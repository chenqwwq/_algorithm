package top.chenqwwq.leetcode.archive.$20200418.by_topics.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 94. Binary Tree Inorder Traversal
 * Medium
 * <p>
 * 1966
 * <p>
 * 87
 * <p>
 * Favorite
 * <p>
 * Share
 * Given a binary tree, return the inorder traversal of its nodes' values.
 * <p>
 * Example:
 * <p>
 * Input: [1,null,2,3]
 * 1
 * \
 * 2
 * /
 * 3
 * <p>
 * Output: [1,3,2]
 * Follow up: Recursive solution is trivial, could you do it iteratively?
 *
 * @author bingxin.chen
 * @date 2019/9/24 12:27
 */
public class $94_BinaryTreeInorderTraversal {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class Solution {
        /**
         * 递归题解
         */
        private List<Integer> res = new ArrayList<>();
        /**
         * 迭代题解
         * 递归的本质就是栈,地柜改成非递归肯定要使用栈
         */
        private Stack<TreeNode> nodes = new Stack<>();

        public List<Integer> inorderTraversal(TreeNode root) {
            return iteration(root);
        }

        private List<Integer> recursive(TreeNode root) {
            if (root == null) {
                return new ArrayList<>();
            }
            if (root.left != null) {
                inorderTraversal(root.left);
            }

            res.add(root.val);

            if (root.right != null) {
                inorderTraversal(root.right);
            }

            return res;
        }

        private List<Integer> iteration(TreeNode root) {
            while (root != null || !nodes.isEmpty()) {
                // 将二叉树左边界的节点全压入栈
                while (root != null) {
                    nodes.push(root);
                    root = root.left;
                }
                // 弹出栈头节点
                root = nodes.pop();
                // 添加当前节点的数值到结果List
                res.add(root.val);
                // 设置为root的右节点，做下次遍历
                root = root.right;
            }
            return res;
        }

    }
}
