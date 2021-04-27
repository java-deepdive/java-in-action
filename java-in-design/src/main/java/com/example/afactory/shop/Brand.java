package com.example.afactory.shop;

import java.util.Arrays;

public enum Brand {
    STARBUCKS,
    COFFEE_BEAN,
    TOM_N_TOMS,
    LOCAL_SHOP,
    NONE;

    public static Brand of(Brand brand) {
        return Arrays.stream(Brand.values())
                .filter(brand1 -> brand1.equals(brand))
                .findFirst()
                .orElse(NONE);
    }
}
