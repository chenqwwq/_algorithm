package top.chenqwwq.leetcode.archive.$20200418.by_topics.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 103. 二叉树的锯齿形层次遍历
 * <p>
 * 给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 * <p>
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回锯齿形层次遍历如下：
 * <p>
 * [
 * [3],
 * [20,9],
 * [15,7]
 * ]
 *
 * @author chen
 * @date 2019/11/25 上午8:27
 */
public class $103_BinaryTreeZigzagLevelOrderTraversal {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class Solution {
        // 常规bfs,翻转奇数行的形式过于取巧

        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
            List<List<Integer>> result = new ArrayList<>();

            // 采用双端队列的形式
            LinkedList<TreeNode> nodes = new LinkedList<>();
            nodes.add(root);
            boolean flag = true;

            while (!nodes.isEmpty()) {
                // 当前层的结果
                List<Integer> tmp = new ArrayList<>();
                // 当前层的元素个数
                int count = nodes.size();

                while (count-- > 0) {
                    // flag为true是从队头取元素 false时从队尾取元素
                    final TreeNode node = flag ? nodes.pollFirst() : nodes.pollLast();

                    // 跳出while循环
                    if (node == null) {
                        continue;
                    }

                    // 添加到tmp中
                    tmp.add(node.val);

                    // 添加元素
                    if (flag) {
                        nodes.addLast(node.left);
                        nodes.addLast(node.right);
                    } else {
                        nodes.addFirst(node.right);
                        nodes.addFirst(node.left);
                    }
                }

                // 遍历永远从前往后遍历
                result.add(tmp);
                flag = !flag;
            }

            result.remove(result.size() - 1);
            return result;

        }

    }
}
