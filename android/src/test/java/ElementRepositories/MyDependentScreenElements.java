package ElementRepositories;

import Actions.Activity;
import Actions.ElementTask;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;

public class MyDependentScreenElements {

    /*Edit Profile Button*/
    public static final By MY_DEPENDENT_PLUS_BUTTON = AppiumBy.accessibilityId("Add Dependent");
    public static final ElementTask MY_DEPENDENT_PLUS_BUTTON_TASK =
            new ElementTask.Builder(Activity.CLICK, "Add dependent +").build();


    /*Burger menu*/
    public static final By DEPENDENT_BURGER_MENU= AppiumBy.id("com.heartmonitor.android:id/imgMenu");
    public static final ElementTask DEPENDENT_BURGER_MENU_TASK =
            new ElementTask.Builder(Activity.CLICK, "Dependent burger menu").build();

    /*Edit profile option*/
    public static final By DEPENDENT_EDIT_PROFILE_OPTION= AppiumBy.androidUIAutomator("new UiSelector().text(\"Edit Profile\")");
    public static final ElementTask DEPENDENT_EDIT_PROFILE_OPTION_TASK =
            new ElementTask.Builder(Activity.CLICK, "Dependent Edit option").build();

    /*Health report option*/
    public static final By DEPENDENT_HEALTH_REPORT_OPTION= AppiumBy.androidUIAutomator("new UiSelector().text(\"Health Report\")");
    public static final ElementTask DEPENDENT_HEALTH_REPORT_OPTION_TASK =
            new ElementTask.Builder(Activity.CLICK, "Dependent Health report").build();

    /*Edit profile option*/
    public static final By DEPENDENT_DELETE_OPTION= AppiumBy.androidUIAutomator("new UiSelector().text(\"Delete\")");
    public static final ElementTask DEPENDENT_DELETE_OPTION_TASK =
            new ElementTask.Builder(Activity.VERIFY, "Dependent Delete option").build();

}
