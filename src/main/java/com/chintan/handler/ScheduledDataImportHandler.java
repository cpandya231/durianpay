package com.chintan.handler;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.chintan.dto.Covid19Datum;
import com.chintan.entity.Covid19DataEntity;
import org.springframework.http.*;
import org.springframework.util.CollectionUtils;
import org.springframework.web.client.RestTemplate;

import java.util.*;

public class ScheduledDataImportHandler implements RequestHandler<Map<String, String>, String> {

    private static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss.SSS";

    AmazonDynamoDB client;
    DynamoDBMapper dynamoDBMapper;
    RestTemplate restTemplate;
    private final String getCovid19CountryDataUrl = "https://disease.sh/v3/covid-19/countries?yesterday=true";

    private final String getCovid19WorldDataUrl = "https://corona.lmao.ninja/v2/all";

    public ScheduledDataImportHandler() {
        client = AmazonDynamoDBClientBuilder.standard().build();
        dynamoDBMapper = new DynamoDBMapper(client);
        restTemplate = new RestTemplate();
    }


    @Override
    public String handleRequest(Map<String, String> event, Context context) {

        System.out.println("Inside handle request");
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.add("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
        HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);


        ResponseEntity<Covid19Datum[]> covid19DatumResponseEntity =
                restTemplate.exchange(getCovid19CountryDataUrl, HttpMethod.GET, entity, Covid19Datum[].class);
        System.out.println("Countries: Got response code " + covid19DatumResponseEntity.getStatusCodeValue());

        List<Covid19Datum> covid19DatumList = Arrays.asList(Objects.requireNonNull(covid19DatumResponseEntity.getBody()));

        if (!CollectionUtils.isEmpty(covid19DatumList)) {
            List<Covid19DataEntity> entities = new ArrayList<>();
            for (Covid19Datum covid19Datum : covid19DatumList) {
                Covid19DataEntity covid19DataEntity = populateCovid19DataEntityForCountry(covid19Datum);
                entities.add(covid19DataEntity);
            }

            ResponseEntity<Covid19Datum> worldDataResponse = restTemplate.exchange(getCovid19WorldDataUrl, HttpMethod.GET, entity, Covid19Datum.class);
            System.out.println("World: Got response code " + worldDataResponse.getStatusCodeValue());

            Covid19DataEntity worldEntity = populateCovid19DataEntityForWorld(Objects.requireNonNull(worldDataResponse.getBody()));
            entities.add(worldEntity);

            List<DynamoDBMapper.FailedBatch> failedBatch = dynamoDBMapper.batchSave(entities);

            failedBatch.forEach(element -> {
                System.out.println(element.getException());
            });


        }
        return "Data Saved";
    }


    private Covid19DataEntity populateCovid19DataEntityForCountry(Covid19Datum covid19Datum) {
        Covid19DataEntity covid19DataEntity = new Covid19DataEntity();
        covid19DataEntity.setCode(covid19Datum.getCountryInfo().getIso2());
        covid19DataEntity.setName(covid19Datum.getCountry());
        covid19DataEntity.setActive(covid19Datum.getActive());
        covid19DataEntity.setDeaths(covid19Datum.getDeaths());
        return covid19DataEntity;
    }

    private Covid19DataEntity populateCovid19DataEntityForWorld(Covid19Datum covid19Datum) {
        Covid19DataEntity covid19DataEntity = new Covid19DataEntity();
        covid19DataEntity.setCode("TOTAL");
        covid19DataEntity.setName("World");
        covid19DataEntity.setActive(covid19Datum.getActive());
        covid19DataEntity.setDeaths(covid19Datum.getDeaths());
        return covid19DataEntity;
    }
}