package com.example.afactory.factory;

import com.example.afactory.component.Milk;
import com.example.afactory.domain.*;

public class CoffeeSimpleFactory {

    public static Coffee makeAmericano() {
        return new Americano();
    }

    public static Coffee makeHazelnut(Milk milk) {
        return new Hazelnut(milk);
    }

    public static Coffee makeEspresso() {
        return new Espresso();
    }

    public static Coffee makeMocha() {
        return new Mocha();
    }
}
