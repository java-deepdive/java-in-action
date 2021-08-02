package kr.seok.document.search;

import org.apache.http.HttpHost;
import org.elasticsearch.action.search.MultiSearchRequest;
import org.elasticsearch.action.search.MultiSearchResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.builder.SearchSourceBuilder;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class EsDocumentMultiQuery {

    public void multiConditionQuery() {
        RestHighLevelClient client = getRestHighLevelClient();

        String INDEX_NAME = "movie_search";
        String TYPE_NAME = "_doc";
        String FIELD_NAME = "movieNm";

        String QUERY_TEXT = "아내들", QUERY_TEXT2 = "아이";

        MultiSearchRequest request = new MultiSearchRequest();

        /* 검색 조건 쿼리 만들기 */
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        searchSourceBuilder
                .query(QueryBuilders.matchQuery(FIELD_NAME, QUERY_TEXT));

        /* 검색 쿼리 생성 1 */
        SearchRequest firstSearchRequest = new SearchRequest(INDEX_NAME);
        firstSearchRequest
                .source(searchSourceBuilder);


        /* 검색 쿼리 추가 1 */
        request.add(firstSearchRequest);

        /* 검색 쿼리 생성 2 */
        searchSourceBuilder = new SearchSourceBuilder();
        searchSourceBuilder
                .query(QueryBuilders.matchQuery(FIELD_NAME, QUERY_TEXT2));

        SearchRequest secondSearchRequest = new SearchRequest(INDEX_NAME);
        secondSearchRequest.source(searchSourceBuilder);

        /* 검색 쿼리 추가 2*/
        request.add(secondSearchRequest);

        try {
            /* 다중 조건 쿼리 요청 */
            MultiSearchResponse multiSearchResponse = client.msearch(request, RequestOptions.DEFAULT);
            List<SearchResponse> searchResponses = new ArrayList<>();
            for (MultiSearchResponse.Item multiSearchResponseItem : multiSearchResponse.getResponses()) {
                searchResponses.add(multiSearchResponseItem.getResponse());
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
