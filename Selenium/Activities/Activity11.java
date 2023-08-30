package activities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Activity11 {
    public static void main(String[] args){
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://v1.training-support.net/selenium/dynamic-controls");
        System.out.println("Title of the page :"+driver.getTitle());
      //  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement CheckBox = driver.findElement(By.xpath("//input[@class = 'willDisappear']"));
        CheckBox.click();
        System.out.println("Check Box Selected?" + CheckBox.isSelected());
        CheckBox.click();
        System.out.println("Check Box Deselected?" + CheckBox.isSelected());
        driver.close();
    }

}
