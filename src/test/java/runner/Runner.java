package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        stepNotifications = true,
        features = "src/test/resources/features",
        glue = {"stepdefinition", "hook"},
        plugin = {"html:target/cucumber/cucumber-report.html",
                "json:target/cucumber/cucumber.json"},
        tags = "@LoginUnsuccessful"
)
public class Runner {

}
