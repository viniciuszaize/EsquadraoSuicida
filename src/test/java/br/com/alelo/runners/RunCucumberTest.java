package br.com.alelo.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;


@CucumberOptions(
        features = {"src/test/resources/features/"},
        plugin = {"json:target/cluecumber-report/json/cucumber.json", "junit:target/junit.xml"},
//                "plugins.alelo.teams.Report", "plugins.alelo.azure.runner.AzureIntegration"},
        glue = {"br.com.alelo.steps"},
        tags = ""
)
public class RunCucumberTest extends AbstractTestNGCucumberTests {


    //Set parallel to false for default execution
    //Set the Thread limit using the mvn option "-Ddataproviderthreadcount=<numberOfThreads>"
    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}

