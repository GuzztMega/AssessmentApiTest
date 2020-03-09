package com.example.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ApplicationPage {
    private String DEFAULT_LOCAL_URL = "http://localhost:8080/HealthCheck";
    private WebDriver driver;
    private WebElement element;

    public String getTitle(){
        return driver.getTitle();
    }
    public ApplicationPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getPageSource(){
        return driver.getPageSource();
    }

    public void openHealthCheck() {
        driver.get(DEFAULT_LOCAL_URL);
    }
}
