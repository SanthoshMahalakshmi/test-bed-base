package ElementRepositories;

import Actions.Activity;
import Actions.ElementTask;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;

public class DeviceScreenElements {

    /*My Device*/
    public static final By DEVICE_COACH_MARK_FINISH_BUTTON = AppiumBy.id("com.heartmonitor.android:id/txtMyDevice");
    public static final ElementTask DEVICE_COACH_MARK_FINISH_BUTTON_TASK =
            new ElementTask.Builder(Activity.CLICK, "Device Coach mark Finish").build();
}
