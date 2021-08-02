package kr.seok.list;

/**
 * Remove Duplicates from Sorted List
 * <p>
 * Given the head of a sorted linked list,
 * delete all duplicates such that each element appears only once.
 * Return the linked list sorted as well.
 */
public class List_83 {

    // Straight-Forward Approach
    public ListNode deleteDuplicates(ListNode head) {
        ListNode current = head;
        while (current != null && current.next != null) {
            if (current.next.val == current.val) {
                current.next = current.next.next; // 값이 동일하면 한칸 당겨서 없애기
            } else {
                current = current.next; // 다음 노드 저장
            }
        }
        return head;
    }

    // singly-linked list
    public class ListNode {
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

}
