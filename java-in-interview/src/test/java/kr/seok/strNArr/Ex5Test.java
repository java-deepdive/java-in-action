package kr.seok.strNArr;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class Ex5Test {
    Ex5 ex5;

    @BeforeEach
    public void setUp() {
        ex5 = new Ex5();

    }

    @Test
    @DisplayName("하나 빼기 테스트")
    void testCase1() {
        String[][] tests = {
                {"a", "b", "true"},
                {"", "d", "true"},
                {"d", "de", "true"},
                {"pale", "pse", "false"},
                {"acdsfdsfadsf", "acdsgdsfadsf", "true"},
                {"acdsfdsfadsf", "acdsfdfadsf", "true"},
                {"acdsfdsfadsf", "acdsfdsfads", "true"},
                {"acdsfdsfadsf", "cdsfdsfadsf", "true"},
                {"adfdsfadsf", "acdfdsfdsf", "false"},
                {"adfdsfadsf", "bdfdsfadsg", "false"},
                {"adfdsfadsf", "affdsfads", "false"},
                {"pale", "pkle", "true"},
                {"pkle", "pable", "false"}
        };

        Arrays.stream(tests).forEach(
                strings -> {
                    boolean expected = "true".equals(strings[2]);
                    String first = strings[0];
                    String second = strings[1];
                    assertThat(ex5.oneEditAway2(first, second)).isEqualTo(expected);
                }
        );
    }
}
