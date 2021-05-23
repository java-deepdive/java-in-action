package com.example.flyweight;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class FlyweightTest {

    @Test
    void testCase1() {

        Flyweight flyweight1 = FlyweightFactory.getFlyweight("key1", "value1");
        Flyweight flyweight2 = FlyweightFactory.getFlyweight("key2", "value2");
        Flyweight flyweight3 = FlyweightFactory.getFlyweight("key1", "value3");

        Flyweight unsharedFlyweight1 = FlyweightFactory.getFlyweight("unsharedKey1",
                "value1");
        Flyweight unsharedFlyweight2 = FlyweightFactory.getFlyweight("unsharedKey2",
                "value2");
        Flyweight unsharedFlyweight3 = FlyweightFactory.getFlyweight("unsharedKey1",
                "value3");

        assertNotEquals(flyweight1, flyweight2);
        assertEquals(flyweight1, flyweight3);
        assertNotEquals(flyweight2, flyweight3);

        assertNotEquals(unsharedFlyweight1, unsharedFlyweight2);
        assertNotEquals(unsharedFlyweight1, unsharedFlyweight3);
        assertNotEquals(unsharedFlyweight2, unsharedFlyweight3);

        if (flyweight1 instanceof ConcreteFlyweight) {
            assertEquals("value1", ((ConcreteFlyweight) flyweight1).getIntrinsicState());
        }

        if (flyweight2 instanceof ConcreteFlyweight) {
            assertEquals("value2",
                    ((ConcreteFlyweight) flyweight2)
                            .getIntrinsicState());
        }

        if (flyweight3 instanceof ConcreteFlyweight) {
            assertEquals("value1",
                    ((ConcreteFlyweight) flyweight3)
                            .getIntrinsicState());
        }

        if (unsharedFlyweight1 instanceof UnsharedConcreteFlyweight) {
            assertEquals("value1",
                    ((UnsharedConcreteFlyweight) unsharedFlyweight1)
                            .getState());
        }

        if (unsharedFlyweight2 instanceof UnsharedConcreteFlyweight) {
            assertEquals("value2",
                    ((UnsharedConcreteFlyweight) unsharedFlyweight2)
                            .getState());
        }

        if (unsharedFlyweight3 instanceof UnsharedConcreteFlyweight) {
            assertEquals("value3",
                    ((UnsharedConcreteFlyweight) unsharedFlyweight3)
                            .getState());
        }
    }
}
