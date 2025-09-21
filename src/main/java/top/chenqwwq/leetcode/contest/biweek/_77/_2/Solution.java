package top.chenqwwq.leetcode.contest.biweek._77._2;

/**
 * @author chenqwwq
 * @date 2022/4/30
 **/
public class Solution {
    public int minimumAverageDifference(int[] nums) {
        final int n = nums.length;
        long[] pre = new long[n + 1];
        for (int i = 0; i < n; i++) {
            pre[i + 1] = pre[i] + nums[i];
        }
        long min = Long.MAX_VALUE;
        int ans = -1;
        for (int i = 1; i <= n; i++) {
            long val = Math.abs((pre[i] - pre[0]) / i - (n - i == 0 ? 0 : (pre[n] - pre[i]) / (n - i)));
            if (val < min) {
                min = val;
                ans = i - 1;
            }
        }
        return ans;
    }
}