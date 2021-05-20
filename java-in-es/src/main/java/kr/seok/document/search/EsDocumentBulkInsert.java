package kr.seok.document.search;

import lombok.Builder;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpHost;
import org.elasticsearch.action.DocWriteResponse;
import org.elasticsearch.action.bulk.BulkItemResponse;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;

import java.io.IOException;
import java.util.List;

@Slf4j
public class EsDocumentBulkInsert {

    @Getter
    static class Movie {
        private final String id;
        private final String fieldName;
        private final String movieNm;

        @Builder
        public Movie(String id, String fieldName, String movieNm) {
            this.id = id;
            this.fieldName = fieldName;
            this.movieNm = movieNm;
        }
    }

    public void addBulk(String indexName, List<Movie> data) {
        RestHighLevelClient client = getRestHighLevelClient();

        // 데이터 생성
        BulkRequest request = new BulkRequest();

        data.forEach(movie -> request.add(makeSource(indexName, movie)));

        try {
            // 결과 조회
            BulkResponse bulkResponse = client.bulk(request, RequestOptions.DEFAULT);

            for (BulkItemResponse bulkItemResponse : bulkResponse) {
                DocWriteResponse itemResponse = bulkItemResponse.getResponse();
                switch (bulkItemResponse.getOpType()) {
                    case INDEX:

                    case CREATE:
                        IndexResponse indexResponse = (IndexResponse) itemResponse;
                        if (indexResponse.status().getStatus() >= 200) {
                            log.info("문서 생성");
                        }
                        break;
                    case UPDATE:
                        UpdateResponse updateResponse = (UpdateResponse) itemResponse;
                        if (updateResponse.status().getStatus() >= 200) {
                            log.info("문서 수정");
                        }
                        break;
                    case DELETE:
                        DeleteResponse deleteResponse = (DeleteResponse) itemResponse;
                        if (deleteResponse.status().getStatus() == 200) {
                            log.info("문서 삭제");
                        }
                }
            }
            client.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private IndexRequest makeSource(String indexName, Movie movie) {
        return new IndexRequest(indexName)
                .id(movie.getId())
                .source(
                        XContentType.JSON,
                        movie.getFieldName(),
                        movie.getMovieNm()
                );
    }

    private RestHighLevelClient getRestHighLevelClient() {
        return new RestHighLevelClient(
                RestClient.builder(
                        new HttpHost("127.0.0.1", 9200, "http")));
    }

}
