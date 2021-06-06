package kr.seok.toptown;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PairRemoveTest {

    @DisplayName("짝지어 제거하기 테스트")
    @Test
    void testCase1() {
        PairRemove pairRemove = new PairRemove();
        int baabaa = pairRemove.solution("baabaa");

        assertThat(baabaa).isEqualTo(1);
    }
}
