package kr.seok.list;

import java.util.Stack;

public class YoutubeLinkedList {

    // ######## DataStructure
    // 단방향 linked list
    static class Node {
        int data;
        Node next = null;

        public Node() {
        }

        public Node(int d) {
            this.data = d;
        }

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }

        public void retrieve() {
            Node n = this;
            while (n.next != null) {
                System.out.print(n.data + " -> ");
                n = n.next;
            }
            System.out.println(n.data);
        }

        public void append(int d) {
            Node end = new Node(d); // 마지막 노드를 신규 생성
            // head로 부터 tail 노드를 찾기
            Node n = this;
            while (n.next != null) {
                n = n.next;
            }
            n.next = end; // 신규 생성했던 노드를 tail 노드 뒤로 붙이기
        }

        public void delete(int d) {
            Node n = this;
            while (n.next != null) {
                if (n.next.data == d) { // 값을 확인
                    n.next = n.next.next;
                } else {
                    n = n.next;
                }
            }
        }
    }

    private Node head;

    YoutubeLinkedList() {
        head = new Node();
    }

    // ####### Algorithm
    public Node kThToLast(Node head, int k) {
        Node n = head;
        int total = 1;

        // 전체 노드의 개수 확인
        while (n.next != null) {
            total++;
            n = n.next;
        }

        // 첫 노드 다시 초기화
        n = head;

        // head 부터 탐색
        for (int i = 1; i < total - k + 1; i++) {
            n = n.next; // n = n.next의 특징 상
            System.out.println("데이터 : " + n.data);
        }
        return n;
    }

    static class Reference {
        public int count = 0;
    }

    // 재귀
    public Node KthToLastRecursive(Node n, int k, Reference r) {
        if (n == null)
            return null;

        Node found = KthToLastRecursive(n.next, k, r);
        r.count++;

        if (r.count == k)
            return n;
        return found;
    }

    public Node KthToLastPointer(Node n, int k) {
        Node p1 = n;
        Node p2 = n;

        for (int i = 0; i < k; i++) {
            if (p1 == null) return null;
            p1 = p1.next;
        }

        while (p1 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }

        return p2;
    }

    // 루프 찾기위한 교차점 찾는 메서드
    public Node findIntersection(Node head) {
        Node fast = head;
        Node slow = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
        }
        if (fast == null || fast.next == null) {
            return null;
        }
        return slow;
    }

    // 루프 찾기
    public Node findLoop(Node head) {

        // intersection
        Node fast = findIntersection(head);
        Node slow = head;

        while (fast != slow) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }

    // 정렬되어 있지 않은 Linked List의 중복 값을 제거
    public void removeDup() {
        Node n = head;
        while (n != null && n.next != null) { // 중복 값이 연속적으로 존재하는 경우를 대비한 조건 n != null
            Node r = n;
            while (r.next != null) {
                if (n.data == r.next.data) { // 앞 노드와 뒤 노드를 비교
                    r.next = r.next.next; // 앞 노드의 포인터 값을 뒤 노드 포인터 값으로 override 하여 삭제 처리
                } else {
                    r = r.next; // 탐색
                }
            }
            n = n.next; // while 문의 조건에 따른 다음 노드 탐색
        }
    }

    // 중간 노드 삭제
    public boolean deleteNode(Node n) {
        if (n == null || n.next == null) {
            return false;
        }

        Node next = n.next;
        n.data = next.data;
        n.next = next.next;

        return true;
    }

    // 숫자의 자리수를 역순으로 담은 두 리스트를 자리수별로 합산 하여 반환
    public Node sumListDesc(Node l1, Node l2, int carry) {
        if (l1 == null && l2 == null && carry == 0) return null;

        Node result = new Node();
        int value = carry;

        if (l1 != null) {
            value += l1.data;
        }
        if (l2 != null) {
            value += l2.data;
        }

        result.data = value % 10;

        if (l1 != null || l2 != null) { // 두 노드 중 하나는 null이 아니면 재귀

            Node next = sumListDesc(
                    l1 == null ? null : l1.next,
                    l2 == null ? null : l2.next,
                    value >= 10 ? 1 : 0
            );
            return result.next = next;
        }
        return result;
    }

    class Num {
        int carry = 0; // 연산된 결과가 10이상이 되어 앞의 자리수로 넘기기 위한 필드
        Node result = null; // 결과 값을 저장할 필드
    }

    // 숫자의 자리 수를 순차적으로 담은 두 리스트를 자리수 별로 합산하기

    // 리스트를 받아서 길이를 반환하는 함수
    private int getListLen(Node l) {
        int total = 0;
        while (l != null) {
            total++;
            l = l.next;
        }
        return total;
    }

    // 노드 앞에 새로운 노드를 추가하는 기능
    private Node insertBefore(Node node, int data) {
        Node before = new Node(data);
        if (node != null) {
            before.next = node;
        }
        return before;
    }

    // 0으로 채우는 함수
    public Node LPadList(Node l, int length) {
        Node head = l;
        for (int i = 0; i < length; i++) {
            head = insertBefore(head, 0);
        }
        return head;
    }

    public Node sumListAsc(Node l1, Node l2) {
        // 알고리즘 처리를 위한 전처리 작업
        int len1 = getListLen(l1);
        int len2 = getListLen(l2);

        if (len1 < len2) {
            l1 = LPadList(l1, len2 - len1);
        } else {
            l2 = LPadList(l2, len1 - len2);
        }

        Num num = addLists(l1, l2);
        if (num.carry != 0) {
            num.result = insertBefore(num.result, num.carry);
        }
        return num.result;
    }

    private Num addLists(Node l1, Node l2) {
        if (l1 == null && l2 == null) {
            return new Num();
        }
        Num num = addLists(l1.next, l2.next);
        int value = num.carry + l1.data + l2.data;
        int data = value % 10;
        num.result = insertBefore(num.result, data);
        num.carry = value / 10;
        return num;
    }

    // 값의 크기에 따라 정렬하기(리스트2개 사용, 포인터가 4개)
    public Node partition(Node n, int x) {
        Node s1 = null;
        Node s2 = null;
        Node e1 = null;
        Node e2 = null;

        while (n != null) {
            // tail 노드를 생성
            Node tail = n.next;
            n.next = null;
            if (n.data < x) {
                if (s1 == null) {
                    s1 = n;
                    e1 = s1;
                } else {
                    e1.next = n;
                    e1 = n;
                }

            } else {
                if (s2 == null) {
                    s2 = n;
                    e2 = s2;
                } else {
                    e2.next = n;
                    e2 = n;
                }
            }
            n = tail;
        }
        if (s1 == null) {
            return s2;
        }
        e1.next = s2;
        return s1;
    }

    // 포인터 2개 사용하여 크기에 따라 정렬
    public Node twoPointerPartition(Node n, int x) {
        Node head = n;
        Node tail = n;

        while (n != null) {
            Node next = n.next;
            if (n.data < x) {
                n.next = head;
                head = n;
            } else { // data 가 x보다 크거나 같은 경우 마지막 추가된 노드를 가리킴
                tail.next = n;
                tail = n;
            }
            n = next;
        }
        tail.next = null; // tail 노드의 특성대로 다음 노드의 값은 null 처리
        return head;
    }

    // 회문 Palindrome 찾기 1. 거꾸로 정렬해서 찾기
    public boolean isPalindromeReversedClone(Node head) {
        Node reversed = reverseAndClone(head);
        return isEqual(head, reversed);
    }

    private boolean isEqual(Node head, Node reversed) {
        while (head != null && reversed != null) {
            if (head.data != reversed.data) {
                return false;
            }
            head = head.next;
            reversed = reversed.next;
        }
        return head == null && reversed == null;
    }

    private Node reverseAndClone(Node node) {
        Node header = null;
        while (node != null) {
            Node n = new Node(node.data);
            n.next = header; // 새로 생성한 노드의 포인터 값을 head로 설정
            header = n; // head의 값을 새로 생성한 노드를 바라보게 하여 리스트의 head를 생성한 것처럼 함

            node = node.next; // 다음 노드 탐색으로 역순으로 정렬됨
        }
        return header;
    }

    // 회문 Palindrome 확인하기, 2. runner technique
    public boolean isPalindromeRunner(Node head) {
        Node fast = head;
        Node slow = head;

        Stack<Integer> stack = new Stack<>();

        while (fast != null && fast.next != null) {
            stack.push(slow.data);

            slow = slow.next;
            fast = fast.next.next;
        }

        if (fast != null) {
            slow = slow.next;
        }

        while (slow != null) {
            int i = stack.pop();

            if (slow.data != i) {
                return false;
            }
            slow = slow.next;
        }
        return true;
    }

    class NodeReference {
        public Node node;
        public boolean result;

        public NodeReference(Node node, boolean result) {
            this.node = node;
            this.result = result;
        }
    }

    public boolean isPalindromeRecursive(Node head) {
        int len = getListLen(head); // 리스트의 길이를 계산
        NodeReference nodeRef = isPalindromeSubRecursive(head, len);
        return nodeRef.result;
    }

    // 재귀를 활용한 Palindrome 찾기
    private NodeReference isPalindromeSubRecursive(Node head, int len) {
        if (head == null || len <= 0) {
            return new NodeReference(head, true);
        } else if (len == 1) {
            return new NodeReference(head.next, true);
        }
        NodeReference ref = isPalindromeSubRecursive(head.next, len - 2);

        if (!ref.result || ref.node == null) {
            return ref;
        }

        ref.result = (head.data == ref.node.data);
        ref.node = ref.node.next;
        return ref;
    }
}
