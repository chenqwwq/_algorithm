package top.chenqwwq.leetcode.archive.$20200418.common;

/**
 * 669. Trim a Binary Search Tree , 修剪二叉搜索树
 *
 * @author chen
 * @date 19-7-10 下午10:35
 */
public class LeetCode669 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class Solution {
        public TreeNode trimBST(TreeNode root, int L, int R) {
            // 考虑递归,往两边修剪
            return trim(root, L, R);
        }

        public TreeNode trim(TreeNode node, int L, int R) {
            if (node == null) {
                return null;
            }
            if (node.val > R) {
                // 往左边遍历
                return trim(node.left, L, R);
            }
            if (node.val < L) {
                return trim(node.right, L, R);
            }

            // >=L && <= R 的话 进行两边的修改
            node.right = trim(node.right, L, R);
            node.left = trim(node.left, L, R);
            return node;
        }
    }
}
