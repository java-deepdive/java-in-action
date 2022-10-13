package kr.seok.item37.coffee;

public enum MenuCategory {
	COFFEE("커피"),
	BEVERAGE("음료"),
	DESSERT("디저트"),
	ETC("기타");
	
	private final String name;
	
	MenuCategory(String name) {
		this.name = name;
	}
}
