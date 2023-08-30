package activities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Activity4 {
    public static void main(String[] args){
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"/dev/null");
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://v1.training-support.net/selenium/target-practice");
        System.out.println("Home Page title is :" + driver.getTitle());
       String ThirdHeadr = driver.findElement(By.xpath("//h3[@id = 'third-header']")).getText();
       System.out.println("Thrird header is :" +ThirdHeadr);
       String color = driver.findElement(By.xpath("//h5[text() = 'Fifth header']")).getCssValue("color");
       System.out.println("Fifth header color is :" +color);
       String violet_color =driver.findElement(By.xpath("//button[text()='Violet']")).getAttribute("class");
       System.out.println("Violet Color is :" +violet_color);
       String Grey_Text = driver.findElement(By.xpath("//button[text() = 'Grey']")).getText();
       System.out.println("Grey Text is :" +Grey_Text);
       driver.close();

    }
}
