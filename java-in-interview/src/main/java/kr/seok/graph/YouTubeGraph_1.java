package kr.seok.graph;

import java.util.LinkedList;

public class YouTubeGraph_1 {

    static class Graph {
        static class Node {
            private final int data;
            private final LinkedList<Node> adjacent;
            private boolean marked;

            public Node(int data) {
                this.data = data;
                this.marked = false;
                adjacent = new LinkedList<>();
            }
        }

        Node[] nodes;

        public Graph(int size) {
            this.nodes = new Node[size];
            for (int i = 0; i < size; i++) {
                nodes[i] = new Node(i);
            }
        }

        void addEdge(int node1, int node2) {
            Node n1 = nodes[node1];
            Node n2 = nodes[node2];

            if (!n1.adjacent.contains(n2)) {
                n1.adjacent.add(n2);
            }
            if (!n2.adjacent.contains(n2)) {
                n2.adjacent.add(n1);
            }
        }

        void initMarks() {
            for (Node n : nodes) {
                n.marked = false;
            }
        }

        boolean search(int i1, int i2) {
            return search(nodes[i1], nodes[i2]);
        }

        private boolean search(Node start, Node end) {

            initMarks(); // 초기화

            // Queue처럼 사용
            LinkedList<Node> q = new LinkedList<>();
            q.add(start);

            while (!q.isEmpty()) {
                Node root = q.removeFirst();

                if(root == end) {
                    return true;
                }

                for (Node n : root.adjacent) {
                    if(!n.marked) {
                        n.marked = true;
                        q.add(n);
                    }
                }
            }
            return false;
        }
    }
}
