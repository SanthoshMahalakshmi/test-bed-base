package iOSElemenRepositories;

import Actions.iOSActionType;
import Actions.iOSElementTask;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;

public class iOSEditProfilePage1Elements {

    public static final By iOS_PROFILE_PICTURE_OPTION = AppiumBy.accessibilityId("ic addimage");
    public static final iOSElementTask iOS_PROFILE_PICTURE_OPTION_TASK =
            new iOSElementTask.Builder(iOSActionType.VERIFY, "profile picture option").build();


    public static final By iOS_FULL_NAME_INPUT_FIELD = AppiumBy.iOSClassChain("**/XCUIElementTypeTextField[`value == \"Viratkohli\"`]");
    public static final iOSElementTask iOS_FULL_NAME_INPUT_FIELD_TASK =
            new iOSElementTask.Builder(iOSActionType.VERIFY, "User: Full name input Field").build();


    public static final By iOS_EMAIL_ID_INPUT_FIELD = AppiumBy.iOSClassChain("**/XCUIElementTypeTextField[`value == \"san@gmail.coom\"`]");
    public static final iOSElementTask iOS_EMAIL_ID_INPUT_FIELD_TASK =
            new iOSElementTask.Builder(iOSActionType.VERIFY, "User:Email Input Field.").build();


    public static final By iOS_MOBILE_NUMBER_INPUT_FIELD = AppiumBy.iOSClassChain("**/XCUIElementTypeTextField[`value == \"9087631080\"`]");
    public static final iOSElementTask iOS_MOBILE_NUMBER_INPUT_FIELD_TASK =
            new iOSElementTask.Builder(iOSActionType.VERIFY, "User: Mobile number field.").build();
}
