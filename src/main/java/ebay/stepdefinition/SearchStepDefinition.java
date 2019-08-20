package ebay.stepdefinition;

import cucumber.api.java.en.When;
import ebay.config.SpringContextAware;
import ebay.entities.Categories;
import ebay.entities.Items;
import ebay.entity.Category;
import ebay.entity.Item;
import ebay.entity.enums.SessionVariable;
import ebay.step.SearchStep;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Shared;
import org.springframework.beans.factory.annotation.Autowired;

@SuppressWarnings("unchecked")
public class SearchStepDefinition implements SpringContextAware {

    @Autowired
    private Items items;
    @Autowired
    private Categories categories;

    @Shared
    private SearchStep searchStep;

    @When("^I search for an item$")
    public void i_search_for_an_item() {
        final Item item = items.newItem();
        searchStep.searchFor(item.getTitle());

        Serenity.setSessionVariable(SessionVariable.ITEM).to(item);
    }

    @When("^I search for an item of the category$")
    public void i_search_for_an_item_of_the_category() {
        Category category = Serenity.sessionVariableCalled(SessionVariable.CATEGORY);

        final Item item = (Item) items.random(
            items.ofTheCategory(category)
        );
        searchStep.searchFor(item.getTitle());

        Serenity.setSessionVariable(SessionVariable.ITEM).to(item);
    }

    @When("^I select a category to search$")
    public void i_select_a_category_to_search() {
        final Category category = (Category) categories.random(
            categories.getAll()
        );
        searchStep.selectCategory(category.getName());

        Serenity.setSessionVariable(SessionVariable.CATEGORY).to(category);
    }
}
