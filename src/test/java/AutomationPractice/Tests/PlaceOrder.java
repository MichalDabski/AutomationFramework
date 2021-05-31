package AutomationPractice.Tests;

import AutomationPractice.Configuration.WebDriverSetup;
import AutomationPractice.Pages.AuthenticationPage;
import AutomationPractice.Pages.EveningDressesCategoryPage;
import AutomationPractice.Pages.MainPage;
import AutomationPractice.Pages.ShoppingCartPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PlaceOrder extends TestBase {

    @Test(priority = 1, description = "1. Log in with valid credentials")
    public void inputValidCredentials() {
        AuthenticationPage authenticationPage = new AuthenticationPage(WebDriverSetup.driver);
        authenticationPage.clickSignIn();
        authenticationPage.inputValidEmail();
        authenticationPage.inputValidPassword();
        Assert.assertTrue(authenticationPage.userIsLoggedIn());
    }

    @Test(priority = 2, description = "2. Select Evening Dresses category")
    public void goToEveningDresses() {
        EveningDressesCategoryPage eveningDressesCategoryPage = new EveningDressesCategoryPage(WebDriverSetup.driver);
        eveningDressesCategoryPage.selectEveningDressessCategory();
        Assert.assertTrue(eveningDressesCategoryPage.isCategoryPageOpened());
    }

    @Test(priority = 3, description = "3. Add Printed Dress to cart")
    public void addPrintedDressToCart() {
        EveningDressesCategoryPage eveningDressesCategoryPage = new EveningDressesCategoryPage(WebDriverSetup.driver);
        eveningDressesCategoryPage.addPrintedDressToCart();
        Assert.assertTrue(eveningDressesCategoryPage.isProductAddedToCart());
    }

    @Test(priority = 4, description = "4. Proceed to checkout")
    public void proceedToCheckout() {
        EveningDressesCategoryPage eveningDressesCategoryPage = new EveningDressesCategoryPage(WebDriverSetup.driver);
        eveningDressesCategoryPage.proceedToCheckOut();
        ShoppingCartPage shoppingCartPage = new ShoppingCartPage(WebDriverSetup.driver);
        Assert.assertTrue(shoppingCartPage.isShoppingCartPageOpen());
        Assert.assertTrue(shoppingCartPage.printedDressIsAddedToCart());
    }

    @Test(priority = 5, description = "5. Make payment for order")
    public void makePayment() {
        ShoppingCartPage shoppingCartPage = new ShoppingCartPage(WebDriverSetup.driver);
        shoppingCartPage.proceedToCheckout();
        Assert.assertTrue(shoppingCartPage.isAdressessTabOpen());
        shoppingCartPage.assertDeliveryAddress();
        shoppingCartPage.proceedToCheckout();
        Assert.assertTrue(shoppingCartPage.isShippingTabOpen());
        shoppingCartPage.acceptTermsOfService();
        Assert.assertTrue(shoppingCartPage.areTermsOfServiceAccepted());
        shoppingCartPage.proceedToCheckout2();
        Assert.assertTrue(shoppingCartPage.isPaymentTabOpen());
        shoppingCartPage.selectPaymentByWire();
        Assert.assertTrue(shoppingCartPage.isOrderSummaryTabOpen());
        shoppingCartPage.confirmOrder();
        Assert.assertTrue(shoppingCartPage.isOrderSuccessful());

    }
}
