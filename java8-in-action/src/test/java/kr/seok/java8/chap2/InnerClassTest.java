package kr.seok.java8.chap2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InnerClassTest {

    @Test
    @DisplayName("익명 클래스 선언하여 동작 테스트")
    void testCase1() {
        InnerClass action = new InnerClass();
    }
}
