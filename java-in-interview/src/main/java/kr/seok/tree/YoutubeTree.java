package kr.seok.tree;

public class YoutubeTree {

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

    public Node root;

    public void setRoot(Node root) {
        this.root = root;
    }

    public Node getRoot() {
        return root;
    }

    public Node makeNode(Node left, int data, Node right) {

        Node node = new Node();
        node.data = data;
        node.left = left;
        node.right = right;

        return node;
    }

    // left -> current -> right
    public void inOrder(Node node) {
        if (node != null) {
            inOrder(node.left);
            System.out.print(node.data + " -> ");
            inOrder(node.right);
        }
    }

    // current -> left -> right
    public void preOrder(Node node) {
        if (node != null) {
            System.out.print(node.data + " -> ");
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    // left -> right -> current
    public void postOrder(Node node) {
        if (node != null) {
            postOrder(node.left);
            postOrder(node.right);
            System.out.print(node.data + " -> ");
        }
    }

}
