package com.airwallex.test.utils;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import lombok.extern.slf4j.Slf4j;

/**
 * @author CHAOJ
 */

@Slf4j
public class HttpUtils {

    public static HttpResponse<String> postJson(String url, String req) {
        log.info("===> http request: {}", req);
        HttpResponse<String> response = null;
        try {
            response = Unirest.post(url)
                    .header("content-type", "application/json")
                    .header("accept", "application/json")
                    .body(req)
                    .asString();
        } catch (UnirestException e) {
            e.printStackTrace();
        }
        log.info("===> http response: {}", response.getBody());
        return response;
    }
    
    public static HttpResponse<String> postForm(String url, String req) {
        log.info("===> http request: {}", req);
        HttpResponse<String> response = null;
        try {
            response = Unirest.post(url)
                    .header("content-type", "application/x-www-form-urlencoded")
                    .body(req)
                    .asString();
        } catch (UnirestException e) {
            e.printStackTrace();
        }
        log.info("===> http response: {}", response.getBody());
        return response;
    }
}

