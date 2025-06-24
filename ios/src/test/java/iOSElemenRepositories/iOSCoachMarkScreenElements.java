package iOSElemenRepositories;

import Actions.iOSActionType;
import Actions.iOSElementTask;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;

public class iOSCoachMarkScreenElements {

    /*Coach mark finish button*/
    public static final By iOS_COACH_MARK_FINISH_BUTTON = AppiumBy.iOSClassChain("**/XCUIElementTypeStaticText[`name == \"Finish\"`]");
    public static final iOSElementTask iOS_COACH_MARK_FINISH_BUTTON_TASK =
            new iOSElementTask.Builder(iOSActionType.CLICK, "Coach Mark Finish").build();

    public static final By iOS_COACH_MARK_NEXT_BUTTON = AppiumBy.iOSClassChain("**/XCUIElementTypeStaticText[`name == \"Finish\"`]");
    public static final iOSElementTask iOS_COACH_MARK_NEXT_BUTTON_TASK =
            new iOSElementTask.Builder(iOSActionType.CLICK, "Coach Mark Next").build();

    public static final By iOS_PROFILE_COACH_MARK_TEXT = AppiumBy.accessibilityId("Click here to download the report for the selected parameter.");
    public static final iOSElementTask iOS_PROFILE_COACH_MARK_TEXT_TASK =
            new iOSElementTask.Builder(iOSActionType.VERIFY, "Profile Coach Mark text").build();

            public static final By iOS_DEVICE_COACH_MARK_TEXT = AppiumBy.accessibilityId("Select to Proceed.");
    public static final iOSElementTask iOS_DEVICE_COACH_MARK_TEXT_TASK =
            new iOSElementTask.Builder(iOSActionType.VERIFY, "Device Coach Mark text").build();

}