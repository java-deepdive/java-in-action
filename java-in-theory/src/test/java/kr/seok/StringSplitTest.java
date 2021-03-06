package kr.seok;

import kr.seok.testdome.StringSplit;
import org.junit.jupiter.api.Test;

class StringSplitTest {

    @Test
    void testCase1() {
        StringSplit split = new StringSplit();

        String[] strs = split.split("2 + 1 + 5 - 4");

        System.out.println(strs.length);
        for (int i = 0; i < strs.length; i++) {
            System.out.println(strs[i]);
        }

    }

}
