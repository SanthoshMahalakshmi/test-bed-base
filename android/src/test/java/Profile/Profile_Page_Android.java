package Profile;

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
        elementMap.put(RESET_PARAMETER_TEXT, RESET_PARAMETER_TEXT_TASK);
        elementMap.put(MODEL_CLOSE_OK_BUTTON, MODEL_CLOSE_OK_BUTTON_TASK);
        performActions(elementMap, wait);


        Map<By, ElementTask> elementTaskMap = new LinkedHashMap<>();
        elementTaskMap.put(ADJUST_BUTTON_2, ADJUST_BUTTON_2_TASK);
        elementTaskMap.put(SUBMIT_BUTTON, SUBMIT_BUTTON_TASK);
        elementTaskMap.put(KEEP_DEFAULT_BUTTON_2, KEEP_DEFAULT_BUTTON_2_TASK);
        elementTaskMap.put(RESET_PARAMETER_TEXT, RESET_PARAMETER_TEXT_TASK);
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
        elementMap.put(BACK_BUTTON,BACK_BUTTON_TASK);
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

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void TC_032() throws Exception {

        LogUtil.info("Enter into TC_032");


         bs.CoreLoginForAndroid(true);  //basic login scenario

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        //MOTO - Clicking on profile section
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.androidUIAutomator("new UiSelector().text(\"Profile\")"))).click();

        //1. Care circle
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.heartmonitor.android:id/txtCareCircle"))).click();
            LogUtil.info("Care circle is clicked");
        } catch (Exception e) {
            LogUtil.warning("Care circle is not visible.");
        }

        //Care circle header
        try {
            WebElement CC = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.
                    androidUIAutomator("new UiSelector().text(\"Care Circles\")")));
            LogUtil.info("User present in : " + CC.getText() + " page");
        } catch (Exception e) {
            LogUtil.warning("Care circle header is not present.");
        }

        //Care circle list
        try {
            WebElement CareCircle = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.androidUIAutomator
                    ("new UiSelector().className(\"android.view.ViewGroup\").instance(5)")));
            LogUtil.info("My care circle : " + CareCircle.getText());
        } catch (Exception e) {
            LogUtil.warning("Care circle list is not present.");
        }

        //Kebab menu click
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.androidUIAutomator
                    ("new UiSelector().resourceId(\"com.heartmonitor.android:id/ivOptions\").instance(0)"))).click();
        } catch (Exception e) {
            LogUtil.warning("Kebab menu is not clicked.");
        }

        //Edit Care circle header
        try {
            WebElement CCL = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.
                    androidUIAutomator("new UiSelector().text(\"Edit Care Circle\")")));
            LogUtil.info("User present in : " + CCL.getText() + " page");
        } catch (Exception e) {
            LogUtil.warning("Header is not visible.");
        }

        try {
            //Clicking the Edit care circle option
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.
                    androidUIAutomator("new UiSelector().text(\"Edit Care Circle\")"))).click();
        } catch (Exception e) {
            LogUtil.warning("Edit button is not visible for click action.");
        }

        //Allow button
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.
                    id("com.android.packageinstaller:id/permission_allow_button"))).click();
            LogUtil.info("Allowing the app tp access the contact in the app.");
        } catch (Exception e) {
            LogUtil.warning("Allow is not pop-up for permission");
        }

        //Selecting the contact
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.
                    androidUIAutomator("new UiSelector().resourceId(\"com.heartmonitor.android:id/ivProfilePicture\").instance(1)"))).click();
            LogUtil.info("contact is selected for care circle.");
        } catch (Exception e) {
            LogUtil.warning("Contact is not selected.");
        }

        //Add member button
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.heartmonitor.android:id/tvAddMembers"))).click();
            LogUtil.info("Selected member is added to the care circle.");
        } catch (Exception e) {
            LogUtil.warning("Add member is not clicked.");
        }

        //Changing the care circle name input field
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.
                    id("com.heartmonitor.android:id/edtGroupName"))).sendKeys("Family Group");
        } catch (Exception e) {
            LogUtil.warning("Group name is not edited.");
        }

        //Update button
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.heartmonitor.android:id/tvOkay"))).click();
        } catch (Exception e) {
            LogUtil.warning("Update button is not clicked");
        }

        // Clicking the home option
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.
                    androidUIAutomator("new UiSelector().description(\"Navigate up\")"))).click();
        } catch (Exception e) {
            LogUtil.warning("Home button is not clicked.");
        }

        //Clicking on profile section
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.
                    androidUIAutomator("new UiSelector().text(\"Profile\")"))).click();
        } catch (Exception e) {
            LogUtil.warning("Profile section is not clicked. Next action is device section.");
        }

        //Scroll to the bottom.
        try {
            driver.findElement(AppiumBy.androidUIAutomator
                    ("new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(resourceId(\"com.heartmonitor.android:id/txtMyReminder\"));"));
        } catch (Exception e) {
            LogUtil.warning("Scroll to device is not working.");
        }

        //5.Clicking on My devices section.
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.heartmonitor.android:id/txtMyDevice"))).click();
            LogUtil.info("User present in : My device page.");
        } catch (Exception e) {
            LogUtil.warning("Not moved to the connected device page.");
        }

        //Connected device
        try {
            WebElement DeviceName = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.heartmonitor.android:id/txtDeviceName")));
            LogUtil.info("Listed Device : " + DeviceName.getText());
        } catch (Exception e) {
            LogUtil.warning("No connected device list.");
        }

        //Kebab menu on the device section
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.heartmonitor.android:id/imgMenu"))).click();
        } catch (Exception e) {
            LogUtil.warning("Kebab menu is not present.");
        }

        //Connect device option
        WebElement ConnectDevice = null;
        try {
            ConnectDevice = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.
                    androidUIAutomator("new UiSelector().text(\"Connect Device\")")));
            LogUtil.info("Connect device option list is present : " + ConnectDevice.isDisplayed());
            if (ConnectDevice.isDisplayed()) {
                LogUtil.info("User can connect with the listed device by using connect device option.");
            }
            ConnectDevice.click();
        } catch (Exception e) {
            LogUtil.warning("Connected device list is not visible. No device is currently present.");
        }

        //Back
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("Navigate up"))).click();
        } catch (Exception e) {
            LogUtil.warning("Navigate back is not working.");
        }

        //Add Another device option
        try {
            WebElement AddAnother = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.
                    id("com.heartmonitor.android:id/txtAddAnotherDevice")));
            if (AddAnother.isDisplayed() == true) {
                LogUtil.info("User can able to another device.");
            }
        } catch (Exception e) {
            LogUtil.warning("Add another device is not clicked.");
        }

        //Device connection video
        try {
            WebElement Video = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.heartmonitor.android:id/imgVideoImage")));
            if (Video.isDisplayed()) {
                LogUtil.info("User can get to know the how the device work.");
            }
        } catch (Exception e) {
            LogUtil.warning("Video reference is not present.");
        }

        //MOTO - Clicking on profile section
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.androidUIAutomator("new UiSelector().text(\"Profile\")"))).click();
        } catch (Exception e) {
            LogUtil.warning("Not moving to profile page. after device page.");
        }

        //Scroll to the bottom.
        try {
            driver.findElement(AppiumBy.androidUIAutomator
                    ("new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(resourceId(\"com.heartmonitor.android:id/txtMyReminder\"));"));
        } catch (Exception e) {
            LogUtil.warning("Not scroll to the bottom to the reminder section.");
        }

        //6.Clicking on my reminder
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.heartmonitor.android:id/txtMyReminder"))).click();
            LogUtil.info("Reminder section is clicked.");
        } catch (Exception e) {
            LogUtil.warning("Reminder section is not clicked.");
        }

        //My reminder header
        try {
            WebElement MyR = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.
                    androidUIAutomator("new UiSelector().text(\"My Reminders\")")));
            LogUtil.info("User present in : " + MyR.getText() + " page");
        } catch (Exception e) {
            LogUtil.warning("Reminder header is not present.");
        }

        //Reminder list
        try {
            WebElement Reminder_1 = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.androidUIAutomator
                    ("new UiSelector().resourceId(\"com.heartmonitor.android:id/rlMainItem\").instance(0)")));
            LogUtil.info("Reminder details : " + Reminder_1.getText());
        } catch (Exception e) {
            LogUtil.warning("Reminder is not present currently.");
        }

        //Update reminder header
        try {
            WebElement upr = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.androidUIAutomator("new UiSelector().text(\"Update Reminder\").instance(0)")));
            LogUtil.info("User present in : " + upr.getText() + " page");
        } catch (Exception e) {
            LogUtil.warning("Reminder is not present for edit.");
        }

        //Edit the reminder name
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.
                    id("com.heartmonitor.android:id/edtReminderName"))).sendKeys("BP reminder.");
        } catch (Exception e) {
            LogUtil.warning("Editing the reminder is not worked.");
        }

        //Adding reminder
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.androidUIAutomator
                    ("new UiSelector().resourceId(\"com.heartmonitor.android:id/menu_add\")"))).click();
            LogUtil.info("Trying to add New reminder.");
        } catch (Exception e) {
            LogUtil.warning("Add ned reminder button is not present.");
        }

        //Reminder list with default blood pressure radio button selected. clicking on done button.
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.heartmonitor.android:id/txtSubmit"))).click();
            LogUtil.info("Adding reminder for default selected reminder set.");
        } catch (Exception e) {
            LogUtil.warning("Submit button is not clicked.");
        }

        try {
            //Reminder name
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id
                    ("com.heartmonitor.android:id/edtReminderName"))).sendKeys("Blood pressure reminder.");
        } catch (Exception e) {

            LogUtil.warning("Reminder name is not added.");
        }

        //Selecting the Day
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.heartmonitor.android:id/txtTUE"))).click();
        } catch (Exception e) {
            LogUtil.warning("Day selecting is not happen.");
        }

        try {
            //Add time
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.heartmonitor.android:id/chipAdd"))).click();
            //Selecting time
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("3"))).click();
            //Selecting minutes
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("30"))).click();
            //Confirm with ok
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("android:id/button1"))).click();
        } catch (Exception e) {
            LogUtil.warning("Add time is not happen.");
        }

        //Scroll to the bottom.
        try {
            driver.findElement(AppiumBy.androidUIAutomator
                    ("new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(resourceId(\"com.heartmonitor.android:id/edtPersonalNotes\"));"));
        } catch (Exception e) {
            LogUtil.warning("Scroll to the bottom is not working.");
        }

        //Personal note
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.heartmonitor.android:id/edtPersonalNotes"))).sendKeys("Take care.");
        } catch (Exception e) {
            LogUtil.warning("Personal note is not added.");
        }

        //Set reminder button
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.heartmonitor.android:id/txtSetReminder"))).click();
        } catch (Exception e) {
            LogUtil.warning("Set reminder button is not clicked.");
        }

        //Deleting the reminder
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.
                    androidUIAutomator("new UiSelector().resourceId(\"com.heartmonitor.android:id/imgDelete\").instance(1)"))).click();
            //Confirmation
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("android:id/button1"))).click();
            LogUtil.warning("Reminder is deleted.");
        } catch (Exception e) {
            LogUtil.warning("Deleting reminder is not happen, may be reminder is not present");
        }

        //reminder deleted meg
        try {
            WebElement ReminderDeleteMeg = wait.until(ExpectedConditions.
                    visibilityOfElementLocated(AppiumBy.id("android:id/message")));
            LogUtil.info("Deleted Message : " + ReminderDeleteMeg.getText());
            LogUtil.info("Reminder is deleted.");
            //Confirm ok
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("android:id/button1"))).click();
        } catch (Exception e) {
            LogUtil.warning("Deleted message is not coming bcz none of the delete reminder is deleted.");
        }

        //Back to home page
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("Navigate up"))).click();
        } catch (Exception e) {
            LogUtil.warning("Navigate back is not working at last.");
        }

    }

}
