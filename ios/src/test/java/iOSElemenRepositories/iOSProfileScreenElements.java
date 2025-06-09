package iOSElemenRepositories;

import Actions.iOSActionType;
import Actions.iOSElementTask;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;

public class iOSProfileScreenElements {

    /*Profile button*/
    public static final By iOS_PROFILE_BUTTON = AppiumBy.accessibilityId("ic_profile");
    public static final iOSElementTask iOS_iOS_PROFILE_BUTTON_TASK =
            new iOSElementTask.Builder(iOSActionType.CLICK, "Profile Option").build();

    /*Profile Page Coach mark Skip.*/
    public static final By iOS_PROFILE_COACH_MARK_SKIP = AppiumBy.iOSClassChain("**/XCUIElementTypeStaticText[`name == \"Skip\"`]");
    public static final iOSElementTask iOS_PROFILE_COACH_MARK_SKIP_TASK =
            new iOSElementTask.Builder(iOSActionType.CLICK, "Profile Coach Mark: Skip").build();

    /*Edit Profile Button*/
    public static final By iOS_EDIT_PROFILE_BUTTON = AppiumBy.xpath("(//XCUIElementTypeButton[@name=\"Edit Profile\"])[2]");
    public static final iOSElementTask iOS_EDIT_PROFILE_BUTTON_TASK =
            new iOSElementTask.Builder(iOSActionType.CLICK, "Edit Profile option").build();

    /*Consume edit button*/
    public static final By iOS_CONSUME_EDIT_BUTTON = AppiumBy.accessibilityId("ic edit");
    public static final iOSElementTask iOS_CONSUME_EDIT_BUTTON_TASK =
            new iOSElementTask.Builder(iOSActionType.CLICK, "Consume Edit icon").build();

    /*Parameter Range*/
    public static final By iOS_PARAMETER_RANGE_BUTTON = AppiumBy.accessibilityId("Parameter Range");
    public static final iOSElementTask iOS_PARAMETER_RANGE_BUTTON_TASK =
            new iOSElementTask.Builder(iOSActionType.CLICK, "Parameter Range").build();

    /*1st Adjust Button*/
    public static final By iOS_ADJUST_BUTTON_1 = AppiumBy.iOSClassChain("**/XCUIElementTypeStaticText[`name == \"Adjust\"`][1]");
    public static final iOSElementTask iOS_ADJUST_BUTTON_1_TASK =
            new iOSElementTask.Builder(iOSActionType.VERIFY, "Blood Pressure Adjust").build();

    /*2nd Adjust Button*/
    public static final By iOS_ADJUST_BUTTON_2 = AppiumBy.iOSClassChain("**/XCUIElementTypeStaticText[`name == \"Adjust\"`][2]");
    public static final iOSElementTask iOS_ADJUST_BUTTON_2_TASK =
            new iOSElementTask.Builder(iOSActionType.VERIFY, "HR Adjust").build();

    /*1st keep Default Button*/
    public static final By iOS_KEEP_DEFAULT_BUTTON_1 = AppiumBy.iOSClassChain("**/XCUIElementTypeStaticText[`name == \"Keep Default\"`][1]");
    public static final iOSElementTask iOS_KEEP_DEFAULT_BUTTON_1_TASK =
            new iOSElementTask.Builder(iOSActionType.VERIFY, "Blood Pressure Keep Default").build();

    /*2nd keep Default Button*/
    public static final By iOS_KEEP_DEFAULT_BUTTON_2 = AppiumBy.iOSClassChain("**/XCUIElementTypeStaticText[`name == \"Keep Default\"`][2]");
    public static final iOSElementTask iOS_KEEP_DEFAULT_BUTTON_2_TASK =
            new iOSElementTask.Builder(iOSActionType.VERIFY, "HR Keep Default").build();

    /*Submit button for closing the range model*/
    public static final By iOS_SUBMIT_BUTTON = AppiumBy.iOSClassChain("**/XCUIElementTypeStaticText[`name == \"Submit\"`]");
    public static final iOSElementTask iOS_SUBMIT_BUTTON_TASK =
            new iOSElementTask.Builder(iOSActionType.VERIFY, "Submit").build();

    /*Are Sure You want to reset the parameter? model text.*/
    public static final By iOS_RESET_PARAMETER_MODEL_TEXT = AppiumBy.iOSClassChain("**/XCUIElementTypeStaticText[`name == \"Reset Parameters\"`]");
    public static final iOSElementTask iOS_RESET_PARAMETER_MODEL_TEXT_TASK =
            new iOSElementTask.Builder(iOSActionType.VERIFY, "Reset Model text Header.").build();

    /*My dependent*/
    public static final By iOS_MY_DEPENDENT_BUTTON = AppiumBy.accessibilityId("My Dependents");
    public static final iOSElementTask iOS_MY_DEPENDENT_BUTTON_TASK =
            new iOSElementTask.Builder(iOSActionType.VERIFY, "My dependent option").build();

    /*Care circle*/
    public static final By iOS_CARE_CIRCLE_BUTTON = AppiumBy.accessibilityId("Care Circle");
    public static final iOSElementTask iOS_CARE_CIRCLE_BUTTON_TASK =
            new iOSElementTask.Builder(iOSActionType.VERIFY, "Care Circle Option").build();

    /*My Device*/
    public static final By iOS_MY_DEVICE_BUTTON = AppiumBy.accessibilityId("My Devices");
    public static final iOSElementTask iOS_MY_DEVICE_BUTTON_TASK =
            new iOSElementTask.Builder(iOSActionType.VERIFY, "My device").build();

    /*My reminder*/
    public static final By iOS_MY_REMINDER_BUTTON = AppiumBy.accessibilityId("My Reminders");
    public static final iOSElementTask iOS_MY_REMINDER_BUTTON_TASK =
            new iOSElementTask.Builder(iOSActionType.VERIFY, "My reminder Option").build();

}
