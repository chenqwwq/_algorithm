package top.chenqwwq.leetcode.archive.$20200418.common;

/**
 * 98. 验证二叉搜索树
 * <p>
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 * <p>
 * 假设一个二叉搜索树具有如下特征：
 * <p>
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 * 示例 1:
 * <p>
 * 输入:
 * 2
 * / \
 * 1   3
 * 输出: true
 * 示例 2:
 * <p>
 * 输入:
 * 5
 * / \
 * 1   4
 * / \
 * 3   6
 * 输出: false
 * 解释: 输入为: [5,1,4,null,null,3,6]。
 * 根节点的值为 5 ，但是其右子节点值为 4 。
 * <p>
 * 1. 首先考虑递归的实现
 * 提交报错,没有考虑子树的左子树比根节点小的情况
 *
 * @author bingxin.chen
 * @date 2019/7/15 12:09
 */
public class LeetCode98 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class Solution {
        public boolean isValidBST(TreeNode root) {
            return validHandle(root, null, null);
        }

        public boolean validHandle(TreeNode root, Integer min, Integer max) {
            if (root == null) {
                return true;
            }

            return (min == null || root.val > min)
                    && (max == null || root.val < max)
                    && validHandle(root.left, min, root.val)
                    && validHandle(root.right, root.val, max);
        }

    }

///**
// * 一种更快的方法
// */
//    class Solution {
//        TreeNode pre = null;
//
//        public boolean isValidBST(TreeNode root) {
//            if (root == null) return true;
//            if (!isValidBST(root.left)) return false;
//            if (pre != null && pre.val >= root.val) return false;
//            pre = root;
//            return isValidBST(root.right);
//        }
}
