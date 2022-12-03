package com.epam.emotionalHelpTestAutomation.utils;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import lombok.experimental.UtilityClass;
import org.hamcrest.Matchers;

import java.util.concurrent.TimeUnit;

@UtilityClass
public class Specifications {

    public RequestSpecification getRequestSpecification() {
        RequestSpecBuilder specBuilder = new RequestSpecBuilder();
        return specBuilder
                .setContentType(ContentType.JSON)
                .setAccept(ContentType.JSON)
                .build();
    }

    public ResponseSpecification getResponseSpecification() {
        ResponseSpecBuilder specBuilder = new ResponseSpecBuilder();
        return specBuilder
                .expectResponseTime(Matchers.lessThan(10L), TimeUnit.SECONDS)
                .expectContentType(ContentType.JSON)
                .build();
    }
}
