package activities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Activity16 {
    public static void main(String[] args){
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://v1.training-support.net/selenium/dynamic-attributes");
        System.out.println("Title is :" + driver.getTitle());
        driver.findElement(By.xpath("//input[contains(@class,'-username')]")).sendKeys("Ram");
        driver.findElement(By.xpath("//input[contains(@class,'-password')]")).sendKeys("Laxman");
        driver.findElement(By.xpath("//input[starts-with(@name,'name-')]")).sendKeys("Laxman");
        driver.findElement(By.xpath("//input[starts-with(@class,'email-')]")).sendKeys("sita@ram.com");
        driver.findElement(By.xpath("//button[text() = 'Sign Up']")).click();
        String Confirm = driver.findElement(By.id("action-confirmation")).getText();
        System.out.println("Confirmation for SignUp :" +Confirm);
        driver.close();
    }
}
