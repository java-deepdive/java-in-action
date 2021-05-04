package com.example.adapter;

import com.example.adapter.cash.CashAdapter;
import com.example.afactory.barista.StarbucksBarista;
import com.example.afactory.coffee.Americano;
import com.example.afactory.component.Bean;
import com.example.afactory.component.Milk;
import com.example.afactory.component.Water;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CashierTest {

    @DisplayName("어댑터 패턴 사용하기")
    @Test
    void testCase1() {
        CashAdapter cashAdapter = new CashAdapter(new StarbucksBarista());

        cashAdapter.calculate();
        cashAdapter.greet();

        cashAdapter.makeAmericano(Bean.of("쓴 원두"), Water.regular());
        cashAdapter.makeEspresso(Bean.of("쌉쌀한 원두"), Water.regular());
        cashAdapter.makeMocha(Bean.of("달달한 원두"), Water.regular(), Milk.regular());

    }
}
