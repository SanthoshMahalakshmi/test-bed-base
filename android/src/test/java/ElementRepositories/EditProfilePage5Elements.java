package ElementRepositories;

import Actions.Activity;
import Actions.ElementTask;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;

public class EditProfilePage5Elements {
    /*Select birth Date page.*/

    /*Select birthdate label*/
    public static final By SELECT_BIRTH_DATE_LABEL = AppiumBy.id("com.heartmonitor.android:id/txtTitle");
    public static final ElementTask SELECT_BIRTH_DATE_LABEL_TASK =
            new ElementTask.Builder(Activity.VERIFY, "Select Birth date label").build();

    /*Select Date scroll*/
    public static final By BIRTH_DATE_SCROLL_BAR = AppiumBy.id("com.heartmonitor.android:id/npDate");
    public static final ElementTask BIRTH_DATE_SCROLL_BAR_TASK =
            new ElementTask.Builder(Activity.VERIFY, "Birth date scroll bar").build();

    /*Select Date scroll*/
    public static final By BIRTH_MONTH_SCROLL_BAR = AppiumBy.id("com.heartmonitor.android:id/npMonth");
    public static final ElementTask BIRTH_MONTH_SCROLL_BAR_TASK =
            new ElementTask.Builder(Activity.VERIFY, "Birth Month scroll bar").build();

    /*Select Date scroll*/
    public static final By BIRTH_YEAR_SCROLL_BAR = AppiumBy.id("com.heartmonitor.android:id/npYear");
    public static final ElementTask BIRTH_YEAR_SCROLL_BAR_TASK =
            new ElementTask.Builder(Activity.VERIFY, "Birth year scroll bar").build();
}
