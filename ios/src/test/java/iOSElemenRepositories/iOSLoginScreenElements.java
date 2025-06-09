package iOSElemenRepositories;

import Actions.iOSActionType;
import Actions.iOSElementTask;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;

public class iOSLoginScreenElements {

    /*User name */
    public static final By iOS_MOBILE_NUMBER_FIELD = AppiumBy.iOSClassChain("**/XCUIElementTypeTextField[`value == \"9999999999\"`]");
    public static final iOSElementTask iOS_MOBILE_NUMBER_FIELD_TASK =
            new iOSElementTask.Builder(iOSActionType.CLICK, "9087631080").build();

    /*Country Code */
    public static final By iOS_COUNTRY_CODE = AppiumBy.iOSClassChain("**/XCUIElementTypeTextField[`value == \"+91\"`]");
    public static final iOSElementTask iOS_COUNTRY_CODE_TASK =
            new iOSElementTask.Builder(iOSActionType.VERIFY, "Country Code").build();

    /*Terms and Condition*/
    public static final By iOS_TERMS_AND_CONDITION_LINK = AppiumBy.iOSClassChain("**/XCUIElementTypeButton[`name == \"By continuing, you agree to our  Terms & Conditions and Privacy Policy\"`]");
    public static final iOSElementTask iOS_TERMS_AND_CONDITION_LINK_TASK =
            new iOSElementTask.Builder(iOSActionType.VERIFY, "pp").build();

    /*Privacy Policy*/
    public static final By iOS_PRIVACY_POLICY_LINK = AppiumBy.xpath("//XCUIElementTypeButton[@name=\"By continuing, you agree to our  Terms & Conditions and Privacy Policy\"]");
    public static final iOSElementTask iOS_PRIVACY_POLICY_LINK_TASK =
            new iOSElementTask.Builder(iOSActionType.VERIFY, "Privacy Policy").build();

    /*Continue Button*/
    public static final By iOS_CONTINUE_BTN = AppiumBy.iOSClassChain("**/XCUIElementTypeButton[`name == \"Continue\"`]");
    public static final iOSElementTask iOS_CONTINUE_BTN_TASK =
            new iOSElementTask.Builder(iOSActionType.CLICK, "Continue").build();
}
