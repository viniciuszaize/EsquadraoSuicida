package BancodoBrasil.com.alelo.BBContratacao;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
        features = {"src/test/resources/features/BBFeatures/BBcontrato.feature"},
        plugin = {"json:target/cluecumber-report/json/cucumber.json", "junit:target/junit.xml"},
//                "plugins.alelo.teams.Report", "plugins.alelo.azure.runner.AzureIntegration"},
      //  glue = {"br.com.alelo.steps"},
        tags = ""
)
public class RunBBcontracaocucumberTest extends AbstractTestNGCucumberTests {


}
