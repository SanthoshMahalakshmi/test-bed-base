package ElementRepositories;

import Actions.Activity;
import Actions.ElementTask;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;

public class FeedBackScreenElements {

    /*Send feedBack Label*/
    public static final By SEND_FEEDBACK_LABEL = AppiumBy.androidUIAutomator("new UiSelector().text(\"Send Feedback\")");
    public static final ElementTask SEND_FEEDBACK_LABEL_TASK =
            new ElementTask.Builder(Activity.VERIFY, "Send FeedBack Label").build();

    /*Subject input field*/
    public static final By SUBJECT_INPUT_FIELD = AppiumBy.id("com.heartmonitor.android:id/etSubject");
    public static final ElementTask SUBJECT_INPUT_FIELD_TASK =
            new ElementTask.Builder(Activity.SEND_KEYS, "Subject input field").inputValue("Glitch on report").build();

    /*Feed back type*/
    public static final By FEEDBACK_TYPE = AppiumBy.id("com.heartmonitor.android:id/feedbackType");
    public static final ElementTask FEEDBACK_TYPE_TASK =
            new ElementTask.Builder(Activity.CLICK, "Subject input field").build();

    /*option PERFORMANCE*/
    public static final By FEEDBACK_OPTION_PERFORMANCE = AppiumBy.androidUIAutomator("new UiSelector().text(\"Performance\")");
    public static final ElementTask FEEDBACK_OPTION_PERFORMANCE_TASK =
            new ElementTask.Builder(Activity.CLICK, "Feedback Option: Performance").build();

    /*option ACCURACY*/
    public static final By FEEDBACK_OPTION_ACCURACY = AppiumBy.androidUIAutomator("new UiSelector().text(\"Accuracy\")");
    public static final ElementTask FEEDBACK_OPTION_ACCURACY_TASK =
            new ElementTask.Builder(Activity.CLICK, "Feedback Option: Accuracy").build();

    /*option Functional*/
    public static final By FEEDBACK_OPTION_FUNCTIONAL = AppiumBy.androidUIAutomator("new UiSelector().text(\"Functional\")");
    public static final ElementTask FEEDBACK_OPTION_FUNCTIONAL_TASK =
            new ElementTask.Builder(Activity.CLICK, "Feedback Option: Functional").build();

    /*option Glitch*/
    public static final By FEEDBACK_OPTION_GLITCH = AppiumBy.androidUIAutomator("new UiSelector().text(\"Glitch\")");
    public static final ElementTask FEEDBACK_OPTION_GLITCH_TASK =
            new ElementTask.Builder(Activity.CLICK, "Feedback Option: Glitch").build();

    /*option Others*/
    public static final By FEEDBACK_OPTION_OTHERS = AppiumBy.androidUIAutomator("new UiSelector().text(\"Others\")");
    public static final ElementTask FEEDBACK_OPTION_OTHERS_TASK =
            new ElementTask.Builder(Activity.CLICK, "Feedback Option: Others").build();

    /*Subject input field*/
    public static final By MESSAGE_INPUT_FIELD = AppiumBy.id("com.heartmonitor.android:id/etMessage");
    public static final ElementTask MESSAGE_INPUT_FIELD_TASK =
            new ElementTask.Builder(Activity.SEND_KEYS, "Message input field").inputValue("Glitch on report").build();

    public static final By PICK_IMAGE_OPTION = AppiumBy.id("com.heartmonitor.android:id/btnPickImage");
    public static final ElementTask PICK_IMAGE_OPTION_TASK =
            new ElementTask.Builder(Activity.VERIFY, "Pick image").build();

    public static final By SEND_FEEDBACK_BUTTON = AppiumBy.id("com.heartmonitor.android:id/btnSendFeedback");
    public static final ElementTask SEND_FEEDBACK_BUTTON_TASK =
            new ElementTask.Builder(Activity.VERIFY, "send Feedback").build();


}
