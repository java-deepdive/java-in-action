package kr.seok.document;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class EsDocumentSearchTest {
    @DisplayName("엘라스틱 서치 문서 검색 테스트")
    @Test
    void testCase1() {
        EsDocumentSearch documentSearch = new EsDocumentSearch();

        int searchDocument = documentSearch.searchDocument("movie_auto_java", "movieNm");

        assertThat(searchDocument).isNotZero();
    }
}
