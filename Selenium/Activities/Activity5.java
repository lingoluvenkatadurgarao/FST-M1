package activities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.interactions.Actions;

public class Activity5 {
    public static void main(String[] args){
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://v1.training-support.net/selenium/input-events");
        System.out.println("Title of the Page :" + driver.getTitle());
        Actions action = new Actions(driver);
        action.click().pause(1000).build().perform();
        String front_text = driver.findElement(By.className("active")).getText();
        action.doubleClick().pause(1000).build().perform();
        String randomSide_text = driver.findElement(By.className("active")).getText();
        action.contextClick().pause(1000).build().perform();
        String cubeFront_text = driver.findElement(By.className("active")).getText();
        System.out.println("Left click is :" + front_text);
        System.out.println("Double click is :" + randomSide_text);
        System.out.println("Right click is :" + cubeFront_text);
        driver.close();


    }
}
