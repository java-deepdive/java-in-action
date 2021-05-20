package kr.seok.document;

import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpHost;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.rest.RestStatus;

import java.io.IOException;

@Slf4j
public class EsDocumentDelete {

    public void deleteDocument(String indexName, String id) {
        RestHighLevelClient client = getRestHighLevelClient();

        try {
            DeleteRequest request = new DeleteRequest(indexName, id);

            DeleteResponse deleteResponse = client.delete(request, RequestOptions.DEFAULT);

            RestStatus status = deleteResponse.status();

            if(status.getStatus() == 200) {
                log.info("삭제 성공");
            } else {
                log.info("삭제 실패");
            }

            client.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private RestHighLevelClient getRestHighLevelClient() {
        return new RestHighLevelClient(
                RestClient.builder(
                        new HttpHost("127.0.0.1", 9200, "http")));
    }
}
