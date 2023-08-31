package Activities;

import jdk.jfr.Enabled;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity2 {
    WebDriver driver;
    @BeforeClass
    public void setup(){
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.get("https://v1.training-support.net/selenium/target-practice");
    }
    @AfterClass
    public void teardown(){
        driver.quit();
    }
    @Test
    public void test_test1(){
        String title = driver.getTitle();
        Assert.assertEquals(title,"Target Practice");
    }
    @Test
    public void test_test2(){
        WebElement color =driver.findElement(By.xpath("//button[text() = 'Black')]"));
        String BlackButton = color.getCssValue("class");
        Assert.assertEquals(BlackButton,"Red");
    }
    @Test(enabled = false)
    public void test_test3(){
        //System.out.println("This test is skipped due to code un availability");
        String subHeading = driver.findElement(By.className("sub")).getText();
        Assert.assertTrue(subHeading.contains("Practice"));
    }

    @Test
    public void test_test4(){
        throw new SkipException("Skipped test case");
    }
}
