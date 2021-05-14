package com.example.domain;

import com.example.afactory.component.Bean;
import com.example.afactory.component.Water;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DeepCopyCoffeeTest {

    @DisplayName("깊은 복사")
    @Test
    void testCase1() {
        DeepCopyCoffee coffee = new DeepCopyCoffee(new Bean(), Water.regular(), Brand.NONE);

        // clone을 활용한 깊은 복사
        Coffee deepCopy = coffee.clone();

        assertThat(coffee).isEqualTo(deepCopy);
    }
}
