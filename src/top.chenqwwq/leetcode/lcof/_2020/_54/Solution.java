package top.chenqwwq.leetcode.lcof._2020._54;

import top.chenqwwq.leetcode.common.TreeNode;

/**
 * 面试题32 - II. 从上到下打印二叉树 II
 * 从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。
 * <p>
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回其层次遍历结果：
 * <p>
 * [
 * [3],
 * [9,20],
 * [15,7]
 * ]
 * <p>
 * 提示：
 * <p>
 * 节点总数 <= 1000
 *
 * @author chen
 * @date 2020/4/18 下午4:04
 */
public class Solution {

    int res, count;

    public int kthLargest(TreeNode root, int k) {
        count = k;
        reverseMidOrder(root);
        return res;
    }

    public void reverseMidOrder(TreeNode node) {
        // 按照二叉树的倒序中序遍历搜索

        // 叶子节点直接返回
        if (node == null) {
            return;
        }
        // 先遍历右边
        reverseMidOrder(node.right);
        if (--count <= 0) {
            if (count == 0) {
                res = node.val;
            }
            return;
        }
        reverseMidOrder(node.left);
    }
}