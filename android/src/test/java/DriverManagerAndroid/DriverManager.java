package DriverManagerAndroid;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.*;
import org.yaml.snakeyaml.Yaml;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.logging.Logger;


public class DriverManager {

    public static Logger logger = Logger.getLogger("MyLog");
    private static final ThreadLocal<AppiumDriver> appiumDriverThreadLocal = new ThreadLocal<>();

    protected static AppiumDriver getDriver() {
        logger.info("getDriver()" + appiumDriverThreadLocal.get());
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

            // Read secrets from environment variables for local and browser stack.
            String currentEnv = System.getenv("ENVIRONMENT");
            if (Objects.equals(currentEnv, "local")) {
                String AppiumServerUrl = "http://127.0.0.1:4723/";
                System.out.print("Entering into local case for ANDROID\n");
                DesiredCapabilities caps = new DesiredCapabilities();
                caps.setCapability("platformName", "Android");
                caps.setCapability("deviceName", "sdk_gphone64_arm64"); // Change to your device/emulator name
                caps.setCapability("udid", "emulator-5554");
                caps.setCapability("platformVersion", "16"); // Change based on your device
                caps.setCapability("automationName", "UiAutomator2");
                caps.setCapability("appPackage", "com.heartmonitor.android"); // Change to your app package
                caps.setCapability("appActivity", "com.heartmonitor.android.presentation.splash.SplashActivity"); // Change to main activity
                caps.setCapability("fullReset", true);
                caps.setCapability("noReset", false); // Keeps app data after test execution
                caps.setCapability("appium:app", "/Users/San/Downloads/apps/Monitor-Staging-170325.apk");
                URL url = new URL(AppiumServerUrl);

                AndroidDriver newDriver = new AndroidDriver(url, caps);
                setDriverForAndroid(newDriver);
            } else {
                System.out.print("Entering into BROWSER_STACK case for ANDROID\n");
                String userName = System.getenv("USER_NAME");
                String accessKey = System.getenv("ACCESS_KEY");
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
                browserstackOptions.put("platformName", platformName);
                browserstackOptions.put("deviceName", deviceName);
                browserstackOptions.put("projectName", projectName);
                browserstackOptions.put("buildName", buildName);
                browserstackOptions.put("sessionName", testName);
                browserstackOptions.put("appiumVersion", "2.0.0");
                browserstackOptions.put("local", "false");
                browserstackOptions.put("debug", "true");

                capabilities.setCapability("bstack:options", browserstackOptions);

                AndroidDriver newDriver = new AndroidDriver(new URL("https://USERNAME:ACCESS_KEY@hub-cloud.browserstack.com/wd/hub"), capabilities);
                setDriverForAndroid(newDriver);
                inputStream.close();
            }
            logger.info("Driver initialized successfully: " + getDriver());
        } catch (Exception e) {
            logger.severe("Error initializing driver: " + e.getMessage());
            e.printStackTrace();
            throw e;
        }
    }

    @AfterMethod(alwaysRun = true)
    public void quitDriver() throws IOException {
        System.out.println("🛑 Executing @AfterMethod: Quitting Android Driver... " + getDriver());
        AppiumDriver currentDriver = getDriver();
        System.out.println("🔚 This has come to an end " + currentDriver);

        if (currentDriver != null) {
            try {
                currentDriver.quit();
                System.out.println("✅ Driver quit successfully.");
            } catch (Exception e) {
                System.out.println("❌ Error while quitting driver: " + e.getMessage());
                e.printStackTrace();
            } finally {
                appiumDriverThreadLocal.remove();
                System.out.println("🧹 ThreadLocal driver removed.");
                // Reset the static driver reference
                driver = null;
            }
        } else {
            System.out.println("⚠️ No active driver found to quit.");
        }

        // Ensure app is force-stopped after quitting driver
        try {
            Runtime.getRuntime().exec("adb shell am force-stop com.heartmonitor.android");
            System.out.println("✅ Force-stopped app successfully.");
        } catch (Exception e) {
            System.out.println("❌ Error force-stopping app: " + e.getMessage());
        }
    }
}