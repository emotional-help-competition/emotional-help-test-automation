package UITest.PagesTest;

import com.epam.emotionalHelpTestAutomation.ui.Pages.HomePage;
import com.epam.emotionalHelpTestAutomation.ui.Pages.ResultPage;
import org.testng.Assert;
import org.testng.annotations.Test;


public class ResultPageTest {


    @Test
    public void resultPageLoaded() {
        ResultPage rp = new HomePage().openQuizzesPage().openTestPage(2).openFilledResultPage();
        Assert.assertEquals(rp.getWelcomeLabelText(), "Your test results");
        Assert.assertTrue(rp.footerLogoVisible(), "Footer Logo is not displayed");
        Assert.assertTrue(rp.emotionsLabelVisible(), "Emotion Label is not visible");
    }
}
