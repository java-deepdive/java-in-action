package kr.seok.java8.chicken.v4;

import kr.seok.java8.chicken.Chicken;
import kr.seok.java8.chicken.ChickenBrand;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ChickenDistinct {
	private final List<Chicken> chickens;
	
	public ChickenDistinct(List<Chicken> chickens) {
		this.chickens = chickens;
	}
	
	public List<Chicken> distinctByBrandAndMaxPrice(ChickenBrand brand) {
		return chickens.stream()
			.filter(chicken -> chicken.isMatchBrand(brand))
			.sorted(Comparator.comparing(Chicken::getPrice).reversed())
			.distinct()
			.collect(Collectors.toList());
	}
	
	public List<Chicken> distinctByBrandAndLimit(ChickenBrand brand, int limit) {
		return chickens.stream()
			.filter(chicken -> chicken.isMatchBrand(brand))
			.sorted(Comparator.comparing(Chicken::getPrice).reversed())
			.limit(limit)
			.collect(Collectors.toList());
	}
}