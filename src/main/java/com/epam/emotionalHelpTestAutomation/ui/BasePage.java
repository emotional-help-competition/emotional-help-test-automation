package com.epam.emotionalHelpTestAutomation.ui;

import static com.codeborne.selenide.Selenide.open;

public class BasePage {

    public BasePage(){
    }

    public void openBasePage(){

        String start = "http://localhost:4200/";
        open(start);
    }
}
