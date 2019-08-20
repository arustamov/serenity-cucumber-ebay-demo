package ebay.step;

import ebay.page.container.SearchForm;
import net.thucydides.core.annotations.Step;

public class SearchStep {

    private SearchForm searchForm;

    @Step
    public void searchFor(final String item) {
        searchForm.typeInSearchInput(item);
        searchForm.clickSearchButton();
    }

    @Step
    public void selectCategory(final String category) {
        searchForm.selectCategory(category);
    }
}
