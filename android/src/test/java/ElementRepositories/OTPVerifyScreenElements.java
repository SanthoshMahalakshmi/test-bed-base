package ElementRepositories;

import Actions.Activity;
import Actions.ElementTask;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;

public class OTPVerifyScreenElements {

    /*Verify Mobile Number.*/
    public static final By VERIFY_MOBILE_NUMBER_LABEL = AppiumBy.id("com.heartmonitor.android:id/txtPhoneLabel");
    public static final ElementTask VERIFY_MOBILE_NUMBER_LABEL_TASK =
            new ElementTask.Builder(Activity.VERIFY, "Verify mobile Number label").build();

    /*OTP Fields*/
    public static final By[] OTP_FIELDS = {
            AppiumBy.id("com.heartmonitor.android:id/editTextOTP1"),
            AppiumBy.id("com.heartmonitor.android:id/editTextOTP2"),
            AppiumBy.id("com.heartmonitor.android:id/editTextOTP3"),
            AppiumBy.id("com.heartmonitor.android:id/editTextOTP4"),
            AppiumBy.id("com.heartmonitor.android:id/editTextOTP5"),
            AppiumBy.id("com.heartmonitor.android:id/editTextOTP6")
    };

    /*Resend Label*/
    public static final By RESEND_LABEL = AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(resourceId(\"com.heartmonitor.android:id/txtResend\"));");
    public static final ElementTask RESEND_LABEL_TASK =
            new ElementTask.Builder(Activity.VERIFY, "Resend Label").build();

    /*Verify Button*/
    public static final By OTP_VERIFY_BUTTON = AppiumBy.id("com.heartmonitor.android:id/txtVerify");
    public static final ElementTask OTP_VERIFY_BUTTON_TASK =
            new ElementTask.Builder(Activity.CLICK, "Verify OTP").build();
}
