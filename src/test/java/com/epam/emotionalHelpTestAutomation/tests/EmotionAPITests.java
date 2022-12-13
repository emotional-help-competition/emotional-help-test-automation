package com.epam.emotionalHelpTestAutomation.tests;

import com.epam.emotionalHelpTestAutomation.config.Endpoints;
import com.epam.emotionalHelpTestAutomation.core.BaseTest;
import com.epam.emotionalHelpTestAutomation.pojo.Emotion;
import com.epam.emotionalHelpTestAutomation.utils.api.RequestUtils;
import com.epam.emotionalHelpTestAutomation.utils.api.ResponseUtils;
import org.apache.http.HttpStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import java.util.LinkedHashMap;
import java.util.Map;

import static com.epam.emotionalHelpTestAutomation.utils.JsonSchemaValidators.validateResponseAgainstJsonSchema;
import static org.assertj.core.api.Assertions.assertThat;

public class EmotionAPITests extends BaseTest {

    private final String EMOTION_SCHEMA_PATH = "emotion";
    private final Logger LOGGER = LoggerFactory.getLogger(EmotionAPITests.class);

    @Test
    public void getAllEmotions() {
        RequestUtils.get(Endpoints.EMOTIONS.getValue());
        validateResponseAgainstJsonSchema(EMOTION_SCHEMA_PATH + "getAllEmotionsSchema.json");
        int responseStatusCode = ResponseUtils.getResponse().extract().statusCode();
        LOGGER.info("The response status code is {}", responseStatusCode);
        LOGGER.info("The response body is \n{}", ResponseUtils.getResponse().extract().body().asPrettyString());
        assertThat(responseStatusCode)
                .withFailMessage("The status code is wrong")
                .isEqualTo(HttpStatus.SC_OK);
        assertThat(ResponseUtils.getListFromResponse("content.", Emotion.class).size())
                .withFailMessage("The list is empty")
                .isGreaterThan(0);
    }

    @Test
    public void getEmotionById() {
        String descriptionForEmotion = "This emotion for test";
        Map<String, Object> postRequestBody = new LinkedHashMap<>();
        postRequestBody.put("description", descriptionForEmotion);
        RequestUtils.post(Endpoints.EMOTIONS.getValue(), postRequestBody);
        int responseStatusCode = ResponseUtils.getResponse().extract().statusCode();
        assertThat(responseStatusCode)
                .withFailMessage("The status code of post request is wrong")
                .isEqualTo(HttpStatus.SC_CREATED);
        Emotion objectFromPostResponse = ResponseUtils.getObjectFromResponse("", Emotion.class);
        Long emotionId = objectFromPostResponse.getId();

        RequestUtils.get(Endpoints.EMOTIONS.getValue() + emotionId);
        validateResponseAgainstJsonSchema(EMOTION_SCHEMA_PATH + "getEmotionSchema");
        responseStatusCode = ResponseUtils.getResponse().extract().statusCode();
        LOGGER.info("The response status code is {}", responseStatusCode);
        LOGGER.info("The response body is \n{}", ResponseUtils.getResponse().extract().body().asPrettyString());
        assertThat(responseStatusCode)
                .withFailMessage("The status code is wrong")
                .isEqualTo(HttpStatus.SC_OK);
        assertThat(ResponseUtils.getObjectFromResponse("", Emotion.class))
                .withFailMessage("The objects are different")
                .isEqualTo(objectFromPostResponse);
    }
}
