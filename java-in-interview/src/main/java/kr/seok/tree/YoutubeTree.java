package kr.seok.tree;

public class YoutubeTree {

    public Node root;

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    public Node makeNode(Node left, int data, Node right) {

        Node node = new Node();
        node.data = data;
        node.left = left;
        node.right = right;

        return node;
    }

    // left -> current -> right
    public void inOrder(Node node) { // 중위 순회
        if (node != null) {
            inOrder(node.left);
            System.out.print(node.data + " -> ");
            inOrder(node.right);
        }
    }

    // current -> left -> right
    public void preOrder(Node node) { // 전위 순회
        if (node != null) {
            System.out.print(node.data + " -> ");
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    // left -> right -> current
    public void postOrder(Node node) { // 후위 순회
        if (node != null) {
            postOrder(node.left);
            postOrder(node.right);
            System.out.print(node.data + " -> ");
        }
    }

    // Binary Heap (min, max)
    // 힙이란?
    static class Node {
        int data;
        Node left;
        Node right;

        public Node() {
        }

        public Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

}
