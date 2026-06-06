package top.chenqwwq.leetcode.contest.biweek._179._1;

/**
 * @author chenqwwq
 * @date 2026/3/29
 **/
public class Solution {
    public int minAbsoluteDifference(int[] nums) {
        final int n = nums.length;
        int cur = -1, tag = -1;
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) continue;
            if (tag != -1 && nums[i] != tag) {
                ans = Math.min(ans, Math.abs(i - cur));
            }
            tag = nums[i];
            cur = i;
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}