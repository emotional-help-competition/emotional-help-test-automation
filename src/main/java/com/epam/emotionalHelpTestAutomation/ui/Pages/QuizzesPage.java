package com.epam.emotionalHelpTestAutomation.ui.Pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.epam.emotionalHelpTestAutomation.ui.BasePage;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.*;

public class QuizzesPage extends BasePage {

    SelenideElement footerLogo = $(By.xpath("//div[@class=\"container__logo\"]"));
    SelenideElement quizzesChoice = $(By.xpath("(//p[@class=\"container__text container__text--title\"])[last()]")).should(Condition.visible);
    ElementsCollection numberOfQuizzes = $$(By.xpath("//p[@class=\"container__text container__text--title\"]"));


    public QuizzesPage() {

    }

    public boolean footerLogoVisible() {
        return footerLogo.isDisplayed();
    }

    public int numberOfQuizzesAvailable() {
        return numberOfQuizzes.size();
    }

    public TestPage openTestPage(int index) {
        open("http://localhost:4200/quizz/" + index);
        return new TestPage();
    }

    public boolean quizzesChoiceLabelDisplayed() {
        return quizzesChoice.isDisplayed();
    }


}
