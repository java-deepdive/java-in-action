package kr.seok.generic.optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OptionalTest {

    @DisplayName("상수를 선언하는 문장을 단계별로 분석하기 1")
    @Test
    void testCase1() {
        // ? = Object
        Optional<?> EMPTY = new Optional<>();
    }

    @Test
    void testCase2() {
        Optional<? extends Object> EMPTY = new Optional<>();

        Optional<?> EMPTY_ = new Optional<Object>();

    }

    @Test
    void testCase3() {

        Optional<? extends Object> EMPTY = new Optional<Object>();

        Optional<?> EMPTY_ = new Optional<>();
    }

    @Test
    void testCase4() {
        Optional<?> wopt = new Optional<Object>();

        Optional<String> sopt = (Optional<String>) wopt;
    }

    @Test
    void testCase5() {
        Optional<Object> oopt = new Optional<Object>();

        // Optional<Object> != Optional<String>
        // Optional<String> sopt = (Optional<String>) oopt;
    }
}