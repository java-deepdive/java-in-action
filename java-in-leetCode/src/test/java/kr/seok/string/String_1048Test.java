package kr.seok.string;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class String_1048Test {

    /**
     * a         b
     * ↘︎    ↙︎
     * ba
     * ↙︎    ↘︎
     * bca     bda
     * ↘︎    ↙︎
     * bdca
     */
    @Test
    void testCase1() {
        String[] words = {"a", "b", "ba", "bca", "bda", "bdca"};

        int actual = new String_1048().longestStrChain(words);

        assertThat(actual).isEqualTo(4);
    }
}