package com.example.afactory.component;


import java.util.Objects;

public class Water implements Cloneable {
    private final int size;

    public Water(int size) {
        this.size = size;
    }

    /**
     * 불변 클래스는 굳이 clone을 제공하지 않는 것이 좋다.
     */
    @Override
    public Water clone() {
        try {
            return (Water) super.clone();
            // 검사 예외와 비 검사 예외 에 대한 차이 알아보기
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Water)) return false;
        final Water water = (Water) o;
        return size == water.size;
    }

    @Override
    public int hashCode() {
        return Objects.hash(size);
    }
}
