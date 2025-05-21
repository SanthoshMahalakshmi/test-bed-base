package ElementRepositories;

import Actions.Activity;
import Actions.ElementTask;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;

public class EditProfilePage4Elements {
    /*Weight Selection page.*/
    /*Select weight label*/
    public static final By SELECT_WEIGHT_LABEL = AppiumBy.id("com.heartmonitor.android:id/txtTitle");
    public static final ElementTask SELECT_WEIGHT_LABEL_TASK =
            new ElementTask.Builder(Activity.VERIFY, "Select Weight label").build();

    /*Selected Weight value*/
    public static final By WEIGHT_VALUE = AppiumBy.id("com.heartmonitor.android:id/txtHeightValue");
    public static final ElementTask WEIGHT_VALUE_TASK =
            new ElementTask.Builder(Activity.VERIFY, "Weight value").build();

    /*Scroll bar for Weight value selection*/
    public static final By WEIGHT_SCROLL_BAR = AppiumBy.id("com.heartmonitor.android:id/scaleNumberPicker");
    public static final ElementTask WEIGHT_SCROLL_BAR_TASK =
            new ElementTask.Builder(Activity.VERIFY, "Weight Scroll bar").build();
}
