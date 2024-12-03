package DriverManagerIos;

import UtilitiesForIos.RetryAnalyzerios;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
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

    public static IOSDriver driver;

    public void setDriverForIOS(IOSDriver driver) {
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
    public void initializeDriverForIOS(ITestResult testResult) throws Exception {
        try {
            InputStream inputStream = new FileInputStream("config/browserstack-ios.yml");

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

            // Handle platformVersion as String or Double
            Object platformVersion = platform.get("platformVersion");
            String platformVersionString = platformVersion instanceof Double
                    ? String.valueOf(platformVersion)
                    : (String) platformVersion;

            // Extracting test case name dynamically
            String testName = testResult.getMethod().getMethodName();

            // Setup BrowserStack capabilities
            MutableCapabilities capabilities = new MutableCapabilities();
            capabilities.setCapability("app", app);

            Map<String, Object> browserstackOptions = new java.util.HashMap<>();
            browserstackOptions.put("userName", userName);
            browserstackOptions.put("accessKey", accessKey);
            browserstackOptions.put("osVersion", platformVersionString);
            browserstackOptions.put("deviceName", deviceName);
            browserstackOptions.put("projectName", projectName);
            browserstackOptions.put("buildName", buildName);
            browserstackOptions.put("sessionName", testName);
            browserstackOptions.put("appiumVersion", "2.0.0");
            browserstackOptions.put("local", "false");
            browserstackOptions.put("debug", "true");

            capabilities.setCapability("bstack:options", browserstackOptions);

            setDriverForIOS(driver = new IOSDriver(new URL("https://hub-cloud.browserstack.com/wd/hub"), capabilities));
            logger.info("iOS Driver initialized successfully.");
            inputStream.close();

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to initialize iOS driver.", e);
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

    @Test(retryAnalyzer = RetryAnalyzerios.class)
    public void BaseLoginForIos() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        WebElement AllowNotificationButton_1 = null;
        try {
            AllowNotificationButton_1 =  wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("Allow")));
            AllowNotificationButton_1.click();
            logger.info("before login->Allow button is visible and its clicked Allow");
        }
        catch (Exception e)
        {
            logger.info("Before login-> Notification allow Button is not pop-up to accept allow.");
        }

        //Clicking the Get started button
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.
                    iOSClassChain("**/XCUIElementTypeStaticText[`name == \"Get Started\"`]"))).click();
            logger.info("Get started button is clicked.");
        } catch (Exception e) {
            logger.warning("Get started button is not visible to click");
        }

        //clicking the mobile number input field and send the keys to it.
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy
                    .iOSClassChain("**/XCUIElementTypeTextField[`value == \"9999999999\"`]"))).sendKeys("0000000000");
            logger.info("input passing for mobile number field is working.");
        } catch (Exception e) {
            logger.warning("input for the mobile number field not passed.");
        }

        //Clicking the continue button
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.
                    iOSClassChain("**/XCUIElementTypeButton[`name == \"Continue\"`]"))).click();
            logger.info("Clicking on continue to move further.");
        } catch (Exception e) {
            logger.warning("Clicking on continue is not working.");
        }

        WebElement Delay_Ok_button = null;
        try
        {
            Delay_Ok_button = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("android:id/button1")));
            Delay_Ok_button.click();
            logger.info(" 30 sec 0r 60 sec delay OK Button is found and its clicked");
        }
        catch (Exception e)
        {
            logger.warning("30 sec 0r 60 sec delay Ok button is not found, we good to go with login");
        }

        //Fill the OTP into input field.
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.
                    xpath("//XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTextField[1]")))
                    .sendKeys("1");
            wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.
                    xpath("//XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTextField[2]")))
                    .sendKeys("2");
            wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.
                    xpath("//XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTextField[3]")))
                    .sendKeys("3");
            wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.
                    xpath("//XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTextField[4]")))
                    .sendKeys("4");
            wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.
                    xpath("//XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTextField[5]")))
                    .sendKeys("5");
            wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.
                    xpath("//XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTextField[6]")))
                    .sendKeys("6");
            logger.info("Otp is entered and we moved further.");
        } catch (Exception e) {
            logger.warning("Entered OTP input is not correct.");
        }

        //Verify the OTP
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.iOSClassChain("**/XCUIElementTypeStaticText[`name == \"Verify OTP\"`]"))).click();
            logger.info("verifying the otp is working.");
        } catch (Exception e) {
            logger.warning("Clicking on verify button is not working.");
        }

        WebElement AllowNotificationButton_2 = null;
        try {
            AllowNotificationButton_2 =  wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("Allow")));
            AllowNotificationButton_2.click();
            logger.info("Allow button is visible and its clicked Allow");
        }
        catch (Exception e)
        {
            logger.info("Notification allow Button is not pop-up to accept allow.");
        }

        //When dependent profile ois not add we need to click the skip button.
        try
        {
            wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.
                    iOSClassChain("**/XCUIElementTypeStaticText[`name == \"Skip\"`]"))).click();
            logger.info("Skip button is clicked to move further.");
        }
        catch (Exception e)
        {
            logger.warning("Skip button is not there might be dependent profile is present.");
        }
    }
}
