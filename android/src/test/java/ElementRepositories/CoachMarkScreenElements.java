package ElementRepositories;

import Actions.Activity;
import Actions.ElementTask;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;

public class CoachMarkScreenElements {

    /*Coach mark finish button*/
    public static final By COACH_MARK_FINISH_BUTTON = AppiumBy.id("com.heartmonitor.android:id/btnNext");
    public static final ElementTask COACH_MARK_FINISH_BUTTON_TASK =
            new ElementTask.Builder(Activity.CLICK, "Coach Mark: Finish").build();

    /*Coach mark text*/
    public static final By COACH_MARK_TEXT = AppiumBy.id("com.heartmonitor.android:id/tvtest");
    public static final ElementTask COACH_MARK_TEXT_TASK =
            new ElementTask.Builder(Activity.VERIFY, "Coach Mark text").build();

    /*Coach mark next button*/
    public static final By COACH_MARK_NEXT_BUTTON = AppiumBy.id("com.heartmonitor.android:id/btnNext");
    public static final ElementTask COACH_MARK_NEXT_BUTTON_TASK =
            new ElementTask.Builder(Activity.CLICK, "Coach Mark: Next").build();
}
