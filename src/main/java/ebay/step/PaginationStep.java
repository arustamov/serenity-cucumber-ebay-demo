package ebay.step;

import ebay.page.container.PaginationContainer;
import net.thucydides.core.annotations.Step;
import org.assertj.core.api.Assertions;

public class PaginationStep {

    private PaginationContainer paginationContainer;

    @Step
    public void goToPage(final Integer number) {
        paginationContainer.clickPageNumber(String.valueOf(number));
    }

    @Step
    public void verifyPagesCountGreaterThan(Integer count) {
        Assertions.assertThat(
            paginationContainer.pagesCount()
        )
            .as("Verify pages count greater than")
            .isGreaterThan(count);
    }
}
