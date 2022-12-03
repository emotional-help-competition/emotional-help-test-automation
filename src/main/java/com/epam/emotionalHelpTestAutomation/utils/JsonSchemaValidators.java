package com.epam.emotionalHelpTestAutomation.utils;

import com.epam.emotionalHelpTestAutomation.utils.api.ResponseUtils;
import com.github.fge.jsonschema.SchemaVersion;
import com.github.fge.jsonschema.cfg.ValidationConfiguration;
import com.github.fge.jsonschema.main.JsonSchemaFactory;
import io.restassured.module.jsv.JsonSchemaValidator;

import java.io.File;

public final class JsonSchemaValidators {

    private JsonSchemaValidators() {
    }

    public static void validateResponseAgainstJsonSchema(String path) {
        JsonSchemaFactory jsonSchemaFactory = JsonSchemaFactory
                .newBuilder()
                .setValidationConfiguration(ValidationConfiguration.newBuilder()
                        .setDefaultVersion(SchemaVersion.DRAFTV4)
                        .freeze())
                .freeze();
        ResponseUtils.getResponse()
                .assertThat()
                .body(JsonSchemaValidator
                        .matchesJsonSchema(new File(path))
                        .using(jsonSchemaFactory));
    }
}
