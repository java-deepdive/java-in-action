package kr.seok.tree;

/**
 * https://youtu.be/oSWTXtMglKE
 *  - Data Structures: Trees
 *
 */
public class Trees {

    class Node {
        Node left, right;
        int data;
        public Node(int data) {
            this.data = data;
        }

        public void insert(int value) {
            if(value <= data) { // left
                if(left == null) {
                    left = new Node(value);
                } else {
                    left.insert(value);
                }
            } else { // right
                if(right == null) {
                    right = new Node(value);
                } else {
                    right.insert(value);
                }
            }
        }

        public boolean contains(int value) {
            if(value == data) {
                return true;
            } else if(value < data) {
                if(left == null) {
                    return false;
                } else {
                    return left.contains(value);
                }
            } else {
                if(right == null) {
                    return false;
                } else {
                    return right.contains(value);
                }
            }
        }

        public void printInOrder() {
            if (left != null) {
                left.printInOrder();
            }
            System.out.println(data);
            if (right != null) {
                right.printInOrder();
            }
        }

        public void printPreOrder() {
            System.out.println(data);
            if (left != null) {
                left.printPreOrder();
            }
            if (right != null) {
                right.printPreOrder();
            }
        }

        public void printPostOrder() {
            if (left != null) {
                left.printPostOrder();
            }
            if (right != null) {
                right.printPostOrder();
            }
            System.out.println(data);
        }
    }
}
