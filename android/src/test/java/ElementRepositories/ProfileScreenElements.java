package ElementRepositories;

import Actions.Activity;
import Actions.ElementTask;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;

public class ProfileScreenElements {

    /*Profile button*/
    public static final By PROFILE_BUTTON = AppiumBy.accessibilityId("Profile");
    public static final ElementTask PROFILE_BUTTON_TASK =
            new ElementTask.Builder(Activity.CLICK, "Profile option").build();

    /*Profile Page Coach mark Skip.*/
    public static final By PROFILE_COACH_MARK_SKIP = AppiumBy.id("com.heartmonitor.android:id/tvSkip");
    public static final ElementTask PROFILE_COACH_MARK_SKIP_TASK =
            new ElementTask.Builder(Activity.CLICK, "Profile screen coach mark Skip").build();

    /*Edit Profile Button*/
    public static final By EDIT_PROFILE_BUTTON = AppiumBy.id("com.heartmonitor.android:id/txtEditProfile");
    public static final ElementTask EDIT_PROFILE_BUTTON_TASK =
            new ElementTask.Builder(Activity.CLICK, "Edit Profile").build();

    /*Edit Profile Button*/
    public static final By CONSUME_EDIT_BUTTON = AppiumBy.id("com.heartmonitor.android:id/editConsume");
    public static final ElementTask CONSUME_EDIT_BUTTON_TASK =
            new ElementTask.Builder(Activity.CLICK, "Consume Edit").build();

    /*Edit Profile Button*/
    public static final By MY_DEPENDENT_BUTTON = AppiumBy.id("com.heartmonitor.android:id/txtMyDependent");
    public static final ElementTask MY_DEPENDENT_BUTTON_TASK =
            new ElementTask.Builder(Activity.CLICK, "My dependent").build();
















}

