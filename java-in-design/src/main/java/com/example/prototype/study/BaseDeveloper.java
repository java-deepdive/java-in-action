package com.example.prototype.study;

import java.util.Objects;

public abstract class BaseDeveloper implements Cloneable {

    private final DevType type;

    protected BaseDeveloper(DevType type) {
        this.type = type;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof BaseDeveloper)) return false;
        final BaseDeveloper that = (BaseDeveloper) o;
        return type == that.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(type);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
