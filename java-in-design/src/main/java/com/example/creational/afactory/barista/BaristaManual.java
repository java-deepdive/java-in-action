package com.example.creational.afactory.barista;

import com.example.creational.afactory.component.Bean;
import com.example.creational.afactory.component.Milk;
import com.example.creational.afactory.component.Water;
import com.example.domain.Coffee;

/**
 * Abstract Factory 역할
 */
public interface BaristaManual {

    Coffee makeAmericano(Bean bean, Water water);

    Coffee makeEspresso(Bean bean, Water water);

    Coffee makeMocha(Bean bean, Water water, Milk milk);
}
