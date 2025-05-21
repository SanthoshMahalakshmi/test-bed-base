package DashBoard;

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

import static ElementRepositories.CareCircleScreenElements.*;
import static ElementRepositories.CommonElements.*;
import static ElementRepositories.DashBoardScreenElements.*;
import static ElementRepositories.FeedBackScreenElements.*;
import static ElementRepositories.NotificationScreenElements.*;
import static ElementRepositories.ReportScreenElements.*;
import static ElementRepositories.SetReminderScreenElements.*;
import static UtilitiesForAndroid.ElementActions.*;

public class DashBoard_Page_Android extends DriverManager {

    BaseLoginForAndroid bs = new BaseLoginForAndroid();

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void TC_010() throws Exception {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        /*Pre-Request*/
        bs.CoreLoginForAndroid(true);

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
        bs.CoreLoginForAndroid(true);
        Map<By, ElementTask> elementMap = new LinkedHashMap<>();
        elementMap.put(DASHBOARD_DEPENDENT_LABEL, DASHBOARD_DEPENDENT_LABEL_TASK);
        elementMap.put(DASHBOARD_DEPENDENT_BUTTON, DASHBOARD_DEPENDENT_BUTTON_TASK);
        elementMap.put(BACK_BUTTON, BACK_BUTTON_TASK);
        elementMap.put(DASHBOARD_DEPENDENT_USER, new ElementTask.Builder(Activity.CLICK, "Dependent profile click").build());
        elementMap.put(COACH_MARK_FINISH_BUTTON, COACH_MARK_FINISH_BUTTON_TASK);
        elementMap.put(BLOOD_PRESSURE_TAB, new ElementTask.Builder(Activity.VERIFY, "Blood pressure tab").build());
        elementMap.put(DOWNLOAD_BUTTON, DOWNLOAD_BUTTON_TASK);
        performActions(elementMap, wait);
    }

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void TC_012() throws Exception {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        /*Pre-Request*/
        bs.CoreLoginForAndroid(true);
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
        bs.CoreLoginForAndroid(true);
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
        bs.CoreLoginForAndroid(true);
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
        WebDriverWait wait =  new WebDriverWait(driver, Duration.ofSeconds(10));
        bs.CoreLoginForAndroid(true);

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
        WebDriverWait wait =  new WebDriverWait(driver, Duration.ofSeconds(10));
        bs.CoreLoginForAndroid(true);
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

        WebDriverWait wait =  new WebDriverWait(driver, Duration.ofSeconds(10));
        bs.CoreLoginForAndroid(true);
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

        WebDriverWait wait =  new WebDriverWait(driver, Duration.ofSeconds(10));
        bs.CoreLoginForAndroid(true);
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

        WebDriverWait wait =  new WebDriverWait(driver, Duration.ofSeconds(10));
        bs.CoreLoginForAndroid(true);
        Map<By, ElementTask> elementMap = new LinkedHashMap<>();

        /*Pre-Request*/
        elementMap.put(DASHBOARD_CARE_CIRCLE, DASHBOARD_CARE_CIRCLE_TASK);
        elementMap.put(ACCESS_CONTACT_DENY_BUTTON, ACCESS_CONTACT_DENY_BUTTON_TASK);
        elementMap.put(TOAST_CLOSE, TOAST_CLOSE_TASK);
        elementMap.put(CARE_CIRCLE_MORE_OPTION, CARE_CIRCLE_MORE_OPTION_TASK);

        /*Actual test case*/
        elementMap.put(DELETE_CARE_CIRCLE_OPTION, DELETE_CARE_CIRCLE_OPTION_TASK);
        elementMap.put(DELETE_CARE_CIRCEL_MODEL_TEXT, DELETE_CARE_CIRCEL_MODEL_TEXT_TASK);
        elementMap.put(MODEL_CLOSE_CANCLE_BUTTON, MODEL_CLOSE_CANCLE_BUTTON_TASK);
        performActions(elementMap, wait);

    }


    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void TC_025() throws Exception {

        LogUtil.info("Enter into TC_025");

        bs.CoreLoginForAndroid(true);  //basic login scenario

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.androidUIAutomator("new UiSelector().text(\"+2\")"))).click();

        try {
            //1.Verify the dependent list
            wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.androidUIAutomator("new UiSelector().text(\"Kavya\")")));
            WebElement Dependent_1 = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Kavya\")"));
            LogUtil.info(Dependent_1.getText() + " is one of the dependent is present : " + Dependent_1.isDisplayed());
        } catch (Exception e) {
            LogUtil.warning("Dependent is not available.");
        }

        try {
            //2.Edit the dependent profile, click on kebab menu.
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.androidUIAutomator
                    ("new UiSelector().resourceId(\"com.heartmonitor.android:id/imgMenu\").instance(1)"))).click();
            //Actual edit profile option.
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.androidUIAutomator
                    ("new UiSelector().text(\"Edit Profile\")"))).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.heartmonitor.android:id/edtFullName"))).sendKeys("NIHIL");
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("Navigate up"))).click();
        } catch (Exception e) {
            LogUtil.warning("Edit the dependent profile is not happen.");
        }

        try {
            //3.Deleting the profile
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.androidUIAutomator
                    ("new UiSelector().resourceId(\"com.heartmonitor.android:id/imgMenu\").instance(2)"))).click();
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.androidUIAutomator("new UiSelector().text(\"Delete\")"))).click();
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("android:id/button1"))).click();

            wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("android:id/message")));
            WebElement message = driver.findElement(AppiumBy.id("android:id/message"));
            LogUtil.info("Success message for deleted dependent :" + message.getText());
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("android:id/button1"))).click();
        } catch (Exception e) {
            LogUtil.warning("Deleting the dependent profile is not happen.s");
        }

    }

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void TC_026() throws Exception {

        LogUtil.info("Enter into TC_026");

        bs.CoreLoginForAndroid(true);  //basic login scenario

        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.androidUIAutomator("new UiSelector().text(\"+2\")"))).click();

            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.androidUIAutomator
                    ("new UiSelector().resourceId(\"com.heartmonitor.android:id/imgMenu\").instance(0)"))).click();

            //Clicking the health report option to navigate to report section.
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.androidUIAutomator("new UiSelector().text(\"Health Report\")"))).click();

            wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.androidUIAutomator("new UiSelector().text(\"Blood Pressure\")")));
            WebElement lable = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Blood Pressure\")"));
            LogUtil.info("Report section : " + lable.getText());
        } catch (Exception e) {
            LogUtil.warning("Not moved to the Report section of the dependent.");
        }
    }

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void TC_027() throws Exception {

        LogUtil.info("Enter into TC_027");

        /*Adding the reminder for Blood pressure.*/
        bs.CoreLoginForAndroid(true);  //basic login scenario

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.heartmonitor.android:id/txtEcg"))).isDisplayed();

        //Scrolling to the plus button.
        try {
            driver.findElement(AppiumBy.androidUIAutomator
                    ("new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(resourceId(\"com.heartmonitor.android:id/imgAddReminder\"));"));
        } catch (Exception e) {
            LogUtil.warning("Scroll to the element is not happen.");
        }

        //1.Clicking the plus button
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.heartmonitor.android:id/imgAddReminder"))).click();
        } catch (Exception e) {
            LogUtil.warning("Clicking plus button is not happen.");
        }

        //Clicking the HR radio button.
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.heartmonitor.android:id/rbHR"))).click();
        } catch (Exception e) {
            LogUtil.warning("Hr radio button click is not happen.");
        }

        //Selecting the DONE button.
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.heartmonitor.android:id/txtSubmit"))).click();
        } catch (Exception e) {
            LogUtil.warning("Done button click is not happen.");
        }

        try {
            //2.reminder name
            wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.
                    id("com.heartmonitor.android:id/edtReminderName"))).sendKeys("Heart rate reminder");

            //Selecting the required days
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.heartmonitor.android:id/txtSUN"))).click();
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.heartmonitor.android:id/txtMUN"))).click();

            //Click add Button.
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.heartmonitor.android:id/chipAdd"))).click();

            //Selecting the Hour as 12.
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("9"))).click();

            //Selecting the Minutes as 00.
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("15"))).click();

            //Clicking the ok
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("android:id/button1"))).click();
        } catch (Exception e) {
            LogUtil.warning("Setting up the reminder time and day selection is not happen.");
        }

        //Checking whether the reminder time is added or not.
        try {
            WebElement timer = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.heartmonitor.android:id/chipText")));
            LogUtil.info("just checking whether the reminder time is added or not: " + timer.isDisplayed());
        } catch (Exception e) {
            LogUtil.warning("Timer is not visible.");
        }

        try {
            //3.Adding invite
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.heartmonitor.android:id/imgAddReminder"))).click();

            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.androidUIAutomator
                    ("new UiSelector().resourceId(\"com.heartmonitor.android:id/mainLayout\").instance(0)"))).click();

            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.heartmonitor.android:id/txtSubmit"))).click();
        } catch (Exception e) {
            LogUtil.warning("Add people to the reminder is not happen.");
        }

        try {
            //Scrolling to the Adding personal notes.
            driver.findElement(AppiumBy.androidUIAutomator
                    ("new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(resourceId(\"com.heartmonitor.android:id/edtPersonalNotes\"));"));
        } catch (Exception e) {
            LogUtil.warning("Scroll to the element is not happen.");
        }

        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.
                    id("com.heartmonitor.android:id/edtPersonalNotes"))).sendKeys("Take HR daily.");

            //Set the reminder
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.heartmonitor.android:id/txtSetReminder"))).click();
        } catch (Exception e) {
            LogUtil.warning("Set reminder is not happen.");
        }

    }

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void TC_028() throws Exception {

        LogUtil.info("Enter into TC_028");

        bs.CoreLoginForAndroid(true);  //basic login scenario

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        //BP report values with chart.
        try {
            WebElement bloodPressureElement = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.heartmonitor.android:id/txtBloodPressure")));
            LogUtil.info("Blood pressure report is present: " + bloodPressureElement.isDisplayed());

            WebElement pressureChart = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.heartmonitor.android:id/bloodPressureChart")));
            LogUtil.info("Blood pressure report chart is present: " + pressureChart.isDisplayed());

            WebElement pressureValue = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.heartmonitor.android:id/txtBPValue")));
            LogUtil.info("Blood pressure value is present: " + pressureValue.getText());
        } catch (Exception e) {
            LogUtil.warning("Bp chart is not visible.");
        }

        try {
            //Hr report values with chart.
            WebElement hrElement = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.heartmonitor.android:id/txtHeartRate")));
            LogUtil.info("Heart rate report is present: " + hrElement.isDisplayed());

            WebElement hrChart = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.heartmonitor.android:id/HeartRateChart")));
            LogUtil.info("Heart rate report chart is present: " + hrChart.isDisplayed());

            WebElement hrValue = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.heartmonitor.android:id/txtHeartRateValue")));
            LogUtil.info("Heart rate value is present: " + hrValue.getText());
        } catch (Exception e) {
            LogUtil.warning("Hr report chart is not visible.");
        }

        try {
            //Spo2 report values with chart.
            WebElement Spo2Element = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.heartmonitor.android:id/txtSpo2")));
            LogUtil.info("Spo2 report is present: " + Spo2Element.isDisplayed());

            WebElement Spo2Chart = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.heartmonitor.android:id/spo2Chart")));
            LogUtil.info("Spo2 report chart is present: " + Spo2Chart.isDisplayed());

            WebElement Spo2Value = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.heartmonitor.android:id/txtSpo2Value")));
            LogUtil.info("Spo2 value is present: " + Spo2Value.getText());
        } catch (Exception e) {
            LogUtil.warning("Spo2 report chart is not visible.");
        }

        try {
            //ECG report va;ues with chart
            WebElement ECGElement = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.heartmonitor.android:id/txtEcg")));
            LogUtil.info("ECG report is present: " + ECGElement.isDisplayed());

            WebElement ECGChart = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.heartmonitor.android:id/mpSingleLeadECG")));
            LogUtil.info("ECG report chart is present: " + ECGChart.isDisplayed());
        } catch (Exception e) {
            LogUtil.warning("ECG report chart is not visible.");
        }
    }

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void TC_029() throws Exception {

        LogUtil.info("Enter into TC_029");

        bs.CoreLoginForAndroid(true);  //basic login scenario

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            //Clicking on primary user profile
            wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.heartmonitor.android:id/imgProfile"))).click();
        } catch (Exception e) {
            LogUtil.warning("Primary user profile click is not happen.");
        }

        try {
            //Clicking on parameter range option in the primary user profile
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.heartmonitor.android:id/txtParameterRange"))).click();
        } catch (Exception e) {
            LogUtil.warning("Primary user parameter range click is not happen");
        }

        //Customize the BP range
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.
                    androidUIAutomator("new UiSelector().resourceId(\"com.heartmonitor.android:id/txtCustomize2\").instance(0)"))).click();
            //Submit button
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.heartmonitor.android:id/txtSubmit"))).click();
            //Reset can happen
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.heartmonitor.android:id/txtBPRest\").instance(0)"))).click();
            //confirmation Ok
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("android:id/button1"))).click();
            //Skip
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.heartmonitor.android:id/tvSkip"))).click();
        } catch (Exception e) {
            LogUtil.warning("Customize the BP range is not happen for the primary user. ");
        }

        try {
            //Customize the heart rate.
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.heartmonitor.android:id/txtCustomize2\").instance(0)"))).click();
            //Submit button
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.heartmonitor.android:id/txtSubmit"))).click();
            //Reset can happen
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.heartmonitor.android:id/txtBPRest\").instance(0)"))).click();
            //confirmation Ok
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("android:id/button1"))).click();
        } catch (Exception e) {
            LogUtil.warning("Customizing the HR is not working");
        }

        try {
            //Navigate to the profile page.
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("Navigate up"))).click();
        } catch (Exception e) {
            LogUtil.warning("Navigating back is not happen.");
        }

    }


    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void TC_030() throws Exception {

        LogUtil.info("Enter into TC_030");

        bs.CoreLoginForAndroid(true);  //basic login scenario

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            //clicking the dependent profile
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.androidUIAutomator("new UiSelector().text(\"K\")"))).click();
        } catch (Exception e) {
            LogUtil.warning("Dependent user profile navigation is not happening.");
        }

        try {
            //Customize the BP range
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.heartmonitor.android:id/txtCustomize2"))).click();
            //Submit button
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.heartmonitor.android:id/txtSubmit"))).click();
            //Reset can happen
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.heartmonitor.android:id/txtBPRest"))).click();
            //confirmation Ok
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("android:id/button1"))).click();
        } catch (Exception e) {
            LogUtil.warning("Customizing BP is not happening.");
        }

        //Scroll to the bottom customize.
        try {
            driver.findElement(AppiumBy.androidUIAutomator
                    ("new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(resourceId(\"com.heartmonitor.android:id/txtCustomize2\"));"));
        } catch (Exception e) {
            LogUtil.warning("Scroll to the element is not happen.");
        }

        try {
            //Blood sugar range is not customizable
            WebElement CustomizeBlood = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.heartmonitor.android:id/txtCustomize1")));
            System.out.println("Blood sugar is not customizable :" + CustomizeBlood.isEnabled());
            LogUtil.info("Customizing for blood sugar is should not be enable.");
        } catch (Exception e) {
            LogUtil.warning("Blood sugar customize is not cheking.");
        }

        try {
            //Customize the Spo2 range
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.heartmonitor.android:id/txtCustomize2\").instance(0)"))).click();
            //Submit button
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.heartmonitor.android:id/txtSubmit"))).click();
            //Reset can happen
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.heartmonitor.android:id/txtBPRest\").instance(0)"))).click();
            //confirmation Ok
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("android:id/button1"))).click();
        } catch (Exception e) {
            LogUtil.warning("Customizing the Spo2 is not happen.");
        }

        try {
            //Customizing the cholesterol is not possible.
            WebElement CustomizeCholesterol = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.heartmonitor.android:id/txtCustomize1\").instance(1)")));
            LogUtil.info("Cholesterol is not Customizable :" + CustomizeCholesterol.isEnabled());
        } catch (Exception e) {
            LogUtil.warning("Customizing the cholesterol is not possible.");
        }

        try {
            //Scroll to the bottom customize.
            driver.findElement(AppiumBy.androidUIAutomator
                    ("new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(resourceId(\"com.heartmonitor.android:id/txtCustomize2\"));"));
        } catch (Exception e) {
            LogUtil.warning("Scroll to the element is not happen.");
        }

        try {
            //Customize the heart rate.
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.heartmonitor.android:id/txtCustomize2\").instance(0)"))).click();
            //Submit button
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.heartmonitor.android:id/txtSubmit"))).click();
            //Reset can happen
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.heartmonitor.android:id/txtBPRest\").instance(0)"))).click();
            //confirmation Ok
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("android:id/button1"))).click();
        } catch (Exception e) {
            LogUtil.warning("Customize the Hr is not happen.");
        }

    }

}
