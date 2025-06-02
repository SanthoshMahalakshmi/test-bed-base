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

        bs.CoreLoginForAndroid(true);  //basic login scenario
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        Map<By, ElementTask> elementMap = new LinkedHashMap<>();

        elementMap.put(MORE_OPTION, MORE_OPTION_TASK);
        performActions(elementMap, wait);
    }

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void TC_033() throws Exception {

        bs.CoreLoginForAndroid(false);  //basic login scenario
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        Map<By, ElementTask> elementMap = new LinkedHashMap<>();
        performActions(elementMap, wait);


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
