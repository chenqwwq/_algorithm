package top.chenqwwq.leetcode.contest.weekly._429._2;

import java.util.Arrays;

/**
 * @author chenqwwq
 * @date 2024/12/22
 **/
public class Solution {
    public int maxDistinctElements(int[] nums, int k) {
        final int n = nums.length;
        Arrays.sort(nums);
        nums[0] -= k;
        int cnt = 1;
        for (int i = 1; i < n; i++) {
            int t = Math.max(nums[i - 1] + 1, nums[i] - k);
            if(Math.abs(t - nums[i]) > k) nums[i] = nums[i-1];
            else nums[i] = t;
            if(nums[i] != nums[i-1]) cnt++;
        }
        return cnt;
    }
}