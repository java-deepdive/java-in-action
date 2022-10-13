package kr.seok.item37.coffee;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class MenuInitializerTest {
	
	@DisplayName("커피 메뉴 초기화 테스트")
	@Test
	void testCase1() {
		// given
		MenuInitializer menuInitializer = new MenuInitializer();
		List<Menu> menus = new ArrayList<>();
		menus.add(new Menu("아메리카노", MenuCategory.COFFEE));
		menus.add(new Menu("카페라떼", MenuCategory.COFFEE));
		menus.add(new Menu("카푸치노", MenuCategory.COFFEE));
		menus.add(new Menu("카페모카", MenuCategory.COFFEE));
		menus.add(new Menu("카라멜마끼아또", MenuCategory.COFFEE));
		menus.add(new Menu("바닐라라떼", MenuCategory.COFFEE));
		menus.add(new Menu("헤이즐넛라떼", MenuCategory.COFFEE));
		menus.add(new Menu("조리퐁쉐이크", MenuCategory.BEVERAGE));
		menus.add(new Menu("초코쉐이크", MenuCategory.BEVERAGE));
		menus.add(new Menu("딸기쉐이크", MenuCategory.BEVERAGE));
		// when
		
		Map<MenuCategory, Set<Menu>> menuCategorySetMap = menuInitializer.addCafeMenuTypeEnumMap(menus);
		String menuInCategory = menuInitializer.findMenuInCategory(menuCategorySetMap, MenuCategory.COFFEE, "아메리카노");
		
		// then
		assertThat(menuInCategory).isEqualTo("아메리카노");
	}
}