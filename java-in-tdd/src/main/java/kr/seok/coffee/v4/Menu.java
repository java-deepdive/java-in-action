package kr.seok.coffee.v4;

import java.util.LinkedList;
import java.util.List;

public enum Menu {
	COFFEE("커피", new LinkedList<>()),
	DESERT("디저트", new LinkedList<>()),
	TEA("티", new LinkedList<>());
	
	private final String name;
	private final List<MenuItem> menuItems;
	
	Menu(String name, List<MenuItem> menuItems) {
		this.name = name;
		this.menuItems = menuItems;
	}
}
