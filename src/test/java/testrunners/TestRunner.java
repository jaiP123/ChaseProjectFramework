package testrunners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/GoogleSearch.feature", //the path of the feature files
        glue = {"stepDefinition"}, //the path of the step definition files
        tags = "@sanity",
        monochrome= true,
        plugin = {"pretty", "junit:target/JUnitReports/report.xml",
                "json:target/cucumber.json",
                "html:target/HTMLReport.html",
        }
)

public class TestRunner {

}
