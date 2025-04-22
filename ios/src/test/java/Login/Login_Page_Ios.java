package Login;

import DriverManagerIos.BaseLoginForiOS;
import DriverManagerIos.DriverManager;
import UtilitiesForIos.RetryAnalyzerios;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import java.time.Duration;

public class Login_Page_Ios extends DriverManager {

    private static final Logger log = LoggerFactory.getLogger(Login_Page_Ios.class);
    BaseLoginForiOS baseLoginForiOS = new BaseLoginForiOS();

    @Test(retryAnalyzer = RetryAnalyzerios.class)
    public void TC_002() {
        /*Global wait.*/
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.iOSClassChain("**/XCUIElementTypeButton[`name == \"Allow\"`]"))).click();
            logger.info("before login->Allow button is visible and its clicked Allow");
        }
        catch (Exception e)
        {
            logger.info("Before login-> Notification allow Button is not pop-up to accept allow.");
        }

        try {
            /*Clicking the Get started button*/
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.
                    iOSClassChain("**/XCUIElementTypeStaticText[`name == \"Get Started\"`]"))).click();
            logger.info("Get started button is clicked.");
        } catch (Exception e) {
            logger.warning("Get started button is not visible.");
        }

        try {
            /*1.Verify the logo is present or not in the login page.*/
            WebElement logo = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.accessibilityId("AppLogo")));
            logger.info("Logo is present :" + logo.isDisplayed());
        } catch (Exception e) {
            logger.warning("Logo is not visible.");
        }

        try {
            //3.clicking the mobile number input field and send the keys to it.
            wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.
                    iOSClassChain("**/XCUIElementTypeTextField[`value == \"9999999999\"`]"))).sendKeys("0000000000");
            logger.info("Mobile number filed is having correct mobile number.");
        } catch (Exception e) {
            logger.warning("Mobile number field is not having the input value.");
        }

        try {
            /* 2.country code is present in the screen or not.  Important - country code is not available in other devices*/
            WebElement countryCode = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.
                    iOSClassChain("**/XCUIElementTypeTextField[`value == \"+91\"`]")));
            logger.info("Country code is present :" + countryCode.isDisplayed());
        } catch (Exception e) {
            logger.warning("Country code is not visible.");
        }

        try {
            //4.Clicking the continue button
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.
                    iOSClassChain("**/XCUIElementTypeStaticText[`name == \"Continue\"`]"))).click();
            logger.info("Continue button is clicked.");

        } catch (Exception e) {
            logger.warning("Continue is not clicked.");
        }

        try {
            /*Back to log in page*/
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("Navigate up"))).click();
        } catch (Exception e) {
            logger.warning("Navigating back is not working.");
        }

        /*Need to check this on ios simulator.*/
        /* *//*5.Terms and condition link*//*
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("com.moai.android:id/txtTerms"))).click();*/

        /*Back to log in page*//*
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("Navigate up"))).click();

        *//*5.Terms and condition link*//*
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("com.moai.android:id/txtPrivacy"))).click();*/

    }

    @Test(retryAnalyzer = RetryAnalyzerios.class)
    public void TC_003() {
        /*Global wait.*/
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.iOSClassChain("**/XCUIElementTypeButton[`name == \"Allow\"`]"))).click();
            logger.info("before login->Allow button is visible and its clicked Allow");
        }
        catch (Exception e)
        {
            logger.info("Before login-> Notification allow Button is not pop-up to accept allow.");
        }

        try {
            /*Clicking the Get started button*/
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.
                    iOSClassChain("**/XCUIElementTypeStaticText[`name == \"Get Started\"`]"))).click();
            logger.info("Get started button is clicked.");
        } catch (Exception e) {
            logger.warning("Get started button is not visible.");
        }

        try {
            //3.clicking the mobile number input field and send the keys to it.
            wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.
                    iOSClassChain("**/XCUIElementTypeTextField[`value == \"9999999999\"`]"))).sendKeys("0000000000");
            logger.info("Mobile number filed is having correct mobile number.");
        } catch (Exception e) {
            logger.warning("Mobile number field id not having the input value.");
        }

        try {
            //4.Clicking the continue button
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.
                    iOSClassChain("**/XCUIElementTypeStaticText[`name == \"Continue\"`]"))).click();
            logger.info("Continue button is clicked.");
        } catch (Exception e) {
            logger.warning("Continue is not clicked.");
        }

        WebElement Delay_Ok = null;  /* Important->Need to check this ok button element in simulator.*/
        try {
            Delay_Ok = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("android:id/button1")));
            Delay_Ok.click();
            logger.info("*OK Button found and its clicked");
        } catch (Exception e) {
            logger.warning("Element is not found, we good to go with login");
        }

        try {
            //1.verify mobile number label
            WebElement label = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.accessibilityId("Mobile Number")));
            logger.info("Verify mobile number label : " + label.isDisplayed());
        } catch (Exception e) {
            logger.warning("Mobile number label is no visible.");
        }

        try {
            //2.Enter OTP label
            WebElement OtpLabel = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.accessibilityId("Enter OTP")));
            logger.info("Enter OTP label : " + OtpLabel.isDisplayed());
        } catch (Exception e) {
            logger.warning("OTP lable is not visible.");
        }

        //Fill the OTP into input field.
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.
                            xpath("//XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTextField[1]")))
                    .sendKeys("1");
            wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.
                            xpath("//XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTextField[2]")))
                    .sendKeys("2");
            wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.
                            xpath("//XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTextField[3]")))
                    .sendKeys("3");
            wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.
                            xpath("//XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTextField[4]")))
                    .sendKeys("4");
            wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.
                            xpath("//XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTextField[5]")))
                    .sendKeys("5");
            wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.
                            xpath("//XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTextField[6]")))
                    .sendKeys("6");
            logger.info("Otp is entered and we moved further.");
        } catch (Exception e) {
            logger.warning("Entered OTP input is not correct.");
        }

        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.accessibilityId("Done"))).click();
            logger.info("keyboard done button is clicked.");
        } catch (Exception e) {
            logger.warning("Keyboard Done button is not clicked.");
        }

        try {
            //4.Resend label
            WebElement resend = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.
                    iOSClassChain("**/XCUIElementTypeStaticText[`name == \"Resend OTP\"`]")));
            logger.info("Resent label is present : " + resend.isDisplayed());
        } catch (Exception e) {
            logger.warning("Resend label is not visible.");
        }

        //4.Timer element.
        WebElement Timer = null;
        try {
            Timer = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.
                    accessibilityId("02:55")));
            logger.info("Timer is present? : " + Timer.isDisplayed());
        } catch (Exception e) {
            logger.warning("*Timer is not found");
        }

        //3.clicking the verify button.
        WebElement verifyButton = null;
        try {
            verifyButton = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.
                    iOSClassChain("**/XCUIElementTypeStaticText[`name == \"Verify OTP\"`]")));
            logger.info("Verify button present? : " + verifyButton.isDisplayed());
        } catch (Exception e) {
            logger.warning("*Verify button is not found");
        }
    }

    @Test(retryAnalyzer = RetryAnalyzerios.class, enabled = true, groups = {"FirstTime login page"})
    public void TC_004() throws Exception {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        baseLoginForiOS.BaseLoginForIos(true);

        WebElement profile_picture, Mobile_number, pagination = null;
        try {
            profile_picture = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.accessibilityId("ic addimage")));
            logger.info("profile picture option is available for selecting picture" + profile_picture.isDisplayed());

            //2.Full name
            wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.
                    iOSClassChain("**/XCUIElementTypeTextField[`value == \"Full Name\"`]"))).sendKeys("mam");
            logger.info("First name filed is filled with user name.");

            //3.Email ID
            wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.
                            iOSClassChain("**/XCUIElementTypeTextField[`value == \"Email Address\"`]"))).
                    sendKeys("mam@gmail.com");
            logger.info("Email id field is filled with user email.");

            //4.Mobile number
            Mobile_number = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.
                    iOSClassChain("**/XCUIElementTypeTextField[`value == \"9087631080\"`]")));
            logger.info("Mobile number field is filled already with given number" + Mobile_number.isDisplayed());

           pagination = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.accessibilityId("1 of 5")));
           logger.info("pagination is visible " + pagination.isDisplayed());

        } catch (Exception e) {
            logger.warning("first name, email not added in page-1.");
        }

        /*Accessibility for error message ->> "Please enter Valid name"*/ /*Need to add conditional check here.*/

        try /*Moving to next page.*/ {
            //5.Continue button
            wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.
                    iOSClassChain("**/XCUIElementTypeStaticText[`name == \"Continue\"`]"))).click();
            logger.info("Continue button is clicked.");
        } catch (Exception e) {
            logger.warning("1st time user Verification is not working in basic detail page-1.");
        }
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
            logger.info("Female option is selected");

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
            logger.info("Pagination is visible : " + Pagination.isDisplayed());

        } catch (Exception e) {
            logger.warning("male or female or others not selected in page-2.");
        }

        try {
            //5.continue button clicking
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.
                    iOSClassChain("**/XCUIElementTypeStaticText[`name == \"Continue\"`]"))).click();
            logger.info("Continue button is clicked.");
        } catch (Exception e) {
            logger.warning("1st time user Verification is not working in basic detail page-2.");
        }

    }

    @Test(retryAnalyzer = RetryAnalyzerios.class, enabled = true, groups = {"FirstTime login page"})
    public void TC_006() throws Exception {

        TC_005(); // To complete the before pages.

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        WebElement Height_label, Default_height, logo, pagination = null;
        try {
            Height_label = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.accessibilityId("Select Height")));
            logger.info("User currently in " + Height_label.getText() + "page.");

            Default_height = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.accessibilityId("5 ft. 2 in.")));
            logger.info("Default height " + Default_height.getText() + " is Selected.");

            //3.verifying the logo is present or not.
            logo = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.
                    iOSClassChain("**/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther" +
                            "/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther" +
                            "/XCUIElementTypeOther[2]/XCUIElementTypeOther[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther" +
                            "/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeImage")));
            logger.info("Logo is visible " + logo.isDisplayed());

            //4.pagination is present in the screen
            pagination = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.
                    accessibilityId("3 of 5")));
            logger.info("Pagination is present " + pagination.isDisplayed());
        } catch (Exception e) {
            logger.warning("Label and default is not visible in page-3.");
        }

        try {
            //5.clicking the continue button.
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.
                    iOSClassChain("**/XCUIElementTypeStaticText[`name == \"Continue\"`]"))).click();
        } catch (Exception e) {
            logger.warning("1st time user Verification is not working in basic detail page-3.");
        }

    }

    @Test(retryAnalyzer = RetryAnalyzerios.class, enabled = true, groups = {"FirstTime login page"})
    public void TC_007() throws Exception {
        TC_006(); //To complete the previous steps.

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement Weight_label, Default_Weight, logo, pagination = null;
        try {
            Weight_label = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.accessibilityId("Select Weight")));
            logger.info("User currently in " + Weight_label.getText() + "page.");

            Default_Weight = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.accessibilityId("20 kg")));
            logger.info("Default height " + Default_Weight.getText() + " is Selected.");

            //Verify the logo
            logo = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.className("XCUIElementTypeCollectionView")));
            logger.info("Selected gender logo is present " + logo.isDisplayed());

            //Pagination verification
            pagination = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.accessibilityId("4 of 5")));
            logger.info("Pagination is present " + pagination.isDisplayed());
        } catch (Exception e) {
            logger.warning("Weight and default weight is not selected in page-4.");
        }

        try {
            //Clicking the continue button
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.
                    iOSClassChain("**/XCUIElementTypeStaticText[`name == \"Continue\"`]"))).click();
        } catch (Exception e) {
            logger.warning("1st time user Verification is not working in basic detail page-4.");

        }
    }

    @Test(retryAnalyzer = RetryAnalyzerios.class, enabled = true, groups = {"FirstTime login page"})
    public void TC_008() throws Exception {

        TC_007(); //To complete the previous steps.

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        WebElement BirthYear_label, pagination = null;
        try {
            BirthYear_label = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.accessibilityId("Select Birth Year")));
            logger.info("User currently in " + BirthYear_label.getText() + "page.");

            //pagination.
            pagination = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.accessibilityId("5 of 5")));
            logger.info("pagination is present : " + pagination.isDisplayed());
        } catch (Exception e) {
            logger.warning("Birth year and pagination is not visible in page-5.");
        }

        try {
            //submit
            WebElement submit = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.
                    iOSClassChain("**/XCUIElementTypeStaticText[`name == \"Submit\"`]")));
            logger.info("Submit button is present : " + submit.isDisplayed());
            submit.click();
        } catch (Exception e) {
            logger.warning("1st time user Verification is not working in basic detail page-4.");
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
            logger.info("Yes button for alcohol is visible.");

            //Alcohol No button
            wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.
                    iOSClassChain("**/XCUIElementTypeStaticText[`name == \"No\"`][1]")));
            logger.info("No button for alcohol is visible.");

            //Alcohol Occasionally button
            wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.
                    iOSClassChain("**/XCUIElementTypeStaticText[`name == \"Occasionally\"`][1]"))).click();
            logger.info("Occasionally button for alcohol is visible.");

            //Smoke Yes button
            wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.
                    iOSClassChain("**/XCUIElementTypeButton[`name == \"Yes\"`][2]")));
            logger.info("Yes button for smoke is visible.");

            //Smoke NO button
            wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.
                    iOSClassChain("**/XCUIElementTypeStaticText[`name == \"No\"`][2]")));
            logger.info("NO button for smoke is visible.");

            //Smoke Occasionally button
            wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.
                    iOSClassChain("**/XCUIElementTypeStaticText[`name == \"Occasionally\"`][2]"))).click();
            logger.info("Occasionally button for smoke is visible.");

            //Submit button
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.
                    iOSClassChain("**/XCUIElementTypeStaticText[`name == \"Submit\"`]"))).click();

        } catch (Exception e) {
            logger.warning("None of the option is selected on this page.");
        }

        try
        {
            wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.
                    iOSClassChain("**/XCUIElementTypeStaticText[`name == \"Skip\"`]"))).click();
        }
        catch (Exception e)
        {
            logger.warning("There is not skip button.");
        }
    }
}
