package UITest.PagesTest;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import com.epam.emotionalHelpTestAutomation.ui.Pages.HomePage;
import com.epam.emotionalHelpTestAutomation.ui.Pages.ResultPage;
import com.epam.emotionalHelpTestAutomation.ui.Pages.SupportMethods;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ResultPageTest {

    ResultPage rp = new HomePage().openQuizzesPage().openTestPage(2).selectAllSurpirseEmotionToAgreeAndShowResult();
    @Test(priority = 1)
    public void resultPageLoaded() {

        Assert.assertEquals(rp.getWelcomeLabelText(), "Your test results");
        Assert.assertTrue(rp.footerLogoVisible(), "Footer Logo is not displayed");
        Assert.assertTrue(rp.emotionsLabelVisible(), "Emotion Label is not visible");
    }

    @Test(priority = 2)
    public void copyResultTest(){
        rp.clickOnCopyButton();
        String clipboard = Selenide.clipboard().getText();
        String expectedURL = WebDriverRunner.getWebDriver().getCurrentUrl();

        Assert.assertEquals(clipboard,expectedURL,"The copied URL is not from the actual test result");
    }

    @Test(priority = 3)
    public void checkIfContainsAllSurpriseEmotion(){
        int count = 0;
        for(String em : SupportMethods.surpriseEmotion){
            if(rp.findEmotionByName(em)){
                count++;
            }
        }
        Assert.assertTrue(count >= 4);

    }
}
