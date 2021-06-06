package kr.seok.sort;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ValidAnagramTest {

    @DisplayName("HashTable 방식")
    @Test
    void testCase() {
        ValidAnagram anagram = new ValidAnagram();

        boolean actual = anagram.isAnagram("anagram", "nagaram");

        assertThat(actual).isTrue();
    }
}
