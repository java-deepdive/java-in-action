package kr.seok.java8.chicken.v5;

import kr.seok.java8.chicken.Chicken;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static kr.seok.java8.chicken.ChickenBrand.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class ChickenMappingTest {
	
	@DisplayName("브랜드를 문자열로 변환하는 테스트")
	@Test
	void testCase1() {
		List<Chicken> originChickenList = List.of(
			new Chicken(KFC, 10_000, "맛있는 치킨"),
			new Chicken(KFC, 12_000, "더 맛있는 치킨"),
			new Chicken(GCOVA, 9_000, "X코바 치킨"),
			new Chicken(BBQ, 15_000, "BBC 치킨")
		);
		ChickenMapping chickenMapping = new ChickenMapping(originChickenList);
		String convertToChickenBrand = chickenMapping.convertToChickenBrand();
		assertAll(
			() -> assertThat(convertToChickenBrand).isNotEqualTo("KFC,GCOVA"),
			() -> assertThat(convertToChickenBrand).isNotEqualTo("KFC,KFC,GCOVA"),
			() -> assertThat(convertToChickenBrand).isEqualTo("KFC,GCOVA,BBQ")
		);
	}
}
