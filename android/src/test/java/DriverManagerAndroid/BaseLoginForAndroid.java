package DriverManagerAndroid;

import UtilitiesForAndroid.LogUtil;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.logging.Logger;

public class BaseLoginForAndroid extends DriverManager {

    @Test(singleThreaded = true)
    public void CoreLoginForAndroid(Boolean IsSkipped) throws Exception {

        LogUtil.info("Entering into Core login case for Android.");

        WebDriverWait wait = new WebDriverWait(DriverManager.driver, Duration.ofSeconds(10));

        //Clicking the Get started button
        try {
            WebElement getStarted = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.heartmonitor.android:id/txtGetStart")));
            getStarted.click();
            LogUtil.info("Successfully clicked the 'Get Started' button.");
        } catch (ElementClickInterceptedException e) {
            throw new ElementNotInteractableException(e.getMessage());
        } catch (NoSuchElementException e) {
            throw new NoSuchElementException(e.getMessage());
        }

        //clicking the mobile number input field and send the keys to it.
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.heartmonitor.android:id/edtMobileNumber"))).sendKeys("9087631080");
            LogUtil.info("Mobile number is added in the field.");
        } catch (Exception e) {
            LogUtil.warning("Mobile number is not added as input to the input field.");
            throw new Exception(e.getMessage());
        }

        //Clicking the continue button
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.heartmonitor.android:id/txtContinue"))).click();
            LogUtil.info("Continue button is clicked for login process.");
        } catch (Exception e) {
            LogUtil.warning("Clicking the continue button is not happening.");
            throw new RuntimeException(e);
        }

        //Fill the OTP into input field.
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.heartmonitor.android:id/editTextOTP1"))).sendKeys("1");
            wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.heartmonitor.android:id/editTextOTP2"))).sendKeys("2");
            wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.heartmonitor.android:id/editTextOTP3"))).sendKeys("3");
            wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.heartmonitor.android:id/editTextOTP4"))).sendKeys("4");
            wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.heartmonitor.android:id/editTextOTP5"))).sendKeys("5");
            wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.heartmonitor.android:id/editTextOTP6"))).sendKeys("6");
            LogUtil.info("OTP is entered successfully.");
        } catch (Exception e) {
            LogUtil.warning("OTP is not entered successfully.");
            throw new Exception(e.getMessage());
        }

        //Verify the OTP
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.heartmonitor.android:id/txtVerify"))).click();
            LogUtil.info("OTP verify button is clicked successfully.");
        } catch (Exception e) {
            LogUtil.warning("Verifying the OTP is not working.");
            throw new Exception(e.getMessage());
        }

        WebElement AllowNotificationButton = null;
        try {
            AllowNotificationButton = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.android.permissioncontroller:id/permission_allow_button")));
            AllowNotificationButton.click();
            LogUtil.info("Allow button is visible and its clicked Allow");
        } catch (Exception e) {
            LogUtil.warning("Notification allow Button is not pop-up to accept allow.");
        }

        WebElement SKip = null;
        if (IsSkipped) {
            try {
                SKip = wait.until(ExpectedConditions.elementToBeClickable(By.id("com.heartmonitor.android:id/tvSkip")));
                SKip.click();
                LogUtil.info("Coach mark is visible and its skipped.");
            } catch (NoSuchElementException e) {
                LogUtil.warning("The coach mark Skip is not visible." + e.getMessage());
            } catch (Exception e) {
                LogUtil.warning(e.getMessage());
            }
        }
        LogUtil.info("Exit from the core login case for Android.");
    }
}
