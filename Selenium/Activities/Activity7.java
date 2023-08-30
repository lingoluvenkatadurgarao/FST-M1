package activities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Activity7 {
    public static void main(String[] args) {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        Actions action = new Actions(driver);
        driver.get("https://v1.training-support.net/selenium/drag-drop");
        System.out.println("Title of the page :" + driver.getTitle());
        WebElement ball = driver.findElement(By.id("draggable"));
        WebElement DropZone1 = driver.findElement(By.id("droppable"));
        WebElement DropZone2 = driver.findElement(By.id("dropzone2"));
        action.clickAndHold(ball).moveToElement(DropZone1).pause(1000).release().build().perform();
        String Zone1_Highlighed = DropZone1.getCssValue("color");
        System.out.println("if ball dragged and droped in Zone 1 then Zone Highlight with Green color" + Zone1_Highlighed);
        //action.clickAndHold(ball).moveToElement(DropZone2).pause(1000).release().build().perform();
        action.dragAndDrop(DropZone1,DropZone2).build().perform();
        String Zone2_Highlighed = DropZone2.getCssValue("color");
        System.out.println("if ball dragged and droped in Zone 2 then Zone Highlight with Green color" + Zone2_Highlighed);
        driver.close();

        }
    }
