package top.chenqwwq.leetcode.archive.$20200418.common;

/**
 * @author chen
 * @description 最大二叉树
 * 输入: [3,2,1,6,0,5]
 * 输入: 返回下面这棵树的根节点：
 * <p>
 * 6
 * /   \
 * 3     5
 * \    /
 * 2  0
 * \
 * 1
 * @email chenbxxx@gmail.com
 * @date 19-2-24
 */
public class LeetCode654 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class Solution {
        public TreeNode constructMaximumBinaryTree(int[] nums) {
            return mainHandle(nums, 0, nums.length - 1);
        }

        private TreeNode mainHandle(int[] nums, int start, int end) {
            if (start > end) {
                return null;
            }
            int maxIndex = getMax(nums, start, end);
            TreeNode node = new TreeNode(nums[maxIndex]);

            node.left = mainHandle(nums, start, maxIndex - 1);
            node.right = mainHandle(nums, maxIndex + 1, end);

            return node;
        }

        /**
         * 返回start~end之间的最大值下标
         */
        public int getMax(int[] nums, int start, int end) {
            int max = start;
            for (int i = start; i <= end; i++) {
                if (nums[i] > nums[max]) {
                    max = i;
                }
            }
            return max;
        }
    }
}
