package kr.seok.item13.immutable;

import kr.seok.item13.domain.Bean;
import kr.seok.item13.domain.Brand;
import kr.seok.item13.domain.Water;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CoffeeTest {

    @DisplayName("불변 객체의 복제 테스트")
    @Test
    void testCase1() {
        Coffee coffee = new Coffee(Bean.of("Bean"), Water.small(), Brand.NONE);

        Coffee clone = coffee.clone();

        assertThat(coffee).isEqualTo(clone);
    }
}
