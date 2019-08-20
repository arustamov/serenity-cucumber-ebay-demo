package ebay.step;

import ebay.page.container.SearchResultsContainer;
import net.thucydides.core.annotations.Step;
import org.assertj.core.api.Assertions;

public class ResultsStep {

    private SearchResultsContainer searchResultsContainer;

    @Step
    public void verifySearchResultsDisplayed() {
        Assertions.assertThat(
            searchResultsContainer.isDisplayed()
        )
            .as("Verify search results displayed")
            .isTrue();
    }

    @Step
    public void verifyAllItemsHasPrices() {
        Assertions.assertThat(
            searchResultsContainer.allItemsHasPrice()
        )
            .as("Verify all items has price")
            .isTrue();
    }

    @Step
    public void verifyAllItemsHasNoOfBids() {
        Assertions.assertThat(
            searchResultsContainer.allItemsHasNoOfBids()
        )
            .as("Verify all items has no of bids")
            .isTrue();
    }

    @Step
    public void verifyAllItemsHasShippingPrices() {
        Assertions.assertThat(
            searchResultsContainer.allItemsHasShippingPrice()
        )
            .as("Verify all items has shipping price")
            .isTrue();
    }

    @Step
    public void verifyAllItemsHasBuyItNowTag() {
        Assertions.assertThat(
            searchResultsContainer.allItemsHasBuyItNowTag()
        )
            .as("Verify all items has buy it now tag")
            .isTrue();
    }

    @Step
    public void verifyFirstItemPriceIsLessThanOrEqualToLastItemPrice() {
        final Integer itemsCount = searchResultsContainer.itemsCount();
        final Double firstItemPrice = extractPrice(
            searchResultsContainer.minItemPriceByIndex(0)
        );
        final Double lastItemPrice = extractPrice(
            searchResultsContainer.minItemPriceByIndex(itemsCount - 1)
        );
        Assertions.assertThat(
            firstItemPrice
        )
            .as("Verify first item price is less than or equal to last item price")
            .isLessThanOrEqualTo(lastItemPrice);
    }

    @Step
    public void verifyFirstItemPriceIsGreaterThanOrEqualTooLastItemPrice() {
        final Integer itemsCount = searchResultsContainer.itemsCount();
        final Double firstItemPrice = extractPrice(
            searchResultsContainer.minItemPriceByIndex(0)
        );
        final Double lastItemPrice = extractPrice(
            searchResultsContainer.minItemPriceByIndex(itemsCount - 1)
        );
        Assertions.assertThat(
            firstItemPrice
        )
            .as("Verify first item price is greater than or equal to last item price")
            .isGreaterThanOrEqualTo(lastItemPrice);
    }

    @Step
    public Double extractPrice(String price) {
        return Double.parseDouble(
            price
                .substring(1)
                .replaceAll(",", "")
        );
    }

    @Step
    public void verifyItemDisplayed(final String title) {
        Assertions.assertThat(
            searchResultsContainer.hasItemByTitleContains(title)
        )
            .as("Verify item displayed")
            .isTrue();
    }
}
