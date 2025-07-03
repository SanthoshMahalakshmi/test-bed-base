package iOSElemenRepositories;

import Actions.iOSActionType;
import Actions.iOSElementTask;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;

public class iOSDashBoardScreenElements {

    /*DashBoard app logo Element*/
    public static final By iOS_DASHBOARD_APP_LOGO = AppiumBy.iOSClassChain("**/XCUIElementTypeImage[`name == \"Monitor\"`]");
    public static final iOSElementTask iOS_DASHBOARD_APP_LOGO_TASK =
            new iOSElementTask.Builder(iOSActionType.VERIFY, "DashBoard logo").build();

//    /*DashBoard option*/
//    public static final By iOS_DASHBOARD_BUTTON = AppiumBy.iOSClassChain("");
//    public static final iOSElementTask iOS_DASHBOARD_BUTTON_TASK =
//            new iOSElementTask.Builder(iOSActionType.VERIFY, "").build();

    /*Dashboard sync toast message*/
    public static final By iOS_DASHBOARD_SYNC_BUTTON = AppiumBy.accessibilityId("ic sync");
    public static final iOSElementTask iOS_DASHBOARD_SYNC_BUTTON_TASK =
            new iOSElementTask.Builder(iOSActionType.VERIFY, "Manual Sync").build();

//    public static final By iOS_DASHBOARD_SYNC_TOAST = AppiumBy.iOSClassChain("");
//    public static final iOSElementTask iOS_DASHBOARD_SYNC_TOAST_TASK =
//            new iOSElementTask.Builder(iOSActionType.VERIFY, "").build();
//
//    /*Dashboard sync toast message close button*/
//    public static final By iOS_DASHBOARD_SYNC_TOAST_CLOSE = AppiumBy.iOSClassChain("");
//    public static final iOSElementTask iOS_DASHBOARD_SYNC_TOAST_CLOSE_TASK =
//            new iOSElementTask.Builder(iOSActionType.VERIFY, "").build();

    /*DashBoard Notification button*/
    public static final By iOS_DASHBOARD_NOTIFICATION_BUTTON = AppiumBy.accessibilityId("ic notification");
    public static final iOSElementTask iOS_DASHBOARD_NOTIFICATION_BUTTON_TASK =
            new iOSElementTask.Builder(iOSActionType.CLICK, "Notification button").build();

    /*Send Feed Back button*/
    public static final By iOS_DASHBOARD_SEND_FEEDBACK_BUTTON = AppiumBy.iOSClassChain("**/XCUIElementTypeButton[`name == \"ic more contactus\"`]");
    public static final iOSElementTask iOS_DASHBOARD_SEND_FEEDBACK_BUTTON_TASK =
            new iOSElementTask.Builder(iOSActionType.VERIFY, "Send feedBack").build();

//    /*Dependent Section*/
//    public static final By iOS_DASHBOARD_DEPENDENT_LABEL = AppiumBy.iOSClassChain("");
//    public static final iOSElementTask iOS_DASHBOARD_DEPENDENT_LABEL_TASK =
//            new iOSElementTask.Builder(iOSActionType.VERIFY, "").build();

//    /*Dependent + button*/
//    public static final By iOS_DASHBOARD_DEPENDENT_BUTTON = AppiumBy.iOSClassChain("");
//    public static final iOSElementTask iOS_DASHBOARD_DEPENDENT_BUTTON_TASK =
//            new iOSElementTask.Builder(iOSActionType.VERIFY, "").build();

//    /*Dependent drop down button*/
//    public static final By iOS_DASHBOARD_DEPENDENT_DROPDOWN = AppiumBy.iOSClassChain("");
//    public static final iOSElementTask iOS_DASHBOARD_DEPENDENT_DROPDOWN_TASK =
//            new iOSElementTask.Builder(iOSActionType.VERIFY, "").build();

    /*Dependent user*/
    public static final By iOS_DASHBOARD_DEPENDENT_USER = AppiumBy.iOSClassChain("**/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell/XCUIElementTypeOther[1]/XCUIElementTypeOther");
    public static final iOSElementTask iOS_DASHBOARD_DEPENDENT_USER_TASK =
            new iOSElementTask.Builder(iOSActionType.CLICK, "").build();

//    /*Care Circle label*/
//    public static final By iOS_DASHBOARD_CARE_CIRCLE_LABEL = AppiumBy.iOSClassChain("");
//    public static final iOSElementTask iOS_DASHBOARD_CARE_CIRCLE_LABEL_TASK =
//            new iOSElementTask.Builder(iOSActionType.VERIFY, "").build();

    /*Care Circle get started button*/
    public static final By iOS_DASHBOARD_CARE_CIRCLE_PLUS_BUTTON = AppiumBy.iOSClassChain("**/XCUIElementTypeButton[`name == \"add\"`][2]");
    public static final iOSElementTask iOS_DASHBOARD_CARE_CIRCLE_PLUS_BUTTON_TASK =
            new iOSElementTask.Builder(iOSActionType.CLICK, "My Care Circle Plus").build();

//    /*Actual care circle group*/
//    public static final By iOS_DASHBOARD_CARE_CIRCLE = AppiumBy.iOSClassChain("");
//    public static final iOSElementTask iOS_DASHBOARD_CARE_CIRCLE_TASK =
//            new iOSElementTask.Builder(iOSActionType.VERIFY, "").build();

    /*DashBoard BP Report label*/
    public static final By iOS_DASHBOARD_BP_REPORT_LABEL = AppiumBy.accessibilityId("Blood Pressure");
    public static final iOSElementTask iOS_DASHBOARD_BP_REPORT_LABEL_TASK =
            new iOSElementTask.Builder(iOSActionType.VERIFY, "DashBoard Bp report label").build();

//    /*DashBoard BP Report chart*/
//    public static final By iOS_DASHBOARD_BP_REPORT_CHART = AppiumBy.iOSClassChain("");
//    public static final iOSElementTask iOS_DASHBOARD_BP_REPORT_CHART_TASK =
//            new iOSElementTask.Builder(iOSActionType.VERIFY, "").build();
//
//    /*DashBoard BP Report values*/
//    public static final By iOS_DASHBOARD_BP_REPORT_VALUE = AppiumBy.iOSClassChain("");
//    public static final iOSElementTask iOS_DASHBOARD_BP_REPORT_VALUE_TASK =
//            new iOSElementTask.Builder(iOSActionType.VERIFY, "").build();

    /*DashBoard HR Report label*/
    public static final By iOS_DASHBOARD_HR_REPORT_LABEL = AppiumBy.accessibilityId("HR");
    public static final iOSElementTask iOS_DASHBOARD_HR_REPORT_LABEL_TASK =
            new iOSElementTask.Builder(iOSActionType.VERIFY, "DashBoard HR report label").build();

//    /*DashBoard HR Report chart*/
//    public static final By iOS_DASHBOARD_HR_REPORT_CHART = AppiumBy.iOSClassChain("");
//    public static final iOSElementTask iOS_DASHBOARD_HR_REPORT_CHART_TASK =
//            new iOSElementTask.Builder(iOSActionType.VERIFY, "").build();
//
//    /*DashBoard HR Report values*/
//    public static final By iOS_DASHBOARD_HR_REPORT_VALUE = AppiumBy.iOSClassChain("");
//    public static final iOSElementTask iOS_DASHBOARD_HR_REPORT_VALUE_TASK =
//            new iOSElementTask.Builder(iOSActionType.VERIFY, "").build();

    /*DashBoard SPO2 Report label*/
    public static final By iOS_DASHBOARD_SPO2_REPORT_LABEL = AppiumBy.accessibilityId("SpO2");
    public static final iOSElementTask iOS_DASHBOARD_SPO2_REPORT_LABEL_TASK =
            new iOSElementTask.Builder(iOSActionType.VERIFY, "DashBoard SPO2 report label").build();

//    /*DashBoard SPO2 Report chart*/
//    public static final By iOS_DASHBOARD_SPO2_REPORT_CHART = AppiumBy.iOSClassChain("");
//    public static final iOSElementTask iOS_DASHBOARD_SPO2_REPORT_CHART_TASK =
//            new iOSElementTask.Builder(iOSActionType.VERIFY, "").build();
//
//    /*DashBoard SPO2 Report values*/
//    public static final By iOS_DASHBOARD_SPO2_REPORT_VALUE = AppiumBy.iOSClassChain("");
//    public static final iOSElementTask iOS_DASHBOARD_SPO2_REPORT_VALUE_TASK =
//            new iOSElementTask.Builder(iOSActionType.VERIFY, "").build();

    /*DashBoard ECG Report label*/
    public static final By iOS_DASHBOARD_ECG_REPORT_LABEL = AppiumBy.accessibilityId("ECG");
    public static final iOSElementTask iOS_DASHBOARD_ECG_REPORT_LABEL_TASK =
            new iOSElementTask.Builder(iOSActionType.VERIFY, "DashBoard ECG report label").build();

//    /*DashBoard ECG Report chart*/
//    public static final By iOS_DASHBOARD_ECG_REPORT_CHART = AppiumBy.iOSClassChain("");
//    public static final iOSElementTask iOS_DASHBOARD_ECG_REPORT_CHART_TASK =
//            new iOSElementTask.Builder(iOSActionType.VERIFY, "").build();

    public static final By iOS_DUM = AppiumBy.accessibilityId("add_cc");
    public static final iOSElementTask iOS_DUM_TASK =
            new iOSElementTask.Builder(iOSActionType.VERIFY, "PLus button").build();

    public static final By iOS_PlUS = AppiumBy.accessibilityId("btn_ic_sync");
    public static final iOSElementTask iOS_PlUS_TASK =
            new iOSElementTask.Builder(iOSActionType.VERIFY, "Sync Button").build();

}
