package kr.seok.item37;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PlantTest {

    @DisplayName("식물 열거 타입 전체 값 확인 테스트")
    @Test
    void testCase1() {
        Plant.LifeCycle[] values = Plant.LifeCycle.values();
        assertThat(values.length).isEqualTo(3);
    }
}
