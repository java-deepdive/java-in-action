package kr.seok.item13.mutable;

import kr.seok.item13.Bean;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CoffeeTest {

    @DisplayName("커피 객체 복제 테스트")
    @Test
    void testCase1() {
        // given
        Coffee coffee = new Coffee(Bean.of("korea"));
        // when
        Coffee clone = coffee.clone();

        // 가변 객체를 포함하는 객체의 복사 문제점
        coffee.setBean(Bean.of("where"));

        System.out.println("Coffee : " + coffee);
        System.out.println("Clone : " + clone);

        // then
        assertThat(coffee).isNotSameAs(clone);
    }
}
