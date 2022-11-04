package kr.seok.item7.memoryleek;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("가변 객체 테스트")
class MutableCustomKeyTest {
	
	@Test
	void testCase1() {
		Map<MutableCustomKey, String> map = new HashMap<>();
		
		// Key: Shamik
		MutableCustomKey key = new MutableCustomKey("Shamik");
		
		// map Shamik :: Shamik Mitra
		
		map.put(key, "Shamik Mitra");
		
		assertThat(key.getName()).isEqualTo("Shamik");
		assertThat(map.get(key)).contains("Shamik Mitra");
		
		MutableCustomKey refKey = new MutableCustomKey("Shamik");
		
		String val = map.get(refKey);
		assertThat(val).isNull();
		
		// map Bubun :: Shamik Mitra
		key.setName("Bubun");
		String s = map.get(key);
		assertThat(s).contains("Shamik Mitra");
		
		// map Shamik :: null
		String val1 = map.get(refKey);
		assertThat(val1).isNull();
	}
}