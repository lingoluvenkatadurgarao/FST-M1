package activities;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity20 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://v1.training-support.net/selenium/javascript-alerts");
        System.out.println("Title is :" + driver.getTitle());
        WebElement Promt_alert = driver.findElement(By.id("prompt"));
        Promt_alert.click();
        Alert P_Alert1 = driver.switchTo().alert();
        System.out.println("Any Text in Prompt Now :" + P_Alert1.getText());
        Thread.sleep(500);
        P_Alert1.dismiss();
        Promt_alert.click();
        Alert P_Alert2 = driver.switchTo().alert();
        P_Alert2.sendKeys("Awsome!");
        System.out.println("Any Text in Prompt Now :" + P_Alert2.getText());
        Thread.sleep(500);
        P_Alert2.accept();
        driver.close();

    }
}
