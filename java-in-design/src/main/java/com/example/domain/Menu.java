package com.example.domain;

import java.util.Arrays;

public enum Menu {
    AMERICANO,
    MOCHA,
    ESPRESSO,
    HAZELNUT;

    public static Menu find(Menu item) {
        return Arrays.stream(Menu.values())
                .filter(menu -> menu.equals(item))
                .findFirst()
                .orElse(ESPRESSO);
    }
}
