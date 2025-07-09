package Devices;

import Actions.Activity;
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

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        bs.CoreLoginForAndroid(false);

        Map<By, ElementTask> elementMap = new LinkedHashMap<>();
        elementMap.put(DEVICE_BUTTON, DEVICE_BUTTON_TASK);
        elementMap.put(DEVICE_COACH_MARK_FINISH_BUTTON, DEVICE_COACH_MARK_FINISH_BUTTON_TASK);
        elementMap.put(DEVICE_KEBAB_MENU, DEVICE_KEBAB_MENU_TASK);
        elementMap.put(DELETE_DEVICE_OPTION, new ElementTask.Builder(Activity.CLICK, "Delete Option").build());
        elementMap.put(MODEL_TEXT, MODEL_TEXT_TASK);
        elementMap.put(MODEL_CLOSE_CANCEL_BUTTON, MODEL_CLOSE_CANCEL_BUTTON_TASK);
        performActions(elementMap, wait);
    }
}
