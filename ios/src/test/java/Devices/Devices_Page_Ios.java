package Devices;

import DriverManagerIos.DriverManager;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class Devices_Page_Ios extends DriverManager
{
    @Test
    public void TC_023()
    {
        BaseLoginForIos();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        //Clicking the device section
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("Devices"))).click();
        } catch (Exception e) {
            logger.warning("Clicking device section is not happening.");
        }

        //Verify the burger menu is clickable.
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.moai.android:id/imgMenu"))).click();
        } catch (Exception e) {
            logger.warning("Burger menu is not clickable.");
        }

        //Clicking on the connect device
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.
                    androidUIAutomator("new UiSelector().text(\"Connect Device\")"))).click();
        } catch (Exception e) {
            logger.warning("Clicking on connect device is not happening.");
        }

        //Clicking on continue button to find out the device
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.moai.android:id/txtContinue"))).click();
        } catch (Exception e) {
            logger.warning("Clicking continue is not happening.");
        }

        //permission
        try {
            wait.until(ExpectedConditions.elementToBeClickable
                    (AppiumBy.id("com.android.packageinstaller:id/permission_allow_button"))).click();
        } catch (Exception e) {
            logger.warning("Giving permission is not happening.");
        }

        //Clicking again on continue button to find out the device
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.moai.android:id/txtContinue"))).click();
        } catch (Exception e) {
            logger.warning("Clicking continue again is not happening.");
        }

        //Actual device freq,
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.moai.android:id/txtDeviceName"))).click();
        } catch (Exception e) {
            logger.warning("Actual device frequency is not showing.");
        }

        //Success message of device connection
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.moai.android:id/txtFailDescription")));
            WebElement message = driver.findElement(AppiumBy.id("com.moai.android:id/txtFailDescription"));
            logger.info("Success message : " + message.getText());
        } catch (Exception e) {
            logger.warning("Success message of connected device is not visible.");
        }

        //clicking on device info
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.moai.android:id/txtDeviceInfo"))).click();
        } catch (Exception e) {
            logger.warning("Device info is not visible.");
        }

        //Push profile
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.moai.android:id/txtPushProfile"))).click();
        } catch (Exception e) {
            logger.warning("Push profile is not happening.");
        }

        //Navigate home
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.
                    androidUIAutomator("new UiSelector().description(\"Navigate up\")"))).click();
        } catch (Exception e) {
            logger.warning("Navigating back home is not working.");
        }

        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.moai.android:id/txtEcg"))).isDisplayed();
        } catch (Exception e) {
            logger.warning("Clicking Ecg report is not happening. ");
        }

        WebElement deviceIndication = null;
        try {
            deviceIndication = driver.findElement(AppiumBy.androidUIAutomator
                    ("new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(resourceId(\"com.moai.android:id/imgDeviceIndication\"));"));
            logger.info("Device indication is present : " + deviceIndication.isDisplayed());
        } catch (Exception e) {
            logger.warning("Connected device indication is not visible.");
        }
    }

    @Test
    public void TC_024()
    {
        TC_023(); // to connect with device

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        //Clicking the device section
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("Devices"))).click();
        } catch (Exception e) {
            logger.warning("Device connection is not happening.");
        }

        //Verify the burger menu is clickable.
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.moai.android:id/imgMenu"))).click();
        } catch (Exception e) {
            logger.warning("Clicking Burger menu is not working.");
        }

        //Disconnect the device
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.
                    androidUIAutomator("new UiSelector().text(\"Disconnect Device\")"))).click();
        } catch (Exception e) {
            logger.warning("Disconnecting device is not happening.");
        }

        //Confirmation of disconnect the device
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("android:id/button1"))).click();
        } catch (Exception e) {
            logger.warning("Confirmation of disconnect is not happening.");
        }

        //Verify the devices is disconnected by clicking burger menu.
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("android:id/message")));
            WebElement message = driver.findElement(AppiumBy.id("android:id/message"));
            logger.info("Disconnected message : " + message.getText());
        } catch (Exception e) {
            logger.warning("Device disconnect verification fail.");
        }

        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("android:id/button1"))).click();
        } catch (Exception e) {
            logger.warning("Ok confirmation is not happening.");
        }
    }
}
