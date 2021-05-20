package kr.seok.item13;

import kr.seok.item13.deep.Bean;
import kr.seok.item13.deep.Brand;
import kr.seok.item13.deep.DeepCopyCoffee;
import kr.seok.item13.deep.Water;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DeepCopyCoffeeTest {

    @DisplayName("깊은 복사 확인 테스트")
    @Test
    void testCase1() {
        DeepCopyCoffee coffee = new DeepCopyCoffee(Bean.of("빈"), Water.regular(), Brand.NONE);

        // immutable Object의 복사
        DeepCopyCoffee deepCopy = coffee.clone();

        assertThat(coffee).isEqualTo(deepCopy);
    }
}
