package top.chenqwwq.leetcode.archive.$20200418.common;

import java.util.Stack;

/**
 * 897. Increasing Order Search Tree
 * 二叉查找树转化为单边递增树
 *
 * @author bingxin.chen
 * @date 2019/7/4 12:15
 */
public class Leetcode897 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class Solution {
        Stack<TreeNode> stack = new Stack();

        public TreeNode increasingBST(TreeNode root) {

            // 中序遍历,入栈
            midTrave(root);
            TreeNode node1 = null, node2;
            node2 = stack.pop();
            while (!stack.isEmpty()) {
                node1 = stack.pop();
                node1.right = node2;
                node2 = node1;
            }

            return node1;
        }

        /**
         * 中序入栈
         *
         * @param node
         */
        public void midTrave(TreeNode node) {
            if (node == null) {
                return;
            }
            midTrave(node.left);
            // 断开链接
            node.left = null;
            stack.push(node);
            midTrave(node.right);
            node.right = null;
        }
    }
}
