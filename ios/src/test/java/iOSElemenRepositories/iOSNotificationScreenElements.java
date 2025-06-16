package iOSElemenRepositories;

import Actions.iOSActionType;
import Actions.iOSElementTask;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;

public class iOSNotificationScreenElements {

    /*Notification Label*/
    public static final By iOS_NOTIFICATION_LABEL = AppiumBy.accessibilityId("Notifications");
    public static final iOSElementTask iOS_NOTIFICATION_LABEL_TASK =
            new iOSElementTask.Builder(iOSActionType.VERIFY, "Notification label").build();

    /*Notification clear button*/
    public static final By iOS_NOTIFICATION_CLEAR_BUTTON = AppiumBy.accessibilityId("ic clearAllNotification");
    public static final iOSElementTask iOS_NOTIFICATION_CLEAR_BUTTON_TASK =
            new iOSElementTask.Builder(iOSActionType.VERIFY, "Notification Clear.").build();

    /*Actual Notification*/
    public static final By iOS_ACTUAL_NOTIFICATION = AppiumBy.xpath("//XCUIElementTypeTable/XCUIElementTypeCell[110]/XCUIElementTypeOther[1]/XCUIElementTypeOther");
    public static final iOSElementTask iOS_ACTUAL_NOTIFICATION_TASK =
            new iOSElementTask.Builder(iOSActionType.VERIFY, "Actual Notification").build();
}
