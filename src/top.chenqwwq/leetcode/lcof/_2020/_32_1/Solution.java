package top.chenqwwq.leetcode.lcof._2020._32_1;

import top.chenqwwq.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 剑指 Offer 32 - I.
 * 从上到下打印二叉树
 * <p>
 * 从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。
 * 提示：
 * <p>
 * 节点总数 <= 1000
 *
 * @author chen
 * @date 2020/6/25 上午9:16
 */
public class Solution {

    public int[] levelOrder(TreeNode root) {
        if (root == null) {
            return new int[0];
        }

        List<Integer> res = new ArrayList<>();

        // 写多了递归，现在用迭代来写
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            final TreeNode pop = queue.poll();
            res.add(pop.val);
            if (pop.left != null) {
                queue.offer(pop.left);
            }
            if (pop.right != null) {
                queue.offer(pop.right);
            }
        }
        int[] result = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            result[i] = res.get(i);
        }

        return result;
    }
}
