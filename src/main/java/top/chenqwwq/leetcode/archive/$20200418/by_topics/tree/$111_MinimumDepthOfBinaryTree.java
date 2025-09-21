package top.chenqwwq.leetcode.archive.$20200418.by_topics.tree;

/**
 * 111. 二叉树的最小深度
 * <p>
 * 给定一个二叉树，找出其最小深度。
 * <p>
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 * <p>
 * 说明: 叶子节点是指没有子节点的节点。
 * <p>
 * 示例:
 * <p>
 * 给定二叉树 [3,9,20,null,null,15,7],
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回它的最小深度  2.
 *
 * @author chen
 * @date 2019/11/24 下午11:42
 */
public class $111_MinimumDepthOfBinaryTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class Solution {
        public int minDepth(TreeNode root) {
            if (root == null) {
                return 0;
            }
            // 1
            //  \
            //   2
            // 以上这种树,单单只有右子树的需要单独处理

            return 1 + (root.left != null && root.right != null
                    ? Math.min(minDepth(root.right), minDepth(root.left))
                    : root.left == null
                    ? minDepth(root.right)
                    : minDepth(root.left));
        }
    }
}
