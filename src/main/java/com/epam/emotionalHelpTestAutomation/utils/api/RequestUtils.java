package com.epam.emotionalHelpTestAutomation.utils.api;

import com.epam.emotionalHelpTestAutomation.utils.Specifications;
import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import lombok.experimental.UtilityClass;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

@UtilityClass
public class RequestUtils {

    private final Logger log = LoggerFactory.getLogger(ResponseUtils.class);
    public ValidatableResponse response;

    public ValidatableResponse getResponse() {
        return response;
    }

    public void get(String endpoint) {
        log.info("Get request is in progress...");
        response = RestAssured
                .given()
                .spec(Specifications.getRequestSpecification())
                .when()
                .get(endpoint)
                .then();
    }

    public void get(String endpoint, Map<String, Object> queryParams) {
        log.info("Get request with query params is in progress...");
        response = RestAssured
                .given()
                .spec(Specifications.getRequestSpecification())
                .queryParams(queryParams)
                .when()
                .get(endpoint)
                .then();
    }

    public void post(String endpoint, Object body) {
        log.info("Post request with body is in progress...");
        response = RestAssured
                .given()
                .spec(Specifications.getRequestSpecification())
                .body(body)
                .when()
                .post(endpoint)
                .then();
    }

    public void patch(String endpoint, Object body) {
        log.info("Patch request with body is in progress...");
        response = RestAssured
                .given()
                .spec(Specifications.getRequestSpecification())
                .body(body)
                .when()
                .patch(endpoint)
                .then();
    }

    public void delete(String endpoint) {
        log.info("Delete request is in progress...");
        response = RestAssured
                .given()
                .spec(Specifications.getRequestSpecification())
                .when()
                .delete(endpoint)
                .then();
    }
}
