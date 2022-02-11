package top.chenqwwq.leetcode.daily._20201027;

import top.chenqwwq.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 144. 二叉树的前序遍历
 * 给定一个二叉树，返回它的 前序 遍历。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,null,2,3]
 * 1
 * \
 * 2
 * /
 * 3
 * <p>
 * 输出: [1,2,3]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 *
 * @author chen
 * @date 2020-10-27
 **/
public class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        iteration(root, ans);
        return ans;
    }

    private void recursion(TreeNode root, List<Integer> ans) {
        // 递归
        if (root == null) {
            return;
        }
        ans.add(root.val);
        recursion(root.left, ans);
        recursion(root.right, ans);
    }

    private void iteration(TreeNode root, List<Integer> ans) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            final TreeNode pop = stack.pop();
            if (pop == null) {
                continue;
            }
            ans.add(pop.val);
            stack.push(pop.right);
            stack.push(pop.left);
        }
    }
}
