package BrokerEC.alelo.com.br.BrokerContratar;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"src/test/resources/features/BrokerFeatures/BrokerContratar.feature"},
        plugin = {"json:target/cluecumber-report/json/cucumber.json", "junit:target/junit.xml"},
//                "plugins.alelo.teams.Report", "plugins.alelo.azure.runner.AzureIntegration"},
        //  glue = {"br.com.alelo.steps"},
        tags = ""
)

public class RunBrokerContratarTest extends AbstractTestNGCucumberTests {
}
