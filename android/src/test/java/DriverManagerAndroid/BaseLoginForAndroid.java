package DriverManagerAndroid;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class BaseLoginForAndroid extends DriverManager {

    @Test(singleThreaded = true)
    public void CoreLoginForAndroid(Boolean IsSkipped) throws Exception {

        logger.info("Entering into Core login case fo Android.");

        WebDriverWait wait = new WebDriverWait(DriverManager.driver, Duration.ofSeconds(2));

        /*Clicking the Get started button*/
        try {
            WebElement getStarted = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.heartmonitor.android:id/txtGetStart")));
            getStarted.click();
            logger.info("Successfully clicked the 'Get Started' button.");
        } catch (ElementClickInterceptedException e) {
            throw new ElementNotInteractableException(e.getMessage());
        } catch (NoSuchElementException e) {
            throw new NoSuchElementException(e.getMessage());
        }

        try {
            //clicking the mobile number input field and send the keys to it.
            wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.heartmonitor.android:id/edtMobileNumber"))).sendKeys("9087631080");
            DriverManager.logger.info("Mobile number is added in the field.");
            //Clicking the continue button
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.heartmonitor.android:id/txtContinue"))).click();
            DriverManager.logger.info("Continue button is clicked for login process.");
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }

        WebElement Ok = null;
        try {
            Ok = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("android:id/button1")));
            Ok.click();
            DriverManager.logger.info("*OK Button is found and its clicked");
        } catch (Exception e) {
            DriverManager.logger.warning("Ok button is not found, we good to go with login");
        }

        //Fill the OTP into input field.
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.heartmonitor.android:id/editTextOTP1"))).sendKeys("1");
            wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.heartmonitor.android:id/editTextOTP2"))).sendKeys("2");
            wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.heartmonitor.android:id/editTextOTP3"))).sendKeys("3");
            wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.heartmonitor.android:id/editTextOTP4"))).sendKeys("4");
            wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.heartmonitor.android:id/editTextOTP5"))).sendKeys("5");
            wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.heartmonitor.android:id/editTextOTP6"))).sendKeys("6");
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }

        //Verify the OTP
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.heartmonitor.android:id/txtVerify"))).click();
        } catch (Exception e) {
            DriverManager.logger.warning("Verifying the OTP is not working.");
        }

        WebElement AllowNotificationButton = null;
        try {
            AllowNotificationButton = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.android.permissioncontroller:id/permission_allow_button")));
            AllowNotificationButton.click();
            DriverManager.logger.info("Allow button is visible and its clicked Allow");
        } catch (Exception e) {
            DriverManager.logger.warning("Notification allow Button is not pop-up to accept allow.");
        }

        WebElement SKip = null;
        if (IsSkipped){
            try {
                SKip = wait.until(ExpectedConditions.elementToBeClickable(By.id("com.heartmonitor.android:id/tvSkip")));
                SKip.click();
                DriverManager.logger.info("Coach mark is visible and its skipped.");
            } catch (NoSuchElementException e) {
                DriverManager.logger.warning("The coach mark Skip is not visible." + e.getMessage());
            } catch (Exception e) {
                DriverManager.logger.warning(e.getMessage());
            }
        }
       logger.info("Exit from the core login case for Android.");
    }
}
