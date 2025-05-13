package ElementRepositories;

import Actions.Activity;
import Actions.ElementTask;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;

public class EditProfilePage2Elements {
    /*Select Gender page Elements*/
    /*Female logo element*/
    public static final By FEMALE_LOGO_ELEMENT = AppiumBy.id("com.heartmonitor.android:id/imgWoman");
    public static final ElementTask FEMALE_LOGO_ELEMENT_TASK =
            new ElementTask.Builder(Activity.CLICK, "Female Logo.").build();

    /*Male Logo element*/
    public static final By MALE_LOGO_ELEMENT = AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.heartmonitor.android:id/imgMan\")");
    public static final ElementTask MALE_LOGO_ELEMENT_TASK =
            new ElementTask.Builder(Activity.CLICK, "Male Logo.").build();

    /*Others*/
    public static final By OTHERS_LOGO_ELEMENT = AppiumBy.id("com.heartmonitor.android:id/imgMan");
    public static final ElementTask OTHERS_LOGO_ELEMENT_TASK =
            new ElementTask.Builder(Activity.CLICK, "others Logo.").build();
}
