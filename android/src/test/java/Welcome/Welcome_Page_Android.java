package Welcome;

import DriverManagerAndroid.DriverManager;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;


public class Welcome_Page_Android extends DriverManager {

    @Test
    public void TC_001() {
        /*Global wait*/
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        /*confirm the image is present in the screen*/
        WebElement img = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.moai.android:id/images")));
        logger.info("image is displayed in the welcome screen :" + img.isDisplayed());

        /*Description verification*/
        WebElement description = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.moai.android:id/txtDescription")));
        logger.info("Welcome screen description : " + description.getText());

        /*Clicking the Get started button*/
        WebElement getStarted = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.moai.android:id/txtGetStart")));
        getStarted.click();

        /*Verifying the login or signup label present or not.*/
        WebElement loginOrSignup = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.moai.android:id/txtPhoneLabel")));
        logger.info("Navigated to login page : " + loginOrSignup.isDisplayed());

    }

}
