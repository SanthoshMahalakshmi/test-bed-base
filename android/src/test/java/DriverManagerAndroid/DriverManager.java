package DriverManagerAndroid;

import UtilitiesForAndroid.LogUtil;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class DriverManager {

    private static final ThreadLocal<AppiumDriver> appiumDriverThreadLocal = new ThreadLocal<>();

    protected static AppiumDriver getDriver() {
        LogUtil.info("getDriver()" + appiumDriverThreadLocal.get());
        return appiumDriverThreadLocal.get();
    }

    public static AndroidDriver driver;

    public void setDriverForAndroid(AndroidDriver driver) {
        appiumDriverThreadLocal.set(driver); // Set the ThreadLocal variable
        DriverManager.driver = driver; // Assign to the static driver variable
    }

    @SuppressWarnings("unused")
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

            // Read the environment variable
            String currentEnv = System.getenv("ENVIRONMENT");

            // Set default to 'bs' if not provided
            if (currentEnv == null || currentEnv.isEmpty()) {
                currentEnv = "BrowserStack";
            }

            LogUtil.info("Current ENVIRONMENT: " + currentEnv);

            if (currentEnv.equalsIgnoreCase("local")) {
                String AppiumServerUrl = "http://127.0.0.1:4723";
                LogUtil.info("Entering into LOCAL case for Android\n");

                String testName = testResult.getMethod().getMethodName();
                LogUtil.info("🚀 STARTING TEST: " + testName);

                DesiredCapabilities caps = new DesiredCapabilities();
                caps.setCapability("platformName", "Android");
                caps.setCapability("deviceName", "Pixel 9 Pro");
                caps.setCapability("udid", "emulator-5554");
                caps.setCapability("platformVersion", "16");
                caps.setCapability("automationName", "UiAutomator2");
                caps.setCapability("appPackage", "com.heartmonitor.android");
                caps.setCapability("appActivity", "com.heartmonitor.android.presentation.splash.SplashActivity");
                caps.setCapability("fullReset", true);
                caps.setCapability("noReset", false);
                caps.setCapability("appium:app", "/Users/San/Downloads/Apps/Monitor new API stg.apk");

                URL url = new URL(AppiumServerUrl);
                setDriverForAndroid(new AndroidDriver(url, caps));
            } else {
                LogUtil.info("Entering into BROWSER_STACK case for Android\n");

                String userName = System.getenv("USER_NAME");
                String accessKey = System.getenv("ACCESS_KEY");
                String app = (String) config.get("app");
                String buildName = (String) config.get("buildName");
                String projectName = (String) config.get("projectName");

                List<Map<String, Object>> platforms = (List<Map<String, Object>>) config.get("platforms");
                Map<String, Object> platform = platforms.get(0);
                String platformName = (String) platform.get("platformName");
                String deviceName = (String) platform.get("deviceName");

                Object platformVersion = platform.get("platformVersion");
                String platformVersionString = platformVersion instanceof Double
                        ? String.valueOf(platformVersion)
                        : (String) platformVersion;

                String testName = testResult.getMethod().getMethodName();
                LogUtil.info("🚀 STARTING TEST: " + testName);

                MutableCapabilities capabilities = new MutableCapabilities();
                capabilities.setCapability("app", app);

                Map<String, Object> browserstackOptions = new HashMap<>();
                browserstackOptions.put("userName", userName);
                browserstackOptions.put("accessKey", accessKey);
                browserstackOptions.put("osVersion", platformVersionString);
                browserstackOptions.put("deviceName", deviceName);
                browserstackOptions.put("platformName", platformName);
                browserstackOptions.put("projectName", projectName);
                browserstackOptions.put("buildName", buildName);
                browserstackOptions.put("sessionName", testName);
                browserstackOptions.put("appiumVersion", "2.0.0");
                browserstackOptions.put("local", "false");
                browserstackOptions.put("debug", "true");

                capabilities.setCapability("bstack:options", browserstackOptions);

                String remoteUrl = "https://" + userName + ":" + accessKey + "@hub-cloud.browserstack.com/wd/hub";
                setDriverForAndroid(new AndroidDriver(new URL(remoteUrl), capabilities));
            }
            inputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to initialize Android driver.", e);
        }
    }

    @AfterMethod(alwaysRun = true)
    public void quitDriver(ITestResult testResult) throws IOException {
        String testName = testResult.getMethod().getMethodName();
        LogUtil.info("✅ FINISHED TEST: " + testName);
        LogUtil.info("🛑 Executing @AfterMethod: Quitting Android Driver... ");
        AppiumDriver currentDriver = getDriver();

        // ✅ Mark test status on BrowserStack if running on BrowserStack
        String currentEnv = System.getenv("ENVIRONMENT");
        if (!"local".equalsIgnoreCase(currentEnv) && currentDriver != null) {
            String status = (testResult.getStatus() == ITestResult.SUCCESS) ? "passed" : "failed";
            String reason = testResult.getThrowable() != null ? testResult.getThrowable().getMessage() : "Completed";
            ((JavascriptExecutor) currentDriver).executeScript(
                    "browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\":\""
                            + status + "\", \"reason\": \"" + reason + "\"}}"
            );
        }

        if (currentDriver != null) {
            try {
                currentDriver.quit();
                LogUtil.info("✅ Driver quit successfully.");
            } catch (Exception e) {
                LogUtil.info("❌ Error while quitting driver: " + e.getMessage());
                e.printStackTrace();
            } finally {
                appiumDriverThreadLocal.remove();
                LogUtil.info("🧹 ThreadLocal driver removed.");
                driver = null;
            }
        } else {
            LogUtil.info("⚠️ No active driver found to quit.");
        }

        try {
            Runtime.getRuntime().exec("adb shell am force-stop com.heartmonitor.android");
            LogUtil.info("✅ Force-stopped app successfully.");
        } catch (Exception e) {
            LogUtil.info("❌ Error force-stopping app: " + e.getMessage());
        }
    }

}