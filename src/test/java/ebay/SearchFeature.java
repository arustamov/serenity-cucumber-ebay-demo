package ebay;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        plugin = {"pretty", "html:target/cucumber"},
        glue = "ebay.stepdefinition",
        features = "classpath:features/search.feature"
)
public class SearchFeature {
}
