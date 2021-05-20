package kr.seok.document.search;

import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpHost;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;

import java.io.IOException;
import java.util.Map;

/**
 * 문서 조회
 */
@Slf4j
public class EsDocumentQuery {

    public boolean documentQuery(String indexName, String id) {
        RestHighLevelClient client = getRestHighLevelClient();

        // 요청
        GetRequest request = new GetRequest(indexName, id);

        try {
            // 응답
            GetResponse response = client.get(request, RequestOptions.DEFAULT);

            // 응답의 결과를 Map 형태로 제공받는다.
            if (response.isExists()) {
                long version = response.getVersion();
                Map<String, Object> sourceAsMap = response.getSourceAsMap();

                log.info("response String : {} :: version : {}", response.getSourceAsString(), version);

                for(Map.Entry<String, Object> entity : sourceAsMap.entrySet()) {
                    log.info("response entity : {}", entity);
                }

            } else {
                log.info("결과가 존재하지 않습니다.");
            }

            boolean exists = client.exists(request, RequestOptions.DEFAULT);

            client.close();

            return exists;

        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    private RestHighLevelClient getRestHighLevelClient() {
        return new RestHighLevelClient(
                RestClient.builder(
                        new HttpHost("127.0.0.1", 9200, "http")));
    }
}
