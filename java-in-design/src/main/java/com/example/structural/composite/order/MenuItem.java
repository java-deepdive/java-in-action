package com.example.structural.composite.order;

import com.example.structural.composite.exception.MenuNotFoundException;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum MenuItem {

    AMERICANO("1"),
    ESPRESSO("2"),
    MOCHA("3");

    private final String index;

    MenuItem(String index) {
        this.index = index;
    }

    public static List<MenuItem> findAll() {
        return Arrays.stream(MenuItem.values())
                .collect(Collectors.toList());
    }

    public static MenuItem find(String nextLine) {
        return Arrays.stream(MenuItem.values())
                .filter(menuItem -> menuItem.index.equals(nextLine))
                .findFirst()
                .orElseThrow(MenuNotFoundException::new);
    }
}
