package com.example.prototype.color;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ColorTest {

    @DisplayName("프로토 타입 clone() 테스트")
    @Test
    void testCase1() {
        // given
        Color color = new blackColor();
        // when
        Object clone = color.clone();
        // then
        assertThat(color).isEqualTo(clone);
    }
}
