package com.example.creational.prototype.color;

import java.util.Objects;

abstract class Color implements Cloneable {

    protected String colorName;

    abstract void addColor();

    /**
     * public 인 clone 메더스에서는 throws 절을 없애야 한다 (아이템 71)
     * Cloneable을 구현한 스레드 안전 클래스를 작성할 때, clone 메서드 역시 동기화 처리 해줘야 한다.(아이템 78)
     */
    @Override
    public Object clone() {
        Object clone = null;
        try {
            clone = super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return clone;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof Color)) return false;
        final Color color = (Color) o;
        return Objects.equals(colorName, color.colorName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(colorName);
    }
}
