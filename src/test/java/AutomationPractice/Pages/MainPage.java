package AutomationPractice.Pages;

import AutomationPractice.Tests.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class MainPage extends TestBase {

    @FindBy(xpath = "//a[@class='login']")
    protected WebElement btnSignIn;

    @FindBy(id = "email")
    protected WebElement txtEmailAddress;

    @FindBy(xpath = "//div[@class='header_user_info']//span[text()='Wade Wilson']")
    protected WebElement btnCustomerAccount;

    @FindBy(xpath = "//div[@id='block_top_menu']//a[text()='Women']")
    protected WebElement categoryWomen;

    @FindBy(xpath = "(//div[@id='block_top_menu']//a[text()='Evening Dresses'])[1]")
    protected WebElement subcategoryEveningDressess;


    public MainPage(WebDriver driver) {
        super();
        PageFactory.initElements(driver, this);
    }

    public void clickSignIn() {
        btnSignIn.click();
    }

    public void selectEveningDressessCategory(){
        siteActions.hoverOverElement(categoryWomen);
        subcategoryEveningDressess.click();

    }

}

