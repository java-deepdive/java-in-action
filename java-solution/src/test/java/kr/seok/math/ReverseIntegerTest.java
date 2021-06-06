package kr.seok.math;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ReverseIntegerTest {

    @DisplayName("숫자 뒤집기 테스트")
    @Test
    void testCase1() {
        ReverseInteger reverseInteger = new ReverseInteger();

        int reverse = reverseInteger.reverse(123);

        assertThat(reverse).isEqualTo(321);
    }
}
