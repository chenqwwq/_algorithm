package top.chenqwwq.leetcode.contest.biweek._102._2;

/**
 * @author chenqwwq
 * @date 2023/4/16
 **/
public class Solution {
    public long[] findPrefixScore(int[] nums) {
        final int n = nums.length;
        long[] ans = new long[n];
        int max = nums[0];
        for (int i = 0; i < n; i++) {
            ans[i] += nums[i] + (max = Math.max(max, nums[i])) + (i > 0 ? ans[i - 1] : 0);
        }
        return ans;
    }
}