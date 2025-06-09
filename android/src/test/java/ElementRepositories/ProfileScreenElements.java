package ElementRepositories;

import Actions.Activity;
import Actions.ElementTask;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;

public class ProfileScreenElements {

    /*Profile button*/
    public static final By PROFILE_BUTTON = AppiumBy.accessibilityId("Profile");
    public static final ElementTask PROFILE_BUTTON_TASK =
            new ElementTask.Builder(Activity.CLICK, "Profile option").build();

    /*Profile Page Coach mark Skip.*/
    public static final By PROFILE_COACH_MARK_SKIP = AppiumBy.id("com.heartmonitor.android:id/tvSkip");
    public static final ElementTask PROFILE_COACH_MARK_SKIP_TASK =
            new ElementTask.Builder(Activity.CLICK, "Profile screen coach mark Skip").build();

    /*Edit Profile Button*/
    public static final By EDIT_PROFILE_BUTTON = AppiumBy.id("com.heartmonitor.android:id/txtEditProfile");
    public static final ElementTask EDIT_PROFILE_BUTTON_TASK =
            new ElementTask.Builder(Activity.CLICK, "Edit Profile").build();

    /*Consume edit button*/
    public static final By CONSUME_EDIT_BUTTON = AppiumBy.id("com.heartmonitor.android:id/editConsume");
    public static final ElementTask CONSUME_EDIT_BUTTON_TASK =
            new ElementTask.Builder(Activity.CLICK, "Consume Edit").build();

    /*My dependent*/
    public static final By MY_DEPENDENT_BUTTON = AppiumBy.id("com.heartmonitor.android:id/txtMyDependent");
    public static final ElementTask MY_DEPENDENT_BUTTON_TASK =
            new ElementTask.Builder(Activity.CLICK, "My dependent").build();

    /*Parameter Range*/
    public static final By PARAMETER_RANGE_BUTTON = AppiumBy.id("com.heartmonitor.android:id/txtParameterRange");
    public static final ElementTask PARAMETER_RANGE_BUTTON_TASK =
            new ElementTask.Builder(Activity.CLICK, "Parameter Range").build();

    /*1st Adjust Button*/
    public static final By ADJUST_BUTTON_1 = AppiumBy.xpath("(//android.widget.TextView[@resource-id=\"com.heartmonitor.android:id/txtCustomize2\"])[1]");
    public static final ElementTask ADJUST_BUTTON_1_TASK =
            new ElementTask.Builder(Activity.CLICK, "1st Adjust").build();

    /*2nd Adjust Button*/
    public static final By ADJUST_BUTTON_2 = AppiumBy.xpath("(//android.widget.TextView[@resource-id=\"com.heartmonitor.android:id/txtCustomize2\"])[2]");
    public static final ElementTask ADJUST_BUTTON_2_TASK =
            new ElementTask.Builder(Activity.CLICK, "2nd Adjust").build();

    /*1st keep Default Button*/
    public static final By KEEP_DEFAULT_BUTTON_1 = AppiumBy.xpath("(//android.widget.TextView[@resource-id=\"com.heartmonitor.android:id/txtBPRest\"])[1]");
    public static final ElementTask KEEP_DEFAULT_BUTTON_1_TASK =
            new ElementTask.Builder(Activity.CLICK, "1st Keep Default").build();

    /*2nd keep Default Button*/
    public static final By KEEP_DEFAULT_BUTTON_2 = AppiumBy.xpath("(//android.widget.TextView[@resource-id=\"com.heartmonitor.android:id/txtBPRest\"])[2]");
    public static final ElementTask KEEP_DEFAULT_BUTTON_2_TASK =
            new ElementTask.Builder(Activity.CLICK, "2nd Keep Default").build();

    /*Submit button for closing the range*/
    public static final By SUBMIT_BUTTON = AppiumBy.id("com.heartmonitor.android:id/txtSubmit");
    public static final ElementTask SUBMIT_BUTTON_TASK =
            new ElementTask.Builder(Activity.CLICK, "Submit").build();

    /*Are Sure You want to reset the parameter? model text.*/
    public static final By RESET_PARAMETER_MODEL_TEXT = AppiumBy.id("android:id/message");
    public static final ElementTask RESET_PARAMETER_MODEL_TEXT_TASK =
            new ElementTask.Builder(Activity.CLICK, "Reset Parameter Model text").build();

    /*Care circle*/
    public static final By CARE_CIRCLE_BUTTON = AppiumBy.id("com.heartmonitor.android:id/txtCareCircle");
    public static final ElementTask CARE_CIRCLE_BUTTON_TASK =
            new ElementTask.Builder(Activity.CLICK, "Care Circle").build();

    /*My Device*/
    public static final By MY_DEVICE_BUTTON = AppiumBy.id("com.heartmonitor.android:id/txtMyDevice");
    public static final ElementTask MY_DEVICE_BUTTON_TASK =
            new ElementTask.Builder(Activity.CLICK, "My device").build();

    /*My reminder*/
    public static final By MY_REMINDER_BUTTON = AppiumBy.id("com.heartmonitor.android:id/txtMyReminder");
    public static final ElementTask MY_REMINDER_BUTTON_TASK =
            new ElementTask.Builder(Activity.CLICK, "My Reminder").build();





}

