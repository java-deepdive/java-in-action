package kr.seok.item37;

import kr.seok.item37.advanced.PhaseArray;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static kr.seok.item37.advanced.PhaseArray.Transition.from;
import static org.assertj.core.api.Assertions.assertThat;

class PhaseArrayTest {

    @DisplayName("고체, 액체, 가스에 대한 데이터베이스를 enum으로 작성 및 테스트")
    @Test
    void testCase1() {
        // 행, 열 조회 -> 뭐하는 짓이지?

        assertThat(from(PhaseArray.SOLID, PhaseArray.SOLID)).isNull();
        assertThat(from(PhaseArray.SOLID, PhaseArray.LIQUID)).isEqualTo(PhaseArray.Transition.MELT);
        assertThat(from(PhaseArray.SOLID, PhaseArray.GAS)).isEqualTo(PhaseArray.Transition.SUBLIME);
        assertThat(from(PhaseArray.SOLID, PhaseArray.PLASMA)).isNull();

        assertThat(from(PhaseArray.LIQUID, PhaseArray.SOLID)).isEqualTo(PhaseArray.Transition.FREEZE);
        assertThat(from(PhaseArray.LIQUID, PhaseArray.LIQUID)).isNull();
        assertThat(from(PhaseArray.LIQUID, PhaseArray.GAS)).isEqualTo(PhaseArray.Transition.BOIL);
        assertThat(from(PhaseArray.LIQUID, PhaseArray.PLASMA)).isNull();

        assertThat(from(PhaseArray.GAS, PhaseArray.SOLID)).isEqualTo(PhaseArray.Transition.DEPOSIT);
        assertThat(from(PhaseArray.GAS, PhaseArray.LIQUID)).isEqualTo(PhaseArray.Transition.CONDENSE);
        assertThat(from(PhaseArray.GAS, PhaseArray.GAS)).isNull();
        assertThat(from(PhaseArray.GAS, PhaseArray.PLASMA)).isEqualTo(PhaseArray.Transition.IONIZE);

        assertThat(from(PhaseArray.PLASMA, PhaseArray.SOLID)).isNull();
        assertThat(from(PhaseArray.PLASMA, PhaseArray.LIQUID)).isNull();
        assertThat(from(PhaseArray.PLASMA, PhaseArray.GAS)).isEqualTo(PhaseArray.Transition.DEIONIZE);
        assertThat(from(PhaseArray.PLASMA, PhaseArray.PLASMA)).isNull();
    }
}
