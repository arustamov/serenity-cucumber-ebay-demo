package ebay.page.container.dropdown;

public class SortDropDown extends BaseDropDown<SortDropDown> {

    private static final String SORT_SELECT_CSS = "#DashSortByContainer";

    public SortDropDown() {
        super(
            SORT_SELECT_CSS,
            BaseDropDown.OPTIONS_CSS,
            BaseDropDown.OPTION_CSS,
            BaseDropDown.SELECTED_OPTION_CSS
        );
    }
}
