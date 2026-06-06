package top.chenqwwq.leetcode.archive.$20200418.by_topics.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 590. N-ary Tree Postorder Traversal
 * Easy
 * Given an n-ary tree, return the postorder traversal of its nodes' values.
 * <p>
 * Note:
 * Recursive solution is trivial, could you do it iteratively?
 *
 * @author bingxin.chen
 * @date 2019/9/25 12:45
 */
public class $590_NaryTreePostorderTraversal {
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
        private List<Integer> res = new ArrayList<>();

        public List<Integer> postorder(Node root) {
            recursion(root);
            return res;
        }

        private void recursion(Node root) {
            if (root == null) {
                return;
            }
            for (Node node : root.children) {
                recursion(node);
            }
            res.add(root.val);
        }
    }
}
