package kr.seok.stack;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class Stack_394Test {
    Stack_394 stack;
    @BeforeEach
    void setUp() {
        stack = new Stack_394();
    }

    @Test
    @DisplayName("메서드 실행 테스트")
    void testCase1() {
        String s = "3[a]2[bc]";
        String decodeString = stack.decodeString_oneStack(s);
        System.out.println(decodeString);
    }
}
