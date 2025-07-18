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

    /*Skip in splash Screen*/
    public static final By SPLASH_SCREEN_SKIP_BUTTON = AppiumBy.id("com.heartmonitor.android:id/txtSkip");
    public static final ElementTask SPLASH_SCREEN_SKIP_BUTTON_TASK =
            new ElementTask.Builder(Activity.VERIFY, "Splash screen skip").build();

    /*Splash Screen slide*/
    public static final By SPLASH_SCREEN_SLIDE = AppiumBy.id("com.heartmonitor.android:id/images");
    public static final ElementTask SPLASH_SCREEN_SLIDE_TASK =
            new ElementTask.Builder(Activity.VERIFY, "Splash Screen slides").build();

    /*1st next Button*/
    public static final By NEXT_BUTTON = AppiumBy.id("com.heartmonitor.android:id/txtGetStart");
    public static final ElementTask NEXT_BUTTON_TASK =
            new ElementTask.Builder(Activity.CLICK, "Next").build();

    /*Get started Button*/
    public static final By GET_STARTED_BUTTON = AppiumBy.id("com.heartmonitor.android:id/txtGetStart");
    public static final ElementTask GET_STARTED_TASK =
            new ElementTask.Builder(Activity.CLICK, "Get Started").build();

    /*Description-1*/
    public static final By SPLASHSCREEN_DESCRIPTION = AppiumBy.id("com.heartmonitor.android:id/txtDescription");
    public static final ElementTask SPLASHSCREEN_DESCRIPTION_TASK =
            new ElementTask.Builder(Activity.VERIFY, "Description").build();

}
