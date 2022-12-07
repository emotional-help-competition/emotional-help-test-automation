package com.epam.emotionalHelpTestAutomation.utils.api;

import com.epam.emotionalHelpTestAutomation.utils.Specifications;
import io.restassured.response.ValidatableResponse;
import lombok.experimental.UtilityClass;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@UtilityClass
public class ResponseUtils {

    private final Logger LOG = LoggerFactory.getLogger(ResponseUtils.class);

    public ValidatableResponse getResponse() {
        return RequestUtils.getResponse().spec(Specifications.getResponseSpecification());
    }

    public <T> T getObjectFromResponse(String jsonPath, Class<T> type) {
        return getResponse()
                .spec(Specifications.getResponseSpecification())
                .extract()
                .jsonPath()
                .getObject(jsonPath, type);
    }

    public <T> List<T> getListFromResponse(String jsonPath, Class<T> type) {
        return getResponse()
                .spec(Specifications.getResponseSpecification())
                .extract()
                .jsonPath()
                .getList(jsonPath, type);
    }
}
