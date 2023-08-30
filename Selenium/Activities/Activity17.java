package activities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Activity17 {
    public static void main(String[] args){
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://v1.training-support.net/selenium/selects");
        System.out.println("Title is :" + driver.getTitle());
        WebElement select_element = driver.findElement(By.id("single-select"));
        Select select = new Select(select_element);
        select.selectByVisibleText("Option 2");
        System.out.println("select by Visible Text is :" + select.getFirstSelectedOption().getText());
        select.selectByIndex(3);
        System.out.println("select by Index is :" + select.getFirstSelectedOption().getText());
        select.selectByValue("4");
        System.out.println("select by Value is :" + select.getFirstSelectedOption().getText());
        List<WebElement> Options_List = select.getOptions();
        //System.out.println("select by Visible Text is :" + select.getAllSelectedOptions().toString());
        for (WebElement list : Options_List){
            System.out.println(list.getText());
        }
        driver.quit();
    }
}
