package top.chenqwwq.leetcode.archive.$20200418.by_topics.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * 589. N-ary Tree Preorder Traversal
 * Easy
 * Given an n-ary tree, return the preorder traversal of its nodes' values.
 * <p>
 * Note:
 * Recursive solution is trivial, could you do it iteratively?
 *
 * @author bingxin.chen
 * @date 2019/9/25 12:14
 */
public class $589_NaryTreePreorderTraversal {
    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    class Solution {
        // 返回值
        private List<Integer> res = new ArrayList<>();

        public List<Integer> preorder(Node root) {
            iterative(root);
            return res;
        }

        /**
         * 递归遍历
         */
        private void recursion(Node root) {
            if (root == null) {
                return;
            }
            res.add(root.val);
            for (Node node : root.children) {
                recursion(node);
            }
        }

        /**
         * 非递归
         */
        private void iterative(Node root) {
            if (root == null) {
                return;
            }
            Stack<Node> nodes = new Stack<>();
            nodes.push(root);

            while (!nodes.isEmpty()) {
                final Node top = nodes.pop();
                res.add(top.val);
                Collections.reverse(top.children);
                for (Node node : top.children) {
                    nodes.push(node);
                }
            }
        }
    }
}
