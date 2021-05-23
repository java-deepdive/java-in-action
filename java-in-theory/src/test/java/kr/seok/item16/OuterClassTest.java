package kr.seok.item16;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class OuterClassTest {

    @DisplayName("외부 클래스를 통해 내부 데이터 변경 테스트")
    @Test
    void testCase1() {
        // given
        OuterClass outerClass = new OuterClass();

        // when
        outerClass.changeValue(1);

        // then
        assertThat(outerClass.value()).isEqualTo(1);
    }
}
