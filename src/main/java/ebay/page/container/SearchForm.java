package ebay.page.container;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;

public class SearchForm extends PageObject {

    private static final String CONTAINER_CSS = "#gh-f";
    private static final String SEARCH_INPUT_CSS = "#gh-ac";
    private static final String SEARCH_BUTTON_CSS = "#gh-btn";
    private static final String CATEGORY_SELECT_CSS = "#gh-cat";

    public void typeInSearchInput(String text) {
        find(By.cssSelector(CONTAINER_CSS))
            .then(By.cssSelector(SEARCH_INPUT_CSS))
            .type(text);
    }

    public void clickSearchButton() {
        find(By.cssSelector(CONTAINER_CSS))
            .then(By.cssSelector(SEARCH_BUTTON_CSS))
            .click();
    }

    public void selectCategory(String category) {
        selectFromDropdown(
            find(By.cssSelector(CATEGORY_SELECT_CSS)),
            category
        );
    }
}
