package ebay.page.container;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;

public class FilterContainer extends PageObject {

    private static final String CONTAINER_CSS = ".asp.pnl.left";
    private static final String FILTER_OPTION_CSS = "a";

    public void clickFilterOption(String option) {
        find(By.cssSelector(CONTAINER_CSS))
            .thenFindAll(By.cssSelector(FILTER_OPTION_CSS))
            .stream()
            .filter(opt -> opt.getText().equals(option))
            .findFirst()
            .get()
            .click();
    }
}
