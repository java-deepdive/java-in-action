package kr.seok.item37.company;

import java.util.Arrays;

public enum CompanyTwoTypes implements CompanyTypes {

    BENEFIT_ONE("condition1", "value1"),
    BENEFIT_TWO("condition2", "value2"),
    BENEFIT_THREE("condition3", "value3"),
    EMPTY("", "");

    protected final String condition;
    protected final String value;

    CompanyTwoTypes(String condition, String value) {
        this.condition = condition;
        this.value = value;
    }

    public static CompanyTwoTypes of(String type) {
        return Arrays.stream(values())
                .filter(t -> t.toString().equals(type))
                .findAny()
                .orElse(EMPTY);
    }

    @Override
    public String value(String fieldName, String condition) {
        String types = of(fieldName).condition;
        String value = of(fieldName).value;
        if (types.equals(condition)) {
            return value;
        }
        throw new IllegalArgumentException();
    }
}
