package com.epam.emotionalHelpTestAutomation.ui.Pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.epam.emotionalHelpTestAutomation.ui.BasePage;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class ResultPage extends BasePage {

    SelenideElement welcomeLabel = $(By.xpath("//div[contains(text(),\"Your test results\")]"));
    SelenideElement footerLogo = $(By.xpath("//div[@class=\"container__logo\"]"));
    SelenideElement emotionsLabel = $(By.xpath("//h3[@class=\"emotions-map__hexagon\"]"));
    SelenideElement copyButton = $(By.xpath("//button[contains(text(),\"Copy\")]"));


    public boolean footerLogoVisible() {
        return footerLogo.shouldBe(Condition.visible).isDisplayed();
    }

    public String getWelcomeLabelText() {
        return welcomeLabel.shouldBe(Condition.visible).getText();
    }

    public boolean emotionsLabelVisible() {
        return emotionsLabel.shouldBe(Condition.visible).isDisplayed();
    }

    public void clickOnCopyButton(){
        copyButton.click();
    }

}
