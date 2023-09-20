package dummy;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

public class Activity1_AppiumProject {
    AndroidDriver driver;
    WebDriverWait wait;
    @BeforeClass
    public void setUp() throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("android");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.google.android.apps.tasks");
        options.setAppActivity(".ui.TaskListsActivity");
        options.noReset();
        URL server_Url = new URL("http://localhost:4723/wd/hub");
        driver = new AndroidDriver(server_Url,options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    public void GoogleTask() throws InterruptedException {
        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.className("android.widget.FrameLayout")));
        add_task("Complete Activity with Google Tasks");
        add_task("Complete Activity with Google Keep");
        add_task("Complete the second Activity Google Keep");
        //Thread.sleep(2000);
        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.id("com.google.android.apps.tasks:id/task_name")));
        List<WebElement> size =driver.findElements(AppiumBy.id("com.google.android.apps.tasks:id/task_name"));
        int no_of_task = size.size();
        Assert.assertEquals(no_of_task,3);
        int i;
        for (i =0;i<no_of_task;i++) {
            wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.accessibilityId("Mark as complete")));
            driver.findElement(AppiumBy.accessibilityId("Mark as complete")).click();
        }

    }
    public void add_task(String task){
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.accessibilityId("Create new task")));
        driver.findElement(AppiumBy.accessibilityId("Create new task")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("add_task_title")));
        driver.findElement(AppiumBy.id("add_task_title")).sendKeys(task);
        driver.findElement(AppiumBy.id("add_task_done")).click();
    }
    @AfterClass
    public void close_task(){
      // driver.quit();
    }
}
