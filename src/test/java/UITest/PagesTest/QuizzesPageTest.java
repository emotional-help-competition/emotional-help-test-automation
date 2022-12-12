package UITest.PagesTest;

import com.codeborne.selenide.WebDriverRunner;
import com.epam.emotionalHelpTestAutomation.ui.Pages.HomePage;
import com.epam.emotionalHelpTestAutomation.ui.Pages.QuizzesPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class QuizzesPageTest {

    private QuizzesPage qp = new HomePage().openQuizzesPage();
    private int numberOfQuizzes = 3;

    @Test
    public void quizzesPageLoaded() {

        Assert.assertTrue(qp.footerLogoVisible(), "Footer Logo is not displayed");
        Assert.assertTrue(qp.quizzesChoiceLabelDisplayed(), "Quizzes choice not displayed");
        this.numberOfQuizzes = qp.numberOfQuizzesAvailable();
        System.out.println("Helloo:" + numberOfQuizzes);

        Assert.assertTrue(numberOfQuizzes >= 1, "No quizzes found");
    }

    @Test
    public void openAllTests() {
        for (int i = 1; i <= numberOfQuizzes; i++) {
            qp.openTestPage(i);
            String currentUrl = WebDriverRunner.getWebDriver().getCurrentUrl();
            Assert.assertTrue(currentUrl.contains("quizz/" + i), "The test with index quizz/" + i + " does not exists");
        }
    }
}
