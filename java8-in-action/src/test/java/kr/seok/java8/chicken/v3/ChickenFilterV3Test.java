package kr.seok.java8.chicken.v3;

import kr.seok.java8.chicken.Chicken;
import kr.seok.java8.chicken.ChickenBrand;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static kr.seok.java8.chicken.ChickenBrand.GCOVA;
import static kr.seok.java8.chicken.ChickenBrand.KFC;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class ChickenFilterV3Test {
	
	@DisplayName("브랜드로 필터링 테스트")
	@Test
	void testCase1() {
		List<Chicken> originChickenList = List.of(
			new Chicken(KFC, 10_000),
			new Chicken(KFC, 12_000),
			new Chicken(GCOVA, 9_000),
			new Chicken(ChickenBrand.BBQ, 15_000)
		);
		
		ChickenFilterV3 chickenFilterV3 = new ChickenFilterV3(originChickenList);
		List<Chicken> kfcChicken = chickenFilterV3.filterBrandChicken(KFC);
		
		assertAll(
			() -> assertThat(kfcChicken).hasSize(2),
			() -> assertThat(kfcChicken.get(0).getBrand()).isEqualTo(KFC),
			() -> assertThat(kfcChicken.get(1).getBrand()).isEqualTo(KFC)
		);
	}
}