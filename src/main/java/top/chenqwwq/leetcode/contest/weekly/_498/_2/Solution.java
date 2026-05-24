package top.chenqwwq.leetcode.contest.weekly._498._2;

/**
 * @author chenqwwq
 * @date 2026/4/19
 **/
public class Solution {

    public int firstStableIndex(int[] nums, int k) {
        final int n = nums.length;
        int[] ms = new int[n], xs = new int[n];
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[n - i - 1]);
            ms[n - i - 1] = min;
            xs[i] = max;
        }

        int ans = -1;
        for (int i = 0; i < n; i++) {
            if (xs[i] - ms[i] <= k) {
                return i;
            }
        }
        return ans;
    }
}