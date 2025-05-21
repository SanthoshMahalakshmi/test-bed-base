package ElementRepositories;

import Actions.Activity;
import Actions.ElementTask;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;

public class CoachMarkScreenElements {

    /*Model close cancel button*/
    public static final By REPORT_FINISH_BUTTON = AppiumBy.id("com.heartmonitor.android:id/btnNext");
    public static final ElementTask REPORT_FINISH_BUTTON_TASK =
            new ElementTask.Builder(Activity.CLICK, "Report Section: Finish").build();
}
