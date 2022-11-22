package runners;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberSerenityRunner;
import org.junit.runner.RunWith;

@RunWith(CucumberSerenityRunner.class)
@CucumberOptions(
        features = "src/test/java/metro/assessment/cucumber/features",
        glue = "metro.assessment",
        plugin = { "pretty",
                   "html:target/site/cucumber-pretty",
                   "json:target/cucumber.json"},

        tags = "@test")

public class RunTest {}
