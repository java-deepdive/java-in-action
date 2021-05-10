package com.example.adapter.cash;

import java.util.Objects;

public class Card {

    private final int value;

    private Card(int value) {
        this.value = value;
    }

    public static Card valueOf(int money) {
        return new Card(money);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Card)) return false;
        final Card card = (Card) o;
        return value == card.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
