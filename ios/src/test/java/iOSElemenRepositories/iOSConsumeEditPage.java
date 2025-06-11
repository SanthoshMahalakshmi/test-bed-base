package iOSElemenRepositories;

import Actions.iOSActionType;
import Actions.iOSElementTask;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;

public class iOSConsumeEditPage {

    /*Do you consume Alcohol*/
    public static final By iOS_DO_YOU_CONSUME_ALCOHOL_LABEL = AppiumBy.accessibilityId("Do you Consume Alcohol?");
    public static final iOSElementTask iOS_DO_YOU_CONSUME_ALCOHOL_LABEL_TASK =
            new iOSElementTask.Builder(iOSActionType.VERIFY, "Do you Consume Alcohol Label").build();

    /*Alcohol Yes*/
    public static final By iOS_ALCOHOL_YES_BUTTON = AppiumBy.iOSClassChain("**/XCUIElementTypeButton[`name == \"Yes\"`][1]");
    public static final iOSElementTask iOS_ALCOHOL_YES_BUTTON_TASK =
            new iOSElementTask.Builder(iOSActionType.CLICK, "Consume Alcohol: Yes.").build();

    /*Alcohol No*/
    public static final By iOS_ALCOHOL_NO_BUTTON = AppiumBy.iOSClassChain("**/XCUIElementTypeButton[`name == \"No\"`][1]");
    public static final iOSElementTask iOS_ALCOHOL_NO_BUTTON_TASK =
            new iOSElementTask.Builder(iOSActionType.CLICK, "Consume Alcohol: No").build();

    /*Alcohol Occasionally*/
    public static final By iOS_ALCOHOL_OCCASIONALLY_BUTTON = AppiumBy.iOSClassChain("**/XCUIElementTypeButton[`name == \"Occasionally\"`][1]");
    public static final iOSElementTask iOS_ALCOHOL_OCCASIONALLY_BUTTON_TASK =
            new iOSElementTask.Builder(iOSActionType.CLICK, "Consume Alcohol: Occasionally").build();

    /*Do you Smoke Alcohol*/
    public static final By iOS_DO_YOU_SMOKE_LABEL = AppiumBy.accessibilityId("Do you Smoke?");
    public static final iOSElementTask iOS_DO_YOU_SMOKE_LABEL_TASK =
            new iOSElementTask.Builder(iOSActionType.VERIFY, "Do you Smoke label").build();

    /*Smoke Yes*/
    public static final By iOS_SMOKE_YES_BUTTON = AppiumBy.iOSClassChain("**/XCUIElementTypeButton[`name == \"Yes\"`][2]");
    public static final iOSElementTask iOS_SMOKE_YES_BUTTON_TASK =
            new iOSElementTask.Builder(iOSActionType.CLICK, "Do you Smoke? : Yes").build();

    /*Smoke No*/
    public static final By iOS_SMOKE_NO_BUTTON = AppiumBy.iOSClassChain("**/XCUIElementTypeButton[`name == \"No\"`][2]");
    public static final iOSElementTask iOS_SMOKE_NO_BUTTON_TASK =
            new iOSElementTask.Builder(iOSActionType.CLICK, "Do you Smoke? : No").build();

    /*Smoke Occasionally*/
    public static final By iOS_SMOKE_OCCASIONALLY_BUTTON = AppiumBy.iOSClassChain("**/XCUIElementTypeButton[`name == \"Occasionally\"`][2]");
    public static final iOSElementTask iOS_SMOKE_OCCASIONALLY_BUTTON_TASK =
            new iOSElementTask.Builder(iOSActionType.CLICK, "Do you Smoke? : Occasionally").build();
}
