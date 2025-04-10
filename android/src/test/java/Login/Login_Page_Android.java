package Login;

import DriverManagerAndroid.BaseLoginForAndroid;
import DriverManagerAndroid.DriverManager;
import UtilitiesForAndroid.RetryAnalyzer;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.NoSuchContextException;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Objects;

public class Login_Page_Android extends DriverManager {

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
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }

        /*1.Verify the logo is present or not in the login page.*/
        try {
            WebElement logo = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.heartmonitor.android:id/imgLogo")));
            logger.info("Logo is present :" + logo.isDisplayed());
        } catch (NoSuchElementException e) {
            logger.warning("There is No such element like logo in the login page." + e.getMessage());
            throw new NoSuchElementException(e.getMessage());
        } catch (Exception e) {
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
        } catch (Exception e) {
            logger.warning("Issue with mobile number input field :" + e.getMessage());
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
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.heartmonitor.android:id/imgLogo"))).click();
            logger.info("Logo click for keyboard close action");
        } catch (Exception e) {
            logger.warning("Logo click is not happening for keyboard close.");
        }

        try {
            //4.Clicking the continue button
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.heartmonitor.android:id/txtContinue"))).click();
        } catch (NoSuchElementException e) {
            throw new NoSuchElementException(e.getMessage());
        } catch (Exception e) {
            logger.warning("Continue is not clicked.");
            throw new Exception(e.getMessage());
        }

        try {
            /*Back to log in page*/
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("Navigate up"))).click();
        } catch (NoSuchElementException e) {
            throw new NoSuchElementException(e.getMessage());
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }

        try {
            //Terms and condition link
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.heartmonitor.android:id/txtTerms"))).click();
            logger.info("Moving to terms and condition page.");
            //Back to log in page
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("Navigate up"))).click();
            logger.info("Moving back to log in page.");
        } catch (NoSuchElementException e) {
            throw new NoSuchElementException(e.getMessage());
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }

        try {
            //Privacy policy link
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.heartmonitor.android:id/txtPrivacy"))).click();
            logger.info("Moving to Privacy policy page.");
            //Back to log in page
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("Navigate up"))).click();
            logger.info("Moving back to log in page.");
        } catch (NoSuchElementException e) {
            throw new NoSuchElementException(e.getMessage());
        } catch (Exception e) {
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
        } catch (Exception e) {
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
        } catch (Exception e) {
            logger.warning("Issue with mobile number input field :" + e.getMessage());
            throw new Exception(e.getMessage());
        }

        //Logo click for close the keyboard of the mobile
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.heartmonitor.android:id/imgLogo"))).click();
            logger.info("Logo click for keyboard close action");
        } catch (Exception e) {
            logger.warning("Logo click is not happening for keyboard close.");
        }

        try {
            //4.Clicking the continue button
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.heartmonitor.android:id/txtContinue"))).click();
        } catch (NoSuchElementException e) {
            throw new NoSuchElementException(e.getMessage());
        } catch (Exception e) {
            logger.warning("Continue is not clicked.");
            throw new Exception(e.getMessage());
        }

        WebElement Ok = null;
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("android:id/button1"))).click();
            logger.info("*OK Button found and its clicked");
        } catch (Exception e) {
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
            logger.info("Enter OTP label : " + OtpLabel.isDisplayed());
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
            WebElement resend = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.
                    androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(resourceId(\"com.heartmonitor.android:id/txtResend\"));")));
            logger.info("Resent label is present : " + resend.isDisplayed());
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
            logger.info("Verify button present? : " + verifyButton.isDisplayed());
            verifyButton.click();
            logger.info("Verify button is clicked.");
        } catch (Exception e) {
            logger.warning("*Verify button is not found");
            throw new Exception(e.getMessage());
        }
    }

    @Test(retryAnalyzer = RetryAnalyzer.class, enabled = true, groups = {"FirstTime login page"})
    public void TC_004() throws Exception {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        bs.CoreLoginForAndroid(true); //For base login scenario

        //Profile section click
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("Profile"))).click();
            logger.info("Clicking the profile button.");
        } catch (Exception e) {
            logger.warning("There is no 'Profile' button.");
            throw new Exception(e.getMessage());
        }

        //Skip button click for profile page section for the first time.
        WebElement CoachMarkSkip = null;
        try {
            CoachMarkSkip = wait.until(ExpectedConditions.elementToBeClickable(By.id("com.heartmonitor.android:id/tvSkip")));
            if (CoachMarkSkip.isDisplayed()) {
                CoachMarkSkip.click();
                logger.info("Skip button is visible and its clicked.");
            } else {
                logger.info("Skip button is not visible for a click.");
            }
        } catch (NoSuchElementException e) {
            DriverManager.logger.warning("The coach mark Skip is not visible." + e.getMessage());
        } catch (Exception e) {
            DriverManager.logger.warning(e.getMessage());
        }

        //Clicking the Edit profile option.
        WebElement EditProfile = null;
        try {
            EditProfile = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.heartmonitor.android:id/txtEditProfile")));
            EditProfile.click();
            logger.info("Edit profile click is happening on profile section.");
        } catch (Exception e) {
            logger.warning("There is no edit profile option available for a click.");
            throw new NoSuchElementException(e.getMessage());
        }

        //1.Profile picture click.
        WebElement ProfilePictureOption = null;
        try {
            ProfilePictureOption = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.heartmonitor.android:id/imgPickProfile")));
            ProfilePictureOption.click();
            logger.info("Profile picture button click is happened.");
        } catch (Exception e) {
            logger.warning("There is no profile picture option for the user.");
            throw new NoSuchElementException(e.getMessage());
        }

        WebElement Camera, Gallery, Cancel = null;
        try {
            Camera = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.androidUIAutomator("new UiSelector().text(\"Camera\")")));
            Gallery = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.androidUIAutomator("new UiSelector().text(\"Gallery\")")));
            Cancel = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("android:id/button2")));
            if (Camera.isDisplayed() && Gallery.isEnabled()) {
                Cancel.click();
                logger.info("user can able to set the profile picture by using camera or gallery.");
            } else {
                logger.warning("There is no camera option and gallery option.");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        //2.Full name
        WebElement FullName = null;
        String ActualFullName = null;
        try {
            FullName = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.heartmonitor.android:id/edtFullName")));
            ActualFullName = FullName.getText();

            //Sending some random name for full name field verification.
            FullName.sendKeys("Santhosh MahaLakshmi");

            if (FullName.isDisplayed()) {
                FullName.sendKeys(ActualFullName);
                logger.info("Full Name is edited by the user.");
            }
        } catch (Exception e) {
            logger.warning("There is no Full name input field.");
            throw new Exception(e.getMessage());
        }

        //3.Email ID
        WebElement EmailID = null;
        String ActuallEmailId = null;
        try {
            EmailID = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.heartmonitor.android:id/edtEmail")));
            ActuallEmailId = EmailID.getText();

            //Sending some random email id for the email input box
            EmailID.sendKeys("SanthoshMahalakshmi@gmail.com");

            if (EmailID.isDisplayed()) {
                EmailID.sendKeys(ActuallEmailId);
                logger.info("Email id is edited by the user.");
            }
            logger.info("Email is added for the new user");
        } catch (Exception e) {
            logger.warning("There is no Email input field.");
            throw new Exception(e.getMessage());
        }

        //4.Mobile number
        WebElement MobileNumber = null;
        try {
            MobileNumber = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.heartmonitor.android:id/edtMobileNumber")));
            logger.info("Mobile number is available for this user.");
        } catch (Exception e) {
            logger.warning("There is no mobile number field");
            throw new Exception(e.getMessage());
        }

        //5.Continue button
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.heartmonitor.android:id/txtContinue"))).click();
            logger.info("Continue button is clicked now.");
        } catch (Exception e) {
            logger.warning("There is no continue button is visible.");
            throw new Exception(e.getMessage());
        }
    }

    @Test(retryAnalyzer = RetryAnalyzer.class, enabled = true, groups = {"FirstTime login page"})
    public void TC_005() throws Exception {

        //Core login for android.
        bs.CoreLoginForAndroid(true);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        //Pre-Request: Profile section click
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("Profile"))).click();
            logger.info("Clicking the profile section.");
        } catch (Exception e) {
            logger.warning("There is no profile section.");
            throw new Exception(e.getMessage());
        }

        //Pre-Request: Skip button click for profile page section for the first time.
        WebElement CoachMarkSkip = null;
        try {
            CoachMarkSkip = wait.until(ExpectedConditions.elementToBeClickable(By.id("com.heartmonitor.android:id/tvSkip")));
            if (CoachMarkSkip.isDisplayed()) {
                CoachMarkSkip.click();
                logger.info("Skip button is visible and its clicked.");
            } else {
                logger.info("Skip button is not visible for a click.");
            }
        } catch (NoSuchElementException e) {
            DriverManager.logger.warning("The coach mark Skip is not visible." + e.getMessage());
        } catch (Exception e) {
            DriverManager.logger.warning(e.getMessage());
        }

        //Pre-Request: Clicking the Edit profile option.
        WebElement EditProfile = null;
        try {
            EditProfile = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.heartmonitor.android:id/txtEditProfile")));
            EditProfile.click();
            logger.info("Edit profile click is happening on profile section.");
        } catch (Exception e) {
            logger.warning("There is no edit profile option available for a click.");
            throw new NoSuchElementException(e.getMessage());
        }

        //Pre-Request: Clicking the continue button.
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.heartmonitor.android:id/txtContinue"))).click();
            logger.info("Continue button is clicked now.");
        } catch (Exception e) {
            logger.warning("There is no continue button is visible.");
            throw new Exception(e.getMessage());
        }

        try {
            //1.Select the female option.
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.heartmonitor.android:id/imgWoman"))).click();
            logger.info("Female option is visible and its selected now.");

            //2.Select the male option
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.heartmonitor.android:id/imgMan"))).click();
            logger.info("Male option is visible and its selected now.");

            //3.Others.
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.heartmonitor.android:id/imgOther"))).click();
            logger.info("Others option is visible and its selected now.");

            //4.Respective pagination
            WebElement Pagination = driver.findElement(AppiumBy.id("com.heartmonitor.android:id/txtSelected"));
            logger.info("Pagination is visible : " + Pagination.isDisplayed());

            //5.continue button clicking
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.heartmonitor.android:id/txtContinue"))).click();
        } catch (Exception e) {
            logger.warning("All the options are not visible. male female, pagination, continue button");
            throw new Exception(e.getMessage());
        }

    }

    @Test(retryAnalyzer = RetryAnalyzer.class, enabled = true, groups = {"FirstTime login page"})
    public void TC_006() throws Exception {

        //Core login for android.
        bs.CoreLoginForAndroid(true);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        //Pre-Request: Profile section click
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("Profile"))).click();
            logger.info("Clicking the profile section.");
        } catch (Exception e) {
            logger.warning("There is no profile section.");
            throw new Exception(e.getMessage());
        }

        //Pre-Request: Skip button click for profile page section for the first time.
        WebElement CoachMarkSkip = null;
        try {
            CoachMarkSkip = wait.until(ExpectedConditions.elementToBeClickable(By.id("com.heartmonitor.android:id/tvSkip")));
            if (CoachMarkSkip.isDisplayed()) {
                CoachMarkSkip.click();
                logger.info("Skip button is visible and its clicked.");
            } else {
                logger.info("Skip button is not visible for a click.");
            }
        } catch (NoSuchElementException e) {
            DriverManager.logger.warning("The coach mark Skip is not visible." + e.getMessage());
        } catch (Exception e) {
            DriverManager.logger.warning(e.getMessage());
        }

        //Pre-Request: Clicking the Edit profile option.
        WebElement EditProfile = null;
        try {
            EditProfile = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.heartmonitor.android:id/txtEditProfile")));
            EditProfile.click();
            logger.info("Edit profile click is happening on profile section.");
        } catch (Exception e) {
            logger.warning("There is no edit profile option available for a click.");
            throw new NoSuchElementException(e.getMessage());
        }

        //Pre-Request: Clicking the continue button in basic details page.
        WebElement ContinueButton, PageTitle = null;
        try {
            ContinueButton = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.heartmonitor.android:id/txtContinue")));

            PageTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.heartmonitor.android:id/txtTitle")));

            if (Objects.equals(PageTitle.getText(), "Basic Details")) {
                ContinueButton.click();
                logger.info("Continue button is clicked in the 'Basic Details' page .");
            } else {
                logger.warning("Page title is not available.");
            }
        } catch (Exception e) {
            logger.warning("There is no continue button is visible.");
            throw new Exception(e.getMessage());
        } finally {
            PageTitle = null;
        }

        //Pre-Request: Clicking the continue button in select gender page.
        WebElement PageTitle2 = null;
        try {
            ContinueButton = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.heartmonitor.android:id/txtContinue")));
            PageTitle2 = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.heartmonitor.android:id/txtTitle")));
            logger.warning("Page title" + PageTitle2.getText());
            if (true) {
                ContinueButton.click();
                logger.info("Now we are in the Select Gender page");
            } else {
                logger.warning("Page title is not available in the select gender page.");
            }
        } catch (Exception e) {
            logger.warning("Page title is not available in the select gender page.");
            throw new Exception(e.getMessage());
        }

        //1.Height picker
        WebElement HeightPicker = null;
        try {
            HeightPicker = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.heartmonitor.android:id/scaleNumberPicker")));
            if (HeightPicker.isDisplayed()) {
                logger.info("Height Picker is visible = " + HeightPicker.isDisplayed());
                logger.info("User can edit their height by using the height picker.");
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }

        WebElement GenderLogo, Pagination = null;
        try {
            //2.verifying the logo is present or not.
            GenderLogo = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.heartmonitor.android:id/imgUserImage")));
            if (GenderLogo.isDisplayed()) {
                logger.info("Selected gender logo is visible? = " + GenderLogo.isDisplayed());
            } else {
                logger.warning("There is no gender logo present in the 'Select Height' page.");
            }

            //3.pagination is present in the screen
            Pagination = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.heartmonitor.android:id/txtSelected")));
            if (Pagination.isDisplayed()) {
                logger.info("Pagination is visible? = " + Pagination.isDisplayed());
            } else {
                logger.warning("There is no pagination is present in the 'Select height' page.");
            }
        } catch (Exception e) {
            logger.warning("Logo and pagination is not visible.");
        }

    }

    @Test(retryAnalyzer = RetryAnalyzer.class, enabled = true, groups = {"FirstTime login page"})
    public void
    TC_007() throws Exception {

        bs.CoreLoginForAndroid(true);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        //Pre-Request: Profile section click
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("Profile"))).click();
            logger.info("Clicking the profile section.");
        } catch (Exception e) {
            logger.warning("There is no profile section.");
            throw new Exception(e.getMessage());
        }

        //Pre-Request: Skip button click for profile page section for the first time.
        WebElement CoachMarkSkip = null;
        try {
            CoachMarkSkip = wait.until(ExpectedConditions.elementToBeClickable(By.id("com.heartmonitor.android:id/tvSkip")));
            if (CoachMarkSkip.isDisplayed()) {
                CoachMarkSkip.click();
                logger.info("Skip button is visible and its clicked.");
            } else {
                logger.info("Skip button is not visible for a click.");
            }
        } catch (NoSuchElementException e) {
            DriverManager.logger.warning("The coach mark Skip is not visible." + e.getMessage());
        } catch (Exception e) {
            DriverManager.logger.warning(e.getMessage());
        }

        //Pre-Request: Clicking the Edit profile option.
        WebElement EditProfile = null;
        try {
            EditProfile = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.heartmonitor.android:id/txtEditProfile")));
            EditProfile.click();
            logger.info("Edit profile click is happening on profile section.");
        } catch (Exception e) {
            logger.warning("There is no edit profile option available for a click.");
            throw new NoSuchElementException(e.getMessage());
        }

        //Pre-Request: Clicking the continue button in basic details and select gender page and select height page.
        WebElement ContinueButton = null;
        WebElement PageTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.heartmonitor.android:id/txtTitle")));
        ;
        if (Objects.equals(PageTitle.getText(), "Basic Details")) {
            logger.info("Entering into if block.");
            int n = 3;
            for (int i = 0; i < n; i++) {
                logger.info("Entering into For loop.");
                try {
                    ContinueButton = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.heartmonitor.android:id/txtContinue")));
                    ContinueButton.click();
                } catch (Exception e) {
                    logger.warning("There is no page title is matching with 'Basic Details'.");
                    throw new Exception(e.getMessage());
                }
            }
        }

        /*1/User can view the selected weight of the user.*/
        WebElement ActualUserWeight = null;
        try {
            ActualUserWeight = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.heartmonitor.android:id/imgUserImage")));
            logger.info("The user actual weight is " + ActualUserWeight.getText());
        } catch (Exception e) {
            logger.warning("There is no user's actual weight count.");
            throw new RuntimeException(e.getMessage());
        }

        /*2.Logo verification.*/
        WebElement isUserLogo = null;
        try {
            //Verify the isUserLogo
            isUserLogo = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.heartmonitor.android:id/imgUserImage")));
            logger.info(" User isUserLogo is present in the 'select weight' page?:" + isUserLogo.isDisplayed());

        } catch (Exception e) {
            logger.warning(" User isUserLogo is present in the 'select weight' page?: " + isUserLogo.isDisplayed());
            throw new Exception(e.getMessage());
        }

        //3.Pagination verification
        WebElement iSPagination = null;
        try {
            iSPagination =  wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.heartmonitor.android:id/txtSelected")));
            logger.info("The pagination is present in the 'Select weight' page." + iSPagination.isDisplayed());
        } catch (Exception e) {
            logger.warning("There is no pagination is present in the 'Select Weight' page." + iSPagination.isDisplayed());
            throw new RuntimeException(e);
        }

        //4.Clicking the continue button
        WebElement Continue = null;
        try {
            Continue = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.heartmonitor.android:id/txtContinue")));
            Continue.click();
            logger.info("The continue button is clicked to move for next page.");
        } catch (Exception e) {logger.warning("There is no continue button click is happening in the 'Select Weight' page.");
            throw new RuntimeException(e.getMessage());
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
