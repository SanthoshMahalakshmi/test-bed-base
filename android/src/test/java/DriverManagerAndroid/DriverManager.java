package DriverManagerAndroid;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.MutableCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.yaml.snakeyaml.Yaml;

import java.io.FileInputStream;
import java.io.InputStream;
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
    public void initializeDriverForAndroid() throws Exception {
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
            browserstackOptions.put("sessionName", "Session Name");
            browserstackOptions.put("appiumVersion", "2.0.0");
            browserstackOptions.put("local", "false");
            browserstackOptions.put("debug", "true");

            capabilities.setCapability("bstack:options", browserstackOptions);

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
    }