package StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class GoogleSearchSteps {
    WebDriver driver;
    WebDriverWait wait;
    @Given("^User is on the Google Page$")
    public void Google_Page(){
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        driver.get("https://www.google.com/");
        System.out.println("Title is :" + driver.getTitle());
    }
    @When("^User types in Cheese and hit Enter$")
    public void User_Search(){
        driver.findElement(By.id("APjFqb")).sendKeys("Cheese", Keys.ENTER);
    }
    @Then("^Show how many search results were Shown$")
        public void Search_Result(){
        //wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("result-stats")));
        String result = driver.findElement(By.id("result-stats")).getText();
        System.out.println("No of Search Results Found :" + result);
        }
    @And("^Close the Browser$")
    public void Close_Browser(){
        driver.close();
    }
}
