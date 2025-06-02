package AllCoachMarkForAndroid;

import Actions.ElementTask;
import DriverManagerAndroid.BaseLoginForAndroid;
import DriverManagerAndroid.DriverManager;
import UtilitiesForAndroid.LogUtil;
import UtilitiesForAndroid.RetryAnalyzer;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.LinkedHashMap;
import java.util.Map;

import static ElementRepositories.CoachMarkScreenElements.*;
import static ElementRepositories.CommonElements.*;
import static UtilitiesForAndroid.ElementActions.*;

public class CoachMarksAndroid extends DriverManager {

    private static final Logger log = LoggerFactory.getLogger(CoachMarksAndroid.class);
    BaseLoginForAndroid bs = new BaseLoginForAndroid();

    /*DashBoard Coach mark case*/
    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void TC_036() throws Exception {
        /*Core Login for android.*/
        bs.CoreLoginForAndroid(false);
        /*Global wait*/
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        Map<By, ElementTask> elementMap = new LinkedHashMap<>();
        /*Need to add dashboard coach mark case once after the coach mark is available*/
        performActions(elementMap, wait);


    }

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void TC_037() throws Exception {

        /*Global wait*/
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        /*Core Login for android.*/
        bs.CoreLoginForAndroid(false);

        Map<By, ElementTask> elementMap = new LinkedHashMap<>();
        elementMap.put(REPORT_BUTTON, REPORT_BUTTON_TASK);
        elementMap.put(COACH_MARK_TEXT, COACH_MARK_TEXT_TASK);
        elementMap.put(REPORT_FINISH_BUTTON, REPORT_FINISH_BUTTON_TASK);
        performActions(elementMap, wait);

    }

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void TC_038() throws Exception {

        /*Global wait*/
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        /*Core Login for android.*/
        bs.CoreLoginForAndroid(true);

        /*Device button click*/
        WebElement DeviceButton = null;
        try {
            DeviceButton = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.androidUIAutomator("new UiSelector().text(\"Devices\")")));
            DeviceButton.click();
            LogUtil.info("Device section click is happening now.");

        } catch (Exception e) {
            LogUtil.warning("There is no 'Device' button.");
            throw new RuntimeException(e.getMessage());
        }

        WebElement DeviceCoachMarkText = null;
        try {
            DeviceCoachMarkText = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.heartmonitor.android:id/tvtest")));
            LogUtil.info("Device page Coach mark text: \n" + DeviceCoachMarkText.getText());
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }

        WebElement Finish = null;
        try {
            Finish = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.heartmonitor.android:id/btnNext")));
            Finish.click();
            LogUtil.info("Clicking the Finish button for the coach mark in the device section");

        } catch (Exception e) {
            LogUtil.warning("There is no 'Finish' Button in the device section.");
            throw new RuntimeException(e.getMessage());
        }
    }


}
