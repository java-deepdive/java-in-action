package com.example.bridge.coffee;

import com.example.afactory.component.Bean;
import com.example.afactory.component.Milk;
import com.example.afactory.component.Water;
import com.example.domain.Americano;
import com.example.domain.Brand;
import com.example.domain.Coffee;
import com.example.domain.Mocha;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BaristaTest {
    @DisplayName("바리스타 커피 만들기")
    @Test
    void testCase1() {
        Barista barista = new StarbucksBarista(new Americano.Builder(new Bean(), Water.regular()).build());

        Coffee coffee = barista.makeCoffee();

        assertThat(coffee).isInstanceOf(Americano.class);
    }

    @DisplayName("Bridge 패턴 커피 만들기 만들기")
    @Test
    void testCase2() {
        Coffee coffee = new Americano
                .Builder(new Bean(), Water.regular())
                .brand(Brand.STARBUCKS)
                .build();


        assertThat(coffee).isInstanceOf(Americano.class);

        Coffee mocha = new Mocha.Builder(new Bean(), Water.regular())
                .milk(Milk.regular())
                .brand(Brand.STARBUCKS)
                .build();

        assertThat(mocha).isInstanceOf(Mocha.class);
    }
}
