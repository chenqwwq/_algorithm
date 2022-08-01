package top.chenqwwq.leetcode.daily._20220721;

import top.chenqwwq.leetcode.common.TreeNode;

/**
 * @author chenqwwq
 * @date 2022/7/21
 **/
public class Solution {
    public TreeNode pruneTree(TreeNode root) {
        if(root == null){
            return null;
        }
        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);
        if(root.left == null && root.right == null && root.val == 0){
            return null;
        }
        return root;
    }
}