package top.chenqwwq.leetcode.archive.$20200418.common;

/**
 * @author CheNbXxx
 * @description 根据中序和后续遍历确定二叉树结构
 * @email chenbxxx@gmail.con
 * @date 2019/2/1 11:16
 */
public class LeetCode106 {
    class Solution {
        public TreeNode buildTree(int[] inorder, int[] postorder) {
            return build(inorder, postorder, postorder.length - 1, 0, inorder.length - 1);
        }

        public TreeNode build(int[] inorders, int[] postorder, int postIndex, int inStart, int inEnd) {
            if (postIndex < 0 || inStart > inEnd) {
                return null;
            }

            // 根据后序遍历确定根节点
            TreeNode root = new TreeNode(postorder[postIndex]);

            // 确定根节点在中中序遍历中的位置
            int sign = inStart;
            for (; sign <= inEnd; sign++) {
                if (inorders[sign] == root.val) {
                    root.left = build(inorders, postorder, postIndex - inEnd + sign - 1, inStart, sign - 1);
                    root.right = build(inorders, postorder, postIndex - 1, sign + 1, inEnd);
                }
            }
            return root;
        }

        class TreeNode {
            int val;
            TreeNode left;
            TreeNode right;

            TreeNode(int x) {
                val = x;
            }
        }
    }
}
