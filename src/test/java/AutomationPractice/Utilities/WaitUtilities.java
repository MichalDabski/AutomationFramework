package AutomationPractice.Utilities;

import AutomationPractice.Configuration.WebDriverSetup;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;

public class WaitUtilities {

    public void waitForElementVisible(WebElement element) {
        WebDriverWait wait = new WebDriverWait(WebDriverSetup.driver, 60);
        wait.pollingEvery(100, TimeUnit.MILLISECONDS);
        wait.until(ExpectedConditions.visibilityOf(element));
    }


}
