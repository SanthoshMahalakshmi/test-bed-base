package Reports_Page;

import Actions.ElementTask;
import DriverManagerAndroid.BaseLoginForAndroid;
import DriverManagerAndroid.DriverManager;
import UtilitiesForAndroid.RetryAnalyzer;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.LinkedHashMap;
import java.util.Map;


import static ElementRepositories.CoachMarkScreenElements.*;
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

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));

        bs.CoreLoginForAndroid(false);
        Map<By, ElementTask> elementMap = new LinkedHashMap<>();

        /*pre-Request*/
        elementMap.put(REPORT_BUTTON, REPORT_BUTTON_TASK);
        elementMap.put(COACH_MARK_FINISH_BUTTON, COACH_MARK_FINISH_BUTTON_TASK);

        /*Actual testcase*/
        elementMap.put(HR_TAB, HR_TAB_TASK);
        elementMap.put(DOWNLOAD_BUTTON, DOWNLOAD_BUTTON_TASK);
        performActions(elementMap, wait);

    }

}
