package top.chenqwwq.leetcode.daily._20200628;

/**
 * 209. 长度最小的子数组
 * 给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的连续子数组，并返回其长度。如果不存在符合条件的连续子数组，返回 0。
 *
 * @author chen
 * @date 2020/6/28 上午12:01
 */
public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        // 因为要求是连续子数组，并且全部是正整数(窗口扩大和增大，缩写和也缩小)
        // 所以考虑用滑动窗口法
        int winL = 0, winR = 0, sum = nums[0];
        int res = Integer.MAX_VALUE;

        while (winL <= winR && winR < nums.length) {
            if (sum >= s) {
                res = Math.min(res, winR - winL + 1);
                sum -= nums[winL++];
            } else {
                if (++winR < nums.length) {
                    sum += nums[winR];
                }
            }
        }

        return res == Integer.MAX_VALUE ? 0 : res;
    }
}