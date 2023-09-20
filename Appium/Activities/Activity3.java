package Activities;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

import java.net.MalformedURLException;
import java.net.URL;
public class Activity3 {
    AndroidDriver driver;

    @BeforeClass
    public void setup() throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("android");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.android.calculator2");
        options.setAppActivity(".Calculator");
        options.noReset();
        URL server_url = new URL("http://localhost:4723/wd/hub");
        driver = new AndroidDriver(server_url,options);
    }

    @Test
    public void cal_ADD(){
      driver.findElement(AppiumBy.id("digit_5")).click();
      driver.findElement(AppiumBy.accessibilityId("plus")).click();
      driver.findElement(AppiumBy.id("digit_9")).click();
      driver.findElement(AppiumBy.accessibilityId("equals")).click();
      String result = driver.findElement(AppiumBy.id("result")).getText();
        Assert.assertEquals(result,"14");
        System.out.println("Addition :"+result);
    }

    @Test
    public void cal_SUB(){
        driver.findElement(AppiumBy.id("digit_1")).click();
        driver.findElement(AppiumBy.id("digit_0")).click();
        driver.findElement(AppiumBy.accessibilityId("minus")).click();
        driver.findElement(AppiumBy.id("digit_5")).click();
        driver.findElement(AppiumBy.accessibilityId("equals")).click();
        String result = driver.findElement(AppiumBy.id("result")).getText();
        Assert.assertEquals(result,"5");
        System.out.println("Subtraction :"+result);
    }

    @Test
    public void cal_MUL(){
        driver.findElement(AppiumBy.id("digit_5")).click();
        driver.findElement(AppiumBy.accessibilityId("multiply")).click();
        driver.findElement(AppiumBy.id("digit_1")).click();
        driver.findElement(AppiumBy.id("digit_0")).click();
        driver.findElement(AppiumBy.id("digit_0")).click();
        driver.findElement(AppiumBy.accessibilityId("equals")).click();
        String result = driver.findElement(AppiumBy.id("result")).getText();
        Assert.assertEquals(result,"500");
        System.out.println("Multiplication :"+result);
    }

    @Test
    public void cal_DIV(){
        driver.findElement(AppiumBy.id("digit_5")).click();
        driver.findElement(AppiumBy.id("digit_0")).click();
        driver.findElement(AppiumBy.accessibilityId("divide")).click();
        driver.findElement(AppiumBy.id("digit_2")).click();
        driver.findElement(AppiumBy.accessibilityId("equals")).click();
        String result = driver.findElement(AppiumBy.id("result")).getText();
        Assert.assertEquals(result,"25");
        System.out.println("Division :"+result);
    }


    @AfterClass
    public void cal_close(){
       driver.quit();
    }
}
