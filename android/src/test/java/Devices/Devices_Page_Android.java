package Devices;

import DriverManagerAndroid.BaseLoginForAndroid;
import DriverManagerAndroid.DriverManager;
import UtilitiesForAndroid.LogUtil;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class Devices_Page_Android extends DriverManager
{
    BaseLoginForAndroid bs = new BaseLoginForAndroid();
    
    @Test
    public void TC_023() throws Exception {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

         bs.CoreLoginForAndroid(false);  //basic login scenario

        WebElement DeviceBtn, BurgerMenuBtn, ConnectDeviceBtn, ContinueBtn,
        Permission;

        //Clicking the device section
        try {
            DeviceBtn =  wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("Devices")));
            DeviceBtn.click();
            LogUtil.info("The Device button is clicked to move to that page.");
        } catch (Exception e) {
            LogUtil.warning("Clicking device section is not happening.");
            throw new Exception(e.getMessage());
        }

        //Verify the burger menu is clickable.
        try {
            BurgerMenuBtn = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.heartmonitor.android:id/imgMenu")));
            BurgerMenuBtn.click();
            LogUtil.info("Burger Menu button is clicked.");
        } catch (Exception e) {
            LogUtil.warning("Burger menu button is not clickable.");
        }

        //Clicking on the connect device
        try {
            ConnectDeviceBtn = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.
                    androidUIAutomator("new UiSelector().text(\"Connect Device\")")));
            ConnectDeviceBtn.click();
            LogUtil.info("Clicking the connect Device Button.");
        } catch (Exception e) {
            LogUtil.warning("Clicking on connect device is not happening.");
        }

        //Clicking on continue button to find out the device
        try {
            ContinueBtn = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.heartmonitor.android:id/txtContinue")));
            ContinueBtn.click();
            LogUtil.info("Clicking the the continue button.");
        } catch (Exception e) {
            LogUtil.warning("Clicking continue is not happening.");
        }

        //permission
        try {
            Permission = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.android.packageinstaller:id/permission_allow_button")));
            Permission.click();
            LogUtil.info("Permission for bluetooth search.");
        } catch (Exception e) {
            LogUtil.warning("Permission for bluetooth search is not happening.");
        }

        //Clicking again on continue button to find out the device
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.heartmonitor.android:id/txtContinue"))).click();
        } catch (Exception e) {
            LogUtil.warning("Clicking continue again is not happening.");
        }

        //Actual device freq,
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.heartmonitor.android:id/txtDeviceName"))).click();
        } catch (Exception e) {
            LogUtil.warning("Actual device frequency is not showing.");
        }

        //Success message of device connection
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.heartmonitor.android:id/txtFailDescription")));
            WebElement message = driver.findElement(AppiumBy.id("com.heartmonitor.android:id/txtFailDescription"));
            LogUtil.info("Success message : " + message.getText());
        } catch (Exception e) {
            LogUtil.warning("Success message of connected device is not visible.");
        }

        //clicking on device info
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.heartmonitor.android:id/txtDeviceInfo"))).click();
        } catch (Exception e) {
            LogUtil.warning("Device info is not visible.");
        }

        //Push profile
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.heartmonitor.android:id/txtPushProfile"))).click();
        } catch (Exception e) {
            LogUtil.warning("Push profile is not happening.");
        }

        //Navigate home
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.
                    androidUIAutomator("new UiSelector().description(\"Navigate up\")"))).click();
        } catch (Exception e) {
            LogUtil.warning("Navigating back home is not working.");
        }

        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.heartmonitor.android:id/txtEcg"))).isDisplayed();
        } catch (Exception e) {
            LogUtil.warning("Clicking Ecg report is not happening. ");
        }

        WebElement deviceIndication = null;
        try {
            deviceIndication = driver.findElement(AppiumBy.androidUIAutomator
                    ("new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(resourceId(\"com.heartmonitor.android:id/imgDeviceIndication\"));"));
            LogUtil.info("Device indication is present : " + deviceIndication.isDisplayed());
        } catch (Exception e) {
            LogUtil.warning("Connected device indication is not visible.");
        }
    }

    @Test
    public void TC_024() throws Exception {

        LogUtil.info("Enter into TC_024");

        TC_023(); // to connect with device

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        //Clicking the device section
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("Devices"))).click();
        } catch (Exception e) {
            LogUtil.warning("Device connection is not happening.");
        }

        //Verify the burger menu is clickable.
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.heartmonitor.android:id/imgMenu"))).click();
        } catch (Exception e) {
            LogUtil.warning("Clicking Burger menu is not working.");
        }

        //Disconnect the device
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.
                    androidUIAutomator("new UiSelector().text(\"Disconnect Device\")"))).click();
        } catch (Exception e) {
            LogUtil.warning("Disconnecting device is not happening.");
        }

        //Confirmation of disconnect the device
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("android:id/button1"))).click();
        } catch (Exception e) {
            LogUtil.warning("Confirmation of disconnect is not happening.");
        }

        //Verify the devices is disconnected by clicking burger menu.
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("android:id/message")));
            WebElement message = driver.findElement(AppiumBy.id("android:id/message"));
            LogUtil.info("Disconnected message : " + message.getText());
        } catch (Exception e) {
            LogUtil.warning("Device disconnect verification fail.");
        }

        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("android:id/button1"))).click();
        } catch (Exception e) {
            LogUtil.warning("Ok confirmation is not happening.");
        }
    }
}
