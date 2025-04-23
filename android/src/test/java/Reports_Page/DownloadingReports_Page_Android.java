package Reports_Page;

import DriverManagerAndroid.BaseLoginForAndroid;
import DriverManagerAndroid.DriverManager;
import UtilitiesForAndroid.LogUtil;
import UtilitiesForAndroid.RetryAnalyzer;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class DownloadingReports_Page_Android extends DriverManager
{

    BaseLoginForAndroid bs = new BaseLoginForAndroid();

    
    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void TC_020() throws Exception {

        LogUtil.info("Enter into TC_020");

         bs.CoreLoginForAndroid(true);  //basic login scenario

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        //Clicking on the report section
        try {
            wait.until(ExpectedConditions.elementToBeClickable
                    (AppiumBy.androidUIAutomator
                            ("new UiSelector().resourceId(\"com.heartmonitor.android:id/navigation_bar_item_icon_view\").instance(1)"))).click();
        } catch (Exception e) {
            LogUtil.warning("Clicking the report section is not working.");
        }

        //Drop down filter.
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.androidUIAutomator
                    ("new UiSelector().text(\"Day\")"))).click();
        } catch (Exception e) {
            LogUtil.warning("Down filter is not working.");
        }

        //Selecting the month on this filter
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.
                    androidUIAutomator("new UiSelector().text(\"Month\")"))).click();
        } catch (Exception e) {
            LogUtil.warning("Selecting month is not working");
        }

        //clicking the to the specific month.
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.
                    androidUIAutomator("new UiSelector().text(\"Nov\")"))).click();
        } catch (Exception e) {
            LogUtil.warning("Selecting particular month is working.");
        }

        //Moving to previous month
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("Previous month"))).click();
        } catch (Exception e) {
            LogUtil.warning("Selecting previous month is not working");
        }

        //Report on Oct-29 for BP
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("29 October 2024"))).click();
        } catch (Exception e) {
            LogUtil.warning("Selecting particular day is not working.");
        }

        //Ok button
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("android:id/button1"))).click();
        } catch (Exception e) {
            LogUtil.warning("Selecting Ok is not happening.");
        }

        //Clicking the download button on Spo2 report section
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.heartmonitor.android:id/imgDownload"))).click();
        } catch (Exception e) {
            LogUtil.warning("Downloading the Spo2 report is not happening.");
        }

        //Allow permission
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.
                    id("com.android.packageinstaller:id/permission_allow_button"))).click();
        } catch (Exception e) {
            LogUtil.warning("Allow permission is not happening.");
        }
    }

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void TC_021() throws Exception {

        LogUtil.info("Enter into TC_021");

         bs.CoreLoginForAndroid(true);  //basic login scenario

        WebDriverWait wait =  new WebDriverWait(driver, Duration.ofSeconds(10));

        //Clicking on the report section
        try {
            wait.until(ExpectedConditions.elementToBeClickable
                    (AppiumBy.androidUIAutomator
                            ("new UiSelector().resourceId(\"com.heartmonitor.android:id/navigation_bar_item_icon_view\").instance(1)"))).click();
        } catch (Exception e) {
            LogUtil.warning("Clicking on report section is not happening.");
        }

        //Clicking on the ECG report
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.
                    androidUIAutomator("new UiSelector().text(\"ECG\")"))).click();
        } catch (Exception e) {
            LogUtil.warning("Ecg Report selection is not happening.");
        }

        //Clicking on the download button in ECG report section
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.heartmonitor.android:id/ivDownload1"))).click();
        } catch (Exception e) {
            LogUtil.warning("Downloading ECG report is not happening.");
        }

        //Allow permission
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.
                    id("com.android.packageinstaller:id/permission_allow_button"))).click();
        } catch (Exception e) {
            LogUtil.warning("Allow permission is not happening.");
        }
    }

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void TC_022() throws Exception {

        LogUtil.info("Enter into TC_022");

        bs.CoreLoginForAndroid(true);  //basic login scenario

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        //Clicking on the report section
        try {
            wait.until(ExpectedConditions.elementToBeClickable
                    (AppiumBy.androidUIAutomator
                            ("new UiSelector().resourceId(\"com.heartmonitor.android:id/navigation_bar_item_icon_view\").instance(1)"))).click();
        } catch (Exception e) {
            LogUtil.warning("Clicking report section is not happening.");
        }

        //Clicking on the HR report
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.
                    androidUIAutomator("new UiSelector().text(\"Heart Rate\")"))).click();
        } catch (Exception e) {
            LogUtil.warning("clicking HR report section is not happening.");
        }

        //Clicking on the download button in ECG report section
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.heartmonitor.android:id/imgDownload"))).click();
        } catch (Exception e) {
            LogUtil.warning("Download the HR report is not happening.");
        }

        //Allow permission
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.
                    id("com.android.packageinstaller:id/permission_allow_button"))).click();
        } catch (Exception e) {
            LogUtil.warning("Allow permission is not happening.");
        }
    }
}
