package com.example.creational.afactory.component;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class WaterTest {

    @DisplayName("물 객체 생성 및 클론 테스트")
    @Test
    void testCase1() {
        // given
        Water water = Water.small();
        // when
        // then
        assertThat(water).isEqualTo(Water.small());
    }
}
