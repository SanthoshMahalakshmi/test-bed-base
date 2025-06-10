package iOSElemenRepositories;

import Actions.iOSActionType;
import Actions.iOSElementTask;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;

public class iOSEditProfilePage5Elements {

    /*Select birthdate label*/
    public static final By iOS_SELECT_BIRTH_DATE_LABEL = AppiumBy.accessibilityId("Select Birth Date");
    public static final iOSElementTask iOS_SELECT_BIRTH_DATE_LABEL_TASK =
            new iOSElementTask.Builder(iOSActionType.VERIFY, "Select Birth Date").build();

    /*Select Date scroll*/
    public static final By iOS_BIRTH_DATE_SCROLL_BAR = AppiumBy.iOSClassChain("**/XCUIElementTypePickerWheel[`value == \"19\"`]");
    public static final iOSElementTask iOS_BIRTH_DATE_SCROLL_BAR_TASK =
            new iOSElementTask.Builder(iOSActionType.VERIFY, "Date Scroll Bar").build();

    /*Select Date scroll*/
    public static final By iOS_BIRTH_MONTH_SCROLL_BAR = AppiumBy.iOSClassChain("**/XCUIElementTypePickerWheel[`value == \"Dec\"`]");
    public static final iOSElementTask iOS_BIRTH_MONTH_SCROLL_BAR_TASK =
            new iOSElementTask.Builder(iOSActionType.VERIFY, "Month Scroll Bar").build();

    /*Select Date scroll*/
    public static final By iOS_BIRTH_YEAR_SCROLL_BAR = AppiumBy.iOSClassChain("**/XCUIElementTypePickerWheel[`value == \"1996\"`]");
    public static final iOSElementTask iOS_BIRTH_YEAR_SCROLL_BAR_TASK =
            new iOSElementTask.Builder(iOSActionType.VERIFY, "Year Scroll Bar").build();
}
