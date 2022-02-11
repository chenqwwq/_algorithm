package top.chenqwwq.leetcode.archive.$20200418.common;

import java.util.ArrayList;
import java.util.List;

/**
 * 559. N叉树的最大深度
 * 给定一个 N 叉树，找到其最大深度。
 * <p>
 * 最大深度是指从根节点到最远叶子节点的最长路径上的节点总数。
 * <p>
 * 例如，给定一个 3叉树 :
 * <p>
 * 我们应返回其最大深度，3。
 * <p>
 * 说明:
 * <p>
 * 树的深度不会超过 1000。
 * 树的节点总不会超过 5000。
 *
 * @author chen
 * @date 2019/8/4 下午1:08
 */
public class LeetCode559 {
    public static void main(String[] args) {
        Node node1 = new Node(1, null);

        List<Node> list = new ArrayList<>();
        Node node2 = new Node(2, null);
        Node node3 = new Node(3, null);
        Node node4 = new Node(4, null);
        list.add(node2);
        list.add(node3);
        list.add(node4);
        node1.children = list;

        Node node5 = new Node(5, null);
        Node node6 = new Node(6, null);

        List<Node> list1 = new ArrayList<>();
        list1.add(node5);
        list1.add(node6);

        node2.children = list1;

        System.out.println(new LeetCode559().new Solution().maxDepth(node1));
    }

    static class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    /**
     * 递归法
     */
    class Solution {

        public int maxDepth(Node root) {
            if (root == null) {
                return 0;
            }
            int max = 0;
            for (Node node : root.children) {
                max = Math.max(maxDepth(node), max);
            }

            return max + 1;
        }
    }
}
