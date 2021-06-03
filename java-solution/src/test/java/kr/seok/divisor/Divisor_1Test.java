package kr.seok.divisor;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class Divisor_1Test {

    @DisplayName("약수 찾기")
    @Test
    void testCase1() {
        Divisor_1 divisor = new Divisor_1();
        int solution = divisor.solution(13, 17);
        assertThat(solution).isEqualTo(43);
    }

    @DisplayName("약수 찾기 2")
    @Test
    void testCase2() {
        Divisor_1 divisor = new Divisor_1();
        int solution = divisor.solution(24, 27);
        assertThat(solution).isEqualTo(52);

    }
}
