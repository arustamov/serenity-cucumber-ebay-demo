package ebay.step;

import ebay.page.container.FilterContainer;
import net.thucydides.core.annotations.Step;

public class FilterStep {

    private FilterContainer filterContainer;

    @Step
    public void filterResultsBy(final String filter) {
        filterContainer.clickFilterOption(filter);
    }
}
