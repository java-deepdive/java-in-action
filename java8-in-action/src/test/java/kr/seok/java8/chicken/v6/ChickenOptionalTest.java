package kr.seok.java8.chicken.v6;

import kr.seok.java8.chicken.Chicken;
import kr.seok.java8.chicken.ChickenBrand;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class ChickenOptionalTest {
	private ChickenOptional chickenOptional;
	
	@BeforeEach
	void setUp() {
		 chickenOptional = new ChickenOptional();
	}
	
	@DisplayName("특정 고객정보의 조회 실패 테스트")
	@Test
	void testCase1() {
		assertThatExceptionOfType(RuntimeException.class)
				.isThrownBy(() -> chickenOptional.getOrderChicken(null))
				.withMessage("사용자 정보를 조회할 수 없습니다.");
	}
	
	@DisplayName("특정 고객의 주문정보의 조회 실패 테스트")
	@Test
	void testCase2() {
		// given
		User user = new User("SR");
		// then
		assertThatExceptionOfType(RuntimeException.class)
			.isThrownBy(() -> chickenOptional.findOrder(user))
			.withMessage("주문정보를 조회할 수 없습니다.");
	}
	
	@DisplayName("특정 고객의 주문정보의 치킨정보 조회 실패 테스트")
	@Test
	void testCase3() {
		// given
		User user = new User("SR");
		user.order(new Order(null));
		// then
		assertThatExceptionOfType(RuntimeException.class)
			.isThrownBy(() -> chickenOptional.getOrderChicken(user))
			.withMessage("치킨정보를 조회할 수 없습니다.");
	}
	
	@DisplayName("특정 고객이 주문한 치킨의 브랜드를 확인해보는 테스트")
	@Test
	void testCase4() {
		User user = new User("SR");
		
		Chicken chicken = new Chicken(ChickenBrand.BBQ, 10000);
		Order order = new Order(chicken);
		user.order(order);
		
		String brandName = chickenOptional.getOrderChicken(user);
		
		assertThat(brandName).isEqualTo(ChickenBrand.BBQ.name());
	}
}