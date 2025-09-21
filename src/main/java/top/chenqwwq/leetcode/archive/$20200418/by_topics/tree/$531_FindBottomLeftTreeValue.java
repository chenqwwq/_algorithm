package top.chenqwwq.leetcode.archive.$20200418.by_topics.tree;

/**
 * 513. 找树左下角的值
 * <p>
 * <p>
 * <p>
 * <p>
 * 题目描述
 * 评论 (120)
 * 题解(32)New
 * 提交记录
 * 给定一个二叉树，在树的最后一行找到最左边的值。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * <p>
 * 2
 * / \
 * 1   3
 * <p>
 * 输出:
 * 1
 * <p>
 * <p>
 * 示例 2:
 * <p>
 * 输入:
 * <p>
 * 1
 * / \
 * 2   3
 * /   / \
 * 4   5   6
 * /
 * 7
 * <p>
 * 输出:
 * 7
 * <p>
 * <p>
 * 注意: 您可以假设树（即给定的根节点）不为 NULL。
 *
 * @author bingxin.chen
 * @date 2019/11/29 10:36
 */
public class $531_FindBottomLeftTreeValue {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class Solution {

        TreeNode leftNode = null;
        int maxDeep = 0;

        public int findBottomLeftValue(TreeNode root) {
            // 树的根节点肯定不为null
            // 深度优先搜索遍历,记录最大深度和节点

            dfs(root, 1);
            return leftNode.val;
        }

        private void dfs(TreeNode root, int depth) {
            if (root.left == null && root.right == null && maxDeep < depth) {
                maxDeep = depth;
                leftNode = root;
            }

            if (root.left != null) {
                dfs(root.left, depth + 1);
            }

            if (root.right != null) {
                dfs(root.right, depth + 1);
            }
        }
    }
}
