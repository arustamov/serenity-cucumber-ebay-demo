package ebay.page.container.dropdown;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;

public class BaseDropDown<T> extends PageObject {

    protected static final String OPTIONS_CSS = "#SortMenu";
    protected static final String OPTION_CSS = "a";
    protected static final String SELECTED_OPTION_CSS = ".sel a";

    private String containerCss;
    private String optionsCss;
    private String optionCss;
    private String selectedOptionCss;

    public BaseDropDown(String containerCss,
                          String optionsCss,
                          String optionCss,
                          String selectedOptionCss) {
        this.containerCss = containerCss;
        this.optionsCss = optionsCss;
        this.optionCss = optionCss;
        this.selectedOptionCss = selectedOptionCss;
    }

    public Boolean isDisplayed() {
        return isElementVisible(By.cssSelector(containerCss));
    }

    public Boolean isExpanded() {
        return isElementVisible(By.cssSelector(String.format("%s %s", containerCss, optionsCss)));
    }

    public T scrollIntoView() {
        evaluateJavascript("arguments[0].scrollIntoView(arguments[1]);", find(By.cssSelector(containerCss)), false);
        return (T) this;
    }

    public T clickSelectDropDown() {
        find(By.cssSelector(containerCss))
                .click();
        return (T) this;
    }

    public Boolean hasOption(String option) {
        return find(By.cssSelector(containerCss))
                .then(By.cssSelector(optionsCss))
                .thenFindAll(By.cssSelector(optionCss))
                .stream()
                .filter(opt -> opt.getText().equals(option))
                .findFirst()
                .orElse(null) != null;
    }

    public T clickOption(String option) {
        find(By.cssSelector(containerCss))
            .then(By.cssSelector(optionsCss))
            .thenFindAll(By.cssSelector(optionCss))
            .stream()
            .filter(opt -> opt.getText().equals(option))
            .findFirst()
            .get()
            .click();
        return (T) this;
    }

    public T clickOptionContains(String option) {
        find(By.cssSelector(containerCss))
                .then(By.cssSelector(optionsCss))
                .thenFindAll(By.cssSelector(optionCss))
                .stream()
                .filter(opt -> opt.getText().contains(option))
                .findFirst()
                .get()
                .click();
        return (T) this;
    }

    public T clickOptionIndex(Integer index) {
        find(By.cssSelector(containerCss))
                .then(By.cssSelector(optionsCss))
                .thenFindAll(By.cssSelector(optionCss))
                .get(index)
                .click();
        return (T) this;
    }

    public String selectedOption() {
        return find(By.cssSelector(containerCss))
                .then(By.cssSelector(selectedOptionCss))
                .getText();
    }

    public Integer optionsCount() {
        return find(By.cssSelector(containerCss))
                .then(By.cssSelector(optionsCss))
                .thenFindAll(By.cssSelector(optionCss))
                .size();
    }

    public T waitForDisappear() {
        waitForRenderedElementsToDisappear(By.cssSelector(String.format("%s %s", containerCss, optionsCss)));
        return (T) this;
    }
}
