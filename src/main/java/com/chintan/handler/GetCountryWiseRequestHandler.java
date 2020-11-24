package com.chintan.handler;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBQueryExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;
import com.chintan.entity.Covid19DataEntity;

import java.util.*;

public class GetCountryWiseRequestHandler implements RequestHandler<APIGatewayProxyRequestEvent, APIGatewayProxyResponseEvent> {

    AmazonDynamoDB client;
    DynamoDBMapper dynamoDBMapper;

    public GetCountryWiseRequestHandler() {
        client = AmazonDynamoDBClientBuilder.standard().build();
        dynamoDBMapper = new DynamoDBMapper(client);
    }

    public APIGatewayProxyResponseEvent handleRequest(APIGatewayProxyRequestEvent apiGatewayProxyRequestEvent, Context context) {
        APIGatewayProxyResponseEvent apiGatewayProxyResponseEvent = new APIGatewayProxyResponseEvent();
        String covid19DataEntity = getCountryWiseInfo(apiGatewayProxyRequestEvent);
        generateResponse(apiGatewayProxyResponseEvent, covid19DataEntity);
        return apiGatewayProxyResponseEvent;
    }

    private String getCountryWiseInfo(APIGatewayProxyRequestEvent apiGatewayProxyRequestEvent) {

        String searchQuery = apiGatewayProxyRequestEvent.getQueryStringParameters().get("searchQuery");
        String[] queries = searchQuery.split(" ");
        Covid19DataEntity queryResult = getCountryWiseInfoQueryOperation(queries[1]).get();
        String resultString = "";
        if (queries[0].equalsIgnoreCase("Cases")) {
            resultString = String.format("%s Active Cases %s", queryResult.getCode(),queryResult.getActive());
        } else if (queries[0].equalsIgnoreCase("Deaths")) {
            resultString = String.format("%s Deaths %s", queryResult.getCode(),queryResult.getDeaths());
        }

        return resultString;
    }


    private Optional<Covid19DataEntity> getCountryWiseInfoQueryOperation(String countryCode) {

        Map<String, AttributeValue> queryOperationEAV = new HashMap<>();
        String queryConditionExpression = "code = :code";
        queryOperationEAV.put(":code", new AttributeValue().withS(countryCode));
        DynamoDBQueryExpression<Covid19DataEntity> queryExpression = new DynamoDBQueryExpression<>();
        queryExpression.withKeyConditionExpression(queryConditionExpression).withExpressionAttributeValues(queryOperationEAV);
        List<Covid19DataEntity> queryResult = dynamoDBMapper.query(Covid19DataEntity.class, queryExpression);
        return queryResult.stream().findFirst();
    }


    private void generateResponse(APIGatewayProxyResponseEvent apiGatewayProxyResponseEvent, String result) {
        apiGatewayProxyResponseEvent.setHeaders(Collections.singletonMap("timeStamp", String.valueOf(System.currentTimeMillis())));
        apiGatewayProxyResponseEvent.setStatusCode(200);
        apiGatewayProxyResponseEvent.setBody(result);
    }
}