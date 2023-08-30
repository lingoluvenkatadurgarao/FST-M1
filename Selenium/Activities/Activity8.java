package activities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.By;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class Activity8 {
    public static void main(String[] args){
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://v1.training-support.net/selenium/dynamic-controls");
        System.out.println("Home page Title :" + driver.getTitle());
       // driver.findElement(By.className("willDisappear")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("willDisappear"))).click();
       // driver.findElement(By.id("toggleCheckbox")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("toggleCheckbox"))).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("willDisappear")));
        driver.findElement(By.id("toggleCheckbox")).click();
        //driver.findElement(By.xpath("//input[@class ='willDisappear']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@class ='willDisappear']"))).click();
        driver.close();
    }
}
