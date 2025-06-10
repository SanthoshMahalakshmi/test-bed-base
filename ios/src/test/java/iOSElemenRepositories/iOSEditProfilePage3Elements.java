package iOSElemenRepositories;

import Actions.iOSActionType;
import Actions.iOSElementTask;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;

public class iOSEditProfilePage3Elements {

    /*Select height label*/
    public static final By iOS_SELECT_HEIGHT_LABEL = AppiumBy.accessibilityId("Select Height");
    public static final iOSElementTask iOS_SELECT_HEIGHT_LABEL_TASK =
            new iOSElementTask.Builder(iOSActionType.VERIFY, "Select Height Label").build();

    /*Selected height value*/
    public static final By iOS_HEIGHT_VALUE = AppiumBy.accessibilityId("5 ft. 2 in.");
    public static final iOSElementTask iOS_HEIGHT_VALUE_TASK =
            new iOSElementTask.Builder(iOSActionType.VERIFY, " Current Selected Height Value").build();

    /*Height Scroll bar*/
    public static final By iOS_HEIGHT_SCROLLBAR = AppiumBy.xpath("//XCUIElementTypeScrollView/XCUIElementTypeOther");
    public static final iOSElementTask iOS_HEIGHT_SCROLLBAR_TASK =
            new iOSElementTask.Builder(iOSActionType.VERIFY, "Height Scroll bar option").build();

    /*Selected Gender Logo.*/
    public static final By iOS_SELECTED_GENDER_LOGO = AppiumBy.accessibilityId("ic_male_full");
    public static final iOSElementTask iOS_SELECTED_GENDER_LOGO_TASK =
            new iOSElementTask.Builder(iOSActionType.VERIFY, "Selected Gender Logo: Male Or Female" ).build();
}
