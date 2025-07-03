package iOSElemenRepositories;

import Actions.iOSActionType;
import Actions.iOSElementTask;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;

public class iOSCareCircleScreenElements {

    public static final By iOS_DASHBOARD_DEPENDENT_LABEL = AppiumBy.iOSClassChain("");
    public static final iOSElementTask iOS_DASHBOARD_DEPENDENT_LABEL_TASK =
            new iOSElementTask.Builder(iOSActionType.VERIFY, "").build();
}
