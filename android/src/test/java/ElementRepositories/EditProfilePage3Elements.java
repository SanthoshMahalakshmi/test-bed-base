package ElementRepositories;

import Actions.Activity;
import Actions.ElementTask;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;

public class EditProfilePage3Elements {

    /*Select height label*/
    public static final By SELECT_HEIGHT_LABEL = AppiumBy.id("com.heartmonitor.android:id/txtTitle");
    public static final ElementTask SELECT_HEIGHT_LABEL_TASK =
            new ElementTask.Builder(Activity.VERIFY, "Select height label").build();

    /*Selected height value*/
    public static final By HEIGHT_VALUE = AppiumBy.id("com.heartmonitor.android:id/txtHeightValue");
    public static final ElementTask HEIGHT_VALUE_TASK =
            new ElementTask.Builder(Activity.VERIFY, "height value").build();

    /*Height Scroll bar*/
    public static final By HEIGHT_SCROLLBAR = AppiumBy.id("com.heartmonitor.android:id/scaleNumberPicker");
    public static final ElementTask HEIGHT_SCROLLBAR_TASK =
            new ElementTask.Builder(Activity.VERIFY, "height Scroll Bar").build();

    /*Selected Gender Logo.*/
    public static final By SELECTED_GENDER_LOGO = AppiumBy.id("com.heartmonitor.android:id/imgUserImage");
    public static final ElementTask SELECTED_GENDER_LOGO_TASK =
            new ElementTask.Builder(Activity.VERIFY, "Selected gender Logo").build();
}
