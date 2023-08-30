package activities;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.List;

public class Activity18 {
    public static void main(String[] args){
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://v1.training-support.net/selenium/selects");
        System.out.println("Title is :" + driver.getTitle());
        WebElement select_element = driver.findElement(By.id("multi-select"));
        Select multi_dropdown = new Select(select_element);
        multi_dropdown.selectByVisibleText("Javascript");
        System.out.println("First selected option is :" + multi_dropdown.getFirstSelectedOption().getText());
        multi_dropdown.selectByIndex(4);
        multi_dropdown.selectByIndex(5);
        multi_dropdown.selectByIndex(6);
        multi_dropdown.selectByValue("node");
        List<WebElement> lst1 = multi_dropdown.getAllSelectedOptions();
        System.out.println("All Options Selected :");
        for (WebElement l1 : lst1){
            System.out.println(l1.getText());
        }
        multi_dropdown.deselectByIndex(5);
        List<WebElement> lst2 = multi_dropdown.getAllSelectedOptions();
        System.out.println("All Options Selected post deselect:");
        for (WebElement l2 : lst2){
            System.out.println(l2.getText());
        }
        driver.close();
    }
}
