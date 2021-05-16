package kr.seok.item13.domain;

import java.util.Objects;

public class Bean implements Cloneable {

    private final String name;

    public Bean() {
        this("default");
    }

    private Bean(String name) {
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

    @Override
    public String toString() {
        return String.valueOf(name);
    }

    @Override
    public Bean clone() {
        Bean clone = null;
        try {
            clone = (Bean) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return clone;
    }
}
