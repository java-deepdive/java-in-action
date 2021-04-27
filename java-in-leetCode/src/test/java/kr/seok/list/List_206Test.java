package kr.seok.list;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static kr.seok.list.List_206.ListNode;
import static kr.seok.list.List_206Test.ListNodeBuilder.append;

class List_206Test {
    List_206 list;

    @BeforeEach
    public void setUp() {
        list = new List_206();
    }

    @Test
    @DisplayName("reverse 테스트")
    void testCase1() {
        ListNode node1 = append(1);
        ListNode node2 = append(2);
        ListNode node3 = append(3);
        ListNode node4 = append(4);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = null;

        ListNode listNode = list.reverseList(node1);

        while (listNode.next != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
            if (listNode.next == null) {
                System.out.println(listNode.val);
            }
        }
    }

    static class ListNodeBuilder {
        ListNode listNode;

        private ListNodeBuilder() {
        }

        public static ListNode append(int num) {
            return new ListNode(num);
        }
    }
}
