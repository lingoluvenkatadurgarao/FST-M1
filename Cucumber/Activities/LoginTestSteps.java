package StepDefinitions;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class LoginTestSteps {
    WebDriver driver;

    @Given("^User is on the Login Page$")
    public void OpenBrowser(){
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.get("https://v1.training-support.net/selenium/login-form");
    }
    @When("^User enter UserName and Password$")
    public void Login(){
        driver.findElement(By.id("username")).sendKeys("admin");
        driver.findElement(By.id("password")).sendKeys("password");
        driver.findElement(By.xpath("//button[text() = 'Log in']")).click();
    }
    @When("User enter {string} and {string}")
    public void Login(String Username,String Password){
        driver.findElement(By.id("username")).sendKeys(Username);
        driver.findElement(By.id("password")).sendKeys(Password);
        driver.findElement(By.xpath("//button[text() = 'Log in']")).click();
    }
    @Then("^Read the Page Title and Confirmation Message$")
    public void Success(){
        String confirm =driver.findElement(By.id("action-confirmation")).getText();
        String title =driver.getTitle();
        System.out.println("Title of Page :" + title);
        System.out.println("Login Confirmation :" +confirm);
        if(confirm.contains("admin")){
            Assert.assertEquals(confirm,"Welcome Back, admin");
        }else {
            Assert.assertEquals(confirm, "Invalid Credentials");
        }
    }
    @And("^Close the Browser!$")
    public void close(){
        driver.close();
    }
}
