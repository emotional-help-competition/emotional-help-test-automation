package com.epam.emotionalHelpTestAutomation.ui.Pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.epam.emotionalHelpTestAutomation.ui.BasePage;
import org.openqa.selenium.By;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class TestPage extends BasePage {


    ElementsCollection questions = $$(By.xpath("//label[@class=\"container__text\"]"));
    ElementsCollection questionsAnswerOptions = $$(By.xpath("//div[@class=\"container__group\"]"));
    SelenideElement welcomeLabel = $(By.xpath("//div[contains(text(),\"Select the answers\")]"));
    SelenideElement footerLogo = $(By.xpath("//div[@class=\"container__logo\"]"));
    SelenideElement lastQuestionLabel = $(By.xpath("(//label[@class=\"container__text\"])[last()]"));
    SelenideElement resultButton = $(By.xpath("//button[contains(text(),\"Result\")]"));

    SelenideElement errorLabel = $(By.xpath("//div[@class=\"container__error\"]"));


    public boolean footerLogoDisplayed() {
        return footerLogo.isDisplayed();
    }

    public String getWelcomeLabelText() {
        return welcomeLabel.getText();
    }

    public int numberOfQuestions() {
        return questions.size();
    }

    public boolean questionsLoaded() {
        return lastQuestionLabel.shouldBe(Condition.visible, Duration.ofMillis(10000)).isDisplayed();
    }

    public boolean resultButtonDisplayed() {
        return resultButton.isDisplayed();
    }

    private boolean checkIfLastQuestionAnswered() {
        return $(By.xpath("(//input[@class=\"container__input ng-dirty ng-valid ng-touched\"])[last()]")).shouldBe(Condition.visible).isDisplayed();
    }

    public boolean fillWithRandomAnswers() {
        Random random = new Random();
        for (int i = 0; i < questionsAnswerOptions.size(); i++) {
            int index = random.nextInt(5) + 1;
            clickAnswerAQuestionWithAgreeLevel(i, index);
        }
        return checkIfLastQuestionAnswered();
    }

    private void clickAnswerAQuestionWithAgreeLevel(int index, int answer) {
        questionsAnswerOptions.get(index).$(By.xpath("(//div[@class=\"container__group\"]/div[" + answer + "])" + "[" + (index + 1) + "]")).click();
    }

    public ResultPage selectAllSurpirseEmotionToAgreeAndShowResult(){
        questionsLoaded();

        for(int i = 0; i < questions.size(); i++){

            ArrayList<String> words = new ArrayList<>(List.of(questions.get(i).getText().split("\\s+")));
            for(String w : words) {
                if (SupportMethods.surpriseEmotion.contains(w)) {
                    clickAnswerAQuestionWithAgreeLevel(i, 5);
                    break;
                } else {
                    clickAnswerAQuestionWithAgreeLevel(i, 1);
                }
            }

        }
        return  openResultPage();
    }

    public ResultPage openResultPage() {
        resultButton.shouldBe(Condition.visible).click();
        return new ResultPage();
    }

    public void clickOnResultButton(){
        resultButton.click();
    }

    public boolean errorLabelDisplayed(){
        return errorLabel.isDisplayed();
    }

}
