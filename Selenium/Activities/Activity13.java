package activities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.List;

public class Activity13 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://v1.training-support.net/selenium/tables");
        System.out.println("Title is :" + driver.getTitle());
        List<WebElement> rows = driver.findElements(By.xpath("//table[@class ='ui celled striped table']/tbody/tr"));
        System.out.println("No.of rows :" + rows.size());
        List<WebElement> columns = driver.findElements(By.xpath("//table[@class ='ui celled striped table']/tbody/tr[1]/td"));
        System.out.println("No.of columns :" + columns.size());
        List<WebElement> Third_row_col = driver.findElements(By.xpath("//table[@class ='ui celled striped table']/tbody/tr[3]/td"));
        for (WebElement cell : Third_row_col) {
            System.out.println(cell.getText());
        }
        WebElement sec_col =driver.findElement(By.xpath("//table[@class ='ui celled striped table']/tbody/tr[2]/td[2]"));
        System.out.println(sec_col.getText());
        driver.close();
    }
}