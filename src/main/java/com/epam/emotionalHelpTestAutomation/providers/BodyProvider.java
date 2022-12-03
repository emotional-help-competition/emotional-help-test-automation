package com.epam.emotionalHelpTestAutomation.providers;

import com.epam.emotionalHelpTestAutomation.utils.api.ResponseUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

public class BodyProvider {
    private final static Logger logger = LoggerFactory.getLogger(ResponseUtils.class);

    public static String getBody(String ftlName, Map<String, Object> params) {
        TemplateManager templateManager = new TemplateManager();
        logger.info("The params are {}", params);
        return templateManager.processTemplate(ftlName, params);
    }
}
