package kr.seok.document;

import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpHost;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.sort.FieldSortBuilder;
import org.elasticsearch.search.sort.SortOrder;

import java.io.IOException;
import java.util.Map;

@Slf4j
public class EsDocumentSearch {

    public int searchDocument(String indexName, String fieldName) {

        RestHighLevelClient client = getRestHighLevelClient();

        // 검색 쿼리 설정
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();

        searchSourceBuilder
                .query(QueryBuilders.matchAllQuery())
                .from(0)
                .size(5)
                .sort(
                        new FieldSortBuilder(fieldName).order(SortOrder.DESC)
                );

        // 요청
        SearchRequest searchRequest = searchRequest(indexName, searchSourceBuilder);

        try  {
            // 응답
            SearchResponse searchResponse = client.search(searchRequest, RequestOptions.DEFAULT);
            SearchHits searchHits = searchResponse.getHits();

            /* hits 된 데이터 출력 */
            for (SearchHit hit : searchHits) {
                Map<String, Object> sourceAsMap = hit.getSourceAsMap();
                log.info("data : {}", sourceAsMap);
            }

            client.close();

            return searchHits.getHits().length;

        } catch (IOException e) {
            e.getMessage();
        }
        return 0;
    }

    private SearchRequest searchRequest(String indexName, SearchSourceBuilder source) {

        SearchRequest searchRequest = new SearchRequest(indexName);
        searchRequest.source(source);

        return searchRequest;
    }

    private static RestHighLevelClient getRestHighLevelClient() {
        return new RestHighLevelClient(
                RestClient.builder(new HttpHost("127.0.0.1", 9200, "http")));
    }
}
