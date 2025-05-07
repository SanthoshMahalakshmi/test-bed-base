package Login;

import Actions.Activity;
import Actions.ElementTask;
import DriverManagerAndroid.BaseLoginForAndroid;
import DriverManagerAndroid.DriverManager;
import UtilitiesForAndroid.LogUtil;
import UtilitiesForAndroid.RetryAnalyzer;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import static ElementRepositories.CommonElements.*;

import java.time.Duration;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

import static ElementRepositories.LoginScreenElements.*;
import static ElementRepositories.OTPVerifyScreenElements.*;
import static ElementRepositories.ProfileScreenElements.*;
import static ElementRepositories.SplashScreenElements.*;
import static UtilitiesForAndroid.ElementActions.performActions;

public class Login_Page_Android extends DriverManager {

    BaseLoginForAndroid bs = new BaseLoginForAndroid();

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void TC_002() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        Map<By, ElementTask> elementMap = new LinkedHashMap<>();

        elementMap.put(TITLE_LOGO_IMAGE, TITLE_LOGO_IMAGE_TASK);

        elementMap.put(GET_STARTED_BUTTON, GET_STARTED_TASK);

        elementMap.put(MOBILE_NUMBER_FIELD, MOBILE_NUMBER_FIELD_TASK);

        elementMap.put(COUNTRY_CODE, COUNTRY_CODE_TASK);

        elementMap.put(CONTINUE_BUTTON, CONTINUE_BUTTON_TASK);

        elementMap.put(BACK_BUTTON, BACK_BUTTON_TASK);

        elementMap.put(TERMS_AND_CONDITION_LINK, new ElementTask.Builder(Activity.VERIFY, "Terms and Condition link").build());

        elementMap.put(PRIVACY_POLICY_LINK, new ElementTask.Builder(Activity.VERIFY, "Privacy policy link").build());

        performActions(elementMap, wait);
    }

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void TC_003() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        Map<By, ElementTask> onboardingElements = new LinkedHashMap<>();
        onboardingElements.put(GET_STARTED_BUTTON, GET_STARTED_TASK);
        onboardingElements.put(MOBILE_NUMBER_FIELD, MOBILE_NUMBER_FIELD_TASK);
        onboardingElements.put(CONTINUE_BUTTON, CONTINUE_BUTTON_TASK);

        performActions(onboardingElements, wait);

        String otp = "123456";
        for (int i = 0; i < otp.length(); i++) {
            wait.until(ExpectedConditions.visibilityOfElementLocated(OTP_FIELDS[i]))
                    .sendKeys(String.valueOf(otp.charAt(i)));
        }

        Map<By, ElementTask> otpElements = new LinkedHashMap<>();
        otpElements.put(VERIFY_MOBILE_NUMBER_LABEL, VERIFY_MOBILE_NUMBER_LABEL_TASK);
        otpElements.put(RESEND_LABEL, RESEND_LABEL_TASK);
        otpElements.put(OTP_VERIFY_BUTTON, OTP_VERIFY_BUTTON_TASK);

        performActions(otpElements, wait);
    }


    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void TC004() throws Exception {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        bs.CoreLoginForAndroid(true);

        Map<By, ElementTask> elementTask = new LinkedHashMap<>();

        elementTask.put(PROFILE_BUTTON, PROFILE_BUTTON_TASK);

        elementTask.put(PROFILE_COACH_MARK_SKIP, PROFILE_COACH_MARK_SKIP_TASK);

        elementTask.put(EDIT_PROFILE_BUTTON, EDIT_PROFILE_BUTTON_TASK);

        elementTask.put(PROFILE_PICTURE_OPTION, PROFILE_PICTURE_OPTION_TASK);

        elementTask.put(FULL_NAME_INPUT_FIELD, FULL_NAME_INPUT_FIELD_TASK);

        elementTask.put(EMAIL_ID_INPUT_FIELD, EMAIL_ID_INPUT_FIELD_TASK);

        elementTask.put(MOBILE_NUMBER_INPUT_FIELD, MOBILE_NUMBER_INPUT_FIELD_TASK);

        elementTask.put(CONTINUE_BUTTON, CONTINUE_BUTTON_TASK);

        performActions(elementTask, wait);

    }


    @Test(retryAnalyzer = RetryAnalyzer.class, enabled = true, groups = {"FirstTime login page"})
    public void TC_004() throws Exception {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        bs.CoreLoginForAndroid(true); //For base login scenario

        //Profile section click
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("Profile"))).click();
            LogUtil.info("Clicking the profile button.");
        } catch (Exception e) {
            LogUtil.warning("There is no 'Profile' button.");
            throw new Exception(e.getMessage());
        }

        //Skip button click for profile page section for the first time.
        WebElement CoachMarkSkip = null;
        try {
            CoachMarkSkip = wait.until(ExpectedConditions.elementToBeClickable(By.id("com.heartmonitor.android:id/tvSkip")));
            if (CoachMarkSkip.isDisplayed()) {
                CoachMarkSkip.click();
                LogUtil.info("Skip button is visible and its clicked.");
            } else {
                LogUtil.info("Skip button is not visible for a click.");
            }
        } catch (NoSuchElementException e) {
            LogUtil.warning("The coach mark Skip is not visible." + e.getMessage());
        } catch (Exception e) {
            LogUtil.warning(e.getMessage());
        }

        //Clicking the Edit profile option.
        WebElement EditProfile = null;
        try {
            EditProfile = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.heartmonitor.android:id/txtEditProfile")));
            EditProfile.click();
            LogUtil.info("Edit profile click is happening on profile section.");
        } catch (Exception e) {
            LogUtil.warning("There is no edit profile option available for a click.");
            throw new NoSuchElementException(e.getMessage());
        }

        //1.Profile picture click.
        WebElement ProfilePictureOption = null;
        try {
            ProfilePictureOption = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.heartmonitor.android:id/imgPickProfile")));
            ProfilePictureOption.click();
            LogUtil.info("Profile picture button click is happened.");
        } catch (Exception e) {
            LogUtil.warning("There is no profile picture option for the user.");
            throw new NoSuchElementException(e.getMessage());
        }

        WebElement Camera, Gallery, Cancel = null;
        try {
            Camera = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.androidUIAutomator("new UiSelector().text(\"Camera\")")));
            Gallery = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.androidUIAutomator("new UiSelector().text(\"Gallery\")")));
            Cancel = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("android:id/button2")));
            if (Camera.isDisplayed() && Gallery.isDisplayed()) {
                Cancel.click();
                LogUtil.info("user can able to set the profile picture by using camera or gallery.");
            } else {
                LogUtil.warning("There is no camera option and gallery option.");
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
                LogUtil.info("Full Name is edited by the user.");
            }
        } catch (Exception e) {
            LogUtil.warning("There is no Full name input field.");
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
                LogUtil.info("Email id is edited by the user.");
            }
            LogUtil.info("Email is added for the new user");
        } catch (Exception e) {
            LogUtil.warning("There is no Email input field.");
            throw new Exception(e.getMessage());
        }

        //4.Mobile number
        WebElement MobileNumber = null;
        try {
            MobileNumber = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.heartmonitor.android:id/edtMobileNumber")));
            LogUtil.info("Mobile number is available for this user.");
        } catch (Exception e) {
            LogUtil.warning("There is no mobile number field");
            throw new Exception(e.getMessage());
        }

        //5.Continue button
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.heartmonitor.android:id/txtContinue"))).click();
            LogUtil.info("Continue button is clicked now.");
        } catch (Exception e) {
            LogUtil.warning("There is no continue button is visible.");
            throw new Exception(e.getMessage());
        }
    }

    @Test(retryAnalyzer = RetryAnalyzer.class, enabled = true, groups = {"FirstTime login page"})
    public void TC_005() throws Exception {

        LogUtil.info("Enter into TC_005");

        //Core login for android.
        bs.CoreLoginForAndroid(true);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        //Pre-Request: Profile section click
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("Profile"))).click();
            LogUtil.info("Clicking the profile section.");
        } catch (Exception e) {
            LogUtil.warning("There is no profile section.");
            throw new Exception(e.getMessage());
        }

        //Pre-Request: Skip button click for profile page section for the first time.
        WebElement CoachMarkSkip = null;
        try {
            CoachMarkSkip = wait.until(ExpectedConditions.elementToBeClickable(By.id("com.heartmonitor.android:id/tvSkip")));
            if (CoachMarkSkip.isDisplayed()) {
                CoachMarkSkip.click();
                LogUtil.info("Skip button is visible and its clicked.");
            } else {
                LogUtil.info("Skip button is not visible for a click.");
            }
        } catch (NoSuchElementException e) {
            LogUtil.warning("The coach mark Skip is not visible." + e.getMessage());
        } catch (Exception e) {
            LogUtil.warning(e.getMessage());
        }

        //Pre-Request: Clicking the Edit profile option.
        WebElement EditProfile = null;
        try {
            EditProfile = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.heartmonitor.android:id/txtEditProfile")));
            EditProfile.click();
            LogUtil.info("Edit profile click is happening on profile section.");
        } catch (Exception e) {
            LogUtil.warning("There is no edit profile option available for a click.");
            throw new NoSuchElementException(e.getMessage());
        }

        //Pre-Request: Clicking the continue button.
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.heartmonitor.android:id/txtContinue"))).click();
            LogUtil.info("Continue button is clicked now.");
        } catch (Exception e) {
            LogUtil.warning("There is no continue button is visible.");
            throw new Exception(e.getMessage());
        }

        try {
            //1.Select the female option.
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.heartmonitor.android:id/imgWoman"))).click();
            LogUtil.info("Female option is visible and its selected now.");

            //2.Select the male option
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.heartmonitor.android:id/imgMan"))).click();
            LogUtil.info("Male option is visible and its selected now.");

            //3.Others.
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.heartmonitor.android:id/imgOther"))).click();
            LogUtil.info("Others option is visible and its selected now.");

            //4.Respective pagination
            WebElement Pagination = driver.findElement(AppiumBy.id("com.heartmonitor.android:id/txtSelected"));
            LogUtil.info("Pagination is visible : " + Pagination.isDisplayed());

            //5.continue button clicking
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.heartmonitor.android:id/txtContinue"))).click();
        } catch (Exception e) {
            LogUtil.warning("All the options are not visible. male female, pagination, continue button");
            throw new Exception(e.getMessage());
        }

    }

    @Test(retryAnalyzer = RetryAnalyzer.class, enabled = true, groups = {"FirstTime login page"})
    public void TC_006() throws Exception {

        LogUtil.info("Enter into TC_006");

        //Core login for android.
        bs.CoreLoginForAndroid(true);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        //Pre-Request: Profile section click
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("Profile"))).click();
            LogUtil.info("Clicking the profile section.");
        } catch (Exception e) {
            LogUtil.warning("There is no profile section.");
            throw new Exception(e.getMessage());
        }

        //Pre-Request: Skip button click for profile page section for the first time.
        WebElement CoachMarkSkip = null;
        try {
            CoachMarkSkip = wait.until(ExpectedConditions.elementToBeClickable(By.id("com.heartmonitor.android:id/tvSkip")));
            if (CoachMarkSkip.isDisplayed()) {
                CoachMarkSkip.click();
                LogUtil.info("Skip button is visible and its clicked.");
            } else {
                LogUtil.info("Skip button is not visible for a click.");
            }
        } catch (NoSuchElementException e) {
            LogUtil.warning("The coach mark Skip is not visible." + e.getMessage());
        } catch (Exception e) {
            LogUtil.warning(e.getMessage());
        }

        //Pre-Request: Clicking the Edit profile option.
        WebElement EditProfile = null;
        try {
            EditProfile = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.heartmonitor.android:id/txtEditProfile")));
            EditProfile.click();
            LogUtil.info("Edit profile click is happening on profile section.");
        } catch (Exception e) {
            LogUtil.warning("There is no edit profile option available for a click.");
            throw new NoSuchElementException(e.getMessage());
        }

        //Pre-Request: Clicking the continue button in basic details page.
        WebElement ContinueButton, PageTitle = null;
        try {
            ContinueButton = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.heartmonitor.android:id/txtContinue")));

            PageTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.heartmonitor.android:id/txtTitle")));

            if (Objects.equals(PageTitle.getText(), "Basic Details")) {
                ContinueButton.click();
                LogUtil.info("Continue button is clicked in the 'Basic Details' page .");
            } else {
                LogUtil.warning("Page title is not available.");
            }
        } catch (Exception e) {
            LogUtil.warning("There is no continue button is visible.");
            throw new Exception(e.getMessage());
        } finally {
            PageTitle = null;
        }

        //Pre-Request: Clicking the continue button in select gender page.
        WebElement PageTitle2 = null;
        try {
            ContinueButton = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.heartmonitor.android:id/txtContinue")));
            PageTitle2 = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.heartmonitor.android:id/txtTitle")));
            LogUtil.warning("Page title" + PageTitle2.getText());
            if (true) {
                ContinueButton.click();
                LogUtil.info("Now we are in the Select Gender page");
            } else {
                LogUtil.warning("Page title is not available in the select gender page.");
            }
        } catch (Exception e) {
            LogUtil.warning("Page title is not available in the select gender page.");
            throw new Exception(e.getMessage());
        }

        //1.Height picker
        WebElement HeightPicker = null;
        try {
            HeightPicker = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.heartmonitor.android:id/scaleNumberPicker")));
            if (HeightPicker.isDisplayed()) {
                LogUtil.info("Height Picker is visible = " + HeightPicker.isDisplayed());
                LogUtil.info("User can edit their height by using the height picker.");
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }

        WebElement GenderLogo, Pagination = null;
        try {
            //2.verifying the logo is present or not.
            GenderLogo = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.heartmonitor.android:id/imgUserImage")));
            if (GenderLogo.isDisplayed()) {
                LogUtil.info("Selected gender logo is visible? = " + GenderLogo.isDisplayed());
            } else {
                LogUtil.warning("There is no gender logo present in the 'Select Height' page.");
            }

            //3.pagination is present in the screen
            Pagination = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.heartmonitor.android:id/txtSelected")));
            if (Pagination.isDisplayed()) {
                LogUtil.info("Pagination is visible? = " + Pagination.isDisplayed());
            } else {
                LogUtil.warning("There is no pagination is present in the 'Select height' page.");
            }
        } catch (Exception e) {
            LogUtil.warning("Logo and pagination is not visible.");
        }

    }

    @Test(retryAnalyzer = RetryAnalyzer.class, enabled = true, groups = {"FirstTime login page"})
    public void
    TC_007() throws Exception {

        LogUtil.info("Enter into TC_007");

        bs.CoreLoginForAndroid(true);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        //Pre-Request: Profile section click
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("Profile"))).click();
            LogUtil.info("Clicking the profile section.");
        } catch (Exception e) {
            LogUtil.warning("There is no profile section.");
            throw new Exception(e.getMessage());
        }

        //Pre-Request: Skip button click for profile page section for the first time.
        WebElement CoachMarkSkip = null;
        try {
            CoachMarkSkip = wait.until(ExpectedConditions.elementToBeClickable(By.id("com.heartmonitor.android:id/tvSkip")));
            if (CoachMarkSkip.isDisplayed()) {
                CoachMarkSkip.click();
                LogUtil.info("Skip button is visible and its clicked.");
            } else {
                LogUtil.info("Skip button is not visible for a click.");
            }
        } catch (NoSuchElementException e) {
            LogUtil.warning("The coach mark Skip is not visible." + e.getMessage());
        } catch (Exception e) {
            LogUtil.warning(e.getMessage());
        }

        //Pre-Request: Clicking the Edit profile option.
        WebElement EditProfile = null;
        try {
            EditProfile = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.heartmonitor.android:id/txtEditProfile")));
            EditProfile.click();
            LogUtil.info("Edit profile click is happening on profile section.");
        } catch (Exception e) {
            LogUtil.warning("There is no edit profile option available for a click.");
            throw new NoSuchElementException(e.getMessage());
        }

        //Pre-Request: Clicking the continue button in basic details and select gender page and select height page.
        WebElement ContinueButton = null;
        WebElement PageTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.heartmonitor.android:id/txtTitle")));
        ;
        if (Objects.equals(PageTitle.getText(), "Basic Details")) {
            LogUtil.info("Entering into if block.");
            int n = 3;
            for (int i = 0; i < n; i++) {
                LogUtil.info("Entering into For loop.");
                try {
                    ContinueButton = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.heartmonitor.android:id/txtContinue")));
                    ContinueButton.click();
                } catch (Exception e) {
                    LogUtil.warning("There is no page title is matching with 'Basic Details'.");
                    throw new Exception(e.getMessage());
                }
            }
        }

        /*1/User can view the selected weight of the user.*/
        WebElement ActualUserWeight = null;
        try {
            ActualUserWeight = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.heartmonitor.android:id/imgUserImage")));
            LogUtil.info("The user actual weight is " + ActualUserWeight.getText());
        } catch (Exception e) {
            LogUtil.warning("There is no user's actual weight count.");
            throw new RuntimeException(e.getMessage());
        }

        /*2.Logo verification.*/
        WebElement isUserLogo = null;
        try {
            //Verify the isUserLogo
            isUserLogo = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.heartmonitor.android:id/imgUserImage")));
            LogUtil.info(" User isUserLogo is present in the 'select weight' page?:" + isUserLogo.isDisplayed());

        } catch (Exception e) {
            LogUtil.warning(" User isUserLogo is present in the 'select weight' page?: " + isUserLogo.isDisplayed());
            throw new Exception(e.getMessage());
        }

        //3.Pagination verification
        WebElement iSPagination = null;
        try {
            iSPagination = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.heartmonitor.android:id/txtSelected")));
            LogUtil.info("The pagination is present in the 'Select weight' page." + iSPagination.isDisplayed());
        } catch (Exception e) {
            LogUtil.warning("There is no pagination is present in the 'Select Weight' page." + iSPagination.isDisplayed());
            throw new RuntimeException(e);
        }

        //4.Clicking the continue button
        WebElement Continue = null;
        try {
            Continue = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.heartmonitor.android:id/txtContinue")));
            Continue.click();
            LogUtil.info("The continue button is clicked to move for next page.");
        } catch (Exception e) {
            LogUtil.warning("There is no continue button click is happening in the 'Select Weight' page.");
            throw new RuntimeException(e.getMessage());
        }

    }

    @Test(retryAnalyzer = RetryAnalyzer.class, enabled = true, groups = {"FirstTime login page"})
    public void TC_008() throws Exception {

        LogUtil.info("Enter into TC_008");

        TC_007(); //To complete the previous steps.

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        try {
            //pagination.
            WebElement pagination = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.heartmonitor.android:id/txtSelected")));
            LogUtil.info("pagination is present : " + pagination.isDisplayed());

            //submit
            WebElement submit = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.heartmonitor.android:id/txtContinue")));
            LogUtil.info("Submit button is present : " + submit.isDisplayed());
            submit.click();
        } catch (Exception e) {
            LogUtil.warning("Pagination is visible.");
        }
    }

    @Test(retryAnalyzer = RetryAnalyzer.class, enabled = true, groups = {"FirstTime login page"})
    public void TC_009() throws Exception {

        LogUtil.info("Enter into TC_009");

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
            LogUtil.warning("Confirm alert is happen.");
        }
    }
}
