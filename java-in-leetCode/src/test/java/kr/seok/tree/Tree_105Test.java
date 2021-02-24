package kr.seok.tree;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class Tree_105Test {

    @Test
    @DisplayName("이진트리 만들기 테스트")
    void testCase1() {
        Tree_105 tree = new Tree_105();
        Tree_105.TreeNode treeNode = tree.buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7});

        System.out.println(treeNode);
    }
}
