package ebay.entity.enums;

public enum SessionVariable {

    ACTOR,
    CATEGORY,
    CUSTOMER,
    ITEM,
    SCENARIO_NAME
    ;

    public static SessionVariable from(String variable) {
        for (SessionVariable sv : SessionVariable.values()) {
            if (variable.toUpperCase().replaceAll(" ", "_").equals(sv.name())) {
                return sv;
            }
        }
        throw new RuntimeException(String.format("There is no '%s' session variable", variable));
    }
}
