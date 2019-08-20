package ebay.stepdefinition;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import ebay.config.SpringContextAware;
import ebay.step.PaginationStep;
import net.thucydides.core.annotations.Shared;

@SuppressWarnings("unchecked")
public class PaginationStepDefinition implements SpringContextAware {

    @Shared
    private PaginationStep paginationStep;

    @When("^I go to results page (\\d+)$")
    public void i_go_to_results_page(Integer page) {
        paginationStep.goToPage(page);
    }

    @Then("I should see that results show more than (\\d+) pages?")
    public void i_should_see_that_results_show_more_than_pages(Integer pages) {
        paginationStep.verifyPagesCountGreaterThan(pages);
    }
}
