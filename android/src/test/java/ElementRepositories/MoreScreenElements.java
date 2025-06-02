package ElementRepositories;

import Actions.Activity;
import Actions.ElementTask;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;

public class MoreScreenElements {

    /*More button*/
    public static final By MORE_OPTION = AppiumBy.accessibilityId("More");
    public static final ElementTask MORE_OPTION_TASK =
            new ElementTask.Builder(Activity.CLICK, "More option").build();

    /*Notification Label*/
    public static final By NOTIFICATION_LABEL = AppiumBy.id("com.heartmonitor.android:id/txtNotification");
    public static final ElementTask NOTIFICATION_LABEL_TASK =
            new ElementTask.Builder(Activity.VERIFY, "Notification label").build();

    /*Notification Toggle*/
    public static final By NOTIFICATION_TOGGLE = AppiumBy.id("com.heartmonitor.android:id/swEnable");
    public static final ElementTask NOTIFICATION_TOGGLE_TASK =
            new ElementTask.Builder(Activity.CLICK, "Notification Toggle").build();

    /*FAQ's OPTION*/
    public static final By FAQ_OPTION = AppiumBy.id("com.heartmonitor.android:id/txtFaq");
    public static final ElementTask FAQ_OPTION_TASK =
            new ElementTask.Builder(Activity.CLICK, "FAQ's option").build();

    /*Send FeedBack OPTION*/
    public static final By SEND_FEEDBACK_OPTION = AppiumBy.id("com.heartmonitor.android:id/txtSendFeedback");
    public static final ElementTask SEND_FEEDBACK_OPTION_TASK =
            new ElementTask.Builder(Activity.CLICK, "Send FeedBack option").build();

    /*About us OPTION*/
    public static final By ABOUT_US_OPTION = AppiumBy.id("com.heartmonitor.android:id/txtAboutUs");
    public static final ElementTask ABOUT_US_OPTION_TASK =
            new ElementTask.Builder(Activity.CLICK, "About us option").build();

    /*Terms & Condition*/
    public static final By TERMS_AND_CONDITION_OPTION = AppiumBy.id("com.heartmonitor.android:id/txtTerms");
    public static final ElementTask TERMS_AND_CONDITION_OPTION_TASK =
            new ElementTask.Builder(Activity.CLICK, "Terms & Condition option").build();

    /*Privacy Policy*/
    public static final By PRIVACY_POLICY_OPTION = AppiumBy.id("com.heartmonitor.android:id/txtPrivacy");
    public static final ElementTask PRIVACY_POLICY_OPTION_TASK =
            new ElementTask.Builder(Activity.CLICK, "Privacy Policy option").build();

    /*Logout option*/
    public static final By LOGOUT_OPTION = AppiumBy.id("com.heartmonitor.android:id/txtLogout");
    public static final ElementTask LOGOUT_OPTION_TASK =
            new ElementTask.Builder(Activity.CLICK, "Logout option").build();

    /*Delete Account option*/
    public static final By DELETE_ACCOUNT_OPTION = AppiumBy.id("com.heartmonitor.android:id/txtDeleteAcc");
    public static final ElementTask DELETE_ACCOUNT_OPTION_TASK =
            new ElementTask.Builder(Activity.CLICK, "Delete option").build();
}
