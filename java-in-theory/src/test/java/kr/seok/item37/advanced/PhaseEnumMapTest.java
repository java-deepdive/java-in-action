package kr.seok.item37.advanced;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PhaseEnumMapTest {

    @DisplayName("EnumMap 으로 구성된 데이터 관리 테스트 ")
    @Test
    void testCase1() {

        assertThat(PhaseEnumMap.Transition.from(PhaseEnumMap.SOLID, PhaseEnumMap.SOLID)).isNull();
        assertThat(PhaseEnumMap.Transition.from(PhaseEnumMap.SOLID, PhaseEnumMap.LIQUID)).isEqualTo(PhaseEnumMap.Transition.MELT);
        assertThat(PhaseEnumMap.Transition.from(PhaseEnumMap.SOLID, PhaseEnumMap.GAS)).isEqualTo(PhaseEnumMap.Transition.SUBLIME);
        assertThat(PhaseEnumMap.Transition.from(PhaseEnumMap.SOLID, PhaseEnumMap.PLASMA)).isNull();

        assertThat(PhaseEnumMap.Transition.from(PhaseEnumMap.LIQUID, PhaseEnumMap.SOLID)).isEqualTo(PhaseEnumMap.Transition.FREEZE);
        assertThat(PhaseEnumMap.Transition.from(PhaseEnumMap.LIQUID, PhaseEnumMap.LIQUID)).isNull();
        assertThat(PhaseEnumMap.Transition.from(PhaseEnumMap.LIQUID, PhaseEnumMap.GAS)).isEqualTo(PhaseEnumMap.Transition.BOIL);
        assertThat(PhaseEnumMap.Transition.from(PhaseEnumMap.LIQUID, PhaseEnumMap.PLASMA)).isNull();

        assertThat(PhaseEnumMap.Transition.from(PhaseEnumMap.GAS, PhaseEnumMap.SOLID)).isEqualTo(PhaseEnumMap.Transition.DEPOSIT);
        assertThat(PhaseEnumMap.Transition.from(PhaseEnumMap.GAS, PhaseEnumMap.LIQUID)).isEqualTo(PhaseEnumMap.Transition.CONDENSE);
        assertThat(PhaseEnumMap.Transition.from(PhaseEnumMap.GAS, PhaseEnumMap.GAS)).isNull();
        assertThat(PhaseEnumMap.Transition.from(PhaseEnumMap.GAS, PhaseEnumMap.PLASMA)).isEqualTo(PhaseEnumMap.Transition.IONIZE);

        assertThat(PhaseEnumMap.Transition.from(PhaseEnumMap.PLASMA, PhaseEnumMap.SOLID)).isNull();
        assertThat(PhaseEnumMap.Transition.from(PhaseEnumMap.PLASMA, PhaseEnumMap.LIQUID)).isNull();
        assertThat(PhaseEnumMap.Transition.from(PhaseEnumMap.PLASMA, PhaseEnumMap.GAS)).isEqualTo(PhaseEnumMap.Transition.DEIONIZE);
        assertThat(PhaseEnumMap.Transition.from(PhaseEnumMap.PLASMA, PhaseEnumMap.PLASMA)).isNull();
    }
}
