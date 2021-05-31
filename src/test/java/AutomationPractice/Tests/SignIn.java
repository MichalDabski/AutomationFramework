package AutomationPractice.Tests;

import AutomationPractice.Configuration.WebDriverSetup;
import AutomationPractice.Pages.AuthenticationPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SignIn extends TestBase {
    @Test(priority = 1, description = "1. Go to Authentication Page")
    public void goToAuthenticationPage() {
        AuthenticationPage authenticationPage = new AuthenticationPage(WebDriverSetup.driver);
        authenticationPage.clickSignIn();

    }

    @Test(priority = 2, description = "2. Input invalid email address")
    public void inputInvalidEmailAddress() {
        AuthenticationPage authenticationPage = new AuthenticationPage(WebDriverSetup.driver);
        authenticationPage.inputInvalidEmail();
        Assert.assertTrue(authenticationPage.emailIsInvalid());
    }

    @Test(priority = 3, description = "3. Log in with invalid credentials")
    public void inputInvalidCredentials() {
        AuthenticationPage authenticationPage = new AuthenticationPage(WebDriverSetup.driver);
        authenticationPage.inputValidEmail();
        authenticationPage.inputInvalidPassword();
        Assert.assertTrue(authenticationPage.authenticationErrorIsPresent());
    }

    @Test(priority = 4, description = "4. Log in with valid credentials")
    public void inputValidCredentials() {
        AuthenticationPage authenticationPage = new AuthenticationPage(WebDriverSetup.driver);
        authenticationPage.inputValidEmail();
        authenticationPage.inputValidPassword();
        Assert.assertTrue(authenticationPage.userIsLoggedIn());
    }
}
