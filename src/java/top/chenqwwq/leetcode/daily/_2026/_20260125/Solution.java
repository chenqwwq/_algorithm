package top.chenqwwq.leetcode.daily._2026._20260125;

import java.util.Arrays;

/**
 * @author chenqwwq
 * @date 2026/1/25
 **/
public class Solution {
    public int minimumDifference(int[] nums, int k) {
        if (k <= 1) return 0;
        final int n = nums.length;
        Arrays.sort(nums);
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n - k - 1; i++) {
            ans = Math.min(ans, nums[i + k - 1] - nums[i]);
        }
        return ans;
    }
}