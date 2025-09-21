package top.chenqwwq.leetcode.daily._2025._20250113;

/**
 * @author chenqwwq
 * @date 2025/1/13
 **/
public class Solution {
    public int waysToSplitArray(int[] nums) {
        final int n = nums.length;
        if (n < 2) return 0;
        long sum = 0;
        for (int num : nums) sum += num;

        long cur = 0;
        int ans = 0;
        for (int i = 0; i < n - 1; i++) {
            cur += nums[i];
            if (cur >= sum - cur) ans++;
        }
        return ans;
    }
}