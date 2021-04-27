package kr.seok.strNArr;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class Ex3Test {

    Ex3 ex3;

    @BeforeEach
    public void setUp() {
        ex3 = new Ex3();
    }

    /**
     * 문제 의도를 이제 이해했다 ?
     */
    @Test
    @DisplayName("URLify 모든 공백 %20 처리")
    void testCase1() {
        String str = "Mr John Smith    ";
        char[] arr = str.toCharArray();
        int cnt = getEmptySpaceCnt(str);
        System.out.println("배열 : " + cnt);
        /* 막 idx + 1 으로 배열 길이 채움 */
        int trueLength = findLastCharacterIdx(arr) + 1;

        // then
        char[] chars = ex3.replaceSpaces(arr, trueLength);
        assertThat(new String(chars)).contains("Mr%20John%20Smith");
    }

    /* 전체 공백 수 확인하기 */
    private int getEmptySpaceCnt(String str) {
        char[] chars = str.toCharArray();

        int cnt = 0;
        for (char ch : chars) {
            int c = ch;
            if (c == 32) {
                cnt++;
            }
        }
        return cnt;
    }

    /* 거꾸로 탐색해서 문자열의 인덱스를 확인 */
    private int findLastCharacterIdx(char[] str) {
        for (int i = str.length - 1; i >= 0; i--) {
            if (str[i] != ' ') return i;
        }
        return -1;
    }
}
