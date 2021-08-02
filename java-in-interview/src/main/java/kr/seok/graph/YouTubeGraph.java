package kr.seok.graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class YouTubeGraph {

    static class Graph { // 그래프

        Node[] nodes;

        public Graph(int size) { // 초기화
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

        void dfs() {
            dfs(0);
        }

        protected void dfs(int index) {
            Node root = nodes[index];
            Stack<Node> stack = new Stack<>();

            root.marked = true; // 루트 값에 마킹
            stack.push(root); // 루트 넣고 시작

            while (!stack.isEmpty()) { // 스택에 노드가 없을 때까지 반복
                Node r = stack.pop(); //

                for (Node n : r.adjacent) { // 0과 인접한 노드 탐색
                    if (!n.marked) { // false
                        n.marked = true;
                        stack.push(n);
                    }
                }
                visit(r); // 출력
            }
        }

        void bfs() {
            bfs(0);
        }

        protected void bfs(int index) {
            Node root = nodes[index];
            Queue<Node> queue = new LinkedList<>();

            root.marked = true;
            queue.offer(root);

            while (!queue.isEmpty()) { // 큐에 데이터가 없을 때까지 반복
                Node r = queue.poll(); // 1. 꺼낸다

                for (Node n : r.adjacent) { // 2. 인접한 노드를 탐색 및 추가
                    if (!n.marked) { // 추가되지 않은 노드들을 추가
                        n.marked = true;
                        queue.offer(n);
                    }
                }
                visit(r); // 3. 꺼낸 노드를 출력
            }
        }

        void dfsR(Node r) { // LinkedList 의 주소 값을 가지고 있기 때문에 파라미터로 Node를 전달하는 방식을 사용
            if (r == null) return;

            r.marked = true;
            visit(r);

            for (Node n : r.adjacent) { // 인접 노드
                if (!n.marked) { // 마킹 false
                    dfsR(n);
                }
            }

        }

        void dfsR() {
            dfsR(0);
        }

        void dfsR(int index) { // 특정 노드를 시작으로 재귀 탐색
            Node r = nodes[index];
            dfsR(r);
        }

        private void visit(Node node) {
            System.out.print(node.data + " ");
        }

        static class Node { // 그래프 안에 노드
            private final int data;
            private final LinkedList<Node> adjacent;
            private boolean marked;

            public Node(int data) {
                this.data = data;
                this.marked = false;
                adjacent = new LinkedList<>();
            }
        }
    }
}
