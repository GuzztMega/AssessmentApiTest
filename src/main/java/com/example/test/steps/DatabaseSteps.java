package com.example.test.steps;

import com.example.test.ApplicationPage;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClientBuilder;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Pending;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;


public class DatabaseSteps {

    private ApplicationPage page;

    public DatabaseSteps(WebDriver driver) {
        page = new ApplicationPage(driver);
    }

    private String address = "http://localhost:8080/HealthCheck/dataBase";
    private String message = "UP and Running DATA BASE";
    private HttpUriRequest request;

    @Autowired
    RestTemplate restTemplate;

    @Given("I enter the $address database adress")
    public void enterTheAddress() {
        request = new HttpGet(address);
        Assert.assertTrue(page.getTitle().contentEquals(address));
    }

    @When("the database application start")
    public void theApplicationStarts() throws IOException {
        HttpClientBuilder.create().build().execute(request);
    }

    @Then("I should see database $message")
    public void theCorrectMessageShouldAppear() {
        Assert.assertTrue(page.getPageSource().contains(message));
    }
}
