package com.example.facade;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

class CompilerTest {

    @DisplayName("사칙 연산 테스트")
    @Test
    void testCase1() {

        // Compiler class is a facade, it can add two numbers with following
        // expression: 1 + 2
        // all other operations are not supported
        assertEquals(3, Compiler.compile("1 + 2"));

        try {
            // right operand is not a number
            Compiler.compile("1 + x");
            fail("Exception must be thrown");
        } catch (Exception e) {
        }

        try {
            // - expression is not supported
            Compiler.compile("1 - 1");
            fail("Exception must be thrown");
        } catch (Exception e) {
        }
    }
}
