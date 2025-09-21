package top.chenqwwq.leetcode.daily._2023._20230521;

import top.chenqwwq.leetcode.common.TreeNode;

/**
 * @author chenqwwq
 * @date 2023/5/22
 **/
public class Solution {
    public TreeNode sufficientSubset(TreeNode root, int limit) {
        if (root == null) return null;
        if (root.left == null && root.right == null) return limit - root.val > 0 ? null : root;
        root.left = sufficientSubset(root.left, limit - root.val);
        root.right = sufficientSubset(root.right, limit - root.val);
        return root.left == null && root.right == null ? null : root;
    }
}