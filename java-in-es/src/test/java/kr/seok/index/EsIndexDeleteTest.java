package kr.seok.index;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class EsIndexDeleteTest {

    @DisplayName("엘라스틱 서치 인덱스 삭제 테스트")
    @Test
    void testCase1() {
        EsIndexDelete delete = new EsIndexDelete();

        // 인덱스 삭제
        boolean movie_auto_java = delete.deleteIndex("movie_auto_java");

        assertThat(movie_auto_java).isTrue();
    }
}
