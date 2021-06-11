package kr.seok.item37.advanced;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static kr.seok.item37.advanced.PhaseEnumMap.Transition.from;
import static org.assertj.core.api.Assertions.assertThat;

class PhaseEnumMapTest {

    @DisplayName("EnumMap 으로 구성된 데이터 관리 테스트 ")
    @Test
    void testCase1() {

        assertThat(from(PhaseEnumMap.GAS, PhaseEnumMap.PLASMA)).isEqualTo(PhaseEnumMap.Transition.IONIZE);
        assertThat(from(PhaseEnumMap.PLASMA, PhaseEnumMap.GAS)).isEqualTo(PhaseEnumMap.Transition.DEIONIZE);

    }
}
