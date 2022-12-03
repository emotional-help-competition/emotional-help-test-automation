package com.epam.emotionalHelpTestAutomation.core;

import com.epam.emotionalHelpTestAutomation.config.URIConfig;
import io.restassured.RestAssured;
import org.testng.annotations.BeforeSuite;

public class BaseTest {

    @BeforeSuite
    public void setup() {
        RestAssured.baseURI = URIConfig.BASE_URI;
        RestAssured.basePath = URIConfig.BASE_PATH;
    }
}
