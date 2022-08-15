package kr.seok.coffee.v2;

public class Barista {
	public Coffee makeCoffee(MenuItem menuItem) {
		return new Coffee(menuItem);
	}
}
