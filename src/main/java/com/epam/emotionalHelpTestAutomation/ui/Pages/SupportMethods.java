package com.epam.emotionalHelpTestAutomation.ui.Pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class SupportMethods {

    public static SelenideElement getEmotion(String emotion) {
        return $(By.xpath("//h4[contains(text(),\"" + emotion + "\")]"));

    }
}
