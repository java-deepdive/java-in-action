package kr.seok.item13.factory;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class FactoryMethodCopyCoffeeTest {

    @DisplayName("복사 팩토리 메서드 복제 테스트")
    @Test
    void testCase1() {
        // given
        FactoryMethodCopyCoffee coffee = new FactoryMethodCopyCoffee(Bean.of("빈"), Water.none(), Brand.NONE);
        // when
        FactoryMethodCopyCoffee clone = FactoryMethodCopyCoffee.newInstance(coffee);
        // then
        assertThat(coffee).isEqualTo(clone);
    }
}
