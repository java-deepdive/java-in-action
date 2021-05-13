package com.example.afactory.barista;

import com.example.afactory.component.Bean;
import com.example.afactory.component.Water;
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
