package kr.seok.strNArr;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class Ex2Test {

    Ex2 ex2;

    @BeforeEach
    public void setUp() {
        ex2 = new Ex2();
    }

    @Test
    @DisplayName("문자열 비교 (길이 다르면 false, 한 글자라도 다르면 -1 값 때문에 false)")
    void testCase1() {
        boolean expect = ex2.permutation2("String1", "String2");
        assertThat(expect).isFalse();
    }

    @Test
    @DisplayName("문자열 비교 다 같음")
    void testCase2() {
        boolean expect = ex2.permutation2("String1", "String1");
        assertThat(expect).isTrue();
    }
}
