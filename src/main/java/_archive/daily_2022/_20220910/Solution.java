package top.chenqwwq.leetcode.daily._2022._20220910;

import top.chenqwwq.leetcode.common.TreeNode;

/**
 * @author chenqwwq
 * @date 2022/9/10
 **/
public class Solution {
    int l, r;

    public TreeNode trimBST(TreeNode root, int low, int high) {
        this.l = low;
        this.r = high;
        return dfs(root);
    }

    public TreeNode dfs(TreeNode node) {
        if (node == null) {
            return null;
        }
        node.left = dfs(node.left);
        node.right = dfs(node.right);
        return node.val < l || node.val > r ? (node.left == null ? node.right : node.left) : node;
    }
}