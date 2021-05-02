package com.example.afactory.shop;

import com.example.afactory.barista.CoffeeSimpleFactory;
import com.example.afactory.coffee.Coffee;
import com.example.afactory.coffee.Hazelnut;
import com.example.afactory.component.Milk;
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
