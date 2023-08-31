package Activities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Activity6 {
    WebDriver driver;
    @BeforeClass
    public void set_up(){
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.get("https://v1.training-support.net/selenium/login-form");
    }
    @Test
    @Parameters({"username","password"})
    public void Login_Form(String UN,String PW){
        driver.findElement(By.id("username")).sendKeys(UN);
        driver.findElement(By.id("password")).sendKeys(PW);
        driver.findElement(By.cssSelector("button.button")).click();
    }
    @AfterClass
    public void tear_down(){
        driver.quit();
    }
}
