package top.chenqwwq.leetcode.daily._20200518;

/**
 * 152. 乘积最大子数组
 * 给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积
 *
 * @author chen
 * @date 2020/5/18 下午9:03
 */
public class Solution {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        if (nums.length == 1) {
            return nums[0];
        }

        int max = nums[0], min = nums[0];
        int res = nums[0];

        for (int i = 1; i < nums.length; i++) {
            final int i1 = max * nums[i];
            final int i2 = min * nums[i];

            max = Math.max(i1, Math.max(i2, nums[i]));
            min = Math.min(i1, Math.min(i2, nums[i]));

            res = Math.max(max, res);
        }

        return res;
    }
}