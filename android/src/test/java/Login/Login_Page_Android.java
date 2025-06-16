package Login;

import Actions.Activity;
import Actions.ElementTask;
import DriverManagerAndroid.BaseLoginForAndroid;
import DriverManagerAndroid.DriverManager;
import UtilitiesForAndroid.LogUtil;
import UtilitiesForAndroid.RetryAnalyzer;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import static ElementRepositories.CommonElements.*;

import java.time.Duration;
import java.util.*;

import static ElementRepositories.ConsumeEditPage.*;
import static ElementRepositories.EditProfilePage1Elements.*;
import static ElementRepositories.EditProfilePage2Elements.*;
import static ElementRepositories.EditProfilePage3Elements.*;
import static ElementRepositories.EditProfilePage4Elements.*;
import static ElementRepositories.EditProfilePage5Elements.*;
import static ElementRepositories.LoginScreenElements.*;
import static ElementRepositories.OTPVerifyScreenElements.*;
import static ElementRepositories.ProfileScreenElements.*;
import static ElementRepositories.SplashScreenElements.*;
import static UtilitiesForAndroid.ElementActions.checkForStagingError;
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
        checkForStagingError(wait);

        elementMap.put(BACK_BUTTON, BACK_BUTTON_TASK);

        elementMap.put(TERMS_AND_CONDITION_LINK, new ElementTask.Builder(Activity.VERIFY, "Terms and Condition link").build());

        elementMap.put(PRIVACY_POLICY_LINK, new ElementTask.Builder(Activity.VERIFY, "Privacy policy link").build());

        performActions(elementMap, wait);
    }

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void TC_003() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        /*Pre-Condition*/
        Map<By, ElementTask> onboardingElements = new LinkedHashMap<>();
        onboardingElements.put(GET_STARTED_BUTTON, GET_STARTED_TASK);
        onboardingElements.put(MOBILE_NUMBER_FIELD, MOBILE_NUMBER_FIELD_TASK);
        onboardingElements.put(CONTINUE_BUTTON, CONTINUE_BUTTON_TASK);
        checkForStagingError(wait);
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
    public void TC_004() throws Exception {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        bs.CoreLoginForAndroid(true);

        Map<By, ElementTask> elementTask = new LinkedHashMap<>();

        /* Actual test case Coverage.*/
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


    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void TC_005() throws Exception {

        //Core login for android.
        bs.CoreLoginForAndroid(true);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        Map<By, ElementTask> elementMap = new LinkedHashMap<>();

        /* Pre-Request*/
        elementMap.put(PROFILE_BUTTON, PROFILE_BUTTON_TASK);

        elementMap.put(PROFILE_COACH_MARK_SKIP, PROFILE_COACH_MARK_SKIP_TASK);

        elementMap.put(EDIT_PROFILE_BUTTON, EDIT_PROFILE_BUTTON_TASK);

        elementMap.put(CONTINUE_BUTTON, CONTINUE_BUTTON_TASK);

        /* Actual test case coverage.*/
        elementMap.put(FEMALE_LOGO_ELEMENT, FEMALE_LOGO_ELEMENT_TASK);

        elementMap.put(MALE_LOGO_ELEMENT, new ElementTask.Builder(Activity.VERIFY, "Male loge").build());

        elementMap.put(OTHERS_LOGO_ELEMENT, OTHERS_LOGO_ELEMENT_TASK);

        elementMap.put(CONTINUE_BUTTON, CONTINUE_BUTTON_TASK);

        performActions(elementMap, wait);

    }


    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void TC_006() throws Exception {
        //Core login for android.
        bs.CoreLoginForAndroid(true);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        Map<By, ElementTask> elementMap = new LinkedHashMap<>();

        /* Pre-Request*/
        elementMap.put(PROFILE_BUTTON, PROFILE_BUTTON_TASK);
        elementMap.put(PROFILE_COACH_MARK_SKIP, PROFILE_COACH_MARK_SKIP_TASK);
        elementMap.put(EDIT_PROFILE_BUTTON, EDIT_PROFILE_BUTTON_TASK);
        /*Page-1*/
        elementMap.put(CONTINUE_BUTTON, CONTINUE_BUTTON_TASK);
        /*Page-2*/
        elementMap.put(CONTINUE_BUTTON_2, CONTINUE_BUTTON_2_TASK);

        /*Actual test Case*/
        elementMap.put(SELECT_HEIGHT_LABEL, SELECT_HEIGHT_LABEL_TASK);
        elementMap.put(HEIGHT_VALUE, HEIGHT_VALUE_TASK);
        elementMap.put(HEIGHT_SCROLLBAR, HEIGHT_SCROLLBAR_TASK);
        elementMap.put(SELECTED_GENDER_LOGO, SELECTED_GENDER_LOGO_TASK);
        performActions(elementMap, wait);
    }

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void TC_007() throws Exception {

        bs.CoreLoginForAndroid(true);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        Map<By, ElementTask> elementMap = new LinkedHashMap<>();

        /* Pre-Request*/
        elementMap.put(PROFILE_BUTTON, PROFILE_BUTTON_TASK);
        elementMap.put(PROFILE_COACH_MARK_SKIP, PROFILE_COACH_MARK_SKIP_TASK);
        elementMap.put(EDIT_PROFILE_BUTTON, EDIT_PROFILE_BUTTON_TASK);
        /*Page-1*/
        elementMap.put(CONTINUE_BUTTON, CONTINUE_BUTTON_TASK);
        /*Page-2*/
        elementMap.put(CONTINUE_BUTTON_2, CONTINUE_BUTTON_2_TASK);
        /*Page-3*/
        elementMap.put(CONTINUE_BUTTON_3, CONTINUE_BUTTON_3_TASK);

        /*Actual test case*/
        elementMap.put(SELECTED_GENDER_LOGO, SELECTED_GENDER_LOGO_TASK);
        elementMap.put(SELECT_WEIGHT_LABEL, SELECT_WEIGHT_LABEL_TASK);
        elementMap.put(WEIGHT_VALUE, WEIGHT_VALUE_TASK);
        elementMap.put(WEIGHT_SCROLL_BAR, WEIGHT_SCROLL_BAR_TASK);

        performActions(elementMap, wait);
    }


    @Test(retryAnalyzer = RetryAnalyzer.class, enabled = true, groups = {"FirstTime login page"})
    public void TC_008() throws Exception {

        bs.CoreLoginForAndroid(true);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        Map<By, ElementTask> elementMap = new LinkedHashMap<>();

        /* Pre-Request */
        elementMap.put(PROFILE_BUTTON, PROFILE_BUTTON_TASK);
        elementMap.put(PROFILE_COACH_MARK_SKIP, PROFILE_COACH_MARK_SKIP_TASK);
        elementMap.put(EDIT_PROFILE_BUTTON, EDIT_PROFILE_BUTTON_TASK);

        performActions(elementMap, wait);

        // Click the "Continue" button 4 times max using different locators
        List<By> continueLocators = Arrays.asList(
                CONTINUE_BUTTON,
                CONTINUE_BUTTON_2,
                CONTINUE_BUTTON_3
        );

        int clickCount = 0;
        while (clickCount < 4) {
            boolean clicked = false;
            for (By locator : continueLocators) {
                try {
                    WebElement btn = wait.until(ExpectedConditions.elementToBeClickable(locator));
                    if (btn.isDisplayed()) {
                        btn.click();
                        LogUtil.info("Clicked Continue button using locator: " + locator);
                        clicked = true;
                        Thread.sleep(5000); // Wait for page transition
                        clickCount++;
                        break;
                    }
                } catch (Exception e) {
                    LogUtil.info("Locator not clickable this round: " + locator);
                }
            }
            if (!clicked) {
                LogUtil.info("No clickable 'Continue' button found on iteration " + (clickCount + 1));
                break;
            }
        }

        Map<By, ElementTask> elementMap2 = new LinkedHashMap<>();

        /* Actual test case */
        elementMap2.put(SELECT_BIRTH_DATE_LABEL, SELECT_BIRTH_DATE_LABEL_TASK);
        elementMap2.put(BIRTH_DATE_SCROLL_BAR, BIRTH_DATE_SCROLL_BAR_TASK);
        elementMap2.put(BIRTH_MONTH_SCROLL_BAR, BIRTH_MONTH_SCROLL_BAR_TASK);
        elementMap2.put(BIRTH_YEAR_SCROLL_BAR, BIRTH_YEAR_SCROLL_BAR_TASK);

        performActions(elementMap2, wait);
    }

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void TC_009() throws Exception {

        bs.CoreLoginForAndroid(true);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        Map<By, ElementTask> elementMap = new LinkedHashMap<>();

        /* Pre-Request*/
        elementMap.put(PROFILE_BUTTON, PROFILE_BUTTON_TASK);
        elementMap.put(PROFILE_COACH_MARK_SKIP, PROFILE_COACH_MARK_SKIP_TASK);
        elementMap.put(CONSUME_EDIT_BUTTON, CONSUME_EDIT_BUTTON_TASK);
        /*Actual test case.*/
        elementMap.put(DO_YOU_CONSUME_ALCOHOL_LABEL, DO_YOU_CONSUME_ALCOHOL_LABEL_TASK);
        elementMap.put(ALCOHOL_YES_BUTTON, ALCOHOL_YES_BUTTON_TASK);
        elementMap.put(ALCOHOL_NO_BUTTON, ALCOHOL_NO_BUTTON_TASK);
        elementMap.put(ALCOHOL_OCCASIONALLY_BUTTON, ALCOHOL_OCCASIONALLY_BUTTON_TASK);

        elementMap.put(DO_YOU_SMOKE_LABEL, DO_YOU_SMOKE_LABEL_TASK);
        elementMap.put(SMOKE_YES_BUTTON, SMOKE_YES_BUTTON_TASK);
        elementMap.put(SMOKE_NO_BUTTON, SMOKE_NO_BUTTON_TASK);
        elementMap.put(SMOKE_OCCASIONALLY_BUTTON, SMOKE_OCCASIONALLY_BUTTON_TASK);
        performActions(elementMap, wait);
    }
}
