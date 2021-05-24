package com.example.structural.composite.barista;

import com.example.structural.composite.coffee.Americano;
import com.example.structural.composite.coffee.Coffee;
import com.example.structural.composite.coffee.Espresso;
import com.example.structural.composite.coffee.Mocha;
import com.example.structural.composite.exception.MenuNotFoundException;
import com.example.structural.composite.order.MenuItem;

public class CoffeeFactory {

    private CoffeeFactory() {
    }

    public static Coffee menu(MenuItem menu) {
        switch (menu) {
            case AMERICANO:
                return new Americano();
            case ESPRESSO:
                return new Espresso();
            case MOCHA:
                return new Mocha();
        }
        throw new MenuNotFoundException();
    }
}
