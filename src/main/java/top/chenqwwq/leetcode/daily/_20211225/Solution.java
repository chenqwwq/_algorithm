package top.chenqwwq.leetcode.daily._20211225;

import top.chenqwwq.leetcode.common.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chenbingxin
 * @date 2021/12/25
 **/
public class Solution {

    Map<Integer, Integer> d2v = new HashMap<>();

    public boolean isEvenOddTree(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isEvenOddTree(root, 0);
    }

    public boolean isEvenOddTree(TreeNode node, int depth) {
        if (node == null) {
            return true;
        }
        final Integer value = d2v.get(depth);
        System.out.printf("第%d层,当前节点值为%d,原始值为%d\n", depth, node.val, value);
        // odd -> even -> strictly decreasing
        if ((depth & 1) == 1) {
            if ((node.val & 1) == 1 || (value != null && node.val >= value)) {
                return false;
            }
        } else if ((node.val & 1) == 0 || (value != null && node.val <= value)) {
            return false;
        }
        d2v.put(depth, node.val);

        boolean flag = isEvenOddTree(node.left, depth + 1);
        if (!flag) {
            return false;
        }
        return isEvenOddTree(node.right, depth + 1);
    }
}
