package kr.seok.java8.chicken.v8;

import kr.seok.java8.chicken.Chicken;
import kr.seok.java8.chicken.ChickenBrand;

import java.util.Collections;
import java.util.List;

class ChickenFixture {
	private static final List<Chicken> chickenFixture;
	
	static {
		chickenFixture = List.of(
			new Chicken(ChickenBrand.NENE, 10000, "허니콤보"),
			new Chicken(ChickenBrand.NENE, 9000, "코찡마요"),
			new Chicken(ChickenBrand.NENE, 8000, "코코넛치킨"),
			new Chicken(ChickenBrand.NENE, 7000, "콤비네이션"),
			new Chicken(ChickenBrand.BHC, 10000, "콤보"),
			new Chicken(ChickenBrand.BHC, 9000, "마늘갈릭"),
			new Chicken(ChickenBrand.GCOVA, 12000, "양념치킨")
		);
	}
	
	public static List<Chicken> getChickenFixture() {
		return Collections.unmodifiableList(chickenFixture);
	}
	
	public static int getNeneChickenPrice() {
		return chickenFixture.stream()
				.filter(chicken -> chicken.isMatchBrand(ChickenBrand.NENE))
				.mapToInt(Chicken::getPrice)
				.sum();
	}
}