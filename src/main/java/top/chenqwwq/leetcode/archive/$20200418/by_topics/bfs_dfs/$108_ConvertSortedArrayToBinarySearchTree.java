package top.chenqwwq.leetcode.archive.$20200418.by_topics.bfs_dfs;

/**
 * 108. Convert Sorted Array to Binary Search Tree
 * Easy
 * <p>
 * Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
 * <p>
 * For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
 * <p>
 * Example:
 * <p>
 * Given the sorted array: [-10,-3,0,5,9],
 * <p>
 * One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:
 * <p>
 * 0
 * / \
 * -3   9
 * /   /
 * -10  5
 *
 * @author chen
 * @date 2019/10/22 上午7:41
 */
public class $108_ConvertSortedArrayToBinarySearchTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class Solution {
        public TreeNode sortedArrayToBST(int[] nums) {
            if (nums == null || nums.length == 0) {
                return null;
            }
            return dfs(nums, 0, nums.length - 1);
        }

        public TreeNode dfs(int[] nums, int start, int end) {
            if (start > end) {
                return null;
            }
            int mid = (start + end) >> 1;
            TreeNode node = new TreeNode(nums[mid]);
            node.right = dfs(nums, mid + 1, end);
            node.left = dfs(nums, start, mid - 1);
            return node;
        }
    }
}
