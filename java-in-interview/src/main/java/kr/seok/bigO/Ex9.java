package kr.seok.bigO;

public class Ex9 {

    /*
        균형 이진 탐색 트리에서 모든 노드의 값을 더하는 코드
     */
    int sum (Node node) {
        if(node == null) {
            return 0;
        }
        return sum(node.left) + node.value + sum(node.right);
    }

    class Node {
        private Node left;
        private Node right;
        private int value;
    }
}
