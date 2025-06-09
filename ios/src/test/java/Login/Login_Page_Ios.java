package Login;

import Actions.iOSActionType;
import Actions.iOSElementTask;
import DriverManagerIos.BaseLoginForiOS;
import DriverManagerIos.DriverManager;
import UtilitiesForIos.LogUtil;
import UtilitiesForIos.RetryAnalyzerios;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.LinkedHashMap;
import java.util.Map;

import static UtilitiesForIos.iOSElementActions.*;
import static iOSElemenRepositories.iOSCommonElements.*;
import static iOSElemenRepositories.iOSEditProfilePage1Elements.*;
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

        iOSElementMap.put(iOS_PROFILE_BUTTON, iOS_iOS_PROFILE_BUTTON_TASK);
        iOSElementMap.put(iOS_PROFILE_COACH_MARK_SKIP, iOS_PROFILE_COACH_MARK_SKIP_TASK);
        iOSElementMap.put(iOS_EDIT_PROFILE_BUTTON, iOS_EDIT_PROFILE_BUTTON_TASK);
        iOSElementMap.put(iOS_PROFILE_PICTURE_OPTION,iOS_PROFILE_PICTURE_OPTION_TASK);
        iOSElementMap.put(iOS_FULL_NAME_INPUT_FIELD, iOS_FULL_NAME_INPUT_FIELD_TASK);
        iOSElementMap.put(iOS_EMAIL_ID_INPUT_FIELD, iOS_EMAIL_ID_INPUT_FIELD_TASK);
        iOSElementMap.put(iOS_MOBILE_NUMBER_INPUT_FIELD, iOS_MOBILE_NUMBER_INPUT_FIELD_TASK);
        iOSElementMap.put(iOS_CONTINUE_BUTTON, iOS_CONTINUE_BUTTON_TASK);
        performIOSActions(iOSElementMap, wait);
    }

    @Test(retryAnalyzer = RetryAnalyzerios.class, enabled = true, groups = {"FirstTime login page"})
    public void TC_005() throws Exception {

        TC_004(); //  1st page of basic details.

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        WebElement Pagination = null;
        try {
            //1.Select the female option.
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.
                    iOSClassChain("**/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther" +
                            "/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther" +
                            "/XCUIElementTypeOther[2]/XCUIElementTypeOther[1]/XCUIElementTypeOther[2]" +
                            "/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeImage"))).click();
            LogUtil.info("Female option is selected");

            //2.Select the male option
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.
                    iOSClassChain("**/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther" +
                            "/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]" +
                            "/XCUIElementTypeOther[1]/XCUIElementTypeOther[2]" +
                            "/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeImage"))).click();

            //3.Others.
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.
                    iOSClassChain("**/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther" +
                            "/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther" +
                            "/XCUIElementTypeOther[2]/XCUIElementTypeOther[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther" +
                            "/XCUIElementTypeOther[3]/XCUIElementTypeImage"))).click();

            //Selecting the man logo again for reference.
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.
                    iOSClassChain("**/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther" +
                            "/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]" +
                            "/XCUIElementTypeOther[1]/XCUIElementTypeOther[2]" +
                            "/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeImage"))).click();

            //4.Respective pagination
            Pagination = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.accessibilityId("2 of 5")));
            LogUtil.info("Pagination is visible : " + Pagination.isDisplayed());

        } catch (Exception e) {
            LogUtil.warning("male or female or others not selected in page-2.");
        }

        try {
            //5.continue button clicking
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.
                    iOSClassChain("**/XCUIElementTypeStaticText[`name == \"Continue\"`]"))).click();
            LogUtil.info("Continue button is clicked.");
        } catch (Exception e) {
            LogUtil.warning("1st time user Verification is not working in basic detail page-2.");
        }

    }

    @Test(retryAnalyzer = RetryAnalyzerios.class, enabled = true, groups = {"FirstTime login page"})
    public void TC_006() throws Exception {

        TC_005(); // To complete the before pages.

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        WebElement Height_label, Default_height, logo, pagination = null;
        try {
            Height_label = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.accessibilityId("Select Height")));
            LogUtil.info("User currently in " + Height_label.getText() + "page.");

            Default_height = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.accessibilityId("5 ft. 2 in.")));
            LogUtil.info("Default height " + Default_height.getText() + " is Selected.");

            //3.verifying the logo is present or not.
            logo = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.
                    iOSClassChain("**/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther" +
                            "/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther" +
                            "/XCUIElementTypeOther[2]/XCUIElementTypeOther[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther" +
                            "/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeImage")));
            LogUtil.info("Logo is visible " + logo.isDisplayed());

            //4.pagination is present in the screen
            pagination = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.
                    accessibilityId("3 of 5")));
            LogUtil.info("Pagination is present " + pagination.isDisplayed());
        } catch (Exception e) {
            LogUtil.warning("Label and default is not visible in page-3.");
        }

        try {
            //5.clicking the continue button.
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.
                    iOSClassChain("**/XCUIElementTypeStaticText[`name == \"Continue\"`]"))).click();
        } catch (Exception e) {
            LogUtil.warning("1st time user Verification is not working in basic detail page-3.");
        }

    }

    @Test(retryAnalyzer = RetryAnalyzerios.class, enabled = true, groups = {"FirstTime login page"})
    public void TC_007() throws Exception {
        TC_006(); //To complete the previous steps.

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement Weight_label, Default_Weight, logo, pagination = null;
        try {
            Weight_label = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.accessibilityId("Select Weight")));
            LogUtil.info("User currently in " + Weight_label.getText() + "page.");

            Default_Weight = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.accessibilityId("20 kg")));
            LogUtil.info("Default height " + Default_Weight.getText() + " is Selected.");

            //Verify the logo
            logo = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.className("XCUIElementTypeCollectionView")));
            LogUtil.info("Selected gender logo is present " + logo.isDisplayed());

            //Pagination verification
            pagination = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.accessibilityId("4 of 5")));
            LogUtil.info("Pagination is present " + pagination.isDisplayed());
        } catch (Exception e) {
            LogUtil.warning("Weight and default weight is not selected in page-4.");
        }

        try {
            //Clicking the continue button
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.
                    iOSClassChain("**/XCUIElementTypeStaticText[`name == \"Continue\"`]"))).click();
        } catch (Exception e) {
            LogUtil.warning("1st time user Verification is not working in basic detail page-4.");

        }
    }

    @Test(retryAnalyzer = RetryAnalyzerios.class, enabled = true, groups = {"FirstTime login page"})
    public void TC_008() throws Exception {

        TC_007(); //To complete the previous steps.

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        WebElement BirthYear_label, pagination = null;
        try {
            BirthYear_label = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.accessibilityId("Select Birth Year")));
            LogUtil.info("User currently in " + BirthYear_label.getText() + "page.");

            //pagination.
            pagination = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.accessibilityId("5 of 5")));
            LogUtil.info("pagination is present : " + pagination.isDisplayed());
        } catch (Exception e) {
            LogUtil.warning("Birth year and pagination is not visible in page-5.");
        }

        try {
            //submit
            WebElement submit = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.
                    iOSClassChain("**/XCUIElementTypeStaticText[`name == \"Submit\"`]")));
            LogUtil.info("Submit button is present : " + submit.isDisplayed());
            submit.click();
        } catch (Exception e) {
            LogUtil.warning("1st time user Verification is not working in basic detail page-4.");
        }
    }

    @Test(retryAnalyzer = RetryAnalyzerios.class, enabled = true, groups = {"FirstTime login page"})
    public void TC_009() throws Exception {
        TC_008(); // To complete the previous steps.

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        try {

            /*After profile created the successfully toast is not coming.*/

            //confirm alert
            wait.until(ExpectedConditions.alertIsPresent());

            //Alcohol yes button
            wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.
                    iOSClassChain("**/XCUIElementTypeStaticText[`name == \"Yes\"`][1]")));
            LogUtil.info("Yes button for alcohol is visible.");

            //Alcohol No button
            wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.
                    iOSClassChain("**/XCUIElementTypeStaticText[`name == \"No\"`][1]")));
            LogUtil.info("No button for alcohol is visible.");

            //Alcohol Occasionally button
            wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.
                    iOSClassChain("**/XCUIElementTypeStaticText[`name == \"Occasionally\"`][1]"))).click();
            LogUtil.info("Occasionally button for alcohol is visible.");

            //Smoke Yes button
            wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.
                    iOSClassChain("**/XCUIElementTypeButton[`name == \"Yes\"`][2]")));
            LogUtil.info("Yes button for smoke is visible.");

            //Smoke NO button
            wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.
                    iOSClassChain("**/XCUIElementTypeStaticText[`name == \"No\"`][2]")));
            LogUtil.info("NO button for smoke is visible.");

            //Smoke Occasionally button
            wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.
                    iOSClassChain("**/XCUIElementTypeStaticText[`name == \"Occasionally\"`][2]"))).click();
            LogUtil.info("Occasionally button for smoke is visible.");

            //Submit button
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.
                    iOSClassChain("**/XCUIElementTypeStaticText[`name == \"Submit\"`]"))).click();

        } catch (Exception e) {
            LogUtil.warning("None of the option is selected on this page.");
        }

        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.
                    iOSClassChain("**/XCUIElementTypeStaticText[`name == \"Skip\"`]"))).click();
        } catch (Exception e) {
            LogUtil.warning("There is not skip button.");
        }
    }
}
