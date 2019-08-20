package ebay.page.container;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.support.pagefactory.ByAll;

public class SearchResultsContainer extends PageObject {

    private static final String CONTAINER_CSS = "#ResultSetItems";
    private static final String ITEM_CSS = ".sresult";
    private static final String ITEM_TITLE_CSS = ".lvtitle";
    private static final String ITEM_PRICES_CSS = ".lvprices";
    private static final String ITEM_PRICE_CSS = ".lvprice";
    private static final String ITEM_BIDS_BUY_IT_NOW_CSS = ".lvformat";
    private static final String ITEM_BUY_IT_NOW_LOGO_CSS = ".logoBin";
    private static final String ITEM_BUY_IT_NOW_OR_BEST_OFFER_LOGO_CSS = ".logoBinBo";
    private static final String ITEM_SHIPPING_PRICE_CSS = ".lvshipping";

    public Boolean isDisplayed() {
       return getRenderedView().elementIsCurrentlyVisible(By.cssSelector(CONTAINER_CSS));
    }

    public Integer itemsCount() {
        return find(By.cssSelector(CONTAINER_CSS))
            .thenFindAll(By.cssSelector(ITEM_CSS))
            .size();
    }

    public Boolean hasItemByTitleContains(String title) {
        return find(By.cssSelector(CONTAINER_CSS))
            .thenFindAll(By.cssSelector(ITEM_CSS))
            .stream()
            .anyMatch(item -> item.find(By.cssSelector(ITEM_TITLE_CSS)).getText().contains(title));
    }

    public Boolean allItemsHasPrice() {
        return find(By.cssSelector(CONTAINER_CSS))
            .thenFindAll(By.cssSelector(ITEM_CSS))
            .stream()
            .allMatch(item -> item.find(By.cssSelector(ITEM_PRICES_CSS))
                .then(By.cssSelector(ITEM_PRICE_CSS))
                .isDisplayed()
            );
    }

    public Boolean allItemsHasNoOfBids() {
        return find(By.cssSelector(CONTAINER_CSS))
            .thenFindAll(By.cssSelector(ITEM_CSS))
            .stream()
            .allMatch(item -> item.find(By.cssSelector(ITEM_PRICES_CSS))
                .then(By.cssSelector(ITEM_BIDS_BUY_IT_NOW_CSS))
                .containsText("bid")
            );
    }

    public Boolean allItemsHasShippingPrice() {
        return find(By.cssSelector(CONTAINER_CSS))
            .thenFindAll(By.cssSelector(ITEM_CSS))
            .stream()
            .allMatch(item -> item.find(By.cssSelector(ITEM_PRICES_CSS))
                .then(By.cssSelector(ITEM_SHIPPING_PRICE_CSS))
                .isDisplayed()
            );
    }

    public Boolean allItemsHasBuyItNowTag() {
        return find(By.cssSelector(CONTAINER_CSS))
            .thenFindAll(By.cssSelector(ITEM_CSS))
            .stream()
            .allMatch(item -> item.find(By.cssSelector(ITEM_PRICES_CSS))
                .then(By.cssSelector(ITEM_BIDS_BUY_IT_NOW_CSS))
                .then(new ByAll(
                    By.cssSelector(ITEM_BUY_IT_NOW_LOGO_CSS),
                    By.cssSelector(ITEM_BUY_IT_NOW_OR_BEST_OFFER_LOGO_CSS)
                    )
                )
                .getAttribute("title")
                .contains("Buy it now")
            );
    }

    public String minItemPriceByIndex(Integer index) {
        return find(By.cssSelector(CONTAINER_CSS))
            .thenFindAll(By.cssSelector(ITEM_CSS))
            .get(index)
            .then(By.cssSelector(ITEM_PRICES_CSS))
            .then(By.cssSelector(ITEM_PRICE_CSS))
            .getText()
            .split(" ")[0]
            .split("/")[0];
    }
}
