package DriverManagerIos;

import UtilitiesForIos.LogUtil;
import UtilitiesForIos.RetryAnalyzerios;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class BaseLoginForiOS extends DriverManager {

    @Test(retryAnalyzer = RetryAnalyzerios.class)
    public void BaseLoginForIos(Boolean isSkipped) throws Exception {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        try {
            Alert alert = wait.until(ExpectedConditions.alertIsPresent());
            alert.accept();
            LogUtil.info("The allow notification is accepted here.");
        } catch (Exception e) {
            LogUtil.warning("There is no Allow button to accept the notification.");
            throw new RuntimeException(e.getMessage());
        }

        //Clicking the Get started button
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.
                    iOSClassChain("**/XCUIElementTypeStaticText[`name == \"Get Started\"`]"))).click();
             LogUtil.info("Get started button is clicked.");
        } catch (Exception e) {
             LogUtil.warning("Get started button is not visible to click");
            throw new Exception(e.getMessage());
        }

        //clicking the mobile number input field and send the keys to it.
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy
                    .iOSClassChain("**/XCUIElementTypeTextField[`value == \"9999999999\"`]"))).sendKeys("9087631080");
             LogUtil.info("input passing for mobile number field is working.");
        } catch (Exception e) {
             LogUtil.warning("input for the mobile number field not passed.");
            throw new Exception(e.getMessage());
        }

        //Clicking the continue button
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.
                    iOSClassChain("**/XCUIElementTypeButton[`name == \"Continue\"`]"))).click();
             LogUtil.info("Clicking on continue to move further.");
        } catch (Exception e) {
             LogUtil.warning("Clicking on continue is not working.");
            throw new Exception(e.getMessage());
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
             LogUtil.info("Otp is entered and we moved further.");
        } catch (Exception e) {
             LogUtil.warning("Entered OTP input is not correct.");
        }

        //Verify the OTP
        WebElement VerifyBtn = null;
        try {
            VerifyBtn = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.iOSClassChain("**/XCUIElementTypeStaticText[`name == \"Verify OTP\"`]")));
            VerifyBtn.click();
             LogUtil.info("verifying the otp is working.");
        } catch (Exception e) {
             LogUtil.warning("Clicking on verify button is not working.");
            throw new Exception(e.getMessage());
        }

        WebElement AllowNotificationButton_2 = null;
        try {
            AllowNotificationButton_2 = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("Allow")));
            AllowNotificationButton_2.click();
             LogUtil.info("Allow button is visible and its clicked Allow");
        } catch (Exception e) {
             LogUtil.info("Notification allow Button is not pop-up to accept allow.");
        }

        WebElement Skip = null;
        if (isSkipped) {
            try {
                Skip = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.
                        iOSClassChain("**/XCUIElementTypeStaticText[`name == \"Skip\"`]")));
                Skip.click();
                 LogUtil.info("Skip button is clicked to move further.");
            } catch (Exception e) {
                 LogUtil.warning("Skip button is not present.");
            }
        }
    }
}
