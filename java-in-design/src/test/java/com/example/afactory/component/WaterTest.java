package com.example.afactory.component;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class WaterTest {

    @DisplayName("물 객체 생성 및 클론 테스트")
    @Test
    void testCase1() {
        // given
        Water water = new Water(50);
        // when
        Water expected = water.clone();
        // then
        assertThat(water).isEqualTo(expected);
    }
}
