import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = "pretty", monochrome = true, snippets = CucumberOptions.SnippetType.CAMELCASE,
        dryRun =  false, strict = false,
        features = "src/test/java/Feature.feature"
)
public class Runner {

}
