package kr.seok.list;

/**
 * 단방향 LinkedList를 역방향으로 반환
 */
public class List_206 {

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        // 1, 2, 3, 4
        while (curr != null) { // 단방향 리스트의 특성에 따라 head를 기준으로 탐색

            ListNode next = curr.next; // 다음 노드를 저장 2
            curr.next = prev; // 1을 next에 저장 -> 2, 1
            prev = curr;

            curr = next;
        }
        return prev;
    }
}
