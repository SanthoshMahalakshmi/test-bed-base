package DashBoard;

import Actions.iOSElementTask;
import DriverManagerIos.BaseLoginForiOS;
import DriverManagerIos.DriverManager;
import UtilitiesForIos.LogUtil;
import UtilitiesForIos.RetryAnalyzerios;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NoSuchElementException;

import static UtilitiesForIos.iOSElementActions.performIOSActions;
import static iOSElemenRepositories.iOSDashBoardScreenElements.*;

public class DashBoard_Page_Ios extends DriverManager {

    BaseLoginForiOS baseLoginForiOS = new BaseLoginForiOS();

    @Test
    public void TC_010() {
        baseLoginForiOS.BaseLoginForIos(false); // Launch the app


    }


    @Test(retryAnalyzer = RetryAnalyzerios.class)
    public void TC_011() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        Map<By, iOSElementTask> iOSElementMap1 = new LinkedHashMap<>();

        performIOSActions(iOSElementMap1, wait);
    }

    @Test(retryAnalyzer = RetryAnalyzerios.class)
    public void TC_012() {

        baseLoginForiOS.BaseLoginForIos(false); // To complete the login process.

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        Map<By, iOSElementTask> iOSElementMap = new LinkedHashMap<>();

        iOSElementMap.put(iOS_DASHBOARD_CARE_CIRCLE_PLUS_BUTTON, iOS_DASHBOARD_CARE_CIRCLE_PLUS_BUTTON_TASK);

        performIOSActions(iOSElementMap, wait);

    }

    @Test(retryAnalyzer = RetryAnalyzerios.class)
    public void TC_013() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        //To enter into care circle.
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("ic heartHandBlueHomeIcon"))).click();
            LogUtil.info("Enter into care circle happening..");
        } catch (Exception e) {
            LogUtil.warning("Enter into care circle is not happening.");
        }

        //Kebab menu clicking to select the edit care circle option
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("ic dot menu white"))).click();
            LogUtil.info("Kebab menu is clicked to access the edit care circle option");

            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("Edit Care Circle"))).click();
            LogUtil.info("Clicking the edit care circle option.");

        } catch (Exception e) {
            LogUtil.warning("Kebab menu is not clicked to access the edit care circle option");
            LogUtil.warning("Clicking the edit care circle is not happening.");
        }

        //Edit the care circle name with less character and Click the submit to get the error for not enough character.
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.
                    className("XCUIElementTypeTextField"))).sendKeys("R");
            LogUtil.info("Care circle name is changed with less character.");

            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.
                    iOSClassChain("**/XCUIElementTypeStaticText[`name == \"Update\"`]"))).click();
            LogUtil.info("clicking the update button with less group name.");
        } catch (Exception e) {
            LogUtil.warning("Submit button is not working for getting the error of not enough character for group name.");
        }

        //Actual error.
        WebElement error1 = null;
        try {
            error1 = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.accessibilityId("Group name at least 5 characters.")));
            LogUtil.info("Not enough character error : " + error1.getText());
        } catch (Exception e) {
            LogUtil.warning("Error message is not pop-up for less character for care circle group name.");
        }

        //Clearing the input field.
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.className("XCUIElementTypeTextField"))).clear();
            LogUtil.info("Clearing the group name");
        } catch (Exception e) {
            LogUtil.warning("Clearing the group name field is not working.");
        }

        //To get empty input field error, clicking the update.
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.
                    iOSClassChain("**/XCUIElementTypeStaticText[`name == \"Update\"`]"))).click();
            LogUtil.info("Update click is happen with empty group name");
        } catch (Exception e) {
            LogUtil.warning("Update click is not happen with empty group name");
        }

        //Empty group name error.
        WebElement error2 = null;
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.accessibilityId("Please enter group name")));
            LogUtil.info("Empty input field error : " + error2.getText());
        } catch (Exception e) {
            LogUtil.warning("Empty input field error message is not visible.");
        }

    }


    @Test(retryAnalyzer = RetryAnalyzerios.class)
    public void TC_014() throws Exception {

        baseLoginForiOS.BaseLoginForIos(true);// To complete the login scenario.

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        //To enter into care circle.
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("ic heartHandBlueHomeIcon"))).click();
            LogUtil.info("Enter into care circle happening..");
        } catch (Exception e) {
            LogUtil.warning("Enter into care circle is not happening.");
        }

        //Allow the permission for accessing the contact list.
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.accessibilityId("OK"))).click();
            LogUtil.info("After clicking the plus to add contact, Permission access is popping-up.");
        } catch (Exception e) {
            LogUtil.warning("After clicking the plus to add contact, Permission access is not popping-up");
        }

        //Kebab menu clicking.
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("ic dot menu white"))).click();
            LogUtil.info("Kebab menu is clicked to access the edit care circle option");
        } catch (Exception e) {
            LogUtil.warning("Kebab menu is not clicked to access the edit care circle option");
        }

        //2.(i)Edit care circle option
        WebElement Edit_Care_circle = null;
        try {
            Edit_Care_circle = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("Edit Care Circle")));
            LogUtil.info("Edit care circle option is present " + Edit_Care_circle.isDisplayed());
        } catch (Exception e) {
            LogUtil.warning("");
        }

        //2.(ii)Kebab menu list with set reminder
        WebElement SetReminder = null;
        try {
            SetReminder = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.accessibilityId("Set Reminders")));
            LogUtil.info("Set reminder option is present in the list : " + SetReminder.isDisplayed());
        } catch (Exception e) {
            LogUtil.warning("Set reminder is not visible.");
        }

        //2.(iii)Kebab menu list with Delete care circle
        WebElement DeleteCareCircle = null;
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.accessibilityId("Delete Care Circle")));
            LogUtil.info("Delete care circle option is present in the list : " + DeleteCareCircle.isDisplayed());
        } catch (Exception e) {
            LogUtil.warning("Delete care circle is not visible");
        }

        //3.Clicking on the edit care circle option in the kebab menu
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("Edit Care Circle"))).click();
            LogUtil.info("Clicking the edit care circle");
        } catch (Exception e) {
            LogUtil.warning("Edit care circle click is not happening.");
        }

        //4.Clicking on the update to complete the change.
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.
                    iOSClassChain("**/XCUIElementTypeStaticText[`name == \"Update\"`]"))).click();
            LogUtil.info("Care circle is updated with existing values.");
        } catch (Exception e) {
            LogUtil.warning("Care circle is not updated with existing values.");
        }

    }

    @Test(retryAnalyzer = RetryAnalyzerios.class)
    public void TC_015() throws Exception {

        baseLoginForiOS.BaseLoginForIos(true); // To complete the login process.

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(13));

        //pre - Care circle button.
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.accessibilityId("ic heartHandBlueHomeIcon"))).click();
            LogUtil.info("clicking the care circle.");
        } catch (Exception e) {
            LogUtil.warning("Care circle is not visible ");
        }


        //pre - clicking the kebab menu
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("ic dot menu white"))).click();
            LogUtil.info("Kebab menu is clicked in the care circle page.");
        } catch (Exception e) {
            LogUtil.warning("clicking kebab menu is not happening in the care circle page.");
        }

        //1.clicking the Set reminder button in the kebab menu
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.
                    accessibilityId("Set Reminders"))).click();
            LogUtil.info("Set reminder is working.");
        } catch (Exception e) {
            LogUtil.warning("Set reminder from care circle is not happening");
        }

        //2.Verify the blood pressure radio button is selected by default.
        WebElement BP = null;
        try {
            BP = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.
                    iOSClassChain("**/XCUIElementTypeButton[`name == \"radioUnSelection\"`][1]")));
            BP.click();
            LogUtil.info("Bp reminder is selected default : " + BP.isDisplayed());
        } catch (Exception e) {
            LogUtil.warning("Bp radio button is not Enabled.");
        }

        //3.verify the ECG radio button is selectable
        WebElement ECG = null;
        try {
            ECG = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.
                    iOSClassChain("**/XCUIElementTypeButton[`name == \"radioUnSelection\"`][2]")));
            ECG.click();
            LogUtil.info("Ecg is selected : " + ECG.isDisplayed());
        } catch (Exception e) {
            LogUtil.warning("ECG radio button is not displayed.");
        }

        //4. verify the Spo2 reminder radio button is selectable
        WebElement Spo2 = null;
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.
                    iOSClassChain("**/XCUIElementTypeButton[`name == \"radioUnSelection\"`][3]")));
            Spo2.click();
            LogUtil.info("Spo2 is selected : " + Spo2.isDisplayed());
        } catch (Exception e) {
            LogUtil.warning("Spo2 radio button is not selectable.");
        }

        //5.Heart rate reminder radio button is selectable
        WebElement HR = null;
        try {
            HR = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.
                    iOSClassChain("**/XCUIElementTypeButton[`name == \"radioUnSelection\"`][4]")));
            HR.click();
            LogUtil.info("HR is selected : " + HR.isDisplayed());
        } catch (Exception e) {
            LogUtil.warning("Hr reminder radio is not visible");
        }

        //Done button
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.
                    iOSClassChain("**/XCUIElementTypeButton[`name == \"Done\"`]"))).click();
            LogUtil.info("Done button click is working.");
        } catch (Exception e) {
            LogUtil.warning("Done button click is not working");
        }

        //Add reminder name
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy
                            .iOSClassChain("**/XCUIElementTypeTextField[`value == \"Reminder Name\"`]")))
                    .sendKeys("Take Heart rate.");
            LogUtil.info("Reminder name is added.");
        } catch (Exception e) {
            LogUtil.warning("Add reminder name is not working.");
        }

        //Selecting the days for the reminder
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("MON"))).click();
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("TUE"))).click();
            LogUtil.info("Selecting the days for reminder is working.");
        } catch (Exception e) {
            LogUtil.warning("Selecting days for the reminder is not working.");
        }

        //Set the time for the reminder
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("Add"))).click();
            LogUtil.info("Set time for reminder is working");
        } catch (Exception e) {
            LogUtil.warning("Set time for reminder is not working.");
        }

        //clicking the done to Choose the Current time for the reminder.
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("Done"))).click();
            LogUtil.info("choose minutes is working");
        } catch (Exception e) {
            LogUtil.warning("Choose minute is not working");
        }

        //Using + to Adding invite to the reminder
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("Plus"))).click();
            LogUtil.info("invite the people is working.");
        } catch (Exception e) {
            LogUtil.warning("Invite the people is not working.");
        }

        //6.Add the invite to the reminder
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy
                    .xpath("//XCUIElementTypeTable/XCUIElementTypeCell/XCUIElementTypeOther[1]/XCUIElementTypeOther"))).click();
            LogUtil.info("Care circle people is added to the reminder.");
        } catch (Exception e) {
            LogUtil.warning("People is not added to the reminder");
        }

        //Clicking the add invite button
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy
                    .accessibilityId("**/XCUIElementTypeButton[`name == \"Add Invitee\"`]"))).click();
            LogUtil.info("Invite button click is working.");
        } catch (Exception e) {
            LogUtil.warning("Clicking invite button is not working.");
        }

        //Scrolling to personal note
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy
                            .iOSClassChain("**/XCUIElementTypeTextView[`value == \"Personal Notes\"`]")))
                    .sendKeys("Take care of yourself.");
            LogUtil.info("Scroll to the personal note and added input as well.");
        } catch (Exception e) {
            LogUtil.warning("Scroll to the  personal note is not happen");
        }

        //7.Confirm the reminder
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy
                    .iOSClassChain("**/XCUIElementTypeButton[`name == \"Set Reminder\"`]"))).click();
            LogUtil.info("Reminder set successfully.");
        } catch (Exception e) {
            LogUtil.warning("Reminder confirmation is not happen.");
        }
    }


    @Test(retryAnalyzer = RetryAnalyzerios.class)
    public void TC_016() throws Exception {

        baseLoginForiOS.BaseLoginForIos(true);// To complete the login process.

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        //Clicking the plus button for set reminder.
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy
                            .iOSClassChain("**/XCUIElementTypeButton[`name == \"Plus\"`][2]")))
                    .click();
            LogUtil.info("Clicking the plus is working");
        } catch (Exception e) {
            LogUtil.warning("plus button is not clicked");
        }

        //Clicking the SpO2 radio button.
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy
                            .iOSClassChain("**/XCUIElementTypeButton[`name == \"radioUnSelection\"`][3]")))
                    .click();
            LogUtil.info("Spo2 radio button is visible and it clicked.");
        } catch (Exception e) {
            LogUtil.warning("Spo2 radio button is not visible for a click.");
        }

        //Clicking the DONE button.
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy
                            .iOSClassChain("**/XCUIElementTypeButton[`name == \"Done\"`]")))
                    .click();
            LogUtil.info("Done is clicked");
        } catch (Exception e) {
            LogUtil.warning("Done is not clicked.");
        }

        //CASE - 1
        //1.Selecting the days for the reminder
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("MON"))).click();
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("WED"))).click();
            LogUtil.info("Days are selected for reminder.");
        } catch (Exception e) {
            LogUtil.warning("Selecting day is not working.");
        }

        //2.Unselect the days in the reminder
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("MON"))).click();
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("WED"))).click();
            LogUtil.info("De-Selecting the days is happen.");
        } catch (Exception e) {
            LogUtil.warning("De-Selecting the days is not working. ");
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
            LogUtil.info("Error 1 :" + EmptyReminderName.getText());
        } catch (Exception e) {
            LogUtil.warning("Empty reminder name error is not visible.");
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
            LogUtil.info("Error 2 :" + LessCharacterError.getText());
        } catch (Exception e) {
            LogUtil.warning("Less character error is not visible");
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
            LogUtil.info("Error 2 :" + DaysNotSelected.getText());
        } catch (Exception e) {
            LogUtil.warning("name is added");
        }

    }

    @Test(retryAnalyzer = RetryAnalyzerios.class)
    public void TC_017() throws Exception {

        baseLoginForiOS.BaseLoginForIos(true); // To complete the login process.

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        //Clicking the plus button for set reminder.
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy
                            .iOSClassChain("**/XCUIElementTypeButton[`name == \"Plus\"`][2]")))
                    .click();
            LogUtil.info("Clicking the plus is working");
        } catch (NoSuchElementException e) {
            LogUtil.warning("Plus button for set reminder is not found.");
        }

        //Clicking the SpO2 radio button.
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy
                            .iOSClassChain("**/XCUIElementTypeButton[`name == \"radioUnSelection\"`][3]")))
                    .click();
            LogUtil.info("Spo2 radio button is visible and it clicked.");
        } catch (Exception e) {
            LogUtil.warning("Spo2 radio button is not visible for a click.");
        }

        //Clicking the DONE button.
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy
                            .iOSClassChain("**/XCUIElementTypeButton[`name == \"Done\"`]")))
                    .click();
            LogUtil.info("Done is clicked");
        } catch (Exception e) {
            LogUtil.warning("Done is not clicked.");
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
            LogUtil.info("Empty personal note to generate the error");
        } catch (Exception e) {
            LogUtil.warning("Empty personal note is not");
        }

        //Actual Error creation for empty personal note.
        WebElement ErrorForNoPersonalNote = null;
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.accessibilityId("Please enter personal note.")));
            LogUtil.info("Error 1 :" + ErrorForNoPersonalNote.getText());
        } catch (Exception e) {
            LogUtil.warning("Empty personal note error is not visible.");
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
            LogUtil.warning("Clearing the personal note.");
        }

        //Confirm the reminder using set reminder button.
        WebElement ErrorForLessCharacterForPersonalNote = null;
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("Please add reminder time"))).click();
            LogUtil.info("Less character for personal note error :" + ErrorForLessCharacterForPersonalNote.getText());
        } catch (Exception e) {
            LogUtil.warning("Less character for personal note error is not coming.");
        }
    }

    @Test(retryAnalyzer = RetryAnalyzerios.class)
    public void TC_018() throws Exception {

        baseLoginForiOS.BaseLoginForIos(true);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        //Clicking the plus button for set reminder.
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy
                            .iOSClassChain("**/XCUIElementTypeButton[`name == \"Plus\"`][2]")))
                    .click();
            LogUtil.info("Clicking the plus is working");
        } catch (NoSuchElementException e) {
            LogUtil.warning("Plus button for set reminder is not found.");
        }

        //Clicking the SpO2 radio button.
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy
                            .iOSClassChain("**/XCUIElementTypeButton[`name == \"radioUnSelection\"`][3]")))
                    .click();
            LogUtil.info("Spo2 radio button is visible and it clicked.");
        } catch (Exception e) {
            LogUtil.warning("Spo2 radio button is not visible for a click.");
        }

        //Clicking the DONE button.
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy
                            .iOSClassChain("**/XCUIElementTypeButton[`name == \"Done\"`]")))
                    .click();
            LogUtil.info("Done is clicked");
        } catch (Exception e) {
            LogUtil.warning("Done is not clicked.");
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
            LogUtil.info("Reminder name date and reminder personal note is added.");
        } catch (Exception e) {
            LogUtil.warning("Set time for the reminder is not happen.");
        }

        //1.Adding reminder time.
        try {
            //Clicking the add button to add tome.
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("Add"))).click();

            //5.clicking the done set the current time for the reminder.
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("Done"))).click();

            LogUtil.info("Reminder time is added.");

        } catch (Exception e) {
            LogUtil.info("Reminder time is not added.");
        }

        //2.Editing the reminder time.
        try {
            //Clicking the add button to add tome.
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy
                    .xpath("//XCUIElementTypeScrollView/XCUIElementTypeCollectionView[2]" +
                            "/XCUIElementTypeCell[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeButton"))).click();

            //clicking the done set the current time for the reminder.
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("Done"))).click();

            LogUtil.info("Reminder time is edited.");

        } catch (Exception e) {
            LogUtil.info("Reminder time is not edited.");
        }

        //User click the cancel button to avoid setting time for reminder.
        WebElement Cancel = null;
        try {
            //Clicking the add button to add tome.
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("Add"))).click();

            //Cancel button click
            Cancel = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("Cancel")));
            LogUtil.info("Canceling the time set for reminder." + Cancel.isDisplayed());
            Cancel.click();
        } catch (Exception e) {
            LogUtil.warning("Cancel button is not visible.");
        }


    }

    @Test(retryAnalyzer = RetryAnalyzerios.class)
    public void TC_019() throws Exception {

        baseLoginForiOS.BaseLoginForIos(true);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        //Verify the care circle is present in the screen
        WebElement CareCircle = null;
        try {
            CareCircle = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.accessibilityId("ic heartHandBlueHomeIcon")));
            CareCircle.click();
            LogUtil.info("Care circle is clicked.");
        } catch (Exception e) {
            LogUtil.warning("Care circle is is not present to click.");
        }

        //clicking the kebab menu
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("ic dot menu white"))).click();

            //1.Clicking the Delete care circle to delete them.
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy
                    .accessibilityId("Delete Care Circle"))).click();
        } catch (Exception e) {
            LogUtil.warning("Clicking the kebab for delete care circel is not happen.");
        }

        //Confirmation for deleting the care circle
        WebElement ConfirmAlterMessage, SuccessToast = null;
        try {
            //Confirm alter message for deleting the care circle
            ConfirmAlterMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy
                    .accessibilityId("Are you sure you want to delete this Care Circle?")));
            LogUtil.info("Delete care circle message" + ConfirmAlterMessage.getText());

            //2.Clicking the Ok to delete the care circle.
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("OK")));

            wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.accessibilityId("Care circle removed successfully")));
            LogUtil.info("Success toast : " + SuccessToast.getText());
        } catch (Exception e) {
            LogUtil.warning("Success toast is not coming in the dashboard.");
        }
    }

    @Test(retryAnalyzer = RetryAnalyzerios.class)
    public void TC_025() throws Exception {
        baseLoginForiOS.BaseLoginForIos(true);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            //Clicking the primary user profile to check my dependent
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy
                    .xpath("//XCUIElementTypeScrollView/XCUIElementTypeOther" +
                            "/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther[1]" +
                            "/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther"))).click();
            LogUtil.info("Clicking the primary user profile to check My dependent section.");
        } catch (Exception e) {
            LogUtil.warning("Primary user profile is not there to click.");
        }

        try {
            //Clicking on my dependent profile
            wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.accessibilityId("My Dependents"))).click();

            //1.Verify the dependent list
            WebElement Dependent_1 = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy
                    .xpath("//XCUIElementTypeCell/XCUIElementTypeOther[1]/XCUIElementTypeOther")));
            LogUtil.info(Dependent_1.getText() + " is one of the dependent is present : " + Dependent_1.isDisplayed());
        } catch (Exception e) {
            LogUtil.warning("Dependent is not available.");
        }

        try {
            //2.Edit the dependent profile, click on kebab menu inspecting is not working in ios
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("ic dot menu"))).click();
            //Actual edit profile option.
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("Edit Profile"))).click();

            /*dependent profile name change*/
            wait.until(ExpectedConditions.visibilityOfElementLocated
                            (AppiumBy.iOSClassChain("//XCUIElementTypeOther[@name=\"CenterPageView\"]/XCUIElementTypeOther[1]")))
                    .sendKeys("NIHIL");

            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("ic back"))).click();
        } catch (Exception e) {
            LogUtil.warning("Edit the dependent profile is not happen.");
        }

        try {
            //3.Deleting the profile
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("Delete Profile"))).click();

            /*OK confirmation button for deleting the dependent profile.*/
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("OK"))).click();

            /*Deleting the dependent profile success toast*/
            WebElement message = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.accessibilityId("Dependent removed successfully")));

            LogUtil.info("Success message for deleted dependent :" + message.getText());
        } catch (Exception e) {
            LogUtil.warning("Deleting the dependent profile is not happen.s");
        }

    }

    @Test(retryAnalyzer = RetryAnalyzerios.class)
    public void TC_026() throws Exception {

        baseLoginForiOS.BaseLoginForIos(true);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            //Clicking the primary user profile to check my dependent
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy
                    .xpath("//XCUIElementTypeScrollView/XCUIElementTypeOther" +
                            "/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther[1]" +
                            "/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther"))).click();
            LogUtil.info("Clicking the primary user profile to check My dependent section.");
        } catch (Exception e) {
            LogUtil.warning("Not moved to the Report section of the dependent.");
        }

        try {
            //2.Edit the dependent profile, click on kebab menu inspecting is not working in ios
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("ic dot menu"))).click();

            //Clicking the health report option to navigate to report section.
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("Health Report"))).click();

            WebElement lable = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.accessibilityId("Blood Pressure")));
            LogUtil.info("Report section : " + lable.getText());
            LogUtil.info("We are in dependent profile report section.");
        } catch (Exception e) {
            LogUtil.warning("Blood pressure label is not there.");
        }
    }

    @Test(retryAnalyzer = RetryAnalyzerios.class)
    public void TC_027() throws Exception {

        /*Adding the reminder for Blood pressure.*/
        baseLoginForiOS.BaseLoginForIos(true);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            //1.User set up the reminder from the dashboard.
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy
                            .iOSClassChain("**/XCUIElementTypeButton[`name == \"Plus\"`][2]")))
                    .click();
            LogUtil.info("Clicking the plus is working");
        } catch (Exception e) {
            LogUtil.warning("plus button is not clicked");
        }

        //Clicking the SpO2 radio button.
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy
                            .iOSClassChain("**/XCUIElementTypeButton[`name == \"radioUnSelection\"`][3]")))
                    .click();
            LogUtil.info("Spo2 radio button is visible and it clicked.");
        } catch (Exception e) {
            LogUtil.warning("Spo2 radio button is not visible for a click.");
        }

        //Clicking the DONE button.
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy
                            .iOSClassChain("**/XCUIElementTypeButton[`name == \"Done\"`]")))
                    .click();
            LogUtil.info("Done is clicked");
        } catch (Exception e) {
            LogUtil.warning("Done is not clicked.");
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
            LogUtil.info("Set up  the reminder from the dashboard is happening.");
        } catch (Exception e) {
            LogUtil.warning("Set up the reminder form the dashboard is not happening.");
        }

        try {
            //3.Clicking the plus for invite the people to the reminder.
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("Plus"))).click();

            //Selecting the people for the reminder.
            wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy
                    .xpath("//XCUIElementTypeTable/XCUIElementTypeCell" +
                            "/XCUIElementTypeOther[1]/XCUIElementTypeOther"))).click();
            //Clicking on Add invite button for the confirmation.
            wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy
                    .xpath("**/XCUIElementTypeButton[`name == \"Add Invitee\"`]"))).click();
            LogUtil.info("Inviting the people to the reminder is happening");
        } catch (Exception e) {
            LogUtil.warning("Invite the people to the reminder is not working. ");
        }
    }

    @Test(retryAnalyzer = RetryAnalyzerios.class)
    public void TC_028() throws Exception {
        baseLoginForiOS.BaseLoginForIos(true); // Login process.

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        //BP report values with chart.
        WebElement bloodPressureElement, pressureChart, pressureValue = null;
        try {
            bloodPressureElement = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.accessibilityId("Blood Pressure")));
            LogUtil.info("Blood pressure report is present: " + bloodPressureElement.isDisplayed());

            try {
                pressureChart = wait.until(ExpectedConditions.visibilityOfElementLocated
                        (AppiumBy.accessibilityId("Line Chart. 7 datasets. DataSet, DataSet, DataSet, DataSet, DataSet, DataSet, DataSet")));
                LogUtil.info("Blood pressure report chart is present: " + pressureChart.isDisplayed());
            } catch (NoSuchCookieException e) {
                LogUtil.warning("There is no such element as pressure chart is visible.");
                throw new RuntimeException(e);
            }

            try {
                pressureValue = wait.until(ExpectedConditions.visibilityOfElementLocated
                        (AppiumBy.xpath("//XCUIElementTypeScrollView/XCUIElementTypeOther" +
                                "/XCUIElementTypeOther[3]/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther[1]")));
                LogUtil.info("Blood pressure value is present: " + pressureValue.getText());
            } catch (NoSuchElementException e) {
                LogUtil.warning("There is no such element as Pressure value is present.");
                throw new RuntimeException(e);
            }
        } catch (TimeoutException e) {
            LogUtil.warning("Bp chart is not visible.");
            throw new TimeoutException(e.getMessage());
        }

        WebElement hrElement, hrChart, hrValue = null;
        try {
            //Hr report values with chart.
            hrElement = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.accessibilityId("HR")));
            LogUtil.info("Heart rate report is present: " + hrElement.isDisplayed());

            hrChart = wait.until(ExpectedConditions.visibilityOfElementLocated
                    (AppiumBy.iOSClassChain("**/XCUIElementTypeOther[`name == \"Bar Chart. 1 dataset. \"`][1]")));
            LogUtil.info("Heart rate report chart is present: " + hrChart.isDisplayed());

            hrValue = wait.until(ExpectedConditions.visibilityOfElementLocated
                    (AppiumBy.xpath("//XCUIElementTypeScrollView/XCUIElementTypeOther/XCUIElementTypeOther[4]" +
                            "/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther[1]")));
            LogUtil.info("Heart rate value is present: " + hrValue.getText());
        } catch (Exception e) {
            LogUtil.warning("Hr report chart is not visible.");
        }

        WebElement Spo2Element, Spo2Chart, Spo2Value = null;
        try {
            //Spo2 report values with chart.
            Spo2Element = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.accessibilityId("SpO2")));
            LogUtil.info("Spo2 report is present: " + Spo2Element.isDisplayed());

            Spo2Chart = wait.until(ExpectedConditions.visibilityOfElementLocated
                    (AppiumBy.iOSClassChain("**/XCUIElementTypeOther[`name == \"Bar Chart. 1 dataset. \"`][2]")));
            LogUtil.info("Spo2 report chart is present: " + Spo2Chart.isDisplayed());

            Spo2Value = wait.until(ExpectedConditions.visibilityOfElementLocated
                    (AppiumBy.xpath("//XCUIElementTypeScrollView/XCUIElementTypeOther/XCUIElementTypeOther[5]" +
                            "/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther[1]")));
            LogUtil.info("Spo2 value is present: " + Spo2Value.getText());
        } catch (Exception e) {
            LogUtil.warning("Spo2 report chart is not visible.");
        }
    }
}
