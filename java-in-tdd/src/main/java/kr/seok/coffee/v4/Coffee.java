package kr.seok.coffee.v4;

public class Coffee extends MenuItem {
	
	private Coffee(String name, int price) {
		super(name, price);
	}
	
	public static Coffee of(String name, int price) {
		return new Coffee(name, price);
	}
	
	@Override
	public String toString() {
		return name + ", " + price;
	}
}
