package Activities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Activity9 {
    WebDriver driver;

    @BeforeTest
    public void setup() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        Reporter.log("Firefox browser Launched!");
        driver.get("https://v1.training-support.net/selenium/javascript-alerts");
        Reporter.log("Title of the Page :" +driver.getTitle());
    }


    @BeforeMethod
    public void alert_BackToHome() {
        driver.switchTo().defaultContent();
        Reporter.log("Browser Ready for Next test!");
    }

    @Test
    public void simpleAlertTestCase() {
        driver.findElement(By.id("simple")).click();
        Reporter.log("Simple Alert opened !");
        Alert alert = driver.switchTo().alert();
        Reporter.log("Switching and getting Simple Alert message text!");
        String data = alert.getText();
        System.out.println("Alert message :"+data);
        Assert.assertEquals(data,"This is a JavaScript Alert!");
        alert.accept();
        Reporter.log("Alert closed and Test execution done");
    }

    @Test
    public void confirmAlertTestCase() {
        driver.findElement(By.id("confirm")).click();
        Reporter.log("Confirmation Alert opened !");
        Alert alert = driver.switchTo().alert();
        Reporter.log("Switching and getting Simple Alert message text!");
        String data = alert.getText();
        System.out.println("Alert message :"+data);
        Assert.assertEquals(data,"This is a JavaScript Confirmation!");
        alert.accept();
        Reporter.log("Alert closed and Test execution done");
    }

    @Test
    public void promptAlertTestCase() {
        driver.findElement(By.id("prompt")).click();
        Reporter.log("Prompt Alert opened !");
        Alert alert = driver.switchTo().alert();
        Reporter.log("Switching and getting Simple Alert message text!");
        String data = alert.getText();
        System.out.println("Alert message :"+data);
        Assert.assertEquals(data,"This is a JavaScript Prompt!");
        alert.sendKeys("I am Happy");
        alert.accept();
        Reporter.log("Alert closed and Test execution done");
    }

    @AfterTest
    public void Test_close(){
        driver.close();
        Reporter.log("Execution Finished!");
    }
}
