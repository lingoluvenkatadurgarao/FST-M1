package Activities;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class Activity5 {
    AndroidDriver driver;
    WebDriverWait wait;
    @BeforeClass
    public void setUp() throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("android");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.google.android.apps.messaging");
        options.setAppActivity(".ui.ConversationListActivity");
        options.noReset();
        URL server_url = new URL("http://localhost:4723/wd/hub");
        driver = new AndroidDriver(server_url,options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    public void SMS_Send(){
       driver.findElement(AppiumBy.accessibilityId("Start new conversation")).click();
       wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("recipient_text_view")));
       driver.findElement(AppiumBy.id("recipient_text_view")).sendKeys("6360845086");
       driver.pressKey(new KeyEvent().withKey(AndroidKey.ENTER));
       driver.findElement(AppiumBy.id("compose_message_text")).sendKeys("Hello from Appium");
       driver.findElement(AppiumBy.accessibilityId("Send SMS")).click();
       String Message = driver.findElement(AppiumBy.id("message_text")).getText();
        Assert.assertEquals(Message,"Hello from Appium");

    }

    @AfterClass
    public void SMS_Close(){
     driver.quit();
    }
}
