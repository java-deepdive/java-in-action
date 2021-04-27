package com.example.afactory.coffee;

import com.example.afactory.component.Bean;
import com.example.afactory.component.Milk;
import com.example.afactory.component.Water;
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
