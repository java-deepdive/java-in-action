package kr.seok.lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTest {

    @Test
    void testCase1() {
        Integer[] integers = {1, 2, 3, 4, 5, 6};

        Lotto lotto = Lotto.of(integers);
        assertThat(lotto).isEqualTo(Lotto.of(integers));
    }

}
