package kr.seok.list;

import java.util.HashSet;
import java.util.Set;

/**
 * Given a linked list, return the node where the cycle begins.
 * If there is no cycle, return null.
 * <p>
 * There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer.
 * Internally, pos is used to denote the index of the node that tail's next pointer is connected to.
 * Note that pos is not passed as a parameter.
 * <p>
 * Notice that you should not modify the linked list.
 */
public class List_142 {
    /*
        탐색한 노드 리스트를 Set에 저장하여 중복 노드를 반환 할 수 있다.

        순환 확인
     */
    public ListNode detectCycleHash(ListNode head) {
        Set<ListNode> visited = new HashSet<>();

        ListNode node = head; // 헤더 저장

        while (node != null) { // LinkedList 탐색
            if (visited.contains(node)) { // 방문한 적이 있는 경우 그 노드 반환
                return node;
            }
            visited.add(node);
            node = node.next;
        }

        return null;
    }

    /*
        Floyd 알고리즘의 두 단계 풀이법

        1. 목록에 주기가 있는지 여부를 결정
            - 사이클이 없으면 null
        2. 교차점을 찾은 경우, 주기의 입구인 노드를 찾는다.
            - 이를 위해 두 개의 포인터를 추가로 초기화 한다.
     */
    private ListNode getIntersect(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        // A fast pointer will either loop around a cycle and meet the slow
        // pointer or reach the `null` at the end of a non-cyclic list.
        while (fast != null && fast.next != null) {
            slow = slow.next; // slower
            fast = fast.next.next;  // faster
            if (slow == fast) {
                return slow;
            }
        }

        return null;
    }

    public ListNode detectCycleFloyd(ListNode head) {
        if (head == null) {
            return null;
        }

        // If there is a cycle, the fast/slow pointers will intersect at some node.
        // Otherwise, there is no cycle, so we cannot find an entrance to a cycle.
        ListNode intersect = getIntersect(head);
        if (intersect == null) { // 교차점이 없으면 null
            return null;
        }

        // To find the entrance to the cycle, we have two pointers traverse at the same speed
        // one from the front of the list, and the other from the point of intersection.
        ListNode ptr1 = head;
        ListNode ptr2 = intersect;
        while (ptr1 != ptr2) { // 사이클의 입구를 찾기 위해 두 개의 포인터가 동일한 속도로 탐색
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }

        return ptr1;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
