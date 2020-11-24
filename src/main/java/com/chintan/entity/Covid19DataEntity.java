package com.chintan.entity;

import com.amazonaws.services.dynamodbv2.datamodeling.*;

@DynamoDBTable(tableName = "Covid19Data")
public class Covid19DataEntity {

    @DynamoDBHashKey
    private String code;

    @DynamoDBAttribute
    private String name;

    @DynamoDBAttribute
    private Long active;

    @DynamoDBAttribute
    private Long deaths;


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getActive() {
        return active;
    }

    public void setActive(Long active) {
        this.active = active;
    }

    public Long getDeaths() {
        return deaths;
    }

    public void setDeaths(Long deaths) {
        this.deaths = deaths;
    }
}
