package kr.seok.java8.chicken.v2;

import kr.seok.java8.chicken.Chicken;
import kr.seok.java8.chicken.ChickenBrand;
import org.junit.jupiter.api.Test;

import java.util.List;

import static kr.seok.java8.chicken.ChickenBrand.GCOVA;
import static kr.seok.java8.chicken.ChickenBrand.KFC;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ChickenReportV2Test {
	
	@Test
	void testCase1() {
		List<Chicken> originChickenList = List.of(
			new Chicken(KFC, 10_000),
			new Chicken(KFC, 12_000),
			new Chicken(GCOVA, 9_000),
			new Chicken(ChickenBrand.BBQ, 15_000)
		);
		ChickenReportV2 chickenReportV2 = new ChickenReportV2(originChickenList);
		assertThat(chickenReportV2.singleSizeReport()).containsKeys(KFC, GCOVA);
		assertAll(
			() -> assertThat(chickenReportV2.singleSizeReport().get(KFC)).hasSize(2),
			() -> assertThat(chickenReportV2.singleSizeReport().get(GCOVA)).hasSize(1)
		);
	}
}