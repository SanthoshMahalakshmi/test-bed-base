package Welcome;

import Actions.ElementTask;
import DriverManagerAndroid.DriverManager;
import UtilitiesForAndroid.RetryAnalyzer;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.LinkedHashMap;
import java.util.Map;

import static ElementRepositories.LoginScreenElements.*;
import static ElementRepositories.SplashScreenElements.*;
import static UtilitiesForAndroid.ElementActions.performActions;


public class Welcome_Page_Android extends DriverManager {


    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void TC_001() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        Map<By, ElementTask> elementMap = new LinkedHashMap<>();

        elementMap.put(TITLE_LOGO_IMAGE, TITLE_LOGO_IMAGE_TASK);

        elementMap.put(DESCRIPTION_TEXT, DESCRIPTION_TEXT_TASK);

        elementMap.put(GET_STARTED_BUTTON, GET_STARTED_TASK);

        elementMap.put(LOGIN_OR_SIGNUP_LABEL, LOGIN_OR_SIGNUP_LABEL_TASK);

        performActions(elementMap, wait);
    }

}
