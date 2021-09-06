package BrokerEC.alelo.com.br.BrokerCancelar;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"src/test/resources/features/BrokerFeatures/BrokerCancelar.feature"},
        plugin = {"json:target/cluecumber-report/json/cucumber.json", "junit:target/junit.xml"},
//                "plugins.alelo.teams.Report", "plugins.alelo.azure.runner.AzureIntegration"},
        //  glue = {"br.com.alelo.steps"},
        tags = ""
)

public class RunBrokerCancelarTest extends AbstractTestNGCucumberTests {

}
