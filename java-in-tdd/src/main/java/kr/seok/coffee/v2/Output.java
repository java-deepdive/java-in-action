package kr.seok.coffee.v2;

public class Output {
	public void printMenu(Menu menu) {
		for (MenuItem menuItem : menu.printMenu()) {
			System.out.println(menuItem);
		}
	}
}
