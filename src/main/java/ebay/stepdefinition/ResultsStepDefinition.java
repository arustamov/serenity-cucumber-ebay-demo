package ebay.stepdefinition;

import cucumber.api.java.en.Then;
import ebay.config.SpringContextAware;
import ebay.entity.Item;
import ebay.entity.enums.SessionVariable;
import ebay.step.ResultsStep;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Shared;

@SuppressWarnings("unchecked")
public class ResultsStepDefinition implements SpringContextAware {

    @Shared
    private ResultsStep resultsStep;

    @Then("I should see a list of matching results")
    public void i_should_see_a_list_of_matching_results() {
        resultsStep.verifySearchResultsDisplayed();
    }

    @Then("I should see that resulting items has price")
    public void i_should_see_that_resulting_items_has_price() {
        resultsStep.verifyAllItemsHasPrices();
    }

    @Then("I should see that resulting items has postage price")
    public void i_should_see_that_resulting_items_has_postage_price() {
        resultsStep.verifyAllItemsHasShippingPrices();
    }

    @Then("I should see that resulting items has no of bids")
    public void i_should_see_that_resulting_items_has_no_of_bids() {
        resultsStep.verifyAllItemsHasNoOfBids();
    }

    @Then("I should see that resulting items has the 'Buy it now' tag")
    public void i_should_see_that_resulting_items_has_the_buy_it_now_tag() {
        resultsStep.verifyAllItemsHasBuyItNowTag();
    }

    @Then("I should see that resulting items are sorted by price ascending")
    public void i_should_see_that_resulting_items_are_sorted_by_price_ascending() {
        resultsStep.verifyFirstItemPriceIsLessThanOrEqualToLastItemPrice();
    }

    @Then("I should see that resulting items are sorted by price descending")
    public void i_should_see_that_resulting_items_are_sorted_by_price_descending() {
        resultsStep.verifyFirstItemPriceIsGreaterThanOrEqualTooLastItemPrice();
    }

    @Then("I should see the item displayed")
    public void i_should_see_the_item_displayed() {
        final Item item = Serenity.sessionVariableCalled(SessionVariable.ITEM);

        resultsStep.verifyItemDisplayed(item.getTitle());
    }
}
