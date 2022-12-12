package UITest.PagesTest;

import com.epam.emotionalHelpTestAutomation.ui.Pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTest {
    HomePage hp = new HomePage();

    @Test
    public void homePageLoaded() {

        Assert.assertTrue(hp.bottomStartTestButtonVisible(), "Start Test Button is not visible");
        Assert.assertTrue(hp.topStartTestButtonVisible(), "Start Test Button is not visible");
        Assert.assertEquals(hp.getWelcomeLabelText(), "Get to know yourself.", "Welcome label is not equal");
        Assert.assertEquals(hp.getBottomHowItWorksLabel(), "How does it work?", "Bottom label is not equal");

    }

}
