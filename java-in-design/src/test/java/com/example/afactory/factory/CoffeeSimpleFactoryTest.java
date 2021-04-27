package com.example.afactory.factory;

import com.example.afactory.component.Milk;
import com.example.afactory.domain.Coffee;
import com.example.afactory.domain.Hazelnut;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CoffeeSimpleFactoryTest {

    @Test
    void testCase() {
        // when
        Coffee coffee = CoffeeSimpleFactory.makeHazelnut(new Milk());
        // then
        assertThat(coffee).isInstanceOf(Hazelnut.class);
    }
}
