package kr.seok.calculate;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class StringAddTest {

    @DisplayName("문자열 숫자 연산 확인 테스트")
    @Test
    void testCase1() {
        StringAdd stringAdd = new StringAdd();

        String sum = stringAdd.solution1("1234", "5678");

        assertThat(sum).isEqualTo("6912");
    }

    @DisplayName("테스트 2")
    @Test
    void testCase2() {
        StringAdd add = new StringAdd();
        String num = add.solution1("0000", "00");

        assertThat(num).isEqualTo("0");
    }
}
