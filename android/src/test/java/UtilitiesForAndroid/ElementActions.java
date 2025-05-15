package UtilitiesForAndroid;

import Actions.Activity;
import Actions.ElementTask;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Map;

public class ElementActions {

    public static void performActions(Map<By, ElementTask> elementMap, WebDriverWait wait) {
        for (Map.Entry<By, ElementTask> entry : elementMap.entrySet()) {
            By locator = entry.getKey();
            ElementTask task = entry.getValue();
            Activity action = task.getActivity();
            String description = task.getDescription();

            int attempts = 0;
            boolean success = false;

            while (attempts < 2 && !success) {
                try {
                    WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));

                    switch (action) {
                        case VERIFY:
                            verifyElement(element, wait, description);
                            break;
                        case CLICK:
                            clickElement(element, wait, description);
                            break;
                        case ACCEPT:
                            acceptAlertIfPresent(wait, description);
                            break;
                        case SEND_KEYS:
                            sendKeysToElement(element, wait, description, task.getInputValue());
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
                    break;
                }
            }
        }
    }

    public static void checkForStagingError(WebDriverWait wait) {
        By STAGING_DOWN_POPUP = AppiumBy.id("com.heartmonitor.android:id/txtStagingDown");

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

    private static void verifyElement(WebElement element, WebDriverWait wait, String description) {
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
            if (element.isDisplayed() && element.isEnabled()) {
                LogUtil.info("Verified [" + description + "] | Displayed: true | Text: \"" + element.getText().trim() + "\"");
            }
        } catch (Exception e) {
            LogUtil.warning("❌ Verified [" + description + "] | Displayed: false | Text: \"N/A\"");
        }
    }

    private static void clickElement(WebElement element, WebDriverWait wait, String description) {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(element)).click();
            LogUtil.info("Clicked on [" + description + "] button.");
        } catch (Exception e) {
            LogUtil.warning("❌ Failed to click on [" + description + "] button - " + e.getMessage());
        }
    }

    private static void sendKeysToElement(WebElement element, WebDriverWait wait, String description, String inputValue) {
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
            element.clear();
            element.sendKeys(inputValue);
            LogUtil.info("Input sent to [" + description + "]: \"" + inputValue + "\"");
        } catch (Exception e) {
            LogUtil.warning("❌ Failed to send input to [" + description + "] - " + e.getMessage());
        }
    }

    private static void acceptAlertIfPresent(WebDriverWait wait, String description) {
        try {
            Alert alert = wait.until(ExpectedConditions.alertIsPresent());
            alert.accept();
            LogUtil.info("Alert accepted for [" + description + "].");
        } catch (Exception e) {
            LogUtil.warning("❌ No alert found to accept for [" + description + "] - " + e.getMessage());
        }
    }

}
