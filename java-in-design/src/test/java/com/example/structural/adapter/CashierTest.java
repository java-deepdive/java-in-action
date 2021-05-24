package com.example.structural.adapter;

import com.example.creational.afactory.barista.StarbucksBarista;
import com.example.creational.afactory.component.Bean;
import com.example.creational.afactory.component.Milk;
import com.example.creational.afactory.component.Water;
import com.example.structural.adapter.cash.CashAdapter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CashierTest {

    @DisplayName("어댑터 패턴 사용하기")
    @Test
    void testCase1() {
        CashAdapter cashAdapter = new CashAdapter(new StarbucksBarista());

        cashAdapter.calculate(3000);
        cashAdapter.greet();

        cashAdapter.makeAmericano(Bean.of("쓴 원두"), Water.regular());
        cashAdapter.makeEspresso(Bean.of("쌉쌀한 원두"), Water.regular());
        cashAdapter.makeMocha(Bean.of("달달한 원두"), Water.regular(), Milk.regular());

    }
}
