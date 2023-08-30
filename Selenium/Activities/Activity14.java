package activities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.Comparator;
import java.util.List;

public class Activity14 {
    public static void main(String[] args){
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://v1.training-support.net/selenium/tables");
        System.out.println("Title is :"+driver.getTitle());
        List<WebElement> cols= driver.findElements(By.xpath("//table[@id = 'sortableTable']/thead/tr/th"));
        System.out.println("No.Of columns :" + cols.size());
        List<WebElement> rows = driver.findElements(By.xpath("//table[@id = 'sortableTable']/tbody/tr"));
        System.out.println("No.of rows :" +rows.size());
        WebElement second_row_cell =driver.findElement(By.xpath("//table[@id = 'sortableTable']/tbody/tr[2]/td[2]"));
        System.out.println("2nd_row_2nd_cell_value is :" + second_row_cell.getText());
        driver.findElement(By.xpath("//table[@id = 'sortableTable']/thead/tr/th")).click();
        WebElement second_row_cell_again =driver.findElement(By.xpath("//table[@id = 'sortableTable']/tbody/tr[2]/td[2]"));
        System.out.println("2nd_row_2nd_cell_value is :" + second_row_cell_again.getText());
        List<WebElement> footer_cell = driver.findElements(By.xpath("//table[@id = 'sortableTable']/tfoot/tr/th"));
        System.out.println("Cell values of the footer: ");
        for (WebElement fcell:footer_cell){
            System.out.println(fcell.getText());
        }
        driver.quit();

    }
}
