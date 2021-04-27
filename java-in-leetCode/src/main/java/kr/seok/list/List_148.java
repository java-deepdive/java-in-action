package kr.seok.list;

/**
 * Given the head of a linked list,
 * return the list after sorting it in ascending order.
 * <p>
 * Follow up: Can you sort the linked list in O(n logn) time and O(1) memory (i.e. constant space)?
 */
public class List_148 {

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

    // Top Down Merge Sort
    public ListNode sortList_TopDownMergeSort(ListNode head) {

        // terminate check
        if (head == null || head.next == null)
            return head;

        ListNode mid = getMid(head); // 중앙 노드 찾기
        ListNode left = sortList_TopDownMergeSort(head); // left 분할
        ListNode right = sortList_TopDownMergeSort(mid); // right 분할
        return merge(left, right);
    }

    private ListNode getMid(ListNode head) {
        ListNode midPrev = null; // 임의 노드 생성
        while (head != null && head.next != null) { // 헤더 , 헤더 next 가 모두 존재하는 경우
            // 임의노드에 값이 없는 경우 헤더를, 이미 head 값으로 등롣을 한 경우 midPerv의 다음 노드를 저장
            midPrev = (midPrev == null) ? head : midPrev.next;
            // 헤더 값에 next next 노드를 저장?
            head = head.next.next;
        }
        // midPrev.next 값을 mid에 저장
        ListNode mid = midPrev.next;
        midPrev.next = null;
        return mid;
    }

    ListNode merge(ListNode list1, ListNode list2) {

        ListNode dummyHead = new ListNode(); // 노드 생성
        ListNode tail = dummyHead; // 임의 노드를 tail에 저장

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                tail.next = list1;
                list1 = list1.next;
            } else {
                tail.next = list2;
                list2 = list2.next;
            }
            tail = tail.next;
        }
        tail.next = (list1 != null) ? list1 : list2;
        return dummyHead.next;
    }

    // ###### Bottom Up Merge Sort
    ListNode tail = new ListNode();
    ListNode nextSubList = new ListNode();

    public ListNode sortList_bottomUpMergeSort(ListNode head) {
        if (head == null || head.next == null)
            return head;

        int n = getCount(head);
        ListNode start = head;
        ListNode dummyHead = new ListNode();

        for (int size = 1; size < n; size = size * 2) {
            tail = dummyHead;
            while (start != null) {
                if (start.next == null) {
                    tail.next = start;
                    break;
                }
                ListNode mid = split(start, size);
                bottomUpMergeSort(start, mid);
                start = nextSubList;
            }
            start = dummyHead.next;
        }
        return dummyHead.next;
    }

    ListNode split(ListNode start, int size) {
        ListNode midPrev = start;
        ListNode end = start.next;
        //use fast and slow approach to find middle and end of second linked list
        for (int index = 1; index < size && (midPrev.next != null || end.next != null); index++) {
            if (end.next != null) {
                end = (end.next.next != null) ? end.next.next : end.next;
            }
            if (midPrev.next != null) {
                midPrev = midPrev.next;
            }
        }
        ListNode mid = midPrev.next;
        midPrev.next = null;
        nextSubList = end.next;
        end.next = null;
        // return the start of second linked list
        return mid;
    }

    void bottomUpMergeSort(ListNode list1, ListNode list2) {
        ListNode dummyHead = new ListNode();
        ListNode newTail = dummyHead;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                newTail.next = list1;
                list1 = list1.next;
                newTail = newTail.next;
            } else {
                newTail.next = list2;
                list2 = list2.next;
                newTail = newTail.next;
            }
        }
        newTail.next = (list1 != null) ? list1 : list2;
        // traverse till the end of merged list to get the newTail
        while (newTail.next != null) {
            newTail = newTail.next;
        }
        // link the old tail with the head of merged list
        tail.next = dummyHead.next;
        // update the old tail to the new tail of merged list
        tail = newTail;
    }

    int getCount(ListNode head) {
        int cnt = 0;
        ListNode ptr = head;
        while (ptr != null) {
            ptr = ptr.next;
            cnt++;
        }
        return cnt;
    }
}
