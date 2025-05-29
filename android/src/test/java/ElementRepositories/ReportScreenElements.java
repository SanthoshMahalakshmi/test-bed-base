package ElementRepositories;

import Actions.Activity;
import Actions.ElementTask;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;

public class ReportScreenElements {

    /*Blood pressure Tab*/
    public static final By BLOOD_PRESSURE_TAB = AppiumBy.androidUIAutomator("new UiSelector().text(\"Blood Pressure\")");
    public static final ElementTask BLOOD_PRESSURE_TAB_TASK =
            new ElementTask.Builder(Activity.CLICK, "Blood pressure tab").build();

    /*Spo2 Tab*/
    public static final By SPO2_TAB = AppiumBy.androidUIAutomator("new UiSelector().text(\"SpO2\")");
    public static final ElementTask SPO2_TAB_TASK =
            new ElementTask.Builder(Activity.CLICK, "Spo2 tab").build();

    /*ECG Tab*/
    public static final By ECG_TAB = AppiumBy.androidUIAutomator("new UiSelector().text(\"ECG\")");
    public static final ElementTask ECG_TAB_TASK =
            new ElementTask.Builder(Activity.CLICK, "ECG tab").build();

    /*heart Rate tab*/
    public static final By HR_TAB = AppiumBy.androidUIAutomator("new UiSelector().text(\"Heart Rate\")");
    public static final ElementTask HR_TAB_TASK =
            new ElementTask.Builder(Activity.CLICK, "Heart Rate tab").build();

    /*Date filter option*/
    public static final By DATE_FILTER_OPTION = AppiumBy.id("com.heartmonitor.android:id/llDate");
    public static final ElementTask DATE_FILTER_OPTION_TASK =
            new ElementTask.Builder(Activity.CLICK, "Date filter").build();

    /*Day filter option*/
    public static final By DAY_DROP_DOWN = AppiumBy.id("com.heartmonitor.android:id/llSpiner");
    public static final ElementTask DAY_DROP_DOWN_TASK =
            new ElementTask.Builder(Activity.CLICK, "Day or month or week.. filter").build();

    /*Week filter option*/
    public static final By WEEK_FILTER_OPTION = AppiumBy.androidUIAutomator("new UiSelector().text(\"Week\")");
    public static final ElementTask WEEK_FILTER_OPTION_TASK =
            new ElementTask.Builder(Activity.CLICK, "week filter").build();

    /*Day filter option*/
    public static final By MONTH_FILTER_OPTION = AppiumBy.id("com.heartmonitor.android:id/llDate");
    public static final ElementTask MONTH_FILTER_OPTION_TASK =
            new ElementTask.Builder(Activity.CLICK, "Month filter").build();

    /*Day filter option*/
    public static final By YEAR_FILTER_OPTION = AppiumBy.id("com.heartmonitor.android:id/llDate");
    public static final ElementTask YEAR_FILTER_OPTION_TASK =
            new ElementTask.Builder(Activity.CLICK, "Year filter").build();

    /*Day filter option*/
    public static final By CUSTOME_FILTER_OPTION = AppiumBy.id("com.heartmonitor.android:id/llDate");
    public static final ElementTask CUSTOME_FILTER_OPTION_TASK =
            new ElementTask.Builder(Activity.CLICK, "Custom filter").build();

    /*Download button*/
    public static final By DOWNLOAD_BUTTON = AppiumBy.id("com.heartmonitor.android:id/imgDownload");
    public static final ElementTask DOWNLOAD_BUTTON_TASK =
            new ElementTask.Builder(Activity.CLICK, "Download button in report section").build();

    /*Share Option*/
    public static final By SHARE_OPTION = AppiumBy.id("com.heartmonitor.android:id/imgShare");
    public static final ElementTask SHARE_OPTION_TASK =
            new ElementTask.Builder(Activity.CLICK, "Share option").build();

    /*Report section Coach mark finish button*/
    public static final By REPORT_COACH_MARK_FINISH_BUTTON = AppiumBy.id("com.heartmonitor.android:id/btnNext");
    public static final ElementTask REPORT_COACH_MARK_FINISH_BUTTON_TASK =
            new ElementTask.Builder(Activity.CLICK, "Coach mark finish").build();

    /*Ecg Download button*/
    public static final By ECG_DOWNLOAD_BUTTON = AppiumBy.id("com.heartmonitor.android:id/ivDownload1");
    public static final ElementTask ECG_DOWNLOAD_BUTTON_TASK =
            new ElementTask.Builder(Activity.CLICK, "Download button in report section").build();

    /*Ecg Report id*/
    public static final By ECG_REPORT_ID = AppiumBy.className("android.widget.TextView");
    public static final ElementTask ECG_REPORT_ID_TASK =
            new ElementTask.Builder(Activity.VERIFY, "ECG report id").build();



}
