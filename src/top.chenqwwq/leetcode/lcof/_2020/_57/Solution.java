package top.chenqwwq.leetcode.lcof._2020._57;

/**
 * 剑指 Offer 57. 和为s的两个数字
 * 输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。如果有多对数字的和等于s，则输出任意一对即可。
 * <p>
 * 限制：
 * <p>
 * 1 <= nums.length <= 10^5
 * 1 <= nums[i] <= 10^6
 *
 * @author chen
 * @date 2020-06-30
 **/
public class Solution {
    public int[] twoSum(int[] nums, int target) {
        // nums递增
        // 直接考虑双指针
        if (nums == null || nums.length == 0) {
            return new int[]{};
        }

        int left = 0, right = nums.length - 1;
        int sum = nums[left] + nums[right];

        while (left < right) {
            if (sum > target) {
                sum -= nums[right--];
                sum += nums[right];
            } else if (sum < target) {
                sum -= nums[left++];
                sum += nums[left];
            } else {
                return new int[]{nums[left], nums[right]};
            }
        }

        return new int[]{};

    }
}