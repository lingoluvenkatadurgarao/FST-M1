package activities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Activity9 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        driver.get("https://v1.training-support.net/selenium/ajax");
        System.out.println("Title of the Page :" + driver.getTitle());
        driver.findElement(By.xpath("//button[text() = 'Change Content']")).click();
       // System.out.println(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text() = 'HELLO!']"))).getText());
        WebElement wait_hello=(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text() = 'HELLO!']"))));
        System.out.println("Visibility of Hello :" + wait_hello.isDisplayed());
        System.out.println("Visibility of Hello Text :" + wait_hello.getText());
        //WebElement wait_late=(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='ajax-content']//h3"))));
        WebElement wait_late=(wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("h3"))));
        //wait.until(ExpectedConditions.textToBePresentInElementValue((By.tagName("h3")),"I'm late!"))
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[text() =\"I'm late!\"]")));
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.tagName("h3"), "I'm late!"));
        Thread.sleep(2000);
        //Here calling same element locator due to stale element exception hence of AJAX execution again locating
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.tagName("h3"), "I'm late!"));
        String lateText = driver.findElement(By.tagName("h3")).getText();
        System.out.println("Visibility of Late Text :" +lateText);
        driver.close();



    }
}
