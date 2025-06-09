package Profile;

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

import static ElementRepositories.CommonElements.*;
import static ElementRepositories.DeviceScreenElements.*;
import static ElementRepositories.ProfileScreenElements.*;
import static UtilitiesForAndroid.ElementActions.performActions;

public class Profile_Page_Android extends DriverManager {

    BaseLoginForAndroid bs = new BaseLoginForAndroid();


    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void TC_029() throws Exception {

        bs.CoreLoginForAndroid(false);  //basic login scenario
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        /*Pre-Condition*/
        Map<By, ElementTask> elementMap = new LinkedHashMap<>();
        elementMap.put(PROFILE_BUTTON, PROFILE_BUTTON_TASK);
        elementMap.put(PROFILE_COACH_MARK_SKIP, PROFILE_COACH_MARK_SKIP_TASK);

        /*Actual Test Case*/
        elementMap.put(PARAMETER_RANGE_BUTTON, PARAMETER_RANGE_BUTTON_TASK);
        elementMap.put(ADJUST_BUTTON_1, ADJUST_BUTTON_1_TASK);
        elementMap.put(SUBMIT_BUTTON, SUBMIT_BUTTON_TASK);
        elementMap.put(KEEP_DEFAULT_BUTTON_1, KEEP_DEFAULT_BUTTON_1_TASK);
        elementMap.put(RESET_PARAMETER_MODEL_TEXT, RESET_PARAMETER_MODEL_TEXT_TASK);
        elementMap.put(MODEL_CLOSE_OK_BUTTON, MODEL_CLOSE_OK_BUTTON_TASK);
        performActions(elementMap, wait);


        Map<By, ElementTask> elementTaskMap = new LinkedHashMap<>();
        elementTaskMap.put(ADJUST_BUTTON_2, ADJUST_BUTTON_2_TASK);
        elementTaskMap.put(SUBMIT_BUTTON, SUBMIT_BUTTON_TASK);
        elementTaskMap.put(KEEP_DEFAULT_BUTTON_2, KEEP_DEFAULT_BUTTON_2_TASK);
        elementTaskMap.put(RESET_PARAMETER_MODEL_TEXT, RESET_PARAMETER_MODEL_TEXT_TASK);
        elementTaskMap.put(MODEL_CLOSE_OK_BUTTON, MODEL_CLOSE_OK_BUTTON_TASK);
        performActions(elementTaskMap, wait);
    }


    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void TC_030() throws Exception {

        bs.CoreLoginForAndroid(false);  //basic login scenario
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        /*Actual Test Case*/
        Map<By, ElementTask> elementMap = new LinkedHashMap<>();
        elementMap.put(PROFILE_BUTTON, PROFILE_BUTTON_TASK);
        elementMap.put(PROFILE_COACH_MARK_SKIP, PROFILE_COACH_MARK_SKIP_TASK);
        elementMap.put(CONSUME_EDIT_BUTTON, CONSUME_EDIT_BUTTON_TASK);
        elementMap.put(BACK_BUTTON, BACK_BUTTON_TASK);
        performActions(elementMap, wait);

        Map<By, ElementTask> elementMap2 = new LinkedHashMap<>();
        elementMap2.put(PARAMETER_RANGE_BUTTON, PARAMETER_RANGE_BUTTON_TASK);
        elementMap2.put(BACK_BUTTON, BACK_BUTTON_TASK);
        performActions(elementMap2, wait);

        Map<By, ElementTask> elementTaskMap = new LinkedHashMap<>();
        elementTaskMap.put(MY_DEPENDENT_BUTTON, MY_DEPENDENT_BUTTON_TASK);
        elementTaskMap.put(BACK_BUTTON, BACK_BUTTON_TASK);
        performActions(elementTaskMap, wait);
    }

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void TC_031() throws Exception {

        bs.CoreLoginForAndroid(false);  //basic login scenario.
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        Map<By, ElementTask> elementMap = new LinkedHashMap<>();
        elementMap.put(PROFILE_BUTTON, PROFILE_BUTTON_TASK);
        elementMap.put(PROFILE_COACH_MARK_SKIP, PROFILE_COACH_MARK_SKIP_TASK);
        elementMap.put(CARE_CIRCLE_BUTTON, CARE_CIRCLE_BUTTON_TASK);
        elementMap.put(BACK_BUTTON, BACK_BUTTON_TASK);
        performActions(elementMap, wait);

        Map<By, ElementTask> elementTaskMap = new LinkedHashMap<>();
        elementTaskMap.put(PROFILE_BUTTON, PROFILE_BUTTON_TASK);
        elementTaskMap.put(MY_DEVICE_BUTTON, MY_DEVICE_BUTTON_TASK);
        elementTaskMap.put(DEVICE_COACH_MARK_FINISH_BUTTON, DEVICE_COACH_MARK_FINISH_BUTTON_TASK);
        performActions(elementTaskMap, wait);

        Map<By, ElementTask> elementTaskMap1 = new LinkedHashMap<>();
        elementTaskMap1.put(PROFILE_BUTTON, PROFILE_BUTTON_TASK);
        elementTaskMap1.put(MY_REMINDER_BUTTON, MY_REMINDER_BUTTON_TASK);
        elementTaskMap1.put(BACK_BUTTON, BACK_BUTTON_TASK);
        performActions(elementTaskMap1, wait);
    }

}
