package kr.seok.document;

import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpHost;
import org.elasticsearch.ElasticsearchException;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.rest.RestStatus;

import java.io.IOException;

import static org.elasticsearch.common.xcontent.XContentFactory.jsonBuilder;

@Slf4j
public class EsDocumentCreate {

    private RestHighLevelClient getRestHighLevelClient() {
        return new RestHighLevelClient(
                RestClient.builder(
                        new HttpHost("127.0.0.1", 9200, "http")));
    }

    public void createDocument() {
        RestHighLevelClient client = getRestHighLevelClient();

        // 인덱스 명
        String INDEX_NAME = "movie_auto_java";

        // 문서 키값
        String _id = "1";

        // 데이터 추가
        IndexRequest request = new IndexRequest(INDEX_NAME).id(_id);

        try {

            XContentBuilder sourceBuilder = jsonBuilder()
                    .startObject()
                    .field("movieCd", "20173732")
                    .field("movieNm", "살아남은 아이")
                    .field("movieNmEn", "Last Child")
                    .field("prdtYear", 1)
                    .endObject();

            request.source(sourceBuilder);

            // 결과 조회
            IndexResponse response = client.index(request, RequestOptions.DEFAULT);

            RestStatus status = response.status();

            if (status.getStatus() == 201) {
                log.info("정상 생성");
            }
            /* ID 충돌로 인한 오류 발생 시 예외처리라고 되어 있는데 문서 내용이 변하기만 함 */
            client.close();

        } catch (IOException e) {
            e.getMessage();
        } catch (ElasticsearchException e) {
            if (e.status() == RestStatus.CONFLICT) {
                System.out.println("문서 생성에 실패하였습니다.");
            }
        }
    }

}
