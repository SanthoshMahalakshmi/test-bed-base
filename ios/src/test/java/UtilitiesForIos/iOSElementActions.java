package UtilitiesForIos;

import Actions.iOSActionType;
import Actions.iOSElementTask;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.HashMap;
import java.util.Map;

public class iOSElementActions {

    public static void performIOSActions(Map<By, iOSElementTask> elementMap, WebDriverWait wait) {
        for (Map.Entry<By, iOSElementTask> entry : elementMap.entrySet()) {
            By locator = entry.getKey();
            iOSElementTask task = entry.getValue();
            iOSActionType action = task.getActionType();
            String description = task.getDescription();

            int attempts = 0;
            boolean success = false;

            while (attempts < 2 && !success) {
                try {
                    WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));

                    switch (action) {
                        case VERIFY:
                            verifyIOSElement(element, wait, description);
                            break;
                        case CLICK:
                            clickIOSElement(element, wait, description);
                            break;
                        case ACCEPT:
                            acceptIOSAlertIfPresent(wait, description);
                            break;
                        case SEND_KEYS:
                            sendKeysToIOSElement(element, wait, description, task.getInputValue());
                            break;
                        case SCROLL_AND_CLICK:
                            iOSClickAndScrollToElement(element, locator, wait, description);
                            break;
                        default:
                            throw new UnsupportedOperationException("Unsupported action: " + action);
                    }

                    success = true;

                } catch (StaleElementReferenceException e) {
                    LogUtil.warning("StaleElementReferenceException caught. Retrying...");
                    attempts++;
                } catch (Exception e) {
                    LogUtil.warning("Element action failed for [" + description + "]: " + e.getMessage());
                    throw new RuntimeException("❌ Test failed while performing [" + description + "] - " + e.getMessage(), e);
                }
            }
        }
    }

    public static void checkForIOSStagingError(WebDriverWait wait) {
        By STAGING_DOWN_POPUP = AppiumBy.id("com.heartmonitor.ios:id/txtStagingDown");

        try {
            WebElement errorElement = wait.until(ExpectedConditions.presenceOfElementLocated(STAGING_DOWN_POPUP));
            String errorText = errorElement.getText();

            if (errorText != null && errorText.contains("Unable to resolve host")) {
                System.out.println("❌ Detected staging down message: " + errorText);
                throw new RuntimeException("Staging environment is down. Stopping test execution.");
            }

        } catch (TimeoutException ignored) {
            LogUtil.info("There is no Staging down is happening now at this moment.");
        }
    }

    private static void verifyIOSElement(WebElement element, WebDriverWait wait, String description) {
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
            if (element.isDisplayed() && element.isEnabled()) {
                LogUtil.info("Verified [" + description + "] | Displayed: true | Text: \"" + element.getText().trim() + "\"");
            } else {
                throw new RuntimeException("❌ [" + description + "] is either not visible or not enabled.");
            }
        } catch (Exception e) {
            LogUtil.warning("❌ Verified [" + description + "] | Displayed: false | Text: \"N/A\"");
            throw new RuntimeException("❌ Element verification failed for [" + description + "]: " + e.getMessage(), e);
        }
    }

    private static void clickIOSElement(WebElement element, WebDriverWait wait, String description) {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(element)).click();
            LogUtil.info("Clicked on [" + description + "] button.");
        } catch (Exception e) {
            LogUtil.warning("❌ Failed to click on [" + description + "] button - " + e.getMessage());
            throw new RuntimeException("❌ Click action failed for [" + description + "]: " + e.getMessage(), e);
        }
    }

    private static void sendKeysToIOSElement(WebElement element, WebDriverWait wait, String description, String inputValue) {
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
            element.clear();
            element.sendKeys(inputValue);
            LogUtil.info("Input sent to [" + description + "]: \"" + inputValue + "\"");
        } catch (Exception e) {
            LogUtil.warning("❌ Failed to send input to [" + description + "] - " + e.getMessage());
            throw new RuntimeException("❌ SendKeys action failed for [" + description + "]: " + e.getMessage(), e);
        }
    }

    private static void acceptIOSAlertIfPresent(WebDriverWait wait, String description) {
        try {
            Alert alert = wait.until(ExpectedConditions.alertIsPresent());
            alert.accept();
            LogUtil.info("Alert accepted for [" + description + "].");
        } catch (Exception e) {
            LogUtil.warning("❌ No alert found to accept for [" + description + "] - " + e.getMessage());
            throw new RuntimeException("❌ Accept alert failed for [" + description + "]: " + e.getMessage(), e);
        }
    }

    public static void alertIOS(WebDriverWait wait, String description) {
        try {
            Alert alert = wait.until(ExpectedConditions.alertIsPresent());
            alert.accept();
            LogUtil.info("Alert accepted for [" + description + "].");
        } catch (Exception e) {
            LogUtil.warning("❌ No alert found to accept for [" + description + "] - " + e.getMessage());
            throw new RuntimeException("❌ Accept alert failed for [" + description + "]: " + e.getMessage(), e);
        }
    }

    public static void iOSClickAndScrollToElement(WebElement element, By locator, WebDriverWait wait, String description) {
        try {
            WebDriver driver = ((RemoteWebElement) element).getWrappedDriver();
            HashMap<String, Object> scrollObject = new HashMap<>();
            scrollObject.put("element", ((RemoteWebElement) element).getId());
            scrollObject.put("toVisible", true);
            ((JavascriptExecutor) driver).executeScript("mobile: scroll", scrollObject);

            wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
            LogUtil.info("Scrolled and clicked on [" + description + "] button.");
        } catch (Exception e) {
            LogUtil.warning("❌ Failed to scroll and click on [" + description + "] - " + e.getMessage());
            throw new RuntimeException("❌ Scroll+Click failed for [" + description + "]", e);
        }
    }
}
