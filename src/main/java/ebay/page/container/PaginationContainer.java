package ebay.page.container;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;

public class PaginationContainer extends PageObject {

    private static final String CONTAINER_CSS = "#Pagination";
    private static final String PAGES_CSS = ".pages";
    private static final String PAGE_CSS = "a";

    public Integer pagesCount() {
        return find(By.cssSelector(CONTAINER_CSS))
            .then(By.cssSelector(PAGES_CSS))
            .thenFindAll(By.cssSelector(PAGE_CSS))
            .size();
    }

    public void clickPageNumber(String number) {
        find(By.cssSelector(CONTAINER_CSS))
            .then(By.cssSelector(PAGES_CSS))
            .thenFindAll(By.cssSelector(PAGE_CSS))
            .stream()
            .filter(opt -> opt.getText().equals(number))
            .findFirst()
            .get()
            .click();
    }
}
