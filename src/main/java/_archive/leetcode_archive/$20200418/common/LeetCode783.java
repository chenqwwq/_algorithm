package top.chenqwwq.leetcode.archive.$20200418.common;

/**
 * @author chen
 * @description
 * @email ai654778@vip.qq.com
 * @date 190-23
 */
public class LeetCode783 {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    static class Solution {
        Integer res;
        Integer prev;

        public int minDiffInBST(TreeNode root) {
            res = Integer.MAX_VALUE;
            prev = null;
            handle(root);
            return res;
        }

        public void handle(TreeNode root) {
            if (root == null) {
                return;
            }
            handle(root.left);
            if (prev != null) {
                res = Math.min(res, root.val - prev);
            }
            prev = root.val;
            handle(root.right);
        }
    }
}
