package kr.seok.tree;

import java.util.HashMap;

/**
 * Given two integer arrays preorder and inorder
 * <p>
 * where preorder is the preorder traversal of a binary tree
 * <p>
 * and inorder is the inorder traversal of the same tree,
 * <p>
 * construct and return the binary tree.
 */
public class Tree_105 {
    // start from first preorder element
    int pre_idx = 0;
    int[] preorder;
    int[] inorder;
    HashMap<Integer, Integer> idx_map = new HashMap<>();

    public TreeNode helper(int in_left, int in_right) {
        // if there is no elements to construct subtrees
        if (in_left == in_right)
            return null;

        // pick up pre_idx element as a root
        int root_val = preorder[pre_idx]; // preOrder로 탐색한 데이터를 하나씩 조회
        TreeNode root = new TreeNode(root_val); // 루트 노드 생성

        // root splits inorder list
        // into left and right subtrees
        int index = idx_map.get(root_val); // inorder 가 저장된
        System.out.println("root_val : " + root_val + " : : index : " + index);

        // recursion
        pre_idx++;
        // build left subtree
        root.left = helper(in_left, index);
        // build right subtree
        root.right = helper(index + 1, in_right);

        return root;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        this.inorder = inorder;

        // build a hashmap value -> its index
        int idx = 0;
        for (Integer val : inorder)
            idx_map.put(val, idx++);
        return helper(0, inorder.length);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        @Override
        public String toString() {
            return "TreeNode{" +
                    "val=" + val +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }
}
