package com.example.creational.afactory.barista;

import com.example.creational.afactory.component.Bean;
import com.example.creational.afactory.component.Water;
import com.example.domain.Coffee;

public class CafeRunner {

    private final BaristaManual baristaManual;

    public CafeRunner(BaristaManual baristaManual) {
        this.baristaManual = baristaManual;
    }

    public Coffee order(String menuItem) {
        if (menuItem.equals("americano")) {
            return baristaManual.makeAmericano(new Bean(), Water.small());
        }
        return baristaManual.makeEspresso(new Bean(), Water.none());
    }
}
