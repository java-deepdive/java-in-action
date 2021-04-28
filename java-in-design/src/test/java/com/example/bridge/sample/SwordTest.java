package com.example.bridge.sample;

import org.junit.jupiter.api.Test;

class SwordTest {

    @Test
    void testCase1() {
        Sword sword = new Sword(new SoulEatingEnchantment());

        sword.wield();
        sword.swing();
        sword.unwield();
    }
}
