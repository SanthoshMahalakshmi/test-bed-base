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


}
