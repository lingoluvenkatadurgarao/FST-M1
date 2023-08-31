package Activities;

import com.beust.ah.A;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.internal.GroupsHelper;

public class Activity5 {
    WebDriver driver;
    @BeforeTest(alwaysRun = true)
    public void set_up() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.get("https://v1.training-support.net/selenium/target-practice");
    }
    @AfterTest(alwaysRun = true)
    public void test_closure(){
        driver.close();
    }
    @Test(groups = {"HeaderTests","ButtonTests"})
    public void test_homepage(){
        System.out.println("Page title :" + driver.getTitle());
        Assert.assertEquals(driver.getTitle(),"Target Practice");
    }

    @Test(dependsOnMethods = {"test_homepage"},groups = {"HeaderTests"})
    public void test_Header1() {
        String Third =driver.findElement(By.id("third-header")).getText();
        Assert.assertEquals(Third,"Third header");
    }

    @Test(dependsOnMethods = {"test_homepage"},groups = {"HeaderTests"})
    public void test_Header2() {
        String color = driver.findElement(By.tagName("h5")).getCssValue("color");
        Assert.assertEquals(color,"rgb(33, 186, 69)");
    }

    @Test(dependsOnMethods = {"test_homepage"},groups = {"ButtonTests"})
    public void test_Button1(){
       String olive = driver.findElement(By.cssSelector("button.olive")).getText();
        Assert.assertEquals(olive,"Olive");
    }

    @Test(dependsOnMethods = {"test_homepage"},groups = {"ButtonTests"})
    public void test_Button2(){
        String brown = driver.findElement(By.cssSelector("button.brown")).getText();
        Assert.assertEquals(brown, "Brown");
    }
    @Test
    public void test_test0(){
        System.out.println("I am just Test");
    }
    }

