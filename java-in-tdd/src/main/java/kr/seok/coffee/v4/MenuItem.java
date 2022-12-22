package kr.seok.coffee.v4;

public abstract class MenuItem {
	
	protected final String name;
	protected final int price;
	
	protected MenuItem(String name, int price) {
		this.name = name;
		this.price = price;
	}
	
	public String name() {
		return name;
	}
	
	public int price() {
		return price;
	}
}
