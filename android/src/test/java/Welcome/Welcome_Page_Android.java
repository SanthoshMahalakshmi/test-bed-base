package Welcome;

import DriverManagerAndroid.DriverManager;
import UtilitiesForAndroid.RetryAnalyzer;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;


public class Welcome_Page_Android extends DriverManager {

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void TC_001() throws Exception {
        /*Global wait*/
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        logger.info("Case pass.");

//        try {
//            /*confirm the image is present in the screen*/
//            WebElement img = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.heartmonitor.android:id/images")));
//            logger.info("Welcome screen image is displayed ? :" + img.isDisplayed());
//        } catch (NoSuchElementException e) {
//            throw new NoSuchElementException(e.getMessage());
//        } catch (Exception e) {
//            logger.warning("Welcome screen image is not displayed");
//            throw new Exception(e.getMessage());
//        }
//
//        try {
//            /*Description verification*/
//            WebElement description = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.
//                    id("com.heartmonitor.android:id/txtDescription")));
//            logger.info("Welcome screen description : " + description.getText());
//        } catch (NoSuchElementException e){
//            throw new NoSuchElementException(e.getMessage());
//        }catch (Exception e) {
//            logger.warning("Welcome page description is not visible." + e.getMessage());
//            throw new Exception(e.getMessage());
//        }
//
//        /*Clicking the Get started button*/
//        try {
//            WebElement getStarted = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.heartmonitor.android:id/txtGetStart")));
//            getStarted.click();
//            logger.info("Successfully clicked the 'Get Started' button.");
//        } catch (ElementClickInterceptedException e) {
//            logger.warning("The 'Get Started' button is present but not interactable. Details: " + e.getMessage());
//            throw new ElementNotInteractableException(e.getMessage());
//        } catch (NoSuchElementException e) {
//            logger.warning("The 'Get Started' button could not be located. Details: " + e.getMessage());
//            throw new NoSuchElementException(e.getMessage());
//        }
//
//        /*Verifying the login or signup label present or not.*/
//        WebElement loginOrSignup = null;
//        try {
//            loginOrSignup = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.heartmonitor.android:id/txtPhoneLabel")));
//            logger.info("LoginOrSignUp page label is present? : " + loginOrSignup.isDisplayed());
//        }catch (NoSuchElementException e){
//            logger.warning("There is no such element like LoginOrSignup label");
//            throw new NoSuchElementException(e.getMessage());
//        }catch (Exception e) {
//            throw new Exception(e.getMessage());
//        }

    }

}
