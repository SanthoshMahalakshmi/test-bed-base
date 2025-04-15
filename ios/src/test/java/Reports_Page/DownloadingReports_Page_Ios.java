package Reports_Page;

import DriverManagerIos.BaseLoginForiOS;
import DriverManagerIos.DriverManager;
import UtilitiesForIos.RetryAnalyzerios;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class DownloadingReports_Page_Ios extends DriverManager
{

    BaseLoginForiOS baseLoginForiOS = new BaseLoginForiOS();

    @Test(retryAnalyzer = RetryAnalyzerios.class)
    public void TC_020()
    {
         baseLoginForiOS.BaseLoginForIos();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        //Clicking on the report section
        try {
            wait.until(ExpectedConditions.elementToBeClickable
                    (AppiumBy.accessibilityId("ic_profile"))).click();
            logger.info("clicking the report section is happening.");
        } catch (Exception e) {
            logger.warning("Clicking the report section is not working.");
        }

        //Drop down filter for BP.
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.
                    accessibilityId("ic_down_arrow"))).click();
            logger.info("Drop down filter is working.");
        } catch (Exception e) {
            logger.warning("Down filter is not working.");
        }

        //Selecting the month on this drop down filter.
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.
                    accessibilityId("Month"))).click();
            logger.info("Selecting the month in drop down is happening.");
        } catch (Exception e) {
            logger.warning("Selecting month is not working");
        }


        //Clicking the download button on BP report section
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("ic donwload"))).click();
            logger.info("Downloading the BP report is working.");
        } catch (Exception e) {
            logger.warning("Downloading the BP report is not happening.");
        }

    }

    @Test(retryAnalyzer = RetryAnalyzerios.class)
    public void TC_021()
    {
         baseLoginForiOS.BaseLoginForIos();

        WebDriverWait wait =  new WebDriverWait(driver, Duration.ofSeconds(10));

        //Clicking on the report section
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("ic_report"))).click();
            logger.info("Moving to report section is working.");
        } catch (Exception e) {
            logger.warning("Clicking on report section is not happening.");
        }

        //Clicking on the ECG report
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.
                    accessibilityId("ECG"))).click();
            logger.info("Moving to ECG report section is happening.");
        } catch (Exception e) {
            logger.warning("Ecg Report selection is not happening.");
        }

        //Clicking on the download button in ECG report section
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("ic donwload"))).click();
            logger.info("Downloading the BP report is not happening.");
        } catch (Exception e) {
            logger.warning("Downloading ECG report is not happening.");
        }

    }

    @Test(retryAnalyzer = RetryAnalyzerios.class)
    public void TC_022()
    {
        baseLoginForiOS.BaseLoginForIos();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        //Clicking on the report section
        try {
            wait.until(ExpectedConditions.elementToBeClickable
                    (AppiumBy.accessibilityId("ic_profile"))).click();
            logger.info("Moving to report section is working.");
        } catch (Exception e) {
            logger.warning("Clicking report section is not happening.");
        }

        //Clicking on the HR report
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("Heart Rate"))).click();
            logger.info("Moving to the HR report section is happening.");
        } catch (Exception e) {
            logger.warning("clicking HR report section is not happening.");
        }

        //Clicking on the download button in hr report section
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("ic donwload"))).click();
            logger.info("Downloading the HR report is happening.");
        } catch (Exception e) {
            logger.warning("Download the HR report is not happening.");
        }
    }
}
