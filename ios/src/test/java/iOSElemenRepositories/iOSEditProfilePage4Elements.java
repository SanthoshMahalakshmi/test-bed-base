package iOSElemenRepositories;

import Actions.iOSActionType;
import Actions.iOSElementTask;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;

public class iOSEditProfilePage4Elements {

    /*Select weight label*/
    public static final By iOS_SELECT_WEIGHT_LABEL = AppiumBy.accessibilityId("Select Weight");
    public static final iOSElementTask iOS_SELECT_WEIGHT_LABEL_TASK =
            new iOSElementTask.Builder(iOSActionType.VERIFY, "Select Weight Label" ).build();

    /*Selected Weight value*/
    public static final By iOS_WEIGHT_VALUE = AppiumBy.accessibilityId("60 kg");
    public static final iOSElementTask iOS_WEIGHT_VALUE_TASK =
            new iOSElementTask.Builder(iOSActionType.VERIFY, "Selected Weight value" ).build();

    /*Scroll bar for Weight value selection*/
    public static final By iOS_WEIGHT_SCROLL_BAR = AppiumBy.accessibilityId("ic_selection_w");
    public static final iOSElementTask iOS_WEIGHT_SCROLL_BAR_TASK =
            new iOSElementTask.Builder(iOSActionType.VERIFY, "Weight Selection Scroll bar" ).build();
}
