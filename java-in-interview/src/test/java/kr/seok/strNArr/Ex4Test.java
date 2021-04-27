package kr.seok.strNArr;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class Ex4Test {

    Ex4 ex4;

    @BeforeEach
    public void setUp() {
        ex4 = new Ex4();
    }

    @Test
    @DisplayName("Palindrome Permutation 테스트")
    void testCase1() {

        String[] strings = {
                "Rats live on no evil star",
                "A man, a plan, a canal, panama",
                "Lleve",
                "Tacotac",
                "asda"
        };

        Arrays.stream(strings)
                .forEach(s -> {
                    boolean permutationOfPalindrome3 = ex4.isPermutationOfPalindrome3(s);
                    System.out.println(permutationOfPalindrome3);
                });
    }
}
