package kr.seok.item89;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static kr.seok.item89.Util.deserialize;
import static kr.seok.item89.Util.serialize;
import static org.assertj.core.api.Assertions.assertThat;

class Elvis_3Test {

    @DisplayName("싱글턴 유지 케이스 테스트")
    @Test
    void testCase1() {
        // given
        Elvis_3 instance = Elvis_3.INSTANCE;

        // when
        byte[] serialized = serialize(instance);

        Elvis_3 deserializedElvis = (Elvis_3) deserialize(serialized);
        System.out.printf("old : %s , new : %s%n", instance, deserializedElvis);

        // then
        assertThat(instance).isEqualTo(deserializedElvis);
    }

}
