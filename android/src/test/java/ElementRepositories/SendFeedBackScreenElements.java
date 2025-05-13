package ElementRepositories;

import Actions.Activity;
import Actions.ElementTask;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;

public class SendFeedBackScreenElements {

    /*Send feedBack label*/
    public static final By SEND_FEEDBACK_LABEL = AppiumBy.androidUIAutomator("new UiSelector().text(\"Send Feedback\")");
    public static final ElementTask SEND_FEEDBACK_LABEL_TASK =
            new ElementTask.Builder(Activity.VERIFY, "Send feedback Label").build();
}
