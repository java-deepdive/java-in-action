package com.example.behavioral.strategy;

import java.math.BigDecimal;

public interface Discounter {
    static Discounter christmasDiscounter() {
        return amount -> amount.multiply(BigDecimal.valueOf(0.9));
    }

    static Discounter newYearDiscounter() {
        return amount -> amount.multiply(BigDecimal.valueOf(0.8));
    }

    static Discounter easterDiscounter() {
        return amount -> amount.multiply(BigDecimal.valueOf(0.5));
    }

    BigDecimal applyDiscount(BigDecimal amount);
}
