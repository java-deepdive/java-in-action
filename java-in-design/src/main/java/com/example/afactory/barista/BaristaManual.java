package com.example.afactory.barista;

import com.example.afactory.component.Bean;
import com.example.afactory.component.Milk;
import com.example.afactory.component.Water;
import com.example.afactory.coffee.Coffee;

/**
 * Abstract Factory 역할
 */
public interface BaristaManual {

    Coffee makeAmericano(Bean bean, Water water);

    Coffee makeEspresso(Bean bean, Water water);

    Coffee makeMocha(Bean bean, Water water, Milk milk);
}
