package com.example.afactory.component;

import java.util.Objects;

public class Bean {
    private final String name;

    public Bean() {
        this("default");
    }

    public Bean(String name) {
        this.name = name;
    }

    public static Bean of(String name) {
        return new Bean(name);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Bean)) return false;
        final Bean bean = (Bean) o;
        return Objects.equals(name, bean.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
