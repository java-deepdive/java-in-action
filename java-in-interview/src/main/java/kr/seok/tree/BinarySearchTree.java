package kr.seok.tree;

class Node {
    public int value;
    public Node left, right;

    public Node(int value, Node left, Node right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }
}

public class BinarySearchTree {
    public static boolean contains(Node root, int value) {

        if(value == root.value) {
            return true;
        } else if(value < root.value) {
            if(root.left == null) {
                return false;
            } else {
                return contains(root.left, value);
            }
        } else {
            if(root.right == null) {
                return false;
            } else {
                return contains(root.right, value);
            }
        }
    }

    public static void main(String[] args) {
        Node n1 = new Node(1, null, null);
        Node n3 = new Node(3, null, null);
        Node n2 = new Node(2, n1, n3);

        System.out.println(contains(n2, 3));
    }
}
