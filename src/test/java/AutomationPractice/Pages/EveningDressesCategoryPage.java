package AutomationPractice.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EveningDressesCategoryPage extends MainPage{

    @FindBy (xpath = "//span[@class='category-name'][contains(text(),'Evening Dresses')]")
    private WebElement categoryName;

    @FindBy (xpath = "//div[@class='product-image-container']/a[@title='Printed Dress']")
    private WebElement printedDressImg;

    @FindBy (xpath = "//div[@class='button-container']/a/span[text()='Add to cart']")
    private WebElement btnAddToCart;

    @FindBy (xpath = "//div[@class='clearfix']//h2[contains(.,'Product successfully added')]")
    private WebElement infoAddToCartSuccess;

    @FindBy (xpath = "//a[@title='Proceed to checkout']")
    private WebElement btnProceedToCheckout;

    public EveningDressesCategoryPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }


    public boolean isCategoryPageOpened(){
        waitUtilites.waitForElementVisible(categoryName);
        return categoryName.isDisplayed();
    }

    public void addPrintedDressToCart(){
        siteActions.hoverOverElement(printedDressImg);
        btnAddToCart.click();
    }

    public boolean isProductAddedToCart(){
        waitUtilites.waitForElementVisible(infoAddToCartSuccess);
        return infoAddToCartSuccess.isDisplayed();
    }

    public void proceedToCheckOut(){
        btnProceedToCheckout.click();
    }
}
