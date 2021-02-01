package kr.seok.list;

/**
 * Remove all elements from a linked list of integers that have value val.
 *
 * Example:
 *
 * Input:  1->2->6->3->4->5->6, val = 6
 * Output: 1->2->3->4->5
 *
 */
public class List_203 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() { }
        ListNode(int val) {
            this.val = val;
        }
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode removeElements(ListNode head, int val) {
        ListNode sentinel = new ListNode(0); // 일단 기본 값 0을 넣고 노드를 생성
        sentinel.next = head; // head 노드를 생성한 노드의 next에 저장함으로써 연결

        ListNode prev = sentinel; // 새 노드를 prev에 저장
        ListNode curr = head; // head를 curr에 저장

        /*
            prev -> curr 을 연결
         */
        while (curr != null) { // curr Node 부터 연결된 Node를 탐색
            if (curr.val == val) { // 탐색 노드의 값 과 삭제해야하는 값을 비교
                /*

                 */
                prev.next = curr.next;
            } else { // 앞으로 탐색
                prev = curr;
            }
            /*
                현 curr 값과 삭제하길 원하는 값과 같은 경우 (데이터를 찾음)
                1. prev.next <- curr.next 로 포인터 값을 한칸씩 당김, 포인터(curr.next)를 curr 로 이동

                해당 노드를 찾지 못함
                2. prev <- curr 로 값을 이동, 포인터(curr.next)를 curr 로 이동

             */
            curr = curr.next;
        }
        return sentinel.next;
    }
}
