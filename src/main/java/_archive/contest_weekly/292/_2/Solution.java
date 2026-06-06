package top.chenqwwq.leetcode.contest.weekly._292._2;

import top.chenqwwq.leetcode.common.TreeNode;

/**
 * @author chenqwwq
 * @date 2022/5/8
 **/
public class Solution {
    int ans = 0;

    public int[] dfs(TreeNode node) {
        if (node == null) {
            return new int[]{0, 0};
        }
        int[] s1 = dfs(node.left);
        int[] s2 = dfs(node.right);
        if ((s1[0] + s2[0] + node.val) / (s1[1] + s2[1]+1) == node.val) {
            ans++;
        }
        return new int[]{s1[0] + s2[0] + node.val, s1[1] + s2[1] + 1};
    }

    public int averageOfSubtree(TreeNode root) {
        dfs(root);
        return ans;
    }
}
