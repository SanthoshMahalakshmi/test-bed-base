package ElementRepositories;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import Actions.Activity;
import Actions.ElementTask;

public class CommonElements {

    /*Back button.*/
    public static final By BACK_BUTTON = AppiumBy.accessibilityId("Navigate up");
    public static final ElementTask BACK_BUTTON_TASK =
            new ElementTask.Builder(Activity.CLICK, "Back").build();

    /*Continue Button.*/
    public static final By CONTINUE_BUTTON = AppiumBy.id("com.heartmonitor.android:id/txtContinue");
    public static final ElementTask CONTINUE_BUTTON_TASK =
            new ElementTask.Builder(Activity.CLICK, "Continue").build();

    /*Continue Button.*/
    public static final By CONTINUE_BUTTON_2 = AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.heartmonitor.android:id/txtContinue\")");
    public static final ElementTask CONTINUE_BUTTON_2_TASK =
            new ElementTask.Builder(Activity.CLICK, "Continue").build();

    /*Continue Button.*/
    public static final By CONTINUE_BUTTON_3 = AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.heartmonitor.android:id/txtContinue\"]");
    public static final ElementTask CONTINUE_BUTTON_3_TASK =
            new ElementTask.Builder(Activity.CLICK, "Continue").build();

    /*Toast Close*/
    public static final By TOAST_CLOSE = AppiumBy.id("com.heartmonitor.android:id/image_close_toaster");
    public static final ElementTask TOAST_CLOSE_TASK =
            new ElementTask.Builder(Activity.CLICK, "dashBoard Sync toast message close").build();

    /*Done button in set reminder*/
    public static final By DONE_BUTTON = AppiumBy.id("com.heartmonitor.android:id/txtSubmit");
    public static final ElementTask DONE_BUTTON_TASK =
            new ElementTask.Builder(Activity.CLICK, "Done").build();

    /*Model close ok button*/
    public static final By MODEL_CLOSE_OK_BUTTON = AppiumBy.id("android:id/button1");
    public static final ElementTask MODEL_CLOSE_OK_BUTTON_TASK =
            new ElementTask.Builder(Activity.CLICK, "Model Confirm: 'ok'").build();

    /*Model close cancel button*/
    public static final By MODEL_CLOSE_CANCEL_BUTTON = AppiumBy.id("android:id/button2");
    public static final ElementTask MODEL_CLOSE_CANCEL_BUTTON_TASK =
            new ElementTask.Builder(Activity.CLICK, "Model close: 'Cancel'").build();

    /*Report button*/
    public static final By REPORT_BUTTON = AppiumBy.accessibilityId("Reports");
    public static final ElementTask REPORT_BUTTON_TASK =
            new ElementTask.Builder(Activity.CLICK, "Report Option").build();

    /*Reminder Plus button*/
    static String resourceId = "com.heartmonitor.android:id/imgAddReminder";
    static String uiScrollScript = "new UiScrollable(new UiSelector().scrollable(true))" + ".scrollIntoView(new UiSelector().resourceId(\"" + resourceId + "\"))";
    public static final By REMINDER_PLUS_BUTTON = AppiumBy.androidUIAutomator(uiScrollScript);
    public static final ElementTask REMINDER_PLUS_BUTTON_TASK =
            new ElementTask.Builder(Activity.CLICK, "Reminder add").build();

    /*Common model text*/
    public static final By MODEL_TEXT = AppiumBy.id("android:id/message");
    public static final ElementTask MODEL_TEXT_TASK =
            new ElementTask.Builder(Activity.VERIFY, "Model text").build();

    /*Device button*/
    public static final By DEVICE_BUTTON = AppiumBy.accessibilityId("Devices");
    public static final ElementTask DEVICE_BUTTON_TASK =
            new ElementTask.Builder(Activity.CLICK, "Devices option").build();


}
