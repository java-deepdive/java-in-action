package kr.seok.item28;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CovariantTest {

    @DisplayName("String to Object Array")
    @Test
    void testCase1() {
        Covariant covariant = new Covariant();

        Object[] convert = covariant.convert(new String[]{"1", "2"});

        assertThat(convert).isEqualTo(new Object[]{"1", "2"});
    }
}
