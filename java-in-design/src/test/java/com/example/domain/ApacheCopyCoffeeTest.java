package com.example.domain;

import com.example.afactory.component.Bean;
import com.example.afactory.component.Water;
import org.apache.commons.lang.SerializationUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ApacheCopyCoffeeTest {

    @DisplayName("아파치 라이브러리를 사용한 복사")
    @Test
    void testCase1() {
        ApacheCopyCoffee coffee = new ApacheCopyCoffee(new Bean(), Water.regular(), Brand.NONE);

        // 깊은 복사본을 얻기 위해 객체를 직렬화 한 다음 새 객체로 역 직렬화 할 수 있다.
        // 메서드가 직렬화 할 수 없는 클래스를 만나는 경우 SerializationException를 던진다.
        // https://stackoverflow.com/questions/9747443/java-io-invalidclassexception-no-valid-constructor/51492340
        ApacheCopyCoffee deepCopy = (ApacheCopyCoffee) SerializationUtils.clone(coffee);

        assertThat(coffee).isEqualTo(deepCopy);
    }
}
