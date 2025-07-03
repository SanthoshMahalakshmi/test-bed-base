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

    /*DashBoard option*/
    public static final By DASHBOARD_BUTTON = AppiumBy.id("com.heartmonitor.android:id/nav_graph_dashboard");
    public static final ElementTask DASHBOARD_BUTTON_TASK =
            new ElementTask.Builder(Activity.CLICK, "DashBoard option").build();

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

    /*Dependent drop down button*/
    public static final By DASHBOARD_DEPENDENT_DROPDOWN = AppiumBy.id("com.heartmonitor.android:id/myDepsDropDown");
    public static final ElementTask DASHBOARD_DEPENDENT_DROPDOWN_TASK =
            new ElementTask.Builder(Activity.CLICK, "dashBoard dependent drop down").build();

    /*Dependent user*/
    public static final By DASHBOARD_DEPENDENT_USER = AppiumBy.id("com.heartmonitor.android:id/depName");
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

    /*DashBoard BP Report label*/
    public static final By DASHBOARD_BP_REPORT_LABEL = AppiumBy.id("com.heartmonitor.android:id/txtBloodPressure");
    public static final ElementTask DASHBOARD_BP_REPORT_LABEL_TASK =
            new ElementTask.Builder(Activity.VERIFY, "DashBoard Bp report label").build();

    /*DashBoard BP Report chart*/
    public static final By DASHBOARD_BP_REPORT_CHART = AppiumBy.id("com.heartmonitor.android:id/bloodPressureChart");
    public static final ElementTask DASHBOARD_BP_REPORT_CHART_TASK =
            new ElementTask.Builder(Activity.VERIFY, "DashBoard Bp report chart").build();

    /*DashBoard BP Report values*/
    public static final By DASHBOARD_BP_REPORT_VALUE = AppiumBy.id("com.heartmonitor.android:id/txtBPValue");
    public static final ElementTask DASHBOARD_BP_REPORT_VALUE_TASK =
            new ElementTask.Builder(Activity.VERIFY, "DashBoard Bp report values").build();

    /*DashBoard HR Report label*/
    public static final By DASHBOARD_HR_REPORT_LABEL = AppiumBy.id("com.heartmonitor.android:id/txtHeartRate");
    public static final ElementTask DASHBOARD_HR_REPORT_LABEL_TASK =
            new ElementTask.Builder(Activity.VERIFY, "DashBoard HR report label").build();

    /*DashBoard HR Report chart*/
    public static final By DASHBOARD_HR_REPORT_CHART = AppiumBy.id("com.heartmonitor.android:id/HeartRateChart");
    public static final ElementTask DASHBOARD_HR_REPORT_CHART_TASK =
            new ElementTask.Builder(Activity.VERIFY, "DashBoard HR report chart").build();

    /*DashBoard HR Report values*/
    public static final By DASHBOARD_HR_REPORT_VALUE = AppiumBy.id("com.heartmonitor.android:id/txtHeartRateValue");
    public static final ElementTask DASHBOARD_HR_REPORT_VALUE_TASK =
            new ElementTask.Builder(Activity.VERIFY, "DashBoard HR report values").build();

    /*DashBoard SPO2 Report label*/
    public static final By DASHBOARD_SPO2_REPORT_LABEL = AppiumBy.id("com.heartmonitor.android:id/txtSpo2");
    public static final ElementTask DASHBOARD_SPO2_REPORT_LABEL_TASK =
            new ElementTask.Builder(Activity.VERIFY, "DashBoard SPO2 report label").build();

    /*DashBoard SPO2 Report chart*/
    public static final By DASHBOARD_SPO2_REPORT_CHART = AppiumBy.id("com.heartmonitor.android:id/spo2Chart");
    public static final ElementTask DASHBOARD_SPO2_REPORT_CHART_TASK =
            new ElementTask.Builder(Activity.VERIFY, "DashBoard SPO2 report chart").build();

    /*DashBoard SPO2 Report values*/
    public static final By DASHBOARD_SPO2_REPORT_VALUE = AppiumBy.id("com.heartmonitor.android:id/txtSpo2Value");
    public static final ElementTask DASHBOARD_SPO2_REPORT_VALUE_TASK =
            new ElementTask.Builder(Activity.VERIFY, "DashBoard SPO2 report values").build();

    /*DashBoard ECG Report label*/
    public static final By DASHBOARD_ECG_REPORT_LABEL = AppiumBy.id("com.heartmonitor.android:id/txtEcg");
    public static final ElementTask DASHBOARD_ECG_REPORT_LABEL_TASK =
            new ElementTask.Builder(Activity.VERIFY, "DashBoard ECG report label").build();

    /*DashBoard ECG Report chart*/
    public static final By DASHBOARD_ECG_REPORT_CHART = AppiumBy.id("com.heartmonitor.android:id/mpSingleLeadECG");
    public static final ElementTask DASHBOARD_ECG_REPORT_CHART_TASK =
            new ElementTask.Builder(Activity.VERIFY, "DashBoard ECG report chart").build();

    /*Primary user profile name in dashboard*/
    public static final By DASHBOARD_PRIMARY_USER_PROFILE_NAME = AppiumBy.id("com.heartmonitor.android:id/txtUserName");
    public static final ElementTask DASHBOARD_PRIMARY_USER_PROFILE_NAME_TASK =
            new ElementTask.Builder(Activity.VERIFY, "primary user profile name on dashboard").build();

}
