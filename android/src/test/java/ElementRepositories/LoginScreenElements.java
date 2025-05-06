package ElementRepositories;

import Actions.Activity;
import Actions.ElementTask;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;

public class LoginScreenElements {
    /*Login or sign up label*/
    public static final By LOGIN_OR_SIGNUP_LABEL = AppiumBy.id("com.heartmonitor.android:id/txtPhoneLabel");
    public static final ElementTask LOGIN_OR_SIGNUP_LABEL_TASK =
            new ElementTask.Builder(Activity.VERIFY, "Login or SignUp").build();

    /*Mobile Number field.*/
    public static final By MOBILE_NUMBER_FIELD = AppiumBy.id("com.heartmonitor.android:id/edtMobileNumber");
    public static final ElementTask MOBILE_NUMBER_FIELD_TASK =
            new ElementTask.Builder(Activity.SEND_KEYS, "Mobile Number").inputValue("9087631080").build();

    /*Country Code Element.*/
    public static final By COUNTRY_CODE = AppiumBy.id("com.heartmonitor.android:id/textinput_prefix_text");
    public static final ElementTask COUNTRY_CODE_TASK =
            new ElementTask.Builder(Activity.VERIFY, "Country Code").build();

    /*Continue Button.*/
    public static final By CONTINUE_BUTTON = AppiumBy.id("com.heartmonitor.android:id/txtContinue");
    public static final ElementTask CONTINUE_BUTTON_TASK =
            new ElementTask.Builder(Activity.CLICK, "Continue").build();

    /*Terms and condition Link*/
    public static final By TERMS_AND_CONDITION_LINK = AppiumBy.id("com.heartmonitor.android:id/txtTerms");
    public static final ElementTask TERMS_AND_CONDITION_LINK_TASK =
            new ElementTask.Builder(Activity.CLICK, "Terms And Condition link").build();

    /*Privacy Policy Link*/
    public static final By PRIVACY_POLICY_LINK = AppiumBy.id("com.heartmonitor.android:id/txtPrivacy");
    public static final ElementTask PRIVACY_POLICY_LINK_TASK =
            new ElementTask.Builder(Activity.CLICK, "Privacy Policy Link").build();

}
