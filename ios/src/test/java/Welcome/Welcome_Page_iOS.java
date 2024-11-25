package Welcome;

import DriverManagerIos.DriverManager;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class Welcome_Page_iOS extends DriverManager
{

    @Test
    public void ios_TC_001()
    {
        //Global wait.
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        //ios
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("Allow"))).click();

        //confirm the device image is present in the screen welcome screen.
        System.out.println( "image is displayed in the welcome screen : " +
                driver.findElement(AppiumBy.xpath("//XCUIElementTypeImage")).isDisplayed());

        //Welcome page Description verification.
        WebElement description = driver.findElement(AppiumBy.xpath("//XCUIElementTypeStaticText[@name=\"Keep track of your own and your family’s health and well-being\"]"));
        System.out.println("Welcome page description : " + description.getText());

        //Clicking the Get started button
        WebElement getStarted =  driver.findElement(AppiumBy.xpath("//XCUIElementTypeStaticText[@name=\"Get Started\"]"));

        System.out.println("Get started button is present in the welcome page : " + getStarted.isDisplayed());

        wait.until(ExpectedConditions.elementToBeClickable(getStarted)).click();

        //Verifying the login or signup label present or not.
        boolean loginOrSignup = driver.findElement(AppiumBy.xpath("//XCUIElementTypeStaticText[@name=\"Login or Sign Up\"]")).isDisplayed();
        System.out.println("Navigated to login page : "+ loginOrSignup);
    }
}