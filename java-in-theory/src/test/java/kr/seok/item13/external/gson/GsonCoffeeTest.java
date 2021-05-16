package kr.seok.item13.external.gson;

import com.google.gson.Gson;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class GsonCoffeeTest {

    @DisplayName("Gson 라이브러리를 통한 객체 복사")
    @Test
    void testCase1() {
        GsonCoffee coffee = new GsonCoffee(Bean.of("루악"), Water.regular(), Brand.NONE);

        // Gson으로 변환하기 위해서 Serializable 인터페이스를 구현할 필요가 없다.
        Gson gson = new Gson();
        GsonCoffee deepCopy = gson.fromJson(gson.toJson(coffee), GsonCoffee.class);

        assertThat(coffee).isEqualTo(deepCopy);
    }
}
