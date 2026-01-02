package testRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
import org.junit.Test;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/features/Products.feature"},
        glue = {"stepDefinitions","appHooks"},
        dryRun = false,
        monochrome = true,
        plugin = {
                "pretty","html:target/cucumber-reports/cucumber.html",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
        }
)

public class TestRunner {
}
