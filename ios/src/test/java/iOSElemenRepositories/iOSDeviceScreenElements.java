package iOSElemenRepositories;

import Actions.iOSActionType;
import Actions.iOSElementTask;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;

public class iOSDeviceScreenElements {

    /*Device screen coach mark skip*/
    public static final By iOS_DEVICE_COACH_MARK_FINISH_BUTTON = AppiumBy.xpath("//XCUIElementTypeStaticText[@name=\"Finish\"]");
    public static final iOSElementTask iOS_DEVICE_COACH_MARK_FINISH_BUTTON_TASK =
            new iOSElementTask.Builder(iOSActionType.CLICK, "Device Coach Mark: Finish").build();
}
