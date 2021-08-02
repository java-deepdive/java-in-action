package kr.seok.item37;

import java.util.Objects;

/**
 * 식물을 나타내는 클래스
 */
public class Plant {
    final String name;
    final LifeCycle lifeCycle;
    Plant(String name, LifeCycle lifeCycle) {
        this.name = name;
        this.lifeCycle = lifeCycle;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Plant)) return false;
        final Plant plant = (Plant) o;
        return Objects.equals(name, plant.name)
                && lifeCycle == plant.lifeCycle;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, lifeCycle);
    }

    // 식물의 생애 주기를 관리하는 열거 타입
    enum LifeCycle {
        ANNUAL, // 한해살이
        PERENNIAL, // 여러해살이
        BIENNIAL // 두해살이
    }
}
