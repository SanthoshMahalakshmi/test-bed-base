package DriverManagerAndroid;

import UtilitiesForAndroid.RetryAnalyzer;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.yaml.snakeyaml.Yaml;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.net.URL;
import java.time.Duration;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;


public class DriverManager {

    private static PrintStream originalConsole;
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

    @SuppressWarnings("unchecked")
    private Map<String, String> getPlatformDetails(Map<String, Object> config) {
        List<Object> platformsList = (List<Object>) config.get("platforms");
        if (platformsList == null || platformsList.isEmpty()) {
            throw new IllegalArgumentException("No platforms defined in the configuration.");
        }
        return (Map<String, String>) platformsList.get(0);
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
            String userName = (String) config.get("userName");
            String accessKey = (String) config.get("accessKey");
            String app = (String) config.get("app");
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

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

        @AfterMethod
        public void quitDriver () {
            AppiumDriver driver = getDriver();
            if (driver != null) {
                driver.quit();
                appiumDriverThreadLocal.remove();
                logger.info("Driver quit successfully.");
            }
        }

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void BaseLogin() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        //Clicking the Get started button
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.moai.android:id/txtGetStart"))).click();

        //clicking the mobile number input field and send the keys to it.
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id
                ("com.moai.android:id/edtMobileNumber"))).sendKeys("0000000000");

        //Clicking the continue button
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.moai.android:id/txtContinue"))).click();

        WebElement Ok = null;
        try
        {
           Ok = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("android:id/button1")));
           Ok.click();
           logger.info("*OK Button is found and its clicked");
        }
        catch (Exception e)
        {
            logger.warning("Ok button is not found, we good to go with login");
        }

        //Fill the OTP into input field.
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.moai.android:id/editTextOTP1"))).sendKeys("1");
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.moai.android:id/editTextOTP2"))).sendKeys("2");
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.moai.android:id/editTextOTP3"))).sendKeys("3");
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.moai.android:id/editTextOTP4"))).sendKeys("4");
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.moai.android:id/editTextOTP5"))).sendKeys("5");
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.moai.android:id/editTextOTP6"))).sendKeys("6");

        //Verify the OTP
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.moai.android:id/txtVerify"))).click();

        WebElement AllowNotificationButton = null;
        try {
            AllowNotificationButton =  wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.android.permissioncontroller:id/permission_allow_button")));
            AllowNotificationButton.click();
            logger.info("Allow button is visible and its clicked Allow");
        }
        catch (Exception e)
        {
            logger.info("Notification allow Button is not pop-up to accept allow.");
        }
    }

    @Test(enabled = false)
    public void lo()
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        //Clicking the Get started button
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.moai.android:id/txtGetStart"))).click();

        //clicking the mobile number input field and send the keys to it.
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id
                ("com.moai.android:id/edtMobileNumber"))).sendKeys("0000000000");

        //Clicking the continue button
      WebElement cn = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.moai.android:id/txtContinue")));
      logger.info("present " + cn.isDisplayed());
    }
}