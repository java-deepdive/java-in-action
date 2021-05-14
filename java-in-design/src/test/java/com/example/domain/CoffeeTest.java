package com.example.domain;

import com.example.afactory.component.Bean;
import com.example.afactory.component.Water;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Coffee 복사 관련 테스트")
class CoffeeTest {

    @DisplayName("Shallow Copy 테스트")
    @Test
    void testCase2() {
        // given
        Bean bean = new Bean();
        Water regular = Water.regular();
        // when
        Coffee coffee = new Americano.Builder(bean, regular).build();
        // 다른 개체로 필드 값만 복사 하는 방법
        Coffee swallowCopy = new Americano.Builder(bean, regular).build();
        // then
        assertThat(coffee).isEqualTo(swallowCopy);
    }

    @DisplayName("커피 clone 인스턴스 확인 테스트")
    @Test
    void testCase1() {
        // given
        Coffee coffee = new Americano.Builder(new Bean(), Water.regular()).build();
        // when
        Coffee clone = coffee.clone();
        // then
        assertThat(coffee).isEqualTo(clone);
    }

    @DisplayName("Deap Copy 첫 번째 방법")
    @Test
    void testCase3() {
    }
}
