package com.epam.emotionalHelpTestAutomation.ui.Pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.epam.emotionalHelpTestAutomation.ui.BasePage;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class HomePage extends BasePage {

    private SelenideElement topStartTestButton = $(By.xpath("(//button[contains(text(),'Start the test')])[1]"));
    private SelenideElement bottomStartTestButton = $(By.xpath("(//button[contains(text(),'Start the test')])[2]"));
    private SelenideElement welcomeLabel = $(By.xpath("//h1[contains(text(),'Get to know yourself.')]"));
    private SelenideElement bottomHowItWorksLabel = $(By.xpath("//h2[contains(text(),'How does it work?')]"));

    public HomePage() {
        openBasePage();
    }

    public QuizzesPage openQuizzesPage() {
        topStartTestButton.shouldBe(Condition.visible).click();
        return new QuizzesPage();
    }

    public boolean topStartTestButtonVisible() {
        return topStartTestButton.isDisplayed();
    }

    public boolean bottomStartTestButtonVisible() {
        return bottomStartTestButton.isDisplayed();
    }

    public String getWelcomeLabelText() {
        return welcomeLabel.text();
    }

    public String getBottomHowItWorksLabel() {
        return bottomHowItWorksLabel.text();
    }
}
