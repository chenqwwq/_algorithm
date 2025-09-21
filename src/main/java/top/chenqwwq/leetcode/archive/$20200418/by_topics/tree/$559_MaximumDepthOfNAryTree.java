package top.chenqwwq.leetcode.archive.$20200418.by_topics.tree;

import java.util.List;

/**
 * 559. Maximum Depth of N-ary Tree
 * Easy
 * Given a n-ary tree, find its maximum depth.
 * <p>
 * The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 * Note:
 * <p>
 * The depth of the tree is at most 1000.
 * The total number of nodes is at most 5000.
 *
 * @author bingxin.chen
 * @date 2019/9/26 12:48
 */
public class $559_MaximumDepthOfNAryTree {
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
        public int maxDepth(Node root) {
            // 求n叉数的最大深度
            if (root == null) {
                return 0;
            }

            int depth = 0;
            for (Node node : root.children) {
                depth = Math.max(depth, maxDepth(node));
            }
            // 子树最大的深度+当前节点
            return depth + 1;
        }
    }
}
