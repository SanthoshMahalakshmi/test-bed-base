package More;

import DriverManagerAndroid.BaseLoginForAndroid;
import DriverManagerAndroid.DriverManager;
import UtilitiesForAndroid.LogUtil;
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
    BaseLoginForAndroid bs = new BaseLoginForAndroid();

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void TC_033() throws Exception {

         bs.CoreLoginForAndroid(true);  //basic login scenario

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        //Clicking on more section
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.
                    androidUIAutomator("new UiSelector().text(\"More\")"))).click();
            LogUtil.info("Clicking the More section button.");
        } catch (Exception e) {
            LogUtil.warning("Clicking the more section button is not happening.");
            throw new ElementNotInteractableException(e.getMessage());
        }

        //1.Notification toggle off and on
        try {
            WebElement NotificationToggle = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.heartmonitor.android:id/swEnable")));

            if (NotificationToggle.isDisplayed())
            {
                NotificationToggle.click();
                LogUtil.info("Disabling the Notification using the toggle.");
            }
        } catch (Exception e) {
            LogUtil.warning("Notification toggle is not enabled.");
            throw new Exception(e.getMessage());
        }

        //All Notification section
        WebElement NotificationsBtn, NotificationHeader;
        try {
            NotificationsBtn = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.heartmonitor.android:id/txtNotification")));
            NotificationsBtn.click();
            LogUtil.info("Clicking the Notification button to view all the notifications.");

            NotificationHeader = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.androidUIAutomator("new UiSelector().text(\"Notifications\")")));
            LogUtil.info("User currently present in ? : " + NotificationHeader.getText() + " page.");
        } catch (Exception e) {
            LogUtil.warning("Notification section is not visible.");
        }

        WebElement ActualNotification;
        try {
            ActualNotification = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.androidUIAutomator
                    ("new UiSelector().resourceId(\"com.heartmonitor.android:id/llMain\").instance(0)")));
            LogUtil.info("Notification is present or not? : " + ActualNotification.isDisplayed());
        } catch (Exception e) {
            LogUtil.warning("No notification's are present currently.");
        }

        //navigate back
        WebElement BackBtn;
        try {
            BackBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.accessibilityId("Navigate up")));
            BackBtn.click();
            LogUtil.info("Clicking the back button.");
        } catch (Exception e) {
            LogUtil.warning("Clicking the back button is not happening.");
            throw new Exception(e.getMessage());
        }

        //2.Clicking on FAQ section
        WebElement FAQBtn;
        try {
            FAQBtn = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.heartmonitor.android:id/txtFaq")));
            FAQBtn.click();
            LogUtil.info("Clicking the FAQ's section button..");
        } catch (Exception e) {
            LogUtil.warning("Clicking the FAQ's section button is not happening.");
            throw new Exception(e.getMessage());
        }

        //FAQ's header
        try {
            WebElement FAQ_Header = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.androidUIAutomator("new UiSelector().text(\"FAQs\")")));
            LogUtil.info("User currently present in : " + FAQ_Header.getText() + " page.");
        } catch (Exception e) {
            LogUtil.warning("FAQ's header is not visible.");
            throw new Exception(e.getMessage());
        }

        //navigate back
        try {
            BackBtn.click();
            LogUtil.info("Clicking the back button.");
        } catch (Exception e) {
            LogUtil.warning("Navigation back is not happening.");
            throw new Exception(e.getMessage());
        }
    }

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void TC_034() throws Exception {

        LogUtil.info("Enter into TC_034");

         bs.CoreLoginForAndroid(true);  //basic login scenario

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        //Clicking on more section
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.
                    androidUIAutomator("new UiSelector().text(\"More\")"))).click();
        } catch (Exception e) {
            LogUtil.warning("Clicking more section is not happening.");
        }

        //1.Clicking on About us
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.heartmonitor.android:id/txtAboutUs"))).click();
            LogUtil.info("Moving to about us page.");
        } catch (Exception e) {
            LogUtil.warning("Clicking is not happening for about us.");
        }

        //About us header
        try {
            WebElement AboutUsHeader = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.androidUIAutomator
                    ("new UiSelector().text(\"About Us\")")));
            LogUtil.info("User currently present in : " + AboutUsHeader.getText());
        } catch (Exception e) {
            LogUtil.warning("About us header is not present.");
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
            LogUtil.info("About us content is present : " + Content.isDisplayed());
        } catch (Exception e) {
            LogUtil.warning("About us content is not visible.");
        }

        //navigate back
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.accessibilityId("Navigate up"))).click();
        } catch (Exception e) {
            LogUtil.warning("Navigating back is not working.");
        }

        //2.clicking on Terms & Conditions
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.heartmonitor.android:id/txtTerms"))).click();
            LogUtil.info("Moving to terms and condition section.");
        } catch (Exception e) {
            LogUtil.warning("Clicking the terms and condition is not working.");
        }

        //Terms and condition header
        try {
            WebElement TermsAndCondition = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.androidUIAutomator
                    ("new UiSelector().text(\"Terms & Conditions\")")));
            LogUtil.info("User currently present in : " + TermsAndCondition.getText());
        } catch (Exception e) {
            LogUtil.warning("Terms and condition header is not visible.");
        }

        //Terms and condition content.
        try {
            WebElement ContentOfTermsAndCondition = wait.until(ExpectedConditions.visibilityOfElementLocated
                    (AppiumBy.androidUIAutomator("new UiSelector().text(\"Terms & Conditions\")")));
            LogUtil.info("Terms and Condition content is present : " + ContentOfTermsAndCondition.isDisplayed());
        } catch (Exception e) {
            LogUtil.warning("Terms and condition content is not visible.");
        }

        //navigate back
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.accessibilityId("Navigate up"))).click();
        } catch (Exception e) {
            LogUtil.warning("Navigating back is not working.");
        }

        //3.Clicking on Privacy policy
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.heartmonitor.android:id/txtPrivacy"))).click();
            LogUtil.info("Moving to Privacy policy.");
        } catch (Exception e) {
            LogUtil.warning("Clicking privacy policy is not working.");
        }

        //Privacy policy header
        try {
            WebElement PrivacyPloicy = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.androidUIAutomator
                    ("new UiSelector().text(\"Privacy Policy\")")));
            LogUtil.info("User currently present in : " + PrivacyPloicy.getText());
        } catch (Exception e) {
            LogUtil.warning("Privacy policy header is not visible.");
        }

        //Privacy policy content.
        try {
            WebElement PrivacyPolicyContent = wait.until(ExpectedConditions.visibilityOfElementLocated
                    (AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.TextView\").instance(2)")));
            LogUtil.info("Privacy policy content is present : " + PrivacyPolicyContent.isDisplayed());
        } catch (Exception e) {
            LogUtil.warning("Privacy policy content is not visible.");
        }

        //navigate back
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.accessibilityId("Navigate up"))).click();
        } catch (Exception e) {
            LogUtil.warning("");
        }
    }

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void TC_035() throws Exception {

        LogUtil.info("Enter into TC_035");

         bs.CoreLoginForAndroid(true);  //basic login scenario

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        //Clicking on more section
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.
                    androidUIAutomator("new UiSelector().text(\"More\")"))).click();
        } catch (Exception e) {
            LogUtil.warning("Not moving to more section.");
        }

        //Clicking on logout
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.heartmonitor.android:id/txtLogout"))).click();
        } catch (Exception e) {
            LogUtil.warning("logout is not clicked.");
        }

        //Warning message.
        try {
            WebElement Message = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("android:id/message")));
            LogUtil.info("Confirmation message for logout : " + Message.getText());
        } catch (Exception e) {
            LogUtil.warning("Logout warning message is not coming.");
        }

        //Ok button
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("android:id/button1"))).click();
        } catch (Exception e) {
            LogUtil.warning("Logout OK button is not coming.");
        }

        //Verifying the singUp page.
        try {
            WebElement SignUp = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.heartmonitor.android:id/txtPhoneLabel")));
            LogUtil.info("User currently present :" + SignUp.getText());
        } catch (Exception e) {
            LogUtil.warning("Not moving to the Sign up page again after the logout.");
        }

    }

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void TC_036() throws Exception {

        LogUtil.info("Enter into TC_036");

         bs.CoreLoginForAndroid(true);  //basic login scenario

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        //Clicking on more section
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.
                    androidUIAutomator("new UiSelector().text(\"More\")"))).click();
        } catch (Exception e) {
            LogUtil.warning("Not moving to more section.");
        }

        //Clicking on delete account
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.
                    id("com.heartmonitor.android:id/txtDeleteAcc"))).click();
        } catch (Exception e) {
            LogUtil.warning("Deleting account is not clicked.");
        }

        //Delete account label
        try {
            WebElement DeleteAccountLabel = wait.until(ExpectedConditions.
                    visibilityOfElementLocated(AppiumBy.id("com.heartmonitor.android:id/alertTitle")));
            LogUtil.info("Label of delete account : " + DeleteAccountLabel.getText());
        } catch (Exception e) {
            LogUtil.warning("label is not visible.");
        }

        //Confirmation message
        try {
            WebElement DeleteMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("android:id/message")));
            LogUtil.info("Delete account confirmation message : " + DeleteMessage.getText());
        } catch (Exception e) {
            LogUtil.warning("delete account confirmation is not visible. ");
        }

        //ok button
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("android:id/button1")));
            LogUtil.info("Ok button is visible, but we are not deleting the account now.");
        } catch (Exception e) {
            LogUtil.warning("OK button is not visible.");
        }

        //Cancel button.
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("android:id/button2"))).click();
            LogUtil.info("Clicking cancel for not deleting the account.");
        } catch (Exception e) {
            LogUtil.warning("Cancel button is not visible.");
        }

    }

}
