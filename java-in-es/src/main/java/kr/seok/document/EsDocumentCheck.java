package kr.seok.document;

import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpHost;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;

import java.io.IOException;

@Slf4j
public class EsDocumentCheck {

    private static RestHighLevelClient getRestHighLevelClient() {
        return new RestHighLevelClient(
                RestClient.builder(
                        new HttpHost("127.0.0.1", 9200, "http")));
    }

    public boolean isDoc(String indexName, String id) {
        RestHighLevelClient client = getRestHighLevelClient();

        try {
            GetRequest getRequest = new GetRequest(indexName, id);

            boolean exists = client.exists(getRequest, RequestOptions.DEFAULT);

            if (exists) {
                log.info("문서가 존재합니다.");
            } else {
                log.info("문서가 존재하지 않습니다.");
            }

            client.close();
            return exists;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}
