package top.chenqwwq.leetcode.contest.hhrc2022._4;

import top.chenqwwq.leetcode.common.TreeNode;

/**
 * @author chenqwwq
 * @date 2022/10/5
 **/
public class Solution {
    public int minSupplyStationNumber(TreeNode root) {
        // 每个节点都有设置和不设置的情况
        if (root == null) return 0;
        return Math.min(dfs(root, false), dfs(root, true));
    }

    public int dfs(TreeNode node, boolean status) {
        if (node == null) return 0;
        if(node.right == null && node.left == null) return status ? 1 : 0;
        return -1;
    }
}