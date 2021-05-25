package com.example.structural.flyweight;

import com.example.structural.flyweight.concrete.ConcreteFlyweight;
import com.example.structural.flyweight.concrete.UnsharedConcreteFlyweight;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class FlyweightTest {

    Flyweight flyweight1;
    Flyweight flyweight2;
    Flyweight flyweight3;

    Flyweight unsharedFlyweight1;
    Flyweight unsharedFlyweight2;
    Flyweight unsharedFlyweight3;

    @BeforeEach
    void setUp() {
        flyweight1 = FlyweightFactory.getFlyweight("key1", "value1");
        flyweight2 = FlyweightFactory.getFlyweight("key2", "value2");
        flyweight3 = FlyweightFactory.getFlyweight("key1", "value3");

        unsharedFlyweight1 = FlyweightFactory.getFlyweight("unsharedKey1", "value1");
        unsharedFlyweight2 = FlyweightFactory.getFlyweight("unsharedKey2", "value2");
        unsharedFlyweight3 = FlyweightFactory.getFlyweight("unsharedKey1", "value3");
    }

    @DisplayName("인스턴스 비교 테스트")
    @Test
    void testCase1() {
        // 동일하지 않은 객체
        assertThat(flyweight1).isNotSameAs(flyweight2);
        // 키 값이 같으므로 동일한 객체
        assertThat(flyweight1).isEqualTo(flyweight3);
        // 동일하지 않은 키 값
        assertThat(flyweight2).isNotSameAs(flyweight3);
    }

    @DisplayName("공유되지 않은 객체 비교")
    @Test
    void testCase2() {

        // 공유하지 않은 객체들
        assertThat(unsharedFlyweight1).isNotSameAs(unsharedFlyweight2);

        // 동일하지 않은 객체
        assertThat(unsharedFlyweight1).isNotSameAs(unsharedFlyweight3);

        // 동일하지 않은 객체
        assertThat(unsharedFlyweight2).isNotSameAs(unsharedFlyweight3);
    }

    @DisplayName("인스턴스 내에 값 확인 테스트")
    @Test
    void testCase3() {
        assertAll(
                () -> {
                    if (flyweight1 instanceof ConcreteFlyweight) {
                        assertThat(((ConcreteFlyweight) flyweight1).getIntrinsicState()).isEqualTo("value1");
                        assertThat(((ConcreteFlyweight) flyweight2).getIntrinsicState()).isEqualTo("value2");
                        assertThat(((ConcreteFlyweight) flyweight3).getIntrinsicState()).isEqualTo("value1");
                    }
                },
                () -> {
                    if (unsharedFlyweight1 instanceof UnsharedConcreteFlyweight) {
                        assertThat(((UnsharedConcreteFlyweight) unsharedFlyweight1).getState()).isEqualTo("value1");
                        assertThat(((UnsharedConcreteFlyweight) unsharedFlyweight2).getState()).isEqualTo("value2");
                        assertThat(((UnsharedConcreteFlyweight) unsharedFlyweight3).getState()).isEqualTo("value3");
                    }
                }
        );
    }
}
