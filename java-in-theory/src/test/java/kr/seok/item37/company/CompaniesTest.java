package kr.seok.item37.company;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CompaniesTest {

    @DisplayName("회사별 테이블 컬럼 내에 값에 따른 ")
    @Test
    void testCase1() {
        // 회사, DB Column, attribute
        String of = Companies.of(Companies.COMPANY_ONE, "BENEFIT_ONE", "condition1");

        assertThat(of).isEqualTo("value1");
    }
}
