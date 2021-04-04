package kr.seok.graph;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class YouTubeGraph_1Test {

    YouTubeGraph_1.Graph g;

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
        g = new YouTubeGraph_1.Graph(9);
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

    @DisplayName("그래프 경로 확인")
    @Test
    void testCase1() {
        boolean actual = g.search(1, 8);// 1 -> 8 로 찾아가는 경로가 존재하는 지 확인
        assertThat(actual).isTrue();
    }
}
