package kr.seok.item13.external.jackson;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class JacksonCoffeeTest {

    @DisplayName("Jackson 객체 복사")
    @Test
    void testCase1() {
        JacksonCoffee coffee = new JacksonCoffee(Bean.of("빈"), Water.regular(), Brand.NONE);

        ObjectMapper mapper = new ObjectMapper();

        // Serializable 을 하기 위해서는 해당 클래스의 필드에 접근할 수 있도록 설정이 필요
        mapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);

        JacksonCoffee deepCopy = null;
        try {
            deepCopy = mapper.readValue(mapper.writeValueAsString(coffee), JacksonCoffee.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        assertThat(coffee).isEqualTo(deepCopy);
    }
}
