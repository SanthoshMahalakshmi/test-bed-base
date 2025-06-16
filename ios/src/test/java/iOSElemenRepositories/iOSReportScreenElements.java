package iOSElemenRepositories;

import Actions.iOSActionType;
import Actions.iOSElementTask;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;

public class iOSReportScreenElements {

    /*Blood pressure Tab*/
    public static final By iOS_BLOOD_PRESSURE_TAB = AppiumBy.accessibilityId("Blood Pressure");
    public static final iOSElementTask iOS_BLOOD_PRESSURE_TAB_TASK =
            new iOSElementTask.Builder(iOSActionType.CLICK, "Blood Pressure Tab").build();

    public static final By iOS_SPO2_TAB = AppiumBy.accessibilityId("SpO2");
    public static final iOSElementTask iOS_SPO2_TAB_TASK =
            new iOSElementTask.Builder(iOSActionType.CLICK, "Spo2 tab").build();

    public static final By iOS_ECG_TAB = AppiumBy.accessibilityId("ECG");
    public static final iOSElementTask iOS_ECG_TAB_TASK =
            new iOSElementTask.Builder(iOSActionType.CLICK, "ECG Tab").build();

    public static final By iOS_HR_TAB = AppiumBy.accessibilityId("Heart Rate");
    public static final iOSElementTask iOS_HR_TAB_TASK =
            new iOSElementTask.Builder(iOSActionType.CLICK, "Heart Rate Tab").build();

    public static final By iOS_DROP_DOWN_FILTER_OPTION = AppiumBy.accessibilityId("ic_down_arrow");
    public static final iOSElementTask iOS_DROP_DOWN_FILTER_OPTION_TASK =
            new iOSElementTask.Builder(iOSActionType.CLICK, "Drop Down Filter options").build();

    public static final By iOS_DAY_DROP_DOWN_OPTION = AppiumBy.accessibilityId("Day");
    public static final iOSElementTask iOS_DAY_DROP_DOWN_OPTION_TASK =
            new iOSElementTask.Builder(iOSActionType.VERIFY, "Day Drop down option ").build();

    public static final By iOS_WEEK_DROP_DOWN_OPTION = AppiumBy.accessibilityId("Week");
    public static final iOSElementTask iOS_WEEK_DROP_DOWN_OPTION_TASK =
            new iOSElementTask.Builder(iOSActionType.VERIFY, "Week Drop down option").build();

    public static final By iOS_MONTH_DROP_DOWN_OPTION = AppiumBy.accessibilityId("Month");
    public static final iOSElementTask iOS_MONTH_DROP_DOWN_OPTION_TASK =
            new iOSElementTask.Builder(iOSActionType.VERIFY, "Month Drop Down option").build();

    public static final By iOS_YEAR_DROP_DOWN_OPTION = AppiumBy.accessibilityId("Year");
    public static final iOSElementTask iOS_YEAR_DROP_DOWN_OPTION_TASK =
            new iOSElementTask.Builder(iOSActionType.CLICK, "Year Drop down option").build();

    public static final By iOS_CUSTOM_DROP_DOWN_OPTION = AppiumBy.accessibilityId("Custom");
    public static final iOSElementTask iOS_CUSTOM_DROP_DOWN_OPTION_TASK =
            new iOSElementTask.Builder(iOSActionType.VERIFY, "Custom Drop down option").build();

    public static final By iOS_DOWNLOAD_BUTTON = AppiumBy.accessibilityId("ic donwload");
    public static final iOSElementTask iOS_DOWNLOAD_BUTTON_TASK =
            new iOSElementTask.Builder(iOSActionType.VERIFY, "Download option").build();

    public static final By iOS_SHARE_OPTION = AppiumBy.accessibilityId("ic share");
    public static final iOSElementTask iOS_SHARE_OPTION_TASK =
            new iOSElementTask.Builder(iOSActionType.CLICK, "Share option").build();

    public static final By iOS_ECG_DOWNLOAD_BUTTON = AppiumBy.iOSClassChain("**/XCUIElementTypeButton[`name == \"ic donwload\"`][1]");
    public static final iOSElementTask iOS_ECG_DOWNLOAD_BUTTON_TASK =
            new iOSElementTask.Builder(iOSActionType.CLICK, "ECG Download option").build();

    public static final By iOS_ECG_REPORT_ID = AppiumBy.accessibilityId("ecg_report_1085_20250616_093030");
    public static final iOSElementTask iOS_ECG_REPORT_ID_TASK =
            new iOSElementTask.Builder(iOSActionType.CLICK, "ECG report id").build();
}
