package UITest.PagesTest;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import com.epam.emotionalHelpTestAutomation.ui.Pages.HomePage;
import com.epam.emotionalHelpTestAutomation.ui.Pages.ResultPage;
import org.testng.Assert;
import org.testng.annotations.Test;


public class ResultPageTest {


    ResultPage rp = new HomePage().openQuizzesPage().openTestPage(1).openFilledResultPage();
    @Test
    public void resultPageLoaded() {

        Assert.assertEquals(rp.getWelcomeLabelText(), "Your test results");
        Assert.assertTrue(rp.footerLogoVisible(), "Footer Logo is not displayed");
        Assert.assertTrue(rp.emotionsLabelVisible(), "Emotion Label is not visible");
    }

    @Test
    public void copyResultTest(){
        rp.clickOnCopyButton();
        String clipboard = Selenide.clipboard().getText();
        String expectedURL = WebDriverRunner.getWebDriver().getCurrentUrl();

        Assert.assertEquals(clipboard,expectedURL,"The copied URL is not from the actual test result");
    }
}
