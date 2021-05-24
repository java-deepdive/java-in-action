package com.example.creational.afactory.coffee;

import com.example.creational.afactory.component.Bean;
import com.example.creational.afactory.component.Milk;
import com.example.creational.afactory.component.Water;
import com.example.domain.Mocha;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MochaTest {

    @Test
    void name() {
        Mocha mocha = new Mocha.Builder(new Bean(), Water.small())
                .milk(Milk.small())
                .build();

        assertThat(mocha).isEqualTo(new Mocha.Builder(new Bean(), Water.small())
                .milk(Milk.small())
                .build());
    }
}
