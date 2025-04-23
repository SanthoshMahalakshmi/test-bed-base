package Welcome;

import DriverManagerIos.DriverManager;
import UtilitiesForIos.LogUtil;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class Welcome_Page_iOS extends DriverManager
{
    @Test
    public void TC_001()
    {
        //Global wait.
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        /*To accept the notification pop-up*/
        try
        {
            Alert alert = wait.until(ExpectedConditions.alertIsPresent());
            alert.accept();
            LogUtil.info("The allow notification is accepted here.");
        } catch (Exception e) {
            LogUtil.warning("There is no Allow button to accept the notification.");
            throw new RuntimeException(e.getMessage());
        }

        try {
            //confirm the device image is present in the screen welcome screen.
            WebElement img = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//XCUIElementTypeImage")));
            LogUtil.info("image is displayed in the welcome screen : " + img.isDisplayed() );
        } catch (Exception e) {
            LogUtil.warning("img is not displayed");
        }

        try {
            //Welcome page Description verification.
            WebElement description = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.
                    xpath("//XCUIElementTypeStaticText[@name=\"Keep track of your own and your family’s health and well-being\"]")));
            LogUtil.info("Welcome page description : " + description.getText());
        } catch (Exception e) {
            LogUtil.info("Welcome page description is not displayed");
        }
        WebElement getStarted = null;

        try {
            //Clicking the Get started button
            getStarted = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.
                    xpath("//XCUIElementTypeStaticText[@name=\"Get Started\"]")));
            LogUtil.info("Get started button is present in the welcome page : " + getStarted.isDisplayed());
        } catch (Exception e) {
            LogUtil.warning("Get started button is not displayed");
        }

        wait.until(ExpectedConditions.elementToBeClickable(getStarted)).click();

        try {
            //Verifying the login or signup label present or not.
            WebElement loginOrSignup = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.
                    xpath("//XCUIElementTypeStaticText[@name=\"Login or Sign Up\"]")));
            LogUtil.info("Navigated to login page : "+ loginOrSignup);
        } catch (Exception e) {
            LogUtil.warning("Navigated to login page is not displayed");
        }
    }
}