package top.chenqwwq.leetcode.archive.$20200418.by_topics.tree;

/**
 * 897. Increasing Order Search Tree
 * Easy
 * Given a binary search tree, rearrange the tree in in-order so that the leftmost node in the tree is now the root of the tree, and every node has no left child and only 1 right child.
 * <p>
 * Example 1:
 * Input: [5,3,6,2,4,null,8,1,null,null,null,7,9]
 * <p>
 * 5
 * / \
 * 3    6
 * / \    \
 * 2   4    8
 * /        / \
 * 1        7   9
 * <p>
 * Output: [1,null,2,null,3,null,4,null,5,null,6,null,7,null,8,null,9]
 * <p>
 * 1
 * \
 * 2
 * \
 * 3
 * \
 * 4
 * \
 * 5
 * \
 * 6
 * \
 * 7
 * \
 * 8
 * \
 * 9
 * Note:
 * <p>
 * The number of nodes in the given tree will be between 1 and 100.
 * Each node will have a unique integer value from 0 to 1000.
 *
 * @author bingxin.chen
 * @date 2019/9/26 12:58
 */
public class $897_IncreasingOrderSearchTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class Solution {
        // 临时节点，向右传递
        TreeNode pseudoHead = null;

        public TreeNode increasingBST(TreeNode root) {
            // 将二叉排序树构造成递增的链表
            TreeNode head = new TreeNode(0);
            pseudoHead = head;
            inOrder(root);
            return head.right;
        }

        public void inOrder(TreeNode node) {
            if (node == null) {
                return;
            }
            inOrder(node.left);
            // 直接断开左边链接
            node.left = null;
            pseudoHead.right = node;
            pseudoHead = node;
            inOrder(node.right);
        }
    }
}
