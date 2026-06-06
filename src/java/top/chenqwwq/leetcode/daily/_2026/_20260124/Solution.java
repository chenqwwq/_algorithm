package top.chenqwwq.leetcode.daily._2026._20260124;

import java.util.Arrays;

/**
 * @author chenqwwq
 * @date 2026/1/24
 **/
public class Solution {
    public int minPairSum(int[] nums) {
        final int n = nums.length;
        Arrays.sort(nums);
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < n >> 1; i++) {
            ans = Math.max(ans, nums[i] + nums[n - 1 - i]);
        }
        return ans;
    }
}