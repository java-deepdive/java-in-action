package kr.seok.coffee.v2;

public class CoffeeOrderV2 {
	
	private final Input in = new Input();
	private final Output out = new Output();
	
	public void run() {
		Menu menu = CoffeeType.initMenu();
		
		out.printMenu(menu);
		CoffeeType menuName = CoffeeType.findByName(in.selectMenu());
		
		Customer customer = new Customer();
		customer.order(menuName, new Menu(), new Barista());
	}
	
	
}
