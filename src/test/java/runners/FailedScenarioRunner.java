package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin={
                "html:target/default-cucumber-reports",
                "json:target/json-reports/cucumber.json",
                "junit:target/xml-report/cucumber.xml",
                 "rerun:target/failedRerun.txt"
        },
//      Running path : @target/failedRerun.txt
        features="@target/failedRerun.txt",
        glue="stepdefinitions",
//      --> fail scenario class'inda tags'e ihtiyacimiz yok.

        dryRun= false
)


public class FailedScenarioRunner {
}
