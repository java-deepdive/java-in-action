package kr.seok.list;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class List_876Test {

    List_876 list;
    List_876.ListNode node1;
    @BeforeEach
    void setUp() {
        list = new List_876();
        // 연결 리스트 생성
        List_876.ListNode node5 = new List_876.ListNode(5);
        List_876.ListNode node4 = new List_876.ListNode(4, node5);
        List_876.ListNode node3 = new List_876.ListNode(3, node4);
        List_876.ListNode node2 = new List_876.ListNode(2, node3);
        node1 = new List_876.ListNode(1, node2);
    }

    @Test
    @DisplayName("배열 기반으로 리스트 탐색하고 중간 리스트를 반환")
    void testCase1() {
        List_876.ListNode midNode = list.middleNode(node1);
        assertThat(midNode.val).isEqualTo(3);
    }

    @Test
    @DisplayName("Slow, Fast Runner 기법으로 시간, 공간 복잡도에서 효율적")
    void testCase2() {
        List_876.ListNode midNode = list.middleNodeFloyd(node1);
        assertThat(midNode.val).isEqualTo(3);
    }
}
