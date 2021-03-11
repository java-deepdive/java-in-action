package kr.seok.step3.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PositionTest {

    @Test
    void testCase1() {
        Position position = new Position(3);
        assertThat(position).isEqualTo(new Position(3));
    }
}
