package AutomationPractice.Configuration;

import io.github.bonigarcia.wdm.config.DriverManagerType;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DefaultWebdriverFactory implements WebDriverFactory {


    private static final String BROWSER_NAME_KEY = "selenium.webdriver";
    private static final String HEADLESS_KEY = "selenium.webdriver.headless";
    private static final String CHROME = "chrome";

    @Override
    public WebDriver getDriver() {
        String driver = System.getProperty(BROWSER_NAME_KEY, CHROME);

        switch (driver) {
            case CHROME:
                return createChrome();
            default:
                throw new IllegalArgumentException("Can't start driver: " + driver);
        }
    }

    private WebDriver createChrome() {
        ChromeDriverManager.getInstance(DriverManagerType.CHROME).setup();
        boolean isHeadless = System.getProperty(HEADLESS_KEY, "false").equals("true");
        ChromeOptions opts = new ChromeOptions();
        if (isHeadless) {
                opts.addArguments("--headless");
                opts.addArguments("window-size=1920x1080");
        }
        return new ChromeDriver(opts);
    }

}
