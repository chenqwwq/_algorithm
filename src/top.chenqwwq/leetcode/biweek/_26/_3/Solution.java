package top.chenqwwq.leetcode.biweek._26._3;

import top.chenqwwq.leetcode.common.TreeNode;

/**
 * 5398. 统计二叉树中好节点的数目 显示英文描述
 * <p>
 * 给你一棵根为 root 的二叉树，请你返回二叉树中好节点的数目。
 * <p>
 * 「好节点」X 定义为：从根到该节点 X 所经过的节点中，没有任何节点的值大于 X 的值。
 * <p>
 * 提示：
 * <p>
 * 二叉树中节点数目范围是 [1, 10^5] 。
 * 每个节点权值的范围是 [-10^4, 10^4] 。·
 *
 * @author chen
 * @date 2020/5/16 下午11:05
 */
public class Solution {
    public int goodNodes(TreeNode root) {
        // 根据题目描述：
        // 可以做深度优先搜索遍历
        if (root == null) {
            return 0;
        }
        return 1 + goodNodes(root.left, root.val) + goodNodes(root.right, root.val);
    }

    public int goodNodes(TreeNode node, int max) {
        if (node == null) {
            return 0;
        }

        // 如果max比当前节点值小，则以1为底数，
        // 都在以0为底数
        return max <= node.val ?
                1 + goodNodes(node.left, node.val) + goodNodes(node.right, node.val)
                : goodNodes(node.left, max) + goodNodes(node.right, max);
    }
}