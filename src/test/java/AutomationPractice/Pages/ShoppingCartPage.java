package AutomationPractice.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class ShoppingCartPage extends MainPage {

    @FindBy(id = "cart_title")
    private WebElement shoppingCartPageTitle;

    @FindBy(xpath = "//p[@class='product-name']/a[text()='Printed Dress']")
    private WebElement printedDressProduct;

    @FindBy(xpath = "//span[text()='Proceed to checkout']")
    private WebElement btnProceedToCheckout;

    @FindBy(xpath = "//button[@type='submit']/span[text()[normalize-space()='Proceed to checkout']]")
    private WebElement btnProceedToCheckout2;

    @FindBy(xpath = "//h1[@class='page-heading'][text()='Addresses']")
    private WebElement shoppingCartAddressTab;

    @FindBy(xpath = "//ul[@class='address item box']//li[contains(.,'1407 Graymalkin Lane, Salem Center')]")
    private WebElement deliveryAddressLine;

    @FindBy(xpath = "//h1[@class='page-heading'][text()='Shipping']")
    private WebElement shoppingCartShippingTab;

    @FindBy(id = "uniform-cgv")
    private WebElement checkboxTermsOfService;

    @FindBy(xpath = "//p[@class='checkbox']//span[@class='checked']")
    private WebElement termsOfServiceChecked;

    @FindBy(xpath = "//h1[@class='page-heading'][text()='Please choose your payment method']")
    private WebElement shoppingCartPaymentTab;

    @FindBy(xpath = "//a[@class='bankwire']")
    private WebElement btnPayByBankWire;

    @FindBy(xpath = "//h1[@class='page-heading'][text()[normalize-space() ='Order summary']]")
    private WebElement shoppingCartSummaryTab;

    @FindBy(xpath = "//h1[@class='page-heading'][text()='Order confirmation']")
    private WebElement shoppingCartConfirmationTab;

    @FindBy(xpath = "//span[text()='I confirm my order']")
    private WebElement btnConfirmOrder;

    @FindBy(xpath = "//p[@class='cheque-indent']//strong[text()='Your order on My Store is complete.']")
    private WebElement infoOrderSuccess;

    @FindBy(xpath = "//div[@class='shopping_cart']//span[text()='(empty)']")
    private WebElement cartEmpty;

    public ShoppingCartPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public boolean isShoppingCartPageOpen() {
        waitUtilites.waitForElementVisible(shoppingCartPageTitle);
        return shoppingCartPageTitle.isDisplayed();
    }

    public boolean printedDressIsAddedToCart() {
        return printedDressProduct.isDisplayed();
    }

    public void proceedToCheckout() {
        siteActions.scrollPage();
        btnProceedToCheckout.click();
    }

    public void proceedToCheckout2() {
        siteActions.scrollPage();
        btnProceedToCheckout2.click();
    }

    public boolean isAdressessTabOpen() {
        waitUtilites.waitForElementVisible(shoppingCartAddressTab);
        return shoppingCartAddressTab.isDisplayed();
    }

    public void assertDeliveryAddress() {
        String address = deliveryAddressLine.getText();
        Assert.assertEquals(address, "1407 Graymalkin Lane, Salem Center");
    }

    public boolean isShippingTabOpen() {
        waitUtilites.waitForElementVisible(shoppingCartShippingTab);
        return shoppingCartShippingTab.isDisplayed();
    }

    public void acceptTermsOfService() {
        checkboxTermsOfService.click();
    }

    public boolean areTermsOfServiceAccepted() {
        waitUtilites.waitForElementVisible(termsOfServiceChecked);
        return termsOfServiceChecked.isDisplayed();
    }

    public boolean isPaymentTabOpen() {
        waitUtilites.waitForElementVisible(shoppingCartPaymentTab);
        return shoppingCartPaymentTab.isDisplayed();
    }

    public void selectPaymentByWire() {
        btnPayByBankWire.click();
    }

    public boolean isOrderSummaryTabOpen() {
        waitUtilites.waitForElementVisible(shoppingCartSummaryTab);
        return shoppingCartSummaryTab.isDisplayed();
    }

    public void confirmOrder(){
        btnConfirmOrder.click();
    }

    public boolean isOrderSuccessful(){
        waitUtilites.waitForElementVisible(infoOrderSuccess);
        return infoOrderSuccess.isDisplayed();
    }
}

