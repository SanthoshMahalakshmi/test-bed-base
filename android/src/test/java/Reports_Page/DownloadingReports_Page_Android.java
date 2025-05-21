package Reports_Page;

import Actions.Activity;
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
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.LinkedHashMap;
import java.util.Map;


import static ElementRepositories.CommonElements.*;
import static ElementRepositories.ReportScreenElements.*;
import static UtilitiesForAndroid.ElementActions.*;

public class DownloadingReports_Page_Android extends DriverManager {

    BaseLoginForAndroid bs = new BaseLoginForAndroid();


    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void TC_020() throws Exception {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        bs.CoreLoginForAndroid(false);
        Map<By, ElementTask> elementMap = new LinkedHashMap<>();
        /*Pre-request*/
        elementMap.put(REPORT_BUTTON, REPORT_BUTTON_TASK);
        elementMap.put(COACH_MARK_FINISH_BUTTON, COACH_MARK_FINISH_BUTTON_TASK);

        /*Actual test case*/
        elementMap.put(DATE_FILTER_OPTION, DATE_FILTER_OPTION_TASK);
        elementMap.put(MODEL_CLOSE_OK_BUTTON, MODEL_CLOSE_OK_BUTTON_TASK);
        elementMap.put(DAY_DROP_DOWN, DAY_DROP_DOWN_TASK);
        elementMap.put(WEEK_FILTER_OPTION, WEEK_FILTER_OPTION_TASK);
        elementMap.put(MONTH_FILTER_OPTION, MONTH_FILTER_OPTION_TASK);
        elementMap.put(YEAR_FILTER_OPTION, YEAR_FILTER_OPTION_TASK);
        elementMap.put(CUSTOME_FILTER_OPTION, CUSTOME_FILTER_OPTION_TASK);
        elementMap.put(DOWNLOAD_BUTTON, DOWNLOAD_BUTTON_TASK);
        performActions(elementMap, wait);

    }

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void TC_021() throws Exception {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));

        bs.CoreLoginForAndroid(false);
        Map<By, ElementTask> elementMap = new LinkedHashMap<>();

        /*pre-Request*/
        elementMap.put(REPORT_BUTTON, REPORT_BUTTON_TASK);
        elementMap.put(COACH_MARK_FINISH_BUTTON, COACH_MARK_FINISH_BUTTON_TASK);

        /*Actual test case*/
        elementMap.put(ECG_TAB, ECG_TAB_TASK);
        elementMap.put(ECG_DOWNLOAD_BUTTON, ECG_DOWNLOAD_BUTTON_TASK);
        elementMap.put(ECG_REPORT_ID, ECG_REPORT_ID_TASK);
        performActions(elementMap, wait);
    }


    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void TC_022() throws Exception {

        bs.CoreLoginForAndroid(true);  //basic login scenario

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        //Variable Declaration.
        WebElement ReportBtn, ECG, DownloadBtn, FinishBtn, HRReport;

        //Clicking on the report section
        try {
            ReportBtn = wait.until(ExpectedConditions.elementToBeClickable
                    (AppiumBy.androidUIAutomator
                            ("new UiSelector().resourceId(\"com.heartmonitor.android:id/navigation_bar_item_icon_view\").instance(1)")));
            ReportBtn.click();
            LogUtil.info("Clicking the 'Report' Section.");
        } catch (Exception e) {
            LogUtil.warning("Clicking the report section is not working.");
            throw new Exception(e.getMessage());
        }

        //Report Section coach mark finish.
        try{
            FinishBtn =  wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.heartmonitor.android:id/btnNext")));
            FinishBtn.click();
            LogUtil.info("Report section coach mark finish button is clicked.");
        } catch (Exception e) {
            LogUtil.warning("There is no coach mark pop's out in the report section.");
        }

        //Clicking on the HR report
        try {
            HRReport = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.androidUIAutomator("new UiSelector().text(\"Heart Rate\")")));
            HRReport.click();
            LogUtil.info("Clicking the HR report section.");
        } catch (Exception e) {
            LogUtil.warning("clicking HR report section is not happening.");
            throw new Exception(e.getMessage());
        }

        //Clicking on the download button in Hr report section
        try {
            DownloadBtn = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.heartmonitor.android:id/imgDownload")));
            if (DownloadBtn.isEnabled())
            {
                DownloadBtn.click();
                LogUtil.info("Clicking the download button in the HR report section.");
            }
        } catch (Exception e) {
            LogUtil.warning("Clicking the download button in the HR report section not happening.");
            throw new Exception(e.getMessage());
        }

    }
}
