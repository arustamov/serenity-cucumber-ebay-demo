package ebay.page;

import java.time.Duration;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.WhenPageOpens;
import org.openqa.selenium.By;

@DefaultUrl("page:home.page")
public class HomePage extends PageObject {

    private static final String PAGE_CONTENT_CSS = "#mainContent";
    private static final String SIGN_UP_LINK_CSS = ".signup";
    private static final String LOG_IN_LINK_CSS = ".login";
    private static final String PROFILE_CIRCLE_CSS = ".profile-circle";
    private static final String FIND_GYMS_BUTTON_CSS = ".select-button";

    @WhenPageOpens
    public HomePage waitForPageContentLoaded() {
        withTimeoutOf(Duration.ofSeconds(30))
                .waitFor(By.cssSelector(PAGE_CONTENT_CSS));
        return this;
    }

    public HomePage clickSignUp() {
        find(By.cssSelector(SIGN_UP_LINK_CSS))
                .click();
        return this;
    }

    public HomePage clickLogIn() {
        find(By.cssSelector(LOG_IN_LINK_CSS))
                .click();
        return this;
    }

    public Boolean isProfileCircleDisplayed() {
        return isElementVisible(By.cssSelector(PROFILE_CIRCLE_CSS));
    }

    public HomePage clickFindGyms() {
        find(By.cssSelector(FIND_GYMS_BUTTON_CSS))
                .click();
        return this;
    }

    public HomePage clickProfileCircle() {
        find(By.cssSelector(PROFILE_CIRCLE_CSS)).click();
        return this;
    }

    public boolean hasFindGymsButtonText(String text) {
        return find(By.cssSelector(PAGE_CONTENT_CSS))
                .then(By.cssSelector(FIND_GYMS_BUTTON_CSS)).getText().equals(text);
    }

    public String getPageTitle() {
        return getTitle();
    }
}
