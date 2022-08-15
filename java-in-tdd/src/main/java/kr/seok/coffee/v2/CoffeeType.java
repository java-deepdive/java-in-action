package kr.seok.coffee.v2;

enum CoffeeType {
		AMERICANO(5000),
		LATTE(6500),
		CAPPUCCINO(7000),
		ESPRESSO(4000);
		
		private final int price;
		
		CoffeeType(int price) {
			this.price = price;
		}
		
		public static Menu initMenu() {
			Menu menu = new Menu();
			for (CoffeeType coffeeType : CoffeeType.values()) {
				menu.add(new MenuItem(coffeeType.name(), coffeeType.price));
			}
			return menu;
		}
		
		public static CoffeeType findByName(String name) {
			for (CoffeeType coffeeType : CoffeeType.values()) {
				if (coffeeType.name().equals(name)) {
					return coffeeType;
				}
			}
			throw new RuntimeException("존재하지 않는 커피입니다.");
		}
	}