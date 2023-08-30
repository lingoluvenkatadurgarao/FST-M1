package activities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;


public class Activity21 {
    public static void main(String[] args){
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        driver.get("https://v1.training-support.net/selenium/tab-opener");
        System.out.println("Title is :" +driver.getTitle());
        System.out.println("Get Current Parent Window Handler :" + driver.getWindowHandle());
        driver.findElement(By.id("launcher")).click();
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
        System.out.println("Get Current all Window Handlers :" + driver.getWindowHandles());
        for (String handle: driver.getWindowHandles()){
            driver.switchTo().window(handle);
        }
        System.out.println("Title of the page is :" +driver.getTitle());
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("content")));
        String PageContent = driver.findElement(By.className("content")).getText();
        System.out.println("Heading of the Page is :" +PageContent);
        wait.until(ExpectedConditions.elementToBeClickable(By.id("actionButton")));
        driver.findElement(By.id("actionButton")).click();
        wait.until(ExpectedConditions.numberOfWindowsToBe(3));
        System.out.println("Get Current all Window Handlers :" + driver.getWindowHandles());
        for (String handleNew: driver.getWindowHandles()){
            driver.switchTo().window(handleNew);
        }
        System.out.println("Title of the page is :" +driver.getTitle());
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("content")));
        String PageContent1 = driver.findElement(By.className("content")).getText();
        System.out.println("Heading of the Page is :" +PageContent1);

        driver.quit();

    }
}
