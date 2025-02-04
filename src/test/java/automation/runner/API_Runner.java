package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        features = {"src/test/resources/features/api"},
        glue = { "automation.stepdefinitions.api" },
        plugin = { "pretty"},
        tags = "@api8",
        dryRun = false,
        publish = false
)

public class API_Runner extends AbstractTestNGCucumberTests {

        @Override
        @DataProvider(parallel = false) // Paralel test çalıştırmayı etkinleştirir
        public Object[][] scenarios() {
                return super.scenarios();
        }
}