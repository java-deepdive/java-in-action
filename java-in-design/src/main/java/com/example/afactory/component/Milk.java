package com.example.afactory.component;

import java.util.Objects;

public class Milk {
    private final int liter;

    private Milk(int liter) {
        this.liter = liter;
    }

    public static Milk small() {
        return new Milk(50);
    }

    public static Milk regular() {
        return new Milk(100);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof Milk)) return false;
        final Milk milk = (Milk) o;
        return liter == milk.liter;
    }

    @Override
    public int hashCode() {
        return Objects.hash(liter);
    }
}
