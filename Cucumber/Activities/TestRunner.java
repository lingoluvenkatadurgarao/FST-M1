package testRunner;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features ="src/test/java/Features",
        glue = {"StepDefinitions"},
        //tags ="@SmokeTest",
        //tags ="@Activity5",
        tags ="@Datatable",
        plugin = {"pretty"},
        //plugin = {"progress"},
        //plugin = {"html:test-reports"},
        //plugin = {"html:target/cucumber-reports/reports"},
        //plugin = {"json:target/cucumber-reports/json-report.json"},
        //plugin = {"junit:target/cucumber-reports/reports"},
        monochrome = true
        //tags ="@SimpleAlert and @SmokeTest"
        //tags = "@ConfirmAlert"
        //tags = "@PromptAlert"


)
public class TestRunner {

}
