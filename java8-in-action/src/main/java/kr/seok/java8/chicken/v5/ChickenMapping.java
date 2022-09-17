package kr.seok.java8.chicken.v5;

import kr.seok.java8.chicken.Chicken;
import kr.seok.java8.chicken.ChickenBrand;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ChickenMapping {
	
	private final List<Chicken> chickens;
	
	public ChickenMapping(List<Chicken> chickens) {
		this.chickens = chickens;
	}
	
	public String convertToChickenBrand() {
		return chickens.stream()
			.map(Chicken::getBrand)
			.map(ChickenBrand::name)
			.distinct()
			.collect(Collectors.joining(","));
	}
}
