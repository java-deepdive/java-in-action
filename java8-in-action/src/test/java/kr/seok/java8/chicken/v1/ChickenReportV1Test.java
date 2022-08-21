package kr.seok.java8.chicken.v1;

import kr.seok.java8.chicken.Chicken;
import kr.seok.java8.chicken.ChickenBrand;
import org.junit.jupiter.api.Test;

import java.util.List;

import static kr.seok.java8.chicken.ChickenBrand.GCOVA;
import static kr.seok.java8.chicken.ChickenBrand.KFC;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class ChickenReportV1Test {
	
	@Test
	void testCase1() {
		List<Chicken> originChickenList = List.of(
			new Chicken(KFC, 10_000),
			new Chicken(KFC, 10_000),
			new Chicken(GCOVA, 9_000),
			new Chicken(ChickenBrand.BBQ, 15_000)
		);
		ChickenReportV1 chickenReportV1 = new ChickenReportV1(originChickenList);
		assertThat(chickenReportV1.singleSizeReport()).containsKeys(KFC, GCOVA);
		assertAll(
			() -> assertThat(chickenReportV1.singleSizeReport().get(KFC)).hasSize(2),
			() -> assertThat(chickenReportV1.singleSizeReport().get(GCOVA)).hasSize(1)
		);
	}
}