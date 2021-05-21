package com.example.composite.barista;

import com.example.composite.coffee.Americano;
import com.example.composite.coffee.Coffee;
import com.example.composite.coffee.Espresso;
import com.example.composite.coffee.Mocha;
import com.example.composite.exception.MenuNotFoundException;
import com.example.composite.order.MenuItem;

public class CoffeeFactory {

    private CoffeeFactory() {}

    public static Coffee menu(MenuItem menu) {
        switch(menu) {
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
