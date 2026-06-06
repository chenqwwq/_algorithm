package top.chenqwwq.leetcode.archive.$20200418.by_topics.tree;

/**
 * 965. Univalued Binary Tree
 * Easy
 * A binary tree is univalued if every node in the tree has the same value.
 * <p>
 * Return true if and only if the given tree is univalued.
 * Note:
 * <p>
 * The number of nodes in the given tree will be in the range [1, 100].
 * Each node's value will be an integer in the range [0, 99].
 *
 * @author bingxin.chen
 * @date 2019/9/26 12:41
 */
public class $965_UnivaluedBinaryTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class Solution {
        Integer val = null;

        public boolean isUnivalTree(TreeNode root) {
            if (root == null) {
                return true;
            }
            if (val == null) {
                val = root.val;
            }

            return root.val == val && isUnivalTree(root.left) && isUnivalTree(root.right);
        }
    }
}

