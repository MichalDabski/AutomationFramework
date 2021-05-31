package AutomationPractice.Tests;

import AutomationPractice.Configuration.WebDriverSetup;
import AutomationPractice.Pages.AccountCreationPage;
import AutomationPractice.Pages.AuthenticationPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegisterAccount extends TestBase {

    @Test(priority = 1, description = "1.Go to account registration")
    public void goToAccountRegistration() {
        AuthenticationPage authenticationPage = new AuthenticationPage(WebDriverSetup.driver);
        authenticationPage.clickSignIn();
        Assert.assertTrue(authenticationPage.authenticationPageIsOpened());
        authenticationPage.enterEmailandClickCreate();
        AccountCreationPage accountCreationPage = new AccountCreationPage(WebDriverSetup.driver);
        Assert.assertTrue(accountCreationPage.accountCreationPageIsOpened());
    }

    @Test(priority = 2, description = "2. Fill out account details")
    public void fillOutAccountdata() {
        AccountCreationPage accountCreationPage = new AccountCreationPage(WebDriverSetup.driver);
        accountCreationPage.fillAccountData();
        Assert.assertTrue(accountCreationPage.accountDetailsPageIsOpen());

    }
}
