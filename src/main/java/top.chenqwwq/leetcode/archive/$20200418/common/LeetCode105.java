package top.chenqwwq.leetcode.archive.$20200418.common;


/**
 * @author CheNbXxx
 * @description 根据前序和中序遍历确定二叉树结构
 * @email chenbxxx@gmail.con
 * @date 2019/1/31 16:57
 */
public class LeetCode105 {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */

    static class Solution {
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            return mainBuild(preorder, inorder, 0, 0, inorder.length - 1);
        }

        private TreeNode mainBuild(int[] preorder, int[] inorder, int preIndex, int inStart, int inEnd) {
            // 递归退出条件
            if (preIndex > preorder.length - 1 || inStart > inEnd) {
                return null;
            }

            // 根据前序遍历确定根节点
            TreeNode root = new TreeNode(preorder[preIndex]);

            // 确定root在中序遍历的位置
            int rootIndexInInOrder = 0;
            for (; rootIndexInInOrder < inorder.length; rootIndexInInOrder++) {
                if (preorder[preIndex] == inorder[rootIndexInInOrder]) {
                    break;
                }
            }
            root.left = mainBuild(preorder, inorder, preIndex + 1, inStart, rootIndexInInOrder - 1);
            root.right = mainBuild(preorder, inorder, preIndex + rootIndexInInOrder - inStart + 1, rootIndexInInOrder + 1, inEnd);
            return root;
        }

        static class TreeNode {
            int val;
            TreeNode left;
            TreeNode right;

            TreeNode(int x) {
                val = x;
            }
        }
    }
}
