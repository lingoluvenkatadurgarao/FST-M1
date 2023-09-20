package Activities;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class Activity2 {
    AndroidDriver driver;
    WebDriverWait wait;
    @BeforeClass
    public void setup() throws MalformedURLException {
       UiAutomator2Options options = new UiAutomator2Options();
       options.setPlatformName("android");
       options.setAutomationName("UiAutomator2");
       options.setAppPackage("com.android.chrome");
       options.setAppActivity("com.google.android.apps.chrome.Main");
       options.noReset();

        URL server_url = new URL("http://localhost:4723/wd/hub");
        driver = new AndroidDriver(server_url,options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    public void web_test(){
        driver.get("https://training-support.net/");
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.view.View[@text='Training Support']")));
        String Heading = driver.findElement(AppiumBy.xpath("//android.view.View[@text='Training Support']")).getText();
        System.out.println(Heading);
        driver.findElement(AppiumBy.xpath("//android.view.View[@text = 'About Us']")).click();
        //driver.navigate().refresh();
        //driver.navigate().to(driver.getCurrentUrl());
        driver.getPageSource();
        //driver.findElement(AppiumBy.xpath("//android.view.View[@text = 'About Us']"));
        String new_Heading = driver.findElement(AppiumBy.xpath("//android.view.View[@text = 'About Us']")).getText();
        System.out.println(new_Heading);

    }

    @AfterClass
    public void web_close(){

    }
}
