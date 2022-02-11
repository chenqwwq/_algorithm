package top.chenqwwq.leetcode.daily._20200513;

import top.chenqwwq.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 102. 二叉树的层序遍历
 * 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
 *
 * @author chen
 * @date 2020-05-13
 **/
public class Solution {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        if (root == null) {
            return lists;
        }
        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.add(root);

        bfs(nodes, lists);
        return lists;
    }

    private void bfs(Queue<TreeNode> nodes, List<List<Integer>> res) {
        if (nodes.isEmpty()) {
            return;
        }
        int size = nodes.size();
        List<Integer> levelList = new ArrayList<>(size);
        while (size-- > 0) {
            TreeNode pop = nodes.poll();
            levelList.add(pop.val);
            if (pop.left != null) {
                nodes.offer(pop.left);
            }
            if (pop.right != null) {
                nodes.offer(pop.right);
            }
        }

        res.add(levelList);

        bfs(nodes, res);

    }
}
