package top.chenqwwq.leetcode.daily._2022._20220805;

import top.chenqwwq.leetcode.common.TreeNode;

/**
 * @author 沽酒
 * @since 2022/08/05
 */
public class Solution {
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        return dfs(root, 1, val, depth, false);
    }

    public TreeNode dfs(TreeNode node, int curr, int val, int depth, boolean right) {
        if (curr < depth) {
            if (node != null) {
                node.left = dfs(node.left, curr + 1, val, depth, false);
                node.right = dfs(node.right, curr + 1, val, depth, true);
            }
            return node;
        }
        final TreeNode ret = new TreeNode(val);
        if (right) ret.right = node;
        else ret.left = node;
        return ret;
    }
}