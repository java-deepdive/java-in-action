package kr.seok.graph;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class YouTubeGraphTest {
    private YouTubeGraph.Graph g;

    /**
     *    0
     *   |
     *  1 -- 3      7
     *  |  / | ⧵  ⧸
     *  | /  |  5
     *  2 -- 4   ⧵
     *             6 - 8
     */
    @BeforeEach
    void setUp() {
        g = new YouTubeGraph.Graph(9);
        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(1, 3);
        g.addEdge(2, 4);
        g.addEdge(2, 3);
        g.addEdge(3, 4);
        g.addEdge(3, 5);
        g.addEdge(5, 6);
        g.addEdge(5, 7);
        g.addEdge(6, 8);
    }

    @DisplayName("그래프 dfs 탐색 결과 확인 (0 1 3 5 7 6 8 4 2)")
    @Test
    void testCase1() {
        /**
         *
         */
        g.dfs();
        System.out.println();
    }

    @DisplayName("그래프 bfs 탐색 결과 확인 (0 1 2 3 4 5 6 7 8)")
    @Test
    void testCase2() {
        g.bfs();
        System.out.println();
    }

    @DisplayName("그래프 dfs recursion 탐색 결과(0 1 2 4 3 5 6 8 7)")
    @Test
    void testCase3() {
        g.dfsR();
        System.out.println();
    }

    @DisplayName("그래프 dfs 3번부터 탐색 결과(3 5 7 6 8 4 2 1 0)")
    @Test
    void testCase4() {
        g.dfs(3);
        System.out.println();
    }

    @DisplayName("그래프 bfs 3번부터 탐색 결과(3 1 2 4 5 0 6 7 8)")
    @Test
    void testCase5() {
        g.bfs(3);
        System.out.println();
    }

    @DisplayName("그래프 dfs recursion 3번부터 탐색 결과(3 1 0 2 4 5 6 8 7)")
    @Test
    void testCase6() {
        g.dfsR(3);
        System.out.println();
    }
}
