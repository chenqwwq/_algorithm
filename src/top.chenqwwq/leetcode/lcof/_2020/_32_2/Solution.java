package top.chenqwwq.leetcode.lcof._2020._32_2;


import top.chenqwwq.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 面试题32 - II. 从上到下打印二叉树 II
 * 从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。
 * <p>
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 *
 * @author chen
 * @date 2020/4/18 下午4:52
 */
class Solution {

    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> levelOrder(TreeNode root) {
        bfs(root, 1);
        return res;
    }

    private void bfs(TreeNode node, int depth) {
        if (node == null) {
            return;
        }

        if (res.size() < depth) {
            res.add(new ArrayList<>());
        }

        res.get(depth - 1).add(node.val);
        bfs(node.left, depth + 1);
        bfs(node.right, depth + 1);
    }
}