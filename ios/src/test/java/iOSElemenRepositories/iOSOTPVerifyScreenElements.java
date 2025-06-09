package iOSElemenRepositories;

import Actions.iOSActionType;
import Actions.iOSElementTask;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;

public class iOSOTPVerifyScreenElements {

    /*Verify mobile number label*/
    public static final By iOS_VERIFY_MOBILE_NUMBER_LABEL = AppiumBy.accessibilityId("Verify Mobile Number");
    public static final iOSElementTask iOS_VERIFY_MOBILE_NUMBER_LABEL_TASK =
            new iOSElementTask.Builder(iOSActionType.VERIFY, "Verify mobile number label").build();

    /*OTP Fields*/
    public static final By[] iOS_OTP_FIELDS = {
            AppiumBy.xpath("//XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTextField[1]"),
            AppiumBy.xpath("//XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTextField[2]"),
            AppiumBy.xpath("//XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTextField[3]"),
            AppiumBy.xpath("//XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTextField[4]"),
            AppiumBy.xpath("//XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTextField[5]"),
            AppiumBy.xpath("//XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTextField[6]")
    };

    /*Resend Label*/
    public static final By iOS_RESEND_LABEL = AppiumBy.iOSClassChain("**/XCUIElementTypeStaticText[`name == \"Resend OTP\"`]");
    public static final iOSElementTask iOS_RESEND_LABEL_TASK =
            new iOSElementTask.Builder(iOSActionType.VERIFY, "Resend").build();

    /*OTP Verify*/
    public static final By iOS_OTP_VERIFY_BUTTON = AppiumBy.iOSClassChain("**/XCUIElementTypeButton[`name == \"Verify OTP\"`]");
    public static final iOSElementTask iOS_OTP_VERIFY_BUTTON_TASK =
            new iOSElementTask.Builder(iOSActionType.CLICK, "Verify OTP btn").build();
}
