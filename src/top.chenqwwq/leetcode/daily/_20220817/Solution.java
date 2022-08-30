package top.chenqwwq.leetcode.daily._20220817;

import top.chenqwwq.leetcode.common.TreeNode;

/**
 * @author chenqwwq
 * @date 2022/8/17
 **/
public class Solution {
    int deep = -1, sum = 0;

    public int deepestLeavesSum(TreeNode root) {
        dfs(root,0);
        return sum;
    }

    public void dfs(TreeNode node, int level) {
        if (node == null) {
            return;
        }
        if (node.left == null && node.right == null) {
            if (level > deep) {
                deep = level;
                sum = node.val;
            } else if (level == deep) {
                sum += node.val;
            }
            return;
        }
        dfs(node.left, level + 1);
        dfs(node.right, level + 1);
    }
}