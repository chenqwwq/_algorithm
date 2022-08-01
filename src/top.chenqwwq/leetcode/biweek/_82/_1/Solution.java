package top.chenqwwq.leetcode.biweek._82._1;

import top.chenqwwq.leetcode.common.TreeNode;

/**
 * @author chenqwwq
 * @date 2022/7/10
 **/
public class Solution {
    public boolean evaluateTree(TreeNode root) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return root.val == 1;
        }
        boolean l = evaluateTree(root.left), r = evaluateTree(root.right);
        return root.val == 3 ? (l && r) : (l || r);
    }
}