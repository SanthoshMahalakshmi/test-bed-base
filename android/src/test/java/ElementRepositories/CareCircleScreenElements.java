package ElementRepositories;

import Actions.Activity;
import Actions.ElementTask;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;

public class CareCircleScreenElements {

    /*Care Circle - Allow button for contact */
    public static final By ACCESS_CONTACT_ALLOW_BUTTON = AppiumBy.id("com.android.permissioncontroller:id/permission_allow_button");
    public static final ElementTask ACCESS_CONTACT_ALLOW_BUTTON_TASK =
            new ElementTask.Builder(Activity.CLICK, "Care circle contact allow ").build();

    /*Care Circle - Deny button for contact */
    public static final By ACCESS_CONTACT_DENY_BUTTON = AppiumBy.id("com.android.permissioncontroller:id/permission_deny_button");
    public static final ElementTask ACCESS_CONTACT_DENY_BUTTON_TASK =
            new ElementTask.Builder(Activity.CLICK, "Care circle contact deny").build();

    /*Add member button*/
    public static final By ADD_MEMEBER_BUTTON = AppiumBy.id("com.heartmonitor.android:id/tvAddMembers");
    public static final ElementTask ADD_MEMEBER_BUTTON_TASK =
            new ElementTask.Builder(Activity.CLICK, "Add member").build();

    /*Care circle label*/
    public static final By CARE_CIRCLE_LABEL = AppiumBy.androidUIAutomator("new UiSelector().text(\"Add Care Circle\")");
    public static final ElementTask CARE_CIRCLE_LABEL_TASK =
            new ElementTask.Builder(Activity.VERIFY, "Care circle label").build();

    /*Care Circle - Deny button for contact */
    public static final By CARE_CIRCLE_GROUP_NAME = AppiumBy.id("com.heartmonitor.android:id/edtGroupName");
    public static final ElementTask CARE_CIRCLE_GROUP_NAME_TASK =
            new ElementTask.Builder(Activity.SEND_KEYS, "Care circle group name").inputValue("GG").build();

    /*contact add button for care circle*/
    public static final By CARE_CIRCLE_CONTACT_ADD_BUTTON = AppiumBy.id("com.heartmonitor.android:id/ivAddPlus");
    public static final ElementTask CARE_CIRCLE_CONTACT_ADD_BUTTON_TASK =
            new ElementTask.Builder(Activity.VERIFY, "Care circle contact add").build();

    /*Set reminder check box*/
    public static final By SET_REMINDER_CHECK_BOX = AppiumBy.id("com.heartmonitor.android:id/cbSetReminders");
    public static final ElementTask SET_REMINDER_CHECK_BOX_TASK =
            new ElementTask.Builder(Activity.CLICK, "Care circle set reminder check box").build();

    /*Submit button*/
    public static final By CARE_CIRCLE_SUBMIT_BUTTON = AppiumBy.id("com.heartmonitor.android:id/tvOkay");
    public static final ElementTask CARE_CIRCLE_SUBMIT_BUTTON_TASK =
            new ElementTask.Builder(Activity.CLICK, "Care circle submit").build();

    /*Empty Group name input error text.*/
    public static final By EMPTY_GROUP_NAME_ERROR = AppiumBy.id("com.heartmonitor.android:id/textinput_error");
    public static final ElementTask EMPTY_GROUP_NAME_ERROR_TASK =
            new ElementTask.Builder(Activity.VERIFY, "Empty group name input error").build();

    /*Less character error for the group name.*/
    public static final By LESS_GROUP_NAME_ERROR = AppiumBy.id("com.heartmonitor.android:id/textinput_error");
    public static final ElementTask LESS_GROUP_NAME_ERROR_TASK =
            new ElementTask.Builder(Activity.VERIFY, "Less character group name error").build();

    /*More Option*/
    public static final By CARE_CIRCLE_MORE_OPTION = AppiumBy.accessibilityId("More options");
    public static final ElementTask CARE_CIRCLE_MORE_OPTION_TASK =
            new ElementTask.Builder(Activity.CLICK, "Kebab menu or more option in care circle").build();

    /*Edit care circle*/
    public static final By EDIT_CARE_CIRCLE_OPTION = AppiumBy.androidUIAutomator("new UiSelector().text(\"Edit Care Circle\")");
    public static final ElementTask EDIT_CARE_CIRCLE_OPTION_TASK =
            new ElementTask.Builder(Activity.VERIFY, "Edit care circle option in the kebab menu").build();

    /*Set reminder option*/
    public static final By SET_REMINDER_OPTION = AppiumBy.androidUIAutomator("new UiSelector().text(\"Set Reminder\")");
    public static final ElementTask SET_REMINDER_OPTION_TASK =
            new ElementTask.Builder(Activity.CLICK, "Set reminder option in the kebab menu").build();

    /*delete care circle*/
    public static final By DELETE_CARE_CIRCLE_OPTION = AppiumBy.androidUIAutomator("new UiSelector().text(\"Delete Care Circle\")");
    public static final ElementTask DELETE_CARE_CIRCLE_OPTION_TASK =
            new ElementTask.Builder(Activity.CLICK, "Delete care circle option in the kebab menu").build();

    /*Submit button*/
    public static final By CARE_CIRCLE_UPDATE_BUTTON = AppiumBy.id("com.heartmonitor.android:id/tvOkay");
    public static final ElementTask CARE_CIRCLE_UPDATE_BUTTON_TASK =
            new ElementTask.Builder(Activity.CLICK, "Care circle Update").build();

    /*No Day selected error.*/
    public static final By DELETE_CARE_CIRCEL_MODEL_TEXT = AppiumBy.id("");
    public static final ElementTask DELETE_CARE_CIRCEL_MODEL_TEXT_TASK =
            new ElementTask.Builder(Activity.VERIFY, "delete care circle model message").build();



}
