package kr.seok.document;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class EsDocumentCreateTest {

    @DisplayName("엘라스틱 서치 문서 생성 테스트")
    @Test
    void testCase1() {
        EsDocumentCreate create = new EsDocumentCreate();

        // 생성 테스트
        create.createDocument();
    }
}
