package iOSElemenRepositories;

import Actions.iOSActionType;
import Actions.iOSElementTask;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;

public class iOSSplashScreenElements {

    /*Title logo os the application */
    public static final By iOS_TITLE_LOGO_IMAGE = AppiumBy.iOSClassChain("**/XCUIElementTypeImage[`name == \"Monitor\"`]");
    public static final iOSElementTask iOS_TITLE_LOGO_IMAGE_TASK =
            new iOSElementTask.Builder(iOSActionType.VERIFY, "Logo").build();

    /*User name */
    public static final By iOS_USERNAME = AppiumBy.iOSClassChain("**/XCUIElementTypeTextField[`value == \"9999999999\"`]");
    public static final iOSElementTask iOS_USERNAME_TASK =
            new iOSElementTask.Builder(iOSActionType.SEND_KEYS, "9087631080").build();

    /*Get Started*/
    public static final By iOS_GET_STARTED_BTN = AppiumBy.iOSClassChain("**/XCUIElementTypeButton[`name == \"Get Started\"`]");
    public static final iOSElementTask iOS_GET_STARTED_BTN_TASK =
            new iOSElementTask.Builder(iOSActionType.CLICK, "Get Started").build();

    /*Splash Text-1*/
    public static final By iOS_SPLASHSCREEN_DESCRIPTION_1 = AppiumBy.accessibilityId("Keep track of your own and your family’s health and well-being");
    public static final iOSElementTask iOS_SPLASHSCREEN_DESCRIPTION_1_TASK =
            new iOSElementTask.Builder(iOSActionType.VERIFY, "Splash Screen Text-1").build();

    /*Splash Text-2*/
    public static final By iOS_SPLASHSCREEN_DESCRIPTION_2 = AppiumBy.accessibilityId("Get granular insights about each health parameter");
    public static final iOSElementTask iOS_SPLASHSCREEN_DESCRIPTION_2_TASK =
            new iOSElementTask.Builder(iOSActionType.VERIFY, "Splash Screen Text-2").build();

    /*Splash Text-3*/
    public static final By iOS_SPLASHSCREEN_DESCRIPTION_3 = AppiumBy.accessibilityId("Keep watch over your loved one’s health");
    public static final iOSElementTask iOS_SPLASHSCREEN_DESCRIPTION_3_TASK =
            new iOSElementTask.Builder(iOSActionType.VERIFY, "Splash Screen Text-3").build();

    /*Next*/
    public static final By iOS_NEXT_BTN = AppiumBy.iOSClassChain("**/XCUIElementTypeStaticText[`name == \"Next\"`]");
    public static final iOSElementTask iOS_NEXT_BTN_TASK =
            new iOSElementTask.Builder(iOSActionType.CLICK, "Next").build();

}


