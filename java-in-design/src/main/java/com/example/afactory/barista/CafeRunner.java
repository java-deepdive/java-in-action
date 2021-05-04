package com.example.afactory.barista;

import com.example.afactory.coffee.Coffee;
import com.example.afactory.component.Bean;
import com.example.afactory.component.Water;

public class CafeRunner {

    private final BaristaManual baristaManual;

    public CafeRunner(BaristaManual baristaManual) {
        this.baristaManual = baristaManual;
    }

    public Coffee order(String menuItem) {
        if(menuItem.equals("americano")) {
            return baristaManual.makeAmericano(new Bean(), Water.small());
        }
        return baristaManual.makeEspresso(new Bean(), Water.none());
    }
}
