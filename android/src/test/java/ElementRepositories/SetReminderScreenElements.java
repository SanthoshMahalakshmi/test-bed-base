package ElementRepositories;

import Actions.Activity;
import Actions.ElementTask;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;

public class SetReminderScreenElements {

    /*Set-reminder radio button*/
    public static final By SET_REMINDER_BP_RADIO_BUTTON = AppiumBy.id("com.heartmonitor.android:id/rbBp");
    public static final ElementTask SET_REMINDER_BP_RADIO_BUTTON_TASK =
            new ElementTask.Builder(Activity.CLICK, "Bp Radio").build();

    /*Set-reminder radio button*/
    public static final By SET_REMINDER_ECG_RADIO_BUTTON = AppiumBy.id("com.heartmonitor.android:id/rbECG");
    public static final ElementTask SET_REMINDER_ECG_RADIO_BUTTON_TASK =
            new ElementTask.Builder(Activity.CLICK, "ECG Radio").build();

    /*Set-reminder radio button*/
    public static final By SET_REMINDER_SPO2_RADIO_BUTTON = AppiumBy.id("com.heartmonitor.android:id/rbSpo2");
    public static final ElementTask SET_REMINDER_SPO2_RADIO_BUTTON_TASK =
            new ElementTask.Builder(Activity.CLICK, "SPO2 Radio").build();

    /*Set-reminder radio button*/
    public static final By SET_REMINDER_HR_RADIO_BUTTON = AppiumBy.id("com.heartmonitor.android:id/rbHR");
    public static final ElementTask SET_REMINDER_HR_RADIO_BUTTON_TASK =
            new ElementTask.Builder(Activity.CLICK, "HR Radio").build();

    /*Reminder type option.*/
    public static final By REMINDER_TYPE_BUTTON = AppiumBy.id("com.heartmonitor.android:id/txtReminderType");
    public static final ElementTask REMINDER_TYPE_BUTTON_TASK =
            new ElementTask.Builder(Activity.CLICK, "Reminder option type").build();

    /*Reminder name input field*/
    public static final By REMINDER_NAME = AppiumBy.id("com.heartmonitor.android:id/edtReminderName");
    public static final ElementTask REMINDER_NAME_TASK =
            new ElementTask.Builder(Activity.SEND_KEYS, "Reminder name input").inputValue("Reminder for HR").build();

    /*All days check box*/
    public static final By ALL_DAYS_CHECKBOX = AppiumBy.id("com.heartmonitor.android:id/checkRepeat");
    public static final ElementTask ALL_DAYS_CHECKBOX_TASK =
            new ElementTask.Builder(Activity.CLICK, "All days check box").build();

    /*Add time option for reminder.*/
    public static final By ADD_TIME_BUTTON = AppiumBy.id("com.heartmonitor.android:id/chipAdd");
    public static final ElementTask ADD_TIME_BUTTON_TASK =
            new ElementTask.Builder(Activity.CLICK, "Add time option for reminder").build();

    /*ok button for time selection*/
    public static final By CLOCK_OK_BUTTON = AppiumBy.id("android:id/button1");
    public static final ElementTask CLOCK_OK_BUTTON_TASK =
            new ElementTask.Builder(Activity.CLICK, "Clock Ok button").build();

    /*Add invitee option.*/
    public static final By ADD_INVITEE_PLUS_BUTTON = AppiumBy.id("com.heartmonitor.android:id/imgAddReminder");
    public static final ElementTask ADD_INVITEE_PLUS_BUTTON_TASK =
            new ElementTask.Builder(Activity.CLICK, "Add invitee plus option").build();

    /*All My family check box*/
    public static final By ALL_MY_FAMILY_CHECKBOX = AppiumBy.id("com.heartmonitor.android:id/selectAllMyFamily");
    public static final ElementTask ALL_MY_FAMILY_CHECKBOX_TASK =
            new ElementTask.Builder(Activity.CLICK, "All my family check box").build();

    /*Personal note input field.*/
    public static final By PERSONAL_NOTE_INPUT_FIELD = AppiumBy.id("com.heartmonitor.android:id/edtPersonalNotes");
    public static final ElementTask PERSONAL_NOTE_INPUT_FIELD_TASK =
            new ElementTask.Builder(Activity.SEND_KEYS, "Personal note input field").inputValue("Reminder for care circle user").build();

    /*Set reminder Button*/
    public static final By SET_REMINDER_BUTTON = AppiumBy.id("com.heartmonitor.android:id/txtSetReminder");
    public static final ElementTask SET_REMINDER_BUTTON_TASK =
            new ElementTask.Builder(Activity.CLICK, "Set reminder").build();

    /*Add invitee button*/
    public static final By ADD_INVITEE_BUTTON = AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.heartmonitor.android:id/txtSubmit\")");
    public static final ElementTask ADD_INVITEE_BUTTON_TASK =
            new ElementTask.Builder(Activity.CLICK, "Add invitee").build();

    /*SUN date button*/
    public static final By SUN_BUTTON = AppiumBy.id("com.heartmonitor.android:id/txtSUN");
    public static final ElementTask SUN_BUTTON_TASK =
            new ElementTask.Builder(Activity.CLICK, "SUNDAY date").build();

    /*MON date button*/
    public static final By MON_BUTTON = AppiumBy.id("com.heartmonitor.android:id/txtMUN");
    public static final ElementTask MON_BUTTON_TASK =
            new ElementTask.Builder(Activity.CLICK, "MONDAY date").build();

    /*TUE date button*/
    public static final By TUE_BUTTON = AppiumBy.id("com.heartmonitor.android:id/txtTUE");
    public static final ElementTask TUE_BUTTON_TASK =
            new ElementTask.Builder(Activity.CLICK, "TUESDAY date").build();

    /*WED date button*/
    public static final By WED_BUTTON = AppiumBy.id("com.heartmonitor.android:id/txtWED");
    public static final ElementTask WED_BUTTON_TASK =
            new ElementTask.Builder(Activity.CLICK, "WEDNESDAY date").build();

    /*THU date button*/
    public static final By THU_BUTTON = AppiumBy.id("com.heartmonitor.android:id/txtTHU");
    public static final ElementTask THU_BUTTON_TASK =
            new ElementTask.Builder(Activity.CLICK, "THURSDAY date").build();

    /*FRI date button*/
    public static final By FRI_BUTTON = AppiumBy.id("com.heartmonitor.android:id/txtFRI");
    public static final ElementTask FRI_BUTTON_TASK =
            new ElementTask.Builder(Activity.CLICK, "FRIDAY date").build();

    /*SAT date button*/
    public static final By SAT_BUTTON = AppiumBy.id("com.heartmonitor.android:id/txtSAT");
    public static final ElementTask SAT_BUTTON_TASK =
            new ElementTask.Builder(Activity.CLICK, "SATURDAY date").build();

    /*Empty reminder name error*/
    public static final By EMPTY_REMINDER_NAME_ERROR = AppiumBy.id("com.heartmonitor.android:id/textinput_error");
    public static final ElementTask EMPTY_REMINDER_NAME_ERROR_TASK =
            new ElementTask.Builder(Activity.VERIFY, "Empty reminder name error").build();

    /*Less reminder name error*/
    public static final By REMINDER_NAME_LESS_CHARACTER_ERROR = AppiumBy.id("com.heartmonitor.android:id/textinput_error");
    public static final ElementTask REMINDER_NAME_LESS_CHARACTER_ERROR_TASK =
            new ElementTask.Builder(Activity.VERIFY, "Less character error for reminder name").build();

    /*Empty Personal note error*/
    public static final By EMPTY_PERSONAL_NAME_ERROR = AppiumBy.id("com.heartmonitor.android:id/textinput_error");
    public static final ElementTask EMPTY_PERSONAL_NAME_ERROR_TASK =
            new ElementTask.Builder(Activity.VERIFY, "Empty personal note error").build();

    /*Less character for personal note error*/
    public static final By PERSONAL_NOTE_LESS_CHARACTER_ERROR = AppiumBy.id("com.heartmonitor.android:id/textinput_error");
    public static final ElementTask PERSONAL_NOTE_LESS_CHARACTER_ERROR_TASK =
            new ElementTask.Builder(Activity.VERIFY, "Less character error for personal note").build();

    /*Time not selected error for reminder*/
    public static final By TIME_NOT_SELECTED_ERROR = AppiumBy.id("android:id/message");
    public static final ElementTask TIME_NOT_SELECTED_ERROR_TASK =
            new ElementTask.Builder(Activity.VERIFY, "Time not selected error.").build();

    /*No Day selected error.*/
    public static final By DAY_NOT_SELECTED_ERROR = AppiumBy.id("android:id/message");
    public static final ElementTask DAY_NOT_SELECTED_ERROR_TASK =
            new ElementTask.Builder(Activity.VERIFY, "Day not selected error").build();




}
