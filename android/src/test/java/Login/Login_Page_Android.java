package Login;

import DriverManagerAndroid.BaseLoginForAndroid;
import DriverManagerAndroid.DriverManager;
import UtilitiesForAndroid.RetryAnalyzer;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.NoSuchContextException;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import java.time.Duration;

public class Login_Page_Android extends DriverManager
{

    private static final Logger log = LoggerFactory.getLogger(Login_Page_Android.class);
    BaseLoginForAndroid bs = new BaseLoginForAndroid();

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void TC_002() throws Exception {
        /*Global wait.*/
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        /*Clicking the Get started button*/
        try {
            WebElement getStarted = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.heartmonitor.android:id/txtGetStart")));
            getStarted.click();
            logger.info("Successfully clicked the 'Get Started' button.");
        } catch (ElementNotInteractableException e) {
            logger.warning("The 'Get Started' button is present but not interactable. Details: " + e.getMessage());
            throw new ElementNotInteractableException("The 'Get Started' button is present but not clickable.", e);
        } catch (NoSuchElementException e) {
            logger.warning("The 'Get Started' button could not be located. Details: " + e.getMessage());
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }

        /*1.Verify the logo is present or not in the login page.*/
        try {
            WebElement logo = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.heartmonitor.android:id/imgLogo")));
            logger.info("Logo is present :" + logo.isDisplayed());
        } catch (NoSuchElementException e){
            logger.warning("There is No such element like logo in the login page." + e.getMessage());
            throw new NoSuchElementException(e.getMessage());
        }catch (Exception e) {
            logger.warning("Logo is not visible." + e.getMessage());
            throw new Exception(e.getMessage());
        }

        //3.Sending input to mobile number field and send the keys to it.
        WebElement MobileNumberInput = null;
        try {
            MobileNumberInput = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.
                    id("com.heartmonitor.android:id/edtMobileNumber")));
            MobileNumberInput.sendKeys("9087631080");
        } catch (NoSuchContextException e) {
            logger.warning("Mobile number field is not visible or not available to interact with.");
            throw new NoSuchElementException(e.getMessage());
        }catch (Exception e){
            logger.warning("Issue with mobile number input field :"+e.getMessage());
            throw new Exception(e.getMessage());
        }

        try {
            /* 2.country code is present in the screen or not.  Important - country code is not available in other devices*/
            WebElement countryCode = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.
                    id("com.heartmonitor.android:id/textinput_prefix_text")));
            logger.info("Country code is present: " + countryCode.isDisplayed());
        } catch (Exception e) {
            logger.warning("Country code is not visible.");
        }

        //Logo click for close the keyboard of the mobile
        try{
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.heartmonitor.android:id/imgLogo"))).click();
            logger.info("Logo click for keyboard close action");
        } catch (Exception e) {
            logger.warning("Logo click is not happening for keyboard close.");
        }

        try {
            //4.Clicking the continue button
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.heartmonitor.android:id/txtContinue"))).click();
        }catch (NoSuchElementException e){
            throw new NoSuchElementException(e.getMessage());
        }catch (Exception e) {
            logger.warning("Continue is not clicked.");
            throw new Exception(e.getMessage());
        }

        try {
            /*Back to log in page*/
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("Navigate up"))).click();
        } catch (NoSuchElementException e){
            throw new NoSuchElementException(e.getMessage());
        }catch (Exception e) {
            throw new Exception(e.getMessage());
        }

        try {
            //Terms and condition link
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.heartmonitor.android:id/txtTerms"))).click();
            logger.info("Moving to terms and condition page.");
            //Back to log in page
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("Navigate up"))).click();
            logger.info("Moving back to log in page.");
        } catch (NoSuchElementException e){
            throw new NoSuchElementException(e.getMessage());
        }catch (Exception e) {
            throw new Exception(e.getMessage());
        }

        try {
            //Privacy policy link
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.heartmonitor.android:id/txtPrivacy"))).click();
            logger.info("Moving to Privacy policy page.");
            //Back to log in page
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("Navigate up"))).click();
            logger.info("Moving back to log in page.");
        } catch (NoSuchElementException e){
            throw new NoSuchElementException(e.getMessage());
        }catch (Exception e) {
            throw new Exception(e.getMessage());
        }

    }

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void TC_003() throws Exception {
        /*Global wait.*/
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        /*Clicking the Get started button*/
        try {
            WebElement getStarted = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.heartmonitor.android:id/txtGetStart")));
            getStarted.click();
            logger.info("Successfully clicked the 'Get Started' button.");
        } catch (ElementNotInteractableException e) {
            logger.warning("The 'Get Started' button is present but not interactable. Details: " + e.getMessage());
            throw new ElementNotInteractableException("The 'Get Started' button is present but not clickable.", e);
        } catch (NoSuchElementException e) {
            logger.warning("The 'Get Started' button could not be located. Details: " + e.getMessage());
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }

        //3.clicking the mobile number input field and send the keys to it.
        WebElement MobileNumberInput = null;
        try {
            MobileNumberInput = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.
                    id("com.heartmonitor.android:id/edtMobileNumber")));
            MobileNumberInput.sendKeys("9087631080");
        } catch (NoSuchContextException e) {
            logger.warning("Mobile number field is not visible or not available to interact with.");
            throw new NoSuchElementException(e.getMessage());
        }catch (Exception e){
            logger.warning("Issue with mobile number input field :"+e.getMessage());
            throw new Exception(e.getMessage());
        }

        //Logo click for close the keyboard of the mobile
        try{
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.heartmonitor.android:id/imgLogo"))).click();
            logger.info("Logo click for keyboard close action");
        } catch (Exception e) {
            logger.warning("Logo click is not happening for keyboard close.");
        }

        try {
            //4.Clicking the continue button
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.heartmonitor.android:id/txtContinue"))).click();
        }catch (NoSuchElementException e){
            throw new NoSuchElementException(e.getMessage());
        }catch (Exception e) {
            logger.warning("Continue is not clicked.");
            throw new Exception(e.getMessage());
        }

        WebElement Ok = null;
        try
        {
            wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("android:id/button1"))).click();
            logger.info("*OK Button found and its clicked");
        }
        catch (Exception e)
        {
            logger.warning("Element is not found, we good to go with login");
        }

        try {
            //1.verify mobile number label
            WebElement label = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.heartmonitor.android:id/txtPhoneLabel")));
            logger.info("Verify mobile number label : " + label.isDisplayed());
        } catch (Exception e) {
            logger.warning("Mobile number label is no visible.");
        }

        try {
            //2.Enter OTP label
            WebElement OtpLabel = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.heartmonitor.android:id/txtPhoneLabel")));
            logger.info("Enter OTP label : "+OtpLabel.isDisplayed());
        } catch (Exception e) {
            logger.warning("OTP lable is not visible.");
        }

        //2.Fill the OTP into input field.
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.heartmonitor.android:id/editTextOTP1"))).sendKeys("1");
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.heartmonitor.android:id/editTextOTP2"))).sendKeys("2");
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.heartmonitor.android:id/editTextOTP3"))).sendKeys("3");
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.heartmonitor.android:id/editTextOTP4"))).sendKeys("4");
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.heartmonitor.android:id/editTextOTP5"))).sendKeys("5");
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.heartmonitor.android:id/editTextOTP6"))).sendKeys("6");

        try {
            //4.Resend label
            WebElement resend =  wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.
                    androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(resourceId(\"com.heartmonitor.android:id/txtResend\"));")));
            logger.info("Resent label is present : " +resend.isDisplayed());
        } catch (Exception e) {
            logger.warning("Resend label is not visible.");
        }

        //4.Scroll Timer ----------
        WebElement Timer = null;
        try {
            Timer = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.
                    androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(resourceId(\"com.heartmonitor.android:id/txtTimer\"));")));
            logger.info("Timer is present? : " + Timer.isDisplayed());
        } catch (Exception e) {
            logger.warning("*Timer is not found");
        }

        //3.clicking the verify button.
        WebElement verifyButton = null;
        try {
            verifyButton = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.heartmonitor.android:id/txtVerify")));
            logger.info("Verify button present? : "+verifyButton.isDisplayed());
        } catch (Exception e) {
            logger.warning("*Verify button is not found");
        }
    }

    @Test(retryAnalyzer = RetryAnalyzer.class, enabled = true, groups = {"FirstTime login page"})
    public void TC_004() throws Exception {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        bs.CoreLoginForAndroid(); //For base login scenario

        try {
            //2.Full name
            wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id
                    ("com.heartmonitor.android:id/edtFullName"))).sendKeys("mam");

            //3.Email ID
            wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id
                    ("com.heartmonitor.android:id/edtEmail"))).sendKeys("mam@gmail.com");

            //4.Mobile number
            System.out.println( wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id
                    ("com.heartmonitor.android:id/edtMobileNumber"))).getText());

            //5.Continue button
            wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id
                    ("com.heartmonitor.android:id/txtContinue"))).click();
        } catch (Exception e)
        {
            logger.warning("Verification is not working.");
        }
    }

    @Test(retryAnalyzer = RetryAnalyzer.class, enabled = true, groups = {"FirstTime login page"})
    public void TC_005() throws Exception {

        TC_004(); //  1st page of basic details.

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        try {
            //1.Select the female option.
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.heartmonitor.android:id/imgWoman"))).click();

            //2.Select the male option
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.heartmonitor.android:id/imgMan"))).click();

            //3.Others.
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.heartmonitor.android:id/imgOther"))).click();

            //4.Respective pagination
            WebElement Pagination = driver.findElement(AppiumBy.id("com.heartmonitor.android:id/txtSelected"));
            System.out.println("Pagination is visible : "+Pagination.isDisplayed());

            //5.continue button clicking
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.heartmonitor.android:id/txtContinue"))).click();
        } catch (Exception e) {
            logger.warning("All the options are not visible. male female, pagination, continue button");
        }

    }

    @Test(retryAnalyzer = RetryAnalyzer.class, enabled = true, groups = {"FirstTime login page"})
    public void TC_006() throws Exception {

        TC_005(); // To complete the before pages.

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        try {
            //3.verifying the logo is present or not.
            wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.heartmonitor.android:id/imgUserImage"))).isDisplayed();

            //4.pagination is present in the screen
            wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.heartmonitor.android:id/txtSelected"))).isDisplayed();

            //5.clicking the continue button.
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.heartmonitor.android:id/txtContinue"))).click();
        } catch (Exception e) {
            logger.warning("Logo and pagination is not visible.");
        }

    }

    @Test(retryAnalyzer = RetryAnalyzer.class, enabled = true, groups = {"FirstTime login page"})
    public void TC_007() throws Exception {
        TC_006(); //To complete the previous steps.

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        try {
            //Verify the logo
            wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.heartmonitor.android:id/imgUserImage"))).isDisplayed();

            //Pagination verification
            wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.heartmonitor.android:id/txtSelected"))).isDisplayed();

            //Clicking the continue button
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.heartmonitor.android:id/txtContinue"))).click();
        } catch (Exception e) {
            logger.warning("Logo and pagination is not visible.");
        }
    }

    @Test(retryAnalyzer = RetryAnalyzer.class, enabled = true, groups = {"FirstTime login page"})
    public void TC_008() throws Exception {

        TC_007(); //To complete the previous steps.

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        try {
            //pagination.
            WebElement pagination = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.heartmonitor.android:id/txtSelected")));
            logger.info("pagination is present : " + pagination.isDisplayed());

            //submit
            WebElement submit = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.heartmonitor.android:id/txtContinue")));
            logger.info("Submit button is present : " + submit.isDisplayed());
            submit.click();
        } catch (Exception e) {
            logger.warning("Pagination is visible.");
        }
    }

    @Test(retryAnalyzer = RetryAnalyzer.class, enabled = true, groups = {"FirstTime login page"})
    public void TC_009() throws Exception {
        TC_008(); // To complete the previous steps.

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        try {
            //confirm alert
            wait.until(ExpectedConditions.alertIsPresent());

            //Alcohol NO button
            wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.heartmonitor.android:id/txtAlcoholNo"))).click();

            //Smoke NO button
            wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.heartmonitor.android:id/txtSmokeNo"))).click();

            //Submit button
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.heartmonitor.android:id/txtContinue"))).click();
        } catch (Exception e) {
            logger.warning("Confirm alert is happen.");
        }
    }
}
