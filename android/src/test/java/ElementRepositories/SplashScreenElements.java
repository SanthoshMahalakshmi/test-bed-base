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

    /*Splash Screen slide-1*/
    public static final By SPLASH_SCREEN_SLIDE_1 = AppiumBy.id("com.heartmonitor.android:id/images");
    public static final ElementTask SPLASH_SCREEN_SLIDE_1_TASK =
            new ElementTask.Builder(Activity.VERIFY, "1st slide of the splash screen").build();

    /*Splash Screen slide-2*/
    public static final By SPLASH_SCREEN_SLIDE_2 = AppiumBy.id("com.heartmonitor.android:id/images");
    public static final ElementTask SPLASH_SCREEN_SLIDE_2_TASK =
            new ElementTask.Builder(Activity.VERIFY, "2nd slide of the splash screen").build();

    /*Splash Screen slide-3*/
    public static final By SPLASH_SCREEN_SLIDE_3 = AppiumBy.id("com.heartmonitor.android:id/images");
    public static final ElementTask SPLASH_SCREEN_SLIDE_3_TASK =
            new ElementTask.Builder(Activity.VERIFY, "3rd slide of the splash screen").build();

    /*1st next Button*/
    public static final By NEXT_BUTTON_1 = AppiumBy.id("com.heartmonitor.android:id/txtGetStart");
    public static final ElementTask NEXT_BUTTON_1_TASK =
            new ElementTask.Builder(Activity.CLICK, "1st next").build();

    /*2nd Next Button*/
    public static final By NEXT_BUTTON_2 = AppiumBy.id("com.heartmonitor.android:id/txtGetStart");
    public static final ElementTask NEXT_BUTTON_2_TASK =
            new ElementTask.Builder(Activity.CLICK, "2nd next").build();

    /*Get started Button*/
    public static final By GET_STARTED_BUTTON = AppiumBy.id("com.heartmonitor.android:id/txtGetStart");
    public static final ElementTask GET_STARTED_TASK =
            new ElementTask.Builder(Activity.CLICK, "Get Started").build();

    /*Description-1*/
    public static final By SPLASHSCREEN_DESCRIPTION_1 = AppiumBy.id("com.heartmonitor.android:id/txtDescription");
    public static final ElementTask SPLASHSCREEN_DESCRIPTION_1_TASK =
            new ElementTask.Builder(Activity.VERIFY, "Description 1").build();

    /*Description-2*/
    public static final By SPLASHSCREEN_DESCRIPTION_2 = AppiumBy.id("com.heartmonitor.android:id/txtDescription");
    public static final ElementTask SPLASHSCREEN_DESCRIPTION_2_TASK =
            new ElementTask.Builder(Activity.VERIFY, "Description 2").build();

    /*Description-3*/
    public static final By SPLASHSCREEN_DESCRIPTION_3 = AppiumBy.id("com.heartmonitor.android:id/txtDescription");
    public static final ElementTask SPLASHSCREEN_DESCRIPTION_3_TASK =
            new ElementTask.Builder(Activity.VERIFY, "Description 3").build();
}
