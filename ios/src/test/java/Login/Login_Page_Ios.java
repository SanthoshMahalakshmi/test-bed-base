package Login;

import Actions.iOSActionType;
import Actions.iOSElementTask;
import DriverManagerIos.BaseLoginForiOS;
import DriverManagerIos.DriverManager;
import UtilitiesForIos.LogUtil;
import UtilitiesForIos.RetryAnalyzerios;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.LinkedHashMap;
import java.util.Map;

import static UtilitiesForIos.iOSElementActions.*;
import static iOSElemenRepositories.iOSCommonElements.*;
import static iOSElemenRepositories.iOSConsumeEditPage.*;
import static iOSElemenRepositories.iOSEditProfilePage1Elements.*;
import static iOSElemenRepositories.iOSEditProfilePage2Elements.*;
import static iOSElemenRepositories.iOSEditProfilePage3Elements.*;
import static iOSElemenRepositories.iOSEditProfilePage4Elements.*;
import static iOSElemenRepositories.iOSEditProfilePage5Elements.*;
import static iOSElemenRepositories.iOSLoginScreenElements.*;
import static iOSElemenRepositories.iOSOTPVerifyScreenElements.*;
import static iOSElemenRepositories.iOSProfileScreenElements.*;
import static iOSElemenRepositories.iOSSplashScreenElements.*;

public class Login_Page_Ios extends DriverManager {

    BaseLoginForiOS baseLoginForiOS = new BaseLoginForiOS();

    @Test(retryAnalyzer = RetryAnalyzerios.class)
    public void TC_002() {

        /*Global wait.*/
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        Map<By, iOSElementTask> iOSElementMap = new LinkedHashMap<>();
        iOSElementMap.put(iOS_TITLE_LOGO_IMAGE, iOS_TITLE_LOGO_IMAGE_TASK);
        iOSElementMap.put(iOS_NEXT_BTN, iOS_NEXT_BTN_TASK);
        performIOSActions(iOSElementMap, wait);

        Map<By, iOSElementTask> iOSElementMap2 = new LinkedHashMap<>();
        iOSElementMap2.put(iOS_NEXT_BTN, iOS_NEXT_BTN_TASK);
        iOSElementMap2.put(iOS_GET_STARTED_BTN, iOS_GET_STARTED_BTN_TASK);
        performIOSActions(iOSElementMap2, wait);

        Map<By, iOSElementTask> iOSElementMap3 = new LinkedHashMap<>();
        iOSElementMap3.put(iOS_MOBILE_NUMBER_FIELD, new iOSElementTask.Builder(iOSActionType.VERIFY, "Mobile Number").build());
        iOSElementMap3.put(iOS_COUNTRY_CODE, iOS_COUNTRY_CODE_TASK);
        iOSElementMap3.put(iOS_CONTINUE_BTN, new iOSElementTask.Builder(iOSActionType.VERIFY, "Continue").build());
        iOSElementMap3.put(iOS_PRIVACY_POLICY_LINK, iOS_PRIVACY_POLICY_LINK_TASK);
        performIOSActions(iOSElementMap3, wait);
    }

    @Test(retryAnalyzer = RetryAnalyzerios.class)
    public void TC_003() {
        /*Global wait.*/
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        /*Pre-Condition*/
        Map<By, iOSElementTask> iOSElementMap = new LinkedHashMap<>();
        iOSElementMap.put(iOS_NEXT_BTN, iOS_NEXT_BTN_TASK);
        performIOSActions(iOSElementMap, wait);

        Map<By, iOSElementTask> iOSElementMap2 = new LinkedHashMap<>();
        iOSElementMap2.put(iOS_NEXT_BTN, iOS_NEXT_BTN_TASK);
        iOSElementMap2.put(iOS_GET_STARTED_BTN, iOS_GET_STARTED_BTN_TASK);
        performIOSActions(iOSElementMap2, wait);

        try {
            driver.findElement(AppiumBy.xpath("//XCUIElementTypeTextField[@value=\"9999999999\"]")).sendKeys("9087631080");

        }catch (Exception e)
        {
            throw new RuntimeException(e.getMessage());
        }

        Map<By, iOSElementTask> iOSElementMap3 = new LinkedHashMap<>();
        iOSElementMap3.put(iOS_KEYBOARD_DONE_BUTTON, iOS_KEYBOARD_DONE_BUTTON_TASK);
        iOSElementMap3.put(iOS_CONTINUE_BTN, iOS_CONTINUE_BTN_TASK);
        performIOSActions(iOSElementMap3, wait);


        String otp = "123456";
        for (int i = 0; i < otp.length(); i++) {
            wait.until(ExpectedConditions.visibilityOfElementLocated(iOS_OTP_FIELDS[i]))
                    .sendKeys(String.valueOf(otp.charAt(i)));
        }



        Map<By, iOSElementTask> iOSElementMap4 = new LinkedHashMap<>();
        iOSElementMap4.put(iOS_VERIFY_MOBILE_NUMBER_LABEL, iOS_VERIFY_MOBILE_NUMBER_LABEL_TASK);
        iOSElementMap4.put(iOS_RESEND_LABEL, iOS_RESEND_LABEL_TASK);
        iOSElementMap4.put(iOS_OTP_VERIFY_BUTTON, iOS_OTP_VERIFY_BUTTON_TASK);
        performIOSActions(iOSElementMap4, wait);

    }

    @Test(retryAnalyzer = RetryAnalyzerios.class, enabled = true, groups = {"FirstTime login page"})
    public void TC_004() {

        baseLoginForiOS.BaseLoginForIos(false);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        Map<By, iOSElementTask> iOSElementMap = new LinkedHashMap<>();

        iOSElementMap.put(iOS_PROFILE_BUTTON, iOS_PROFILE_BUTTON_TASK);
        iOSElementMap.put(iOS_PROFILE_COACH_MARK_SKIP, iOS_PROFILE_COACH_MARK_SKIP_TASK);
        iOSElementMap.put(iOS_EDIT_PROFILE_BUTTON, iOS_EDIT_PROFILE_BUTTON_TASK);
        iOSElementMap.put(iOS_PROFILE_PICTURE_OPTION,iOS_PROFILE_PICTURE_OPTION_TASK);
        iOSElementMap.put(iOS_FULL_NAME_INPUT_FIELD, iOS_FULL_NAME_INPUT_FIELD_TASK);
        iOSElementMap.put(iOS_EMAIL_ID_INPUT_FIELD, iOS_EMAIL_ID_INPUT_FIELD_TASK);
        iOSElementMap.put(iOS_MOBILE_NUMBER_INPUT_FIELD, iOS_MOBILE_NUMBER_INPUT_FIELD_TASK);
        iOSElementMap.put(iOS_CONTINUE_BUTTON, iOS_CONTINUE_BUTTON_TASK);
        performIOSActions(iOSElementMap, wait);
    }

    @Test(retryAnalyzer = RetryAnalyzerios.class)
    public void TC_005()  {

        baseLoginForiOS.BaseLoginForIos(false);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        /*Pre-Request*/
        Map<By, iOSElementTask> iOSElementMap = new LinkedHashMap<>();

        iOSElementMap.put(iOS_PROFILE_BUTTON, iOS_PROFILE_BUTTON_TASK);

        iOSElementMap.put(iOS_PROFILE_COACH_MARK_SKIP, iOS_PROFILE_COACH_MARK_SKIP_TASK);

        iOSElementMap.put(iOS_EDIT_PROFILE_BUTTON, iOS_EDIT_PROFILE_BUTTON_TASK);

        iOSElementMap.put(iOS_CONTINUE_BTN, iOS_CONTINUE_BTN_TASK);

        performIOSActions(iOSElementMap, wait);

        /*Actual Test Execution*/
        Map<By, iOSElementTask> iOSElementMap2 = new LinkedHashMap<>();

        iOSElementMap2.put(iOS_MALE_LOGO_ELEMENT, new iOSElementTask.Builder(iOSActionType.VERIFY, "Male Logo Option").build());

        iOSElementMap2.put(iOS_FEMALE_LOGO_ELEMENT, iOS_FEMALE_LOGO_ELEMENT_TASK);

        iOSElementMap2.put(iOS_OTHER_LOGO_ELEMENT, iOS_OTHER_LOGO_ELEMENT_TASK);

        iOSElementMap2.put(iOS_CONTINUE_BTN, iOS_CONTINUE_BUTTON_TASK);

        performIOSActions(iOSElementMap2, wait);

    }

    @Test(retryAnalyzer = RetryAnalyzerios.class, enabled = true, groups = {"FirstTime login page"})
    public void TC_006() {

        baseLoginForiOS.BaseLoginForIos(false);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        /*Pre-Request*/
        Map<By, iOSElementTask> iOSElementMap1 = new LinkedHashMap<>();

        iOSElementMap1.put(iOS_PROFILE_BUTTON, iOS_PROFILE_BUTTON_TASK);

        iOSElementMap1.put(iOS_PROFILE_COACH_MARK_SKIP, iOS_PROFILE_COACH_MARK_SKIP_TASK);

        iOSElementMap1.put(iOS_EDIT_PROFILE_BUTTON, iOS_EDIT_PROFILE_BUTTON_TASK);

        iOSElementMap1.put(iOS_CONTINUE_BTN, iOS_CONTINUE_BTN_TASK);

        performIOSActions(iOSElementMap1, wait);

        Map<By, iOSElementTask> iOSElementMap2 = new LinkedHashMap<>();

        iOSElementMap2.put(iOS_CONTINUE_BTN, iOS_CONTINUE_BTN_TASK);

        performIOSActions(iOSElementMap2, wait);

        /*Actual Test case*/
        Map<By, iOSElementTask> iOSElementMap3 = new LinkedHashMap<>();

        iOSElementMap3.put(iOS_SELECT_HEIGHT_LABEL, iOS_SELECT_HEIGHT_LABEL_TASK);

        iOSElementMap3.put(iOS_HEIGHT_VALUE, iOS_HEIGHT_VALUE_TASK);

        iOSElementMap3.put(iOS_HEIGHT_SCROLLBAR, iOS_HEIGHT_SCROLLBAR_TASK);

        iOSElementMap3.put(iOS_SELECTED_GENDER_LOGO, iOS_SELECTED_GENDER_LOGO_TASK);

        performIOSActions(iOSElementMap3, wait);

    }

    @Test(retryAnalyzer = RetryAnalyzerios.class)
    public void TC_007()  {

        baseLoginForiOS.BaseLoginForIos(false);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        /*Pre-Request-1*/
        Map<By, iOSElementTask> iOSElementMap1 = new LinkedHashMap<>();

        iOSElementMap1.put(iOS_PROFILE_BUTTON, iOS_PROFILE_BUTTON_TASK);

        iOSElementMap1.put(iOS_PROFILE_COACH_MARK_SKIP, iOS_PROFILE_COACH_MARK_SKIP_TASK);

        iOSElementMap1.put(iOS_EDIT_PROFILE_BUTTON, iOS_EDIT_PROFILE_BUTTON_TASK);

        iOSElementMap1.put(iOS_CONTINUE_BTN, iOS_CONTINUE_BTN_TASK);

        performIOSActions(iOSElementMap1, wait);

        /*Pre-Request-2*/
        Map<By, iOSElementTask> iOSElementMap2 = new LinkedHashMap<>();

        iOSElementMap2.put(iOS_CONTINUE_BTN, iOS_CONTINUE_BTN_TASK);

        performIOSActions(iOSElementMap2, wait);

        /*Pre-Request-3*/
        Map<By, iOSElementTask> iOSElementMap3 = new LinkedHashMap<>();

        iOSElementMap3.put(iOS_CONTINUE_BTN, iOS_CONTINUE_BTN_TASK);

        performIOSActions(iOSElementMap3, wait);

        /*Actual Test Case*/
        Map<By, iOSElementTask> iOSElementMap4 = new LinkedHashMap<>();

        iOSElementMap4.put(iOS_SELECTED_GENDER_LOGO, iOS_SELECTED_GENDER_LOGO_TASK);

        iOSElementMap4.put(iOS_SELECT_WEIGHT_LABEL,iOS_SELECT_WEIGHT_LABEL_TASK);

        iOSElementMap4.put(iOS_WEIGHT_VALUE, iOS_WEIGHT_VALUE_TASK);

        iOSElementMap4.put(iOS_WEIGHT_SCROLL_BAR, iOS_WEIGHT_SCROLL_BAR_TASK);

        performIOSActions(iOSElementMap4, wait);

    }

    @Test(retryAnalyzer = RetryAnalyzerios.class, enabled = true, groups = {"FirstTime login page"})
    public void TC_008() throws Exception {

        baseLoginForiOS.BaseLoginForIos(false);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        /*Pre-Request-1*/
        Map<By, iOSElementTask> iOSElementMap1 = new LinkedHashMap<>();

        iOSElementMap1.put(iOS_PROFILE_BUTTON, iOS_PROFILE_BUTTON_TASK);

        iOSElementMap1.put(iOS_PROFILE_COACH_MARK_SKIP, iOS_PROFILE_COACH_MARK_SKIP_TASK);

        iOSElementMap1.put(iOS_EDIT_PROFILE_BUTTON, iOS_EDIT_PROFILE_BUTTON_TASK);

        iOSElementMap1.put(iOS_CONTINUE_BTN, iOS_CONTINUE_BTN_TASK);

        performIOSActions(iOSElementMap1, wait);

        /*Pre-Request-2*/
        Map<By, iOSElementTask> iOSElementMap2 = new LinkedHashMap<>();

        iOSElementMap2.put(iOS_CONTINUE_BTN, iOS_CONTINUE_BTN_TASK);

        performIOSActions(iOSElementMap2, wait);

        /*Pre-Request-3*/
        Map<By, iOSElementTask> iOSElementMap3 = new LinkedHashMap<>();

        iOSElementMap3.put(iOS_CONTINUE_BTN, iOS_CONTINUE_BTN_TASK);

        performIOSActions(iOSElementMap3, wait);

        /*Pre-Request-4*/
        Map<By, iOSElementTask> iOSElementMap4 = new LinkedHashMap<>();

        iOSElementMap4.put(iOS_CONTINUE_BTN, iOS_CONTINUE_BTN_TASK);

        performIOSActions(iOSElementMap4, wait);


        /*Actual Test Case*/
        Map<By, iOSElementTask> iOSElementMap5 = new LinkedHashMap<>();

        iOSElementMap5.put(iOS_SELECT_BIRTH_DATE_LABEL, iOS_SELECT_BIRTH_DATE_LABEL_TASK);

        iOSElementMap5.put(iOS_BIRTH_DATE_SCROLL_BAR, iOS_BIRTH_DATE_SCROLL_BAR_TASK);

        iOSElementMap5.put(iOS_BIRTH_MONTH_SCROLL_BAR, iOS_BIRTH_MONTH_SCROLL_BAR_TASK);

        iOSElementMap5.put(iOS_BIRTH_YEAR_SCROLL_BAR, iOS_BIRTH_YEAR_SCROLL_BAR_TASK);

        performIOSActions(iOSElementMap5,wait);


    }

    @Test(retryAnalyzer = RetryAnalyzerios.class)
    public void TC_009() {

        baseLoginForiOS.BaseLoginForIos(false);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        /*Pre-Request.*/
        Map<By, iOSElementTask> iOSElementMap1 = new LinkedHashMap<>();

        iOSElementMap1.put(iOS_PROFILE_BUTTON, iOS_PROFILE_BUTTON_TASK);

        iOSElementMap1.put(iOS_PROFILE_COACH_MARK_SKIP, iOS_PROFILE_COACH_MARK_SKIP_TASK);

        iOSElementMap1.put(iOS_CONSUME_EDIT_BUTTON, iOS_CONSUME_EDIT_BUTTON_TASK);

        iOSElementMap1.put(iOS_DO_YOU_CONSUME_ALCOHOL_LABEL, iOS_DO_YOU_CONSUME_ALCOHOL_LABEL_TASK);

        iOSElementMap1.put(iOS_ALCOHOL_YES_BUTTON, iOS_ALCOHOL_YES_BUTTON_TASK);

        iOSElementMap1.put(iOS_ALCOHOL_NO_BUTTON, iOS_ALCOHOL_NO_BUTTON_TASK);

        iOSElementMap1.put(iOS_ALCOHOL_OCCASIONALLY_BUTTON, iOS_ALCOHOL_OCCASIONALLY_BUTTON_TASK);

        iOSElementMap1.put(iOS_DO_YOU_SMOKE_LABEL, iOS_DO_YOU_SMOKE_LABEL_TASK);

        iOSElementMap1.put(iOS_SMOKE_YES_BUTTON, iOS_SMOKE_YES_BUTTON_TASK);

        iOSElementMap1.put(iOS_SMOKE_NO_BUTTON, iOS_SMOKE_NO_BUTTON_TASK);

        iOSElementMap1.put(iOS_SMOKE_OCCASIONALLY_BUTTON, iOS_SMOKE_OCCASIONALLY_BUTTON_TASK);

        performIOSActions(iOSElementMap1, wait);

    }
}
