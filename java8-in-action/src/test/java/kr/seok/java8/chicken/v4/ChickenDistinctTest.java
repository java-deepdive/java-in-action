package kr.seok.java8.chicken.v4;

import kr.seok.java8.chicken.Chicken;
import kr.seok.java8.chicken.ChickenBrand;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static kr.seok.java8.chicken.ChickenBrand.GCOVA;
import static kr.seok.java8.chicken.ChickenBrand.KFC;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class ChickenDistinctTest {
	
	@DisplayName("브랜드로 필터링 하되 distinct를 통해 중복 제거")
	@Test
	void testCase1() {
		List<Chicken> originChickenList = List.of(
			new Chicken(KFC, 10_000, "맛있는 치킨"),
			new Chicken(KFC, 12_000, "더 맛있는 치킨"),
			new Chicken(GCOVA, 9_000, "X코바 치킨"),
			new Chicken(ChickenBrand.BBQ, 15_000, "BBC 치킨")
		);
		
		ChickenDistinct chickenDistinct = new ChickenDistinct(originChickenList);
		List<Chicken> chickens = chickenDistinct.distinctByBrandAndMaxPrice(ChickenBrand.KFC);
		assertAll(
			() -> assertThat(chickens).hasSize(1),
			() -> assertThat(chickens.get(0).getPrice()).isEqualTo(12_000)
		);
	}
	
	@DisplayName("브랜드로 필터링 및 제한된 데이터 사이즈만 조회")
	@Test
	void testCase2() {
		List<Chicken> originChickenList = List.of(
			new Chicken(KFC, 10_000, "맛있는 치킨"),
			new Chicken(KFC, 12_000, "더 맛있는 치킨"),
			new Chicken(GCOVA, 9_000, "X코바 치킨"),
			new Chicken(ChickenBrand.BBQ, 15_000, "BBC 치킨")
		);
		
		ChickenDistinct chickenDistinct = new ChickenDistinct(originChickenList);
		List<Chicken> chickens = chickenDistinct.distinctByBrandAndLimit(ChickenBrand.KFC, 1);
		assertAll(
			() -> assertThat(chickens).hasSize(1),
			() -> assertThat(chickens.get(0).getPrice()).isEqualTo(12_000)
		);
	}
}