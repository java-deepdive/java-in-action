package kr.seok.graph;

import java.util.LinkedList;

/**
 * 4.1 노드 사이의 경로<br>
 * <p>
 * - 방향 그래프가 주어졌을 때 두 노드 사이에 경로가 존재하는 지 확인
 */
public class Graph_1 {

    enum State {
        Unvisited,
        Visited,
        Visiting
    }

    class Graph {
        public Node[] nodes;

        public Node[] getNodes() {
            return nodes;
        }
    }

    class Node {
        public Node[] children;
        public String name;
        public State state;

        public Node[] getAdjacent() {
            return children;
        }
    }

    boolean search(Graph g, Node start, Node end) {

        if (start == end) { // 두 노드가 같다는 건 접점을 찾으므로 true를 반환
            return true;
        }

        // Queue처럼 사용
        LinkedList<Node> q = new LinkedList<>();

        initMarks(g);

        start.state = State.Visiting; // 방문 체크

        q.add(start); // 시작점 부터 넣기

        Node u;

        while (!q.isEmpty()) { // 첫 노드 넣었으므로 비어있지 않으면 반복
            u = q.removeFirst(); // 시작 점 제거를 왜하지 ???

            if (u != null) { // 노드가 Queue에 있으면 탐색

                if (searchAdjacent(end, q, u)) return true;

                u.state = State.Visited; // 방문한 상태 입력
            }
        }
        return false;
    }

    private void initMarks(Graph g) {
        for (Node u : g.getNodes()) { // 각 노드의 방문 상태를 초기화
            u.state = State.Unvisited;
        }
    }

    private boolean searchAdjacent(Node end, LinkedList<Node> q, Node u) {
        for (Node v : u.getAdjacent()) { // 인접한 노드 탐색

            if (v.state == State.Unvisited) { // 만약 노드의 상태 코드가 방문 했었다면 ?

                if (v == end) { // 방문 했었는데 end 노드 와 같다면? -> 전체 방문 완료
                    return true;

                } else { // 방문은 했지만 end 노드와 같지 않다면 방문 중 상태로 수정
                    v.state = State.Visiting;
                    q.add(v); // 방문 중인 노드를 Queue에 입력
                }

            } // end if

        } // end for
        return false;
    }
}
