package activities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Activity2 {
    public static void main(String[] args) throws InterruptedException {
       // System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"/dev/null");
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://v1.training-support.net/selenium/login-form");
        System.out.println("Home Page Title is :" + driver.getTitle());
        driver.findElement(By.id("username")).sendKeys("admin");
        driver.findElement(By.id("password")).sendKeys("password");
        driver.findElement(By.xpath("//button[text() = 'Log in']")).click();
        String comfirmation_msg = driver.findElement(By.id("action-confirmation")).getText();
        System.out.println("comfirmation_msg is :" +comfirmation_msg);

        Thread.sleep(500);
        driver.close();


    }
}
