package iOSElemenRepositories;

import Actions.iOSActionType;
import Actions.iOSElementTask;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;

public class iOSMoreScreenElements {

    /*More button*/
    public static final By iOS_MORE_OPTION = AppiumBy.accessibilityId("ic_more");
    public static final iOSElementTask iOS_MORE_OPTION_TASK =
            new iOSElementTask.Builder(iOSActionType.CLICK, "More Option").build();

    public static final By iOS_NOTIFICATION_LABEL = AppiumBy.iOSClassChain("**/XCUIElementTypeStaticText[`name == \"Notifications\"`]");
    public static final iOSElementTask iOS_NOTIFICATION_LABEL_TASK =
            new iOSElementTask.Builder(iOSActionType.VERIFY, "Notification Label").build();

    public static final By iOS_NOTIFICATION_TOGGLE = AppiumBy.className("XCUIElementTypeSwitch");
    public static final iOSElementTask iOS_NOTIFICATION_TOGGLE_TASK =
            new iOSElementTask.Builder(iOSActionType.CLICK, "Notification toggle").build();

    public static final By iOS_FAQ_OPTION = AppiumBy.accessibilityId("FAQs");
    public static final iOSElementTask iOS_FAQ_OPTION_TASK =
            new iOSElementTask.Builder(iOSActionType.CLICK, "FAQs").build();

    public static final By iOS_SEND_FEEDBACK_OPTION = AppiumBy.accessibilityId("Send Feedback");
    public static final iOSElementTask iOS_SEND_FEEDBACK_OPTION_TASK =
            new iOSElementTask.Builder(iOSActionType.CLICK, "Send Feedback").build();

    public static final By iOS_ABOUT_US_OPTION = AppiumBy.accessibilityId("About Us");
    public static final iOSElementTask iOS_ABOUT_US_OPTION_TASK =
            new iOSElementTask.Builder(iOSActionType.CLICK, "About Us").build();

    public static final By iOS_TERMS_AND_CONDITION_OPTION = AppiumBy.accessibilityId("Terms & Conditions");
    public static final iOSElementTask iOS_TERMS_AND_CONDITION_OPTION_TASK =
            new iOSElementTask.Builder(iOSActionType.CLICK, "Terms & Conditions").build();

    public static final By iOS_PRIVACY_POLICY_OPTION = AppiumBy.accessibilityId("");
    public static final iOSElementTask iOS_PRIVACY_POLICY_OPTION_TASK =
            new iOSElementTask.Builder(iOSActionType.CLICK, "").build();

    public static final By iOS_LOGOUT_OPTION = AppiumBy.accessibilityId("");
    public static final iOSElementTask iOS_LOGOUT_OPTION_TASK =
            new iOSElementTask.Builder(iOSActionType.CLICK, "").build();

    public static final By iOS_DELETE_ACCOUNT_OPTION = AppiumBy.accessibilityId("");
    public static final iOSElementTask iOS_DELETE_ACCOUNT_OPTION_TASK =
            new iOSElementTask.Builder(iOSActionType.CLICK, "").build();

}
