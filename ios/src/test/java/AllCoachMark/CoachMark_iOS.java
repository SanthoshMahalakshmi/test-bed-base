package AllCoachMark;

import DriverManagerIos.BaseLoginForiOS;
import DriverManagerIos.DriverManager;

import UtilitiesForIos.RetryAnalyzerios;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import Actions.iOSElementTask;

import static UtilitiesForIos.iOSElementActions.performIOSActions;
import static iOSElemenRepositories.iOSCommonElements.*;
import static iOSElemenRepositories.iOSCoachMarkScreenElements.*;
import static iOSElemenRepositories.iOSProfileScreenElements.*;

import java.time.Duration;
import java.util.LinkedHashMap;
import java.util.Map;

public class CoachMark_iOS extends DriverManager {

    BaseLoginForiOS bs = new BaseLoginForiOS();

    @Test(retryAnalyzer = RetryAnalyzerios.class)
    public void TC036() {
        /*Global wait*/
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        /*Core Login for android.*/
        bs.BaseLoginForIos(false);

        Map<By, iOSElementTask> iOSElementMap = new LinkedHashMap<>();

        // Need to be added for DashBoard Coach mark
        performIOSActions(iOSElementMap, wait);
    }


    @Test(retryAnalyzer = RetryAnalyzerios.class)
    public void TC_037() {

        /*Global wait*/
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        /*Core Login for android.*/
        bs.BaseLoginForIos(false);

        Map<By, iOSElementTask> iOSElementMap = new LinkedHashMap<>();

        iOSElementMap.put(iOS_REPORT_SECTION, iOS_REPORT_SECTION_TASK);

       iOSElementMap.put(iOS_REPORT_COACH_MARK_TEXT, iOS_REPORT_COACH_MARK_TEXT_TASK);

        iOSElementMap.put(iOS_COACH_MARK_FINISH_BUTTON, iOS_COACH_MARK_FINISH_BUTTON_TASK);

        performIOSActions(iOSElementMap, wait);
    }


    @Test(retryAnalyzer = RetryAnalyzerios.class)
    public void TC_038() {

        /*Global wait*/
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        /*Core Login for android.*/
        bs.BaseLoginForIos(false);

        Map<By, iOSElementTask> iOSElemenetMap = new LinkedHashMap<>();

        iOSElemenetMap.put(iOS_MY_DEVICE_BUTTON, iOS_MY_DEVICE_BUTTON_TASK);

        iOSElemenetMap.put(iOS_DEVICE_COACH_MARK_TEXT, iOS_DEVICE_COACH_MARK_TEXT_TASK);

        iOSElemenetMap.put(iOS_COACH_MARK_FINISH_BUTTON, iOS_COACH_MARK_FINISH_BUTTON_TASK);

        performIOSActions(iOSElemenetMap, wait);
    }


    @Test(retryAnalyzer = RetryAnalyzerios.class)
    public void TC_039() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        bs.BaseLoginForIos(false);

        Map<By, iOSElementTask> iOSElementMap = new LinkedHashMap<>();

        iOSElementMap.put(iOS_PROFILE_BUTTON, iOS_PROFILE_BUTTON_TASK);

        iOSElementMap.put(iOS_PROFILE_COACH_MARK_TEXT1, iOS_PROFILE_COACH_MARK_TEXT_TASK1);

        iOSElementMap.put(iOS_COACH_MARK_NEXT_BUTTON, iOS_COACH_MARK_NEXT_BUTTON_TASK);

        iOSElementMap.put(iOS_PROFILE_COACH_MARK_TEXT2, iOS_PROFILE_COACH_MARK_TEXT_TASK2);

        iOSElementMap.put(iOS_COACH_MARK_FINISH_BUTTON, iOS_COACH_MARK_FINISH_BUTTON_TASK);

        performIOSActions(iOSElementMap, wait);
        
    }
}
