package top.chenqwwq.leetcode.contest.weekly._190._3;

import top.chenqwwq.leetcode.common.TreeNode;

/**
 * 5418. 二叉树中的伪回文路径
 * 题目难度Medium
 * 给你一棵二叉树，每个节点的值为 1 到 9 。我们称二叉树中的一条路径是 「伪回文」的，当它满足：路径经过的所有节点值的排列中，存在一个回文序列。
 * <p>
 * 请你返回从根到叶子节点的所有路径中 伪回文 路径的数目。
 *
 * @author chen
 * @date 2020/5/24 上午10:49
 */
public class Solution {

    private int res = 0;


    public int pseudoPalindromicPaths(TreeNode root) {
        dfs(root, new int[10]);
        return res;
    }

    public void dfs(TreeNode root, int[] hash) {
        if (root == null) {
            return;
        }
        hash[root.val]++;
        // 到叶子节点了开始判断
        if (root.left == null && root.right == null && check(hash)) {
            res++;
            hash[root.val]--;
            return;
        }

        dfs(root.left, hash);
        dfs(root.right, hash);
        hash[root.val]--;
    }


    private boolean check(int[] hash) {
        int num = 0;
        for (int i : hash) {
            if ((i & 1) == 1 && ++num > 1) {
                return false;
            }
        }
        return true;
    }
}
