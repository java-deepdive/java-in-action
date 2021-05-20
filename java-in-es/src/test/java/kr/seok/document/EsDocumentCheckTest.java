package kr.seok.document;

import kr.seok.document.search.EsDocumentCheck;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class EsDocumentCheckTest {

    @DisplayName("엘라스틱 서치 문서 확인 테스트")
    @Test
    void testCase1() {
        EsDocumentCheck documentCheck = new EsDocumentCheck();
        // 문서 확인
        boolean doc = documentCheck.isDoc("movie_auto_java", "1");
        // then
        assertThat(doc).isTrue();
    }
}
