package kr.seok.item2.hierarchicalbuilder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static kr.seok.item2.hierarchicalbuilder.NyPizza.Size.SMALL;
import static kr.seok.item2.hierarchicalbuilder.Pizza.Topping.*;
import static org.assertj.core.api.Assertions.assertThat;

class PizzaTest {
	
	@DisplayName("빌더 패턴 테스트")
	@Test
	void testCase1() {
		NyPizza pizza = new NyPizza.Builder(SMALL)
			.addTopping(SAUSAGE).addTopping(ONION).build();
		Calzone calzone = new Calzone.Builder()
			.addTopping(HAM).sauceInside().build();
		
		assertThat(pizza).isNotNull();
		assertThat(calzone).isNotNull();
	}
}