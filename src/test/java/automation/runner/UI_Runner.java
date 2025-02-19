package automation.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        features = {"src/test/resources/features/ui"},
        glue = { "automation.stepdefinitions.ui" },
        plugin = { "pretty"},
        tags = "@test",
        dryRun = false,
        publish = false
)

public class UI_Runner extends AbstractTestNGCucumberTests {

    @Override
    @DataProvider(parallel = false) // Paralel test çalıştırmayı etkinleştirir
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
