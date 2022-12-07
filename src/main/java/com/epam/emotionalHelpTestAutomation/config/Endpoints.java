package com.epam.emotionalHelpTestAutomation.config;

public enum Endpoints {

    EMOTIONS("emotions/"), QUIZZES("quizzes/"),
    QUESTIONS("questions/"), RESULTS("results/");

    private final String value;

    Endpoints(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
