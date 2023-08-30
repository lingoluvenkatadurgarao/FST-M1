package activities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
public class Activity3 {
    public static void main(String[] args){
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://v1.training-support.net");
        System.out.println("Home Page Title is :" + driver.getTitle());
        driver.findElement(By.xpath("//a[@id = 'about-link']")).click();
        System.out.println("Title of new page :" +driver.getTitle());

        driver.get("https://v1.training-support.net/selenium/login-form");
        System.out.println("Page Title is :"+ driver.getTitle());
        driver.findElement(By.xpath("//input[@id = 'username']")).sendKeys("admin");
        driver.findElement(By.xpath("//input[@id = 'password']")).sendKeys("password");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        String comfirmation_msg = driver.findElement(By.xpath("//div[@id = 'action-confirmation']")).getText();
        System.out.println("comfirmation_msg is :" +comfirmation_msg);
        driver.quit();



    }
}
