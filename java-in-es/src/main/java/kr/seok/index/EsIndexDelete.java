package kr.seok.index;

import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpHost;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.support.master.AcknowledgedResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;

import java.io.IOException;

@Slf4j
public class EsIndexDelete {

    public boolean deleteIndex(String indexName) {
        RestHighLevelClient client = getRestHighLevelClient();
        // 인덱스 삭제
        DeleteIndexRequest request = new DeleteIndexRequest(indexName);

        try {

            /* DeleteIndexResponse -> AcknowledgedResponse */
            AcknowledgedResponse deleteIndexResponse =
                    client.indices().delete(request, RequestOptions.DEFAULT);

            boolean acknowledged = deleteIndexResponse.isAcknowledged();

            if(acknowledged) log.info("삭제 확인");

            client.close();

            return acknowledged;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return false;
    }

    private static RestHighLevelClient getRestHighLevelClient() {
        return new RestHighLevelClient(
                RestClient.builder(
                        new HttpHost("127.0.0.1", 9200, "http")));
    }
}
