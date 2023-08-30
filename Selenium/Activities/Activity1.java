package activities;
import io.github.bonigarcia.wdm.WebDriverManager;
import  org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import  org.openqa.selenium.*;
public class Activity1 {
    public static void main(String[] args){
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://v1.training-support.net");
        String title = driver.getTitle();
        System.out.println("WebPage Tile is :" +title);
       WebElement element = driver.findElement(By.id("about-link"));
       element.click();
        System.out.println("Tile of the Next page is :" +driver.getTitle());
        driver.close();

    }

}
