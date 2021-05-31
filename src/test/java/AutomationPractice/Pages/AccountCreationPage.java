package AutomationPractice.Pages;

import AutomationPractice.Actions.SiteActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AccountCreationPage extends MainPage {

    @FindBy(xpath = "//h1[@class = 'page-heading'][text()='Create an account']")
    private WebElement createAnAccountPageTitle;

    @FindBy(id = "id_gender1")
    private WebElement radioMr;

    @FindBy(id = "customer_firstname")
    private WebElement txtFirstName;

    @FindBy(id = "customer_lastname")
    private WebElement txtLastName;

    @FindBy(id = "email")
    private WebElement txtEmail;

    @FindBy(id = "passwd")
    private WebElement txtPassword;

    @FindBy(id = "days")
    private WebElement btnDays;

    @FindBy(id = "months")
    private WebElement btnMonths;

    @FindBy(id = "years")
    private WebElement btnYears;

    @FindBy(id = "firstname")
    private WebElement txtAddressFirstName;

    @FindBy(id = "lastname")
    private WebElement txtAddressLastName;

    @FindBy(id = "address1")
    private WebElement txtAddressLine1;

    @FindBy(id = "city")
    private WebElement txtAddressCity;

    @FindBy(id = "id_state")
    private WebElement dropAddressState;

    @FindBy(id = "postcode")
    private WebElement txtAddressPostCode;

    @FindBy(id = "phone_mobile")
    private WebElement txtAddressMobilePhone;

    @FindBy(id = "alias")
    private WebElement txtAddressAlias;

    @FindBy(id = "submitAccount")
    private WebElement btnRegister;

    @FindBy(xpath = "//p[@class = 'info-account'][text()='Welcome to your account. Here you can manage all of your personal information and orders.']")
    private WebElement txtAccountDetails;

    public AccountCreationPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public boolean accountCreationPageIsOpened() {
        waitUtilites.waitForElementVisible(createAnAccountPageTitle);
        return createAnAccountPageTitle.isDisplayed();
    }

    public void fillAccountData() {

        radioMr.click();
        txtFirstName.sendKeys("Wade");
        txtLastName.sendKeys("Wilson");
        String password = SiteActions.generateRandomPassword(10);
        System.out.println("Password used: " + password);
        txtPassword.sendKeys(password);
        new Select(btnDays).selectByValue("22");
        new Select(btnMonths).selectByValue("11");
        new Select(btnYears).selectByValue("1973");
        txtAddressFirstName.sendKeys("Wade");
        txtAddressLastName.sendKeys("Wilson");
        txtAddressLine1.sendKeys("1407 Graymalkin Lane, Salem Center");
        txtAddressCity.sendKeys("Westchester County, New York");
        new Select(dropAddressState).selectByValue("32");
        txtAddressPostCode.sendKeys("10814");
        txtAddressMobilePhone.sendKeys("55511122255");
        txtAddressAlias.clear();
        txtAddressAlias.sendKeys("X-Mansion");
        btnRegister.click();
    }

    public boolean accountDetailsPageIsOpen() {
        waitUtilites.waitForElementVisible(txtAccountDetails);
        return txtAccountDetails.isDisplayed();
    }
}

