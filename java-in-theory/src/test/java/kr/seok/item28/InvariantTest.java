package kr.seok.item28;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class InvariantTest {
    @DisplayName("불공변 제네릭 테스트")
    @Test
    void testCase1() {
        Invariant invariant = new Invariant();
        List<Object> convert = invariant.convert(Arrays.asList("1", "2"));

        List<Object> expected = Arrays.asList("1", "2");

        assertThat(convert).isEqualTo(expected);
    }
}
