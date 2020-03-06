package com.example.test;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;


import java.net.MalformedURLException;
import java.net.URL;

@SpringBootApplication
public class AssessmentApiTestApplication{

    @Autowired
    private RestTemplate restTemplate;

    @Value(value="url")
    private String url;


    public void run() throws MalformedURLException {
        ResponseEntity<String> response = restTemplate
                .getForEntity(new URL("http://localhost:" + url + "/healthCheck").toString(), String.class);

        Assert.assertTrue(response.getStatusCode().equals(HttpStatus.OK));

        ResponseEntity<String> responseDb = restTemplate
                .getForEntity(new URL("http://localhost:" + url + "/healthCheck/dataBase").toString(), String.class);
        Assert.assertTrue(responseDb.getStatusCode().equals(HttpStatus.OK));
    }

    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

}
