package com.example.afactory.shop;

import com.example.afactory.barista.BaristaManual;
import com.example.afactory.barista.StarbucksBarista;
import com.example.afactory.barista.TomNTomsBarista;
import com.example.afactory.component.Bean;
import com.example.afactory.component.Milk;
import com.example.afactory.component.Water;
import com.example.domain.Americano;
import com.example.domain.Coffee;
import com.example.domain.Mocha;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BaristaManualTest {

    @DisplayName("스타벅스 아메리카노 생성 테스트")
    @Test
    void testCase1() {
        // given
        BaristaManual starbucksBarista = new StarbucksBarista();
        // when
        Coffee coffee = starbucksBarista.makeAmericano(new Bean(), Water.small());
        // then
        assertThat(coffee).isEqualTo(new Americano.Builder(new Bean(), Water.small()).build());
    }

    @DisplayName("탐 앤 탐스 모카 생성 테스트")
    @Test
    void testCase2() {
        // given
        BaristaManual barista = new TomNTomsBarista();
        // when
        Coffee coffee = barista.makeMocha(new Bean(), Water.small(), Milk.small());
        // then
        assertThat(coffee).isEqualTo(new Mocha.Builder(new Bean(), Water.small()).milk(Milk.small()).build());
    }
}
