package AutomationPractice.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.Random;

public class AuthenticationPage extends MainPage {


    @FindBy(id = "email")
    private WebElement emailAddressBox;

    @FindBy(xpath = "//label[@for='email']")
    private WebElement emailAddressLabel;

    @FindBy(id = "email_create")
    private WebElement emailAddressCreationBox;

    @FindBy(id = "SubmitCreate")
    private WebElement createAccountButton;

    @FindBy(id = "passwd")
    private WebElement passwordBox;

    @FindBy(id = "SubmitLogin")
    private WebElement btnSignInAccount;

    @FindBy(id = "authentication")
    private WebElement authentication;

    @FindBy(xpath = "//div[@class='alert alert-danger']/p[text()='There is 1 error']")
    private WebElement alertAuthentication;


    public AuthenticationPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public boolean authenticationPageIsOpened() {
        return authentication.isDisplayed();
    }

    public void enterEmailandClickCreate() {
        Random randomGenerator = new Random();
        int randomInt = randomGenerator.nextInt(1000);
        String email = "deadpool" + randomInt + "@gmail.com";
        System.out.println("Email address used is " + email);
        emailAddressCreationBox.sendKeys(email);
        createAccountButton.click();
    }

    public void inputInvalidEmail() {
        txtEmailAddress.sendKeys("xxx_mail.com");
        emailAddressLabel.click();
    }

    public boolean emailIsInvalid() {
        return txtEmailAddress.getCssValue("color").equals("rgba(241, 51, 64, 1)");
    }

    public void inputValidEmail() {
        waitUtilites.waitForElementVisible(txtEmailAddress);
        txtEmailAddress.clear();
        txtEmailAddress.sendKeys("deadpool@xmen.com");
        emailAddressLabel.click();
        Assert.assertEquals(txtEmailAddress.getCssValue("color"), "rgba(53, 179, 63, 1)");
    }

    public void inputInvalidPassword() {
        passwordBox.clear();
        passwordBox.sendKeys("1234567985");
        btnSignInAccount.click();
    }

    public void inputValidPassword() {
        passwordBox.clear();
        passwordBox.sendKeys("deadpool1973");
        btnSignInAccount.click();
    }

    public boolean authenticationErrorIsPresent() {
        waitUtilites.waitForElementVisible(alertAuthentication);
        return alertAuthentication.isDisplayed();
    }

    public boolean userIsLoggedIn() {
        waitUtilites.waitForElementVisible(btnCustomerAccount);
        return btnCustomerAccount.isDisplayed();
    }

}
