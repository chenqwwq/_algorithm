package top.chenqwwq.leetcode.daily._2026._20260201;

import java.util.Arrays;

/**
 * @author chenqwwq
 * @date 2026/2/1
 **/
public class Solution {
    public int minimumCost(int[] nums) {
        final int n = nums.length;
        int ans = nums[0];
        System.arraycopy(nums, 1, nums, 0, n - 1);
        nums[n - 1] = Integer.MAX_VALUE;
        Arrays.sort(nums);
        return nums[0] + nums[1] + ans;
    }
}