package Activities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class Activity7 {
    WebDriver driver;
    @BeforeMethod
    public void set_up(){
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.get(" https://v1.training-support.net/selenium/login-form");
    }


    @DataProvider(name = "Authentication")
    public  static Object[][] credentials() {
        return new Object[][] {
                {"admin","password"},
               // {"adminUser","password"}
        };
    }

    @Test (dataProvider = "Authentication")
    public void test_Login(String UN,String PW) throws InterruptedException {
        driver.findElement(By.id("username")).sendKeys(UN);
        driver.findElement(By.id("password")).sendKeys(PW);
        driver.findElement(By.xpath("//button[text() = 'Log in']")).click();
        String Actual_Message = driver.findElement(By.id("action-confirmation")).getText();
        String Expected_Message = "Welcome Back, admin";
        Assert.assertEquals(Actual_Message,Expected_Message);

    }

    @AfterMethod
    public void close(){
        driver.close();
    }


}
