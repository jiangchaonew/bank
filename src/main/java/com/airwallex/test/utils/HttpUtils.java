package com.airwallex.test.utils;

import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;
import kong.unirest.UnirestException;
import lombok.extern.slf4j.Slf4j;

/**
 * @author CHAOJ
 */

@Slf4j
public class HttpUtils {

    public static HttpResponse<JsonNode> postJson(String url, String req) {
        log.info("===> http request body: {}", req);
        HttpResponse<JsonNode> response = null;
        try {
            response = Unirest.post(url)
                    .header("content-type", "application/json")
                    .header("accept", "application/json")
                    .body(req)
                    .asJson();
            log.info("===> http response body: {}", response.getBody());
        } catch (UnirestException e) {
            e.printStackTrace();
        } catch (NullPointerException e) {
            e.printStackTrace();
            log.error("===> http response body is null");
        }
        return response;
    }
    
    public static HttpResponse<JsonNode> postForm(String url, String req) {
        log.info("===> http request body: {}", req);
        HttpResponse<JsonNode> response = null;
        try {
            response = Unirest.post(url)
                    .header("content-type", "application/x-www-form-urlencoded")
                    .body(req)
                    .asJson();
            log.info("===> http response body: {}", response.getBody());
        } catch (UnirestException e) {
            e.printStackTrace();
        } catch (NullPointerException e) {
            e.printStackTrace();
            log.error("===> http response body is null");
        }
        return response;
    }
}

