package Reports_Page;

import DriverManagerIos.BaseLoginForiOS;
import DriverManagerIos.DriverManager;
import UtilitiesForIos.LogUtil;
import UtilitiesForIos.RetryAnalyzerios;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.NoSuchElementException;

public class DownloadingReports_Page_Ios extends DriverManager
{

    BaseLoginForiOS baseLoginForiOS = new BaseLoginForiOS();

    @Test(retryAnalyzer = RetryAnalyzerios.class)
    public void TC_020() throws Exception {
        baseLoginForiOS.BaseLoginForIos(true);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        //Variable Declaration.
        WebElement
                ReportBtn, DropDownFilterBtn, FinishBtn, DownloadBtn;

        //Clicking on the report section
        try {
            ReportBtn = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("ic_report")));
            ReportBtn.click();
            LogUtil.info("Clicking the 'Report' Section.");
        } catch (Exception e) {
            LogUtil.warning("Clicking the report section is not working.");
            throw new Exception(e.getMessage());
        }

        //Report Section coach mark finish.
        try{
            FinishBtn =  wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.iOSClassChain("**/XCUIElementTypeStaticText[`name == \"Finish\"`]")));
            FinishBtn.click();
            LogUtil.info("Report section coach mark finish button is clicked.");
        } catch (Exception e) {
            LogUtil.warning("There is no coach mark pop's out in the report section.");
        }

        //Drop down filter.
        try {
            DropDownFilterBtn = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.iOSClassChain("**/XCUIElementTypeTextField[`value == \"Day\"`]")));
            LogUtil.info("Drop Down button is displayed? : " + DropDownFilterBtn.isDisplayed());
        } catch (Exception e) {
            LogUtil.warning("There is Drop Down button is visible for the user in the report section.");
            throw new Exception(e.getMessage());
        }

        //Downloading the report.
        try
        {
            DownloadBtn = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("ic donwload")));
            if (DownloadBtn.isEnabled())
            {
                DownloadBtn.click();
                LogUtil.info("Downloading the report.");
            }
        }catch (Exception e)
        {
            LogUtil.warning("There is no download button to download the user report.");
            throw new NoSuchElementException(e.getMessage());
        }
    }

    @Test(retryAnalyzer = RetryAnalyzerios.class)
    public void TC_021() throws Exception {
        baseLoginForiOS.BaseLoginForIos(true);

        WebDriverWait wait =  new WebDriverWait(driver, Duration.ofSeconds(10));

        //Variable Declaration.
        WebElement ReportBtn, ECG, DownloadBtn, FinishBtn;

        //Clicking on the report section
        try {
            ReportBtn = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("ic_report")));
            ReportBtn.click();
            LogUtil.info("Clicking the 'Report' Section.");
        } catch (Exception e) {
            LogUtil.warning("Clicking the report section is not working.");
            throw new Exception(e.getMessage());
        }

        //Report Section coach mark finish.
        try{
            FinishBtn =  wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.iOSClassChain("**/XCUIElementTypeStaticText[`name == \"Finish\"`]")));
            FinishBtn.click();
            LogUtil.info("Report section coach mark finish button is clicked.");
        } catch (Exception e) {
            LogUtil.warning("There is no coach mark pop's out in the report section.");
        }

        //Clicking on the ECG report
        try {
            ECG =  wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("ECG")));
            ECG.click();
            LogUtil.info("Clicking the ECG report section.");
        } catch (Exception e) {
            LogUtil.warning("Clicking the ECG report section is not happening.");
            throw new Exception(e.getMessage());
        }

        //Clicking on the download button in ECG report section
        try {
            DownloadBtn = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("ic donwload")));
            if (DownloadBtn.isEnabled())
            {
                DownloadBtn.click();
                LogUtil.info("Clicking the download button in the ECG report section.");
            }
        } catch (Exception e) {
            LogUtil.warning("Clicking the Downloading ECG report is not happening.");
            throw new Exception(e.getMessage());
        }

    }

    @Test(retryAnalyzer = RetryAnalyzerios.class)
    public void TC_022() throws Exception {
       baseLoginForiOS.BaseLoginForIos(true);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        //Clicking on the report section
        try {
            wait.until(ExpectedConditions.elementToBeClickable
                    (AppiumBy.accessibilityId("ic_profile"))).click();
            LogUtil.info("Moving to report section is working.");
        } catch (Exception e) {
            LogUtil.warning("Clicking report section is not happening.");
        }

        //Clicking on the HR report
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("Heart Rate"))).click();
            LogUtil.info("Moving to the HR report section is happening.");
        } catch (Exception e) {
            LogUtil.warning("clicking HR report section is not happening.");
        }

        //Clicking on the download button in hr report section
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("ic donwload"))).click();
            LogUtil.info("Downloading the HR report is happening.");
        } catch (Exception e) {
            LogUtil.warning("Download the HR report is not happening.");
        }
    }
}
