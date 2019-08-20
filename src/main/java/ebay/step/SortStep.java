package ebay.step;

import ebay.page.container.dropdown.SortDropDown;
import net.thucydides.core.annotations.Step;

public class SortStep {

    private SortDropDown sortSelectDropDown;

    @Step
    public void selectCategory(final String category) {

    }

    @Step
    public void expandSortOptions() {
        sortSelectDropDown.clickSelectDropDown();
    }

    @Step
    public void selectSortOption(final String sort) {
        sortSelectDropDown.clickOption(sort);
    }
}
