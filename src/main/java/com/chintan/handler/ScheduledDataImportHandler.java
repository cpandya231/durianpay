package com.chintan.handler;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.chintan.dto.Covid19Datum;
import com.chintan.entity.Covid19DataEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

public class ScheduledDataImportHandler implements RequestHandler<Map<String, String>, String> {

    private static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss.SSS";

    AmazonDynamoDB client;
    DynamoDBMapper dynamoDBMapper;
    RestTemplate restTemplate;
    private String getCovid19DataUrl = "https://disease.sh/v3/covid-19/countries?yesterday=true";

    public ScheduledDataImportHandler() {
        client = AmazonDynamoDBClientBuilder.standard().build();
        dynamoDBMapper = new DynamoDBMapper(client);
        restTemplate = new RestTemplate();
    }


    @Override
    public String handleRequest(Map<String, String> event, Context context) {
        ResponseEntity<Covid19Datum> covid19DatumResponseEntity =
                restTemplate.getForEntity(getCovid19DataUrl, Covid19Datum.class);
        Covid19Datum covid19Datum = covid19DatumResponseEntity.getBody();
        Covid19DataEntity covid19DataEntity = new Covid19DataEntity();
        if (covid19Datum != null) {
            covid19DataEntity.setCode(covid19Datum.getCountryInfo().getIso2());
            covid19DataEntity.setName(covid19Datum.getCountry());
            covid19DataEntity.setActive(covid19Datum.getActive());
            covid19DataEntity.setDeaths(covid19Datum.getDeaths());
        }
        dynamoDBMapper.save(covid19DataEntity);
        return "Data Saved";
    }

}