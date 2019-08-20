package ebay.page.container.dropdown;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;

public class GDPRBannerContainer extends PageObject {

    private static final String CONTAINER_CSS = "#gdpr-banner";
    private static final String ACCEPT_BUTTON_CSS = "#gdpr-banner-accept";

    public Boolean isDisplayed() {
        return getRenderedView().elementIsCurrentlyVisible(By.cssSelector(CONTAINER_CSS));
    }

    public void clickAccept() {
        find(By.cssSelector(CONTAINER_CSS))
            .then(By.cssSelector(ACCEPT_BUTTON_CSS))
            .click();
    }
}
