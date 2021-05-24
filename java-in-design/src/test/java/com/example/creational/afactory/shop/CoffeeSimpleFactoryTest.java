package com.example.creational.afactory.shop;

import com.example.creational.afactory.barista.CoffeeSimpleFactory;
import com.example.creational.afactory.component.Milk;
import com.example.domain.Coffee;
import com.example.domain.Hazelnut;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CoffeeSimpleFactoryTest {

    @DisplayName("헤이즐넛 생성")
    @Test
    void testCase() {
        // when
        Coffee coffee = CoffeeSimpleFactory.makeHazelnut(Milk.small());
        // then
        assertThat(coffee).isInstanceOf(Hazelnut.class);
    }
}
