package activities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Activity10 {
    public static void main(String[] args){
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://v1.training-support.net/selenium/dynamic-controls");
        System.out.println("Title of the Page :" + driver.getTitle());
        WebElement checkbox = driver.findElement(By.xpath("//div[@id ='dynamicCheckbox']//input"));
       if(checkbox.isEnabled()){
            checkbox.click();
        }
        System.out.println("is checkbox selected :" + checkbox.isSelected());
        driver.findElement(By.id("toggleCheckbox")).click();
        System.out.println("Check box Removed :");
        System.out.println(wait.until(ExpectedConditions.invisibilityOf(checkbox)));
        System.out.println("Is checkbox available :" +checkbox.isDisplayed());
        driver.findElement(By.xpath("//button[text() ='Add Checkbox']")).click();
        wait.until(ExpectedConditions.visibilityOf(checkbox)).click();
        System.out.println("Is check box visible and selected :" + checkbox.isSelected());
        driver.close();
    }
}
