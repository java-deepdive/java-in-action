package com.example.decorator;

import com.example.decorator.addtive.Mocha;
import com.example.decorator.component.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CoffeeTest {

    @DisplayName("Decorator 패턴으로 만든 라떼 생성 테스트")
    @Test
    void testCase1() {
        Coffee coffee = new Latte(new Espresso(), new Milk());

        assertThat(coffee.cost()).isEqualTo(5000);
    }

    @DisplayName("모카 라떼 생성 테스트")
    @Test
    void testCase2() {
        // given
        Latte latte = new Latte(new Espresso(), new Milk());
        Coffee mochaLatte = new MochaLatte(latte, new Mocha());
        // when
        double cost = mochaLatte.cost();

        // then
        assertThat(cost).isEqualTo(5500);
    }

    @DisplayName("커피 생성 테스트")
    @Test
    void testCase3() {
        Latte latte = new Latte(new Espresso(), new Milk());
        Coffee mochaLatte = new MochaLatte(latte, new Mocha());

        assertThat(mochaLatte.toString()).contains("모카라떼");
    }
}
