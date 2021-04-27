package kr.seok.strNArr;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class Ex1Test {

    Ex1 ex1;

    @BeforeEach
    public void setUp() {
        ex1 = new Ex1();
    }

    @Test
    @DisplayName("중복 문자열 확인")
    void testCase1() {
        boolean except = ex1.isUniqueChars2("string");
        assertThat(except).isTrue();
    }

    @Test
    @DisplayName("중복 문자열 확인")
    void testCase2() {
        boolean except = ex1.isUniqueChars2("asdqwega");
        assertThat(except).isFalse();
    }
}
