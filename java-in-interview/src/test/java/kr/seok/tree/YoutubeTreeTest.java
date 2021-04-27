package kr.seok.tree;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class YoutubeTreeTest {

    @Test
    void testCase1() {
        YoutubeTree tree = new YoutubeTree();
        YoutubeTree.Node node7 = new YoutubeTree.Node(7, null, null);
        YoutubeTree.Node node6 = new YoutubeTree.Node(6, null, null);
        YoutubeTree.Node node5 = new YoutubeTree.Node(5, null, null);
        YoutubeTree.Node node4 = new YoutubeTree.Node(4, null, null);
        YoutubeTree.Node node3 = new YoutubeTree.Node(3, node6, node7);
        YoutubeTree.Node node2 = new YoutubeTree.Node(2, node4, node5);
        YoutubeTree.Node root = new YoutubeTree.Node(1, node2, node3);

        tree.setRoot(root);

        assertThat(tree.getRoot().data).isEqualTo(1);

        tree.preOrder(root);
        System.out.println("pre-order 전위 순회");
        tree.inOrder(root);
        System.out.println("in-order 중위 순회");
        tree.postOrder(root);
        System.out.println("post-order 중위 순회");

    }
}
