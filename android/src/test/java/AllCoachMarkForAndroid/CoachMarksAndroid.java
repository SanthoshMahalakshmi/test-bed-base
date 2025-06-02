package AllCoachMarkForAndroid;

import Actions.ElementTask;
import DriverManagerAndroid.BaseLoginForAndroid;
import DriverManagerAndroid.DriverManager;
import UtilitiesForAndroid.RetryAnalyzer;
import org.openqa.selenium.By;
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
        elementMap.put(COACH_MARK_FINISH_BUTTON, COACH_MARK_FINISH_BUTTON_TASK);
        performActions(elementMap, wait);

    }

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void TC_038() throws Exception {

        /*Global wait*/
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        /*Core Login for android.*/
        bs.CoreLoginForAndroid(false);
        Map<By, ElementTask> elementMap = new LinkedHashMap<>();
        elementMap.put(DEVICE_BUTTON, DEVICE_BUTTON_TASK);
        elementMap.put(COACH_MARK_TEXT, COACH_MARK_TEXT_TASK);
        elementMap.put(COACH_MARK_FINISH_BUTTON, COACH_MARK_FINISH_BUTTON_TASK);
        performActions(elementMap, wait);

    }

}
