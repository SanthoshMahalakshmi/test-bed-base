package ElementRepositories;

import Actions.Activity;
import Actions.ElementTask;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;

public class DeviceScreenElements {

    /*My Device*/
    public static final By DEVICE_COACH_MARK_FINISH_BUTTON = AppiumBy.id("com.heartmonitor.android:id/btnNext");
    public static final ElementTask DEVICE_COACH_MARK_FINISH_BUTTON_TASK =
            new ElementTask.Builder(Activity.CLICK, "Device Coach mark Finish").build();

    /*Device Kebab menu option*/
    public static final By DEVICE_KEBAB_MENU = AppiumBy.id("com.heartmonitor.android:id/imgMenu");
    public static final ElementTask DEVICE_KEBAB_MENU_TASK =
            new ElementTask.Builder(Activity.CLICK, "Device Kebab menu").build();

    /*Connect Device*/
    public static final By CONNECT_DEVICE_OPTION = AppiumBy.androidUIAutomator("new UiSelector().text(\"Connect Device\")");
    public static final ElementTask CONNECT_DEVICE_OPTION_TASK =
            new ElementTask.Builder(Activity.VERIFY, "Connect Device option").build();

    /*Delete Option*/
    public static final By DELETE_DEVICE_OPTION = AppiumBy.androidUIAutomator("new UiSelector().text(\"Delete Device\")");
    public static final ElementTask DELETE_DEVICE_OPTION_TASK =
            new ElementTask.Builder(Activity.VERIFY, "Delete Device option").build();

    /*Connected Device*/
    public static final By CONNECTED_DEVICE_NAME = AppiumBy.androidUIAutomator("new UiSelector().text(\"Connect Device\")");
    public static final ElementTask CONNECTED_DEVICE_NAME_TASK =
            new ElementTask.Builder(Activity.VERIFY, "Connected device name").build();
}
