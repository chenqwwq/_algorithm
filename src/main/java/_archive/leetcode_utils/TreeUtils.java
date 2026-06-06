package top.chenqwwq.leetcode.utils;

import top.chenqwwq.leetcode.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author chen
 * @date 2020/4/18 下午4:52
 */
public class TreeUtils {

    /**
     * 树比较
     */
    public static boolean equals(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 == null || root2 == null) {
            return false;
        }

        if (root1.val != root2.val) {
            return false;
        }

        return equals(root1.left, root2.left) && equals(root1.right, root2.right);
    }

    public static boolean isBinarySearchTree(TreeNode node) {
        if (node == null || (node.left == null && node.right == null)) {
            return true;
        }

        return (node.left == null || node.val > node.left.val)
                && (node.right == null || node.val < node.right.val)
                && isBinarySearchTree(node.left)
                && isBinarySearchTree(node.right);
    }

    /**
     * 中左右生成树
     */
    public static TreeNode getTreeByArray(Integer[] arr) {
        if (arr == null || arr.length == 0) {
            return TreeNode.DEFAULT;
        }
        if (arr.length == 1) {
            return new TreeNode(arr[0]);
        }

        TreeNode root = new TreeNode(arr[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int currIndex = 1;

        while (currIndex < arr.length) {
            final TreeNode pop = queue.poll();
            if (pop == null) {
                throw new RuntimeException("error");
            }
            pop.left = getTreeNode(arr[currIndex++]);

            if (currIndex >= arr.length) {
                break;
            }
            pop.right = getTreeNode(arr[currIndex++]);

            queue.offer(pop.left);
            queue.offer(pop.right);
        }

        return root;
    }

    private static TreeNode getTreeNode(Integer i) {
        return i == null ? null : new TreeNode(i);
    }

}
