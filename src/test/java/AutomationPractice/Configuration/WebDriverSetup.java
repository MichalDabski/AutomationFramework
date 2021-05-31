package AutomationPractice.Configuration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class WebDriverSetup {

    public static WebDriver driver;
    public WebDriverSetup() {
        PageFactory.initElements(driver, this);
    }

    /**
     * Opens browser, maximize it and go to app url.
     */
    public void openBrowser() {
        WebDriverFactory factory = new DefaultWebdriverFactory();
        driver = factory.getDriver();
        driver.manage().window().maximize();
        driver.get("http://automationpractice.com/");
    }

    /**
     * Quit browser.
     */
    public void closeBrowser() {
        driver.quit();
    }

}
