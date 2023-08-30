package activities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.interactions.Actions;

public class Activity22 {
public static void main(String[] args){
    WebDriverManager.firefoxdriver().setup();
    WebDriver driver = new FirefoxDriver();
    driver.get("https://v1.training-support.net/selenium/popups");
    System.out.println("Title is :" + driver.getTitle());
    WebElement hover = driver.findElement(By.className("orange"));
    Actions tooltip = new Actions(driver);
    tooltip.moveToElement(hover).build().perform();
    System.out.println("Sign in Button tooltip is :" + hover.getAttribute("data-tooltip"));
    hover.click();
    driver.findElement(By.id("username")).sendKeys("admin");
    driver.findElement(By.id("password")).sendKeys("password");
    driver.findElement(By.xpath("//button[text() = 'Log in']")).click();
    String confirm = driver.findElement(By.id("action-confirmation")).getText();
    System.out.println("Confirmation Message is :" + confirm);
    driver.close();


}
}
