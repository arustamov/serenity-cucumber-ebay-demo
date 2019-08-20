package ebay.stepdefinition;

import cucumber.api.Scenario;
import cucumber.api.java.Before;
import ebay.config.SpringContextAware;
import ebay.entity.enums.SessionVariable;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;

public class Hook implements SpringContextAware {

    @Managed
    private WebDriver webDriver;

    @Before
    public void beforeScenario(Scenario scenario) {
        Serenity.setSessionVariable(SessionVariable.SCENARIO_NAME).to(scenario.getName());

        webDriver.manage().window().maximize();
    }
}
