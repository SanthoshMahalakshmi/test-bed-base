package DriverManagerIos;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.MutableCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.PrintStream;
import java.net.URL;
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
    public void initializeDriverForIOS() throws Exception {
        // Load JSON configuration
        String jsonFilePath = "/home/santhosh/RealProjects/MoAI_Mobile_Test_Automation/ios/config/browserstack.json";
        Map<String, Object> config = ConfigLoader.loadConfig(jsonFilePath);

        // Extract platform-specific capabilities
        Map<String, String> platforms = getPlatformDetails(config);

        // Use MutableCapabilities for BrowserStack
        MutableCapabilities capabilities = new MutableCapabilities();

        // Set BrowserStack options
        MutableCapabilities browserStackOptions = new MutableCapabilities();
        browserStackOptions.setCapability("browserstack.user", config.get("browserstack.user"));
        browserStackOptions.setCapability("browserstack.key", config.get("browserstack.key"));
        browserStackOptions.setCapability("appiumVersion", "1.22.0");
        browserStackOptions.setCapability("debug", "true");

        // Set platform-specific capabilities
        browserStackOptions.setCapability("deviceName", platforms.get("deviceName"));
        browserStackOptions.setCapability("platformVersion", platforms.get("platformVersion"));
        browserStackOptions.setCapability("app", config.get("app"));

        // Combine capabilities into a single object
        capabilities.setCapability("bstack:options", browserStackOptions);

        // Additional capabilities if needed
        capabilities.setCapability("buildName", config.get("build"));
        capabilities.setCapability("projectName", config.get("project"));

        // Debugging logs to verify capabilities
        logger.info("Loaded JSON File: " + jsonFilePath);
        logger.info("BrowserStack User: " + config.get("browserstack.user"));
        logger.info("BrowserStack Key: " + config.get("browserstack.key"));
        logger.info("Parsed Platform Details: " + platforms.toString());
        logger.info("Final Capabilities Sent to BrowserStack: " + capabilities.toString());

        // Initialize RemoteWebDriver
        driver = new IOSDriver(new URL("https://hub-cloud.browserstack.com/wd/hub"), capabilities);
        setDriverForIOS(driver); // Set the driver for thread-safe access
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
}