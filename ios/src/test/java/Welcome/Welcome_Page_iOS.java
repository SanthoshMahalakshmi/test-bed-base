package Welcome;

import Actions.iOSElementTask;
import DriverManagerIos.DriverManager;
import UtilitiesForIos.RetryAnalyzerios;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.LinkedHashMap;
import java.util.Map;

import static UtilitiesForIos.iOSElementActions.*;
import static iOSElemenRepositories.iOSSplashScreenElements.*;

public class Welcome_Page_iOS extends DriverManager {


    @Test(retryAnalyzer = RetryAnalyzerios.class)
    public void TC_001()
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        alertIOS(wait, "Allow notification from alert function.");

        Map<By, iOSElementTask> iOSElementMap1 = new LinkedHashMap<>();
        iOSElementMap1.put(iOS_TITLE_LOGO_IMAGE, iOS_TITLE_LOGO_IMAGE_TASK);
        iOSElementMap1.put(iOS_SPLASHSCREEN_DESCRIPTION_1, iOS_SPLASHSCREEN_DESCRIPTION_1_TASK);
        iOSElementMap1.put(iOS_NEXT_BTN, iOS_NEXT_BTN_TASK);
        performIOSActions(iOSElementMap1, wait);

        Map<By, iOSElementTask> iOSElementMap2 = new LinkedHashMap<>();
        iOSElementMap2.put(iOS_SPLASHSCREEN_DESCRIPTION_2, iOS_SPLASHSCREEN_DESCRIPTION_2_TASK);
        iOSElementMap2.put(iOS_NEXT_BTN, iOS_NEXT_BTN_TASK);
        performIOSActions(iOSElementMap2, wait);

        Map<By, iOSElementTask> iOSElementMap3 = new LinkedHashMap<>();
        iOSElementMap3.put(iOS_SPLASHSCREEN_DESCRIPTION_3, iOS_SPLASHSCREEN_DESCRIPTION_3_TASK);
        iOSElementMap3.put(iOS_GET_STARTED_BTN, iOS_GET_STARTED_BTN_TASK);
        performIOSActions(iOSElementMap3, wait);
    }

}