package kr.seok.study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.assertj.core.api.Assertions.assertThat;

class YouTubeHashTableTest {
    YouTubeHashTable ht;

    @BeforeEach
    void setUp() {
        ht = new YouTubeHashTable(5);
    }

    @Test
    @DisplayName("HashTable 내에 LinkedList의 사이즈를 확인하기 위한 테스트")
    void testCase1() {
        assertThat(ht.data.length).isEqualTo(5);
    }

    @Test
    @DisplayName("HashTable 데이터 put() 및 get()으로 확인 테스트")
    void testCase2() {
        // given
        String test_key = "test_key";
        String test_value = "test_value";

        // when
        ht.put(test_key, test_value);

        // then
        String hValue = ht.get(test_key);
        assertThat(hValue).isEqualTo(test_value);
    }

    /*
        비어있는 배열
        비어있는 배열
        비어있는 배열
        HashCode : [743] :: Index : [3] :: Node : [Node{key='NetFlex1', value='Movie'}]
        HashCode : [403] :: Index : [3] :: Node : [Node{key='Wave', value='Movie'}]
        HashCode : [744] :: Index : [4] :: Node : [Node{key='NetFlex2', value='Drama'}]
     */
    @Test
    @DisplayName("HashTable 다건 등록 및 해시코드, 저장된 인덱스, 저장된 데이터 확인")
    void testCase3() {
        // given
        ht.put("netflix1", "Movie");
        ht.put("netflix2", "Drama");
        ht.put("Wave", "Movie");

        ht.dump();

        // when
        LinkedList<YouTubeHashTable.Node> list = new LinkedList<>();
        YouTubeHashTable.Node node1 = new YouTubeHashTable.Node("netflix1", "Movie");
        YouTubeHashTable.Node node2 = new YouTubeHashTable.Node("netflix2", "Drama");
        list.add(node1);
        list.add(node2);

        // then
        YouTubeHashTable.Node netflix1 = ht.search(list, "netflix1");
        YouTubeHashTable.Node netflix2 = ht.search(list, "netflix2");

        assertThat(netflix1.getValue()).isEqualTo("Movie");
        assertThat(netflix2.getValue()).isEqualTo("Drama");
    }
}
