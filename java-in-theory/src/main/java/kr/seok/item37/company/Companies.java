package kr.seok.item37.company;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public enum Companies {

    COMPANY_ONE(Arrays.asList(CompanyOneTypes.BENEFIT_ONE, CompanyOneTypes.BENEFIT_TWO)),
    COMPANY_TWO(Arrays.asList(CompanyTwoTypes.BENEFIT_ONE, CompanyTwoTypes.BENEFIT_TWO, CompanyTwoTypes.BENEFIT_THREE)),
    EMPTY(Collections.emptyList());

    private final List<CompanyTypes> list;

    Companies(List<CompanyTypes> list) {
        this.list = list;
    }

    public static Companies findOfCompany(Companies company) {
        return Arrays.stream(values())
                .filter(companies -> companies.equals(company))
                .findFirst()
                .orElse(EMPTY);
    }

    public static String of(Companies company, String fieldName, String condition) {
        List<CompanyTypes> comp = findOfCompany(company).list;
        for (CompanyTypes item : comp) {
            if (item.toString().equals(fieldName)) {
                return item.value(fieldName, condition);
            }
        }
        throw new IllegalArgumentException();
    }
}
