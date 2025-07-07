package DashBoard;

import java.time.Duration;
import java.util.LinkedHashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import Actions.Activity;
import Actions.ElementTask;
import DriverManagerAndroid.BaseLoginForAndroid;
import DriverManagerAndroid.DriverManager;
import static ElementRepositories.CoachMarkScreenElements.*;
import static ElementRepositories.CommonElements.*;
import static ElementRepositories.DashBoardScreenElements.*;
import static ElementRepositories.FeedBackScreenElements.*;
import static ElementRepositories.MyDependentScreenElements.*;
import static ElementRepositories.NotificationScreenElements.*;
import static ElementRepositories.ReportScreenElements.*;
import static ElementRepositories.SetReminderScreenElements.*;
import static ElementRepositories.CareCircleScreenElements.*;
import static UtilitiesForAndroid.ElementActions.*;
import static ElementRepositories.ProfileScreenElements.*;
import UtilitiesForAndroid.RetryAnalyzer;

public class DashBoard_Page_Android extends DriverManager {

    BaseLoginForAndroid bs = new BaseLoginForAndroid();

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void TC_010() throws Exception {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        /*Pre-Request*/
        bs.CoreLoginForAndroid(false);

        Map<By, ElementTask> elementMap = new LinkedHashMap<>();
        /*Actual test case*/
        elementMap.put(DASHBOARD_APP_LOGO, DASHBOARD_APP_LOGO_TASK);
        elementMap.put(DASHBOARD_SYNC_BUTTON, DASHBOARD_SYNC_BUTTON_TASK);
        elementMap.put(DASHBOARD_SYNC_TOAST, DASHBOARD_SYNC_TOAST_TASK);
        elementMap.put(DASHBOARD_SYNC_TOAST_CLOSE, DASHBOARD_SYNC_TOAST_CLOSE_TASK);
        elementMap.put(DASHBOARD_NOTIFICATION_BUTTON, DASHBOARD_NOTIFICATION_BUTTON_TASK);
        elementMap.put(NOTIFICATION_LABEL, NOTIFICATION_LABEL_TASK);
        elementMap.put(ACTUAL_NOTIFICATION, ACTUAL_NOTIFICATION_TASK);
        elementMap.put(NOTIFICATION_CLEAR_BUTTON, new ElementTask.Builder(Activity.VERIFY, "clear button is").build());
        elementMap.put(BACK_BUTTON, BACK_BUTTON_TASK);
        elementMap.put(DASHBOARD_SEND_FEEDBACK_BUTTON, DASHBOARD_SEND_FEEDBACK_BUTTON_TASK);
        performActions(elementMap, wait);
    }

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void TC_011() throws Exception {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        /*Pre-Request*/
        bs.CoreLoginForAndroid(false);
        Map<By, ElementTask> elementMap = new LinkedHashMap<>();
        elementMap.put(DASHBOARD_DEPENDENT_LABEL, DASHBOARD_DEPENDENT_LABEL_TASK);
        elementMap.put(DASHBOARD_DEPENDENT_BUTTON, DASHBOARD_DEPENDENT_BUTTON_TASK);
        elementMap.put(BACK_BUTTON, BACK_BUTTON_TASK);
        elementMap.put(DASHBOARD_DEPENDENT_USER_1, new ElementTask.Builder(Activity.CLICK, "Dependent profile click").build());
        elementMap.put(COACH_MARK_FINISH_BUTTON, COACH_MARK_FINISH_BUTTON_TASK);
        elementMap.put(BLOOD_PRESSURE_TAB, new ElementTask.Builder(Activity.VERIFY, "Blood pressure tab").build());
        elementMap.put(DOWNLOAD_BUTTON, new ElementTask.Builder(Activity.VERIFY, "Download button").build());
        performActions(elementMap, wait);
    }

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void TC_012() throws Exception {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        /*Pre-Request*/
        bs.CoreLoginForAndroid(false);
        Map<By, ElementTask> elementMap = new LinkedHashMap<>();
        /*Actual test case*/
        elementMap.put(DASHBOARD_CARE_CIRCLE_LABEL, DASHBOARD_CARE_CIRCLE_LABEL_TASK);
        elementMap.put(DASHBOARD_CARE_CIRCLE_GET_STARTED, DASHBOARD_CARE_CIRCLE_GET_STARTED_TASK);
        elementMap.put(ACCESS_CONTACT_DENY_BUTTON, ACCESS_CONTACT_DENY_BUTTON_TASK);
        elementMap.put(TOAST_CLOSE, TOAST_CLOSE_TASK);
        elementMap.put(CARE_CIRCLE_LABEL, CARE_CIRCLE_LABEL_TASK);
        elementMap.put(CARE_CIRCLE_GROUP_NAME, CARE_CIRCLE_GROUP_NAME_TASK);
        elementMap.put(CARE_CIRCLE_CONTACT_ADD_BUTTON, CARE_CIRCLE_CONTACT_ADD_BUTTON_TASK);
        elementMap.put(SET_REMINDER_CHECK_BOX, SET_REMINDER_CHECK_BOX_TASK);
        elementMap.put(CARE_CIRCLE_SUBMIT_BUTTON, CARE_CIRCLE_SUBMIT_BUTTON_TASK);
        performActions(elementMap, wait);
    }

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void TC_013() throws Exception {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        bs.CoreLoginForAndroid(false);
        Map<By, ElementTask> elementMap = new LinkedHashMap<>();
        elementMap.put(DASHBOARD_SEND_FEEDBACK_BUTTON, DASHBOARD_SEND_FEEDBACK_BUTTON_TASK);
        elementMap.put(SEND_FEEDBACK_LABEL, SEND_FEEDBACK_LABEL_TASK);
        elementMap.put(SUBJECT_INPUT_FIELD, SUBJECT_INPUT_FIELD_TASK);
        elementMap.put(FEEDBACK_TYPE, FEEDBACK_TYPE_TASK);
        elementMap.put(FEEDBACK_OPTION_OTHERS, FEEDBACK_OPTION_OTHERS_TASK);
        elementMap.put(MESSAGE_INPUT_FIELD, MESSAGE_INPUT_FIELD_TASK);
        elementMap.put(PICK_IMAGE_OPTION, PICK_IMAGE_OPTION_TASK);
        elementMap.put(SEND_FEEDBACK_BUTTON, SEND_FEEDBACK_BUTTON_TASK);
        performActions(elementMap, wait);
    }

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void TC_014() throws Exception {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        bs.CoreLoginForAndroid(false);
        Map<By, ElementTask> elementMap = new LinkedHashMap<>();
        elementMap.put(DASHBOARD_CARE_CIRCLE, DASHBOARD_CARE_CIRCLE_TASK);
        elementMap.put(ACCESS_CONTACT_DENY_BUTTON, ACCESS_CONTACT_DENY_BUTTON_TASK);
        elementMap.put(TOAST_CLOSE, TOAST_CLOSE_TASK);
        elementMap.put(CARE_CIRCLE_MORE_OPTION, CARE_CIRCLE_MORE_OPTION_TASK);
        elementMap.put(EDIT_CARE_CIRCLE_OPTION, new ElementTask.Builder(Activity.VERIFY, "Edit care circle option").build());
        elementMap.put(SET_REMINDER_OPTION, new ElementTask.Builder(Activity.VERIFY, "Set reminder option").build());
        elementMap.put(DELETE_CARE_CIRCLE_OPTION, new ElementTask.Builder(Activity.VERIFY, "Delete care Circle option").build());
        performActions(elementMap, wait);
    }

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void TC_015() throws Exception {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        bs.CoreLoginForAndroid(false);

        Map<By, ElementTask> elementMap = new LinkedHashMap<>();

        elementMap.put(DASHBOARD_CARE_CIRCLE, DASHBOARD_CARE_CIRCLE_TASK);
        elementMap.put(ACCESS_CONTACT_DENY_BUTTON, ACCESS_CONTACT_DENY_BUTTON_TASK);
        elementMap.put(TOAST_CLOSE, TOAST_CLOSE_TASK);
        elementMap.put(CARE_CIRCLE_MORE_OPTION, CARE_CIRCLE_MORE_OPTION_TASK);
        elementMap.put(SET_REMINDER_OPTION, SET_REMINDER_OPTION_TASK);
        elementMap.put(SET_REMINDER_BP_RADIO_BUTTON, SET_REMINDER_BP_RADIO_BUTTON_TASK);
        elementMap.put(SET_REMINDER_ECG_RADIO_BUTTON, SET_REMINDER_ECG_RADIO_BUTTON_TASK);
        elementMap.put(SET_REMINDER_SPO2_RADIO_BUTTON, SET_REMINDER_SPO2_RADIO_BUTTON_TASK);
        elementMap.put(SET_REMINDER_HR_RADIO_BUTTON, SET_REMINDER_HR_RADIO_BUTTON_TASK);
        elementMap.put(DONE_BUTTON, DONE_BUTTON_TASK);
        elementMap.put(REMINDER_NAME, REMINDER_NAME_TASK);
        elementMap.put(ALL_DAYS_CHECKBOX, ALL_DAYS_CHECKBOX_TASK);
        elementMap.put(ADD_TIME_BUTTON, ADD_TIME_BUTTON_TASK);
        elementMap.put(CLOCK_OK_BUTTON, CLOCK_OK_BUTTON_TASK);
        elementMap.put(ADD_INVITEE_PLUS_BUTTON, ADD_INVITEE_PLUS_BUTTON_TASK);
        elementMap.put(ALL_MY_FAMILY_CHECKBOX, ALL_MY_FAMILY_CHECKBOX_TASK);
        elementMap.put(ADD_INVITEE_BUTTON, ADD_INVITEE_BUTTON_TASK);
        elementMap.put(PERSONAL_NOTE_INPUT_FIELD, PERSONAL_NOTE_INPUT_FIELD_TASK);
        elementMap.put(SET_REMINDER_BUTTON, SET_REMINDER_BUTTON_TASK);

        performActions(elementMap, wait);
    }

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void TC_016() throws Exception {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        bs.CoreLoginForAndroid(false);
        Map<By, ElementTask> elementMap = new LinkedHashMap<>();

        /*pre-Request*/
        elementMap.put(DASHBOARD_CARE_CIRCLE, DASHBOARD_CARE_CIRCLE_TASK);
        elementMap.put(ACCESS_CONTACT_DENY_BUTTON, ACCESS_CONTACT_DENY_BUTTON_TASK);
        elementMap.put(TOAST_CLOSE, TOAST_CLOSE_TASK);
        elementMap.put(CARE_CIRCLE_MORE_OPTION, CARE_CIRCLE_MORE_OPTION_TASK);
        elementMap.put(SET_REMINDER_OPTION, SET_REMINDER_OPTION_TASK);
        elementMap.put(SET_REMINDER_BP_RADIO_BUTTON, SET_REMINDER_BP_RADIO_BUTTON_TASK);
        elementMap.put(DONE_BUTTON, DONE_BUTTON_TASK);
        elementMap.put(REMINDER_NAME, REMINDER_NAME_TASK);
        elementMap.put(PERSONAL_NOTE_INPUT_FIELD, PERSONAL_NOTE_INPUT_FIELD_TASK);

        /*Actual test case*/
        elementMap.put(SUN_BUTTON, SUN_BUTTON_TASK);
        elementMap.put(MON_BUTTON, MON_BUTTON_TASK);
        elementMap.put(TUE_BUTTON, TUE_BUTTON_TASK);
        elementMap.put(WED_BUTTON, WED_BUTTON_TASK);
        elementMap.put(THU_BUTTON, THU_BUTTON_TASK);
        elementMap.put(FRI_BUTTON, FRI_BUTTON_TASK);
        elementMap.put(SAT_BUTTON, SAT_BUTTON_TASK);
        elementMap.put(ALL_DAYS_CHECKBOX, new ElementTask.Builder(Activity.CLICK, "UnSelect the days").build());
        performActions(elementMap, wait);

        /*Day not selected error.*/
        Map<By, ElementTask> elementTaskMap = new LinkedHashMap<>();
        elementTaskMap.put(SET_REMINDER_BUTTON, SET_REMINDER_BUTTON_TASK);
        elementTaskMap.put(DAY_NOT_SELECTED_ERROR, DAY_NOT_SELECTED_ERROR_TASK);
        elementTaskMap.put(MODEL_CLOSE_OK_BUTTON, MODEL_CLOSE_OK_BUTTON_TASK);
        performActions(elementTaskMap, wait);

        /*Time not selected error.*/
        Map<By, ElementTask> elementTaskMap1 = new LinkedHashMap<>();
        elementTaskMap1.put(SAT_BUTTON, SAT_BUTTON_TASK);
        elementTaskMap1.put(SET_REMINDER_BUTTON, SET_REMINDER_BUTTON_TASK);
        elementTaskMap1.put(TIME_NOT_SELECTED_ERROR, TIME_NOT_SELECTED_ERROR_TASK);
        elementTaskMap1.put(MODEL_CLOSE_OK_BUTTON, MODEL_CLOSE_OK_BUTTON_TASK);
        performActions(elementTaskMap1, wait);

    }

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void TC_017() throws Exception {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        bs.CoreLoginForAndroid(false);
        Map<By, ElementTask> elementMap = new LinkedHashMap<>();

        /*Pre-Request*/
        elementMap.put(DASHBOARD_CARE_CIRCLE, DASHBOARD_CARE_CIRCLE_TASK);
        elementMap.put(ACCESS_CONTACT_DENY_BUTTON, ACCESS_CONTACT_DENY_BUTTON_TASK);
        elementMap.put(TOAST_CLOSE, TOAST_CLOSE_TASK);
        elementMap.put(CARE_CIRCLE_MORE_OPTION, CARE_CIRCLE_MORE_OPTION_TASK);
        elementMap.put(SET_REMINDER_OPTION, SET_REMINDER_OPTION_TASK);
        elementMap.put(SET_REMINDER_BP_RADIO_BUTTON, SET_REMINDER_BP_RADIO_BUTTON_TASK);
        elementMap.put(DONE_BUTTON, DONE_BUTTON_TASK);

        /*Reminder Empty character error*/
        elementMap.put(PERSONAL_NOTE_INPUT_FIELD, PERSONAL_NOTE_INPUT_FIELD_TASK);
        elementMap.put(SET_REMINDER_BUTTON, SET_REMINDER_BUTTON_TASK);
        elementMap.put(EMPTY_REMINDER_NAME_ERROR, EMPTY_REMINDER_NAME_ERROR_TASK);
        performActions(elementMap, wait);

        /*Reminder Less character error*/
        Map<By, ElementTask> elementTaskMap = new LinkedHashMap<>();
        elementTaskMap.put(PERSONAL_NOTE_INPUT_FIELD, PERSONAL_NOTE_INPUT_FIELD_TASK);
        elementTaskMap.put(REMINDER_NAME, new ElementTask.Builder(Activity.SEND_KEYS, "Reminder name").inputValue("Re").build());
        elementTaskMap.put(SET_REMINDER_BUTTON, SET_REMINDER_BUTTON_TASK);
        elementTaskMap.put(REMINDER_NAME_LESS_CHARACTER_ERROR, REMINDER_NAME_LESS_CHARACTER_ERROR_TASK);
        performActions(elementTaskMap, wait);
    }

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void TC_018() throws Exception {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        bs.CoreLoginForAndroid(false);
        Map<By, ElementTask> elementMap = new LinkedHashMap<>();

        /*Pre-Request*/
        elementMap.put(DASHBOARD_CARE_CIRCLE, DASHBOARD_CARE_CIRCLE_TASK);
        elementMap.put(ACCESS_CONTACT_DENY_BUTTON, ACCESS_CONTACT_DENY_BUTTON_TASK);
        elementMap.put(TOAST_CLOSE, TOAST_CLOSE_TASK);
        elementMap.put(CARE_CIRCLE_MORE_OPTION, CARE_CIRCLE_MORE_OPTION_TASK);
        elementMap.put(SET_REMINDER_OPTION, SET_REMINDER_OPTION_TASK);
        elementMap.put(SET_REMINDER_BP_RADIO_BUTTON, SET_REMINDER_BP_RADIO_BUTTON_TASK);
        elementMap.put(DONE_BUTTON, DONE_BUTTON_TASK);
        performActions(elementMap, wait);


        /*Personal note empty error.*/
        Map<By, ElementTask> byElementTaskMap = new LinkedHashMap<>();
        byElementTaskMap.put(REMINDER_NAME, REMINDER_NAME_TASK);
        byElementTaskMap.put(SET_REMINDER_BUTTON, SET_REMINDER_BUTTON_TASK);
        byElementTaskMap.put(EMPTY_PERSONAL_NAME_ERROR, EMPTY_PERSONAL_NAME_ERROR_TASK);
        performActions(byElementTaskMap, wait);

        /*Less character error for personal note.*/
        Map<By, ElementTask> elementTaskMap1 = new LinkedHashMap<>();
        elementTaskMap1.put(PERSONAL_NOTE_INPUT_FIELD, new ElementTask.Builder(Activity.SEND_KEYS, "Personal note").inputValue("per").build());
        elementTaskMap1.put(SET_REMINDER_BUTTON, SET_REMINDER_BUTTON_TASK);
        elementTaskMap1.put(PERSONAL_NOTE_LESS_CHARACTER_ERROR, PERSONAL_NOTE_LESS_CHARACTER_ERROR_TASK);
        performActions(elementTaskMap1, wait);

    }

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void TC_019() throws Exception {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        bs.CoreLoginForAndroid(false);
        Map<By, ElementTask> elementMap = new LinkedHashMap<>();

        /*Pre-Request*/
        elementMap.put(DASHBOARD_CARE_CIRCLE, DASHBOARD_CARE_CIRCLE_TASK);
        elementMap.put(ACCESS_CONTACT_DENY_BUTTON, ACCESS_CONTACT_DENY_BUTTON_TASK);
        elementMap.put(TOAST_CLOSE, TOAST_CLOSE_TASK);
        elementMap.put(CARE_CIRCLE_MORE_OPTION, CARE_CIRCLE_MORE_OPTION_TASK);

        /*Actual test case*/
        elementMap.put(DELETE_CARE_CIRCLE_OPTION, DELETE_CARE_CIRCLE_OPTION_TASK);
        elementMap.put(DELETE_CARE_CIRCEL_MODEL_TEXT, DELETE_CARE_CIRCEL_MODEL_TEXT_TASK);
        elementMap.put(MODEL_CLOSE_CANCEL_BUTTON, MODEL_CLOSE_CANCEL_BUTTON_TASK);
        performActions(elementMap, wait);

    }

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void TC_025() throws Exception {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        bs.CoreLoginForAndroid(false);  //basic login scenario

        Map<By, ElementTask> elementMap = new LinkedHashMap<>();
        elementMap.put(DASHBOARD_DEPENDENT_DROPDOWN, DASHBOARD_DEPENDENT_DROPDOWN_TASK);
        elementMap.put(DASHBOARD_DEPENDENT_USER_1, new ElementTask.Builder(Activity.VERIFY, "Dependent User").build());
        performActions(elementMap, wait);

        Map<By, ElementTask> elementMap2 = new LinkedHashMap<>();
        elementMap2.put(DASHBOARD_DEPENDENT_USER_1, new ElementTask.Builder(Activity.CLICK, "Dependent user").build());
        elementMap2.put(PROFILE_BUTTON, PROFILE_BUTTON_TASK);
        elementMap2.put(PROFILE_COACH_MARK_SKIP, PROFILE_COACH_MARK_SKIP_TASK);
        elementMap2.put(MY_DEPENDENT_BUTTON, MY_DEPENDENT_BUTTON_TASK);
        elementMap2.put(DEPENDENT_BURGER_MENU, DEPENDENT_BURGER_MENU_TASK);
        elementMap2.put(DEPENDENT_DELETE_OPTION, DEPENDENT_DELETE_OPTION_TASK);
        elementMap2.put(DEPENDENT_EDIT_PROFILE_OPTION, DEPENDENT_EDIT_PROFILE_OPTION_TASK);
        performActions(elementMap2, wait);
    }

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void TC_026() throws Exception {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        bs.CoreLoginForAndroid(false);  //basic login scenario
        Map<By, ElementTask> elementMap = new LinkedHashMap<>();

        /*Pre-Request*/
        elementMap.put(PROFILE_BUTTON, PROFILE_BUTTON_TASK);
        elementMap.put(PROFILE_COACH_MARK_SKIP, PROFILE_COACH_MARK_SKIP_TASK);
        elementMap.put(MY_DEPENDENT_BUTTON, MY_DEPENDENT_BUTTON_TASK);

        /*Actual test Case*/
        elementMap.put(DEPENDENT_BURGER_MENU, DEPENDENT_BURGER_MENU_TASK);
        elementMap.put(DEPENDENT_HEALTH_REPORT_OPTION, DEPENDENT_HEALTH_REPORT_OPTION_TASK);
        elementMap.put(REPORT_BUTTON, new ElementTask.Builder(Activity.VERIFY, "User is in report section now").build());
        elementMap.put(COACH_MARK_FINISH_BUTTON, COACH_MARK_FINISH_BUTTON_TASK);
        performActions(elementMap, wait);

    }

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void TC_027() throws Exception {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        bs.CoreLoginForAndroid(false);  //basic login scenario
        Map<By, ElementTask> elementMap = new LinkedHashMap<>();
        elementMap.put(REMINDER_PLUS_BUTTON, REMINDER_PLUS_BUTTON_TASK);
        performActions(elementMap, wait);

    }

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void TC_028() throws Exception {

        bs.CoreLoginForAndroid(false);  //basic login scenario
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Map<By, ElementTask> elementMap = new LinkedHashMap<>();
        elementMap.put(DASHBOARD_BP_REPORT_LABEL, DASHBOARD_BP_REPORT_LABEL_TASK);
        elementMap.put(DASHBOARD_BP_REPORT_CHART, DASHBOARD_BP_REPORT_CHART_TASK);
        elementMap.put(DASHBOARD_BP_REPORT_VALUE, DASHBOARD_BP_REPORT_VALUE_TASK);

        elementMap.put(DASHBOARD_HR_REPORT_LABEL, DASHBOARD_HR_REPORT_LABEL_TASK);
        elementMap.put(DASHBOARD_HR_REPORT_CHART, DASHBOARD_HR_REPORT_CHART_TASK);
        elementMap.put(DASHBOARD_HR_REPORT_VALUE, DASHBOARD_HR_REPORT_VALUE_TASK);

        elementMap.put(DASHBOARD_SPO2_REPORT_LABEL, DASHBOARD_SPO2_REPORT_LABEL_TASK);
        elementMap.put(DASHBOARD_SPO2_REPORT_CHART, DASHBOARD_SPO2_REPORT_CHART_TASK);
        elementMap.put(DASHBOARD_SPO2_REPORT_VALUE, DASHBOARD_SPO2_REPORT_VALUE_TASK);

        elementMap.put(DASHBOARD_ECG_REPORT_LABEL, DASHBOARD_ECG_REPORT_LABEL_TASK);
        elementMap.put(DASHBOARD_ECG_REPORT_CHART, DASHBOARD_ECG_REPORT_CHART_TASK);
        performActions(elementMap, wait);

    }

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void TC_040() throws Exception {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        bs.CoreLoginForAndroid(false);
        Map<By, ElementTask> elementMap = new LinkedHashMap<>();

        elementMap.put(PROFILE_BUTTON, PROFILE_BUTTON_TASK);

        elementMap.put(PROFILE_COACH_MARK_SKIP, PROFILE_COACH_MARK_SKIP_TASK);

        elementMap.put(PRIMARY_USER_PROFILE_NAME, PRIMARY_USER_PROFILE_NAME_TASK);

        performActions(elementMap, wait);

        Map<By, ElementTask> elementMap2 = new LinkedHashMap<>();
       
        elementMap2.put(DASHBOARD_BUTTON, DASHBOARD_BUTTON_TASK);
        
        elementMap2.put(DASHBOARD_PRIMARY_USER_PROFILE_NAME, DASHBOARD_PRIMARY_USER_PROFILE_NAME_TASK);
        performActions(elementMap2, wait);

        assertElementsTextEqual(driver, PRIMARY_USER_PROFILE_NAME,DASHBOARD_PRIMARY_USER_PROFILE_NAME, "primary user profile name on profile", "primary user profile name on dashboard");
    }

    @Test
    public void TC_041() throws Exception {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        bs.CoreLoginForAndroid(false);

        Map<By, ElementTask> elementMap1 = new LinkedHashMap<>();
        elementMap1.put(DASHBOARD_DEPENDENT_DROPDOWN, DASHBOARD_DEPENDENT_DROPDOWN_TASK);
        elementMap1.put(DASHBOARD_DEPENDENT_USER_1, DASHBOARD_DEPENDENT_USER_1_TASK);
        elementMap1.put(DASHBOARD_DEPENDENT_USER_PROFILE_NAME, DASHBOARD_DEPENDENT_USER_PROFILE_NAME_TASK);
        performActions(elementMap1, wait);
        assertElementsTextEqual(driver, DASHBOARD_DEPENDENT_USER_1, DASHBOARD_DEPENDENT_USER_PROFILE_NAME, "Dependent user name in dashboard", "Dependent user name in dropDown");

        Map<By, ElementTask> elementMap2 = new LinkedHashMap<>();
        elementMap2.put(DASHBOARD_DEPENDENT_DROPDOWN, DASHBOARD_DEPENDENT_DROPDOWN_TASK);
        elementMap2.put(DASHBOARD_DEPENDENT_USER_2, DASHBOARD_DEPENDENT_USER_2_TASK);
        elementMap2.put(DASHBOARD_DEPENDENT_USER_PROFILE_NAME, DASHBOARD_DEPENDENT_USER_PROFILE_NAME_TASK);
        performActions(elementMap2, wait);
        assertElementsTextEqual(driver, DASHBOARD_DEPENDENT_USER_2, DASHBOARD_DEPENDENT_USER_PROFILE_NAME, "Dependent user name in dashboard", "Dependent user name in dropDown");

        Map<By, ElementTask> elementMap3 = new LinkedHashMap<>();
        elementMap3.put(DASHBOARD_DEPENDENT_DROPDOWN, DASHBOARD_DEPENDENT_DROPDOWN_TASK);
        elementMap3.put(DASHBOARD_DEPENDENT_USER_3, DASHBOARD_DEPENDENT_USER_3_TASK);
        elementMap3.put(DASHBOARD_DEPENDENT_USER_PROFILE_NAME, DASHBOARD_DEPENDENT_USER_PROFILE_NAME_TASK);
        performActions(elementMap3, wait);
        assertElementsTextEqual(driver, DASHBOARD_DEPENDENT_USER_3, DASHBOARD_DEPENDENT_USER_PROFILE_NAME, "Dependent user name in dashboard", "Dependent user name in dropDown");

        Map<By, ElementTask> elementMap4 = new LinkedHashMap<>();
        elementMap4.put(DASHBOARD_DEPENDENT_DROPDOWN, DASHBOARD_DEPENDENT_DROPDOWN_TASK);
        elementMap4.put(DASHBOARD_DEPENDENT_USER_4, DASHBOARD_DEPENDENT_USER_4_TASK);
        elementMap4.put(DASHBOARD_DEPENDENT_USER_PROFILE_NAME, DASHBOARD_DEPENDENT_USER_PROFILE_NAME_TASK);
        performActions(elementMap4, wait);
        assertElementsTextEqual(driver, DASHBOARD_DEPENDENT_USER_4, DASHBOARD_DEPENDENT_USER_PROFILE_NAME, "Dependent user name in dashboard", "Dependent user name in dropDown");

    }

}
