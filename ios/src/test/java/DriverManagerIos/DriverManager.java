package DriverManagerIos;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.yaml.snakeyaml.Yaml;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.Objects;
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

            // Read secrets from environment variables for local and browser stack.
            String currentEnv = System.getenv("ENVIRONMENT");
            if (Objects.equals(currentEnv, "local")) {
                String AppiumServerUrl = "http://127.0.0.1:4723";
                System.out.print("Entering into local case for iOS\n");

                DesiredCapabilities caps = new DesiredCapabilities();
                caps.setCapability("platformName", "iOS");
                caps.setCapability("deviceName", "iPhone 16 Pro Max"); // Change based on your simulator/device
                caps.setCapability("udid", "A9242CE4-9A84-44FD-882A-FC68675675AA");
                caps.setCapability("platformVersion", "18.3"); // Change based on your device
                caps.setCapability("automationName", "XCUITest");
                caps.setCapability("bundleId", "com.ios.MoAI"); // Change to your app's bundle ID
                caps.setCapability("noReset", true); // Keeps app data after test execution
                caps.setCapability("appium:app", "/Users/San/Downloads/Apps/Monitor.app"); // Local app path

                URL url = new URL(AppiumServerUrl);
                setDriverForIOS(driver = new IOSDriver(url, caps));

            } else {
                System.out.print("Entering into BROWSER_STACK case for iOS\n");

                String userName = System.getenv("USER_NAME");
                String accessKey = System.getenv("ACCESS_KEY");
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
                setDriverForIOS(driver = new IOSDriver(new URL("https://USERNAME:ACCESS_KEY@hub-cloud.browserstack.com/wd/hub"), capabilities));
            }
            inputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to initialize iOS driver.", e);
        }
    }

    @AfterMethod(alwaysRun = true)
    public void quitDriver() {
        AppiumDriver currentDriver = getDriver();
        System.out.println("🧪 [AfterMethod] Starting driver cleanup...");

        if (currentDriver != null) {
            try {
                System.out.println("📌 Driver class: " + currentDriver.getClass().getName());

                if (currentDriver instanceof IOSDriver) {
                    IOSDriver iosDriver = (IOSDriver) currentDriver;
                    String bundleId = "com.ios.MoAI";

                    System.out.println("📱 iOSDriver detected. Starting app termination...");

                    try {
                        // Attempt to terminate the app
                        boolean terminated = iosDriver.terminateApp(bundleId);
                        System.out.println("🛑 App terminated: " + terminated);
                    } catch (Exception e) {
                        System.out.println("⚠️ Failed to terminate app: " + e.getMessage());
                    }

                    try {
                        // Wait a second before uninstall
                        Thread.sleep(1000);
                        boolean removed = iosDriver.removeApp(bundleId);
                        System.out.println("🧹 App uninstalled: " + removed);
                    } catch (Exception e) {
                        System.out.println("⚠️ Failed to uninstall app: " + e.getMessage());
                    }

                } else {
                    System.out.println("🤖 Not an iOS driver. No iOS-specific cleanup.");
                }

                try {
                    currentDriver.quit();
                    System.out.println("✅ Driver quit successfully.");
                } catch (Exception e) {
                    System.out.println("❌ Error while quitting driver: " + e.getMessage());
                }

            } catch (Exception e) {
                System.out.println("❌ Unexpected error during cleanup: " + e.getMessage());
                e.printStackTrace();
            } finally {
                try {
                    appiumDriverThreadLocal.remove();
                    driver = null;
                    System.out.println("🧼 ThreadLocal cleared.");
                } catch (Exception e) {
                    System.out.println("⚠️ Error clearing ThreadLocal: " + e.getMessage());
                }
            }
        } else {
            System.out.println("⚠️ No active driver found.");
        }
    }

}
