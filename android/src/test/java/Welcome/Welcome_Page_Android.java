package Welcome;

import Actions.ElementTask;
import DriverManagerAndroid.DriverManager;
import UtilitiesForAndroid.RetryAnalyzer;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.LinkedHashMap;
import java.util.Map;

import static ElementRepositories.SplashScreenElements.*;
import static UtilitiesForAndroid.ElementActions.performActions;


public class Welcome_Page_Android extends DriverManager {


    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void TC_001() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        Map<By, ElementTask> elementMap1 = new LinkedHashMap<>();
        elementMap1.put(TITLE_LOGO_IMAGE, TITLE_LOGO_IMAGE_TASK);
        elementMap1.put(SPLASH_SCREEN_SLIDE, SPLASH_SCREEN_SLIDE_TASK);
        elementMap1.put(SPLASHSCREEN_DESCRIPTION, SPLASHSCREEN_DESCRIPTION_TASK);
        elementMap1.put(NEXT_BUTTON, NEXT_BUTTON_TASK);
        performActions(elementMap1, wait);

        Map<By, ElementTask> elementMap2 = new LinkedHashMap<>();
        elementMap2.put(SPLASHSCREEN_DESCRIPTION, SPLASHSCREEN_DESCRIPTION_TASK);
        elementMap2.put(SPLASH_SCREEN_SLIDE, SPLASH_SCREEN_SLIDE_TASK);
        elementMap2.put(NEXT_BUTTON, NEXT_BUTTON_TASK);
        performActions(elementMap2, wait);

        Map<By, ElementTask> elementMap3 = new LinkedHashMap<>();
        elementMap3.put(SPLASHSCREEN_DESCRIPTION, SPLASHSCREEN_DESCRIPTION_TASK);
        elementMap3.put(SPLASH_SCREEN_SLIDE, SPLASH_SCREEN_SLIDE_TASK);
        elementMap3.put(GET_STARTED_BUTTON, GET_STARTED_TASK);
        performActions(elementMap3, wait);


    }


}
