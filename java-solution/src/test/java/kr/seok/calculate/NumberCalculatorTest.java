package kr.seok.calculate;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class NumberCalculatorTest {

    @Test
    void testCase1() {
        NumberCalculator cal = new NumberCalculator();
        int solution = cal.solution(15);

        assertThat(solution).isEqualTo(4);
    }
}
