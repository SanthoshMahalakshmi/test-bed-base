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

}