package DriverManagerAndroid;

import UtilitiesForAndroid.RetryAnalyzer;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.yaml.snakeyaml.Yaml;

import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URL;
import java.time.Duration;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.logging.Logger;


public class DriverManager {

    public static Logger logger = Logger.getLogger("MyLog");
    private static final ThreadLocal<AppiumDriver> appiumDriverThreadLocal = new ThreadLocal<>();

    protected static AppiumDriver getDriver() {
        return appiumDriverThreadLocal.get();
    }

    public static AndroidDriver driver;

    public void setDriverForAndroid(AndroidDriver driver) {
        appiumDriverThreadLocal.set(driver); // Set the ThreadLocal variable
        DriverManager.driver = driver; // Assign to the static driver variable
    }

    @BeforeMethod
    public void initializeDriverForAndroid(ITestResult testResult) throws Exception {
        try {
            InputStream inputStream = new FileInputStream("config/browserstack-android.yml");

            if (inputStream == null) {
                throw new IllegalArgumentException("YAML file not found in resources.");
            }

            // Parse YAML content
            Yaml yaml = new Yaml();
            Map<String, Object> config = yaml.load(inputStream);

            // Extract details from the YAML
            /*String userName = (String) config.get("userName");
            String accessKey = (String) config.get("accessKey");
            String app = (String) config.get("app");*/


            // Read secrets from environment variables for local and browser stack.
            String currentEnv = System.getenv("ENVIRONMENT");
            if (Objects.equals(currentEnv, "local")) {
                String AppiumServerUrl = "http://127.0.0.1:4723/";
                System.out.print("Entering into local case for ANDROID\n");
                DesiredCapabilities caps = new DesiredCapabilities();
                caps.setCapability("platformName", "Android");
                caps.setCapability("deviceName", "sdk_gphone64_x86_64"); // Change to your device/emulator name
                caps.setCapability("udid", "emulator-5554");
                caps.setCapability("platformVersion", "15"); // Change based on your device
                caps.setCapability("automationName", "UiAutomator2");
                caps.setCapability("appPackage", "com.heartmonitor.android"); // Change to your app package
                caps.setCapability("appActivity", "com.heartmonitor.android.presentation.main.MainActivity"); // Change to main activity
                caps.setCapability("noReset", true); // Keeps app data after test execution
                caps.setCapability("appium:app", "/Users/codingmart/Downloads/Monitor v1.0.1 (4) - Staging.apk");
                URL url = new URL(AppiumServerUrl);

                setDriverForAndroid(driver = new AndroidDriver(url, caps));
            } else {
                System.out.print("Entering into BROWSER_STACK case for ANDROID\n");
                String userName = System.getenv("USER_NAME");
                String accessKey = System.getenv("ACCESS_KEY");
                //String app = System.getenv("APP");
                String app = (String) config.get("app");

                // Extract details from the YAML
                String buildName = (String) config.get("buildName");
                String projectName = (String) config.get("projectName");

                // Get platform-specific capabilities
                List<Map<String, Object>> platforms = (List<Map<String, Object>>) config.get("platforms");
                Map<String, Object> platform = platforms.get(0);
                String platformName = (String) platform.get("platformName");
                String deviceName = (String) platform.get("deviceName");
                Double platformVersion = (Double) platform.get("platformVersion");

                // Extracting test case name dynamically
                String testName = testResult.getMethod().getMethodName();

                // Setup BrowserStack capabilities
                MutableCapabilities capabilities = new MutableCapabilities();
                capabilities.setCapability("app", app);

                Map<String, Object> browserstackOptions = new java.util.HashMap<>();
                browserstackOptions.put("userName", userName);
                browserstackOptions.put("accessKey", accessKey);
                browserstackOptions.put("osVersion", platformVersion);
                browserstackOptions.put("deviceName", deviceName);
                browserstackOptions.put("projectName", projectName);
                browserstackOptions.put("buildName", buildName);
                browserstackOptions.put("sessionName", testName);
                browserstackOptions.put("appiumVersion", "2.0.0");
                browserstackOptions.put("local", "false");
                browserstackOptions.put("debug", "true");

                capabilities.setCapability("bstack:options", browserstackOptions);

                setDriverForAndroid(driver = new AndroidDriver(new URL("https://hub-cloud.browserstack.com/wd/hub"), capabilities));
                inputStream.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @AfterMethod
    public void quitDriver() {
        AppiumDriver driver = getDriver();
        if (driver != null) {
            driver.quit();
            appiumDriverThreadLocal.remove();
            logger.info("Driver quit successfully.");
        }
    }

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void BaseLogin() throws Exception {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        logger.info("Entering into BaseLogin for Android.");

        //Clicking the Get started button
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.heartmonitor.android:id/txtGetStart"))).click();
            logger.info("Get started Button is clicked.");
        } catch (NoSuchElementException e) {
            throw new NoSuchElementException(e.getMessage());
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }

        try {
            //clicking the mobile number input field and send the keys to it.
            wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.heartmonitor.android:id/edtMobileNumber"))).sendKeys("9087631080");
            logger.info("Mobile number is added in the field.");
            //Clicking the continue button
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.heartmonitor.android:id/txtContinue"))).click();
            logger.info("Continue button is clicked for login process.");
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }

        WebElement Ok = null;
        try {
            Ok = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("android:id/button1")));
            Ok.click();
            logger.info("*OK Button is found and its clicked");
        } catch (Exception e) {
            logger.warning("Ok button is not found, we good to go with login");
        }

        //Fill the OTP into input field.
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.heartmonitor.android:id/editTextOTP1"))).sendKeys("1");
            wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.heartmonitor.android:id/editTextOTP2"))).sendKeys("2");
            wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.heartmonitor.android:id/editTextOTP3"))).sendKeys("3");
            wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.heartmonitor.android:id/editTextOTP4"))).sendKeys("4");
            wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.heartmonitor.android:id/editTextOTP5"))).sendKeys("5");
            wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.heartmonitor.android:id/editTextOTP6"))).sendKeys("6");
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }

        //Verify the OTP
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.heartmonitor.android:id/txtVerify"))).click();
        } catch (Exception e) {
            logger.warning("Verifying the OTP is not working.");
        }

        WebElement AllowNotificationButton = null;
        try {
            AllowNotificationButton = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.android.permissioncontroller:id/permission_allow_button")));
            AllowNotificationButton.click();
            logger.info("Allow button is visible and its clicked Allow");
        } catch (Exception e) {
            logger.warning("Notification allow Button is not pop-up to accept allow.");
        }

        WebElement CoachMark = null;
        try {
            CoachMark = wait.until(ExpectedConditions.elementToBeClickable(By.id("com.heartmonitor.android:id/tvSkip")));
            CoachMark.click();
            logger.info("Coach mark is visible and its skipped.");
        } catch (NoSuchElementException e) {
            logger.warning("The coach mark Skip is not visible." + e.getMessage());
        } catch (Exception e) {
            logger.warning(e.getMessage());
        }
    }

}
