package kr.seok.item37;

import kr.seok.item37.advanced.PhaseArray;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PhaseArrayArrayTest {

    @DisplayName("고체, 액체, 가스에 대한 데이터베이스를 enum으로 작성 및 테스트")
    @Test
    void testCase1() {
        // 행, 열 조회 -> 뭐하는 짓이지?

        assertThat(PhaseArray.Transition.from(PhaseArray.SOLID, PhaseArray.SOLID)).isNull();
        assertThat(PhaseArray.Transition.from(PhaseArray.SOLID, PhaseArray.LIQUID)).isEqualTo(PhaseArray.Transition.MELT);
        assertThat(PhaseArray.Transition.from(PhaseArray.SOLID, PhaseArray.GAS)).isEqualTo(PhaseArray.Transition.SUBLIME);
        assertThat(PhaseArray.Transition.from(PhaseArray.SOLID, PhaseArray.PLASMA)).isNull();

        assertThat(PhaseArray.Transition.from(PhaseArray.LIQUID, PhaseArray.SOLID)).isEqualTo(PhaseArray.Transition.FREEZE);
        assertThat(PhaseArray.Transition.from(PhaseArray.LIQUID, PhaseArray.LIQUID)).isNull();
        assertThat(PhaseArray.Transition.from(PhaseArray.LIQUID, PhaseArray.GAS)).isEqualTo(PhaseArray.Transition.BOIL);
        assertThat(PhaseArray.Transition.from(PhaseArray.LIQUID, PhaseArray.PLASMA)).isNull();

        assertThat(PhaseArray.Transition.from(PhaseArray.GAS, PhaseArray.SOLID)).isEqualTo(PhaseArray.Transition.DEPOSIT);
        assertThat(PhaseArray.Transition.from(PhaseArray.GAS, PhaseArray.LIQUID)).isEqualTo(PhaseArray.Transition.CONDENSE);
        assertThat(PhaseArray.Transition.from(PhaseArray.GAS, PhaseArray.GAS)).isNull();
        assertThat(PhaseArray.Transition.from(PhaseArray.GAS, PhaseArray.PLASMA)).isEqualTo(PhaseArray.Transition.IONIZE);

        assertThat(PhaseArray.Transition.from(PhaseArray.PLASMA, PhaseArray.SOLID)).isNull();
        assertThat(PhaseArray.Transition.from(PhaseArray.PLASMA, PhaseArray.LIQUID)).isNull();
        assertThat(PhaseArray.Transition.from(PhaseArray.PLASMA, PhaseArray.GAS)).isEqualTo(PhaseArray.Transition.DEIONIZE);
        assertThat(PhaseArray.Transition.from(PhaseArray.PLASMA, PhaseArray.PLASMA)).isNull();
    }
}
