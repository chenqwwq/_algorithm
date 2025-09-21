package top.chenqwwq.leetcode.daily._2025._20250404;


import top.chenqwwq.leetcode.common.TreeNode;

/**
 * @author chenqwwq
 * @date 2025/4/4
 **/
public class Solution {

    TreeNode ans = null;
    int cur = 0;

    public TreeNode lcaDeepestLeaves(TreeNode root) {
        dfs(root, 0);
        return ans;
    }

    public int dfs(TreeNode node, int dep) {
        if (node == null) return dep - 1;
        if (node.left == null && node.right == null) {
            if (dep > cur) {
                ans = node;
                cur = dep;
            }
            return dep;
        }
        final int l = dfs(node.left, dep + 1), r = dfs(node.right, dep + 1);
        if (l == r && cur <= l) {
            ans = node;
            cur = l;
            return l;
        }

        return Math.max(l, r);
    }
}