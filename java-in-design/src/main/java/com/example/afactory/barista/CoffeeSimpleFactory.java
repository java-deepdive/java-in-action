package com.example.afactory.barista;

import com.example.afactory.component.Milk;
import com.example.afactory.coffee.*;

/**
 * Simple Factory
 */
public class CoffeeSimpleFactory {

    public static Coffee makeAmericano() {
        return new Americano.Builder(null, null).build();
    }

    public static Coffee makeHazelnut(Milk milk) {
        return new Hazelnut(milk);
    }

    public static Coffee makeEspresso() {
        return new Espresso.Builder(null, null).build();
    }

    public static Coffee makeMocha() {
        return new Mocha.Builder(null, null).milk(null).build();
    }
}
