package kr.seok.list;

/**
 * Given head, the head of a linked list,
 * determine if the linked list has a cycle in it.
 * <p>
 * 헤더가 주어졌을 때, 그 안에 cycle이 존재하는지 확인하기
 * <p>
 * There is a cycle in a linked list
 * <p>
 * if there is some node in the list
 * that can be reached again by continuously following the next pointer.
 * next 포인터를 계속 따라갔을 때 다시 도달하는 경우 Cycle로 판단
 * <p>
 * Internally, pos is used to denote the index of the node that tail's next pointer is connected to.
 * Note that pos is not passed as a parameter.
 * <p>
 * 내부적으로 pos는
 * Return true if there is a cycle in the linked list.
 * Otherwise, return false.
 */
public class List_141 {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public boolean hasCycle(ListNode head) {
        if (head == null) return false;

        ListNode slow = head;
        ListNode fast = head.next;

        while (slow != fast) {
            if (fast == null || fast.next == null) return false;

            slow = slow.next; // 1칸 이동
            fast = fast.next.next; // 2칸 이동
        }

        return true;
    }
}
