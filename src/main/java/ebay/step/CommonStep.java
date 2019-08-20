package ebay.step;

import ebay.page.HomePage;
import ebay.page.container.dropdown.GDPRBannerContainer;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.DefaultTimeouts;
import net.thucydides.core.annotations.Step;

public class CommonStep {

    private HomePage homePage;
    private GDPRBannerContainer gdprBannerContainer;

    @Step
    public void setSessionVariable(Object variableName, Object variableValue) {
        Serenity.setSessionVariable(variableName).to(variableValue);
    }

    @Step
    public void openHomePage() {
        homePage.open();
    }

    @Step
    public void waitForGDPR() {
        gdprBannerContainer.withTimeoutOf(
            DefaultTimeouts.DEFAULT_WAIT_FOR_TIMEOUT
        )
            .waitFor(driver -> gdprBannerContainer.isDisplayed());
    }

    @Step
    public void acceptGDPR() {
        gdprBannerContainer.clickAccept();
    }
}
