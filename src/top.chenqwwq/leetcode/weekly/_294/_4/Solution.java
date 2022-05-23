package top.chenqwwq.leetcode.weekly._294._4;

/**
 * @author chenqwwq
 * @date 2022/5/22
 **/
public class Solution {
    int mod = (int) 1e9 + 7;

    public int totalStrength(int[] nums) {
        final int n = nums.length;
        int min = nums[0];
        long pre = nums[0], sum = nums[0];
        long ans = (long) min * min % mod;
        for (int i = 1; i < n; i++) {
            min = Math.min(min, nums[i]);
        }
        return (int) ans;
    }
}