package kr.seok.tree;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class Tree_543Test {
    Tree_543 tree;

    @BeforeEach
    void setUp() {
        tree = new Tree_543();
    }

    @Test
    @DisplayName("depth 테스트")
    void testCase1() {

        Tree_543.TreeNode node5 = new Tree_543.TreeNode(5, null, null);
        Tree_543.TreeNode node4 = new Tree_543.TreeNode(4, null, null);
        Tree_543.TreeNode node3 = new Tree_543.TreeNode(3, null, null);
        Tree_543.TreeNode node2 = new Tree_543.TreeNode(2, node4, node5);
        Tree_543.TreeNode root = new Tree_543.TreeNode(1, node2, node3);
        int i = tree.diameterOfBinaryTree(root);
        assertThat(i).isEqualTo(3);
    }
}
