package kr.seok.list;

import java.util.ArrayList;
import java.util.List;

public class List_234 {
    public static class ListNode {
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

    /**
     * Copy into Array List and then Use Two Pointer Technique
     */
    public boolean isPalindrome(ListNode head) {

        List<Integer> visited = new ArrayList<>();

        // copy
        ListNode cur = head;
        while (cur != null) {
            visited.add(cur.val);
            cur = cur.next;
        }

        int front = 0;
        int back = visited.size() - 1;

        // two pointer로 검색
        while (front < back) {
            if (!visited.get(front).equals(visited.get(back))) {
                return false;
            }
            front++;
            back--;
        }
        return true;
    }

    private ListNode frontPointer;

    public boolean isPalindromeRecursive(ListNode head) {
        frontPointer = head;
        return recursivelyCheck(head);
    }

    private boolean recursivelyCheck(ListNode currentNode) {
        if (currentNode != null) {
            if (!recursivelyCheck(currentNode.next)) return false;
            if (currentNode.val != frontPointer.val) return false;
            frontPointer = frontPointer.next;
        }
        return true;
    }
}
