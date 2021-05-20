package kr.seok.connect;


import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;

import java.io.IOException;

@Slf4j
public class ElasticSearchConnection {
    public static void main(String[] args) {
        try {
            RestHighLevelClient client =
                    new RestHighLevelClient(RestClient.builder(new HttpHost("127.0.0.1", 9200, "http")));
            log.info("client 실행");

            client.close();
        } catch (IOException e) {
            log.info("client 연결 오류");
        }
    }
}
