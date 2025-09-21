package top.chenqwwq.leetcode.daily._2024._20240225;

import top.chenqwwq.leetcode.common.TreeNode;

/**
 * @author chenqwwq
 * @date 2024/2/25
 **/
public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;
        if(root.val == p.val || root.val == q.val) return root;
        final TreeNode ll = lowestCommonAncestor(root.left, q, p);
        final TreeNode rr = lowestCommonAncestor(root.right, q, p);
        if(ll != null && rr != null) return root;
        else if(ll != null) return ll;
        else if(rr != null) return rr;
        return null;
    }
}