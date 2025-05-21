package AllCoachMarkForAndroid;

import DriverManagerAndroid.BaseLoginForAndroid;
import DriverManagerAndroid.DriverManager;
import UtilitiesForAndroid.LogUtil;
import UtilitiesForAndroid.RetryAnalyzer;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import java.time.Duration;

public class CoachMarksAndroid extends DriverManager {

    private static final Logger log = LoggerFactory.getLogger(CoachMarksAndroid.class);
    BaseLoginForAndroid bs = new BaseLoginForAndroid();

    /*DashBoard Coach mark case*/
    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void TC_037() throws Exception {
        /*Global wait*/
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        /*Core Login for android.*/
        bs.CoreLoginForAndroid(false);

        /*1st text element in dashboard.*/
        WebElement firstTextElement;
        try {
            firstTextElement = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.heartmonitor.android:id/tvtest")));
            LogUtil.info("DashBoard 1st coach mark Text: \n" + firstTextElement.getText());
        } catch (Exception e) {
            LogUtil.warning("There is no coach mark text for first element");
            throw new Exception(e.getMessage());
        }

        /* Clicking the Next button */
        WebElement Next_1;
        try {
            Next_1 = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.heartmonitor.android:id/btnNext")));
            Next_1.click();
            LogUtil.info("Clicking the 'Next' Button for second coach mark text");

        } catch (Exception e) {
            LogUtil.warning("In DashBoard there is no 'Next' Button for coach mark.");
            throw new RuntimeException(e.getMessage());
        }

        /*2nd text element in dashboard*/
        WebElement SecondTextElement;
        try {
            SecondTextElement = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.heartmonitor.android:id/tvtest")));
            LogUtil.info("DashBoard 2nd coach mark Text: \n " + SecondTextElement.getText());
        } catch (Exception e) {
            LogUtil.warning("There is no coach mark text for second element");
            throw new RuntimeException(e.getMessage());
        }

        /* Clicking the Next button */
        WebElement Next_2;
        try {
            Next_2 = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.heartmonitor.android:id/btnNext")));
            Next_2.click();
            LogUtil.info("Clicking the 'Next' Button for third coach mark text");

        } catch (Exception e) {
            LogUtil.warning("In DashBoard there is no 'Next' Button for coach mark.");
            throw new RuntimeException(e.getMessage());
        }


        /*Third Text in the DASHBOARD COACH mark.*/
        WebElement ThirdTextElement;
        try {
            ThirdTextElement = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.heartmonitor.android:id/tvtest")));
            LogUtil.info("DashBoard 3rd coach mark Text: \n " + ThirdTextElement.getText());
        } catch (Exception e) {
            LogUtil.warning("There is no coach mark text for third element");
            throw new Exception(e.getMessage());
        }

        /*Clicking 'BACK' button to see the previous coach mark*/
        WebElement BackButton;
        try {
            BackButton = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.heartmonitor.android:id/btnBack")));
            BackButton.click();
            LogUtil.info("Back button click is working, to see the previous coach mark content.");

        } catch (Exception e) {
            LogUtil.warning("There is no back button click is happened.");
            throw new RuntimeException(e.getMessage());
        }

        /* Clicking the Next button */
        WebElement Next_3;
        try {
            Next_3 = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.heartmonitor.android:id/btnNext")));
            Next_3.click();
            LogUtil.info("Clicking the 'Next' Button for fourth coach mark text");

        } catch (Exception e) {
            LogUtil.warning("In DashBoard there is no 'Next' Button for coach mark.");
            throw new RuntimeException(e.getMessage());
        }

        /*Fourth Text in the DASHBOARD COACH mark.*/
        WebElement FourthTextElement;
        try {
            FourthTextElement = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.heartmonitor.android:id/tvtest")));
            LogUtil.info("DashBoard fourth coach mark Text: \n " + FourthTextElement.getText());
        } catch (Exception e) {
            LogUtil.warning("There is no coach mark text for fourth element");
            throw new Exception(e.getMessage());
        }

        /* Clicking the Next button */
        WebElement Next_4;
        try {
            Next_4 = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.heartmonitor.android:id/btnNext")));
            Next_4.click();
            LogUtil.info("Clicking the 'Next' Button for fourth coach mark text");

        } catch (Exception e) {
            LogUtil.warning("In DashBoard there is no 'Next' Button for coach mark.");
            throw new RuntimeException(e.getMessage());
        }

        /*fifth Text in the DASHBOARD COACH mark.*/
        WebElement FifthTextElement;
        try {
            FifthTextElement = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.heartmonitor.android:id/tvtest")));
            LogUtil.info("DashBoard 5th coach mark Text: \n " + FifthTextElement.getText());
        } catch (Exception e) {
            LogUtil.warning("There is no coach mark text for fourth element");
            throw new Exception(e.getMessage());
        }

        /* Clicking the Finish button */
        WebElement Finish;
        try {
            Finish = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.heartmonitor.android:id/btnNext")));
            Finish.click();
            LogUtil.info("Clicking the 'Finish' Button for last coach mark.");
        } catch (Exception e) {
            LogUtil.warning("In DashBoard there is no 'Finish' Button for coach mark.");
            throw new RuntimeException(e.getMessage());
        }
    }

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void TC_038() throws Exception {

        /*Global wait*/
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        /*Core Login for android.*/
        bs.CoreLoginForAndroid(true);

        /*Report page click for the coach mark check.*/
        WebElement ReportPage=null;
        try
        {
            ReportPage = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.androidUIAutomator("new UiSelector().text(\"Reports\")")));
            ReportPage.click();
            LogUtil.info("Report page click is happening for the coach mark check.");

        } catch (Exception e) {
            LogUtil.warning("There is no report page click is happening.");
            throw new RuntimeException(e.getMessage());
        }

        /*Coach mark text.*/
        WebElement CoachMarkText = null;
        try
        {
            CoachMarkText =  wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.heartmonitor.android:id/tvtest")));
            LogUtil.info("Report coach mark Text: \n " + CoachMarkText.getText());
        } catch (Exception e) {
            LogUtil.warning("There is no coach mark text in the report section.");
            throw new RuntimeException(e.getMessage());
        }

        /*Finish button click*/
        WebElement FinishButton = null;
        try
        {
            FinishButton = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.heartmonitor.android:id/btnNext")));
            FinishButton.click();
            LogUtil.info("Finish button click is happening in the report section.");
        } catch (Exception e) {
            LogUtil.warning("There is no finish button in the report section and click is not happening.");
            throw new RuntimeException(e.getMessage());
        }
    }

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void TC_039() throws Exception {

        /*Global wait*/
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        /*Core Login for android.*/
        bs.CoreLoginForAndroid(true);

        /*Device button click*/
        WebElement DeviceButton = null;
        try
        {
            DeviceButton = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.androidUIAutomator("new UiSelector().text(\"Devices\")")));
            DeviceButton.click();
            LogUtil.info("Device section click is happening now.");

        } catch (Exception e) {
            LogUtil.warning("There is no 'Device' button.");
            throw new RuntimeException(e.getMessage());
        }

        WebElement DeviceCoachMarkText = null;
        try
        {
            DeviceCoachMarkText = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.heartmonitor.android:id/tvtest")));
            LogUtil.info("Device page Coach mark text: \n" + DeviceCoachMarkText.getText());
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }

        WebElement Finish = null;
        try
        {
            Finish = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.heartmonitor.android:id/btnNext")));
            Finish.click();
            LogUtil.info("Clicking the Finish button for the coach mark in the device section");

        } catch (Exception e) {
            LogUtil.warning("There is no 'Finish' Button in the device section.");
            throw new RuntimeException(e.getMessage());
        }
    }


    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void TC_040() throws Exception {

        LogUtil.info("Enter into TC_040");

        /*Description: Profile page coach mark automation coverage */
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        bs.CoreLoginForAndroid(true);

        WebElement ProfilePageButton;
        try
        {
            ProfilePageButton = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.androidUIAutomator("new UiSelector().text(\"Profile\")")));
            ProfilePageButton.click();
            LogUtil.info("Clicking the 'Profile' page.");
        } catch (Exception e) {
            LogUtil.warning("There is no Profile button clicking is not happening now. ");
            throw new RuntimeException(e.getMessage());
        }

        WebElement ParameterRangeText_1;
        try
        {
            ParameterRangeText_1 = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.heartmonitor.android:id/tvtest")));
            LogUtil.info("Profile page coach mark text: \n " + ParameterRangeText_1.getText());

        } catch (Exception e) {
            LogUtil.warning("There is no 1st coach mark text in the profile page");
            throw new RuntimeException(e.getMessage());
        }

        WebElement Skip;
        try
        {
            Skip = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.heartmonitor.android:id/tvSkip")));
            LogUtil.info("Skip button is available or not ?" + Skip.isDisplayed());
        } catch (Exception e) {
            LogUtil.warning("There is no skip button is available now in the profile section.");
            throw new RuntimeException(e.getMessage());
        }

        WebElement NextButton;
        try
        {
            NextButton =  wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.heartmonitor.android:id/btnNext")));
            NextButton.click();
            LogUtil.info("Clicking the 'Next' button in the profile page now.");

        } catch (Exception e) {
            LogUtil.warning("There is no 'Next' button in the profile page.");
            throw new RuntimeException(e.getMessage());
        }

        WebElement ParameterRangeText_2;
        try
        {
            ParameterRangeText_2 = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.heartmonitor.android:id/tvtest")));
            LogUtil.info("Profile page coach mark text: \n " + ParameterRangeText_2.getText());
        } catch (Exception e) {
            LogUtil.warning("There is no 1st coach mark text in the profile page");
            throw new RuntimeException(e.getMessage());
        }

        WebElement FinishButton;
        try
        {
            FinishButton =  wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.heartmonitor.android:id/btnNext")));
            FinishButton.click();
            LogUtil.info("Clicking the 'Finish' button in the profile page now.");

        } catch (Exception e) {
            LogUtil.warning("There is no 'Finish' button in the profile page.");
            throw new RuntimeException(e.getMessage());
        }

    }

}
