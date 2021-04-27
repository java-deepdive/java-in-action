package kr.seok.string;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class String_91Test {

    String_91 s91;

    @BeforeEach
    public void setUp() {
        s91 = new String_91();
    }

    @Test
    @DisplayName("이해 ㄴㄴ")
    void testCase1() {
        int i = s91.numDecodings("12");
        assertThat(i).isEqualTo(2);
    }

    @Test
    @DisplayName("이해 ㄴㄴ")
    void testCase2() {
        int i = s91.numDecodings("326");
        assertThat(i).isEqualTo(2);
    }

    @Test
    @DisplayName("이해 ㄴㄴ")
    void testCase3() {
        int i = s91.numDecodings("2326");
        assertThat(i).isEqualTo(4);
    }
}
