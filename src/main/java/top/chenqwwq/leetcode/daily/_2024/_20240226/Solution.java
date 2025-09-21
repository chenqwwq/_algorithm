package top.chenqwwq.leetcode.daily._2024._20240226;

import top.chenqwwq.leetcode.common.TreeNode;

/**
 * @author chenqwwq
 * @date 2024/2/26
 **/
public class Solution {
    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) return 0;
        if (root.val >= low && root.val <= high) return root.val  +  rangeSumBST(root.left, low, high) +  rangeSumBST(root.right, low, high);
        else if (root.val > high) return rangeSumBST(root.left, low, high);
        else return rangeSumBST(root.right, low, high);
    }
}