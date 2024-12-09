package More;

import DriverManagerAndroid.DriverManager;
import UtilitiesForAndroid.RetryAnalyzer;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import java.time.Duration;

public class More_page_Android extends DriverManager {
    private static final Logger log = LoggerFactory.getLogger(More_page_Android.class);

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void TC_033() {
        BaseLogin(); // Login process

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        //Clicking on more section
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.
                    androidUIAutomator("new UiSelector().text(\"More\")"))).click();
            logger.info("Enter into more section now.");
        } catch (Exception e) {
            throw new ElementNotInteractableException(e.getMessage());
        }

        //1.Notification toggle off and on
        try {
            WebElement NotificationToggle = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.
                    id("com.moai.android:id/swEnable")));
            logger.info("Notification toggle is enabled : " + NotificationToggle.isEnabled());
            NotificationToggle.click();
            logger.info("Notification toggle is working.");
        } catch (Exception e) {
            logger.warning("Notification toggle is not enabled.");
        }

        //All Notification section
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.moai.android:id/txtNotification"))).click();

            WebElement NotificationHeader = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.androidUIAutomator
                    ("new UiSelector().text(\"Notifications\")")));
            logger.info("User currently present in : " + NotificationHeader.getText() + " page.");
        } catch (Exception e) {
            logger.warning("Notification section is not visible.");
        }

        WebElement ActualNotification = null;
        try {
            ActualNotification = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.androidUIAutomator
                    ("new UiSelector().resourceId(\"com.moai.android:id/llMain\").instance(0)")));
            logger.info("Notification is present : " + ActualNotification.getText());
        } catch (Exception e) {
            logger.warning("No notification's are present currently.");
        }

        //User can click the notification to view the details of it.
        try {
            ActualNotification.click();
        } catch (Exception e) {
            logger.warning("No notification's are present currently.");
        }

        //notification description
        try {
            WebElement Description = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.
                    id("com.moai.android:id/description")));
            logger.info("Notification description :" + Description.getText());
        } catch (Exception e) {

            logger.warning("No notification is present and no description are available.");
        }

        //notification time
        try {
            WebElement time = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.moai.android:id/txtCurrentTime")));
            logger.info("Notification time : " + time.getText());
        } catch (Exception e) {
            logger.warning("No notification Time is visible.");
        }

        //Notification personal note
        try {
            WebElement PersonalNote = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.moai.android:id/txtCurrentTime")));
            logger.info("Notification personal note : " + PersonalNote.getText());
        } catch (Exception e) {
            logger.warning("NO Notification personal note is visible.");
        }

        //Notification Days
        try {
            WebElement NotificationDays = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.moai.android:id/tvWeekDay")));
            logger.info("Notification personal note : " + NotificationDays.getText());
        } catch (Exception e) {
            logger.warning("No Notification days is visible.");
        }

        //Done.
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.moai.android:id/tvOkay"))).click();
        } catch (Exception e) {
            logger.warning("Ok is not clicked after view the notification.");
        }

        //clear
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.moai.android:id/menu_clear"))).click();
        } catch (Exception e) {
            logger.warning("Clear button is not present may be there is no notification.");
        }

        //Clearing confirmation message.
        WebElement ConfirmationMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("android:id/message")));
        logger.info("Confirmation message : " + ConfirmationMessage.getText());

        //ok button for the clearing notification.
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("android:id/button1"))).click();
            logger.info("Ok button is clicked for clearing the notification.");
        } catch (Exception e) {
            logger.warning("Ok button is not clicked.");
        }

        //navigate back
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.accessibilityId("Navigate up"))).click();
        } catch (Exception e) {
            logger.warning("Navigation is not happen.");
        }

        //2.Clicking on FAQ section
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.moai.android:id/txtFaq"))).click();
            logger.info("MOved to FAQ's section.");
        } catch (Exception e) {
            logger.warning("Not moved to FAQ's section");
        }

        //FAQ's header
        try {
            WebElement FAQ_Header = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.androidUIAutomator("new UiSelector().text(\"FAQs\")")));
            logger.info("User currently present in : " + FAQ_Header.getText() + " page.");
        } catch (Exception e) {
            logger.warning("FAQ's header is not visible.");
        }

        //How to use this app
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.androidUIAutomator
                    ("new UiSelector().text(\"How to use this app?\")"))).click();
            WebElement HowToUseThisApp = wait.until(ExpectedConditions.visibilityOfElementLocated
                    (AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.moai.android:id/txtTitle2\").instance(0)")));
            logger.info("How to use this app content is present : " + HowToUseThisApp.isDisplayed());
        } catch (Exception e) {
            logger.warning("How to use this app description is not visible.");
        }

        //Why do we use it
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.androidUIAutomator
                    ("new UiSelector().text(\"Why do we use it?\")"))).click();
            WebElement WhyDoWeUseIt = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.
                    androidUIAutomator("new UiSelector().resourceId(\"com.moai.android:id/txtTitle2\").instance(1)")));
            logger.info("Why do we use it content is present : " + WhyDoWeUseIt.isDisplayed());
        } catch (Exception e) {
            logger.warning("No why do use it section is present.");
        }

        //navigate back
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.accessibilityId("Navigate up"))).click();
        } catch (Exception e) {
            logger.warning("Navigation back is not happening.");
        }

        //3.Clicking on Contact us
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.moai.android:id/txtContactUs"))).click();
        } catch (Exception e) {
            logger.warning("Not clicked the contact us section. ");
        }

        //Contact us header
        try {
            WebElement ContactUs = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.
                    androidUIAutomator("new UiSelector().text(\"Contact Us\")")));
            logger.info("User currently present in : " + ContactUs.getText() + " page.");
        } catch (Exception e) {
            logger.warning("Contact us header is not visible");
        }

        //To email address.
        try {
            WebElement To = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.moai.android:id/tvTo")));
            logger.info("User can see the To email address : " + To.isDisplayed());
        } catch (Exception e) {
            logger.warning("To email is not visible.");
        }

        //From email address.
        try {
            WebElement From = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.moai.android:id/tvFrom")));
            logger.info("User can see the To email address : " + From.isDisplayed());
        } catch (Exception e) {
            logger.warning("From email is not visible.");
        }

        //Write your message with minimum character. will get error.
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id
                    ("com.moai.android:id/edtMessage"))).sendKeys("th");
        } catch (Exception e) {
            logger.warning("Write your message is not visible");
        }

        //Submit
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.moai.android:id/txtSubmit"))).click();
        } catch (Exception e) {
            logger.warning("Submit button is not clicked now.");
        }

        //Error for less character
        try {
            WebElement ErrorText = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.moai.android:id/text_message_toaster")));
            logger.info("Error message for less character : " + ErrorText.getText());
        } catch (Exception e) {
            logger.warning("");
        }

        try {
            //Write your message
            wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id
                            ("com.moai.android:id/edtMessage"))).
                    sendKeys("Thanks for developing the application and try to resolve all the conflict.");
            logger.info("Write a message is happening.");
        } catch (Exception e) {
            logger.warning("Message is not added in the input box.");
        }

        //Submit
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.moai.android:id/txtSubmit"))).click();
        } catch (Exception e) {
            logger.warning("Submit is not happen.");
        }

        //Success message
        try {
            WebElement SuccessMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.moai.android:id/text_message_toaster")));
            logger.info("Success message for the : " + SuccessMessage.getText());
        } catch (Exception e) {
            logger.warning("Success message is not coming.");
        }

        //navigate back
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.accessibilityId("Navigate up"))).click();
        } catch (Exception e) {
            logger.warning("Navigating Back is not working.");
        }

    }

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void TC_034() {
        BaseLogin();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        //Clicking on more section
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.
                    androidUIAutomator("new UiSelector().text(\"More\")"))).click();
        } catch (Exception e) {
            logger.warning("Clicking more section is not happening.");
        }

        //1.Clicking on About us
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.moai.android:id/txtAboutUs"))).click();
            logger.info("Moving to about us page.");
        } catch (Exception e) {
            logger.warning("Clicking is not happening for about us.");
        }

        //About us header
        try {
            WebElement AboutUsHeader = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.androidUIAutomator
                    ("new UiSelector().text(\"About Us\")")));
            logger.info("User currently present in : " + AboutUsHeader.getText());
        } catch (Exception e) {
            logger.warning("About us header is not present.");
        }

        //About us content
        try {
            WebElement Content = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.androidUIAutomator
                    ("new UiSelector().text(\"What is Lorem Ipsum? Lorem Ipsum is " +
                            "simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, " +
                            "when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic " +
                            "typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum. Why do we use it? It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. " +
                            "The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here', making it look like readable English. Many desktop publishing packages and web page editors now use Lorem Ipsum as their default model text, and a search for 'lorem ipsum' will uncover many web sites still in their infancy. Various versions have evolved over the years, sometimes by accident, " +
                            "sometimes on purpose (injected humour and the like).\")")));
            logger.info("About us content is present : " + Content.isDisplayed());
        } catch (Exception e) {
            logger.warning("About us content is not visible.");
        }

        //navigate back
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.accessibilityId("Navigate up"))).click();
        } catch (Exception e) {
            logger.warning("Navigating back is not working.");
        }

        //2.clicking on Terms & Conditions
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.moai.android:id/txtTerms"))).click();
            logger.info("Moving to terms and condition section.");
        } catch (Exception e) {
            logger.warning("Clicking the terms and condition is not working.");
        }

        //Terms and condition header
        try {
            WebElement TermsAndCondition = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.androidUIAutomator
                    ("new UiSelector().text(\"Terms & Conditions\")")));
            logger.info("User currently present in : " + TermsAndCondition.getText());
        } catch (Exception e) {
            logger.warning("Terms and condition header is not visible.");
        }

        //Terms and condition content.
        try {
            WebElement ContentOfTermsAndCondition = wait.until(ExpectedConditions.visibilityOfElementLocated
                    (AppiumBy.androidUIAutomator("new UiSelector().text(\"Terms & Conditions\")")));
            logger.info("Terms and Condition content is present : " + ContentOfTermsAndCondition.isDisplayed());
        } catch (Exception e) {
            logger.warning("Terms and condition content is not visible.");
        }

        //navigate back
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.accessibilityId("Navigate up"))).click();
        } catch (Exception e) {
            logger.warning("Navigating back is not working.");
        }

        //3.Clicking on Privacy policy
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.moai.android:id/txtPrivacy"))).click();
            logger.info("Moving to Privacy policy.");
        } catch (Exception e) {
            logger.warning("Clicking privacy policy is not working.");
        }

        //Privacy policy header
        try {
            WebElement PrivacyPloicy = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.androidUIAutomator
                    ("new UiSelector().text(\"Privacy Policy\")")));
            logger.info("User currently present in : " + PrivacyPloicy.getText());
        } catch (Exception e) {
            logger.warning("Privacy policy header is not visible.");
        }

        //Privacy policy content.
        try {
            WebElement PrivacyPolicyContent = wait.until(ExpectedConditions.visibilityOfElementLocated
                    (AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.TextView\").instance(2)")));
            logger.info("Privacy policy content is present : " + PrivacyPolicyContent.isDisplayed());
        } catch (Exception e) {
            logger.warning("Privacy policy content is not visible.");
        }

        //navigate back
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.accessibilityId("Navigate up"))).click();
        } catch (Exception e) {
            logger.warning("");
        }
    }

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void TC_035() {
        BaseLogin();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        //Clicking on more section
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.
                    androidUIAutomator("new UiSelector().text(\"More\")"))).click();
        } catch (Exception e) {
            logger.warning("Not moving to more section.");
        }

        //Clicking on logout
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.moai.android:id/txtLogout"))).click();
        } catch (Exception e) {
            logger.warning("logout is not clicked.");
        }

        //Warning message.
        try {
            WebElement Message = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("android:id/message")));
            logger.info("Confirmation message for logout : " + Message.getText());
        } catch (Exception e) {
            logger.warning("Logout warning message is not coming.");
        }

        //Ok button
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("android:id/button1"))).click();
        } catch (Exception e) {
            logger.warning("Logout OK button is not coming.");
        }

        //Verifying the singUp page.
        try {
            WebElement SignUp = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.moai.android:id/txtPhoneLabel")));
            logger.info("User currently present :" + SignUp.getText());
        } catch (Exception e) {
            logger.warning("Not moving to the Sign up page again after the logout.");
        }

    }

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void TC_036() {
        BaseLogin();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        //Clicking on more section
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.
                    androidUIAutomator("new UiSelector().text(\"More\")"))).click();
        } catch (Exception e) {
            logger.warning("Not moving to more section.");
        }

        //Clicking on delete account
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.
                    id("com.moai.android:id/txtDeleteAcc"))).click();
        } catch (Exception e) {
            logger.warning("Deleting account is not clicked.");
        }

        //Delete account label
        try {
            WebElement DeleteAccountLabel = wait.until(ExpectedConditions.
                    visibilityOfElementLocated(AppiumBy.id("com.moai.android:id/alertTitle")));
            logger.info("Label of delete account : " + DeleteAccountLabel.getText());
        } catch (Exception e) {
            logger.warning("label is not visible.");
        }

        //Confirmation message
        try {
            WebElement DeleteMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("android:id/message")));
            logger.info("Delete account confirmation message : " + DeleteMessage.getText());
        } catch (Exception e) {
            logger.warning("delete account confirmation is not visible. ");
        }

        //ok button
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("android:id/button1")));
            logger.info("Ok button is visible, but we are not deleting the account now.");
        } catch (Exception e) {
            logger.warning("OK button is not visible.");
        }

        //Cancel button.
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("android:id/button2"))).click();
            logger.info("Clicking cancel for not deleting the account.");
        } catch (Exception e) {
            logger.warning("Cancel button is not visible.");
        }

    }

}
