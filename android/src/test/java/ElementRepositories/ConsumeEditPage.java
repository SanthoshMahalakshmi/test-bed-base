package ElementRepositories;

import Actions.Activity;
import Actions.ElementTask;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;

public class ConsumeEditPage {

    /*Do you consume Alcohol*/
    public static final By DO_YOU_CONSUME_ALCOHOL_LABEL = AppiumBy.id("com.heartmonitor.android:id/txtTitle");
    public static final ElementTask DO_YOU_CONSUME_ALCOHOL_LABEL_TASK =
            new ElementTask.Builder(Activity.VERIFY, "Do you consume alcohol label").build();

    /*Alcohol Yes*/
    public static final By ALCOHOL_YES_BUTTON = AppiumBy.id("com.heartmonitor.android:id/txtAlcoholYes");
    public static final ElementTask ALCOHOL_YES_BUTTON_TASK =
            new ElementTask.Builder(Activity.CLICK, "Yes for alcohol").build();

    /*Alcohol No*/
    public static final By ALCOHOL_NO_BUTTON = AppiumBy.id("com.heartmonitor.android:id/txtAlcoholNo");
    public static final ElementTask ALCOHOL_NO_BUTTON_TASK =
            new ElementTask.Builder(Activity.CLICK, "No for alcohol").build();

    /*Alcohol Occasionally*/
    public static final By ALCOHOL_OCCASIONALLY_BUTTON = AppiumBy.id("com.heartmonitor.android:id/txtAlcoholOther");
    public static final ElementTask ALCOHOL_OCCASIONALLY_BUTTON_TASK =
            new ElementTask.Builder(Activity.CLICK, "occasionally alcohol").build();

    /*Do you Smoke Alcohol*/
    public static final By DO_YOU_SMOKE_LABEL = AppiumBy.id("com.heartmonitor.android:id/titleSmoke");
    public static final ElementTask DO_YOU_SMOKE_LABEL_TASK =
            new ElementTask.Builder(Activity.VERIFY, "Do you smoke label").build();

    /*Smoke Yes*/
    public static final By SMOKE_YES_BUTTON = AppiumBy.id("com.heartmonitor.android:id/txtSmokeYes");
    public static final ElementTask SMOKE_YES_BUTTON_TASK =
            new ElementTask.Builder(Activity.CLICK, "Yes for smoke").build();

    /*Smoke No*/
    public static final By SMOKE_NO_BUTTON = AppiumBy.id("com.heartmonitor.android:id/txtSmokeNo");
    public static final ElementTask SMOKE_NO_BUTTON_TASK =
            new ElementTask.Builder(Activity.CLICK, "No for smoke").build();

    /*Smoke Occasionally*/
    public static final By SMOKE_OCCASIONALLY_BUTTON = AppiumBy.id("com.heartmonitor.android:id/txtSmokeOther");
    public static final ElementTask SMOKE_OCCASIONALLY_BUTTON_TASK =
            new ElementTask.Builder(Activity.CLICK, "occasionally for smoke").build();

}
