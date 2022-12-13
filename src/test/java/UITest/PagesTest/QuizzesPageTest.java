package UITest.PagesTest;

import com.codeborne.selenide.WebDriverRunner;
import com.epam.emotionalHelpTestAutomation.ui.Pages.HomePage;
import com.epam.emotionalHelpTestAutomation.ui.Pages.QuizzesPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class QuizzesPageTest {

    private QuizzesPage qp = new HomePage().openQuizzesPage();
    private int numberOfQuizzes = 2;

    @Test(priority = 1)
    public void quizzesPageLoaded() {

        Assert.assertTrue(qp.footerLogoVisible(), "Footer Logo is not displayed");
        Assert.assertTrue(qp.quizzesChoiceLabelDisplayed(), "Quizzes choice not displayed");
        this.numberOfQuizzes = qp.numberOfQuizzesAvailable();

        Assert.assertTrue(numberOfQuizzes >= 1, "No quizzes found");
    }

    @Test(priority = 2)
    public void openAllTestPages() {
        for (int i = 0; i < numberOfQuizzes; i++) {
            qp.openTestPage(i+1);
            String currentUrl = WebDriverRunner.getWebDriver().getCurrentUrl();
            Assert.assertTrue(currentUrl.contains("quizz/" + (i+1)), "The test with index quizz/" + (i+1) + " does not exists");
        }
    }
}
