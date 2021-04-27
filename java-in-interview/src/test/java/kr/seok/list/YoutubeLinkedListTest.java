package kr.seok.list;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class YoutubeLinkedListTest {

    YoutubeLinkedList youtubeLinkedList;

    @BeforeEach
    void setUp() {
        youtubeLinkedList = new YoutubeLinkedList();
    }

    @Test
    @DisplayName("단방햘 LinkedList 뒤에서부터 세기")
    void testCase1() {
        YoutubeLinkedList.Node node4 = new YoutubeLinkedList.Node(4, null);
        YoutubeLinkedList.Node node3 = new YoutubeLinkedList.Node(3, node4);
        YoutubeLinkedList.Node node2 = new YoutubeLinkedList.Node(2, node3);
        YoutubeLinkedList.Node first = new YoutubeLinkedList.Node(1, node2);

        int k = 1; // 배열의 인덱스

        YoutubeLinkedList.Node node = youtubeLinkedList.kThToLast(first, k);
        assertThat(node.data).isEqualTo(4);
    }

    @Test
    @DisplayName("재귀 안됨 다시 보기")
    void testCase2() {
        YoutubeLinkedList.Node node4 = new YoutubeLinkedList.Node(4, null);
        YoutubeLinkedList.Node node3 = new YoutubeLinkedList.Node(3, node4);
        YoutubeLinkedList.Node node2 = new YoutubeLinkedList.Node(2, node3);
        YoutubeLinkedList.Node first = new YoutubeLinkedList.Node(1, node2);

        int k = 2;

        YoutubeLinkedList.Reference r = new YoutubeLinkedList.Reference();
        YoutubeLinkedList.Node nodeData = youtubeLinkedList.KthToLastRecursive(first, k, r);

        assertThat(nodeData.data).isEqualTo(3);

//        k = 2;
//        YoutubeLinkedList.Node nodeData2 = youtubeLinkedList.KthToLastRecursive(first, k, r);
//        assertThat(nodeData2.data).isEqualTo(3);
    }

    @Test
    @DisplayName("포인터")
    void testCase3() {
        YoutubeLinkedList.Node node4 = new YoutubeLinkedList.Node(4, null);
        YoutubeLinkedList.Node node3 = new YoutubeLinkedList.Node(3, node4);
        YoutubeLinkedList.Node node2 = new YoutubeLinkedList.Node(2, node3);
        YoutubeLinkedList.Node first = new YoutubeLinkedList.Node(1, node2);

        // when
        int k = 3;
        YoutubeLinkedList.Node nodeData = youtubeLinkedList.KthToLastPointer(first, k);

        // then
        assertThat(nodeData.data).isEqualTo(2);

        // when
        k = 2;
        YoutubeLinkedList.Node nodeData2 = youtubeLinkedList.KthToLastPointer(first, k);

        // then
        assertThat(nodeData2.data).isEqualTo(3);
    }
}
