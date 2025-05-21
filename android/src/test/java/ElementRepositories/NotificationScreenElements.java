package ElementRepositories;

import Actions.Activity;
import Actions.ElementTask;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;

public class NotificationScreenElements {

    /*Notification Label*/
    public static final By NOTIFICATION_LABEL = AppiumBy.androidUIAutomator("new UiSelector().text(\"Notifications\")");
    public static final ElementTask NOTIFICATION_LABEL_TASK =
            new ElementTask.Builder(Activity.VERIFY, "Notification label").build();

    /*Notification clear button*/
    public static final By NOTIFICATION_CLEAR_BUTTON = AppiumBy.accessibilityId("clear");
    public static final ElementTask NOTIFICATION_CLEAR_BUTTON_TASK =
            new ElementTask.Builder(Activity.CLICK, "Notification clear").build();

    /*Actual Notification*/
    public static final By ACTUAL_NOTIFICATION = AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.heartmonitor.android:id/llMain\").instance(0)");
    public static final ElementTask ACTUAL_NOTIFICATION_TASK =
            new ElementTask.Builder(Activity.VERIFY, "Actual Notification").build();
}
