package com.example.domain;

import com.example.afactory.component.Bean;
import com.example.afactory.component.Water;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ConstructorCopyCoffeeTest {

    @DisplayName("생성자 복사를 통한 인스턴스 복사")
    @Test
    void testCase1() {
        // given
        ConstructorCopyCoffee coffee = new ConstructorCopyCoffee(new Bean(), Water.small(), Brand.NONE);
        // when
        ConstructorCopyCoffee constructorCopy = new ConstructorCopyCoffee(coffee);
        // then
        assertThat(coffee).isEqualTo(constructorCopy);
    }
}
