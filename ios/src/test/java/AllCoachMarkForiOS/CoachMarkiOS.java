package AllCoachMarkForiOS;

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

public class CoachMarkiOS extends DriverManager {

    private static final Logger log = LoggerFactory.getLogger(CoachMarkiOS.class);

    BaseLoginForiOS bs = new BaseLoginForiOS();

    /*DashBoard Coach mark case*/
    @Test(retryAnalyzer = RetryAnalyzerios.class)
    public void TC_037() throws Exception {
        /*Global wait*/
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        /*Core Login for android.*/
        bs.BaseLoginForIos(false);

        /*1st text element in dashboard.*/
        WebElement firstTextElement;
        try {
            firstTextElement = wait.until(ExpectedConditions.visibilityOfElementLocated
                    (AppiumBy.accessibilityId("For a more comprehensive view of your health, please complete your profile.")));
            logger.info("DashBoard 1st coach mark Text: \n" + firstTextElement.getText());
        } catch (Exception e) {
            logger.warning("There is no coach mark text for first element");
            throw new Exception(e.getMessage());
        }

        /* Clicking the Next button */
        WebElement Next_1;
        try {
            Next_1 = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.iOSClassChain("**/XCUIElementTypeButton[`name == \"Next\"`]")));
            Next_1.click();
            logger.info("Clicking the 'Next' Button for second coach mark text");

        } catch (Exception e) {
            logger.warning("In DashBoard there is no 'Next' Button for coach mark.");
            throw new RuntimeException(e.getMessage());
        }

        /*2nd text element in dashboard*/
        WebElement SecondTextElement;
        try {
            SecondTextElement = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//XCUIElementTypeStaticText[@name=\"Add your dependents who may not be comfortable using smart phones.\n" +
                    "\n" +
                    " Dependents are those users who will be using the same device as you.\"]")));
            logger.info("DashBoard 2nd coach mark Text: \n " + SecondTextElement.getText());
        } catch (Exception e) {
            logger.warning("There is no coach mark text for second element");
            throw new RuntimeException(e.getMessage());
        }

        /* Clicking the Next button */
        WebElement Next_2;
        try {
            Next_2 = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.iOSClassChain("**/XCUIElementTypeButton[`name == \"Next\"`]")));
            Next_2.click();
            logger.info("Clicking the 'Next' Button for third coach mark text");
        } catch (Exception e) {
            logger.warning("In DashBoard there is no 'Next' Button for coach mark.");
            throw new RuntimeException(e.getMessage());
        }

        /*Third Text in the DASHBOARD COACH mark.*/
        WebElement ThirdTextElement;
        try {
            ThirdTextElement = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//XCUIElementTypeStaticText[@name=\"Create care circles to manage all family member's health parameters in one place.\n" +
                    "\n" +
                    " Care circle members are those users who will not be using the same device as you.\"]")));
            logger.info("DashBoard 3rd coach mark Text: \n " + ThirdTextElement.getText());
        } catch (Exception e) {
            logger.warning("There is no coach mark text for third element");
            throw new Exception(e.getMessage());
        }

        /* Clicking the Next button */
        WebElement Next_3;
        try {
            Next_3 = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.iOSClassChain("**/XCUIElementTypeStaticText[`name == \"Next\"`]")));
            Next_3.click();
            logger.info("Clicking the 'Next' Button for fourth coach mark text");

        } catch (Exception e) {
            logger.warning("In DashBoard there is no 'Next' Button for coach mark.");
            throw new RuntimeException(e.getMessage());
        }

        /*Fourth Text in the DASHBOARD COACH mark.*/
        WebElement FourthTextElement;
        try {
            FourthTextElement = wait.until(ExpectedConditions.visibilityOfElementLocated
                    (AppiumBy.xpath("//XCUIElementTypeStaticText[@name=\"Click here to connect your device.\n" +
                            "\n" +
                            "Ensure your device is powered on and within range of your smartphone.\"]")));
            logger.info("DashBoard fourth coach mark Text: \n " + FourthTextElement.getText());
        } catch (Exception e) {
            logger.warning("There is no coach mark text for fourth element");
            throw new Exception(e.getMessage());
        }

        /* Clicking the Finish button */
        WebElement FinishBtn;
        try {
            FinishBtn = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//XCUIElementTypeStaticText[@name=\"Finish\"]")));
            FinishBtn.click();
            logger.info("Clicking the 'Finish' Button for the coach mark complete in dashboard.");
        } catch (Exception e) {
            logger.warning("In DashBoard there is no 'Finish' Button for coach mark.");
            throw new RuntimeException(e.getMessage());
        }
    }


    @Test(retryAnalyzer = RetryAnalyzerios.class)
    public void TC_038() throws Exception {

        /*Global wait*/
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        /*Core Login for android.*/
        bs.BaseLoginForIos(true);

        /*Report page click for the coach mark check.*/
        WebElement ReportPage = null;
        try {
            ReportPage = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("ic_report")));
            ReportPage.click();
            logger.info("Report page click is happening for the coach mark check.");
        } catch (Exception e) {
            logger.warning("There is no report page click is happening.");
            throw new RuntimeException(e.getMessage());
        }

        /*Coach mark text.*/
        WebElement CoachMarkText = null;
        try {
            CoachMarkText = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("Click here to download the report for the selected parameter.")));
            logger.info("Report coach mark Text: \n " + CoachMarkText.getText());
        } catch (Exception e) {
            logger.warning("There is no coach mark text in the report section.");
            throw new RuntimeException(e.getMessage());
        }

        /*Finish button click*/
        WebElement FinishButton = null;
        try {
            FinishButton = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.iOSClassChain("**/XCUIElementTypeStaticText[`name == \"Finish\"`]")));
            FinishButton.click();
            logger.info("Finish button click is happening in the report section.");
        } catch (Exception e) {
            logger.warning("There is no finish button in the report section and click is not happening.");
            throw new RuntimeException(e.getMessage());
        }
    }


    @Test(retryAnalyzer = RetryAnalyzerios.class)
    public void TC_039() throws Exception {

        logger.info("Enter into TC_039");

        /*Global wait*/
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        /*Core Login for android.*/
        bs.BaseLoginForIos(true);

        /*Device button click*/
        WebElement DeviceButton = null;
        try {
            DeviceButton = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("ic_device")));
            DeviceButton.click();
            logger.info("Device section click is happening now.");

        } catch (Exception e) {
            logger.warning("There is no 'Device' button.");
            throw new RuntimeException(e.getMessage());
        }

        WebElement DeviceCoachMarkText = null;
        try {
            DeviceCoachMarkText = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("Select to Proceed.")));
            logger.info("Device page Coach mark text: \n" + DeviceCoachMarkText.getText());
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }

        WebElement Finish = null;
        try {
            Finish = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.iOSClassChain("**/XCUIElementTypeStaticText[`name == \"Finish\"`]")));
            Finish.click();
            logger.info("Clicking the Finish button for the coach mark in the device section");

        } catch (Exception e) {
            logger.warning("There is no 'Finish' Button in the device section.");
            throw new RuntimeException(e.getMessage());
        }
    }


    @Test(retryAnalyzer = RetryAnalyzerios.class)
    public void TC_040() throws Exception {

        /*Description: Profile page coach mark automation coverage */
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        bs.BaseLoginForIos(true);

        WebElement ProfilePageButton;
        try {
            ProfilePageButton = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("ic_profile")));
            ProfilePageButton.click();
            logger.info("Clicking the 'Profile' page.");
        } catch (Exception e) {
            logger.warning("There is no Profile button clicking is not happening now. ");
            throw new RuntimeException(e.getMessage());
        }

        WebElement ParameterRangeText_1;
        try {
            ParameterRangeText_1 = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("We’ve provided commonly accepted range.")));
            logger.info("Profile page coach mark text: \n " + ParameterRangeText_1.getText());
        } catch (Exception e) {
            logger.warning("There is no 1st coach mark text in the profile page");
            throw new RuntimeException(e.getMessage());
        }

        WebElement Skip;
        try {
            Skip = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.iOSClassChain("**/XCUIElementTypeStaticText[`name == \"Skip\"`]")));
            logger.info("Skip button is available or not? : " + Skip.isDisplayed());
        } catch (Exception e) {
            logger.warning("There is no skip button is available now in the profile section.");
            throw new RuntimeException(e.getMessage());
        }

        WebElement NextButton;
        try {
            NextButton = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.iOSClassChain("**/XCUIElementTypeStaticText[`name == \"Next\"`]")));
            NextButton.click();
            logger.info("Clicking the 'Next' button in the profile page now.");

        } catch (Exception e) {
            logger.warning("There is no 'Next' button in the profile page.");
            throw new RuntimeException(e.getMessage());
        }

        WebElement ParameterRangeText_2;
        try {
            ParameterRangeText_2 = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("Customize if informed by physician.")));
            logger.info("Profile page coach mark text: \n " + ParameterRangeText_2.getText());
        } catch (Exception e) {
            logger.warning("There is no 1st coach mark text in the profile page");
            throw new RuntimeException(e.getMessage());
        }

        WebElement FinishButton;
        try {
            FinishButton = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.iOSClassChain("**/XCUIElementTypeStaticText[`name == \"Finish\"`]")));
            FinishButton.click();
            logger.info("Clicking the 'Finish' button in the profile page now.");

        } catch (Exception e) {
            logger.warning("There is no 'Finish' button in the profile page.");
            throw new RuntimeException(e.getMessage());
        }

    }
}
