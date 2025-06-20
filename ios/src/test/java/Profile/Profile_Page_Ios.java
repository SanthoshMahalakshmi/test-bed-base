package Profile;

import Actions.iOSActionType;
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
import static iOSElemenRepositories.iOSCommonElements.*;
import static iOSElemenRepositories.iOSDeviceScreenElements.*;
import static iOSElemenRepositories.iOSProfileScreenElements.*;

public class Profile_Page_Ios extends DriverManager {

    BaseLoginForiOS baseLoginForiOS = new BaseLoginForiOS();

    @Test(retryAnalyzer = RetryAnalyzerios.class)
    public void TC_029() {

        baseLoginForiOS.BaseLoginForIos(false);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        Map<By, iOSElementTask> iOSElementMap = new LinkedHashMap<>();

        /*Pre-Request*/
        iOSElementMap.put(iOS_PROFILE_BUTTON, iOS_PROFILE_BUTTON_TASK);

        iOSElementMap.put(iOS_PROFILE_COACH_MARK_SKIP, iOS_PROFILE_COACH_MARK_SKIP_TASK);

        /*Actual TestCase*/
        iOSElementMap.put(iOS_PARAMETER_RANGE_BUTTON, iOS_PARAMETER_RANGE_BUTTON_TASK);

        iOSElementMap.put(iOS_KEEP_DEFAULT_BUTTON_1, new iOSElementTask.Builder(iOSActionType.VERIFY, "Keep Default ").build());

        iOSElementMap.put(iOS_ADJUST_BUTTON_1, iOS_ADJUST_BUTTON_1_TASK);

        iOSElementMap.put(iOS_SUBMIT_BUTTON, iOS_SUBMIT_BUTTON_TASK);

        performIOSActions(iOSElementMap, wait);


        Map<By, iOSElementTask> iOSElementTaskMap = new LinkedHashMap<>();

        iOSElementTaskMap.put(iOS_KEEP_DEFAULT_BUTTON_2, new iOSElementTask.Builder(iOSActionType.VERIFY, "Keep Default ").build());

        iOSElementTaskMap.put(iOS_ADJUST_BUTTON_2, iOS_ADJUST_BUTTON_2_TASK);

        iOSElementTaskMap.put(iOS_SUBMIT_BUTTON, iOS_SUBMIT_BUTTON_TASK);

        performIOSActions(iOSElementTaskMap, wait);
    }

    @Test(retryAnalyzer = RetryAnalyzerios.class)
    public void TC_030() {
        baseLoginForiOS.BaseLoginForIos(false); //Login process.

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        Map<By, iOSElementTask> iOSElementMap1 = new LinkedHashMap<>();
        iOSElementMap1.put(iOS_PROFILE_BUTTON, iOS_PROFILE_BUTTON_TASK);
        iOSElementMap1.put(iOS_PROFILE_COACH_MARK_SKIP, iOS_PROFILE_COACH_MARK_SKIP_TASK);
        iOSElementMap1.put(iOS_CONSUME_EDIT_BUTTON, iOS_CONSUME_EDIT_BUTTON_TASK);
        iOSElementMap1.put(iOS_BACK_BUTTON, iOS_BACK_BUTTON_TASK);
        performIOSActions(iOSElementMap1, wait);


        Map<By, iOSElementTask> iOSElementMap2 = new LinkedHashMap<>();
        iOSElementMap2.put(iOS_PARAMETER_RANGE_BUTTON, iOS_PARAMETER_RANGE_BUTTON_TASK);
        iOSElementMap2.put(iOS_BACK_BUTTON, iOS_BACK_BUTTON_TASK);
        performIOSActions(iOSElementMap2, wait);

        Map<By, iOSElementTask> iOSElementMap3 = new LinkedHashMap<>();
        iOSElementMap3.put(iOS_MY_DEPENDENT_BUTTON, iOS_MY_DEPENDENT_BUTTON_TASK);
        iOSElementMap3.put(iOS_HOME_BUTTON, iOS_HOME_BUTTON_TASK);
        performIOSActions(iOSElementMap3, wait);

    }

    @Test(retryAnalyzer = RetryAnalyzerios.class)
    public void TC_031() {

         baseLoginForiOS.BaseLoginForIos(false);//Login process.

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        Map<By, iOSElementTask> iOSElementMap = new LinkedHashMap<>();

        iOSElementMap.put(iOS_PROFILE_BUTTON, iOS_PROFILE_BUTTON_TASK);

        iOSElementMap.put(iOS_PROFILE_COACH_MARK_SKIP, iOS_PROFILE_COACH_MARK_SKIP_TASK);

        iOSElementMap.put(iOS_CARE_CIRCLE_BUTTON, iOS_CARE_CIRCLE_BUTTON_TASK);

        iOSElementMap.put(iOS_HOME_BUTTON, iOS_HOME_BUTTON_TASK);

        performIOSActions(iOSElementMap, wait);


        Map<By, iOSElementTask> iOSElementMap1 = new LinkedHashMap<>();

        iOSElementMap1.put(iOS_PROFILE_BUTTON, iOS_PROFILE_BUTTON_TASK);

        iOSElementMap1.put(iOS_MY_DEVICE_BUTTON, iOS_MY_DEVICE_BUTTON_TASK);

        iOSElementMap1.put(iOS_DEVICE_COACH_MARK_FINISH_BUTTON, iOS_DEVICE_COACH_MARK_FINISH_BUTTON_TASK);

        performIOSActions(iOSElementMap1, wait);

        Map<By, iOSElementTask> iOSElementMap2 = new LinkedHashMap<>();

        iOSElementMap2.put(iOS_PROFILE_BUTTON, iOS_PROFILE_BUTTON_TASK);

        iOSElementMap2.put(iOS_MY_REMINDER_BUTTON, iOS_MY_REMINDER_BUTTON_TASK);

        performIOSActions(iOSElementMap2, wait);

    }

    @Test(enabled = true, retryAnalyzer = RetryAnalyzerios.class)
    public void TC_032() throws Exception {
         baseLoginForiOS.BaseLoginForIos(true);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        //MOTO - Clicking on profile section
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//XCUIElementTypeButton[@name=\"Profile\"]"))).click();

        //1. Care circle
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//XCUIElementTypeStaticText[@name=\"Care Circle\"]"))).click();
            LogUtil.info("Care circle is clicked");
        } catch (Exception e) {
            LogUtil.warning("Care circle is not visible.");
        }

        //Care circle header
        try {
            WebElement CC = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.
                    xpath("//XCUIElementTypeStaticText[@name=\"Care Circles\"]")));
            LogUtil.info("User present in : " + CC.getText() + " page");
        } catch (Exception e) {
            LogUtil.warning("Care circle header is not present.");
        }

        //Care circle list
        try {
            WebElement CareCircle = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.
                    xpath("//XCUIElementTypeTable/XCUIElementTypeCell[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther")));
            LogUtil.info("My care circle : " + CareCircle.getText());
        } catch (Exception e) {
            LogUtil.warning("Care circle list is not present.");
        }

        //Kebab menu click >>>>IMPORTANT Bug-Not able to inspect the kebab menu in care circle list
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.androidUIAutomator
                    ("new UiSelector().resourceId(\"com.moai.android:id/ivOptions\").instance(0)"))).click();
        } catch (Exception e) {
            LogUtil.warning("Kebab menu is not clicked.");
        }

        //Edit Care circle header
        try {
            WebElement CCL = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.
                    xpath("//XCUIElementTypeStaticText[@name=\"Edit Care Circle\"]")));
            LogUtil.info("User present in : " + CCL.getText() + " page");
        } catch (Exception e) {
            LogUtil.warning("Header is not visible.");
        }

        try {  /*bug EDIT CARE CIRCLE OPTION IS NOT VISIBLE BCZ OF KEBAB MENU NOT AVAILABLE IN THE DOM.*/
            //Clicking the Edit care circle option
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.
                    xpath("new UiSelector().text(\"Edit Care Circle\")"))).click();
        } catch (Exception e) {
            LogUtil.warning("Edit button is not visible for click action.");
        }

        //Allow button  /*ALLOW option is not visible for ios.*/
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.
                    id("com.android.packageinstaller:id/permission_allow_button"))).click();
            LogUtil.info("Allowing the app tp access the contact in the app.");
        } catch (Exception e) {
            LogUtil.warning("Allow is not pop-up for permission");
        }

        /*Clicking on the plus button to add member.*/
        try{
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.
                    xpath("//XCUIElementTypeButton[@name=\"Plus\"]"))).click();

            LogUtil.info("Add contact button is clicked");
        }
        catch (Exception e) {
            LogUtil.warning("Plus button is not visible for click action.");
        }

        //select the member to the care circle.
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.
                    xpath("//XCUIElementTypeTable/XCUIElementTypeCell/XCUIElementTypeOther[1]/XCUIElementTypeOther"))).click();
            LogUtil.info("Add contact button is clicked");
        } catch (Exception e) {
            LogUtil.warning("Add contact button is not visible.");
        }

        //Add member button clicking.
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.
                    xpath("(//XCUIElementTypeStaticText[@name=\"Add Members\"])[3]"))).click();
            LogUtil.info("Selected member is added to the care circle.");
        } catch (Exception e) {
            LogUtil.warning("Member is not added.");
        }

        //Changing the care circle name input field
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.
                    xpath("//XCUIElementTypeTextField[@value=\"san's फ़ैमिली\"]"))).sendKeys("Family Group");
        } catch (Exception e) {
            LogUtil.warning("Group name is not edited.");
        }

        //Update button
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//XCUIElementTypeStaticText[@name=\"Update\"]"))).click();
        } catch (Exception e) {
            LogUtil.warning("Update button is not clicked");
        }

        // Clicking the home option
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.
                    androidUIAutomator("ic home header"))).click();
        } catch (Exception e) {
            LogUtil.warning("Home button is not clicked.");
        }

        //Clicking on profile section
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.
                    xpath("//XCUIElementTypeButton[@name=\"Profile\"]"))).click();
        } catch (Exception e) {
            LogUtil.warning("Profile section is not clicked. Next action is device section.");
        }

        //Scroll to the set reminder.
        try {
            driver.findElement(AppiumBy.iOSClassChain(
                    "**/XCUIElementTypeScrollView[`visible == 1`]" +
                            "/XCUIElementTypeStaticText[`name == 'My Reminders'`]"));
        } catch (Exception e) {
            LogUtil.warning("Scroll to device is not working.");
        }

        //5.Clicking on My devices section.
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.
                    xpath("//XCUIElementTypeStaticText[@name=\"My Devices\"]"))).click();
            LogUtil.info("User present in : My device page.");
        } catch (Exception e) {
            LogUtil.warning("Not moved to the connected device page.");
        }

        //Connected device list
        try {
            WebElement DeviceName = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.
                    xpath("//XCUIElementTypeCell/XCUIElementTypeOther[1]/XCUIElementTypeOther")));
            LogUtil.info("Listed Device : " + DeviceName.getText());
        } catch (Exception e) {
            LogUtil.warning("No connected device list.");
        }

        //Kebab menu on the device section
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.
                    xpath("//XCUIElementTypeCell/XCUIElementTypeButton"))).click();
        } catch (Exception e) {
            LogUtil.warning("Kebab menu is not present.");
        }

        //Connect device option
        WebElement ConnectDevice = null;
        try {
            ConnectDevice = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.
                    xpath("//XCUIElementTypeStaticText[@name=\"Connect Device\"]")));
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
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("ic back"))).click();
        } catch (Exception e) {
            LogUtil.warning("Navigate back is not working.");
        }

        //Add Another device option
        try {
            WebElement AddAnother = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.
                    xpath("//XCUIElementTypeStaticText[@name=\"Add Another Device\"]")));
            if (AddAnother.isDisplayed() == true) {
                LogUtil.info("User can able to another device.");
            }
        } catch (Exception e) {
            LogUtil.warning("Add another device is not clicked.");
        }

        //Device connection video
        try {
            WebElement Video = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.
                    iOSClassChain("**/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther" +
                            "/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther" +
                            "/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeButton[1]")));
            if (Video.isDisplayed()) {
                LogUtil.info("User can get to know how the device work.");
            }
        } catch (Exception e) {
            LogUtil.warning("Video reference is not present.");
        }

        //MOTO - Clicking on profile section
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.
                    xpath("//XCUIElementTypeImage[@name=\"ic_profile\"]"))).click();
        } catch (Exception e) {
            LogUtil.warning("Not moving to profile page. after device page.");
        }

        //Scroll to the bottom.
        try {
            driver.findElement(AppiumBy.iOSClassChain(
                    "**/XCUIElementTypeScrollView[`visible == 1`]" +
                            "/XCUIElementTypeStaticText[`name == 'My Reminders'`]"));
        } catch (Exception e) {
            LogUtil.warning("Not scroll to the bottom to the reminder section.");
        }

        //6.Clicking on my reminder
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.
                    xpath("//XCUIElementTypeStaticText[@name=\"My Reminders\"]"))).click();
            LogUtil.info("Reminder section is clicked.");
        } catch (Exception e) {
            LogUtil.warning("Reminder section is not clicked.");
        }

        //My reminder header
        try {
            WebElement MyR = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.
                    xpath("//XCUIElementTypeStaticText[@name=\"My Reminders\"]")));
            LogUtil.info("User present in : " + MyR.getText() + " page");
        } catch (Exception e) {
            LogUtil.warning("Reminder header is not present.");
        }

        //Reminder list
        try {
            WebElement Reminder_1 = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.
                    xpath("//XCUIElementTypeCell/XCUIElementTypeOther[1]/XCUIElementTypeOther")));
            LogUtil.info("Reminder details : " + Reminder_1.getText());
        } catch (Exception e) {
            LogUtil.warning("Reminder is not present currently.");
        }

        //Update reminder
        WebElement upr = null;
        try {
             wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.
                    xpath("//XCUIElementTypeCell/XCUIElementTypeOther[1]/XCUIElementTypeOther"))).click();
            LogUtil.info("User present in : " + upr.getText() + " page");
        } catch (Exception e) {
            LogUtil.warning("Reminder is not present for edit.");
        }

        //Edit the reminder name
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.
                    className("XCUIElementTypeTextField"))).sendKeys("BP reminder.");
            /*Update reminder button clicking.*/
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.
                    xpath("(//XCUIElementTypeStaticText[@name=\"Update Reminder\"])[2]"))).click();
        } catch (Exception e) {
            LogUtil.warning("Editing the reminder is not worked.");
        }

        //Adding reminder
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("plush icon"))).click();
            LogUtil.info("Trying to add New reminder.");
        } catch (Exception e) {
            LogUtil.warning("Add new reminder button is not present.");
        }

        //Reminder list pop.
        try {
            /*Selecting the bp reminder.*/
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("(//XCUIElementTypeButton[@name=\"radioUnSelection\"])[1]"))).click();
            /*submit button click.*/
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//XCUIElementTypeButton[@name=\"Done\"]"))).click();

            LogUtil.info("Adding reminder for default selected reminder set.");
        } catch (Exception e) {
            LogUtil.warning("Submit button is not clicked.");
        }

        try {
            //Reminder name
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.
                    className("XCUIElementTypeTextField"))).sendKeys("Blood pressure reminder.");
        } catch (Exception e) {

            LogUtil.warning("Reminder name is not added.");
        }

        //Selecting the Day
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("SUN"))).click();
        } catch (Exception e) {
            LogUtil.warning("Day selecting is not happen.");
        }

        try {
            //select time with current time by default is in current time.
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("Add"))).click();
            //Confirm with done
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("Done"))).click();
        } catch (Exception e) {
            LogUtil.warning("Add time is not happen.");
        }

        //Personal note
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.
                    className("XCUIElementTypeTextView"))).sendKeys("Take care.");
        } catch (Exception e) {
            LogUtil.warning("Personal note is not added.");
        }

        //Set reminder button
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.
                    iOSClassChain("**/XCUIElementTypeStaticText[`name == \"Set Reminder\"`][2]"))).click();
        } catch (Exception e) {
            LogUtil.warning("Set reminder button is not clicked.");
        }

        //Deleting the reminder
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.
                    iOSClassChain("**/XCUIElementTypeButton[`name == \"ic delete\"`][1]"))).click();
            //Confirmation
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("Yes"))).click();
            LogUtil.warning("Reminder is deleted.");
        } catch (Exception e) {
            LogUtil.warning("Deleting reminder is not happen, may be reminder is not present");
        }

        //reminder deleted meg Important-Bug reminder delete message is not coming for ios
        try {
            WebElement ReminderDeleteMeg = wait.until(ExpectedConditions.
                    visibilityOfElementLocated(AppiumBy.id("android:id/message")));
            LogUtil.info("Deleted Message : " + ReminderDeleteMeg.getText());
            LogUtil.info("Reminder is deleted.");
            //Confirm ok
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("android:id/button1"))).click();
            LogUtil.info("Reminder is deleted.");
        } catch (Exception e) {
            LogUtil.warning("Deleted message is not coming bcz none of the delete reminder is deleted.");
        }

        //Back to home page
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("ic back"))).click();
        } catch (Exception e) {
            LogUtil.warning("Navigate back is not working at last.");
        }
    }

}
