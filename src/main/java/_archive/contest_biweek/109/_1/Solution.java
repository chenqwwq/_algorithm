package top.chenqwwq.leetcode.contest.biweek._109._1;

import java.util.Arrays;

/**
 * @author chenqwwq
 * @date 2023/7/22
 **/
public class Solution {
    public boolean isGood(int[] nums) {
        final int n = nums.length;
        if (n == 1) return false;
        Arrays.sort(nums);
        for (int i = 0; i < n - 1; i++) {
            if (nums[i] != i + 1) return false;
        }
        return nums[n - 1] == n - 1;
    }
}