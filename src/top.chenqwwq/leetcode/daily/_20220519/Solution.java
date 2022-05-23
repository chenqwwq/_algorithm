package top.chenqwwq.leetcode.daily._20220519;

import java.util.Arrays;

/**
 * @author chenqwwq
 * @date 2022/5/19
 **/
public class Solution {
    public int minMoves2(int[] nums) {
        final int n = nums.length;
        Arrays.sort(nums);
        if ((n & 1) == 1) {
            int mid = nums[n >> 1], ans = 0;
            for (int num : nums) {
                ans += Math.abs(num - mid);
            }
            return ans;
        }
        int m1 = nums[n >> 1], m2 = nums[(n >> 1) - 1];
        int a1 = 0, a2 = 0;
        for (int num : nums) {
            a1 += Math.abs(num - m1);
            a2 += Math.abs(num - m2);
        }
        return Math.min(a1, a2);
    }
}