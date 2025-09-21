package top.chenqwwq.leetcode.contest.weekly._311._3;

import top.chenqwwq.leetcode.common.TreeNode;

import java.util.*;

/**
 * [0,2,1,0,0,0,0,2,2,2,2,1,1,1,1]
 * [0,2,1,0,0,0,0,2,2,2,2,1,1,1,1]
 * [2,5,3,8,13,21,34]
 * [2,5,3,8,13,21,34]
 * @author chenqwwq
 * @date 2022/9/18
 **/
public class Solution {
    Map<Integer, Deque<TreeNode>> map = new HashMap<>();

    // 收集每个偶数层
    private void dfs(TreeNode node, int depth) {
        if (node == null) return;
        if ((depth & 1) == 0) {
            if (!map.containsKey(depth)) map.put(depth, new LinkedList<>());
            map.get(depth).add(node);
        }
        dfs(node.left, depth + 1);
        dfs(node.right, depth + 1);
    }

    private void reverse(TreeNode node, int depth) {
        if (node == null) return;
        if ((depth & 1) == 1) {
            if(map.containsKey(depth+1)) {
                TreeNode left = node.left;
                TreeNode right = node.right;
                node.left = new TreeNode(map.get(depth + 1).pollLast().val, left.left, left.right);
                node.right = new TreeNode(map.get(depth + 1).pollLast().val, right.left, right.right);
            }
        }
        reverse(node.left, depth + 1);
        reverse(node.right, depth + 1);
    }

    public TreeNode reverseOddLevels(TreeNode root) {
        dfs(root, 1);
        reverse(root,1);
        return root;
    }
}