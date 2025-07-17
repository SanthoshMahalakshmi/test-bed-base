package iOSElemenRepositories;

import Actions.iOSActionType;
import Actions.iOSElementTask;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;

public class iOSCommonElements {

    /*Verify mobile number label*/
    public static final By iOS_KEYBOARD_DONE_BUTTON = AppiumBy.accessibilityId("Done");
    public static final iOSElementTask iOS_KEYBOARD_DONE_BUTTON_TASK =
            new iOSElementTask.Builder(iOSActionType.CLICK, "Key Board Done").build();

    /*Model Close Ok Button*/
    public static final By iOS_MODEL_CLOSE_OK_BUTTON = AppiumBy.accessibilityId("OK");
    public static final iOSElementTask iOS_MODEL_CLOSE_OK_BUTTON_TASK =
            new iOSElementTask.Builder(iOSActionType.CLICK, "Model Confirm: OK").build();

    /*Model Close Cancel Button*/
    public static final By iOS_MODEL_CLOSE_CANCEL_BUTTON = AppiumBy.accessibilityId("Cancel");
    public static final iOSElementTask iOS_MODEL_CLOSE_CANCEL_BUTTON_TASK =
            new iOSElementTask.Builder(iOSActionType.CLICK, "Model Confirm: Cancel").build();

    /*Delete Device alert Model Text*/
    public static final By iOS_DELETE_MODEL_TEXT = AppiumBy.accessibilityId("Are you sure want to delete device?");
    public static final iOSElementTask iOS_DELETE_MODEL_TEXT_TASK =
            new iOSElementTask.Builder(iOSActionType.VERIFY, "Delete Device Model text").build();

    /*Continue Button*/
    public static final By iOS_CONTINUE_BUTTON = AppiumBy.iOSClassChain("**/XCUIElementTypeStaticText[`name == \"Continue\"`]");
    public static final iOSElementTask iOS_CONTINUE_BUTTON_TASK =
            new iOSElementTask.Builder(iOSActionType.CLICK, "Continue").build();

    /*Back Button*/
    public static final By iOS_BACK_BUTTON = AppiumBy.accessibilityId("ic back");
    public static final iOSElementTask iOS_BACK_BUTTON_TASK =
            new iOSElementTask.Builder(iOSActionType.CLICK, "Back").build();

    /*Home Button*/
    public static final By iOS_HOME_BUTTON = AppiumBy.accessibilityId("ic home header");
    public static final iOSElementTask iOS_HOME_BUTTON_TASK =
            new iOSElementTask.Builder(iOSActionType.CLICK, "Home").build();

    /*Actual Report Section*/
    public static final By iOS_REPORT_SECTION = AppiumBy.accessibilityId("ic_report");
    public static final iOSElementTask iOS_REPORT_SECTION_TASK =
            new iOSElementTask.Builder(iOSActionType.CLICK, "Report Section").build();

    /*Device section*/
    public static final By iOS_DEVICE_SECTION = AppiumBy.accessibilityId("ic_device");
    public static final iOSElementTask iOS_iOS_DEVICE_SECTION_TASK =
            new iOSElementTask.Builder(iOSActionType.CLICK, "Device Section").build();
}
