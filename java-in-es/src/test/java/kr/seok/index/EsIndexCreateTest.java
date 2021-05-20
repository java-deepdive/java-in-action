package kr.seok.index;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class EsIndexCreateTest {

    @DisplayName("엘라스틱 서치 인덱스 생성 테스트")
    @Test
    void testCase1() {
        EsIndexCreate create = new EsIndexCreate();
        // es 인덱스 생성
        boolean createIndex = create.createIndex();

        assertThat(createIndex).isTrue();
    }
}
