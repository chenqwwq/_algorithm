package top.chenqwwq.leetcode.contest.biweek._102._3;

import top.chenqwwq.leetcode.common.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chenqwwq
 * @date 2023/4/16
 **/

public class Solution {
    Map<Integer, Integer> map = new HashMap<>();

    public TreeNode replaceValueInTree(TreeNode root) {
        dfs(root,0);
        return handle(root,root.val,0);
    }

    public TreeNode handle(TreeNode root, int sum,int level) {
        if(root == null) return null;
        root.val = map.get(level) - sum;
        final int nextSum = (root.left != null ? root.left.val : 0) + (root.right != null ? root.right.val : 0);
        handle(root.left, nextSum,level+1);
        handle(root.right,nextSum,level+1);
        return root;
    }


    public void dfs(TreeNode root, int level) {
        if (root == null) return;
        map.put(level, map.getOrDefault(level, 0) + root.val);
        dfs(root.left, level + 1);
        dfs(root.right, level + 1);
    }
}