package AllCoachMarkForiOS;

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

import Actions.iOSElementTask;

import static UtilitiesForIos.iOSElementActions.performIOSActions;
import static iOSElemenRepositories.iOSCommonElements.*;
import static iOSElemenRepositories.iOSCoachMarkScreenElements.*;

import java.time.Duration;
import java.util.LinkedHashMap;
import java.util.Map;

public class CoachMarkiOS extends DriverManager {

    BaseLoginForiOS bs = new BaseLoginForiOS();

    @Test(retryAnalyzer = RetryAnalyzerios.class)
    public void TC036() throws Exception {
        /*Global wait*/
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        /*Core Login for android.*/
        bs.BaseLoginForIos(false);

        Map<By, iOSElementTask> iOSElementMap = new LinkedHashMap<>();

        // Need to be added for DashBoard Coach mark
        performIOSActions(iOSElementMap, wait);
    }


    @Test(retryAnalyzer = RetryAnalyzerios.class)
    public void TC_037() throws Exception {

        /*Global wait*/
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        /*Core Login for android.*/
        bs.BaseLoginForIos(false);

        Map<By, iOSElementTask> iOSElementMap = new LinkedHashMap<>();

        iOSElementMap.put(iOS_REPORT_SECTION, iOS_REPORT_SECTION_TASK);

       iOSElementMap.put(iOS_PROFILE_COACH_MARK_TEXT, iOS_PROFILE_COACH_MARK_TEXT_TASK);

        iOSElementMap.put(iOS_COACH_MARK_FINISH_BUTTON, iOS_COACH_MARK_FINISH_BUTTON_TASK);

        performIOSActions(iOSElementMap, wait);
    }


    @Test(retryAnalyzer = RetryAnalyzerios.class)
    public void TC_038() throws Exception {

        /*Global wait*/
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        /*Core Login for android.*/
        bs.BaseLoginForIos(false);

        Map<By, iOSElementTask> iOSElemenetMap = new LinkedHashMap<>();

        performIOSActions(iOSElemenetMap, wait);
    }


    @Test(retryAnalyzer = RetryAnalyzerios.class)
    public void TC_039() throws Exception {

        /*Description: Profile page coach mark automation coverage */
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        bs.BaseLoginForIos(true);

        WebElement ProfilePageButton;
        try {
            ProfilePageButton = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("ic_profile")));
            ProfilePageButton.click();
            LogUtil.info("Clicking the 'Profile' page.");
        } catch (Exception e) {
            LogUtil.warning("There is no Profile button clicking is not happening now. ");
            throw new RuntimeException(e.getMessage());
        }

        WebElement ParameterRangeText_1;
        try {
            ParameterRangeText_1 = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("We’ve provided commonly accepted range.")));
            LogUtil.info("Profile page coach mark text: \n " + ParameterRangeText_1.getText());
        } catch (Exception e) {
            LogUtil.warning("There is no 1st coach mark text in the profile page");
            throw new RuntimeException(e.getMessage());
        }

        WebElement Skip;
        try {
            Skip = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.iOSClassChain("**/XCUIElementTypeStaticText[`name == \"Skip\"`]")));
            LogUtil.info("Skip button is available or not? : " + Skip.isDisplayed());
        } catch (Exception e) {
            LogUtil.warning("There is no skip button is available now in the profile section.");
            throw new RuntimeException(e.getMessage());
        }

        WebElement NextButton;
        try {
            NextButton = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.iOSClassChain("**/XCUIElementTypeStaticText[`name == \"Next\"`]")));
            NextButton.click();
            LogUtil.info("Clicking the 'Next' button in the profile page now.");

        } catch (Exception e) {
            LogUtil.warning("There is no 'Next' button in the profile page.");
            throw new RuntimeException(e.getMessage());
        }

        WebElement ParameterRangeText_2;
        try {
            ParameterRangeText_2 = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("Customize if informed by physician.")));
            LogUtil.info("Profile page coach mark text: \n " + ParameterRangeText_2.getText());
        } catch (Exception e) {
            LogUtil.warning("There is no 1st coach mark text in the profile page");
            throw new RuntimeException(e.getMessage());
        }

        WebElement FinishButton;
        try {
            FinishButton = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.iOSClassChain("**/XCUIElementTypeStaticText[`name == \"Finish\"`]")));
            FinishButton.click();
            LogUtil.info("Clicking the 'Finish' button in the profile page now.");

        } catch (Exception e) {
            LogUtil.warning("There is no 'Finish' button in the profile page.");
            throw new RuntimeException(e.getMessage());
        }

    }
}
