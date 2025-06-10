package iOSElemenRepositories;

import Actions.iOSActionType;
import Actions.iOSElementTask;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;

public class iOSEditProfilePage2Elements {

    /**
     * iOS Edit Profile Page (Step 2) Elements Repository.
     *
     * This page object holds all the elements used in the second step of the "Edit Profile" flow,
     * specifically for selecting gender on iOS devices.
     *
     * Elements on this screen:
     * - Female Logo/Profile Option
     *
     * Action Types:
     * - Taps on the Profile option (used to represent the Female avatar).
     */

    /*Female option logo element*/
    public static final By iOS_FEMALE_LOGO_ELEMENT = AppiumBy.accessibilityId("ic_female_g");
    public static final iOSElementTask iOS_FEMALE_LOGO_ELEMENT_TASK =
            new iOSElementTask.Builder(iOSActionType.CLICK, "Female Option").build();

    /*Male option logo element*/
    public static final By iOS_MALE_LOGO_ELEMENT = AppiumBy.xpath("//XCUIElementTypeImage[@name=\"ic_male\"]");
    public static final iOSElementTask iOS_MALE_LOGO_ELEMENT_TASK =
            new iOSElementTask.Builder(iOSActionType.CLICK, "Male Option").build();

    /*Other option logo element*/
    public static final By iOS_OTHER_LOGO_ELEMENT = AppiumBy.accessibilityId("ic_other_g");
    public static final iOSElementTask iOS_OTHER_LOGO_ELEMENT_TASK =
            new iOSElementTask.Builder(iOSActionType.CLICK, "Others Option").build();
}
