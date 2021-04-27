package kr.seok.bst;

public class Bst_530 {
    // 이진검색트리의 성질을 이용 inorder -> 오름차순 정렬
    boolean flag;
    int min;
    int prev;

    public int getMinimumDifference(TreeNode root) {
        flag = false;
        min = Integer.MAX_VALUE;
        inorder(root);
        return min;
    }

    /**
     * 이진 트리의 탐색 방법 중 inorder 를 활용한 방법
     */
    public void inorder(TreeNode root) {
        if (root == null) return;
        // left 먼저 처리
        inorder(root.left);

        // self 처리
        if (!flag) {
            flag = true;
        } else {
            // 차이 값을 계산
            min = Math.min(
                    // 최소 값
                    min,
                    // 현재 값 - 이전값 = 현재 값과 이전값의 거리
                    root.val - prev);
        }
        prev = root.val;

        // right 처리
        inorder(root.right);
    }

    class TreeNode {
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
    }
}
