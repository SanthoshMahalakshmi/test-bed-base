package DriverManagerIos;

import Actions.iOSElementTask;
import UtilitiesForIos.LogUtil;
import UtilitiesForIos.RetryAnalyzerios;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.LinkedHashMap;
import java.util.Map;

import static UtilitiesForIos.iOSElementActions.performIOSActions;
import static iOSElemenRepositories.iOSCommonElements.*;
import static iOSElemenRepositories.iOSLoginScreenElements.*;
import static iOSElemenRepositories.iOSOTPVerifyScreenElements.*;
import static iOSElemenRepositories.iOSSplashScreenElements.*;

public class BaseLoginForiOS extends DriverManager {

    @Test(retryAnalyzer = RetryAnalyzerios.class)
    public void BaseLoginForIos(Boolean isSkipped) {

        /*Global wait.*/
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        /*Pre-Condition*/
        Map<By, iOSElementTask> iOSElementMap = new LinkedHashMap<>();
        iOSElementMap.put(iOS_NEXT_BTN, iOS_NEXT_BTN_TASK);
        performIOSActions(iOSElementMap, wait);

        Map<By, iOSElementTask> iOSElementMap2 = new LinkedHashMap<>();
        iOSElementMap2.put(iOS_NEXT_BTN, iOS_NEXT_BTN_TASK);
        iOSElementMap2.put(iOS_GET_STARTED_BTN, iOS_GET_STARTED_BTN_TASK);
        performIOSActions(iOSElementMap2, wait);

        try {
            driver.findElement(AppiumBy.xpath("//XCUIElementTypeTextField[@value=\"9999999999\"]")).sendKeys("9087631080");

        }catch (Exception e)
        {
            throw new RuntimeException(e.getMessage());
        }

        Map<By, iOSElementTask> iOSElementMap3 = new LinkedHashMap<>();
        iOSElementMap3.put(iOS_KEYBOARD_DONE_BUTTON, iOS_KEYBOARD_DONE_BUTTON_TASK);
        iOSElementMap3.put(iOS_CONTINUE_BTN, iOS_CONTINUE_BTN_TASK);
        performIOSActions(iOSElementMap3, wait);


        String otp = "123456";
        for (int i = 0; i < otp.length(); i++) {
            wait.until(ExpectedConditions.visibilityOfElementLocated(iOS_OTP_FIELDS[i]))
                    .sendKeys(String.valueOf(otp.charAt(i)));
        }

        Map<By, iOSElementTask> iOSElementMap4 = new LinkedHashMap<>();
        iOSElementMap4.put(iOS_OTP_VERIFY_BUTTON, iOS_OTP_VERIFY_BUTTON_TASK);
        performIOSActions(iOSElementMap4, wait);

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
        LogUtil.info("Exit from the core login case for iOS.");
    }
}
