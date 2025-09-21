package top.chenqwwq.leetcode.archive.$20200418.common;

/**
 * 1080. Insufficient Nodes in Root to Leaf Paths
 * <p>
 * Given the root of a binary tree, consider all root to leaf paths: paths from the root to any leaf.  (A leaf is a node with no children.)
 * <p>
 * A node is insufficient if every such root to leaf path intersecting this node has sum strictly less than limit.
 * <p>
 * Delete all insufficient nodes simultaneously, and return the root of the resulting binary tree.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: root = [1,2,3,4,-99,-99,7,8,9,-99,-99,12,13,-99,14], limit = 1
 * <p>
 * Output: [1,2,3,4,null,null,7,8,9,null,14]
 * Example 2:
 * <p>
 * <p>
 * Input: root = [5,4,8,11,null,17,4,7,1,null,null,5,3], limit = 22
 * <p>
 * Output: [5,4,8,11,null,17,4,7,null,null,null,5]
 * <p>
 * <p>
 * Example 3:
 * <p>
 * <p>
 * Input: root = [1,2,-3,-5,null,4,null], limit = -1
 * <p>
 * Output: [1,null,-3,4]
 * <p>
 * <p>
 * Note:
 * <p>
 * The given tree will have between 1 and 5000 nodes.
 * -10^5 <= node.val <= 10^5
 * -10^9 <= limit <= 10^9
 * <p>
 * DFS,修剪二叉树
 * 只有在节点连接的所有叶子节点的和都小于limit的时候才能删除该节点
 *
 * @author bingxin.chen
 * @date 2019/7/11 12:26
 */
public class LeetCode1080 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class Solution {
        public TreeNode sufficientSubset(TreeNode root, int limit) {
            return dfsTrim(root, 0, limit) ? null : root;
        }

        public boolean dfsTrim(TreeNode curr, int currPath, int limit) {
            // 可以修剪的判断
            // 递归有问题,单边有枝的节点判断会出现问题
            // 一边可剪一边为空的节点应该剪去
//            if (curr == null){
//                return currPath < limit;
//            }

            // 节点未空不能走到这一步
            if (curr.left == null && curr.right == null) {
                return currPath + curr.val < limit;
            }
            currPath += curr.val;
            final boolean left = curr.left == null || dfsTrim(curr.left, currPath, limit);
            final boolean right = curr.right == null || dfsTrim(curr.right, currPath, limit);
            if (left) {
                curr.left = null;
            }

            if (right) {
                curr.right = null;
            }

            return right && left;
        }
    }
}
