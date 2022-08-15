package kr.seok.coffee.v2;

public class Customer {
	public void order(CoffeeType menuName, Menu menu, Barista barista) {
		MenuItem menuItem = menu.choose(menuName);
		Coffee coffee = barista.makeCoffee(menuItem);
		System.out.println(coffee);
	}
}
