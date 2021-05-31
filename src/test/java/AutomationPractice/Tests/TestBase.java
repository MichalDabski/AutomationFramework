package AutomationPractice.Tests;

import AutomationPractice.Actions.SiteActions;
import AutomationPractice.Configuration.WebDriverSetup;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import AutomationPractice.Utilities.WaitUtilities;

public class TestBase {

    protected static WebDriverSetup webDriverSetup = new WebDriverSetup();

    protected WaitUtilities waitUtilites;
    protected SiteActions siteActions;

    public TestBase() {
        waitUtilites = new WaitUtilities();
        siteActions = new SiteActions();
    }

    @BeforeClass()
    public static void beforeAll() {
        webDriverSetup.openBrowser();
    }

  //  @AfterClass
   // static void cleanUp() {
 //       webDriverSetup.closeBrowser();
   // }

}
