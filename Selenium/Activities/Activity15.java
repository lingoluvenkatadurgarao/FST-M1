package activities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.List;
import java.util.Set;

public class Activity15 {
    public static void main(String[] args) {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://v1.training-support.net/selenium/dynamic-attributes");
        System.out.println("Title is :" + driver.getTitle());
        driver.findElement(By.xpath("//input[starts-with(@class,'username-')]")).sendKeys("admin");
        driver.findElement(By.xpath("//input[starts-with(@class,'password-')]")).sendKeys("password");
        driver.findElement(By.xpath("//button[text() = 'Log in']")).click();
        String Confirmation = driver.findElement(By.id("action-confirmation")).getText();
        System.out.println("Confirmation message is :" + Confirmation);
        driver.close();
    }
}