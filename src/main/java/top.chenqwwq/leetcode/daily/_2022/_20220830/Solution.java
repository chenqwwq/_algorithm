package top.chenqwwq.leetcode.daily._2022._20220830;

import top.chenqwwq.leetcode.common.TreeNode;

/**
 * @author 沽酒
 * @since 2022/08/30
 */
public class Solution {
    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
        if(root == null){
            return new TreeNode(val);
        }
        if(val > root.val){
            final TreeNode node = new TreeNode(val);
            node.left = root;
            return node;
        }
        root.right = insertIntoMaxTree(root,val);
        return root;
    }
}