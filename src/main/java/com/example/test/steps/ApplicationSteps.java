package com.example.test.steps;

import com.example.test.ApplicationPage;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClientBuilder;
import org.jbehave.core.annotations.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;


public class ApplicationSteps {

    private ApplicationPage page;

    public ApplicationSteps(WebDriver driver) {
        page = new ApplicationPage(driver);
    }

    private String address = "http://localhost:8080/HealthCheck";

    @Autowired
    RestTemplate restTemplate;

    @Given("I enter the $address address")
    public void enterTheAddress() {

        Assert.assertTrue(page.getTitle().contentEquals(address));
    }

    @When("the application start")
    public void theApplicationStarts() throws IOException {
        HttpUriRequest request = new HttpGet(address);
        HttpClientBuilder.create().build().execute(request);
    }

    @Then("I should see $message")
    public void theCorrectMessageShouldAppear() {
        String message = "UP and Running";
        Assert.assertTrue(page.getPageSource().contains(message));
    }
}
