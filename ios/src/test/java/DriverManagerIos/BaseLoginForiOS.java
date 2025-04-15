package DriverManagerIos;

import UtilitiesForIos.RetryAnalyzerios;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class BaseLoginForiOS extends DriverManager {

    @Test(retryAnalyzer = RetryAnalyzerios.class)
    public void BaseLoginForIos() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        try
        {
            Alert alert = wait.until(ExpectedConditions.alertIsPresent());
            alert.accept();
            logger.info("The allow notification is accepted here.");
        } catch (Exception e) {
            logger.warning("There is no Allow button to accept the notification.");
            throw new RuntimeException(e.getMessage());
        }


        //Need add skip button handling.
        WebElement Skip = null;
        try
        {
            Skip = wait.until(ExpectedConditions.elementToBeClickable
                    (AppiumBy.iOSClassChain("**/XCUIElementTypeStaticText[`name == \"Skip\"`]")));
            logger.info("Skipping the coach mark");
        }catch (NoSuchElementException e)
        {
            logger.warning("There is no Skip button is visible.");
        }

        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy
                    .iOSClassChain("**/XCUIElementTypeButton[`name == \"Allow\"`]"))).click();
            logger.info("before login->Allow button is visible and its clicked Allow");
        }
        catch (Exception e)
        {
            logger.info("Before login-> Notification allow Button is not pop-up to accept allow.");
        }

        //Clicking the Get started button
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.
                    iOSClassChain("**/XCUIElementTypeStaticText[`name == \"Get Started\"`]"))).click();
            logger.info("Get started button is clicked.");
        } catch (Exception e) {
            logger.warning("Get started button is not visible to click");
        }

        //clicking the mobile number input field and send the keys to it.
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy
                    .iOSClassChain("**/XCUIElementTypeTextField[`value == \"9999999999\"`]"))).sendKeys("0000000000");
            logger.info("input passing for mobile number field is working.");
        } catch (Exception e) {
            logger.warning("input for the mobile number field not passed.");
        }

        //Clicking the continue button
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.
                    iOSClassChain("**/XCUIElementTypeButton[`name == \"Continue\"`]"))).click();
            logger.info("Clicking on continue to move further.");
        } catch (Exception e) {
            logger.warning("Clicking on continue is not working.");
        }

        WebElement Delay_Ok_button = null;
        try
        {
            Delay_Ok_button = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("android:id/button1")));
            Delay_Ok_button.click();
            logger.info(" 30 sec 0r 60 sec delay OK Button is found and its clicked");
        }
        catch (Exception e)
        {
            logger.warning("30 sec 0r 60 sec delay Ok button is not found, we good to go with login");
        }

        //Fill the OTP into input field.
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.
                            xpath("//XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTextField[1]")))
                    .sendKeys("1");
            wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.
                            xpath("//XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTextField[2]")))
                    .sendKeys("2");
            wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.
                            xpath("//XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTextField[3]")))
                    .sendKeys("3");
            wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.
                            xpath("//XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTextField[4]")))
                    .sendKeys("4");
            wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.
                            xpath("//XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTextField[5]")))
                    .sendKeys("5");
            wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.
                            xpath("//XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTextField[6]")))
                    .sendKeys("6");
            logger.info("Otp is entered and we moved further.");
        } catch (Exception e) {
            logger.warning("Entered OTP input is not correct.");
        }

        //Verify the OTP
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.iOSClassChain("**/XCUIElementTypeStaticText[`name == \"Verify OTP\"`]"))).click();
            logger.info("verifying the otp is working.");
        } catch (Exception e) {
            logger.warning("Clicking on verify button is not working.");
        }

        WebElement AllowNotificationButton_2 = null;
        try {
            AllowNotificationButton_2 =  wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("Allow")));
            AllowNotificationButton_2.click();
            logger.info("Allow button is visible and its clicked Allow");
        }
        catch (Exception e)
        {
            logger.info("Notification allow Button is not pop-up to accept allow.");
        }

        //When dependent profile ois not add we need to click the skip button.
        try
        {
            wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.
                    iOSClassChain("**/XCUIElementTypeStaticText[`name == \"Skip\"`]"))).click();
            logger.info("Skip button is clicked to move further.");
        }
        catch (Exception e)
        {
            logger.warning("Skip button is not there might be dependent profile is present.");
        }
    }


}
