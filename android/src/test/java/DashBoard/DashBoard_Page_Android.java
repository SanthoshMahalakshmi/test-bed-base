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
    public void TC014() throws Exception {
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

        LogUtil.info("Enter into TC_015");

        bs.CoreLoginForAndroid(true);  //basic login scenario

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(13));

        //pre - Care circle button.
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.heartmonitor.android:id/imgOtherProfile"))).click();
            LogUtil.info("clicking the care circle.");
        } catch (Exception e) {
            LogUtil.warning("Care circle is not visible ");
        }

        //pre - permission
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id
                    ("com.android.packageinstaller:id/permission_allow_button"))).click();
        } catch (Exception e) {
            LogUtil.warning("permission is not accepted for allow.");
        }

        //pre - Add member
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.heartmonitor.android:id/tvAddMembers"))).click();
            LogUtil.info("Adding member is working");
        } catch (Exception e) {
            LogUtil.warning("Add member is not happening.");
        }

        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id
                    ("com.android.packageinstaller:id/permission_allow_button"))).click();
        } catch (Exception e) {
            LogUtil.warning("permission is not accepted for allow.");
        }

        //pre - clicking the kebab menu
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("More options"))).click();
        } catch (Exception e) {
            LogUtil.warning("clicking kebab menu is not happening.");
        }

        //1.clicking the Set reminder button in the kebab menu
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.androidUIAutomator
                    ("new UiSelector().text(\"Set Reminder\")"))).click();
            LogUtil.info("Set reminder is working.");
        } catch (Exception e) {
            LogUtil.warning("Set reminder from care circle is not happening");
        }

        //2.Verify the blood pressure radio button is selected by default.
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.heartmonitor.android:id/rbBp")));
            WebElement BP = driver.findElement(AppiumBy.id("com.heartmonitor.android:id/rbBp"));
            LogUtil.info("Bp reminder is selected default : " + BP.isDisplayed());
        } catch (Exception e) {
            LogUtil.warning("Bp radio button is not Enabled.");
        }

        //3.verify the ECG radio button is selectable
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.heartmonitor.android:id/rbECG"))).click();
            WebElement ECG = driver.findElement(AppiumBy.id("com.heartmonitor.android:id/rbECG"));
            LogUtil.info("Ecg is selected : " + ECG.isDisplayed());
        } catch (Exception e) {
            LogUtil.warning("ECG radio button is not displayed.");
        }

        //4. verify the Spo2 reminder radio button is selectable
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.heartmonitor.android:id/rbSpo2"))).click();
            WebElement Spo2 = driver.findElement(AppiumBy.id("com.heartmonitor.android:id/rbSpo2"));
            LogUtil.info("Spo2 is selected : " + Spo2.isDisplayed());
        } catch (Exception e) {
            LogUtil.warning("Spo2 radio button is not selectable.");
        }

        //5.Heart rate reminder radio button is selectable
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.heartmonitor.android:id/rbHR"))).click();
            WebElement HR = driver.findElement(AppiumBy.id("com.heartmonitor.android:id/rbHR"));
            LogUtil.info("HR is selected : " + HR.isDisplayed());
        } catch (Exception e) {
            LogUtil.warning("Hr reminder radio is not visible");
        }

        //Done button
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.heartmonitor.android:id/txtSubmit"))).click();
            LogUtil.info("Done button click is working.");
        } catch (Exception e) {
            LogUtil.warning("Done button click is not working");
        }

        //Add reminder name
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id
                    ("com.heartmonitor.android:id/edtReminderName"))).sendKeys("Take Heart rate.");
            LogUtil.info("Reminder name is added.");
        } catch (Exception e) {
            LogUtil.warning("Add reminder name is not working.");
        }

        //Selecting the days for the reminder
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.heartmonitor.android:id/txtMUN"))).click();
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.heartmonitor.android:id/txtTHU"))).click();
            LogUtil.info("Selecting the days for reminder is working.");
        } catch (Exception e) {
            LogUtil.warning("Selecting days for the reminder is not working.");
        }

        //Set the time for the reminder
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.heartmonitor.android:id/chipAdd"))).click();
            LogUtil.info("Set time for reminder is working");
        } catch (Exception e) {
            LogUtil.warning("Set time for reminder is not working.");
        }

        //Choose the hour time for the reminder
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("6"))).click();
            LogUtil.info("Choose hour is happen.");
        } catch (Exception e) {
            LogUtil.warning("Choose hour is not happening");
        }

        //Choose the minute time for the reminder
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("0"))).click();
            LogUtil.info("choose minutes is working");
        } catch (Exception e) {
            LogUtil.warning("Choose minute is not working");
        }

        //Confirm the with OK
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("android:id/button1"))).click();
            LogUtil.info("Clicking Ok is working.");
        } catch (Exception e) {
            LogUtil.warning("Clicking Ok is not working");
        }

        //Using + to Adding invite to the reminder
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.heartmonitor.android:id/imgAddReminder"))).click();
            LogUtil.info("invite the people is working.");
        } catch (Exception e) {
            LogUtil.warning("Invite the people is not working.");
        }

        //6.Add the invite to the reminder
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.
                    androidUIAutomator("new UiSelector().text(\"Kavya\")"))).click();
            LogUtil.info("Care circle people is added to the reminder.");
        } catch (Exception e) {
            LogUtil.warning("People is not added to the reminder");
        }

        //Clicking the add invite button
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.heartmonitor.android:id/txtSubmit"))).click();
            LogUtil.info("Invite button click is working.");
        } catch (Exception e) {
            LogUtil.warning("Clicking invite button is not working.");
        }

        //Scrolling to personal note
        try {
            driver.findElement(AppiumBy.androidUIAutomator
                    ("new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(resourceId(\"com.heartmonitor.android:id/edtPersonalNotes\"));")).sendKeys("Take care Your self..");
            LogUtil.info("Scroll to the personal note and added input as well.");
        } catch (Exception e) {
            LogUtil.warning("Scroll to the  personal note is not happen");
        }

        //7.Confirm the reminder
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.heartmonitor.android:id/txtSetReminder"))).click();
            LogUtil.info("Reminder set successfully.");
        } catch (Exception e) {
            LogUtil.warning("Reminder confirmation is not happen.");
        }
    }


    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void TC_016() throws Exception {

        LogUtil.info("Enter into TC_016");

        bs.CoreLoginForAndroid(true);  //basic login scenario

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        //Scrolling to the plus button.
        try {
            driver.findElement(AppiumBy.androidUIAutomator
                    ("new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(resourceId(\"com.heartmonitor.android:id/imgAddReminder\"));"));
        } catch (Exception e) {
            LogUtil.warning("Scroll to the add reminder in the DB is not working");
        }

        //Clicking the plus button
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.heartmonitor.android:id/imgAddReminder"))).click();
            LogUtil.info("Clicking the plus is working");
        } catch (Exception e) {
            LogUtil.warning("plus button is not clicked");
        }

        //Clicking the SpO2 radio button.
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.heartmonitor.android:id/rbSpo2"))).click();
            LogUtil.info("Spo2 radio button is visible and it clicked.");
        } catch (Exception e) {
            LogUtil.warning("Spo2 radio button is not visible for a click.");
        }

        //Clicking the DONE button.
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.heartmonitor.android:id/txtSubmit"))).click();
            LogUtil.info("Done is clicked");
        } catch (Exception e) {
            LogUtil.warning("Done is nor clicked.");
        }

        //CASE - 1
        //1.Selecting the days for the reminder
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.heartmonitor.android:id/txtMUN"))).click();
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.heartmonitor.android:id/txtTHU"))).click();
            LogUtil.info("Days are selected for reminder.");
        } catch (Exception e) {
            LogUtil.warning("Selecting day is not working.");
        }

        //2.Unselect the days in the reminder
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.heartmonitor.android:id/txtMUN"))).click();
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.heartmonitor.android:id/txtTHU"))).click();
            LogUtil.info("De-Selecting the days is happen.");
        } catch (Exception e) {
            LogUtil.warning("De-Selecting the days is not working. ");
        }

        // CASE - 2 & 3
        //Empty reminder name
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.heartmonitor.android:id/edtReminderName")));
            //Confirm the reminder using set reminder button.
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.heartmonitor.android:id/txtSetReminder"))).click();
            //Empty reminder name error will be shown up.
            wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.heartmonitor.android:id/textinput_error")));
            WebElement EmptyReminderName = driver.findElement(AppiumBy.id("com.heartmonitor.android:id/textinput_error"));
            LogUtil.info("Error 1 :" + EmptyReminderName.getText());
        } catch (Exception e) {
            LogUtil.warning("Empty reminder name error is not visible.");
        }

        //Less character error on reminder name.
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.
                    id("com.heartmonitor.android:id/edtReminderName"))).sendKeys("sa");
            //Confirm the reminder using set reminder button.
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.heartmonitor.android:id/txtSetReminder"))).click();
            //Error for less charscter.
            wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.heartmonitor.android:id/textinput_error")));
            WebElement LessCharacterError = driver.findElement(AppiumBy.id("com.heartmonitor.android:id/textinput_error"));
            LogUtil.info("Error 2 :" + LessCharacterError.getText());
        } catch (Exception e) {
            LogUtil.warning("Less character error is not visible");
        }

        //3.
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.
                    id("com.heartmonitor.android:id/edtReminderName"))).sendKeys("Sant");
        } catch (Exception e) {
            LogUtil.warning("name is added");
        }

        //Empty Personal note less character.
        try {
            driver.findElement(AppiumBy.androidUIAutomator
                    ("new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(resourceId(\"com.heartmonitor.android:id/edtPersonalNotes\"));")).sendKeys("Take care");

            //Confirm the reminder using set reminder button.
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.heartmonitor.android:id/txtSetReminder"))).click();

            //Popup for not selecting the day
            wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("android:id/message")));
            WebElement message = driver.findElement(AppiumBy.id("android:id/message"));
            LogUtil.info("Pop up message for days not selected : " + message.getText());
        } catch (Exception e) {
            LogUtil.warning("Days not selected error is not visible.");
        }
    }

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void TC_017() throws Exception {

        LogUtil.info("Enter into TC_017");

        bs.CoreLoginForAndroid(true);  //basic login scenario

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        //Scrolling to the plus button.
        try {
            driver.findElement(AppiumBy.androidUIAutomator
                    ("new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(resourceId(\"com.heartmonitor.android:id/imgAddReminder\"));"));
        } catch (Exception e) {
            LogUtil.warning("Scroll to the reminder is not happen.");
        }

        //Clicking the plus button
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.heartmonitor.android:id/imgAddReminder"))).click();
        } catch (Exception e) {
            LogUtil.warning("Clicking plus is not happen.");
        }

        //Clicking the SpO2 radio button.
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.heartmonitor.android:id/rbSpo2"))).click();
        } catch (Exception e) {
            LogUtil.warning("Selecting SPo2 is not happen.");
        }

        //Clicking the DONE button.
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.heartmonitor.android:id/txtSubmit"))).click();
        } catch (Exception e) {
            LogUtil.warning("Selecting done is not happen.");
        }

        //----------------This scroll is not working-----------------------need to work on that-----------------

        try {
            driver.findElement(AppiumBy.androidUIAutomator
                    ("new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(resourceId(\"com.heartmonitor.android:id/txtSetReminder\"));"));
        } catch (Exception e) {
            LogUtil.warning("Scroll to the element is not working.");
        }

        //Empty Personal note less character.
        try {
            driver.findElement(AppiumBy.androidUIAutomator
                            ("new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(resourceId(\"com.heartmonitor.android:id/edtPersonalNotes\"));"))
                    .sendKeys("Take");
        } catch (Exception e) {
            LogUtil.warning("Empty personal note is not");
        }

        //Confirm the reminder using set reminder button.
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.heartmonitor.android:id/txtSetReminder"))).click();
        } catch (Exception e) {
            LogUtil.warning("Set reminder is not working. ");
        }

        //Error for empty personal note.
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.heartmonitor.android:id/textinput_error")));
            WebElement error1 = driver.findElement(AppiumBy.id("com.heartmonitor.android:id/textinput_error"));
            LogUtil.info("Error 1 :" + error1.getText());
        } catch (Exception e) {
            LogUtil.warning("Empty personal note error is not visible.");
        }

        //Clearing the personal note to get another error
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.heartmonitor.android:id/edtPersonalNotes"))).clear();
        } catch (Exception e) {
            LogUtil.warning("Clearing the personal note.");
        }

        //Confirm the reminder using set reminder button.
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.heartmonitor.android:id/txtSetReminder"))).click();
            //Error for empty personal note.
            wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.heartmonitor.android:id/textinput_error")));
            WebElement error2 = driver.findElement(AppiumBy.id("com.heartmonitor.android:id/textinput_error"));
            LogUtil.info("Error 2 :" + error2.getText());
        } catch (Exception e) {
            LogUtil.warning("Empty personal note error is not visible.");
        }
    }

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void TC_018() throws Exception {

        LogUtil.info("Enter into TC_018");

        bs.CoreLoginForAndroid(true);  //basic login scenario

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        //Scrolling to the plus button.
        try {
            driver.findElement(AppiumBy.androidUIAutomator
                    ("new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(resourceId(\"com.heartmonitor.android:id/imgAddReminder\"));"));
        } catch (Exception e) {
            LogUtil.warning("Scroll to the element is not happen.");
        }

        try {
            //Clicking the plus button
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.heartmonitor.android:id/imgAddReminder"))).click();

            //Clicking the SpO2 radio button.
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.heartmonitor.android:id/rbSpo2"))).click();

            //Clicking the DONE button.
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.heartmonitor.android:id/txtSubmit"))).click();
        } catch (Exception e) {
            LogUtil.warning("New reminder selection for spo2 is not happen.");
        }

        try {
            //reminder name
            wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.
                    id("com.heartmonitor.android:id/edtReminderName"))).sendKeys("SpO2 reminder ");
            //Selecting the required days
            wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.heartmonitor.android:id/txtSUN"))).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.heartmonitor.android:id/txtMUN"))).click();
        } catch (Exception e) {
            LogUtil.warning("Reminder name and days are not selected.");
        }

        try {
            //Click add Button.
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.heartmonitor.android:id/chipAdd"))).click();

            //Selecting the Hour.
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("9"))).click();

            //Selecting the Minutes.
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("15"))).click();

            //Clicking the ok
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("android:id/button1"))).click();
        } catch (Exception e) {
            LogUtil.warning("Set time for the reminder is not happen.");
        }

        //Checking whether the reminder time is added or not.
        WebElement timer = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.heartmonitor.android:id/chipText")));
        LogUtil.info("Timer is added :" + timer.isDisplayed());

        try {
            driver.findElement(AppiumBy.androidUIAutomator
                    ("new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(resourceId(\"com.heartmonitor.android:id/edtPersonalNotes\"));")).sendKeys("Take");
        } catch (Exception e) {
            LogUtil.warning("Scroll is not happen.");
        }

        try {
            //Adding personal notes.
            wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.
                    id("com.heartmonitor.android:id/edtPersonalNotes"))).sendKeys("Take SpO2");

            //Set the reminder
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.heartmonitor.android:id/txtSetReminder"))).click();
            LogUtil.info("Personal note is added.");
        } catch (Exception e) {
            LogUtil.warning("Adding personal note is not happen.");
        }
    }

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void TC_019() throws Exception {

        bs.CoreLoginForAndroid(true);  //basic login scenario

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        //Verify the care circle is present in the screen
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.heartmonitor.android:id/imgOtherProfile")));
            WebElement CareCircle = driver.findElement(AppiumBy.id("com.heartmonitor.android:id/imgOtherProfile"));
            LogUtil.info("Care is present : " + CareCircle.isDisplayed());
            System.out.println();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        try {
            //Care circle button.
            wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.heartmonitor.android:id/imgOtherProfile"))).click();
        } catch (Exception e) {
            LogUtil.warning("care circle button is not visible.");
        }

        //permission
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id
                    ("com.android.packageinstaller:id/permission_allow_button"))).click();
        } catch (Exception e) {
            LogUtil.warning("Permission is not allowed.");
        }

        //Add member
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.heartmonitor.android:id/tvAddMembers"))).click();
        } catch (Exception e) {
            LogUtil.warning("Add member is not happen.");
        }

        //1.clicking the kebab menu
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("More options"))).click();

            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.androidUIAutomator
                    ("new UiSelector().text(\"Delete Care Circle\")"))).click();
        } catch (Exception e) {
            LogUtil.warning("Clicking the kebab for delete care circel is not happen.");
        }

        //Confirmation for deleting the care circle
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("android:id/button1"))).click();
            WebElement SuccessToast = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.heartmonitor.android:id/dialog_layout_toaster")));
            LogUtil.info("Success toast : " + SuccessToast.getText());
        } catch (Exception e) {
            LogUtil.warning("Confirmation Ok for delete care circle is not happen.");
        }
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
