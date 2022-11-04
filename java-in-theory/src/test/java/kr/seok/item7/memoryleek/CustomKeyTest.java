package kr.seok.item7.memoryleek;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("불변 객체 테스트")
class CustomKeyTest {
	
	@Test
	void testCase1() {
		Map<CustomKey, String> map = new HashMap<>();
		
		// 신규 이름 등록
		CustomKey name = new CustomKey("Shamik");
		map.put(name, "Shamik Mitra");
		
		// 같은 이름으로 조회
		CustomKey sameName = new CustomKey("Shamik");
		String value = map.get(sameName);
		
		assertThat(value).isEqualTo("Shamik Mitra");
		assertThat(name).isEqualTo(sameName);
	}
}