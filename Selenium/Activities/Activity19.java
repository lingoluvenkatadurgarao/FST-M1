package activities;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Activity19 {
    public static void main(String[] args){
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://v1.training-support.net/selenium/javascript-alerts");
        System.out.println("Title is :" +driver.getTitle());
        driver.findElement(By.id("confirm")).click();
        Alert Confirm_alert = driver.switchTo().alert();
        System.out.println("Text in Confirm Alert is :" +Confirm_alert.getText());
        Confirm_alert.accept();
        driver.findElement(By.id("confirm")).click();
        Confirm_alert.dismiss();
        driver.close();
    }
}
