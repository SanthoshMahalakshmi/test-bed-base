package More;

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
import static iOSElemenRepositories.iOSMoreScreenElements.*;

public class More_page_Ios extends DriverManager {

    BaseLoginForiOS baseLoginForiOS = new BaseLoginForiOS();

    @Test(retryAnalyzer = RetryAnalyzerios.class)
    public void TC_032() {
        baseLoginForiOS.BaseLoginForIos(false);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));

        Map<By, iOSElementTask> iOSElementMap = new LinkedHashMap<>();

        iOSElementMap.put(iOS_MORE_OPTION, iOS_MORE_OPTION_TASK);

        iOSElementMap.put(iOS_NOTIFICATION_LABEL, iOS_NOTIFICATION_LABEL_TASK);

        iOSElementMap.put(iOS_NOTIFICATION_TOGGLE, iOS_NOTIFICATION_TOGGLE_TASK);

        performIOSActions(iOSElementMap, wait);


        Map<By, iOSElementTask> iOSElementMap2 = new LinkedHashMap<>();

        iOSElementMap2.put(iOS_NOTIFICATION_TOGGLE, iOS_NOTIFICATION_TOGGLE_TASK);

        iOSElementMap2.put(iOS_FAQ_OPTION, iOS_FAQ_OPTION_TASK);

        iOSElementMap2.put(iOS_BACK_BUTTON, iOS_BACK_BUTTON_TASK);

        performIOSActions(iOSElementMap2, wait);


        Map<By, iOSElementTask> iOSElementMap3 = new LinkedHashMap<>();

        iOSElementMap3.put(iOS_SEND_FEEDBACK_OPTION, iOS_SEND_FEEDBACK_OPTION_TASK);

        iOSElementMap3.put(iOS_BACK_BUTTON, iOS_BACK_BUTTON_TASK);

        performIOSActions(iOSElementMap3, wait);
    }

    
    @Test(retryAnalyzer = RetryAnalyzerios.class)
    public void TC_033() {

         baseLoginForiOS.BaseLoginForIos(true); // Login process

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));


    }

    @Test(retryAnalyzer = RetryAnalyzerios.class)
    public void TC_034() {

        baseLoginForiOS.BaseLoginForIos(true);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));


    }

    @Test(retryAnalyzer = RetryAnalyzerios.class)
    public void TC_035() {

         baseLoginForiOS.BaseLoginForIos(true);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));


    }
}
