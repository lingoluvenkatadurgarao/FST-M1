package Activities;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebElement;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class Activity10 {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setup() {
        WebDriverManager.firefoxdriver().setup();
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"NULL");
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://v1.training-support.net/selenium/simple-form");
    }

    public static List<List<Object>> readExcel(String filepath) {
        List<List<Object>> Excel_data = new ArrayList<>();
        try {
            FileInputStream file_stream = new FileInputStream(filepath);
            XSSFWorkbook workbook = new XSSFWorkbook(file_stream);
            XSSFSheet sheet =workbook.getSheetAt(0);
            for(Row row: sheet){
                List<Object> row_data = new ArrayList<>();
                for (Cell cell: row){
                    if(cell != null) {
                        switch (cell.getCellType()) {
                            case NUMERIC -> {
                                row_data.add(cell.getNumericCellValue());
                            }
                            case STRING -> {
                                row_data.add(cell.getStringCellValue());
                            }
                            case BOOLEAN -> {
                                row_data.add(cell.getBooleanCellValue());
                            }

                        }
                    }
                }
                Excel_data.add(row_data);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return Excel_data;
    }
    @DataProvider(name = "Registration")
    public static Object[][] form_data() {
        String filepath ="src/test/resources/UserData.xlsx";
        List<List<Object>> data = readExcel(filepath);
        return new Object[][]{
                { data.get(1)},
                { data.get(2)},
                { data.get(3)}

        };
    }

    @Test(dataProvider = "Registration")
    public void simple_form(List<Object> rows_data) {
        WebElement F_name_field = driver.findElement(By.id("firstName"));
        WebElement L_name_field = driver.findElement(By.id("lastName"));
        WebElement E_mail_field = driver.findElement(By.id("email"));
        WebElement Phone_Num_field = driver.findElement(By.id("number"));

        F_name_field.clear();
        L_name_field.clear();
        E_mail_field.clear();
        Phone_Num_field.clear();

        F_name_field.sendKeys(rows_data.get(1).toString());
        L_name_field.sendKeys(rows_data.get(2).toString());
        E_mail_field.sendKeys(rows_data.get(3).toString());
        Phone_Num_field.sendKeys(rows_data.get(4).toString());



       // driver.findElement(By.cssSelector("input.green")).click();
        driver.findElement(By.xpath("//input[@class = 'ui green button']")).click();
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert =driver.switchTo().alert();
        String Alert_Msg =alert.getText();
        System.out.println("Alert Message :" +Alert_Msg);
        Reporter.log("Alert present and Accepting !");
        alert.accept();
        driver.navigate().refresh();
    }


        @AfterClass
        public void teardown() {
            driver.close();
        }
    }
