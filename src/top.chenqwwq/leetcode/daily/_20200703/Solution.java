package top.chenqwwq.leetcode.daily._20200703;

import top.chenqwwq.leetcode.common.TreeNode;

/**
 * 108. 将有序数组转换为二叉搜索树
 * 将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
 * <p>
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。*
 *
 * @author chen
 * @date 2020-07-03
 **/
public class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        // 升序数组

        return generate(nums, 0, nums.length - 1);
    }


    public TreeNode generate(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = (left + right + 1) >> 1;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = generate(nums, left, mid - 1);
        root.right = generate(nums, mid + 1, right);
        return root;
    }
}
