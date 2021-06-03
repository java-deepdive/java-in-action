package kr.seok.calculate;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class StringAddTest {

    @DisplayName("문자열 숫자 연산 확인 테스트")
    @Test
    void testCase1() {
        StringAdd stringAdd = new StringAdd();

        String sum = stringAdd.solution1("123400", "567800");

        assertThat(sum).isEqualTo("69120");
    }
}
