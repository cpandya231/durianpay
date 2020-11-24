package com.chintan.entity;

import com.amazonaws.services.dynamodbv2.datamodeling.*;

@DynamoDBTable(tableName = "Covid19Data")
public class Covid19DataEntity {

    @DynamoDBHashKey
    private String code;

    @DynamoDBAttribute
    private String name;

    @DynamoDBAttribute
    private Integer active;

    @DynamoDBAttribute
    private Integer deaths;


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

    public Integer getActive() {
        return active;
    }

    public void setActive(Integer active) {
        this.active = active;
    }

    public Integer getDeaths() {
        return deaths;
    }

    public void setDeaths(Integer deaths) {
        this.deaths = deaths;
    }
}
