package Profile;

import DriverManagerAndroid.BaseLoginForAndroid;
import DriverManagerAndroid.DriverManager;
import UtilitiesForAndroid.LogUtil;
import UtilitiesForAndroid.RetryAnalyzer;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import java.time.Duration;

public class Profile_Page_Android extends DriverManager {

    private static final Logger log = LoggerFactory.getLogger(Profile_Page_Android.class);
    BaseLoginForAndroid bs = new BaseLoginForAndroid();
    

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void TC_031() throws Exception {

        LogUtil.info("Enter into TC_031");

         bs.CoreLoginForAndroid(true);  //basic login scenario.

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        //DB string
        WebElement DB = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.heartmonitor.android:id/txtDashboard")));
        System.out.println("User present in : " + DB.getText());

        //1.Clicking on profile section
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.androidUIAutomator("new UiSelector().text(\"Profile\")"))).click();
            LogUtil.info("User on profile currently");
        } catch (Exception e) {
            LogUtil.warning("Profile section is not present");
        }

        //1.Clicking the edit for alcohol
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.heartmonitor.android:id/editConsume"))).click();
            LogUtil.info("User present in : Alcohol or smoke habit confirmation page");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        WebElement Yes = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.heartmonitor.android:id/txtAlcoholYes")));
        WebElement No = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.heartmonitor.android:id/txtAlcoholNo")));
        WebElement Occasionally = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.heartmonitor.android:id/txtAlcoholOther")));

        try {
            // Get the current selected text dynamically
            String currentSelection = "";
            if (Yes.getText().equals("Yes")) {
                currentSelection = "Yes";
            } else if (No.getText().equals("No")) {
                currentSelection = "No";
            } else if (Occasionally.getText().equals("Occasionally")) {
                currentSelection = "Occasionally";
            }

            // Use a switch to handle different cases
            switch (currentSelection) {
                case "Yes":
                    No.click();
                    LogUtil.info("Previously 'Yes' was selected for alcohol. Now changed to 'No'.");
                    break;
                case "No":
                    Yes.click();
                    LogUtil.info("Previously 'No' was selected for alcohol. Now changed to 'Yes'.");
                    break;
                case "Occasionally":
                    Yes.click();
                    LogUtil.info("Previously 'Occasionally' was selected for alcohol. Now changed to 'Yes'.");
                    break;
                default:
                    LogUtil.warning("No valid option is currently selected.");
                    break;
            }
        } catch (Exception e) {
            LogUtil.warning("An error occurred while toggling selection: " + e.getMessage());
        }

        WebElement YesForSmoke = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.heartmonitor.android:id/txtSmokeYes")));
        WebElement NoForSmoke = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.heartmonitor.android:id/txtSmokeNo")));
        ;
        WebElement occasionallyForSmoke = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.heartmonitor.android:id/txtSmokeOther")));
        ;
        try {
            if (YesForSmoke.getText().equals("Yes")) {
                NoForSmoke.click();
                LogUtil.info("Previously Yes is selected for smoke, Now changed to No.");
            } else if (NoForSmoke.getText().equals("No")) {
                YesForSmoke.click();
                LogUtil.info("Previously NO is selected for smoke, Now changed to Yes.");
            } else if (occasionallyForSmoke.getText().equals("Occasionally")) {
                YesForSmoke.click();
                LogUtil.info("Previously occasionally is selected for smoke, Now changed to Yes.");
            }
        } catch (Exception e) {
            LogUtil.warning("Nothing is selected for smoke it remains as it's.");
        }

        //Confirm with submit
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.heartmonitor.android:id/txtContinue"))).click();

        //Success toast for the update
        WebElement SuccessMeg = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.heartmonitor.android:id/text_message_toaster")));
        LogUtil.info("Success toast : " + SuccessMeg.getText());

        //2. Editing parameter range
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.heartmonitor.android:id/txtParameterRange"))).click();

        //Skip button
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.heartmonitor.android:id/tvSkip"))).click();
        } catch (Exception e) {
            LogUtil.warning("Skip is not present");
        }

        /*Checking the visibility of the element.*/
        WebElement Reset = null;
        try {
            Reset = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.heartmonitor.android:id/txtBPRest")));
            LogUtil.info("Reset is currently present.");
        } catch (Exception e) {
            LogUtil.warning("Reset is not present.");
        }

        /*Checking for customize button visibility*/
        WebElement Customize = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.
                androidUIAutomator("new UiSelector().resourceId(\"com.heartmonitor.android:id/txtCustomize1\").instance(0)")));
        LogUtil.info("Customize button is present, there is not reset button.");

        /*Checking for after customize button visibility*/
        WebElement AfterCustomize = null;
        try {
            AfterCustomize = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.heartmonitor.android:id/txtCustomize2")));
        } catch (Exception e) {
            LogUtil.warning("Customize 2 button is not present. bcz the reset button is not present");
        }

        /*Selecting the desired element based on the visibility*/
        try {
            LogUtil.info("Enter into if and elseif block");
            String CurrentSelection = "";
            if (Reset.isEnabled() == true) {
                CurrentSelection = "Reset";
            } else if (Customize.isEnabled() && Customize.getAttribute("resource-id").equals("com.heartmonitor.android:id/txtCustomize1")) {
                CurrentSelection = "Customize";
            } else if (AfterCustomize.isEnabled() && AfterCustomize.getAttribute("resource-id").equals("com.heartmonitor.android:id/txtCustomize2")) {
                CurrentSelection = "com.heartmonitor.android:id/txtCustomize2";
            }

            switch (CurrentSelection) {
                case "Reset":
                    try {
                        LogUtil.info("Reset button block is executing");
                        Reset.click();
                        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("android:id/button1"))).click();
                        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.heartmonitor.android:id/tvSkip"))).click();
                        LogUtil.info("Reset the previous setting");
                    } catch (Exception e) {
                        LogUtil.warning("Reset is not present.");
                    }
                    break;
                case "Customize":
                    try {
                        LogUtil.info("Customize button block is executing.");
                        WebElement skip = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.heartmonitor.android:id/tvSkip")));
                        if (skip.isEnabled()) {
                            skip.click();
                        }
                        Customize.click();
                        LogUtil.info("Normal customize is clicked ");
                    } catch (Exception e) {
                        LogUtil.warning("Normal customize is not present.");
                    }
                    break;
                case "com.heartmonitor.android:id/txtCustomize2":
                    try {
                        LogUtil.info("Customize 2 button block is executing.");
                        AfterCustomize.click();
                        LogUtil.info("After customize is present.");
                    } catch (Exception e) {
                        LogUtil.warning("After customize is not present.");
                    }
                    break;
                default:
                    LogUtil.warning("No valid option is currently selected.");
                    break;
            }
        } catch (Exception e) {
            LogUtil.warning("None of the above is selected and its not customized anything");
        }


       /* //Customize the Blood pressure
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.androidUIAutomator
                    ("new UiSelector().resourceId(\"com.heartmonitor.android:id/txtCustomize1\").instance(0)"))).click();
        } catch (Exception e) {
            LogUtil.warning("customize is not clickable");
        }

        //Submit the blood pressure
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.heartmonitor.android:id/txtSubmit"))).click();

        //After customized Skip button
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.heartmonitor.android:id/tvSkip"))).click();
        } catch (Exception e) {
            LogUtil.warning("After customized Skip is not present");
        }*/

        //Back to the profile section
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("Navigate up"))).click();

        //3.Editing My dependent
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.heartmonitor.android:id/txtMyDependent"))).click();

        //My dependent header
        WebElement MyD = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.androidUIAutomator("new UiSelector().text(\"My Dependent\")")));
        LogUtil.info("User present in : " + MyD.getText() + " page");

        //Clicking the kebab option
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.androidUIAutomator
                ("new UiSelector().resourceId(\"com.heartmonitor.android:id/imgMenu\").instance(0)"))).click();

        //Clicking the Edit profile option.
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.androidUIAutomator("new UiSelector().text(\"Edit Profile\")"))).click();

        //Edit profile header
        WebElement EP = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.
                androidUIAutomator("new UiSelector().text(\"Edit Profile\")")));
        LogUtil.info("User present in : " + EP.getText() + " page");

        //Back to the profile section
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("Navigate up"))).click();

        // Clicking the home option
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("Navigate up"))).click();

        //Clicking on profile section
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.androidUIAutomator("new UiSelector().text(\"Profile\")"))).click();

    }

    @Test(enabled = true, retryAnalyzer = RetryAnalyzer.class)
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
