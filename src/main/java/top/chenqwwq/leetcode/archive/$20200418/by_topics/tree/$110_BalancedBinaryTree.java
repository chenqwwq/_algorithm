package top.chenqwwq.leetcode.archive.$20200418.by_topics.tree;

/**
 * 110. 平衡二叉树
 * <p>
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 * <p>
 * 本题中，一棵高度平衡二叉树定义为：
 * <p>
 * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。
 * <p>
 * 示例 1:
 * <p>
 * 给定二叉树 [3,9,20,null,null,15,7]
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回 true 。
 * <p>
 * 示例 2:
 * <p>
 * 给定二叉树 [1,2,2,3,3,null,null,4,4]
 * <p>
 * 1
 * / \
 * 2   2
 * / \
 * 3   3
 * / \
 * 4   4
 * 返回 false 。
 *
 * @author chen
 * @date 2019/11/24 下午11:00
 */
public class $110_BalancedBinaryTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class Solution {
        public boolean isBalanced(TreeNode root) {
            // 递归获取并判断每个子树的左右子树
            // 如果非平衡树返回-1,进行阻断
            return getDepthAndCheck(root) != -1;
        }

        private int getDepthAndCheck(TreeNode root) {
            if (root == null) {
                return 1;
            }

            // 获取右节点深度
            // 判断-1并返回相当于提前截断
            final int rightDepth = getDepthAndCheck(root.right);
            if (rightDepth == -1) {
                return -1;
            }

            // 获取左边节点的深度
            final int leftDepth = getDepthAndCheck(root.left);
            if (leftDepth == -1) {
                return -1;
            }

            // 如果是非平衡树直接返回-1,是平衡树就返回高度
            return Math.abs(rightDepth - leftDepth) <= 1 ? Math.max(rightDepth, leftDepth) + 1 : -1;


        }
    }
}
