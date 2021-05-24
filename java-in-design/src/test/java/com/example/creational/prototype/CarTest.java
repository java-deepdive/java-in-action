package com.example.creational.prototype;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {

    @DisplayName("클론 테스트")
    @Test
    void testCase1() {
        // given
        Car car = new Car("BMW");
        Car clone = car.clone();
        // then
        assertThat(car).isEqualTo(clone);
    }
}
