package More;

import DriverManagerIos.BaseLoginForiOS;
import DriverManagerIos.DriverManager;
import UtilitiesForIos.LogUtil;
import UtilitiesForIos.RetryAnalyzerios;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class More_page_Ios extends DriverManager {

    BaseLoginForiOS baseLoginForiOS = new BaseLoginForiOS();

    @Test(retryAnalyzer = RetryAnalyzerios.class)
    public void TC_033() throws Exception {

         baseLoginForiOS.BaseLoginForIos(true); // Login process

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        //Clicking on more section
        try {
           wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("ic_more"))).click();
            LogUtil.info("Clicking the More section button.");
        } catch (Exception e) {
            LogUtil.warning("Clicking the more section button is not happening.");
            throw new ElementNotInteractableException(e.getMessage());
        }

        //1.Notification toggle off and on
        try {
            WebElement NotificationToggle = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.iOSClassChain("**/XCUIElementTypeSwitch[`name == \"Notifications\"`]")));

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
            NotificationsBtn = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.iOSClassChain("**/XCUIElementTypeStaticText[`name == \"Notifications\"`]")));
            NotificationsBtn.click();
            LogUtil.info("Clicking the Notification button to view all the notifications.");

            NotificationHeader = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.accessibilityId("Notifications")));
            LogUtil.info("User currently present in ? : " + NotificationHeader.getText() + " page.");
        } catch (Exception e) {
            LogUtil.warning("Notification section is not visible.");
        }

        WebElement ActualNotification;
        try {
            ActualNotification = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.iOSClassChain("**/XCUIElementTypeButton[`name == \"Decline\"`][1]")));
            LogUtil.info("Notification is present or not? : " + ActualNotification.isDisplayed());
        } catch (Exception e) {
            LogUtil.warning("No notification's are present currently.");
        }

        //navigate back
        WebElement BackBtn;
        try {
            BackBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.accessibilityId("ic back")));
            BackBtn.click();
            LogUtil.info("Clicking the back button.");
        } catch (Exception e) {
            LogUtil.warning("Clicking the back button is not happening.");
            throw new Exception(e.getMessage());
        }

        //2.Clicking on FAQ section
        WebElement FAQBtn;
        try {
            FAQBtn = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("FAQs")));
            FAQBtn.click();
            LogUtil.info("Clicking the FAQ's section button..");
        } catch (Exception e) {
            LogUtil.warning("Clicking the FAQ's section button is not happening.");
            throw new Exception(e.getMessage());
        }

        //FAQ's header
        try {
            WebElement FAQ_Header = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.accessibilityId("FAQs")));
            LogUtil.info("User currently present in : " + FAQ_Header.getText() + " page.");
        } catch (Exception e) {
            LogUtil.warning("FAQ's header is not visible.");
            throw new Exception(e.getMessage());
        }
    }

    @Test(retryAnalyzer = RetryAnalyzerios.class)
    public void TC_034() throws Exception {

        baseLoginForiOS.BaseLoginForIos(true);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        //Clicking on more section
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("ic_more"))).click();
            LogUtil.info("Clicking the More section button.");
        } catch (Exception e) {
            LogUtil.warning("Clicking the more section button is not happening.");
            throw new ElementNotInteractableException(e.getMessage());
        }

        //1.Clicking on About
        WebElement AboutUsBtn;
        try {
            AboutUsBtn = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("About Us")));
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
            AboutUsHeader = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.iOSClassChain("**/XCUIElementTypeStaticText[`name == \"About Us\"`][1]")));
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
            BackBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.accessibilityId("ic back")));
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
            TermsAndConditions = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("Terms & Conditions")));
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
            TermsAndConditionHeader = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.accessibilityId("Terms & Conditions")));
            if (TermsAndConditionHeader.isDisplayed()) {
                LogUtil.info("User currently present in : " + TermsAndConditionHeader.getText() + "Page");
            }
        } catch (Exception e) {
            LogUtil.warning("Terms and condition header is not visible.");
            throw new Exception(e.getMessage());
        }

        //Terms and condition content.
        WebElement ContentOfTermsAndCondition;
        try {
            ContentOfTermsAndCondition = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.accessibilityId("CONNECTED HEALTH MoAI END-USER LICENSE AGREEMENT")));
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
            BackBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.accessibilityId("ic back")));
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
            PrivacyPolicyBtn = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("Privacy Policy")));
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
            PrivacyPolicyHeader = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.accessibilityId("Privacy Policy")));
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
            PrivacyPolicyContent = wait.until(ExpectedConditions.visibilityOfElementLocated
                    (AppiumBy.iOSClassChain("**/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther" +
                    "/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeWebView/XCUIElementTypeWebView/XCUIElementTypeWebView/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeStaticText")));
            if (PrivacyPolicyContent.isDisplayed()) {
                LogUtil.info("Privacy Policy content is present : " + PrivacyPolicyContent.isDisplayed());
            }
        } catch (Exception e) {
            LogUtil.warning("Privacy Policy content is not visible.");
            throw new Exception(e.getMessage());
        }

        //navigate back
        try {
            BackBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.accessibilityId("ic back")));
            if (BackBtn.isEnabled()) {
                BackBtn.click();
                LogUtil.info("Clicking the back button.");
            }
        } catch (Exception e) {
            LogUtil.warning("Clicking the back button is not happening.");
            throw new Exception(e.getMessage());
        }
    }

    @Test(retryAnalyzer = RetryAnalyzerios.class)
    public void TC_035() throws Exception {

         baseLoginForiOS.BaseLoginForIos(true);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        //Clicking on more section
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("ic_more"))).click();
        } catch (Exception e) {
            LogUtil.warning("Not moving to more section.");
        }

        //Clicking on logout
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("Logout"))).click();
        } catch (Exception e) {
            LogUtil.warning("logout is not clicked.");
        }

        //Warning message.
        try {
            WebElement Message = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("(//XCUIElementTypeStaticText[@name=\"Logout\"])[2]")));
            LogUtil.info("Confirmation message for logout : " + Message.getText());
        } catch (Exception e) {
            LogUtil.warning("Logout warning message is not coming.");
        }

        //Yes button
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("Yes"))).click();
        } catch (Exception e) {
            LogUtil.warning("Logout YES button is not coming.");
        }

        //Verifying the singUp page.
        try {
            WebElement SignUp = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.accessibilityId("Login or Sign Up")));
            LogUtil.info("User currently present :" + SignUp.getText());
        } catch (Exception e) {
            LogUtil.warning("Not moving to the Sign up page again after the logout.");
        }

    }

    @Test(retryAnalyzer = RetryAnalyzerios.class)
    public void TC_036() throws Exception {
         baseLoginForiOS.BaseLoginForIos(true);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        //Clicking on more section
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("ic_more"))).click();
        } catch (Exception e) {
            LogUtil.warning("Not moving to more section.");
        }

        //Clicking on delete account
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("Delete Account"))).click();
        } catch (Exception e) {
            LogUtil.warning("Deleting account is not clicked.");
        }

        //Delete account label
        try {
            WebElement DeleteAccountLabel = wait.until(ExpectedConditions.
                    visibilityOfElementLocated(AppiumBy.xpath("(//XCUIElementTypeStaticText[@name=\"Delete Account\"])[2]")));
            LogUtil.info("Label of delete account : " + DeleteAccountLabel.getText());
        } catch (Exception e) {
            LogUtil.warning("label is not visible.");
        }

        //Confirmation message
        try {
            WebElement DeleteMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.
                    xpath("//XCUIElementTypeAlert[@name=\"Delete Account\"]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeScrollView[1]/XCUIElementTypeOther[1]")));
            LogUtil.info("Delete account confirmation message : " + DeleteMessage.getText());
        } catch (Exception e) {
            LogUtil.warning("delete account confirmation is not visible. ");
        }

        //yes button
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("Yes")));
            LogUtil.info("yes button is visible, but we are not deleting the account now.");
        } catch (Exception e) {
            LogUtil.warning("yes button is not visible.");
        }

        //No button.
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("No"))).click();
            LogUtil.info("Clicking No for not deleting the account.");
        } catch (Exception e) {
            LogUtil.warning("No button is not visible.");
        }

    }
}
