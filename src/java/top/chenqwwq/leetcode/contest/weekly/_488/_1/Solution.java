package top.chenqwwq.leetcode.contest.weekly._488._1;

/**
 * @author chenqwwq
 * @date 2026/2/9
 **/
public class Solution {
    public int dominantIndices(int[] nums) {
        final int n = nums.length;
        long total = 0L;
        for (int num : nums) total += num;

        long cur = 0;
        int ans = 0;
        for (int i = 0; i < n - 1; i++) {
            if (nums[i] > (total - cur) / (n - i)) ans++;
        }
        return ans;
    }
}