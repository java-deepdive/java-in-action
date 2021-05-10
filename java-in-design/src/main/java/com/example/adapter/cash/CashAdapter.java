package com.example.adapter.cash;

import com.example.afactory.barista.StarbucksBarista;
import com.example.afactory.coffee.Coffee;
import com.example.afactory.component.Bean;
import com.example.afactory.component.Milk;
import com.example.afactory.component.Water;

/**
 * 클라이언트 인터페이스를 구현 & 서비스 클래스를 wrapper
 */
public class CashAdapter implements Cashier {

    private final StarbucksBarista starbucksBarista;

    public CashAdapter(StarbucksBarista starbucksBarista) {
        this.starbucksBarista = starbucksBarista;
    }

    @Override
    public void calculate(int money) {
        System.out.println("계산해 줄게 : " + money);
    }

    @Override
    public void greet() {
        System.out.println("잘가");
    }

    public Coffee makeAmericano(Bean bean, Water water) {
        return starbucksBarista.makeAmericano(bean, water);
    }

    public Coffee makeEspresso(Bean bean, Water water) {
        return starbucksBarista.makeEspresso(bean, water);
    }

    public Coffee makeMocha(Bean bean, Water water, Milk milk) {
        return starbucksBarista.makeMocha(bean, water, milk);
    }
}
