package kr.seok.item37.coffee;

import java.util.*;

public class MenuInitializer {
	
	public String findMenuInCategory(Map<MenuCategory, Set<Menu>> origin, MenuCategory category, String menuName) {
		Set<Menu> menus = origin.get(category);
		if (menus == null) {
			throw new IllegalArgumentException("해당 카테고리에 메뉴가 존재하지 않습니다.");
		}
		for (Menu menu : menus) {
			if (menu.getName().equals(menuName)) {
				return menu.getName();
			}
		}
		throw new IllegalArgumentException("해당 메뉴가 존재하지 않습니다.");
	}
	
	public Map<MenuCategory, Set<Menu>> addCafeMenuTypeEnumMap(List<Menu> menuCategoryList) {
		// EnumMap 생성
		Map<MenuCategory, Set<Menu>> menuByCategory = new EnumMap<>(MenuCategory.class);
		
		// EnumMap 내에 Set 컬렉션 생성
		for (MenuCategory category : MenuCategory.values()) {
			menuByCategory.put(category, new HashSet<>());
		}
		
		// 사용자가 등록한 메뉴를 카테고리에 따라 Set을 조회 후 등록
		for (Menu menu : menuCategoryList) {
			menuByCategory.get(menu.getCategory()).add(menu);
		}
		
		System.out.println(menuByCategory);
		return menuByCategory;
	}
	
	public void addMenu(List<Menu> menus) {
		// 메뉴의 카테고리 종류 정의
		int menuCategoryMaxLength = MenuCategory.values().length;
		// 1. 카페 메뉴들을 카테고리 분류 기준에 따라 메뉴를 등록
		Set<Menu>[] menuByCategory = new Set[menuCategoryMaxLength];
		
		// 2. 배열을 초기화 하기 위해 Set 구현체 생성
		for (int i = 0; i < menuByCategory.length; i++) {
			menuByCategory[i] = new HashSet<>();
		}
		
		// 3. 사용자가 등록한 데이터를 Set 컨테이너에 등록
		for (Menu menu : menus) {
			menuByCategory[menu.getCategory().ordinal()].add(menu);
		}
		
		// 인덱스의 의미를 알 수 없어 직접 레이블을 달아 데이터 확인 작업 필요
		for (int i = 0; i < menuByCategory.length; i++) {
			System.out.printf("%s: %s%n", MenuCategory.values()[i], menuByCategory[i]);
		}
	}
}
