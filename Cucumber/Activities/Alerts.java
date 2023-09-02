package StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Alerts {
    WebDriver driver;
    Alert alert;
    WebDriverWait wait;

    @Given("^User is on the Home page$")
    public void setUP(){
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.get("https://v1.training-support.net/selenium/javascript-alerts");
    }
    @When("^User clicks the Simple Alert Button$")
    public void SimpleAlert(){
        driver.findElement(By.id("simple")).click();
    }
    @When("^User click on Confirm Alert Button$")
    public void ConfirmAlert(){
        driver.findElement(By.id("confirm")).click();
    }
    @When("^User Clicks Prompt Alert Button$")
    public void PromptAlert(){
        driver.findElement(By.id("prompt")).click();
    }
    @Then("^Alert Opens$")
    public void Alert_Open(){
        alert =driver.switchTo().alert();
    }
    @And("^Read the text form it and Print it$")
    public void text(){
        System.out.println("Alert Message is :" +alert.getText());
    }
    @And("^Close the Alert$")
    public void Close_Alert(){
        alert.accept();
    }
    @And("^Write a custom message in it$")
    public void Custom_Message() throws InterruptedException {
        alert.sendKeys("I am Happy!");
        Thread.sleep(1000);
    }
    @And("^Close the Alert with Cancel$")
    public void Alert_cancel(){
        alert.dismiss();
    }
    @And("^Read the result text$")
    public void result(){

       /*String result =driver.findElement(By.tagName("p")).getText();
       System.out.println("Result is :"+result);*/
        System.out.println("I am Executed!");
    }
    @And("^Close Browser$")
    public void Close_Browser(){
        driver.close();
    }
}
