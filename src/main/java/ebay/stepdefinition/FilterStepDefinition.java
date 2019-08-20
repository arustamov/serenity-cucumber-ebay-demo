package ebay.stepdefinition;

import cucumber.api.java.en.When;
import ebay.config.SpringContextAware;
import ebay.step.FilterStep;
import net.thucydides.core.annotations.Shared;

@SuppressWarnings("unchecked")
public class FilterStepDefinition implements SpringContextAware {

    @Shared
    private FilterStep filterStep;

    @When("^I filter results by \"([^\"]*)\"$")
    public void i_filter_results_by(String filter) {
        filterStep.filterResultsBy(filter);
    }
}
