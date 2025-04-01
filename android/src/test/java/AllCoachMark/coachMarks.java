package AllCoachMark;

import DriverManagerAndroid.BaseLoginForAndroid;
import DriverManagerAndroid.DriverManager;
import UtilitiesForAndroid.RetryAnalyzer;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import java.time.Duration;

public class coachMarks extends DriverManager {

    private static final Logger log = LoggerFactory.getLogger(coachMarks.class);
    BaseLoginForAndroid bs = new BaseLoginForAndroid();

    /*DashBoard Coach mark case*/
    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void TC_037() throws Exception
    {
        /*Global wait*/
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        /*Core Login for android.*/
        bs.CoreLoginForAndroid(false);

        /*1st text element in dashboard.*/
        WebElement firstTextElement;
        try
        {
            firstTextElement = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.heartmonitor.android:id/tvtest")));
            logger.info("DashBoard 1st coach mark Text: \n" + firstTextElement.getText());
        }catch (Exception e)
        {
            logger.warning("There is no coach mark text for first element");
            throw new Exception(e.getMessage());
        }

        /* Clicking the Next button */
        WebElement Next_1;
        try
        {
            Next_1 = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.heartmonitor.android:id/btnNext")));
            Next_1.click();
            logger.info("Clicking the 'Next' Button for second coach mark text");

        } catch (Exception e) {
            logger.warning("In DashBoard there is no 'Next' Button for coach mark.");
            throw new RuntimeException(e.getMessage());
        }

        /*2nd text element in dashboard*/
        WebElement SecondTextElement;
        try
        {
            SecondTextElement = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.heartmonitor.android:id/tvtest")));
            logger.info("DashBoard 2nd coach mark Text: \n " + SecondTextElement.getText());
        } catch (Exception e) {
            logger.warning("There is no coach mark text for second element");
            throw new RuntimeException(e.getMessage());
        }

        /* Clicking the Next button */
        WebElement Next_2;
        try
        {
            Next_2 = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.heartmonitor.android:id/btnNext")));
            Next_2.click();
            logger.info("Clicking the 'Next' Button for third coach mark text");

        } catch (Exception e) {
            logger.warning("In DashBoard there is no 'Next' Button for coach mark.");
            throw new RuntimeException(e.getMessage());
        }


        /*Third Text in the DASHBOARD COACH mark.*/
        WebElement ThirdTextElement;
        try {
            ThirdTextElement = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.heartmonitor.android:id/tvtest")));
            logger.info("DashBoard 3rd coach mark Text: \n " + ThirdTextElement.getText());
        }catch (Exception e)
        {
            logger.warning("There is no coach mark text for third element");
            throw new Exception(e.getMessage());
        }

        /*Clicking 'BACK' button to see the previous coach mark*/
        WebElement BackButton;
        try
        {
            BackButton = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.heartmonitor.android:id/btnBack")));
            BackButton.click();
            logger.info("Back button click is working, to see the previous coach mark content.");

        } catch (Exception e) {
            logger.warning("There is no back button click is happened.");
            throw new RuntimeException(e);
        }

        /* Clicking the Next button */
        WebElement Next_3;
        try
        {
            Next_3 = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.heartmonitor.android:id/btnNext")));
            Next_3.click();
            logger.info("Clicking the 'Next' Button for fourth coach mark text");

        } catch (Exception e) {
            logger.warning("In DashBoard there is no 'Next' Button for coach mark.");
            throw new RuntimeException(e.getMessage());
        }

        /*Fourth Text in the DASHBOARD COACH mark.*/
        WebElement FourthTextElement;
        try {
            FourthTextElement = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.heartmonitor.android:id/tvtest")));
            logger.info("DashBoard fourth coach mark Text: \n " + FourthTextElement.getText());
        }catch (Exception e)
        {
            logger.warning("There is no coach mark text for fourth element");
            throw new Exception(e.getMessage());
        }

        /* Clicking the Next button */
        WebElement Next_4;
        try
        {
            Next_4 = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.heartmonitor.android:id/btnNext")));
            Next_4.click();
            logger.info("Clicking the 'Next' Button for fourth coach mark text");

        } catch (Exception e) {
            logger.warning("In DashBoard there is no 'Next' Button for coach mark.");
            throw new RuntimeException(e.getMessage());
        }

        /*fifth Text in the DASHBOARD COACH mark.*/
        WebElement FifthTextElement;
        try {
            FifthTextElement = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.heartmonitor.android:id/tvtest")));
            logger.info("DashBoard 5th coach mark Text: \n " + FifthTextElement.getText());
        }catch (Exception e)
        {
            logger.warning("There is no coach mark text for fourth element");
            throw new Exception(e.getMessage());
        }

        /* Clicking the Finish button */
        WebElement Finish;
        try
        {
            Finish = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.heartmonitor.android:id/btnNext")));
            Finish.click();
            logger.info("Clicking the 'Finish' Button for last coach mark.");
        } catch (Exception e) {
            logger.warning("In DashBoard there is no 'Finish' Button for coach mark.");
            throw new RuntimeException(e.getMessage());
        }

    }

}
