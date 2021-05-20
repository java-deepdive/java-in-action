package kr.seok.document;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class EsDocumentDeleteTest {

    @DisplayName("엘라스틱 서치 문서 삭제 테스트")
    @Test
    void testCase1() {
        EsDocumentDelete delete = new EsDocumentDelete();
        // 문서 삭제
        delete.deleteDocument("movie_auto_java", "1");
    }
}
