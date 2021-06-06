package kr.seok.sort;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ReverseStringTest {

    @DisplayName("문자열 뒤집기")
    @Test
    void testCase1() {
        ReverseString reverse = new ReverseString();
        char[] input = {'h', 'e', 'l', 'l', 'o'};

        char[] actual = reverse.reverseString(input);

        assertThat(actual).isEqualTo(new char[]{'o', 'l', 'l', 'e', 'h'});
    }
}
