package kr.seok.document.search;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class EsDocumentBulkInsertTest {

    @DisplayName("엘라스틱 서치 Bulk Insert Query 테스트")
    @Test
    void testCase1() {

        List<EsDocumentBulkInsert.Movie> insertData = Arrays.asList(
                EsDocumentBulkInsert.Movie.builder().id("4").fieldName("movieNm").movieNm("살아남은 아이").build(),
                EsDocumentBulkInsert.Movie.builder().id("5").fieldName("movieNm").movieNm("프렌즈: 몬스터섬의 비밀").build(),
                EsDocumentBulkInsert.Movie.builder().id("6").fieldName("movieNm").movieNm("캡틴 아메리카: 시빌워").build()
        );

        EsDocumentBulkInsert bulkQuery = new EsDocumentBulkInsert();

        bulkQuery.addBulk("movie_auto_java", insertData);
    }
}
