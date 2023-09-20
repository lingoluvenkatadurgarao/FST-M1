package dummy;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class Activity2_AppiumProject {
    AndroidDriver driver;
    WebDriverWait wait;
    @BeforeClass
    public void setup() throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("android");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.google.android.keep");
        options.setAppActivity(".activities.BrowseActivity");
        options.noReset();
        URL server_url = new URL("http://localhost:4723/wd/hub");
        driver = new AndroidDriver(server_url,options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    @Test
    public void adding_Notes(){
        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.accessibilityId("New text note")));
        driver.findElement(AppiumBy.accessibilityId("New text note")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.id("editable_title")));
        driver.findElement(AppiumBy.id("editable_title")).sendKeys("Learning_Selenium");
        driver.findElement(AppiumBy.id("edit_note_text")).sendKeys("Daily I will spend 2 hours for Learning");
        driver.findElement(AppiumBy.accessibilityId("Navigate up")).click();
        String content = driver.findElement(AppiumBy.id("index_note_text_description")).getText();
        System.out.println("Notes is :"+content);
        String title = driver.findElement(By.id("index_note_title")).getText();
        Assert.assertEquals(title,"Learning_Selenium");

    }

    @AfterClass
    public void Close_Notes(){
        driver.quit();
    }
}
