package Activities;
import com.beust.ah.A;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity1 {
    WebDriver driver;
    @BeforeMethod
    public void test_setup(){
        WebDriverManager.firefoxdriver().setup();
        driver= new FirefoxDriver();
        driver.get("https://v1.training-support.net/");
    }

    @AfterMethod
    public void test_cleanup(){
        driver.close();
    }

    @Test
    public void test_OpenBrowser(){
        System.out.println("Firefox browser opened successfully");
        String Actual_title =driver.getTitle();
        String Expected_title ="Training Support";
        System.out.println("Home page title is :" + Actual_title);
        Assert.assertEquals(Actual_title,Expected_title);
        driver.findElement(By.id("about-link")).click();
        String NewPageTile_Actual = driver.getTitle();
        String NewPageTile_Expected = "About Training Support";
        System.out.println("New Page title :" +NewPageTile_Actual);
        Assert.assertEquals(NewPageTile_Actual,NewPageTile_Expected);

    }
}
