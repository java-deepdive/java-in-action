package kr.seok.tree;

/**
 * Given a binary tree, you need to compute the length of the diameter of the tree.
 *
 * The diameter of a binary tree is the length of the longest path between any two nodes in a tree.
 *
 * This path may or may not pass through the root.
 */
public class Tree_543 {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() { }
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    // Depth-First Search
    /*
        모든 경로는 일부 노드에서 두 개의 화살표로 작성될 수 있다.
        화살표란 일부 노드에서 시작하여 하위 노드로만 내려가는 경로이다.

        L, R 각 자식의 최대 길이 화살표를 알고 있다면, 최상 경로는 L + R + 1 노드에 닿는다.

        두 노드 간의 가장 긴 길이를 반환

        left로 탐색하면서 depth를 계산, right로 탐색하면서 depth를 계산하여 합산하면 왼쪽 노드 끝에서 오른쪽 끝 노드의 최대 거리

     */
    int ans;

    public int diameterOfBinaryTree(TreeNode root) {
        ans = 1;

        depth(root);

        return ans - 1;
    }

    public int depth(TreeNode node) {
        if (node == null) return 0;

        int L = depth(node.left);
        System.out.println("L :: " + L);
        int R = depth(node.right);
        System.out.println("R :: " + R);

        ans = Math.max(ans, L + R + 1);
        System.out.println("ans :: " + ans);

        return Math.max(L, R) + 1;
    }
}
