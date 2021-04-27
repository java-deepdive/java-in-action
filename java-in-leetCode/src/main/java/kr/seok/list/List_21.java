package kr.seok.list;

public class List_21 {
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

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode ret = null;
        ListNode cur = null;

        while (l1 != null || l2 != null) {
            if (l2 == null || (l1 != null && l1.val < l2.val)) {
                // pick from l1
                if (ret == null) { // 데이터를 처음 넣는 경우
                    ret = l1;
                    cur = l1;
                    l1 = l1.next;
                } else {
                    cur.next = l1;
                    cur = l1;
                    l1 = l1.next;
                }
            } else {
                // pick from l2
                if (ret == null) { // 데이터 처음 넣는 경우
                    ret = l2;
                    cur = l2;
                    l2 = l2.next;
                } else {
                    cur.next = l2;
                    cur = l2;
                    l2 = l2.next;
                }
            }
        }
        return ret;
    }
}
