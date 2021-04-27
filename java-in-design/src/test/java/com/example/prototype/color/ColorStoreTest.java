package com.example.prototype.color;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ColorStoreTest {

    @Test
    void testCase1() {
        Color black = ColorStore.getColor("black");

        assertThat(black).isInstanceOf(BlackColor.class);
    }
}
