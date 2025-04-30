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
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.androidUIAutomator("new UiSelector().text(\"More\")"))).click();
            LogUtil.info("Clicking the More section button.");
        } catch (Exception e) {
            LogUtil.warning("Clicking the more section button is not happening.");
            throw new ElementNotInteractableException(e.getMessage());
        }

        //1.Notification toggle off and on
        try {
            WebElement NotificationToggle = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.heartmonitor.android:id/swEnable")));
            if (NotificationToggle.isDisplayed()) {
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
            if (NotificationsBtn.isDisplayed()) {
                NotificationsBtn.click();
                LogUtil.info("Clicking the Notification button to view all the notifications.");
            }

            NotificationHeader = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.androidUIAutomator("new UiSelector().text(\"Notifications\")")));
            if (NotificationHeader.isDisplayed()) {
                LogUtil.info("User currently present in ? : " + NotificationHeader.getText() + " page.");
            }

        } catch (Exception e) {
            LogUtil.warning("No Notification is not visible now.");
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

        bs.CoreLoginForAndroid(true);  //basic login scenario

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        //Clicking on more section
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.androidUIAutomator("new UiSelector().text(\"More\")"))).click();
            LogUtil.info("Clicking the More section button.");
        } catch (Exception e) {
            LogUtil.warning("Clicking the more section button is not happening.");
            throw new ElementNotInteractableException(e.getMessage());
        }

        //1.Clicking on About
        WebElement AboutUsBtn;
        try {
            AboutUsBtn = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.heartmonitor.android:id/txtAboutUs")));
            if (AboutUsBtn.isDisplayed()) {
                AboutUsBtn.click();
                LogUtil.info("Moving to about us page.");
            }
        } catch (Exception e) {
            LogUtil.warning("Clicking is not happening for about us.");
            throw new Exception(e.getMessage());
        }

        //About us header
        WebElement AboutUsHeader;
        try {
            AboutUsHeader = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.androidUIAutomator("new UiSelector().text(\"About Us\")")));
            if (AboutUsHeader.isDisplayed()) {
                LogUtil.info("User currently present in : " + AboutUsHeader.getText() + "Page.");
            }
        } catch (Exception e) {
            LogUtil.warning("About us header is not present.");
            throw new Exception(e.getMessage());
        }

        //navigate back
        WebElement BackBtn;
        try {
            BackBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.accessibilityId("Navigate up")));
            if (BackBtn.isEnabled()) {
                BackBtn.click();
                LogUtil.info("Clicking the back button.");
            }
        } catch (Exception e) {
            LogUtil.warning("Clicking the back button is not happening.");
            throw new Exception(e.getMessage());
        }

        //2.clicking on Terms & Conditions
        WebElement TermsAndConditions;
        try {
            TermsAndConditions = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.heartmonitor.android:id/txtTerms")));
            if (TermsAndConditions.isDisplayed()) {
                TermsAndConditions.click();
                LogUtil.info("Clicking to Terms & conditions.");
            }
        } catch (Exception e) {
            LogUtil.warning("Clicking the terms and condition is not working.");
            throw new Exception(e.getMessage());
        }

        //Terms and condition header
        WebElement TermsAndConditionHeader;
        try {
            TermsAndConditionHeader = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.androidUIAutomator("new UiSelector().text(\"Terms & Conditions\")")));
            if (TermsAndConditionHeader.isDisplayed()) {
                LogUtil.info("User currently present in : " + TermsAndConditionHeader.getText());
            }
        } catch (Exception e) {
            LogUtil.warning("Terms and condition header is not visible.");
            throw new Exception(e.getMessage());
        }

        //Terms and condition content.
        WebElement ContentOfTermsAndCondition;
        try {
            ContentOfTermsAndCondition = wait.until(ExpectedConditions.visibilityOfElementLocated
                    (AppiumBy.androidUIAutomator("new UiSelector().text(\"This  is a legal agreement (“Agreement”) between you (End-user or you) and Connected Health, a Division of Tata Industries, having its registered address at Bombay House, " +
                            "24 Homi Modi Street, Mumbai 400001(Licensor, us or we) for the use of the MoAI Application Software (App, as defined below) and MoAI Cloud Service (Service, as defined below).\")")));
            if (ContentOfTermsAndCondition.isDisplayed())
            {
                LogUtil.info("Terms and Condition content is present : " + ContentOfTermsAndCondition.isDisplayed());
            }
        } catch (Exception e) {
            LogUtil.warning("Terms and condition content is not visible.");
            throw new Exception(e.getMessage());
        }

        //navigate back
        try {
            if (BackBtn.isEnabled()) {
                BackBtn.click();
                LogUtil.info("Clicking the back button.");
            }
        } catch (Exception e) {
            LogUtil.warning("Clicking the back button is not happening.");
            throw new Exception(e.getMessage());
        }

        //3.Clicking on Privacy policy
        WebElement PrivacyPolicyBtn;
        try {
            PrivacyPolicyBtn = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.heartmonitor.android:id/txtPrivacy")));
            if (PrivacyPolicyBtn.isDisplayed())
            {
                PrivacyPolicyBtn.click();
                LogUtil.info("Moving to Privacy policy.");
            }
        } catch (Exception e) {
            LogUtil.warning("Clicking privacy policy is not working.");
            throw new Exception(e.getMessage());
        }

        //Privacy policy header
        WebElement PrivacyPolicyHeader;
        try {
             PrivacyPolicyHeader = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.androidUIAutomator("new UiSelector().text(\"Privacy Policy\")")));
             if (PrivacyPolicyHeader.isDisplayed())
             {
                 LogUtil.info("User currently present in : " + PrivacyPolicyHeader.getText() + "page.");
             }
        } catch (Exception e) {
            LogUtil.warning("Privacy policy header is not visible.");
            throw new Exception(e.getMessage());
        }

        //Privacy policy content.
        WebElement PrivacyPolicyContent;
        try {
             PrivacyPolicyContent = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.TextView\").instance(2)")));
            if (PrivacyPolicyContent.isDisplayed()) {
                LogUtil.info("Privacy Policy content is present : " + PrivacyPolicyContent.isDisplayed());
            }
        } catch (Exception e) {
            LogUtil.warning("Privacy Policy content is not visible.");
            throw new Exception(e.getMessage());
        }

        //navigate back
        try {
            if (BackBtn.isEnabled()) {
                BackBtn.click();
                LogUtil.info("Clicking the back button.");
            }
        } catch (Exception e) {
            LogUtil.warning("Clicking the back button is not happening.");
            throw new Exception(e.getMessage());
        }
    }

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void TC_035() throws Exception {

        bs.CoreLoginForAndroid(true);  //basic login scenario

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        //Clicking on more section
        WebElement MoreBtn;
        try {
            MoreBtn = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.androidUIAutomator("new UiSelector().text(\"More\")")));
            if (MoreBtn.isDisplayed())
            {
                MoreBtn.click();
                LogUtil.info("Clicking the More section button.");
            }
        } catch (Exception e) {
            LogUtil.warning("Clicking the more section button is not happening.");
            throw new ElementNotInteractableException(e.getMessage());
        }

        //Clicking on logout
        WebElement LogoutBtn;
        try {
            LogoutBtn = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.heartmonitor.android:id/txtLogout")));
            if (LogoutBtn.isDisplayed())
            {
                LogoutBtn.click();
                LogUtil.info("Clicking the logout button.");
            }
        } catch (Exception e) {
            LogUtil.warning("Clicking the logout is not happened..");
            throw new Exception(e.getMessage());
        }

        //Warning message.
        WebElement LogoutWarningMessage;
        try {
            LogoutWarningMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("android:id/message")));
            if (LogoutWarningMessage.isDisplayed())
            {
                LogUtil.info("Confirmation message for logout : " + LogoutWarningMessage.getText());
            }
        } catch (Exception e) {
            LogUtil.warning("Logout warning message  model is not pop's out.");
            throw new Exception(e.getMessage());
        }

        //Ok button.
        WebElement LogoutOkBtn;
        try {
            LogoutOkBtn = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("android:id/button1")));
            if (LogoutOkBtn.isDisplayed())
            {
                LogoutOkBtn.click();
                LogUtil.info("Clicking the Logout 'Ok' Button now.");
            }
        } catch (Exception e) {
            LogUtil.warning("Logout 'Ok' button is not visible.");
            throw new Exception(e.getMessage());
        }

        //Verifying the singUp page.
        WebElement SignUpPage;
        try {
            SignUpPage = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.heartmonitor.android:id/txtPhoneLabel")));
            if (SignUpPage.isDisplayed()) {
                LogUtil.info("User currently present : " + SignUpPage.getText());
                LogUtil.info("User logged out successfully.");
            }
        } catch (Exception e) {
            LogUtil.warning("Not moving to the Sign up page again after the logout.");
            throw new Exception(e.getMessage());
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
