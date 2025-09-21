package top.chenqwwq.leetcode.archive.$20200418.common;

import java.util.ArrayList;
import java.util.List;

/**
 * 872. Leaf-Similar Trees
 *
 * @author chen
 * @date 19-6-12
 */
public class LeetCode872 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class Solution {


        public boolean leafSimilar(TreeNode root1, TreeNode root2) {
            List<Integer> root1Leaf = new ArrayList<>();
            List<Integer> root2Leaf = new ArrayList<>();

            dfs(root1, root1Leaf);
            dfs(root2, root2Leaf);
            if (root1Leaf.size() != root2Leaf.size()) {
                return false;
            }
            for (int i = 0; i < root1Leaf.size(); i++) {
                if (!root1Leaf.get(i).equals(root2Leaf.get(i))) {
                    return false;
                }
            }

            return true;
        }

        public void dfs(TreeNode root, List<Integer> res) {
            if (root == null) {
                return;
            }

            if (root.left == null && root.right == null) {
                res.add(root.val);
            } else {
                dfs(root.left, res);
                dfs(root.right, res);
            }
        }
    }
}
