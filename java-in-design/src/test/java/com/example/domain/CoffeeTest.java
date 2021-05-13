package com.example.domain;

import com.example.afactory.component.Bean;
import com.example.afactory.component.Water;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CoffeeTest {

    @DisplayName("커피 복제하기")
    @Test
    void testCase1() {
        Coffee coffee = new Americano.Builder(new Bean(), Water.regular()).build();

        Coffee clone = coffee.clone();

        assertThat(coffee).isEqualTo(clone);
    }
}
