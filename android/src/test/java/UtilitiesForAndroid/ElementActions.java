package UtilitiesForAndroid;

import Actions.Activity;
import Actions.ElementTask;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Map;

public class ElementActions {

    public static void performActions(Map<By, ElementTask> elementMap, WebDriverWait wait) {
        for (Map.Entry<By, ElementTask> entry : elementMap.entrySet()) {
            By locator = entry.getKey();
            ElementTask elementTask = entry.getValue();
            Activity action = elementTask.getActivity();
            String description = elementTask.getDescription();

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
                            sendKeysToElement(element, wait, description, elementTask.getInputValue());
                            break;
                    }
                    success = true;
                } catch (StaleElementReferenceException e) {
                    LogUtil.warning("StaleElementReferenceException caught. Retrying...");
                    attempts++;
                } catch (Exception e) {
                    LogUtil.warning("Element action failed: " + e.getMessage());
                    break;
                }
            }
        }
    }

    /**
     * Verifies if the element is visible and enabled.
     */
    public static void verifyElement(WebElement element, WebDriverWait wait, String description) {
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
            if (element.isDisplayed() && element.isEnabled()) {
                LogUtil.info("Verified [" + description + "] | Displayed: " + element.isDisplayed() + " | Text: \"" + element.getText().trim() + "\"");
            }
        } catch (Exception e) {
            LogUtil.warning("❌ Verification failed for [" + description + "] - " + e.getMessage());
        }
    }

    /**
     * Clicks on the element after ensuring it is clickable.
     */
    public static void clickElement(WebElement element, WebDriverWait wait, String description) {
        try {
            if (element.isEnabled() || element.isDisplayed()) {
                wait.until(ExpectedConditions.elementToBeClickable(element)).click();
                LogUtil.info("Clicked on [" + description + "] button.");
            }
        } catch (Exception e) {
            LogUtil.warning("❌ Failed to click on [" + description + "] button - " + e.getMessage());
        }
    }

    /**
     * Accepts an alert if it is present.
     */
    public static void acceptAlertIfPresent(WebDriverWait wait, String description) {
        try {
            Alert alert = wait.until(ExpectedConditions.alertIsPresent());
            alert.accept();
            LogUtil.info("Alert accepted for [" + description + "].");
        } catch (Exception e) {
            LogUtil.warning("❌ No alert found to accept for [" + description + "] - " + e.getMessage());
        }
    }

    /**
     * Sends input text to the element after ensuring it is visible and enabled.
     *
     * @param element     the target WebElement
     * @param wait        WebDriverWait instance
     * @param description custom log message (element's purpose)
     * @param inputValue  the value to send to the element
     */
    public static void sendKeysToElement(WebElement element, WebDriverWait wait, String description, String inputValue) {
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
            if (element.isDisplayed() && element.isEnabled()) {
                element.clear();
                element.sendKeys(inputValue);
                LogUtil.info("Entered value into [" + description + "]: \"" + inputValue + "\"");
            } else {
                LogUtil.warning("Element [" + description + "] is not enabled or visible for input.");
            }
        } catch (Exception e) {
            LogUtil.warning("Failed to send input to [" + description + "]: " + e.getMessage());
        }
    }

}
