package com.example.structural.bridge.sample;

public interface Weapon {
    void wield();

    void swing();

    void unwield();

    Enchantment getEnchantment();
}
