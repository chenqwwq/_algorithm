package top.chenqwwq.leetcode.archive.$20200418.by_topics.tree;

/**
 * 700. Search in a Binary Search Tree
 * Easy
 * Given the root node of a binary search tree (BST) and a value. You need to find the node in the BST that the node's value equals the given value. Return the subtree rooted with that node. If such node doesn't exist, you should return NULL.
 * <p>
 * For example,
 * <p>
 * Given the tree:
 * 4
 * / \
 * 2   7
 * / \
 * 1   3
 * <p>
 * And the value to search: 2
 * You should return this subtree:
 * <p>
 * 2
 * / \
 * 1   3
 * In the example above, if we want to search the value 5, since there is no node with value 5, we should return NULL.
 * <p>
 * Note that an empty tree is represented by NULL, therefore you would see the expected output (serialized tree format) as [], not null.
 *
 * @author bingxin.chen
 * @date 2019/9/25 11:25
 */
public class $700_SearchInABinarySearchTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class Solution {
        public TreeNode searchBST(TreeNode root, int val) {
            return iterative(root, val);
        }

        /**
         * 递归题解
         */
        private TreeNode recursion(TreeNode root, int val) {
            if (root == null) {
                return null;
            }
            if (root.val == val) {
                return root;
            }
            return recursion(root.val > val ? root.left : root.right, val);
        }

        /**
         * 非递归题解
         */
        private TreeNode iterative(TreeNode root, int val) {

            while (root != null) {
                if (root.val == val) {
                    return root;
                }
                root = root.val > val
                        ? root.left
                        : root.right;
            }

            return null;
        }
    }
}
