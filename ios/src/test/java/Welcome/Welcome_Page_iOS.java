package Welcome;

import DriverManagerIos.DriverManager;
import UtilitiesForIos.LogUtil;
import UtilitiesForIos.RetryAnalyzerios;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.LinkedHashMap;
import java.util.Map;

public class Welcome_Page_iOS extends DriverManager {


    enum Activity {
        VERIFY, CLICK, ACCEPT
    }

    Map<WebElement, Activity> webElements = new LinkedHashMap<>();


    public void init(WebDriverWait wait) {
        LogUtil.info("Called Init");
        try {
            Alert alert = wait.until(ExpectedConditions.alertIsPresent());
            alert.accept();
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        LogUtil.info("Hello world");
        WebElement img = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//XCUIElementTypeImage")));
        WebElement description = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//XCUIElementTypeStaticText[@name=\"Keep track of your own and your family’s health and well-being\"]")));
        WebElement getStarted = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//XCUIElementTypeStaticText[@name=\"Get Started\"]")));
        LogUtil.info("Hello world 2.0 reloaded" +img.isDisplayed());

        webElements.put(img, Activity.VERIFY);
        webElements.put(description, Activity.VERIFY);
        webElements.put(getStarted, Activity.CLICK);

        LogUtil.info("Came here.");
        for (Map.Entry<WebElement, Activity> element : webElements.entrySet()) {
            if (element.getValue() == Activity.VERIFY) {
                try {
                    VerifyElement(element.getKey(), wait);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
            if (element.getValue() == Activity.CLICK) {
                try {
                    ClickElement(element.getKey(), wait);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        }
        LogUtil.info("Came here. too.");
    }

    @Test(retryAnalyzer = RetryAnalyzerios.class)
    public void TC_001() {

        //Global wait.
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        /*To accept the notification pop-up*/
        try {
            Alert alert = wait.until(ExpectedConditions.alertIsPresent());
            alert.accept();
            LogUtil.info("The allow notification is accepted here.");
        } catch (Exception e) {
            LogUtil.warning("There is no Allow button to accept the notification.");
            throw new RuntimeException(e.getMessage());
        }

        //confirm the device image is present in the screen welcome screen.
        try {
            WebElement img = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//XCUIElementTypeImage")));
            LogUtil.info("image is displayed in the welcome screen : " + img.isDisplayed());
        } catch (Exception e) {
            LogUtil.warning("img is not displayed");
        }

        try {
            //Welcome page Description verification.
            WebElement description = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.
                    xpath("//XCUIElementTypeStaticText[@name=\"Keep track of your own and your family’s health and well-being\"]")));
            LogUtil.info("Welcome page description : " + description.getText());
        } catch (Exception e) {
            LogUtil.info("Welcome page description is not displayed");
        }
        WebElement getStarted = null;

        try {
            //Clicking the Get started button
            getStarted = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.
                    xpath("//XCUIElementTypeStaticText[@name=\"Get Started\"]")));
            LogUtil.info("Get started button is present in the welcome page : " + getStarted.isDisplayed());
        } catch (Exception e) {
            LogUtil.warning("Get started button is not displayed");
        }

        wait.until(ExpectedConditions.elementToBeClickable(getStarted)).click();

        try {
            //Verifying the login or signup label present or not.
            WebElement loginOrSignup = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.
                    xpath("//XCUIElementTypeStaticText[@name=\"Login or Sign Up\"]")));
            LogUtil.info("Navigated to login page : " + loginOrSignup);
        } catch (Exception e) {
            LogUtil.warning("Navigated to login page is not displayed");
        }
    }

    public void VerifyElement(WebElement element, WebDriverWait wait) {
        try {
            if (element.isDisplayed()) {
                LogUtil.info("Element is visible");
            } else {
                System.out.println("Element is not visible");
            }
        } catch (Exception e) {
            System.out.println("Error is " + e.getMessage());
        }
    }

    public void ClickElement(WebElement element, WebDriverWait wait) {
        try {
            LogUtil.info("Clicking " + element.getText());
            wait.until(ExpectedConditions.elementToBeClickable(element)).click();
            LogUtil.info("Clicked " + element.getText() + " Successfully!");

        } catch (Exception e) {
            System.out.println("Error is " + e.getMessage());
        }
    }
}