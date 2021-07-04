package kr.seok.item62;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class InputInterfaceTest {
    private InputInterface inputInterface;

    @BeforeEach
    void setUp() {
        inputInterface = new InputInterface();
    }

    @DisplayName("Integer 타입 데이터 입력 테스트")
    @Test
    void testCase1() {
        String integerData = String.valueOf(Integer.MAX_VALUE);
        int actual = inputInterface.inputInteger(integerData);

        assertThat(actual).isEqualTo(Integer.MAX_VALUE);
        assertThat(actual).isInstanceOf(Integer.class);
    }

    @DisplayName("Short 타입 데이터 입력 테스트")
    @Test
    void testCase2() {
        String shortData = String.valueOf(Short.MAX_VALUE);

        short actual = inputInterface.inputShort(shortData);

        assertThat(actual).isEqualTo(Short.MAX_VALUE);
        assertThat(actual).isInstanceOf(Short.class);
    }

    @DisplayName("double 타입 데이터 입력 테스트")
    @Test
    void testCase3() {
        String doubleData = String.valueOf(Double.MAX_VALUE);

        double actual = inputInterface.inputDouble(doubleData);

        assertThat(actual).isEqualTo(Double.MAX_VALUE);
        // 0.0 인지 확인 체크
        // assertThat(actual).isNegative();
        assertThat(actual).isNotNaN();
        assertThat(actual).isNotZero();
        assertThat(actual).isInstanceOf(Double.class);
    }

    @DisplayName("열거 타입 데이터 입력 테스트")
    @Test
    void testCase4() {
        InputInterface.Type type = inputInterface.inputEnum(1682489);

        assertThat(type).isEqualTo(InputInterface.Type.A);
        assertThat(type).isInstanceOf(InputInterface.Type.class);
    }
}
