package top.chenqwwq.leetcode.archive.$20200418.by_topics.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 95. Unique Binary Search Trees II
 * Medium
 * <p>
 * 1581
 * <p>
 * 130
 * <p>
 * Favorite
 * <p>
 * Share
 * Given an integer n, generate all structurally unique BST's (binary search trees) that store values 1 ... n.
 * <p>
 * Example:
 * <p>
 * Input: 3
 * Output:
 * [
 * [1,null,3,2],
 * [3,2,null,1],
 * [3,1,null,null,2],
 * [2,1,3],
 * [1,null,2,null,3]
 * ]
 * Explanation:
 * The above output corresponds to the 5 unique BST's shown below:
 * <p>
 * 1         3     3      2      1
 * \       /     /      / \      \
 * 3     2     1      1   3      2
 * /     /       \                 \
 * 2     1         2                 3
 *
 * @author chen
 * @date 2019/11/14 下午11:55
 */
public class $95_UniqueBinarySearchTreesII {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class Solution {
        public List<TreeNode> generateTrees(int n) {
            // 生成所有的二叉搜索树
            // 1. 分治递归
            // 2. 动态规划

            // n == 0的时候输出一个二维数组报错
            if (n == 0) {
                return new ArrayList<>();
            }
            return generate(1, n);
        }


        /**
         * 分治+递归
         * // 遍历数组,每个节点轮流作为root节点
         * // 先获得左右两个子树所有的子树排列
         * // 左右两个子树的列表做两层循环遍历,排列组合
         */
        private List<TreeNode> generate(int left, int right) {
            ArrayList<TreeNode> nodes = new ArrayList<>();
            if (left > right) {
                // null不能少,否则遍历不到
                nodes.add(null);
                return nodes;
            }

            if (left == right) {
                nodes.add(new TreeNode(left));
                return nodes;
            }

            for (int i = left; i <= right; i++) {
                List<TreeNode> leftNodes = generate(left, i - 1);
                List<TreeNode> rightNodes = generate(i + 1, right);
                for (TreeNode rightNode : rightNodes) {
                    for (TreeNode leftNode : leftNodes) {
                        TreeNode root = new TreeNode(i);
                        root.left = leftNode;
                        root.right = rightNode;
                        nodes.add(root);
                    }
                }
            }
            return nodes;
        }
    }
}
