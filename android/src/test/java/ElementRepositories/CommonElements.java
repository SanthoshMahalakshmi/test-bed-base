package ElementRepositories;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import Actions.Activity;
import Actions.ElementTask;

public class CommonElements {

    /*Back button.*/
    public static final By BACK_BUTTON = AppiumBy.accessibilityId("Navigate up");
    public static final ElementTask BACK_BUTTON_TASK =
            new ElementTask.Builder(Activity.CLICK, "Back").build();

}
