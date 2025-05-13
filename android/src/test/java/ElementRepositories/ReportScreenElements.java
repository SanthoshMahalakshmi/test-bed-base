package ElementRepositories;

import Actions.Activity;
import Actions.ElementTask;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;

public class ReportScreenElements {

    /*Blood pressure*/
    public static final By BLOOD_PRESSURE_TAB = AppiumBy.androidUIAutomator("new UiSelector().text(\"Blood Pressure\")");
    public static final ElementTask BLOOD_PRESSURE_TAB_TASK =
            new ElementTask.Builder(Activity.CLICK, "dependent user").build();

    /*Download button*/
    public static final By DOWNLOAD_BUTTON = AppiumBy.androidUIAutomator("new UiSelector().text(\"Blood Pressure\")");
    public static final ElementTask DOWNLOAD_BUTTON_TASK =
            new ElementTask.Builder(Activity.VERIFY, "Download in report section").build();

    /*Finish button*/
    public static final By COACH_MARK_FINISH_BUTTON = AppiumBy.id("com.heartmonitor.android:id/btnNext");
    public static final ElementTask COACH_MARK_FINISH_BUTTON_TASK =
            new ElementTask.Builder(Activity.CLICK, "Coach mark finish").build();


}
