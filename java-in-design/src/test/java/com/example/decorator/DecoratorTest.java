package com.example.decorator;

import com.example.decorator.addtive.Component;
import com.example.decorator.addtive.Hazelnut;
import com.example.decorator.addtive.Milk;
import com.example.decorator.addtive.Mocha;
import com.example.decorator.component.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DecoratorTest {

    @DisplayName("Decorator 패턴으로 만든 라떼 생성 테스트")
    @Test
    void testCase1() {
        Decorator coffee = new Latte(new Espresso(), new Milk());

        assertThat(coffee.cost()).isEqualTo(4000);
    }

    @DisplayName("모카 라떼 생성 가격 확인 테스트")
    @Test
    void testCase2() {
        // given
        Component espresso = new Espresso();
        Component milk = new Milk();
        Latte latte = new Latte(espresso, milk);

        Component component = new Mocha();
        Decorator mochaLatte = new MochaLatte(latte, component);
        // when
        double cost = mochaLatte.cost();

        // then
        assertThat(cost).isEqualTo(4500);
    }

    @DisplayName("라떼 생성 테스트")
    @Test
    void testCase3() {
        // given
        Component espresso = new Espresso();
        Component milk = new Milk();

        // when
        Latte latte = new Latte(espresso, milk);

        // then
        assertThat(latte.toString()).contains("라떼");
    }

    @DisplayName("모카라떼 생성 테스트")
    @Test
    void testCase4() {
        // given
        Component espresso = new Espresso();
        Component milk = new Milk();
        Latte latte = new Latte(espresso, milk);

        // when
        Component component = new Mocha();
        Decorator mochaLatte = new MochaLatte(latte, component);

        // then
        assertThat(mochaLatte.toString()).contains("모카라떼");
    }

    @DisplayName("헤이즐넛 라떼 생성 테스트")
    @Test
    void testCase5() {
        // given
        Component espresso = new Espresso();
        Component milk = new Milk();
        // when
        Component component = new Hazelnut();
        Decorator hazelnut = new HazelnutLatte(espresso, milk, component);
        // then
        assertThat(hazelnut.cost()).isEqualTo(5_000);
        assertThat(hazelnut.toString()).contains("헤이즐넛라떼");
    }
}
