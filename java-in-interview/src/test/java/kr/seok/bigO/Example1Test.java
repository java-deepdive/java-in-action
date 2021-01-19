package kr.seok.bigO;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Example1Test {
    Example1 ex;

    @BeforeEach
    public void setUp() {
        ex = new Example1();
    }

    @Test
    void testCase1() {
        ex.foo(new int[] {1, 2});
    }

    @Test
    void testCase2() {
        ex.foo(new int[] {1, 2, 3});
    }

    @Test
    void testCase3() {
        ex.foo(new int[] {1, 2, 3, 4});
    }
}
