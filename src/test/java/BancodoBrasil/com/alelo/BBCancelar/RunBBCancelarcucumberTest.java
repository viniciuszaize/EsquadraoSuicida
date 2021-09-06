package BancodoBrasil.com.alelo.BBCancelar;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;


@CucumberOptions(
        features = {"src/test/resources/features/BBcancelarContrato.feature"},
        plugin = {"json:target/cluecumber-report/json/cucumber.json", "junit:target/junit.xml"},
//                "plugins.alelo.teams.Report", "plugins.alelo.azure.runner.AzureIntegration"},
        //  glue = {"br.com.alelo.steps"},
        tags = ""
)
public class RunBBCancelarcucumberTest extends AbstractTestNGCucumberTests {
    
}
