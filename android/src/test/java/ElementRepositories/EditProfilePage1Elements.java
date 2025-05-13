package ElementRepositories;

import Actions.Activity;
import Actions.ElementTask;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;

public class EditProfilePage1Elements {

    /*Basic Details Page Elements.*/
    /*Profile Picture*/
    public static final By PROFILE_PICTURE_OPTION = AppiumBy.id("com.heartmonitor.android:id/imgPickProfile");
    public static final ElementTask PROFILE_PICTURE_OPTION_TASK =
            new ElementTask.Builder(Activity.VERIFY, "Profile picture option").build();

    /*Camera Option for profile picture set.*/
    public static final By CAMERA_OPTION = AppiumBy.androidUIAutomator("new UiSelector().text(\"Camera\")");
    public static final ElementTask CAMERA_OPTION_TASK =
            new ElementTask.Builder(Activity.VERIFY, "Camera option").build();

    /*Gallery Option for profile picture set.*/
    public static final By GALLERY_OPTION = AppiumBy.androidUIAutomator("new UiSelector().text(\"Gallery\")");
    public static final ElementTask GALLERY_OPTION_TASK =
            new ElementTask.Builder(Activity.VERIFY, "Gallery option").build();

    /*Cancel Option for profile picture set.*/
    public static final By CANCEL_BUTTON = AppiumBy.id("new UiSelector().text(\"Gallery\")");
    public static final ElementTask CANCEL_BUTTON_TASK =
            new ElementTask.Builder(Activity.CLICK, "Cancel Button").build();

    /*Full name input field.*/
    public static final By FULL_NAME_INPUT_FIELD = AppiumBy.id("com.heartmonitor.android:id/edtFullName");
    public static final ElementTask FULL_NAME_INPUT_FIELD_TASK =
            new ElementTask.Builder(Activity.SEND_KEYS, "Full name").inputValue("Santhosh MahaLakshmi").build();

    /*Email id input field.*/
    public static final By EMAIL_ID_INPUT_FIELD = AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.heartmonitor.android:id/edtEmail\")");
    public static final ElementTask EMAIL_ID_INPUT_FIELD_TASK =
            new ElementTask.Builder(Activity.SEND_KEYS, "Email id").inputValue("SanthoshMahalakshmi@gmail.com").build();

    /*Mobile Number input field.*/
    public static final By MOBILE_NUMBER_INPUT_FIELD = AppiumBy.id("com.heartmonitor.android:id/edtEmail");
    public static final ElementTask MOBILE_NUMBER_INPUT_FIELD_TASK =
            new ElementTask.Builder(Activity.VERIFY, "Mobile Number").build();
}
