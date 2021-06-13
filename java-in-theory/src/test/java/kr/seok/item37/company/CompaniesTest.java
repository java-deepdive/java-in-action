package kr.seok.item37.company;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CompaniesTest {

    @Test
    void testCase1() {
        String of = Companies.of(Companies.COMPANY_ONE, "BENEFIT_ONE", "condition1");

        assertThat(of).isEqualTo("value1");
    }
}
