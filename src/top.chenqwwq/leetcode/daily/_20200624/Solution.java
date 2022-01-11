package top.chenqwwq.leetcode.daily._20200624;

import java.util.Arrays;

/**
 * 16. 最接近的三数之和
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 * <p>
 * 提示：
 * <p>
 * 3 <= nums.length <= 10^3
 * -10^3 <= nums[i] <= 10^3
 * -10^4 <= target <= 10^4
 *
 * @author chen
 * @date 2020/6/24 上午11:22
 */
public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length < 3) {
            return -1;
        }

        // 排序
        Arrays.sort(nums);

        // 属性
        final int length = nums.length;
        int minDiff = Integer.MAX_VALUE, corrSum = Integer.MAX_VALUE;

        // curr定一个起点
        for (int curr = 0; curr < length; curr++) {
            int left = curr + 1, right = length - 1;

            while (left < right) {
                final int sum = nums[curr] + nums[left] + nums[right];
                final int diff = Math.abs(sum - target);
                if (diff < minDiff) {
                    minDiff = diff;
                    corrSum = sum;
                }
                if (sum > target) {
                    right--;
                } else if (sum < target) {
                    left++;
                } else {
                    // 相同了，直接返回
                    return sum;
                }
            }
        }

        return corrSum == Integer.MAX_VALUE ? -1 : corrSum;

    }
}