package com.chintan;

import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.chintan.handler.ScheduledDataImportHandler;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;


public class ScheduledDataImportHandlerTest {
    private com.chintan.handler.ScheduledDataImportHandler handler;

    @Test
    public void handleTest() {
        this.handler = new com.chintan.handler.ScheduledDataImportHandler();

        APIGatewayProxyRequestEvent request = new APIGatewayProxyRequestEvent();
        Map<String, String> queryParam = new HashMap<>();
        queryParam.put("searchQuery", "CASES IN");
        request.setQueryStringParameters(queryParam);
        Object output = this.handler.handleRequest(new HashMap<>(), null);


    }
}
