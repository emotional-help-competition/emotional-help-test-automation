package UITest.PagesTest;

import com.epam.emotionalHelpTestAutomation.ui.Pages.HomePage;
import com.epam.emotionalHelpTestAutomation.ui.Pages.ResultPage;
import com.epam.emotionalHelpTestAutomation.ui.Pages.TestPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestPageTest {

    TestPage tp = new HomePage().openQuizzesPage().openTestPage(2);

    @Test (priority = 1)
    public void testPageLoaded() {
        Assert.assertTrue(tp.footerLogoDisplayed(), "Footer Logo is not displayed");
        Assert.assertEquals(tp.getWelcomeLabelText(), "Select the answers based on how well each statement describes you.", "Welcome lable is not equal");
        Assert.assertTrue(tp.questionsLoaded(), "Questions are not loaded");
        Assert.assertTrue(tp.numberOfQuestions() >= 1, "We have no question");
        Assert.assertTrue(tp.resultButtonDisplayed(), "Result Button is not displayed");
    }

    @Test (priority = 3)
    public void fillAllQuestions(){
        if(tp.questionsLoaded()){
            tp.fillWithRandomAnswers();
        }
    }

    @Test ( priority = 4)
    public void setSurpriesEmtotionToAgree(){
        ResultPage re = tp.selectAllSurpirseEmotionToAgreeAndShowResult();
        Assert.assertTrue(re.emotionsLabelVisible(),"Emotions Label is not visible");
    }

    @Test(priority = 2)
    public void sendTestWithoutChoice(){
        tp.clickOnResultButton();
        Assert.assertTrue(tp.errorLabelDisplayed(),"Error Label is not displayed!");
    }

}
