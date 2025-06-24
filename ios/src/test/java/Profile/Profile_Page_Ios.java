package Profile;

import Actions.iOSActionType;
import Actions.iOSElementTask;
import DriverManagerIos.BaseLoginForiOS;
import DriverManagerIos.DriverManager;
import UtilitiesForIos.RetryAnalyzerios;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.LinkedHashMap;
import java.util.Map;

import static UtilitiesForIos.iOSElementActions.performIOSActions;
import static iOSElemenRepositories.iOSCommonElements.*;
import static iOSElemenRepositories.iOSDeviceScreenElements.*;
import static iOSElemenRepositories.iOSProfileScreenElements.*;

public class Profile_Page_Ios extends DriverManager {

    BaseLoginForiOS baseLoginForiOS = new BaseLoginForiOS();

    @Test(retryAnalyzer = RetryAnalyzerios.class)
    public void TC_029() {

        baseLoginForiOS.BaseLoginForIos(false);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        Map<By, iOSElementTask> iOSElementMap = new LinkedHashMap<>();

        /*Pre-Request*/
        iOSElementMap.put(iOS_PROFILE_BUTTON, iOS_PROFILE_BUTTON_TASK);

        iOSElementMap.put(iOS_PROFILE_COACH_MARK_SKIP, iOS_PROFILE_COACH_MARK_SKIP_TASK);

        /*Actual TestCase*/
        iOSElementMap.put(iOS_PARAMETER_RANGE_BUTTON, iOS_PARAMETER_RANGE_BUTTON_TASK);

        iOSElementMap.put(iOS_KEEP_DEFAULT_BUTTON_1, new iOSElementTask.Builder(iOSActionType.VERIFY, "Keep Default ").build());

        iOSElementMap.put(iOS_ADJUST_BUTTON_1, iOS_ADJUST_BUTTON_1_TASK);

        iOSElementMap.put(iOS_SUBMIT_BUTTON, iOS_SUBMIT_BUTTON_TASK);

        performIOSActions(iOSElementMap, wait);


        Map<By, iOSElementTask> iOSElementTaskMap = new LinkedHashMap<>();

        iOSElementTaskMap.put(iOS_KEEP_DEFAULT_BUTTON_2, new iOSElementTask.Builder(iOSActionType.VERIFY, "Keep Default ").build());

        iOSElementTaskMap.put(iOS_ADJUST_BUTTON_2, iOS_ADJUST_BUTTON_2_TASK);

        iOSElementTaskMap.put(iOS_SUBMIT_BUTTON, iOS_SUBMIT_BUTTON_TASK);

        performIOSActions(iOSElementTaskMap, wait);
    }

    @Test(retryAnalyzer = RetryAnalyzerios.class)
    public void TC_030() {
        baseLoginForiOS.BaseLoginForIos(false); //Login process.

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        Map<By, iOSElementTask> iOSElementMap1 = new LinkedHashMap<>();
        iOSElementMap1.put(iOS_PROFILE_BUTTON, iOS_PROFILE_BUTTON_TASK);
        iOSElementMap1.put(iOS_PROFILE_COACH_MARK_SKIP, iOS_PROFILE_COACH_MARK_SKIP_TASK);
        iOSElementMap1.put(iOS_CONSUME_EDIT_BUTTON, iOS_CONSUME_EDIT_BUTTON_TASK);
        iOSElementMap1.put(iOS_BACK_BUTTON, iOS_BACK_BUTTON_TASK);
        performIOSActions(iOSElementMap1, wait);


        Map<By, iOSElementTask> iOSElementMap2 = new LinkedHashMap<>();
        iOSElementMap2.put(iOS_PARAMETER_RANGE_BUTTON, iOS_PARAMETER_RANGE_BUTTON_TASK);
        iOSElementMap2.put(iOS_BACK_BUTTON, iOS_BACK_BUTTON_TASK);
        performIOSActions(iOSElementMap2, wait);

        Map<By, iOSElementTask> iOSElementMap3 = new LinkedHashMap<>();
        iOSElementMap3.put(iOS_MY_DEPENDENT_BUTTON, iOS_MY_DEPENDENT_BUTTON_TASK);
        iOSElementMap3.put(iOS_HOME_BUTTON, iOS_HOME_BUTTON_TASK);
        performIOSActions(iOSElementMap3, wait);
    }

    @Test(retryAnalyzer = RetryAnalyzerios.class)
    public void TC_031() {

         baseLoginForiOS.BaseLoginForIos(false);//Login process.

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        Map<By, iOSElementTask> iOSElementMap = new LinkedHashMap<>();

        iOSElementMap.put(iOS_PROFILE_BUTTON, iOS_PROFILE_BUTTON_TASK);

        iOSElementMap.put(iOS_PROFILE_COACH_MARK_SKIP, iOS_PROFILE_COACH_MARK_SKIP_TASK);

        iOSElementMap.put(iOS_CARE_CIRCLE_BUTTON, iOS_CARE_CIRCLE_BUTTON_TASK);

        iOSElementMap.put(iOS_HOME_BUTTON, iOS_HOME_BUTTON_TASK);

        performIOSActions(iOSElementMap, wait);


        Map<By, iOSElementTask> iOSElementMap1 = new LinkedHashMap<>();

        iOSElementMap1.put(iOS_PROFILE_BUTTON, iOS_PROFILE_BUTTON_TASK);

        iOSElementMap1.put(iOS_MY_DEVICE_BUTTON, iOS_MY_DEVICE_BUTTON_TASK);

        iOSElementMap1.put(iOS_DEVICE_COACH_MARK_FINISH_BUTTON, iOS_DEVICE_COACH_MARK_FINISH_BUTTON_TASK);

        performIOSActions(iOSElementMap1, wait);

        Map<By, iOSElementTask> iOSElementMap2 = new LinkedHashMap<>();

        iOSElementMap2.put(iOS_PROFILE_BUTTON, iOS_PROFILE_BUTTON_TASK);

        iOSElementMap2.put(iOS_MY_REMINDER_BUTTON, iOS_MY_REMINDER_BUTTON_TASK);

        performIOSActions(iOSElementMap2, wait);
    }

}
