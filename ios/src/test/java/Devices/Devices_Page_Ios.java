package Devices;

import Actions.iOSActionType;
import Actions.iOSElementTask;
import DriverManagerIos.BaseLoginForiOS;
import DriverManagerIos.DriverManager;
import UtilitiesForIos.LogUtil;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.LinkedHashMap;
import java.util.Map;

import static UtilitiesForIos.iOSElementActions.*;
import static iOSElemenRepositories.iOSCommonElements.*;
import static iOSElemenRepositories.iOSDeviceScreenElements.*;

public class Devices_Page_Ios extends DriverManager
{
    BaseLoginForiOS baseLoginForiOS = new BaseLoginForiOS();

    @Test
    public void TC_023() {
         baseLoginForiOS.BaseLoginForIos(true);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        Map<By, iOSElementTask> elementMap = new LinkedHashMap<>();
        elementMap.put(iOS_DEVICE_SECTION, iOS_iOS_DEVICE_SECTION_TASK);
        elementMap.put(iOS_DEVICE_COACH_MARK_FINISH_BUTTON, iOS_DEVICE_COACH_MARK_FINISH_BUTTON_TASK);
        elementMap.put(iOS_DEVICE_KEBAB_MENU, iOS_DEVICE_KEBAB_MENU_TASK);
        elementMap.put(iOS_CONNECT_DEVICE_OPTION, iOS_CONNECT_DEVICE_OPTION_TASK);
        elementMap.put(iOS_DELETE_DEVICE_OPTION, iOS_DELETE_DEVICE_OPTION_TASK);
        performIOSActions(elementMap, wait);
    }

    @Test
    public void TC_024() {

        baseLoginForiOS.BaseLoginForIos(true);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        Map<By, iOSElementTask> elementMap = new LinkedHashMap<>();
        elementMap.put(iOS_DEVICE_SECTION, iOS_iOS_DEVICE_SECTION_TASK);
        elementMap.put(iOS_DEVICE_COACH_MARK_FINISH_BUTTON, iOS_DEVICE_COACH_MARK_FINISH_BUTTON_TASK);
        elementMap.put(iOS_DEVICE_KEBAB_MENU, iOS_DEVICE_KEBAB_MENU_TASK);
        elementMap.put(iOS_DELETE_DEVICE_OPTION, new iOSElementTask.Builder(iOSActionType.CLICK, "Delete Option").build());
        elementMap.put(iOS_DELETE_MODEL_TEXT, iOS_DELETE_MODEL_TEXT_TASK);
        elementMap.put(iOS_MODEL_CLOSE_CANCEL_BUTTON, iOS_MODEL_CLOSE_CANCEL_BUTTON_TASK);
        performIOSActions(elementMap, wait);

    }
}
