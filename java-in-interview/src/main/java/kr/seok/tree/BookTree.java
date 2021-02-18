package kr.seok.tree;

import java.util.Comparator;

public class BookTree<K, V>  {
    static class Node<K, V> {
        private K key;
        private V data;

        private Node<K, V> left;
        private Node<K, V> right;

        public Node(K key, V data, Node<K, V> left, Node<K, V> right) {
            this.key = key;
            this.data = data;
            this.left = left;
            this.right = right;
        }

        public K getKey() {
            return key;
        }

        public V getData() {
            return data;
        }
    }

    private Node<K, V> root;
    private Comparator<? super K> comparator = null;

    public BookTree() {
        this.root = null;
    }

    public BookTree(Comparator<? super K> comparator) {
        this();
        this.comparator = comparator;
    }

    private int comp(K key1, K key2) {
        return comparator == null ? ((Comparable<K>)key1).compareTo(key2) : comparator.compare(key1, key2);
    }

    // 트리 탐색 메서드
    public V search(K key) {
        Node<K, V> ptr = root;

        while (true) {
            if(ptr == null) return null;

            int cond = comp(key, ptr.getKey());

            if(cond == 0) {
                return ptr.getData();
            } else if(cond < 0) {
                ptr = ptr.left;
            } else {
                ptr = ptr.right;
            }
        }
    }

    // 노드 추가 하는 메서드
    public void add(K key, V data) {
        if(root == null) {
            root = new Node<>(key, data, null, null);
        } else {
            addNode(root, key, data);
        }
    }

    // 이진 탐색 트리의 특성에 따라 Node 추가
    private void addNode(Node<K, V> node, K key, V data) {
        int cond = comp(key, node.getKey()); // 키 비교
        if (cond == 0) return;
        else if (cond < 0){
            if(node.left == null) {
                node.left = new Node<>(key, data, null, null);
            } else {
                addNode(node.left, key, data);
            }
        } else {
            if(node.right == null) {
                node.right = new Node<>(key, data, null, null);
            } else {
                addNode(node.right, key, data);
            }
        }
    }

    public boolean remove(K key) {
        Node<K, V> ptr = root;
        Node<K, V> parent = null;
        boolean isLeftChild = true;

        while (true) {
            if(ptr == null) return false; // 더이상 노드가 존재하지 않음
            int cond = comp(key, ptr.getKey()); // key와 탐색 노드의 키를 비교

            if(cond == 0) {
                break; // 검색에 성공

            } else {
                parent = ptr; // 아래 단계로 내려가기 전 parent 설정

                if(cond < 0) { // 비교 값이 -1인 경우 left 로 내려감
                    isLeftChild = true;
                    ptr = ptr.left;
                } else { // 비교 값이 1인경우 right 로 내려감
                    isLeftChild = false;
                    ptr = ptr.right;
                }
            }
        }

        if(ptr.left == null) { // 탐색 포인터의 왼쪽 자식이 없는 경우
            if(ptr == root) {
                root = ptr.right;
            } else if(isLeftChild) {
                parent.left = ptr.right; // 부모의 왼쪽 포인터가 오른쪽 자식을 가리킴
            } else {
                parent.right = ptr.right; // 부모의 오른쪽 포인터가 오른쪽 자식을 가리킴
            }
        } else if(ptr.right == null){ // 포인터에는 오른쪽 자식이 없는 경우
            if(ptr == root) {
                root = ptr.left;
            } else if(ptr.right == null) {
                parent.left = ptr.left;
            } else {
                parent.right = ptr.left;
            }
        } else {
            parent = ptr;
            Node<K, V> left = ptr.left;
            isLeftChild = true;

            while (left.right != null) {
                parent = left;
                left = left.right;
                isLeftChild = false;
            }
            ptr.key = left.key;
            ptr.data = left.data;

            if(isLeftChild) {
                parent.left = left.left;
            } else {
                parent.right = left.left;
            }
        }
        return true;
    }

    private void printSubTree(Node<K, V> node) {
        if(node != null) {
            printSubTree(node.left);
            System.out.println(node.key + " : : " + node.data);
            printSubTree(node.right);
        }
    }

    public void print() {
        printSubTree(root);
    }
}
