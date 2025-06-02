package More;

import Actions.ElementTask;
import DriverManagerAndroid.BaseLoginForAndroid;
import DriverManagerAndroid.DriverManager;
import UtilitiesForAndroid.RetryAnalyzer;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.LinkedHashMap;
import java.util.Map;

import static ElementRepositories.CommonElements.*;
import static ElementRepositories.MoreScreenElements.*;
import static UtilitiesForAndroid.ElementActions.performActions;

public class More_page_Android extends DriverManager {

    BaseLoginForAndroid bs = new BaseLoginForAndroid();

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void TC_032() throws Exception {

        bs.CoreLoginForAndroid(false);  //basic login scenario
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        Map<By, ElementTask> elementMap = new LinkedHashMap<>();
        elementMap.put(MORE_OPTION, MORE_OPTION_TASK);
        elementMap.put(NOTIFICATION_LABEL, NOTIFICATION_LABEL_TASK);
        elementMap.put(NOTIFICATION_TOGGLE, NOTIFICATION_TOGGLE_TASK);
        performActions(elementMap, wait);


        Map<By, ElementTask> elementMap2 = new LinkedHashMap<>();
        elementMap2.put(NOTIFICATION_TOGGLE, NOTIFICATION_TOGGLE_TASK);
        elementMap2.put(FAQ_OPTION, FAQ_OPTION_TASK);
        elementMap2.put(BACK_BUTTON, BACK_BUTTON_TASK);
        performActions(elementMap2, wait);


        Map<By, ElementTask> elementMap3 = new LinkedHashMap<>();
        elementMap3.put(SEND_FEEDBACK_OPTION, SEND_FEEDBACK_OPTION_TASK);
        elementMap3.put(BACK_BUTTON, BACK_BUTTON_TASK);
        performActions(elementMap3, wait);

    }

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void TC_033() throws Exception {

        bs.CoreLoginForAndroid(false);  //basic login scenario
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        Map<By, ElementTask> elementMap = new LinkedHashMap<>();
        elementMap.put(MORE_OPTION, MORE_OPTION_TASK);
        elementMap.put(ABOUT_US_OPTION, ABOUT_US_OPTION_TASK);
        elementMap.put(BACK_BUTTON, BACK_BUTTON_TASK);
        performActions(elementMap, wait);


        Map<By, ElementTask> elementMap2 = new LinkedHashMap<>();
        elementMap2.put(TERMS_AND_CONDITION_OPTION, TERMS_AND_CONDITION_OPTION_TASK);
        elementMap2.put(BACK_BUTTON, BACK_BUTTON_TASK);
        performActions(elementMap2, wait);


        Map<By, ElementTask> elementMap3 = new LinkedHashMap<>();
        elementMap3.put(PRIVACY_POLICY_OPTION, PRIVACY_POLICY_OPTION_TASK);
        elementMap3.put(BACK_BUTTON, BACK_BUTTON_TASK);
        performActions(elementMap3, wait);

    }

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void TC_034() throws Exception {

        bs.CoreLoginForAndroid(false);  //basic login scenario
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        Map<By, ElementTask> elementMap = new LinkedHashMap<>();
        elementMap.put(MORE_OPTION, MORE_OPTION_TASK);
        elementMap.put(LOGOUT_OPTION, LOGOUT_OPTION_TASK);
        elementMap.put(MODEL_TEXT, MODEL_TEXT_TASK);
        elementMap.put(MODEL_CLOSE_OK_BUTTON, MODEL_CLOSE_OK_BUTTON_TASK);
        performActions(elementMap, wait);

    }

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void TC_035() throws Exception {

        bs.CoreLoginForAndroid(false);  //basic login scenario
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        Map<By, ElementTask> elementMap = new LinkedHashMap<>();
        elementMap.put(MORE_OPTION, MORE_OPTION_TASK);
        elementMap.put(DELETE_ACCOUNT_OPTION, DELETE_ACCOUNT_OPTION_TASK);
        elementMap.put(MODEL_TEXT, MODEL_TEXT_TASK);
        elementMap.put(MODEL_CLOSE_CANCEL_BUTTON, MODEL_CLOSE_CANCEL_BUTTON_TASK);
        performActions(elementMap, wait);

    }

}
