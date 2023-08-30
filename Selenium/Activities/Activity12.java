package activities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Activity12 {
    public static void main(String[] args){
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get(" https://v1.training-support.net/selenium/dynamic-controls");
        System.out.println("Title is :" + driver.getTitle());
        WebElement text_field = driver.findElement(By.id("input-text"));
        System.out.println("Is Text field Enabled :"+text_field.isEnabled());
        WebElement Enable_Button =driver.findElement(By.id("toggleInput"));
        Enable_Button.click();
        System.out.println("Is text field Enabled :" +text_field.isEnabled());
        driver.close();

    }
}
