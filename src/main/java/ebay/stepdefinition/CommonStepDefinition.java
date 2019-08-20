package ebay.stepdefinition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import ebay.config.SpringContextAware;
import ebay.entities.Customers;
import ebay.entity.Customer;
import ebay.entity.Entity;
import ebay.entity.enums.SessionVariable;
import ebay.step.CommonStep;
import java.util.List;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Shared;
import org.springframework.beans.factory.annotation.Autowired;

@SuppressWarnings("unchecked")
public class CommonStepDefinition implements SpringContextAware {

    @Autowired
    private Customers customers;

    @Shared
    private CommonStep commonStep;

    @Given("^I've selected a random \"([^\"]*)\" from the \"([^\"]*)\"$")
    public void i_ve_selected_a_random_entity_from_the_entities(String variable, String variables) {
        i_select_a_random_entity_from_the_entities(variable, variables);
    }

    @Given("^I've selected a random \"([^\"]*)\" as \"([^\"]*)\" from the \"([^\"]*)\"$")
    public void i_ve_selected_a_random_entity_as_from_the_entities(String variable, List<String> aliases, String variables) {
        i_select_a_random_entity_as_from_the_entities(variable, aliases, variables);
    }

    @Given("^I've acted as the \"([^\"]*)\"$")
    public void i_ve_acted_as_the_user(String variable) {
        i_act_as_the_user(variable);
    }

    @When("^I act as the \"([^\"]*)\"$")
    public void i_act_as_the_user(String variable) {
        Customer customer = Serenity.sessionVariableCalled(SessionVariable.from(variable));

        commonStep.setSessionVariable(SessionVariable.ACTOR, customer);
    }

    @When("^I select a random \"([^\"]*)\" from the \"([^\"]*)\"$")
    public void i_select_a_random_entity_from_the_entities(String variableName, String variablesName) {
        List<Entity> entities = Serenity.sessionVariableCalled(SessionVariable.from(variablesName));

        Entity entity = customers.random(
                entities.stream()
        );

        commonStep.setSessionVariable(SessionVariable.from(variableName), entity);
    }

    @When("^I select a random \"([^\"]*)\" as \"([^\"]*)\" from the \"([^\"]*)\"$")
    public void i_select_a_random_entity_as_from_the_entities(String variableName, List<String> aliases, String variablesName) {
        List<Entity> entities = Serenity.sessionVariableCalled(SessionVariable.from(variablesName));

        entities = customers.random(
                entities.stream(),
                aliases.size()
        );

        for (int i = 0; i < aliases.size(); i++) {
            commonStep.setSessionVariable(aliases.get(i) + SessionVariable.from(variableName), entities.get(i));
        }
    }

    @When("^I navigate to the site$")
    public void i_navigate_to_the_site() {
        commonStep.openHomePage();
        commonStep.waitForGDPR();
        commonStep.acceptGDPR();
    }
}
