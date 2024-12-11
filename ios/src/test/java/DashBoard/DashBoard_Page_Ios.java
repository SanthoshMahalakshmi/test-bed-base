package DashBoard;

import DriverManagerIos.DriverManager;
import UtilitiesForIos.RetryAnalyzerios;
import browserstack.shaded.org.eclipse.jgit.diff.Edit;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.NoSuchElementException;

public class DashBoard_Page_Ios extends DriverManager {

    private static final Logger log = LoggerFactory.getLogger(DashBoard_Page_Ios.class);

    @Test(retryAnalyzer = RetryAnalyzerios.class)
    public void TC_010() {
        BaseLoginForIos();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        //1.Verify the LOGO text present in the top.
        WebElement LogoText = null;
        try {
            LogoText = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.
                    iOSClassChain("**/XCUIElementTypeStaticText[`name == \"MoAI\"`]")));
            logger.info("Logo text : " + LogoText.getText());
            logger.info("Logo text is present : " + LogoText.isDisplayed());
        } catch (Exception e) {
            logger.warning("Logo is not present in dash board");
        }

        //2.Verify the Sync button.
        WebElement SyncData = null;
        try {
            SyncData = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.accessibilityId("ic sync")));
            logger.info("Sync data button is present : " + SyncData.isDisplayed());
            SyncData.click();
        } catch (Exception e) {
            logger.warning("Sync button is not present dash board.");
        }

        WebElement SyncInfo_Message = null;
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.
                    accessibilityId("Device disconnected")));
            logger.info("Sync button info message for device not connected :" + SyncInfo_Message.getText());
        } catch (Exception e) {
            logger.warning("Info message for device not connected is not found.");
        }

        WebElement SyncClose_icon = null;
        try {
            SyncClose_icon = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("error_icon")));
            logger.info("error_icon button is found its clicked :" + SyncClose_icon.isDisplayed());
            SyncClose_icon.click();
        } catch (Exception e) {
            logger.warning("error_icon button is not found.");
        }

        //3.Notification button.
        WebElement NotificationButton = null;
        try {
            NotificationButton = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.accessibilityId("ic notification")));
            logger.info("Notification button is present : " + NotificationButton.isDisplayed());
            NotificationButton.click();
        } catch (Exception e) {
            logger.warning("Notification button is not present.");
        }

        //4.Seeing the notification and clearing them
        WebElement Actual_Notifications = null;
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.
                    iOSClassChain("**/XCUIElementTypeButton[`name == \"Decline\"`][1]")));
            logger.info("Notification is present? : " + Actual_Notifications.isDisplayed());
        } catch (Exception e) {
            logger.warning("No notification are present currently.");
        }

        //5. clearing them
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("ic clearAllNotification"))).click();
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("Yes"))).click();
            logger.info("Clear button is found and it's cleared all the notifications");
        } catch (Exception e) {
            logger.warning("Clear button is not present currently, there is no notification");
        }

        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("ic back"))).click();
        } catch (Exception e) {
            logger.warning("Navigate back is not happen currently.");
        }

        //6.Device indication¡ /*in process*/
        WebElement deviceIndication = null;
        try {
            deviceIndication = driver.findElement(AppiumBy.androidUIAutomator
                    ("new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(resourceId(\"com.moai.android:id/view5\"));"));
            logger.info("Heath scroll is present :" + deviceIndication.isDisplayed());
        } catch (Exception e) {
            logger.warning("Health scroll is not visible, may be the screen is not scrolled.");
        }

        //Scrolling to heath score section.
        WebElement HealthScore = null;
        try {
            HealthScore = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.accessibilityId("Health Score")));
            logger.info("Health Score is present : " + HealthScore.getText());
        } catch (Exception e) {
            logger.warning("Health scroll is not visible, may be the screen is not scrolled.");
        }
    }

    @Test(retryAnalyzer = RetryAnalyzerios.class)
    public void TC_011() {

        BaseLoginForIos(); // To complete the login process.

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        //1.Verify My dependent section.
        WebElement MyDependent = null;
        try {
            MyDependent = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.accessibilityId("My Dependents")));
            logger.info("My dependent section is present : " + MyDependent.isDisplayed());
        } catch (Exception e) {
            logger.warning("My dependent section is not visible.");
        }

        //2.Add new dependent plus.
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("+2"))).click();
            //My Dependent details page, new journey for adding dependent. user should cross all the 5 pages.
            wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.accessibilityId("Basic Details")));
            logger.info("User can add new Dependent ");
        } catch (Exception e) {
            logger.warning("Add new dependent is not happening.");
        }

        //Home button, moving back to dashboard.
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("ic back"))).click();
            logger.info("Moving back to dashboard.");
        } catch (Exception e) {
            logger.warning("Moving back to home is not happening.");
        }

        //3.Verify new dependent in the dashboard
        WebElement NewDependent = null;
        try {
            NewDependent = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.
                    xpath("//XCUIElementTypeScrollView/XCUIElementTypeOther/XCUIElementTypeOther[1]" +
                            "/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther[2]")));
            logger.warning("Newly added dependent profile is visible : " + NewDependent.isDisplayed());
        } catch (Exception e) {
            logger.warning("New dependent is not added.");
        }

        //4.Dependent profile
        WebElement dependent_profile = null;
        try {
            NewDependent.click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.
                    xpath("//XCUIElementTypeTable/XCUIElementTypeCell[5]/XCUIElementTypeOther[1]/XCUIElementTypeOther")));
            logger.info("Dependent profile is visible : " + dependent_profile.isDisplayed());
        } catch (Exception e) {
            logger.warning("New dependent profile is not visible");
        }

        //Navigate back to the DB
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("ic back"))).click();
        } catch (Exception e) {
            logger.warning("Navigating back dashboard is not happening.");
        }

        //6.Sharing the report detail
        try {
            /*Clicking on share in DB*/
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("ic share"))).click();
            /*Selecting the ECG*/
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.iOSClassChain("**/XCUIElementTypeStaticText[`name == \"ECG\"`][2]"))).click();
            /*Selecting the done*/
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.iOSClassChain("**/XCUIElementTypeButton[`name == \"Done \"`]"))).click();
            /*Selecting the close button*/
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("UICloseButtonBackground"))).click();
            logger.info("Sharing the report is working.");
        } catch (Exception e) {
            logger.warning("Sharing option click is not happening.");
        }

        //7.downloading the reports and sharing to the people from DB.
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("ic donwload"))).click();
            /*Selecting BP for download*/
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.
                    xpath("(//XCUIElementTypeButton[@name=\"ic UnCheckBoxShareReportIcon\"])[1]"))).click();
            /*Selecting ECG for download*/
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.
                    xpath("(//XCUIElementTypeButton[@name=\"ic UnCheckBoxShareReportIcon\"])[2]"))).click();
            /*Selecting the SPO2 download.*/
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.
                    xpath("(//XCUIElementTypeButton[@name=\"ic UnCheckBoxShareReportIcon\"])[3]"))).click();
            /*Selecting the HR download*/
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.
                    xpath("(//XCUIElementTypeButton[@name=\"ic UnCheckBoxShareReportIcon\"])[4]"))).click();
            /*Clicking on done*/
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.
                    iOSClassChain("**/XCUIElementTypeStaticText[`name == \"Done \"`]"))).click();
            logger.info("Sharing the report is working.");
        } catch (Exception e) {
            logger.warning("Downloading the report not working.");
        }
    }

    @Test(retryAnalyzer = RetryAnalyzerios.class)
    public void TC_012() {

        BaseLoginForIos(); // To complete the login process.

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        //verify the care circle section label.
        WebElement careCircleLabel = null;
        try {
            careCircleLabel = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.accessibilityId("Care Circles")));
            logger.info("Care circle label is present : " + careCircleLabel.isDisplayed());
        } catch (Exception e) {
            logger.warning("Care section label is not visible.");
        }

        //2.Clicking the Get stared button
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.
                    iOSClassChain("**/XCUIElementTypeStaticText[`name == \"Get Started\"`]"))).click();
        } catch (Exception e) {
            logger.warning("Clicking on get started is not happening.");
        }

        //Allow the permission for accessing the contact list.
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.accessibilityId("OK"))).click();
            logger.info("Before clicking the plus to add contact, Permission access is popping-up.");
        } catch (Exception e) {
            logger.warning("Before clicking the plus to add contact, Permission access is not popping-up");
        }

        //Add group name for care circle.
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.
                    iOSClassChain("**/XCUIElementTypeTextField[`value == \"Group Name\"`]"))).sendKeys("New group");
            logger.info("group name is added");
        } catch (Exception e) {
            logger.warning("Group name is not added");
        }

        //Clicking the Plus to add contact.
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.
                    accessibilityId("Plus"))).click();
        } catch (Exception e) {
            logger.warning("Clicking the plus button is not happening.");
        }

        //Allow the permission for accessing the contact list.
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.accessibilityId("OK"))).click();
            logger.info("After clicking the plus to add contact, Permission access is popping-up.");
        } catch (Exception e) {
            logger.warning("After clicking the plus to add contact, Permission access is not popping-up");
        }

        //Selecting the contact
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.
                    xpath("//XCUIElementTypeTable/XCUIElementTypeCell[2]/XCUIElementTypeOther[1]/XCUIElementTypeOther"))).click();
            logger.info("Contact is selected for care circle");
        } catch (Exception e) {
            logger.warning("Selecting contact for care circle is not happening.");
        }

        //Add member
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.
                    iOSClassChain("**/XCUIElementTypeStaticText[`name == \"Add Members\"`][3]"))).click();
            logger.info("Add member button is clicked after selected the contact.");
        } catch (Exception e) {
            logger.warning("Add member button is not clicked after selected the contact.");
        }

        //Submit click to create a care circle.
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.
                    iOSClassChain("**/XCUIElementTypeStaticText[`name == \"Submit\"`]"))).click();
            logger.info("Submit button is clicked and care circle is created");
        } catch (Exception e) {
            logger.warning("Submit button is not clicked and care circle is not created.");
        }
    }

    @Test(retryAnalyzer = RetryAnalyzerios.class)
    public void TC_013() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        //To enter into care circle.
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("ic heartHandBlueHomeIcon"))).click();
            logger.info("Enter into care circle happening..");
        } catch (Exception e) {
            logger.warning("Enter into care circle is not happening.");
        }

        //Kebab menu clicking to select the edit care circle option
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("ic dot menu white"))).click();
            logger.info("Kebab menu is clicked to access the edit care circle option");

            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("Edit Care Circle"))).click();
            logger.info("Clicking the edit care circle option.");

        } catch (Exception e) {
            logger.warning("Kebab menu is not clicked to access the edit care circle option");
            logger.warning("Clicking the edit care circle is not happening.");
        }

        //Edit the care circle name with less character and Click the submit to get the error for not enough character.
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.
                    className("XCUIElementTypeTextField"))).sendKeys("R");
            logger.info("Care circle name is changed with less character.");

            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.
                    iOSClassChain("**/XCUIElementTypeStaticText[`name == \"Update\"`]"))).click();
            logger.info("clicking the update button with less group name.");
        } catch (Exception e) {
            logger.warning("Submit button is not working for getting the error of not enough character for group name.");
        }

        //Actual error.
        WebElement error1 = null;
        try {
            error1 = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.accessibilityId("Group name at least 5 characters.")));
            logger.info("Not enough character error : " + error1.getText());
        } catch (Exception e) {
            logger.warning("Error message is not pop-up for less character for care circle group name.");
        }

        //Clearing the input field.
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.className("XCUIElementTypeTextField"))).clear();
            logger.info("Clearing the group name");
        } catch (Exception e) {
            logger.warning("Clearing the group name field is not working.");
        }

        //To get empty input field error, clicking the update.
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.
                    iOSClassChain("**/XCUIElementTypeStaticText[`name == \"Update\"`]"))).click();
            logger.info("Update click is happen with empty group name");
        } catch (Exception e) {
            logger.warning("Update click is not happen with empty group name");
        }

        //Empty group name error.
        WebElement error2 = null;
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.accessibilityId("Please enter group name")));
            logger.info("Empty input field error : " + error2.getText());
        } catch (Exception e) {
            logger.warning("Empty input field error message is not visible.");
        }

    }


    @Test(retryAnalyzer = RetryAnalyzerios.class)
    public void TC_014() {

        BaseLoginForIos();// To complete the login scenario.

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        //To enter into care circle.
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("ic heartHandBlueHomeIcon"))).click();
            logger.info("Enter into care circle happening..");
        } catch (Exception e) {
            logger.warning("Enter into care circle is not happening.");
        }

        //Allow the permission for accessing the contact list.
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.accessibilityId("OK"))).click();
            logger.info("After clicking the plus to add contact, Permission access is popping-up.");
        } catch (Exception e) {
            logger.warning("After clicking the plus to add contact, Permission access is not popping-up");
        }

        //Kebab menu clicking.
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("ic dot menu white"))).click();
            logger.info("Kebab menu is clicked to access the edit care circle option");
        } catch (Exception e) {
            logger.warning("Kebab menu is not clicked to access the edit care circle option");
        }

        //2.(i)Edit care circle option
        WebElement Edit_Care_circle = null;
        try {
            Edit_Care_circle = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("Edit Care Circle")));
            logger.info("Edit care circle option is present " + Edit_Care_circle.isDisplayed());
        } catch (Exception e) {
            logger.warning("");
        }

        //2.(ii)Kebab menu list with set reminder
        WebElement SetReminder = null;
        try {
            SetReminder = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.accessibilityId("Set Reminders")));
            logger.info("Set reminder option is present in the list : " + SetReminder.isDisplayed());
        } catch (Exception e) {
            logger.warning("Set reminder is not visible.");
        }

        //2.(iii)Kebab menu list with Delete care circle
        WebElement DeleteCareCircle = null;
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.accessibilityId("Delete Care Circle")));
            logger.info("Delete care circle option is present in the list : " + DeleteCareCircle.isDisplayed());
        } catch (Exception e) {
            logger.warning("Delete care circle is not visible");
        }

        //3.Clicking on the edit care circle option in the kebab menu
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("Edit Care Circle"))).click();
            logger.info("Clicking the edit care circle");
        } catch (Exception e) {
            logger.warning("Edit care circle click is not happening.");
        }

        //4.Clicking on the update to complete the change.
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.
                    iOSClassChain("**/XCUIElementTypeStaticText[`name == \"Update\"`]"))).click();
            logger.info("Care circle is updated with existing values.");
        } catch (Exception e) {
            logger.warning("Care circle is not updated with existing values.");
        }

    }

    @Test(retryAnalyzer = RetryAnalyzerios.class)
    public void TC_015() {

        BaseLoginForIos(); // To complete the login process.

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(13));

        //pre - Care circle button.
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.accessibilityId("ic heartHandBlueHomeIcon"))).click();
            logger.info("clicking the care circle.");
        } catch (Exception e) {
            logger.warning("Care circle is not visible ");
        }


        //pre - clicking the kebab menu
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("ic dot menu white"))).click();
            logger.info("Kebab menu is clicked in the care circle page.");
        } catch (Exception e) {
            logger.warning("clicking kebab menu is not happening in the care circle page.");
        }

        //1.clicking the Set reminder button in the kebab menu
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.
                    accessibilityId("Set Reminders"))).click();
            logger.info("Set reminder is working.");
        } catch (Exception e) {
            logger.warning("Set reminder from care circle is not happening");
        }

        //2.Verify the blood pressure radio button is selected by default.
        WebElement BP = null;
        try {
            BP = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.
                    iOSClassChain("**/XCUIElementTypeButton[`name == \"radioUnSelection\"`][1]")));
            BP.click();
            logger.info("Bp reminder is selected default : " + BP.isDisplayed());
        } catch (Exception e) {
            logger.warning("Bp radio button is not Enabled.");
        }

        //3.verify the ECG radio button is selectable
        WebElement ECG = null;
        try {
            ECG = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.
                    iOSClassChain("**/XCUIElementTypeButton[`name == \"radioUnSelection\"`][2]")));
            ECG.click();
            logger.info("Ecg is selected : " + ECG.isDisplayed());
        } catch (Exception e) {
            logger.warning("ECG radio button is not displayed.");
        }

        //4. verify the Spo2 reminder radio button is selectable
        WebElement Spo2 = null;
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.
                    iOSClassChain("**/XCUIElementTypeButton[`name == \"radioUnSelection\"`][3]")));
            Spo2.click();
            logger.info("Spo2 is selected : " + Spo2.isDisplayed());
        } catch (Exception e) {
            logger.warning("Spo2 radio button is not selectable.");
        }

        //5.Heart rate reminder radio button is selectable
        WebElement HR = null;
        try {
            HR = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.
                    iOSClassChain("**/XCUIElementTypeButton[`name == \"radioUnSelection\"`][4]")));
            HR.click();
            logger.info("HR is selected : " + HR.isDisplayed());
        } catch (Exception e) {
            logger.warning("Hr reminder radio is not visible");
        }

        //Done button
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.
                    iOSClassChain("**/XCUIElementTypeButton[`name == \"Done\"`]"))).click();
            logger.info("Done button click is working.");
        } catch (Exception e) {
            logger.warning("Done button click is not working");
        }

        //Add reminder name
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy
                            .iOSClassChain("**/XCUIElementTypeTextField[`value == \"Reminder Name\"`]")))
                    .sendKeys("Take Heart rate.");
            logger.info("Reminder name is added.");
        } catch (Exception e) {
            logger.warning("Add reminder name is not working.");
        }

        //Selecting the days for the reminder
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("MON"))).click();
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("TUE"))).click();
            logger.info("Selecting the days for reminder is working.");
        } catch (Exception e) {
            logger.warning("Selecting days for the reminder is not working.");
        }

        //Set the time for the reminder
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("Add"))).click();
            logger.info("Set time for reminder is working");
        } catch (Exception e) {
            logger.warning("Set time for reminder is not working.");
        }

        //clicking the done to Choose the Current time for the reminder.
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("Done"))).click();
            logger.info("choose minutes is working");
        } catch (Exception e) {
            logger.warning("Choose minute is not working");
        }

        //Using + to Adding invite to the reminder
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("Plus"))).click();
            logger.info("invite the people is working.");
        } catch (Exception e) {
            logger.warning("Invite the people is not working.");
        }

        //6.Add the invite to the reminder
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy
                    .xpath("//XCUIElementTypeTable/XCUIElementTypeCell/XCUIElementTypeOther[1]/XCUIElementTypeOther"))).click();
            logger.info("Care circle people is added to the reminder.");
        } catch (Exception e) {
            logger.warning("People is not added to the reminder");
        }

        //Clicking the add invite button
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy
                    .accessibilityId("**/XCUIElementTypeButton[`name == \"Add Invitee\"`]"))).click();
            logger.info("Invite button click is working.");
        } catch (Exception e) {
            logger.warning("Clicking invite button is not working.");
        }

        //Scrolling to personal note
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy
                            .iOSClassChain("**/XCUIElementTypeTextView[`value == \"Personal Notes\"`]")))
                    .sendKeys("Take care of yourself.");
            logger.info("Scroll to the personal note and added input as well.");
        } catch (Exception e) {
            logger.warning("Scroll to the  personal note is not happen");
        }

        //7.Confirm the reminder
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy
                    .iOSClassChain("**/XCUIElementTypeButton[`name == \"Set Reminder\"`]"))).click();
            logger.info("Reminder set successfully.");
        } catch (Exception e) {
            logger.warning("Reminder confirmation is not happen.");
        }
    }


    @Test(retryAnalyzer = RetryAnalyzerios.class)
    public void TC_016() {

        BaseLoginForIos();// To complete the login process.

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        //Clicking the plus button for set reminder.
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy
                            .iOSClassChain("**/XCUIElementTypeButton[`name == \"Plus\"`][2]")))
                    .click();
            logger.info("Clicking the plus is working");
        } catch (Exception e) {
            logger.warning("plus button is not clicked");
        }

        //Clicking the SpO2 radio button.
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy
                            .iOSClassChain("**/XCUIElementTypeButton[`name == \"radioUnSelection\"`][3]")))
                    .click();
            logger.info("Spo2 radio button is visible and it clicked.");
        } catch (Exception e) {
            logger.warning("Spo2 radio button is not visible for a click.");
        }

        //Clicking the DONE button.
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy
                            .iOSClassChain("**/XCUIElementTypeButton[`name == \"Done\"`]")))
                    .click();
            logger.info("Done is clicked");
        } catch (Exception e) {
            logger.warning("Done is not clicked.");
        }

        //CASE - 1
        //1.Selecting the days for the reminder
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("MON"))).click();
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("WED"))).click();
            logger.info("Days are selected for reminder.");
        } catch (Exception e) {
            logger.warning("Selecting day is not working.");
        }

        //2.Unselect the days in the reminder
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("MON"))).click();
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("WED"))).click();
            logger.info("De-Selecting the days is happen.");
        } catch (Exception e) {
            logger.warning("De-Selecting the days is not working. ");
        }

        // CASE - 2 & 3
        //Empty reminder name
        WebElement EmptyReminderName = null;
        try {
            //Confirm the reminder using set reminder button.
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy
                            .iOSClassChain("**/XCUIElementTypeButton[`name == \"Set Reminder\"`]")))
                    .click();
            //Empty reminder name error will be shown up.
            wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.accessibilityId("Please enter reminder name")));
            logger.info("Error 1 :" + EmptyReminderName.getText());
        } catch (Exception e) {
            logger.warning("Empty reminder name error is not visible.");
        }

        //Less character error on reminder name.
        WebElement LessCharacterError = null;
        try {
            //Reminder name is added.
            wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy
                            .iOSClassChain("**/XCUIElementTypeTextField[`value == \"Reminder Name\"`]")))
                    .sendKeys("sa");
            //Adding personal note.
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy
                            .className("XCUIElementTypeTextView")))
                    .sendKeys("Take care");

            //Confirm the reminder using set reminder button.
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy
                            .iOSClassChain("**/XCUIElementTypeButton[`name == \"Set Reminder\"`]")))
                    .click();

            //Error for less character.
            wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy
                    .accessibilityId("Reminder name should be at least 3 characters")));
            logger.info("Error 2 :" + LessCharacterError.getText());
        } catch (Exception e) {
            logger.warning("Less character error is not visible");
        }

        //3. error message for not selected day.
        WebElement DaysNotSelected = null;
        try {
            //Reminder name is added.
            wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy
                            .iOSClassChain("**/XCUIElementTypeTextField[`value == \"Reminder Name\"`]")))
                    .sendKeys("reminder");
            //Adding personal note.
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy
                            .className("XCUIElementTypeTextView")))
                    .sendKeys("Take care");

            //Confirm the reminder using set reminder button.
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy
                            .iOSClassChain("**/XCUIElementTypeButton[`name == \"Set Reminder\"`]")))
                    .click();

            //Error for days not selected character.
            wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy
                    .accessibilityId("Please select day(s)")));
            logger.info("Error 2 :" + DaysNotSelected.getText());
        } catch (Exception e) {
            logger.warning("name is added");
        }

    }

    @Test(retryAnalyzer = RetryAnalyzerios.class)
    public void TC_017() {

        BaseLoginForIos(); // To complete the login process.

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        //Clicking the plus button for set reminder.
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy
                            .iOSClassChain("**/XCUIElementTypeButton[`name == \"Plus\"`][2]")))
                    .click();
            logger.info("Clicking the plus is working");
        } catch (NoSuchElementException e) {
            logger.warning("Plus button for set reminder is not found.");
        }

        //Clicking the SpO2 radio button.
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy
                            .iOSClassChain("**/XCUIElementTypeButton[`name == \"radioUnSelection\"`][3]")))
                    .click();
            logger.info("Spo2 radio button is visible and it clicked.");
        } catch (Exception e) {
            logger.warning("Spo2 radio button is not visible for a click.");
        }

        //Clicking the DONE button.
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy
                            .iOSClassChain("**/XCUIElementTypeButton[`name == \"Done\"`]")))
                    .click();
            logger.info("Done is clicked");
        } catch (Exception e) {
            logger.warning("Done is not clicked.");
        }

        //1.Empty Personal note less character.
        try {
            //Reminder name is added.
            wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy
                            .iOSClassChain("**/XCUIElementTypeTextField[`value == \"Reminder Name\"`]")))
                            .sendKeys("reminder");

            //Selecting the days
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("MON"))).click();
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("WED"))).click();

            //Confirm the reminder using set reminder button.
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy
                            .iOSClassChain("**/XCUIElementTypeButton[`name == \"Set Reminder\"`]"))).click();
            logger.info("Empty personal note to generate the error");
        } catch (Exception e) {
            logger.warning("Empty personal note is not");
        }

        //Actual Error creation for empty personal note.
        WebElement ErrorForNoPersonalNote =null;
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.accessibilityId("Please enter personal note.")));
            logger.info("Error 1 :" + ErrorForNoPersonalNote.getText());
        } catch (Exception e) {
            logger.warning("Empty personal note error is not visible.");
        }

        //2.Creating the error for less character in personal note.
        try {
            //Reminder name is added.
            wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy
                            .iOSClassChain("**/XCUIElementTypeTextField[`value == \"Reminder Name\"`]")))
                    .sendKeys("reminder");

            //Selecting the days
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("MON"))).click();
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("WED"))).click();

            //Adding personal note with less character for another error.
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy
                            .className("XCUIElementTypeTextView")))
                            .sendKeys("Tak");

            //Confirm the reminder using set reminder button.
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy
                    .iOSClassChain("**/XCUIElementTypeButton[`name == \"Set Reminder\"`]"))).click();
        } catch (Exception e) {
            logger.warning("Clearing the personal note.");
        }

        //Confirm the reminder using set reminder button.
        WebElement ErrorForLessCharacterForPersonalNote =null;
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("Please add reminder time"))).click();
            logger.info("Less character for personal note error :" + ErrorForLessCharacterForPersonalNote.getText());
        } catch (Exception e) {
            logger.warning("Less character for personal note error is not coming.");
        }
    }

    @Test(retryAnalyzer = RetryAnalyzerios.class)
    public void TC_018() {

        BaseLoginForIos();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        //Clicking the plus button for set reminder.
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy
                            .iOSClassChain("**/XCUIElementTypeButton[`name == \"Plus\"`][2]")))
                    .click();
            logger.info("Clicking the plus is working");
        } catch (NoSuchElementException e) {
            logger.warning("Plus button for set reminder is not found.");
        }

        //Clicking the SpO2 radio button.
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy
                            .iOSClassChain("**/XCUIElementTypeButton[`name == \"radioUnSelection\"`][3]")))
                    .click();
            logger.info("Spo2 radio button is visible and it clicked.");
        } catch (Exception e) {
            logger.warning("Spo2 radio button is not visible for a click.");
        }

        //Clicking the DONE button.
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy
                            .iOSClassChain("**/XCUIElementTypeButton[`name == \"Done\"`]")))
                    .click();
            logger.info("Done is clicked");
        } catch (Exception e) {
            logger.warning("Done is not clicked.");
        }

        try {
            //Reminder name is added.
            wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy
                            .iOSClassChain("**/XCUIElementTypeTextField[`value == \"Reminder Name\"`]")))
                    .sendKeys("reminder");

            //Selecting the days
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("MON"))).click();
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("WED"))).click();

            //Adding personal note with less character for another error.
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy
                            .className("XCUIElementTypeTextView")))
                    .sendKeys("Take care.");
            logger.info("Reminder name date and reminder personal note is added.");
        } catch (Exception e) {
            logger.warning("Set time for the reminder is not happen.");
        }

        //1.Adding reminder time.
        try {
            //Clicking the add button to add tome.
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("Add"))).click();

            //5.clicking the done set the current time for the reminder.
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("Done"))).click();

            logger.info("Reminder time is added.") ;

        }catch (Exception e)
        {
            logger.info("Reminder time is not added.");
        }

        //2.Editing the reminder time.
        try {
            //Clicking the add button to add tome.
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy
                    .xpath("//XCUIElementTypeScrollView/XCUIElementTypeCollectionView[2]" +
                            "/XCUIElementTypeCell[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeButton"))).click();

            //clicking the done set the current time for the reminder.
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("Done"))).click();

            logger.info("Reminder time is edited.");

        }catch (Exception e)
        {
            logger.info("Reminder time is not edited.");
        }

        //User click the cancel button to avoid setting time for reminder.
        WebElement Cancel = null;
        try
        {
            //Clicking the add button to add tome.
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("Add"))).click();

            //Cancel button click
            Cancel = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("Cancel")));
            logger.info("Canceling the time set for reminder." + Cancel.isDisplayed());
            Cancel.click();
        } catch (Exception e) {
            logger.warning("Cancel button is not visible.");
        }


    }

    @Test(retryAnalyzer = RetryAnalyzerios.class)
    public void TC_019() {

        BaseLoginForIos();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        //Verify the care circle is present in the screen
        WebElement CareCircle =null;
        try {
            CareCircle = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.accessibilityId("ic heartHandBlueHomeIcon")));
            CareCircle.click();
            logger.info("Care circle is clicked.");
        } catch (Exception e) {
            logger.warning("Care circle is is not present to click.");
        }

        //clicking the kebab menu
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("ic dot menu white"))).click();

            //1.Clicking the Delete care circle to delete them.
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy
                    .accessibilityId("Delete Care Circle"))).click();
        } catch (Exception e) {
            logger.warning("Clicking the kebab for delete care circel is not happen.");
        }

        //Confirmation for deleting the care circle
        WebElement ConfirmAlterMessage, SuccessToast = null;
        try {
            //Confirm alter message for deleting the care circle
            ConfirmAlterMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy
                    .accessibilityId("Are you sure you want to delete this Care Circle?")));
            logger.info("Delete care circle message" + ConfirmAlterMessage.getText());

            //2.Clicking the Ok to delete the care circle.
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("OK")));

            wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.accessibilityId("Care circle removed successfully")));
            logger.info("Success toast : " + SuccessToast.getText());
        } catch (Exception e) {
            logger.warning("Success toast is not coming in the dashboard.");
        }
    }

    @Test(retryAnalyzer = RetryAnalyzerios.class)
    public void TC_025() {
        BaseLoginForIos();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            //Clicking the primary user profile to check my dependent
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy
                    .xpath("//XCUIElementTypeScrollView/XCUIElementTypeOther" +
                            "/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther[1]" +
                            "/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther"))).click();
            logger.info("Clicking the primary user profile to check My dependent section.");
        } catch (Exception e) {
            logger.warning("Primary user profile is not there to click.");
        }

        try {
            //Clicking on my dependent profile
            wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.accessibilityId("My Dependents"))).click();

            //1.Verify the dependent list
            WebElement Dependent_1 = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy
                    .xpath("//XCUIElementTypeCell/XCUIElementTypeOther[1]/XCUIElementTypeOther")));
            logger.info(Dependent_1.getText() + " is one of the dependent is present : " + Dependent_1.isDisplayed());
        } catch (Exception e) {
            logger.warning("Dependent is not available.");
        }

        try {
            //2.Edit the dependent profile, click on kebab menu inspecting is not working in ios
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.androidUIAutomator
                    ("new UiSelector().resourceId(\"com.moai.android:id/imgMenu\").instance(1)"))).click();
            //Actual edit profile option.
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.androidUIAutomator
                    ("new UiSelector().text(\"Edit Profile\")"))).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.moai.android:id/edtFullName"))).sendKeys("NIHIL");
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("Navigate up"))).click();
        } catch (Exception e) {
            logger.warning("Edit the dependent profile is not happen.");
        }

        try {
            //3.Deleting the profile
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.androidUIAutomator
                    ("new UiSelector().resourceId(\"com.moai.android:id/imgMenu\").instance(2)"))).click();
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.androidUIAutomator("new UiSelector().text(\"Delete\")"))).click();
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("android:id/button1"))).click();

            wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("android:id/message")));
            WebElement message = driver.findElement(AppiumBy.id("android:id/message"));
            logger.info("Success message for deleted dependent :" + message.getText());
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("android:id/button1"))).click();
        } catch (Exception e) {
            logger.warning("Deleting the dependent profile is not happen.s");
        }

    }

    @Test(retryAnalyzer = RetryAnalyzerios.class)
    public void TC_026() {

        BaseLoginForIos();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            //Clicking the primary user profile to check my dependent
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy
                    .xpath("//XCUIElementTypeScrollView/XCUIElementTypeOther" +
                            "/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther[1]" +
                            "/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther"))).click();
            logger.info("Clicking the primary user profile to check My dependent section.");
        } catch (Exception e) {
            logger.warning("Not moved to the Report section of the dependent.");
        }

        try
        {
            //Clicking the kebab menu
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath(""))).click();

            //Clicking the health report option to navigate to report section.
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.androidUIAutomator("new UiSelector().text(\"Health Report\")"))).click();

            wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.androidUIAutomator("new UiSelector().text(\"Blood Pressure\")")));
            WebElement lable = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Blood Pressure\")"));
            logger.info("Report section : " + lable.getText());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test(retryAnalyzer = RetryAnalyzerios.class)
    public void TC_027() {

        /*Adding the reminder for Blood pressure.*/
        BaseLoginForIos();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            //1.User set up the reminder from the dashboard.
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy
                            .iOSClassChain("**/XCUIElementTypeButton[`name == \"Plus\"`][2]")))
                            .click();
            logger.info("Clicking the plus is working");
        } catch (Exception e) {
            logger.warning("plus button is not clicked");
        }

        //Clicking the SpO2 radio button.
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy
                            .iOSClassChain("**/XCUIElementTypeButton[`name == \"radioUnSelection\"`][3]")))
                    .click();
            logger.info("Spo2 radio button is visible and it clicked.");
        } catch (Exception e) {
            logger.warning("Spo2 radio button is not visible for a click.");
        }

        //Clicking the DONE button.
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy
                            .iOSClassChain("**/XCUIElementTypeButton[`name == \"Done\"`]")))
                    .click();
            logger.info("Done is clicked");
        } catch (Exception e) {
            logger.warning("Done is not clicked.");
        }

        try {
            //2(i).Reminder name is added.
            wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy
                            .iOSClassChain("**/XCUIElementTypeTextField[`value == \"Reminder Name\"`]")))
                    .sendKeys("reminder");

            //2(ii)Selecting the days
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("MON"))).click();
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("WED"))).click();

            //2.(iii)Clicking the add button to add tome.
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("Add"))).click();
            //clicking the done set the current time for the reminder.
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("Done"))).click();

            //2.(iv)Adding personal note with less character for another error.
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy
                            .className("XCUIElementTypeTextView")))
                            .sendKeys("Take care of your health.");

            //2.(ii)Confirm the reminder using set reminder button.
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy
                    .iOSClassChain("**/XCUIElementTypeButton[`name == \"Set Reminder\"`]"))).click();
            logger.info("Set up  the reminder from the dashboard is happening.");
        } catch (Exception e) {
            logger.warning("Set up the reminder form the dashboard is not happening.");
        }

        try
        {
            //3.Clicking the plus for invite the people to the reminder.
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("Plus"))).click();

            //Selecting the people for the reminder.
            wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy
                    .xpath("//XCUIElementTypeTable/XCUIElementTypeCell" +
                            "/XCUIElementTypeOther[1]/XCUIElementTypeOther"))).click();
            //Clicking on Add invite button for the confirmation.
            wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy
                    .xpath("**/XCUIElementTypeButton[`name == \"Add Invitee\"`]"))).click();
            logger.info("Inviting the people to the reminder is happening");
        } catch (Exception e) {
            logger.warning("Invite the people to the reminder is not working. ");
        }
    }

    @Test(retryAnalyzer = RetryAnalyzerios.class)
    public void TC_028() {
        BaseLoginForIos(); // Login process.

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        //BP report values with chart.
        try {
            WebElement bloodPressureElement = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.moai.android:id/txtBloodPressure")));
            logger.info("Blood pressure report is present: " + bloodPressureElement.isDisplayed());

            WebElement pressureChart = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.moai.android:id/bloodPressureChart")));
            logger.info("Blood pressure report chart is present: " + pressureChart.isDisplayed());

            WebElement pressureValue = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.moai.android:id/txtBPValue")));
            logger.info("Blood pressure value is present: " + pressureValue.getText());
        } catch (Exception e) {
            logger.warning("Bp chart is not visible.");
        }

        try {
            //Hr report values with chart.
            WebElement hrElement = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.moai.android:id/txtHeartRate")));
            logger.info("Heart rate report is present: " + hrElement.isDisplayed());

            WebElement hrChart = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.moai.android:id/HeartRateChart")));
            logger.info("Heart rate report chart is present: " + hrChart.isDisplayed());

            WebElement hrValue = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.moai.android:id/txtHeartRateValue")));
            logger.info("Heart rate value is present: " + hrValue.getText());
        } catch (Exception e) {
            logger.warning("Hr report chart is not visible.");
        }

        try {
            //Spo2 report values with chart.
            WebElement Spo2Element = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.moai.android:id/txtSpo2")));
            logger.info("Spo2 report is present: " + Spo2Element.isDisplayed());

            WebElement Spo2Chart = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.moai.android:id/spo2Chart")));
            logger.info("Spo2 report chart is present: " + Spo2Chart.isDisplayed());

            WebElement Spo2Value = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.moai.android:id/txtSpo2Value")));
            logger.info("Spo2 value is present: " + Spo2Value.getText());
        } catch (Exception e) {
            logger.warning("Spo2 report chart is not visible.");
        }

        try {
            //ECG report va;ues with chart
            WebElement ECGElement = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.moai.android:id/txtEcg")));
            logger.info("ECG report is present: " + ECGElement.isDisplayed());

            WebElement ECGChart = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.moai.android:id/mpSingleLeadECG")));
            logger.info("ECG report chart is present: " + ECGChart.isDisplayed());
        } catch (Exception e) {
            logger.warning("ECG report chart is not visible.");
        }
    }

    @Test(retryAnalyzer = RetryAnalyzerios.class)
    public void TC_029() {

        BaseLoginForIos(); //Login process from base class.

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            //Clicking on primary user profile
            wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.moai.android:id/imgProfile"))).click();
        } catch (Exception e) {
            logger.warning("Primary user profile click is not happen.");
        }

        try {
            //Clicking on parameter range option in the primary user profile
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.moai.android:id/txtParameterRange"))).click();
        } catch (Exception e) {
            logger.warning("Primary user parameter range click is not happen");
        }

        //Customize the BP range
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.
                    androidUIAutomator("new UiSelector().resourceId(\"com.moai.android:id/txtCustomize2\").instance(0)"))).click();
            //Submit button
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.moai.android:id/txtSubmit"))).click();
            //Reset can happen
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.moai.android:id/txtBPRest\").instance(0)"))).click();
            //confirmation Ok
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("android:id/button1"))).click();
            //Skip
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.moai.android:id/tvSkip"))).click();
        } catch (Exception e) {
            logger.warning("Customize the BP range is not happen for the primary user. ");
        }


        //Blood sugar range is not customizable
        try {
            WebElement CustomizeBlood = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.moai.android:id/txtCustomize1")));
            logger.info("Blood sugar is not customizable :" + CustomizeBlood.isEnabled());
        } catch (Exception e) {
            logger.warning("Blood sugar cant be customizable.");
        }


        try {
            //Customize the Spo2 range
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.moai.android:id/txtCustomize2\").instance(0)"))).click();
            //Submit button
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.moai.android:id/txtSubmit"))).click();
            //Reset can happen
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.moai.android:id/txtBPRest\").instance(0)"))).click();
            //confirmation Ok
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("android:id/button1"))).click();
        } catch (Exception e) {
            logger.warning("Customize the Spo2 is not happen. ");
        }


        try {
            //Customizing the cholesterol is not possible.
            WebElement CustomizeCholesterol = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.moai.android:id/txtCustomize1\").instance(1)")));
            logger.info("Cholesterol is not Customizable :" + CustomizeCholesterol.isEnabled());
        } catch (Exception e) {
            logger.warning("Customizing is should not be use.");
        }

        try {
            //Scroll to the bottom customize.
            driver.findElement(AppiumBy.androidUIAutomator
                    ("new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(resourceId(\"com.moai.android:id/txtCustomize2\"));"));
        } catch (Exception e) {
            logger.warning("Scroll to the element is not happpen.");
        }

        try {
            //Customize the heart rate.
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.moai.android:id/txtCustomize2\").instance(0)"))).click();
            //Submit button
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.moai.android:id/txtSubmit"))).click();
            //Reset can happen
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.moai.android:id/txtBPRest\").instance(0)"))).click();
            //confirmation Ok
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("android:id/button1"))).click();
        } catch (Exception e) {
            logger.warning("Customizing the HR is not working");
        }

        try {
            //Navigate to the profile page.
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("Navigate up"))).click();
        } catch (Exception e) {
            logger.warning("Navigating back is not happen.");
        }

    }


    @Test(retryAnalyzer = RetryAnalyzerios.class)
    public void TC_030() {
        BaseLoginForIos(); //Login process.

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            //clicking the dependent profile
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.androidUIAutomator("new UiSelector().text(\"K\")"))).click();
        } catch (Exception e) {
            logger.warning("Dependent user profile navigation is not happening.");
        }

        try {
            //Customize the BP range
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.moai.android:id/txtCustomize2"))).click();
            //Submit button
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.moai.android:id/txtSubmit"))).click();
            //Reset can happen
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.moai.android:id/txtBPRest"))).click();
            //confirmation Ok
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("android:id/button1"))).click();
        } catch (Exception e) {
            logger.warning("Customizing BP is not happening.");
        }

        //Scroll to the bottom customize.
        try {
            driver.findElement(AppiumBy.androidUIAutomator
                    ("new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(resourceId(\"com.moai.android:id/txtCustomize2\"));"));
        } catch (Exception e) {
            logger.warning("Scroll to the element is not happen.");
        }

        try {
            //Blood sugar range is not customizable
            WebElement CustomizeBlood = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.moai.android:id/txtCustomize1")));
            System.out.println("Blood sugar is not customizable :" + CustomizeBlood.isEnabled());
            logger.info("Customizing for blood sugar is should not be enable.");
        } catch (Exception e) {
            logger.warning("Blood sugar customize is not cheking.");
        }

        try {
            //Customize the Spo2 range
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.moai.android:id/txtCustomize2\").instance(0)"))).click();
            //Submit button
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.moai.android:id/txtSubmit"))).click();
            //Reset can happen
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.moai.android:id/txtBPRest\").instance(0)"))).click();
            //confirmation Ok
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("android:id/button1"))).click();
        } catch (Exception e) {
            logger.warning("Customizing the Spo2 is not happen.");
        }

        try {
            //Customizing the cholesterol is not possible.
            WebElement CustomizeCholesterol = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.moai.android:id/txtCustomize1\").instance(1)")));
            logger.info("Cholesterol is not Customizable :" + CustomizeCholesterol.isEnabled());
        } catch (Exception e) {
            logger.warning("Customizing the cholesterol is not possible.");
        }

        try {
            //Scroll to the bottom customize.
            driver.findElement(AppiumBy.androidUIAutomator
                    ("new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(resourceId(\"com.moai.android:id/txtCustomize2\"));"));
        } catch (Exception e) {
            logger.warning("Scroll to the element is not happen.");
        }

        try {
            //Customize the heart rate.
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.moai.android:id/txtCustomize2\").instance(0)"))).click();
            //Submit button
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.moai.android:id/txtSubmit"))).click();
            //Reset can happen
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.moai.android:id/txtBPRest\").instance(0)"))).click();
            //confirmation Ok
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("android:id/button1"))).click();
        } catch (Exception e) {
            logger.warning("Customize the Hr is not happen.");
        }

    }

}
