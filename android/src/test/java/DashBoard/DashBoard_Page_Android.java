package DashBoard;

import DriverManagerAndroid.DriverManager;
import UtilitiesForAndroid.RetryAnalyzer;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import java.time.Duration;

public class DashBoard_Page_Android extends DriverManager {

    private static final Logger log = LoggerFactory.getLogger(DashBoard_Page_Android.class);
    
     @Test(retryAnalyzer = RetryAnalyzer.class)
    public void TC_010()
    {
        BaseLogin();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        //1.Verify the LOGO text present in the top.
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.androidUIAutomator("new UiSelector().text(\"MoAI\")")));
            WebElement LogoText = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"MoAI\")"));
            logger.info("Logo text : " + LogoText.getText());
            logger.info("Logo text is present : " + LogoText.isDisplayed());
        } catch (Exception e) {
            logger.warning("Logo is not present.");
        }

        //2.Verify the Sync button.
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.accessibilityId("Sync data")));
            WebElement SyncData = driver.findElement(AppiumBy.accessibilityId("Sync data"));
            logger.info("Sync data button is present : " + SyncData.isDisplayed());
            SyncData.click();
        } catch (Exception e) {
            logger.warning("Sync button is not present.");
        }

        WebElement SyncInfo = null;
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.
                    id("com.android.permissioncontroller:id/permission_allow_button")));
            logger.info("Sync button info :" + SyncInfo.getText());
        }
        catch (Exception e)
        {
            logger.warning("Info message is not found.");
        }

        WebElement SyncClose = null;
        try {
            SyncClose = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.moai.android:id/image_close_toaster")));
            logger.info("Cross button is found its clicked :" + SyncClose.isDisplayed());
            SyncClose.click();
        }
        catch (Exception e)
        {
             logger.warning("Sync cross button is not found.");
        }

        //3.Notification button.
        try {
            WebElement NotificationButton = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.accessibilityId("Notification")));
            logger.info("Notification button is present : " + NotificationButton.isDisplayed());
            NotificationButton.click();
        } catch (Exception e) {
            logger.warning("Notification button is not present.");
        }

        //4.Seeing the notification and clearing them
        WebElement Notifications = null;
        try{
            wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.androidUIAutomator
                    ("new UiSelector().resourceId(\"com.moai.android:id/llMain\").instance(0)")));
            logger.info("Notification is present? : " + Notifications.isDisplayed());
        }
        catch (Exception e)
        {
            logger.warning("No notification are present.");
        }

        //5. clearing them
        try{
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("clear"))).click();
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("android:id/button1"))).click();
            logger.info("Clear button is found and it's cleared all the notifications");
        }
        catch (Exception e)
        {
         logger.warning("Clear button is not present currently, there is no notification");
        }

        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("Navigate up"))).click();

        //6.health score section
        WebElement ECGReport = null;
        try {
            ECGReport =  wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.moai.android:id/txtEcg")));
            logger.info("Ecg report is present " + ECGReport.isDisplayed());
        }
        catch (Exception e)
        {
            logger.warning("Ecg report data is not present in the dashboard.");
        }

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
            HealthScore = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.moai.android:id/view5")));
        } catch (Exception e) {
            logger.warning("Health scroll is not visible, may be the screen is not scrolled.");
        }
    }

     @Test(retryAnalyzer = RetryAnalyzer.class)
    public void TC_011() {

        BaseLogin(); // To complete the login process.

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        //1.Verify My dependent section.
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.moai.android:id/txtMyDependent")));
            WebElement MyDependent = driver.findElement(AppiumBy.id("com.moai.android:id/txtMyDependent"));
            logger.info("My dependent section is present : " + MyDependent.isDisplayed());
        } catch (Exception e) {
            logger.warning("My dependent section is not visible.");
        }

        //2.Add new dependent
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.androidUIAutomator("new UiSelector().text(\"+2\")"))).click();
            //My Dependent details page, new journey for adding dependent. user should cross all the 5 pages.
            wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.androidUIAutomator("new UiSelector().text(\"My Dependent\")")));
            WebElement MyDependentSection = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"My Dependent\")"));
            logger.info("My Dependent page is present : " + MyDependentSection.isDisplayed());
        } catch (Exception e) {
            logger.warning("Add new dependent is not happening.");
        }

        //Home button, moving back to dashboard.
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("Navigate up"))).click();
        } catch (Exception e) {
            logger.warning("Moving back to home is not happening.");
        }

        //3.Verify added dependent in the dashboard
        WebElement AddedDependent = null;
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.androidUIAutomator("new UiSelector().text(\"K\")")));
            AddedDependent = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"K\")"));
            logger.warning("Newly added dependent profile is visible : " + AddedDependent.isDisplayed());
        } catch (Exception e) {
            logger.warning("New dependent is not added.");
        }

        //4.Dependent profile
        try {
            AddedDependent.click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.moai.android:id/txtUserName")));
            WebElement userName = driver.findElement(AppiumBy.id("com.moai.android:id/txtUserName"));
            logger.info("Dependent profile name : " + userName.getText());
        } catch (Exception e) {
            logger.warning("New dependent profile is ");
        }

        //Navigate back to the DB
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("Navigate up"))).click();
        } catch (Exception e) {
            logger.warning("Navigating back dashboard is not happening.");
        }

        //6.Sharing the report detail

        try {
            /*Clicking on share in DB*/
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.moai.android:id/imgShare"))).click();
            /*Selecting the ECG*/
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.moai.android:id/rbECG"))).click();
            /*Selecting the Submit*/
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.moai.android:id/txtSubmit"))).click();
            /*Selecting the message*/
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.
                    xpath("//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"Messages\"]"))).click();
            logger.info("Sharing the report is working.");
        } catch (Exception e) {
            logger.warning("Sharing option is not happening.");
        }


        //7.downloading the reports and sharing to the people from DB.
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.moai.android:id/imgDownload"))).click();
            /*Selecting ECG for download*/
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.moai.android:id/rbECG"))).click();
            /*Selecting the SPO2 download.*/
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.moai.android:id/rbSpo2"))).click();
            /*Selecting the HR download*/
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.moai.android:id/rbHR"))).click();
            /*Clicking on done*/
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.moai.android:id/txtSubmit"))).click();
        } catch (Exception e) {
            logger.warning("Downloading the report not working.");
        }
    }

     @Test(retryAnalyzer = RetryAnalyzer.class)
    public void TC_012() {

        BaseLogin(); // To complete the login process.

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        //verify the care circle section label.
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.moai.android:id/txtCareCirclesLabel")));
            WebElement careCircleLabel = driver.findElement(AppiumBy.id("com.moai.android:id/txtCareCirclesLabel"));
            logger.info("Care circle label is present : " + careCircleLabel.isDisplayed());
        } catch (Exception e) {
            logger.warning("Care section label is not visible.");
        }

        //2.Clicking the Get stared button
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.moai.android:id/txtCareCircle"))).click();
        } catch (Exception e) {
            logger.warning("Clicking on get started is not happening.");
        }

        //Permission
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id
                    ("com.android.packageinstaller:id/permission_allow_button"))).click();
        } catch (Exception e) {
            logger.warning("Permission allow is not happening.");
        }

        //Selecting the contact
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.
                    androidUIAutomator("new UiSelector().text(\"A\")"))).click();
        } catch (Exception e) {
            logger.warning("Selecting contact os not happening.");
        }

        //Add member
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.moai.android:id/tvAddMembers"))).click();
        } catch (Exception e) {
            logger.warning("Adding member is not happening");
        }

        //Enter group name
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id
                    ("com.moai.android:id/edtGroupName"))).sendKeys("Fam");
        } catch (Exception e) {
            logger.warning("Adding new name for the care circle is not happening.");
        }

    }

     @Test(retryAnalyzer = RetryAnalyzer.class)
    public void TC_013() {

        TC_012();  // To complete the previous steps.

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        //Click the submit to get the error, not enough character.
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.moai.android:id/tvOkay"))).click();
        } catch (Exception e) {
            logger.warning("Submit button is not working for getting the error for not enough character.");
        }

        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.moai.android:id/textinput_error")));
            WebElement error1 = driver.findElement(AppiumBy.id("com.moai.android:id/textinput_error"));
            logger.info("Not enough character error : " + error1.getText());
        } catch (Exception e) {
            logger.warning("error message is not pop-up");
        }

        //Clearing the input field.
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id
                    ("com.moai.android:id/edtGroupName"))).clear();
        } catch (Exception e) {
            logger.warning("Clearing the input field is not working.");
        }

        //To get empty input field error.
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.moai.android:id/tvOkay"))).click();
            logger.info("Empty input for the care circle name");
        } catch (Exception e) {
            logger.warning("Empty input field error is not pop-up.");
        }

        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.moai.android:id/textinput_error")));
            WebElement error2 = driver.findElement(AppiumBy.id("com.moai.android:id/textinput_error"));
            logger.info("Empty input field error : " + error2.getText());
        } catch (Exception e) {
            logger.warning("Empty input field error message is not visible.");
        }

    }


     @Test(retryAnalyzer = RetryAnalyzer.class)
    public void TC_014() {

        BaseLogin();// To complete the login scenario.

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        //Care circle button.
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.moai.android:id/imgOtherProfile"))).click();
        } catch (Exception e) {
            logger.warning("Care circle button is not visible for a click.");
        }

        //permission
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id
                    ("com.android.packageinstaller:id/permission_allow_button"))).click();
            logger.info("Permission is given for allow button");
        } catch (Exception e) {
            logger.warning("Permission is not happening");
        }

        //Add member
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.moai.android:id/tvAddMembers"))).click();
            logger.info("Add member is happened");
        } catch (Exception e) {
            logger.warning("Add member is not happen.");
        }

        //1.clicking the kebab menu
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("More options"))).click();
        } catch (Exception e) {
            logger.warning("Clicking the more options is not happen.");
        }

        //2.(i)Kebab menu list with edit care circle.
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.androidUIAutomator
                    ("new UiSelector().text(\"Edit Care Circle\")")));
            WebElement EditCareCircle = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Edit Care Circle\")"));
            logger.info("Edit care circle option is present in the list : " + EditCareCircle.isDisplayed());
        } catch (Exception e) {
            logger.warning("Edit care circle is not visible.");
        }

        //2.(ii)Kebab menu list with set reminder
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.androidUIAutomator
                    ("new UiSelector().text(\"Set Reminder\")")));
            WebElement SetReminder = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Set Reminder\")"));
            logger.info("Set reminder option is present in the list : " + SetReminder.isDisplayed());
        } catch (Exception e) {
            logger.warning("Set reminder is not visible.");
        }

        //2.(iii)Kebab menu list with Delete care circle
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.androidUIAutomator
                    ("new UiSelector().text(\"Delete Care Circle\")")));
            WebElement DeleteCareCircle = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Delete Care Circle\")"));
            logger.info("Delete care circle option is present in the list : " + DeleteCareCircle.isDisplayed());
        } catch (Exception e) {
            logger.warning("Delete care circle is not visible");
        }

        //3.Clicking on the edit care circle option in the kebab menu
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.androidUIAutomator
                    ("new UiSelector().text(\"Edit Care Circle\")"))).click();
            logger.info("Clicking the edit care circle");
        } catch (Exception e) {
            logger.warning("Edit care circle click is not happening.");
        }

        //Clearing the input field.
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id
                    ("com.moai.android:id/edtGroupName"))).clear();
            logger.info("Clearing the previous input.");
        } catch (Exception e) {
            logger.warning("Clearing the previous input is not happening");
        }

        //Editing the care circle name.
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id
                    ("com.moai.android:id/edtGroupName"))).sendKeys("SANTH");
            logger.info("Editing the care circle name");
        } catch (Exception e) {
            logger.warning("Edit the care circle name is not happen.");
        }

        //4.Clicking on the update to complete the change.
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.moai.android:id/tvOkay"))).click();
            logger.info("name is changed.");
        } catch (Exception e) {
            logger.warning("Name changed newly.");
        }

    }

     @Test(retryAnalyzer = RetryAnalyzer.class)
    public void TC_015() {

        BaseLogin(); // To complete the login process.

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(13));

        //pre - Care circle button.
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.moai.android:id/imgOtherProfile"))).click();
            logger.info("clicking the care circle.");
        } catch (Exception e) {
            logger.warning("Care circle is not visible ");
        }

        //pre - permission
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id
                    ("com.android.packageinstaller:id/permission_allow_button"))).click();
        } catch (Exception e) {
            logger.warning("permission is not accepted for allow.");
        }

        //pre - Add member
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.moai.android:id/tvAddMembers"))).click();
            logger.info("Adding member is working");
        } catch (Exception e) {
            logger.warning("Add member is not happening.");
        }

         try {
             wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id
                     ("com.android.packageinstaller:id/permission_allow_button"))).click();
         } catch (Exception e) {
             logger.warning("permission is not accepted for allow.");
         }

        //pre - clicking the kebab menu
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("More options"))).click();
        } catch (Exception e) {
            logger.warning("clicking kebab menu is not happening.");
        }

        //1.clicking the Set reminder button in the kebab menu
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.androidUIAutomator
                    ("new UiSelector().text(\"Set Reminder\")"))).click();
            logger.info("Set reminder is working.");
        } catch (Exception e) {
            logger.warning("Set reminder from care circle is not happening");
        }

        //2.Verify the blood pressure radio button is selected by default.
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.moai.android:id/rbBp")));
            WebElement BP = driver.findElement(AppiumBy.id("com.moai.android:id/rbBp"));
            logger.info("Bp reminder is selected default : " + BP.isDisplayed());
        } catch (Exception e) {
            logger.warning("Bp radio button is not Enabled.");
        }

        //3.verify the ECG radio button is selectable
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.moai.android:id/rbECG"))).click();
            WebElement ECG = driver.findElement(AppiumBy.id("com.moai.android:id/rbECG"));
            logger.info("Ecg is selected : " + ECG.isDisplayed());
        } catch (Exception e) {
            logger.warning("ECG radio button is not displayed.");
        }

        //4. verify the Spo2 reminder radio button is selectable
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.moai.android:id/rbSpo2"))).click();
            WebElement Spo2 = driver.findElement(AppiumBy.id("com.moai.android:id/rbSpo2"));
            logger.info("Spo2 is selected : " + Spo2.isDisplayed());
        } catch (Exception e) {
            logger.warning("Spo2 radio button is not selectable.");
        }

        //5.Heart rate reminder radio button is selectable
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.moai.android:id/rbHR"))).click();
            WebElement HR = driver.findElement(AppiumBy.id("com.moai.android:id/rbHR"));
            logger.info("HR is selected : " + HR.isDisplayed());
        } catch (Exception e) {
            logger.warning("Hr reminder radio is not visible");
        }

        //Done button
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.moai.android:id/txtSubmit"))).click();
            logger.info("Done button click is working.");
        } catch (Exception e) {
            logger.warning("Done button click is not working");
        }

        //Add reminder name
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id
                    ("com.moai.android:id/edtReminderName"))).sendKeys("Take Heart rate.");
            logger.info("Reminder name is added.");
        } catch (Exception e) {
            logger.warning("Add reminder name is not working.");
        }

        //Selecting the days for the reminder
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.moai.android:id/txtMUN"))).click();
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.moai.android:id/txtTHU"))).click();
            logger.info("Selecting the days for reminder is working.");
        } catch (Exception e) {
            logger.warning("Selecting days for the reminder is not working.");
        }

        //Set the time for the reminder
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.moai.android:id/chipAdd"))).click();
            logger.info("Set time for reminder is working");
        } catch (Exception e) {
            logger.warning("Set time for reminder is not working.");
        }

        //Choose the hour time for the reminder
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("6"))).click();
            logger.info("Choose hour is happen.");
        } catch (Exception e) {
            logger.warning("Choose hour is not happening");
        }

        //Choose the minute time for the reminder
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("0"))).click();
            logger.info("choose minutes is working");
        } catch (Exception e) {
            logger.warning("Choose minute is not working");
        }

        //Confirm the with OK
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("android:id/button1"))).click();
            logger.info("Clicking Ok is working.");
        } catch (Exception e) {
            logger.warning("Clicking Ok is not working");
        }

        //Using + to Adding invite to the reminder
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.moai.android:id/imgAddReminder"))).click();
            logger.info("invite the people is working.");
        } catch (Exception e) {
            logger.warning("Invite the people is not working.");
        }

        //6.Add the invite to the reminder
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.
                    androidUIAutomator("new UiSelector().text(\"Kavya\")"))).click();
            logger.info("Care circle people is added to the reminder.");
        } catch (Exception e) {
            logger.warning("People is not added to the reminder");
        }

        //Clicking the add invite button
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.moai.android:id/txtSubmit"))).click();
            logger.info("Invite button click is working.");
        } catch (Exception e) {
            logger.warning("Clicking invite button is not working.");
        }

        //Scrolling to personal note
        try {
            driver.findElement(AppiumBy.androidUIAutomator
                    ("new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(resourceId(\"com.moai.android:id/edtPersonalNotes\"));")).sendKeys("Take care Your self..");
            logger.info("Scroll to the personal note and added input as well.");
        } catch (Exception e) {
            logger.warning("Scroll to the  personal note is not happen");
        }

        //7.Confirm the reminder
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.moai.android:id/txtSetReminder"))).click();
            logger.info("Reminder set successfully.");
        } catch (Exception e) {
            logger.warning("Reminder confirmation is not happen.");
        }
    }


     @Test(retryAnalyzer = RetryAnalyzer.class)
    public void TC_016() {

        BaseLogin();// To complete the login process.

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        //Scrolling to the plus button.
        try {
            driver.findElement(AppiumBy.androidUIAutomator
                    ("new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(resourceId(\"com.moai.android:id/imgAddReminder\"));"));
        } catch (Exception e) {
            logger.warning("Scroll to the add reminder in the DB is not working");
        }

        //Clicking the plus button
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.moai.android:id/imgAddReminder"))).click();
            logger.info("Clicking the plus is working");
        } catch (Exception e) {
            logger.warning("plus button is not clicked");
        }

        //Clicking the SpO2 radio button.
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.moai.android:id/rbSpo2"))).click();
            logger.info("Spo2 radio button is visible and it clicked.");
        } catch (Exception e) {
            logger.warning("Spo2 radio button is not visible for a click.");
        }

        //Clicking the DONE button.
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.moai.android:id/txtSubmit"))).click();
            logger.info("Done is clicked");
        } catch (Exception e) {
            logger.warning("Done is nor clicked.");
        }

        //CASE - 1
        //1.Selecting the days for the reminder
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.moai.android:id/txtMUN"))).click();
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.moai.android:id/txtTHU"))).click();
            logger.info("Days are selected for reminder.");
        } catch (Exception e) {
            logger.warning("Selecting day is not working.");
        }

        //2.Unselect the days in the reminder
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.moai.android:id/txtMUN"))).click();
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.moai.android:id/txtTHU"))).click();
            logger.info("De-Selecting the days is happen.");
        } catch (Exception e) {
            logger.warning("De-Selecting the days is not working. ");
        }

        // CASE - 2 & 3
        //Empty reminder name
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.moai.android:id/edtReminderName")));
            //Confirm the reminder using set reminder button.
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.moai.android:id/txtSetReminder"))).click();
            //Empty reminder name error will be shown up.
            wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.moai.android:id/textinput_error")));
            WebElement EmptyReminderName = driver.findElement(AppiumBy.id("com.moai.android:id/textinput_error"));
            logger.info("Error 1 :" + EmptyReminderName.getText());
        } catch (Exception e) {
            logger.warning("Empty reminder name error is not visible.");
        }

        //Less character error on reminder name.
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.
                    id("com.moai.android:id/edtReminderName"))).sendKeys("sa");
            //Confirm the reminder using set reminder button.
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.moai.android:id/txtSetReminder"))).click();
            //Error for less charscter.
            wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.moai.android:id/textinput_error")));
            WebElement LessCharacterError = driver.findElement(AppiumBy.id("com.moai.android:id/textinput_error"));
            logger.info("Error 2 :" + LessCharacterError.getText());
        } catch (Exception e) {
            logger.warning("Less character error is not visible");
        }

        //3.
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.
                    id("com.moai.android:id/edtReminderName"))).sendKeys("Sant");
        } catch (Exception e) {
            logger.warning("name is added");
        }

        //Empty Personal note less character.
        try {
            driver.findElement(AppiumBy.androidUIAutomator
                    ("new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(resourceId(\"com.moai.android:id/edtPersonalNotes\"));")).sendKeys("Take care");

            //Confirm the reminder using set reminder button.
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.moai.android:id/txtSetReminder"))).click();

            //Popup for not selecting the day
            wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("android:id/message")));
            WebElement message = driver.findElement(AppiumBy.id("android:id/message"));
            logger.info("Pop up message for days not selected : " + message.getText());
        } catch (Exception e) {
            logger.warning("Days not selected error is not visible.");
        }
    }

     @Test(retryAnalyzer = RetryAnalyzer.class)
    public void TC_017() {

        BaseLogin(); // To complete the login process.

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        //Scrolling to the plus button.
        try {
            driver.findElement(AppiumBy.androidUIAutomator
                    ("new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(resourceId(\"com.moai.android:id/imgAddReminder\"));"));
        } catch (Exception e) {
            logger.warning("Scroll to the reminder is not happen.");
        }

        //Clicking the plus button
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.moai.android:id/imgAddReminder"))).click();
        } catch (Exception e) {
            logger.warning("Clicking plus is not happen.");
        }

        //Clicking the SpO2 radio button.
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.moai.android:id/rbSpo2"))).click();
        } catch (Exception e) {
            logger.warning("Selecting SPo2 is not happen.");
        }

        //Clicking the DONE button.
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.moai.android:id/txtSubmit"))).click();
        } catch (Exception e) {
            logger.warning("Selecting done is not happen.");
        }

        //----------------This scroll is not working-----------------------need to work on that-----------------

        try {
            driver.findElement(AppiumBy.androidUIAutomator
                    ("new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(resourceId(\"com.moai.android:id/txtSetReminder\"));"));
        } catch (Exception e) {
            logger.warning("Scroll to the element is not working.");
        }

        //Empty Personal note less character.
        try {
            driver.findElement(AppiumBy.androidUIAutomator
                    ("new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(resourceId(\"com.moai.android:id/edtPersonalNotes\"));"))
                    .sendKeys("Take");
        } catch (Exception e) {
            logger.warning("Empty personal note is not");
        }

        //Confirm the reminder using set reminder button.
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.moai.android:id/txtSetReminder"))).click();
        } catch (Exception e) {
            logger.warning("Set reminder is not working. ");
        }

        //Error for empty personal note.
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.moai.android:id/textinput_error")));
            WebElement error1 = driver.findElement(AppiumBy.id("com.moai.android:id/textinput_error"));
            logger.info("Error 1 :" + error1.getText());
        } catch (Exception e) {
            logger.warning("Empty personal note error is not visible.");
        }

        //Clearing the personal note to get another error
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.moai.android:id/edtPersonalNotes"))).clear();
        } catch (Exception e) {
            logger.warning("Clearing the personal note.");
        }

        //Confirm the reminder using set reminder button.
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.moai.android:id/txtSetReminder"))).click();
            //Error for empty personal note.
            wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.moai.android:id/textinput_error")));
            WebElement error2 = driver.findElement(AppiumBy.id("com.moai.android:id/textinput_error"));
            logger.info("Error 2 :" + error2.getText());
        } catch (Exception e) {
            logger.warning("Empty personal note error is not visible.");
        }
    }

     @Test(retryAnalyzer = RetryAnalyzer.class)
    public void TC_018() {

        BaseLogin();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        //Scrolling to the plus button.
        try {
            driver.findElement(AppiumBy.androidUIAutomator
                    ("new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(resourceId(\"com.moai.android:id/imgAddReminder\"));"));
        } catch (Exception e) {
            logger.warning("Scroll to the element is not happen.");
        }

        try {
            //Clicking the plus button
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.moai.android:id/imgAddReminder"))).click();

            //Clicking the SpO2 radio button.
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.moai.android:id/rbSpo2"))).click();

            //Clicking the DONE button.
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.moai.android:id/txtSubmit"))).click();
        } catch (Exception e) {
            logger.warning("New reminder selection for spo2 is not happen.");
        }

        try {
            //reminder name
            wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.
                    id("com.moai.android:id/edtReminderName"))).sendKeys("SpO2 reminder ");
            //Selecting the required days
            wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.moai.android:id/txtSUN"))).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.moai.android:id/txtMUN"))).click();
        } catch (Exception e) {
            logger.warning("Reminder name and days are not selected.");
        }

        try {
            //Click add Button.
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.moai.android:id/chipAdd"))).click();

            //Selecting the Hour.
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("9"))).click();

            //Selecting the Minutes.
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("15"))).click();

            //Clicking the ok
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("android:id/button1"))).click();
        } catch (Exception e) {
            logger.warning("Set time for the reminder is not happen.");
        }

        //Checking whether the reminder time is added or not.
        WebElement timer = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.moai.android:id/chipText")));
        logger.info("Timer is added :"+timer.isDisplayed());

        try {
            driver.findElement(AppiumBy.androidUIAutomator
                    ("new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(resourceId(\"com.moai.android:id/edtPersonalNotes\"));")).sendKeys("Take");
        } catch (Exception e) {
            logger.warning("Scroll is not happen.");
        }

        try {
            //Adding personal notes.
            wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.
                    id("com.moai.android:id/edtPersonalNotes"))).sendKeys("Take SpO2");

            //Set the reminder
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.moai.android:id/txtSetReminder"))).click();
            logger.info("Personal note is added.");
        } catch (Exception e) {
            logger.warning("Adding personal note is not happen.");
        }
    }

     @Test(retryAnalyzer = RetryAnalyzer.class)
    public void TC_019() {

        BaseLogin();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        //Verify the care circle is present in the screen
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.moai.android:id/imgOtherProfile")));
            WebElement CareCircle = driver.findElement(AppiumBy.id("com.moai.android:id/imgOtherProfile"));
            logger.info("Care is present : " + CareCircle.isDisplayed());
            System.out.println();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        try {
            //Care circle button.
            wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.moai.android:id/imgOtherProfile"))).click();
        } catch (Exception e) {
            logger.warning("care circle button is not visible.");
        }

        //permission
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id
                    ("com.android.packageinstaller:id/permission_allow_button"))).click();
        } catch (Exception e) {
            logger.warning("Permission is not allowed.");
        }

        //Add member
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.moai.android:id/tvAddMembers"))).click();
        } catch (Exception e) {
            logger.warning("Add member is not happen.");
        }

        //1.clicking the kebab menu
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("More options"))).click();

            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.androidUIAutomator
                    ("new UiSelector().text(\"Delete Care Circle\")"))).click();
        } catch (Exception e) {
            logger.warning("Clicking the kebab for delete care circel is not happen.");
        }

        //Confirmation for deleting the care circle
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("android:id/button1"))).click();
            WebElement SuccessToast =  wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.moai.android:id/dialog_layout_toaster")));
            logger.info("Success toast : " + SuccessToast.getText());
        } catch (Exception e) {
            logger.warning("Confirmation Ok for delete care circle is not happen.");
        }
    }

     @Test(retryAnalyzer = RetryAnalyzer.class)
    public void TC_025() {
        BaseLogin();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.androidUIAutomator("new UiSelector().text(\"+2\")"))).click();

        try {
            //1.Verify the dependent list
            wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.androidUIAutomator("new UiSelector().text(\"Kavya\")")));
            WebElement Dependent_1 = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Kavya\")"));
            logger.info(Dependent_1.getText() + " is one of the dependent is present : " + Dependent_1.isDisplayed());
        } catch (Exception e) {
            logger.warning("Dependent is not available.");
        }

        try {
            //2.Edit the dependent profile, click on kebab menu.
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

     @Test(retryAnalyzer = RetryAnalyzer.class)
    public void TC_026() {

        BaseLogin();

        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.androidUIAutomator("new UiSelector().text(\"+2\")"))).click();

            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.androidUIAutomator
                    ("new UiSelector().resourceId(\"com.moai.android:id/imgMenu\").instance(0)"))).click();

            //Clicking the health report option to navigate to report section.
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.androidUIAutomator("new UiSelector().text(\"Health Report\")"))).click();

            wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.androidUIAutomator("new UiSelector().text(\"Blood Pressure\")")));
            WebElement lable = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Blood Pressure\")"));
            logger.info("Report section : " + lable.getText());
        } catch (Exception e) {
            logger.warning("Not moved to the Report section of the dependent.");
        }
    }

     @Test(retryAnalyzer = RetryAnalyzer.class)
    public void TC_027() {

        /*Adding the reminder for Blood pressure.*/
        BaseLogin();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.moai.android:id/txtEcg"))).isDisplayed();

        //Scrolling to the plus button.
        try {
            driver.findElement(AppiumBy.androidUIAutomator
                    ("new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(resourceId(\"com.moai.android:id/imgAddReminder\"));"));
        } catch (Exception e) {
            logger.warning("Scroll to the element is not happen.");
        }

        //1.Clicking the plus button
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.moai.android:id/imgAddReminder"))).click();
        } catch (Exception e) {
            logger.warning("Clicking plus button is not happen.");
        }

        //Clicking the HR radio button.
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.moai.android:id/rbHR"))).click();
        } catch (Exception e) {
            logger.warning("Hr radio button click is not happen.");
        }

        //Selecting the DONE button.
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.moai.android:id/txtSubmit"))).click();
        } catch (Exception e) {
            logger.warning("Done button click is not happen.");
        }

        try {
            //2.reminder name
            wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.
                    id("com.moai.android:id/edtReminderName"))).sendKeys("Heart rate reminder");

            //Selecting the required days
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.moai.android:id/txtSUN"))).click();
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.moai.android:id/txtMUN"))).click();

            //Click add Button.
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.moai.android:id/chipAdd"))).click();

            //Selecting the Hour as 12.
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("9"))).click();

            //Selecting the Minutes as 00.
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("15"))).click();

            //Clicking the ok
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("android:id/button1"))).click();
        } catch (Exception e) {
            logger.warning("Setting up the reminder time and day selection is not happen.");
        }

        //Checking whether the reminder time is added or not.
        try {
            WebElement timer = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.moai.android:id/chipText")));
            logger.info("just checking whether the reminder time is added or not: " +timer.isDisplayed());
        } catch (Exception e) {
            logger.warning("Timer is not visible.");
        }

        try {
            //3.Adding invite
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.moai.android:id/imgAddReminder"))).click();

            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.androidUIAutomator
                    ("new UiSelector().resourceId(\"com.moai.android:id/mainLayout\").instance(0)"))).click();

            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.moai.android:id/txtSubmit"))).click();
        } catch (Exception e) {
            logger.warning("Add people to the reminder is not happen.");
        }

        try {
            //Scrolling to the Adding personal notes.
            driver.findElement(AppiumBy.androidUIAutomator
                    ("new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(resourceId(\"com.moai.android:id/edtPersonalNotes\"));"));
        } catch (Exception e) {
            logger.warning("Scroll to the element is not happen.");
        }

        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.
                    id("com.moai.android:id/edtPersonalNotes"))).sendKeys("Take HR daily.");

            //Set the reminder
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.moai.android:id/txtSetReminder"))).click();
        } catch (Exception e) {
            logger.warning("Set reminder is not happen.");
        }

    }

     @Test(retryAnalyzer = RetryAnalyzer.class)
    public void TC_028() {
       BaseLogin(); // Login process.

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

     @Test(retryAnalyzer = RetryAnalyzer.class)
    public void TC_029() {

        BaseLogin(); //Login process from base class.

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


     @Test(retryAnalyzer = RetryAnalyzer.class)
    public void TC_030()
    {
        BaseLogin(); //Login process.

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
