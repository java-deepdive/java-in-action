package kr.seok.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Invert a binary tree.
 *
 *  - 재귀를 통한 방법
 *  - BFS를 통해 swap
 */
public class Tree_226 {

    public class TreeNode {
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

    public TreeNode invertTreeRecursive(TreeNode root) {
        if (root == null) return null;
        TreeNode right = invertTreeRecursive(root.right);
        TreeNode left = invertTreeRecursive(root.left);

        root.left = right;
        root.right = left;

        return root;
    }

    public TreeNode invertTreeIterative(TreeNode root) {
        if (root == null) return null;

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);

        while (!queue.isEmpty()) {
            // 시작은 root를 poll
            TreeNode current = queue.poll();

            // swap
            TreeNode temp = current.left;
            current.left = current.right;
            current.right = temp;

            if (current.left != null) queue.add(current.left);
            if (current.right != null) queue.add(current.right);
        }
        return root;
    }
}
