package iOSElemenRepositories;

import Actions.iOSActionType;
import Actions.iOSElementTask;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;

public class iOSDeviceScreenElements {

    /*Device screen coach mark skip*/
    public static final By iOS_DEVICE_COACH_MARK_FINISH_BUTTON = AppiumBy.xpath("//XCUIElementTypeStaticText[@name=\"Finish\"]");
    public static final iOSElementTask iOS_DEVICE_COACH_MARK_FINISH_BUTTON_TASK =
            new iOSElementTask.Builder(iOSActionType.CLICK, "Device Coach Mark: Finish").build();

    /*Device screen coach mark skip*/
    public static final By iOS_DEVICE_KEBAB_MENU = AppiumBy.xpath("//XCUIElementTypeCell/XCUIElementTypeButton");
    public static final iOSElementTask iOS_DEVICE_KEBAB_MENU_TASK =
            new iOSElementTask.Builder(iOSActionType.CLICK, "Kebab Menu").build();

    /*Device screen coach mark skip*/
    public static final By iOS_CONNECT_DEVICE_OPTION = AppiumBy.xpath("(//XCUIElementTypeStaticText[@name=\"Connect Device\"])[2]");
    public static final iOSElementTask iOS_CONNECT_DEVICE_OPTION_TASK =
            new iOSElementTask.Builder(iOSActionType.VERIFY, "Connect Device Option").build();

    /*Device screen coach mark skip*/
    public static final By iOS_DELETE_DEVICE_OPTION = AppiumBy.accessibilityId("Delete Device");
    public static final iOSElementTask iOS_DELETE_DEVICE_OPTION_TASK =
            new iOSElementTask.Builder(iOSActionType.VERIFY, "Delete Device Option").build();

    /*Device screen coach mark skip*/
    public static final By iOS_CONNECTED_DEVICE_NAME = AppiumBy.accessibilityId("Heart Monitor");
    public static final iOSElementTask iOS_CONNECTED_DEVICE_NAME_TASK =
            new iOSElementTask.Builder(iOSActionType.VERIFY, "Connected Device name").build();
}
