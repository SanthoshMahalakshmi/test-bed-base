package Welcome;

import DriverManagerIos.DriverManager;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class Welcome_Page_iOS extends DriverManager
{

    @Test
    public void ios_TC_001()
    {
        //Global wait.
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        //ios
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("Allow"))).click();

        try {
            //confirm the device image is present in the screen welcome screen.
            WebElement img = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//XCUIElementTypeImage")));
            logger.info("image is displayed in the welcome screen : " + img.isDisplayed() );
        } catch (Exception e) {
            logger.warning("img is not displayed");
        }

        try {
            //Welcome page Description verification.
            WebElement description = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.
                    xpath("//XCUIElementTypeStaticText[@name=\"Keep track of your own and your family’s health and well-being\"]")));
            logger.info("Welcome page description : " + description.getText());
        } catch (Exception e) {
            logger.info("Welcome page description is not displayed");
        }
        WebElement getStarted = null;

        try {
            //Clicking the Get started button
            getStarted = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.
                    xpath("//XCUIElementTypeStaticText[@name=\"Get Started\"]")));
            logger.info("Get started button is present in the welcome page : " + getStarted.isDisplayed());
        } catch (Exception e) {
            logger.warning("Get started button is not displayed");
        }

        wait.until(ExpectedConditions.elementToBeClickable(getStarted)).click();

        try {
            //Verifying the login or signup label present or not.
            WebElement loginOrSignup = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.
                    xpath("//XCUIElementTypeStaticText[@name=\"Login or Sign Up\"]")));
            logger.info("Navigated to login page : "+ loginOrSignup);
        } catch (Exception e) {
            logger.warning("Navigated to login page is not displayed");
        }
    }
}