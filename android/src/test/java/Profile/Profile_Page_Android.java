package Profile;

import DriverManagerAndroid.DriverManager;
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

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void TC_031() throws Exception {   /*User navigation from profile section */

        BaseLogin(); //Login process.

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        //DB string
        WebElement DB = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.moai.android:id/txtDashboard")));
        System.out.println("User present in : " + DB.getText());

        //1.Clicking on profile section
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.androidUIAutomator("new UiSelector().text(\"Profile\")"))).click();
            logger.info("User on profile currently");
        } catch (Exception e) {
            logger.warning("Profile section is not present");
        }

        //1.Clicking the edit for alcohol
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.moai.android:id/editConsume"))).click();
            logger.info("User present in : Alcohol or smoke habit confirmation page");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        WebElement Yes = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.moai.android:id/txtAlcoholYes")));
        WebElement No = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.moai.android:id/txtAlcoholNo")));
        WebElement Occasionally = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.moai.android:id/txtAlcoholOther")));

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
                    logger.info("Previously 'Yes' was selected for alcohol. Now changed to 'No'.");
                    break;
                case "No":
                    Yes.click();
                    logger.info("Previously 'No' was selected for alcohol. Now changed to 'Yes'.");
                    break;
                case "Occasionally":
                    Yes.click();
                    logger.info("Previously 'Occasionally' was selected for alcohol. Now changed to 'Yes'.");
                    break;
                default:
                    logger.warning("No valid option is currently selected.");
                    break;
            }
        } catch (Exception e) {
            logger.warning("An error occurred while toggling selection: " + e.getMessage());
        }

        WebElement YesForSmoke = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.moai.android:id/txtSmokeYes")));
        WebElement NoForSmoke = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.moai.android:id/txtSmokeNo")));
        ;
        WebElement occasionallyForSmoke = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.moai.android:id/txtSmokeOther")));
        ;
        try {
            if (YesForSmoke.getText().equals("Yes")) {
                NoForSmoke.click();
                logger.info("Previously Yes is selected for smoke, Now changed to No.");
            } else if (NoForSmoke.getText().equals("No")) {
                YesForSmoke.click();
                logger.info("Previously NO is selected for smoke, Now changed to Yes.");
            } else if (occasionallyForSmoke.getText().equals("Occasionally")) {
                YesForSmoke.click();
                logger.info("Previously occasionally is selected for smoke, Now changed to Yes.");
            }
        } catch (Exception e) {
            logger.warning("Nothing is selected for smoke it remains as it's.");
        }

        //Confirm with submit
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.moai.android:id/txtContinue"))).click();

        //Success toast for the update
        WebElement SuccessMeg = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.moai.android:id/text_message_toaster")));
        logger.info("Success toast : " + SuccessMeg.getText());

        //2. Editing parameter range
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.moai.android:id/txtParameterRange"))).click();

        //Skip button
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.moai.android:id/tvSkip"))).click();
        } catch (Exception e) {
            logger.warning("Skip is not present");
        }

        /*Checking the visibility of the element.*/
        WebElement Reset = null;
        try {
            Reset = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.moai.android:id/txtBPRest")));
            logger.info("Reset is currently present.");
        } catch (Exception e) {
            logger.warning("Reset is not present.");
        }

        /*Checking for customize button visibility*/
        WebElement Customize = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.
                androidUIAutomator("new UiSelector().resourceId(\"com.moai.android:id/txtCustomize1\").instance(0)")));
        logger.info("Customize button is present, there is not reset button.");

        /*Checking for after customize button visibility*/
        WebElement AfterCustomize = null;
        try {
            AfterCustomize = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.moai.android:id/txtCustomize2")));
        } catch (Exception e) {
            logger.warning("Customize 2 button is not present. bcz the reset button is not present");
        }

        /*Selecting the desired element based on the visibility*/
        try {
            logger.info("Enter into if and elseif block");
            String CurrentSelection = "";
            if (Reset.isEnabled() == true) {
                CurrentSelection = "Reset";
            } else if (Customize.isEnabled() && Customize.getAttribute("resource-id").equals("com.moai.android:id/txtCustomize1")) {
                CurrentSelection = "Customize";
            } else if (AfterCustomize.isEnabled() && AfterCustomize.getAttribute("resource-id").equals("com.moai.android:id/txtCustomize2")) {
                CurrentSelection = "com.moai.android:id/txtCustomize2";
            }

            switch (CurrentSelection) {
                case "Reset":
                    try {
                        logger.info("Reset button block is executing");
                        Reset.click();
                        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("android:id/button1"))).click();
                        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.moai.android:id/tvSkip"))).click();
                        logger.info("Reset the previous setting");
                    } catch (Exception e) {
                        logger.warning("Reset is not present.");
                    }
                    break;
                case "Customize":
                    try {
                        logger.info("Customize button block is executing.");
                        WebElement skip = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.moai.android:id/tvSkip")));
                        if (skip.isEnabled()) {
                            skip.click();
                        }
                        Customize.click();
                        logger.info("Normal customize is clicked ");
                    } catch (Exception e) {
                        logger.warning("Normal customize is not present.");
                    }
                    break;
                case "com.moai.android:id/txtCustomize2":
                    try {
                        logger.info("Customize 2 button block is executing.");
                        AfterCustomize.click();
                        logger.info("After customize is present.");
                    } catch (Exception e) {
                        logger.warning("After customize is not present.");
                    }
                    break;
                default:
                    logger.warning("No valid option is currently selected.");
                    break;
            }
        } catch (Exception e) {
            logger.warning("None of the above is selected and its not customized anything");
        }


       /* //Customize the Blood pressure
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.androidUIAutomator
                    ("new UiSelector().resourceId(\"com.moai.android:id/txtCustomize1\").instance(0)"))).click();
        } catch (Exception e) {
            logger.warning("customize is not clickable");
        }

        //Submit the blood pressure
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.moai.android:id/txtSubmit"))).click();

        //After customized Skip button
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.moai.android:id/tvSkip"))).click();
        } catch (Exception e) {
            logger.warning("After customized Skip is not present");
        }*/

        //Back to the profile section
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("Navigate up"))).click();

        //3.Editing My dependent
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.moai.android:id/txtMyDependent"))).click();

        //My dependent header
        WebElement MyD = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.androidUIAutomator("new UiSelector().text(\"My Dependent\")")));
        logger.info("User present in : " + MyD.getText() + " page");

        //Clicking the kebab option
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.androidUIAutomator
                ("new UiSelector().resourceId(\"com.moai.android:id/imgMenu\").instance(0)"))).click();

        //Clicking the Edit profile option.
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.androidUIAutomator("new UiSelector().text(\"Edit Profile\")"))).click();

        //Edit profile header
        WebElement EP = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.
                androidUIAutomator("new UiSelector().text(\"Edit Profile\")")));
        logger.info("User present in : " + EP.getText() + " page");

        //Back to the profile section
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("Navigate up"))).click();

        // Clicking the home option
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("Navigate up"))).click();

        //Clicking on profile section
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.androidUIAutomator("new UiSelector().text(\"Profile\")"))).click();

    }

    @Test(enabled = true, retryAnalyzer = RetryAnalyzer.class)
    public void TC_032() throws Exception {
        BaseLogin();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        //MOTO - Clicking on profile section
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.androidUIAutomator("new UiSelector().text(\"Profile\")"))).click();

        //1. Care circle
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.moai.android:id/txtCareCircle"))).click();
            logger.info("Care circle is clicked");
        } catch (Exception e) {
            logger.warning("Care circle is not visible.");
        }

        //Care circle header
        try {
            WebElement CC = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.
                    androidUIAutomator("new UiSelector().text(\"Care Circles\")")));
            logger.info("User present in : " + CC.getText() + " page");
        } catch (Exception e) {
            logger.warning("Care circle header is not present.");
        }

        //Care circle list
        try {
            WebElement CareCircle = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.androidUIAutomator
                    ("new UiSelector().className(\"android.view.ViewGroup\").instance(5)")));
            logger.info("My care circle : " + CareCircle.getText());
        } catch (Exception e) {
            logger.warning("Care circle list is not present.");
        }

        //Kebab menu click
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.androidUIAutomator
                    ("new UiSelector().resourceId(\"com.moai.android:id/ivOptions\").instance(0)"))).click();
        } catch (Exception e) {
            logger.warning("Kebab menu is not clicked.");
        }

        //Edit Care circle header
        try {
            WebElement CCL = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.
                    androidUIAutomator("new UiSelector().text(\"Edit Care Circle\")")));
            logger.info("User present in : " + CCL.getText() + " page");
        } catch (Exception e) {
            logger.warning("Header is not visible.");
        }

        try {
            //Clicking the Edit care circle option
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.
                    androidUIAutomator("new UiSelector().text(\"Edit Care Circle\")"))).click();
        } catch (Exception e) {
            logger.warning("Edit button is not visible for click action.");
        }

        //Allow button
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.
                    id("com.android.packageinstaller:id/permission_allow_button"))).click();
            logger.info("Allowing the app tp access the contact in the app.");
        } catch (Exception e) {
            logger.warning("Allow is not pop-up for permission");
        }

        //Selecting the contact
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.
                    androidUIAutomator("new UiSelector().resourceId(\"com.moai.android:id/ivProfilePicture\").instance(1)"))).click();
            logger.info("contact is selected for care circle.");
        } catch (Exception e) {
            logger.warning("Contact is not selected.");
        }

        //Add member button
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.moai.android:id/tvAddMembers"))).click();
            logger.info("Selected member is added to the care circle.");
        } catch (Exception e) {
            logger.warning("Add member is not clicked.");
        }

        //Changing the care circle name input field
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.
                    id("com.moai.android:id/edtGroupName"))).sendKeys("Family Group");
        } catch (Exception e) {
            logger.warning("Group name is not edited.");
        }

        //Update button
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.moai.android:id/tvOkay"))).click();
        } catch (Exception e) {
            logger.warning("Update button is not clicked");
        }

        // Clicking the home option
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.
                    androidUIAutomator("new UiSelector().description(\"Navigate up\")"))).click();
        } catch (Exception e) {
            logger.warning("Home button is not clicked.");
        }

        //Clicking on profile section
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.
                    androidUIAutomator("new UiSelector().text(\"Profile\")"))).click();
        } catch (Exception e) {
            logger.warning("Profile section is not clicked. Next action is device section.");
        }

        //Scroll to the bottom.
        try {
            driver.findElement(AppiumBy.androidUIAutomator
                    ("new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(resourceId(\"com.moai.android:id/txtMyReminder\"));"));
        } catch (Exception e) {
            logger.warning("Scroll to device is not working.");
        }

        //5.Clicking on My devices section.
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.moai.android:id/txtMyDevice"))).click();
            logger.info("User present in : My device page.");
        } catch (Exception e) {
            logger.warning("Not moved to the connected device page.");
        }

        //Connected device
        try {
            WebElement DeviceName = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.moai.android:id/txtDeviceName")));
            logger.info("Listed Device : " + DeviceName.getText());
        } catch (Exception e) {
            logger.warning("No connected device list.");
        }

        //Kebab menu on the device section
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.moai.android:id/imgMenu"))).click();
        } catch (Exception e) {
            logger.warning("Kebab menu is not present.");
        }

        //Connect device option
        WebElement ConnectDevice = null;
        try {
            ConnectDevice = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.
                    androidUIAutomator("new UiSelector().text(\"Connect Device\")")));
            logger.info("Connect device option list is present : " + ConnectDevice.isDisplayed());
            if (ConnectDevice.isDisplayed()) {
                logger.info("User can connect with the listed device by using connect device option.");
            }
            ConnectDevice.click();
        } catch (Exception e) {
            logger.warning("Connected device list is not visible. No device is currently present.");
        }

        //Back
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("Navigate up"))).click();
        } catch (Exception e) {
            logger.warning("Navigate back is not working.");
        }

        //Add Another device option
        try {
            WebElement AddAnother = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.
                    id("com.moai.android:id/txtAddAnotherDevice")));
            if (AddAnother.isDisplayed() == true) {
                logger.info("User can able to another device.");
            }
        } catch (Exception e) {
            logger.warning("Add another device is not clicked.");
        }

        //Device connection video
        try {
            WebElement Video = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.moai.android:id/imgVideoImage")));
            if (Video.isDisplayed()) {
                logger.info("User can get to know the how the device work.");
            }
        } catch (Exception e) {
            logger.warning("Video reference is not present.");
        }

        //MOTO - Clicking on profile section
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.androidUIAutomator("new UiSelector().text(\"Profile\")"))).click();
        } catch (Exception e) {
            logger.warning("Not moving to profile page. after device page.");
        }

        //Scroll to the bottom.
        try {
            driver.findElement(AppiumBy.androidUIAutomator
                    ("new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(resourceId(\"com.moai.android:id/txtMyReminder\"));"));
        } catch (Exception e) {
            logger.warning("Not scroll to the bottom to the reminder section.");
        }

        //6.Clicking on my reminder
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.moai.android:id/txtMyReminder"))).click();
            logger.info("Reminder section is clicked.");
        } catch (Exception e) {
            logger.warning("Reminder section is not clicked.");
        }

        //My reminder header
        try {
            WebElement MyR = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.
                    androidUIAutomator("new UiSelector().text(\"My Reminders\")")));
            logger.info("User present in : " + MyR.getText() + " page");
        } catch (Exception e) {
            logger.warning("Reminder header is not present.");
        }

        //Reminder list
        try {
            WebElement Reminder_1 = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.androidUIAutomator
                    ("new UiSelector().resourceId(\"com.moai.android:id/rlMainItem\").instance(0)")));
            logger.info("Reminder details : " + Reminder_1.getText());
        } catch (Exception e) {
            logger.warning("Reminder is not present currently.");
        }

        //Update reminder header
        try {
            WebElement upr = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.androidUIAutomator("new UiSelector().text(\"Update Reminder\").instance(0)")));
            logger.info("User present in : " + upr.getText() + " page");
        } catch (Exception e) {
            logger.warning("Reminder is not present for edit.");
        }

        //Edit the reminder name
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.
                    id("com.moai.android:id/edtReminderName"))).sendKeys("BP reminder.");
        } catch (Exception e) {
            logger.warning("Editing the reminder is not worked.");
        }

        //Adding reminder
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.androidUIAutomator
                    ("new UiSelector().resourceId(\"com.moai.android:id/menu_add\")"))).click();
            logger.info("Trying to add New reminder.");
        } catch (Exception e) {
            logger.warning("Add ned reminder button is not present.");
        }

        //Reminder list with default blood pressure radio button selected. clicking on done button.
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.moai.android:id/txtSubmit"))).click();
            logger.info("Adding reminder for default selected reminder set.");
        } catch (Exception e) {
            logger.warning("Submit button is not clicked.");
        }

        try {
            //Reminder name
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id
                    ("com.moai.android:id/edtReminderName"))).sendKeys("Blood pressure reminder.");
        } catch (Exception e) {

            logger.warning("Reminder name is not added.");
        }

        //Selecting the Day
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.moai.android:id/txtTUE"))).click();
        } catch (Exception e) {
            logger.warning("Day selecting is not happen.");
        }

        try {
            //Add time
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.moai.android:id/chipAdd"))).click();
            //Selecting time
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("3"))).click();
            //Selecting minutes
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("30"))).click();
            //Confirm with ok
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("android:id/button1"))).click();
        } catch (Exception e) {
            logger.warning("Add time is not happen.");
        }

        //Scroll to the bottom.
        try {
            driver.findElement(AppiumBy.androidUIAutomator
                    ("new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(resourceId(\"com.moai.android:id/edtPersonalNotes\"));"));
        } catch (Exception e) {
            logger.warning("Scroll to the bottom is not working.");
        }

        //Personal note
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.moai.android:id/edtPersonalNotes"))).sendKeys("Take care.");
        } catch (Exception e) {
            logger.warning("Personal note is not added.");
        }

        //Set reminder button
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.moai.android:id/txtSetReminder"))).click();
        } catch (Exception e) {
            logger.warning("Set reminder button is not clicked.");
        }

        //Deleting the reminder
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.
                    androidUIAutomator("new UiSelector().resourceId(\"com.moai.android:id/imgDelete\").instance(1)"))).click();
            //Confirmation
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("android:id/button1"))).click();
            logger.warning("Reminder is deleted.");
        } catch (Exception e) {
            logger.warning("Deleting reminder is not happen, may be reminder is not present");
        }

        //reminder deleted meg
        try {
            WebElement ReminderDeleteMeg = wait.until(ExpectedConditions.
                    visibilityOfElementLocated(AppiumBy.id("android:id/message")));
            logger.info("Deleted Message : " + ReminderDeleteMeg.getText());
            logger.info("Reminder is deleted.");
            //Confirm ok
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("android:id/button1"))).click();
        } catch (Exception e) {
            logger.warning("Deleted message is not coming bcz none of the delete reminder is deleted.");
        }

        //Back to home page
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("Navigate up"))).click();
        } catch (Exception e) {
            logger.warning("Navigate back is not working at last.");
        }

    }

}
