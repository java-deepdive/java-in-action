package kr.seok.list;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class List_148Test {

    List_148 list;

    @BeforeEach
    void setUp() {
        list = new List_148();
    }

    @Test
    @DisplayName("4, 2, 1, 3 asc 정렬 테스트")
    void testCase1() {
        List_148.ListNode node4 = new List_148.ListNode(3);
        List_148.ListNode node3 = new List_148.ListNode(1, node4);
        List_148.ListNode node2 = new List_148.ListNode(2, node3);
        List_148.ListNode node1 = new List_148.ListNode(4, node2);

        List_148.ListNode listNode = list.sortList_TopDownMergeSort(node1);
        while(listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
}
