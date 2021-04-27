package com.example.prototype.color;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ColorEnumStoreTest {

    @Test
    void testCase1() {
        ColorEnumStore colorEnumStore = ColorEnumStore.find(ColorEnumStore.BLACK);

        assertThat(colorEnumStore.newInstance()).isInstanceOf(BlackColor.class);
    }
}
