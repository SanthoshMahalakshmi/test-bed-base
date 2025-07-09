package UtilitiesForAndroid;

import Actions.Activity;
import Actions.ElementTask;
import DriverManagerAndroid.DriverManager;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
                        case SCROLL_TO_ELEMENT:
                            scrollToMobileElement(locator,wait, description);
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
            } else {
                throw new RuntimeException("❌ [" + description + "] is either not visible or not enabled.");
            }
        } catch (Exception e) {
            LogUtil.warning("❌ Verified [" + description + "] | Displayed: false | Text: \"N/A\"");
            throw new RuntimeException("❌ Element verification failed for [" + description + "]: " + e.getMessage(), e);
        }
    }


    private static void clickElement(WebElement element, WebDriverWait wait, String description) {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(element)).click();
            LogUtil.info("Clicked on [" + description + "] button.");
        } catch (Exception e) {
            LogUtil.warning("❌ Failed to click on [" + description + "] button - " + e.getMessage());
            throw new RuntimeException("❌ Click action failed for [" + description + "]: " + e.getMessage(), e);
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
            throw new RuntimeException("❌ SendKeys action failed for [" + description + "]: " + e.getMessage(), e);
        }
    }

    private static void acceptAlertIfPresent(WebDriverWait wait, String description) {
        try {
            Alert alert = wait.until(ExpectedConditions.alertIsPresent());
            alert.accept();
            LogUtil.info("Alert accepted for [" + description + "].");
        } catch (Exception e) {
            LogUtil.warning("❌ No alert found to accept for [" + description + "] - " + e.getMessage());
            throw new RuntimeException("❌ Accept alert failed for [" + description + "]: " + e.getMessage(), e);
        }
    }

    public static void assertElementsTextEqual(WebDriver driver, By locator1, By locator2, String description1, String description2) {
        String text1 = driver.findElement(locator1).getText().trim();
        String text2 = driver.findElement(locator2).getText().trim();
        LogUtil.info("Comparing text: [" + description1 + "] = \"" + text1 + "\" with [" + description2 + "] = \"" + text2 + "\"");
        org.testng.Assert.assertEquals(
            text1,
            text2,
            "Text mismatch between " + description1 + " and " + description2
        );
    }

    private static void scrollToMobileElement(By locator, WebDriverWait wait, String description) {
        try {
            AndroidDriver driver = (AndroidDriver) DriverManager.getDriver();

            // First attempt direct scroll via UiScrollable if possible
            String scrollableCommand = "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(" +
                    "new UiSelector()." + getLocatorStrategy(locator) + "(\"" + getLocatorValue(locator) + "\"))";

            driver.findElement(AppiumBy.androidUIAutomator(scrollableCommand));

            LogUtil.info("✅ Scrolled to element [" + description + "]");
        } catch (Exception e) {
            LogUtil.warning("❌ Failed to scroll to [" + description + "] - " + e.getMessage());
            throw new RuntimeException("❌ Scroll action failed for [" + description + "]", e);
        }
    }

    private static String getLocatorStrategy(By locator) {
        String locatorStr = locator.toString();
        if (locatorStr.contains("resourceId")) return "resourceId";
        if (locatorStr.contains("text")) return "text";
        if (locatorStr.contains("description") || locatorStr.contains("accessibilityId")) return "description";
        throw new IllegalArgumentException("Unsupported locator strategy: " + locatorStr);
    }

    private static String getLocatorValue(By locator) {
        String locatorStr = locator.toString();
        return locatorStr.substring(locatorStr.indexOf(": ") + 2).replace("\"", "").trim();
    }

}
