package top.chenqwwq.leetcode.archive.$20200418.common;

import java.util.ArrayList;
import java.util.List;

/**
 * 109. 有序链表转换二叉搜索树
 * 给定一个单链表，其中的元素按升序排序，将其转换为高度平衡的二叉搜索树。
 * <p>
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 * <p>
 * 示例:
 * <p>
 * 给定的有序链表： [-10, -3, 0, 5, 9],
 * <p>
 * 一个可能的答案是：[0, -3, 9, -10, null, 5], 它可以表示下面这个高度平衡二叉搜索树：
 * <p>
 * 0
 * / \
 * -3   9
 * /   /
 * -10  5
 *
 * @author bingxin.chen
 * @date 2019 /8/22 19:39
 */
public class LeetCode109 {
    /**
     * The type List node.
     */
    public class ListNode {
        /**
         * The Val.
         */
        int val;
        /**
         * The Next.
         */
        ListNode next;

        /**
         * Instantiates a new List node.
         *
         * @param x the x
         */
        ListNode(int x) {
            val = x;
        }
    }

    /**
     * The type Tree node.
     */
    public class TreeNode {
        /**
         * The Val.
         */
        int val;
        /**
         * The Left.
         */
        TreeNode left;
        /**
         * The Right.
         */
        TreeNode right;

        /**
         * Instantiates a new Tree node.
         *
         * @param x the x
         */
        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * The type Solution.
     */
    class Solution {
        /**
         * Sorted list to bst tree node.
         *
         * @param head the head
         * @return the tree node
         */
        public TreeNode sortedListToBST(ListNode head) {
            final List<Integer> nodes = tranToList(head);
            return link(nodes, 0, nodes.size() - 1);
        }

        /**
         * 递归链接树节点
         *
         * @param nodes the nodes
         * @param start the start
         * @param end   the end
         * @return tree node
         */
        private TreeNode link(List<Integer> nodes, int start, int end) {
            if (start > end) {
                return null;
            }
            // 选取中间的node
            int mid = (start + end + 1) / 2;
            System.out.println("mid:" + mid);
            final TreeNode midNode = new TreeNode(nodes.get(mid));
            midNode.right = link(nodes, mid + 1, end);
            midNode.left = link(nodes, start, mid - 1);
            return midNode;
        }

        /**
         * 链表转化为列表
         *
         * @param head the head
         * @return list
         */
        private List<Integer> tranToList(ListNode head) {
            // 1. 将链表转化为数组
            List<Integer> nodes = new ArrayList<>();
            while (head != null) {
                nodes.add(head.val);
                head = head.next;
            }
            return nodes;
        }
    }
}
