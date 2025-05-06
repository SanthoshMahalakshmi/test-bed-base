package ElementRepositories;

import Actions.Activity;
import Actions.ElementTask;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;

public class SplashScreenElements {

    /*Title logo os the application */
    public static final By TITLE_LOGO_IMAGE = AppiumBy.id("com.heartmonitor.android:id/txttitle");
    public static final ElementTask TITLE_LOGO_IMAGE_TASK =
            new ElementTask.Builder(Activity.VERIFY, "Logo").build();

    /*Get started Button*/
    public static final By GET_STARTED_BUTTON = AppiumBy.id("com.heartmonitor.android:id/txtGetStart");
    public static final ElementTask GET_STARTED_TASK =
            new ElementTask.Builder(Activity.CLICK, "Get Started").build();

    /*Description*/
    public static final By DESCRIPTION_TEXT = AppiumBy.id("com.heartmonitor.android:id/txtDescription");
    public static final ElementTask DESCRIPTION_TEXT_TASK =
            new ElementTask.Builder(Activity.VERIFY, "Description").build();
}
