package kr.seok.item37.coffee;

import java.util.Objects;

public class Menu {
	
	private final String name;
	private final MenuCategory category;
	
	public Menu(String name, MenuCategory category) {
		this.name = name;
		this.category = category;
	}
	
	public String getName() {
		return name;
	}
	
	public MenuCategory getCategory() {
		return category;
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Menu)) return false;
		Menu menu = (Menu) o;
		return Objects.equals(name, menu.name) && category == menu.category;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(name, category);
	}
	
	@Override
	public String toString() {
		return "Menu{" +
			"name='" + name + '\'' +
			", category=" + category +
			'}';
	}
}
