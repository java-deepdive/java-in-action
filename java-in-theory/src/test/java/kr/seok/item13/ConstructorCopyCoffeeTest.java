package kr.seok.item13;

import kr.seok.item13.constructor.Bean;
import kr.seok.item13.constructor.Brand;
import kr.seok.item13.constructor.ConstructorCopyCoffee;
import kr.seok.item13.constructor.Water;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ConstructorCopyCoffeeTest {

    @DisplayName("생성자 복사를 통한 인스턴스 복사")
    @Test
    void testCase1() {
        // given
        ConstructorCopyCoffee coffee = new ConstructorCopyCoffee(Bean.of("빈"), Water.small(), Brand.NONE);
        // when
        ConstructorCopyCoffee constructorCopy = new ConstructorCopyCoffee(coffee);
        // then
        assertThat(coffee).isEqualTo(constructorCopy);
    }
}
