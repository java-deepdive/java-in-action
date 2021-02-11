package kr.seok.list;

/**
 * Given a non-empty,
 * singly linked list with head node head,
 * return a middle node of linked list.
 *
 * If there are two middle nodes,
 * return the second middle node.
 *
 * Input:
 *  [1,2,3,4,5]
 * Output:
 *  Node 3 from this list (Serialization: [3,4,5])
 *
 * The returned node has value 3.
 * (The judge's serialization of this node is [3,4,5]).
 *
 * Note that we returned a ListNode object ans, such that:
 * ans.val = 3,
 * ans.next.val = 4,
 * ans.next.next.val = 5,
 * and ans.next.next.next = NULL.
 *
 */
public class List_876 {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() { }
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    /*
        임시 배열을 생성하여 배열에 데이터를 넣고, 그 절반의 리스트를 반환
     */
    public ListNode middleNode(ListNode head) {
        ListNode[] A = new ListNode[100];
        int t = 0;
        while (head != null) { // list 탐색
            A[t++] = head; // node의 값을 저장
            head = head.next;
        }
        return A[t / 2];
    }

    /*
        slow, fast runner technique

        fast가 list의 끝에 도달했을 때, slow는 list의 중간에 있는 특징
     */
    public ListNode middleNodeFloyd(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
