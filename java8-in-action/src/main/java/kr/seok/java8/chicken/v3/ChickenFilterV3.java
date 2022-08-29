package kr.seok.java8.chicken.v3;

import kr.seok.java8.chicken.Chicken;
import kr.seok.java8.chicken.ChickenBrand;

import java.util.List;
import java.util.stream.Collectors;

public class ChickenFilterV3 {
	private final List<Chicken> chickens;
	
	public ChickenFilterV3(List<Chicken> chickens) {
		this.chickens = chickens;
	}
	
	public List<Chicken> filterBrandChicken(ChickenBrand brand) {
		return this.chickens.stream()
			.filter(chicken -> chicken.isMatch(brand))
			.collect(Collectors.toList());
	}
}
