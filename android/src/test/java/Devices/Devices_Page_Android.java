package Devices;

import Actions.ElementTask;
import DriverManagerAndroid.BaseLoginForAndroid;
import DriverManagerAndroid.DriverManager;
import UtilitiesForAndroid.LogUtil;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.LinkedHashMap;
import java.util.Map;

import static ElementRepositories.CommonElements.*;
import static ElementRepositories.DeviceScreenElements.*;
import static UtilitiesForAndroid.ElementActions.*;

public class Devices_Page_Android extends DriverManager {
    BaseLoginForAndroid bs = new BaseLoginForAndroid();

    @Test
    public void TC_023() throws Exception {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        bs.CoreLoginForAndroid(false);  //basic login scenario

        Map<By, ElementTask> elementMap = new LinkedHashMap<>();
        elementMap.put(DEVICE_BUTTON, DEVICE_BUTTON_TASK);
        elementMap.put(DEVICE_COACH_MARK_FINISH_BUTTON, DEVICE_COACH_MARK_FINISH_BUTTON_TASK);
        elementMap.put(DEVICE_KEBAB_MENU, DEVICE_KEBAB_MENU_TASK);
        elementMap.put(CONNECT_DEVICE_OPTION, CONNECT_DEVICE_OPTION_TASK);
        elementMap.put(DELETE_DEVICE_OPTION, DELETE_DEVICE_OPTION_TASK);
        performActions(elementMap, wait);
    }

    @Test
    public void TC_024() throws Exception {

        LogUtil.info("Enter into TC_024");

        TC_023(); // to connect with device

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        //Clicking the device section
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("Devices"))).click();
        } catch (Exception e) {
            LogUtil.warning("Device connection is not happening.");
        }

        //Verify the burger menu is clickable.
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.heartmonitor.android:id/imgMenu"))).click();
        } catch (Exception e) {
            LogUtil.warning("Clicking Burger menu is not working.");
        }

        //Disconnect the device
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.
                    androidUIAutomator("new UiSelector().text(\"Disconnect Device\")"))).click();
        } catch (Exception e) {
            LogUtil.warning("Disconnecting device is not happening.");
        }

        //Confirmation of disconnect the device
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("android:id/button1"))).click();
        } catch (Exception e) {
            LogUtil.warning("Confirmation of disconnect is not happening.");
        }

        //Verify the devices is disconnected by clicking burger menu.
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("android:id/message")));
            WebElement message = driver.findElement(AppiumBy.id("android:id/message"));
            LogUtil.info("Disconnected message : " + message.getText());
        } catch (Exception e) {
            LogUtil.warning("Device disconnect verification fail.");
        }

        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("android:id/button1"))).click();
        } catch (Exception e) {
            LogUtil.warning("Ok confirmation is not happening.");
        }
    }
}
