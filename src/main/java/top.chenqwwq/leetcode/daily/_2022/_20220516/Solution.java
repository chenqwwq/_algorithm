package top.chenqwwq.leetcode.daily._2022._20220516;

import top.chenqwwq.leetcode.common.TreeNode;

/**
 * @author chenqwwq
 * @date 2022/5/16
 **/
public class Solution {
    TreeNode ans;
    boolean flag;

    private void dfs(TreeNode node, TreeNode p) {
        if (node == null) {
            return;
        }
        dfs(node.left, p);
        if (flag && ans == null) {
            ans = node;
            return;
        }
        if (node == p) {
            flag = true;
        }
        dfs(node.right, p);
    }

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        dfs(root,p);
        return ans;
    }
}