package ElementRepositories;

import Actions.Activity;
import Actions.ElementTask;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;

public class DashBoardScreenElements {

    /*DashBoard app logo Element*/
    public static final By DASHBOARD_APP_LOGO = AppiumBy.id("com.heartmonitor.android:id/headerImage");
    public static final ElementTask DASHBOARD_APP_LOGO_TASK =
            new ElementTask.Builder(Activity.VERIFY, "dashBoard App Logo").build();

    /*DashBoard Sync button Element*/
    public static final By DASHBOARD_SYNC_BUTTON = AppiumBy.accessibilityId("Sync data");
    public static final ElementTask DASHBOARD_SYNC_BUTTON_TASK =
            new ElementTask.Builder(Activity.CLICK, "dashBoard Sync").build();

    /*Dashboard sync toast message*/
    public static final By DASHBOARD_SYNC_TOAST = AppiumBy.id("com.heartmonitor.android:id/text_message_toaster");
    public static final ElementTask DASHBOARD_SYNC_TOAST_TASK =
            new ElementTask.Builder(Activity.VERIFY, "dashBoard Sync toast message").build();

    /*Dashboard sync toast message close button*/
    public static final By DASHBOARD_SYNC_TOAST_CLOSE = AppiumBy.id("com.heartmonitor.android:id/image_close_toaster");
    public static final ElementTask DASHBOARD_SYNC_TOAST_CLOSE_TASK =
            new ElementTask.Builder(Activity.CLICK, "dashBoard Sync toast message close").build();

    /*DashBoard Notification button*/
    public static final By DASHBOARD_NOTIFICATION_BUTTON = AppiumBy.accessibilityId("Notification");
    public static final ElementTask DASHBOARD_NOTIFICATION_BUTTON_TASK =
            new ElementTask.Builder(Activity.CLICK, "dashBoard notification").build();

    /*Send Feed Back button*/
    public static final By DASHBOARD_SEND_FEEDBACK_BUTTON = AppiumBy.accessibilityId("Send Feedback");
    public static final ElementTask DASHBOARD_SEND_FEEDBACK_BUTTON_TASK =
            new ElementTask.Builder(Activity.CLICK, "dashBoard send feedback").build();

    /*Dependent Section*/
    public static final By DASHBOARD_DEPENDENT_LABEL = AppiumBy.id("com.heartmonitor.android:id/txtMyDependent");
    public static final ElementTask DASHBOARD_DEPENDENT_LABEL_TASK =
            new ElementTask.Builder(Activity.VERIFY, "dashBoard dependent label").build();

    /*Dependent + button*/
    public static final By DASHBOARD_DEPENDENT_BUTTON = AppiumBy.androidUIAutomator("new UiSelector().text(\"+\")");
    public static final ElementTask DASHBOARD_DEPENDENT_BUTTON_TASK =
            new ElementTask.Builder(Activity.CLICK, "dashBoard dependent + option").build();

    /*Dependent user*/
    public static final By DASHBOARD_DEPENDENT_USER = AppiumBy.androidUIAutomator("new UiSelector().text(\"S\")");
    public static final ElementTask DASHBOARD_DEPENDENT_USER_TASK =
            new ElementTask.Builder(Activity.VERIFY, "dependent user").build();

    /*Care Circle label*/
    public static final By DASHBOARD_CARE_CIRCLE_LABEL = AppiumBy.id("com.heartmonitor.android:id/txtCareCirclesLabel");
    public static final ElementTask DASHBOARD_CARE_CIRCLE_LABEL_TASK =
            new ElementTask.Builder(Activity.VERIFY, "Care circle label").build();

    /*Care Circle get started button*/
    public static final By DASHBOARD_CARE_CIRCLE_GET_STARTED = AppiumBy.id("com.heartmonitor.android:id/txtCareCircle");
    public static final ElementTask DASHBOARD_CARE_CIRCLE_GET_STARTED_TASK =
            new ElementTask.Builder(Activity.CLICK, "Care circle get started").build();

    /*Actual care circle group*/
    public static final By DASHBOARD_CARE_CIRCLE = AppiumBy.id("com.heartmonitor.android:id/imgOtherProfile");
    public static final ElementTask DASHBOARD_CARE_CIRCLE_TASK =
            new ElementTask.Builder(Activity.CLICK, "Actual Care circle").build();


}
