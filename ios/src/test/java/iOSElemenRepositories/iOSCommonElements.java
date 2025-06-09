package iOSElemenRepositories;

import Actions.iOSActionType;
import Actions.iOSElementTask;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;

public class iOSCommonElements {

    /*Verify mobile number label*/
    public static final By iOS_KEYBOARD_DONE_BUTTON = AppiumBy.accessibilityId("Done");
    public static final iOSElementTask iOS_KEYBOARD_DONE_BUTTON_TASK =
            new iOSElementTask.Builder(iOSActionType.CLICK, "Key Board Done").build();
}
