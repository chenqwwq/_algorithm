package top.chenqwwq.leetcode.daily._2022._20220524;

import top.chenqwwq.leetcode.common.TreeNode;

/**
 * @author chenqwwq
 * @date 2022/5/24
 **/
public class Solution {
    public boolean isUnivalTree(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (root.left != null) {
            if (root.left.val != root.val || !isUnivalTree(root.left)) {
                return false;
            }
        }
        return root.right == null || root.right.val == root.val && isUnivalTree(root.right);
    }
}