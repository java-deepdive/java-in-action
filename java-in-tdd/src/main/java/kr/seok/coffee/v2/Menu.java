package kr.seok.coffee.v2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Menu {
	private final List<MenuItem> values = new ArrayList<>();
	
	public void add(MenuItem menuItem) {
		values.add(menuItem);
	}
	
	public MenuItem choose(CoffeeType menuName) {
		return values.stream()
			.filter(menuItem -> menuItem.isMatches(menuName))
			.findFirst()
			.orElseThrow(() -> new IllegalArgumentException("없는 메뉴입니다."));
	}
	
	public List<MenuItem> printMenu() {
		return Collections.unmodifiableList(values);
	}
}
