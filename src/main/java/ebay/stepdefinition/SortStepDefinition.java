package ebay.stepdefinition;

import cucumber.api.java.en.When;
import ebay.config.SpringContextAware;
import ebay.step.SortStep;
import net.thucydides.core.annotations.Shared;

@SuppressWarnings("unchecked")
public class SortStepDefinition implements SpringContextAware {

    @Shared
    private SortStep sortStep;

    @When("^I sort the results by \"([^\"]*)\"$")
    public void i_sort_the_results_by(String sort) {
        sortStep.expandSortOptions();
        sortStep.selectSortOption(sort);
    }
}
