package kr.seok.document.search;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class EsDocumentQueryTest {

    @DisplayName("문서 조회 테스트")
    @Test
    void testCase1() {
        // given
        EsDocumentQuery doc = new EsDocumentQuery();
        // when
        boolean query = doc.documentQuery("movie_auto_java", "1");
        // then
        assertThat(query).isTrue();
    }
}
