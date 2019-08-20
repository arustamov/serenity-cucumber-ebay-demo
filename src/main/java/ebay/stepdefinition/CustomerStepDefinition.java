package ebay.stepdefinition;

import cucumber.api.java.en.Given;
import ebay.config.SpringContextAware;
import ebay.entities.Customers;
import ebay.entity.Customer;
import ebay.entity.enums.SessionVariable;
import net.serenitybdd.core.Serenity;
import org.springframework.beans.factory.annotation.Autowired;

@SuppressWarnings("unchecked")
public class CustomerStepDefinition implements SpringContextAware {

    @Autowired
    private Customers customers;

    @Given("^there is a non-registered customer$")
    public void there_is_a_non_registered_customer() {
        Customer customer = customers.nonRegistered();

        Serenity.setSessionVariable(SessionVariable.CUSTOMER).to(customer);
    }
}
