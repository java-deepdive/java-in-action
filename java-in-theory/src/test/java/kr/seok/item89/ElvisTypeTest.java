package kr.seok.item89;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ElvisTypeTest {

    @DisplayName("인스턴스 비교 테스트")
    @Test
    void testCase1() {
        ElvisType instance = ElvisType.INSTANCE;
        ElvisType instance2 = ElvisType.INSTANCE;
        instance.printFavorites();
        instance2.printFavorites();

        assertThat(instance).isEqualTo(instance2);
    }
}
