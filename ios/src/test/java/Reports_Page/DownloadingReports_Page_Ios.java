package Reports_Page;

import Actions.iOSElementTask;
import DriverManagerIos.BaseLoginForiOS;
import DriverManagerIos.DriverManager;
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
import static iOSElemenRepositories.iOSCoachMarkScreenElements.*;
import static iOSElemenRepositories.iOSCommonElements.*;
import static iOSElemenRepositories.iOSReportScreenElements.*;

public class DownloadingReports_Page_Ios extends DriverManager {

    BaseLoginForiOS baseLoginForiOS = new BaseLoginForiOS();

    @Test(retryAnalyzer = RetryAnalyzerios.class)
    public void TC_020() {
        baseLoginForiOS.BaseLoginForIos(false);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        Map<By, iOSElementTask> iOSElementMap = new LinkedHashMap<>();

        iOSElementMap.put(iOS_REPORT_SECTION, iOS_REPORT_SECTION_TASK);

        iOSElementMap.put(iOS_COACH_MARK_FINISH_BUTTON, iOS_COACH_MARK_FINISH_BUTTON_TASK);

        /*Actual Test Case*/
        iOSElementMap.put(iOS_DROP_DOWN_FILTER_OPTION, iOS_DROP_DOWN_FILTER_OPTION_TASK);

        iOSElementMap.put(iOS_DAY_DROP_DOWN_OPTION, iOS_DAY_DROP_DOWN_OPTION_TASK);

        iOSElementMap.put(iOS_WEEK_DROP_DOWN_OPTION, iOS_WEEK_DROP_DOWN_OPTION_TASK);

        iOSElementMap.put(iOS_MONTH_DROP_DOWN_OPTION, iOS_MONTH_DROP_DOWN_OPTION_TASK);

        iOSElementMap.put(iOS_CUSTOM_DROP_DOWN_OPTION, iOS_CUSTOM_DROP_DOWN_OPTION_TASK);

        iOSElementMap.put(iOS_YEAR_DROP_DOWN_OPTION, iOS_YEAR_DROP_DOWN_OPTION_TASK);

        iOSElementMap.put(iOS_DOWNLOAD_BUTTON, iOS_DOWNLOAD_BUTTON_TASK);

        performIOSActions(iOSElementMap, wait);
    }

    @Test(retryAnalyzer = RetryAnalyzerios.class)
    public void TC_021() {
        baseLoginForiOS.BaseLoginForIos(false);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        Map<By, iOSElementTask> iOSElementMap = new LinkedHashMap<>();

        iOSElementMap.put(iOS_REPORT_SECTION, iOS_REPORT_SECTION_TASK);

        iOSElementMap.put(iOS_COACH_MARK_FINISH_BUTTON, iOS_COACH_MARK_FINISH_BUTTON_TASK);

        /*Actual test case*/
        iOSElementMap.put(iOS_ECG_TAB, iOS_ECG_TAB_TASK);
        iOSElementMap.put(iOS_ECG_DOWNLOAD_BUTTON, iOS_ECG_DOWNLOAD_BUTTON_TASK);
        iOSElementMap.put(iOS_ECG_REPORT_DONE_BUTTON, iOS_ECG_REPORT_DONE_BUTTON_TASK);

        performIOSActions(iOSElementMap, wait);
    }

    @Test(retryAnalyzer = RetryAnalyzerios.class)
    public void TC_022() {
        baseLoginForiOS.BaseLoginForIos(false);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        Map<By, iOSElementTask> iOSElementMap = new LinkedHashMap<>();

        iOSElementMap.put(iOS_REPORT_SECTION, iOS_REPORT_SECTION_TASK);

        iOSElementMap.put(iOS_COACH_MARK_FINISH_BUTTON, iOS_COACH_MARK_FINISH_BUTTON_TASK);

        /*Actual Test case*/
        iOSElementMap.put(iOS_HR_TAB, iOS_HR_TAB_TASK);
        iOSElementMap.put(iOS_DOWNLOAD_BUTTON, iOS_DOWNLOAD_BUTTON_TASK);

        performIOSActions(iOSElementMap, wait);
    }
}
     