package top.chenqwwq.leetcode.contest.weekly._482._1;

/**
 * @author chenqwwq
 * @date 2025/12/28
 **/
public class Solution {
    public long maximumScore(int[] nums) {
        final int n = nums.length;
        long[] ps = new long[n], sm = new long[n];
        for (int i = 0; i < n; i++) {
            ps[i] = (i > 0 ? ps[i - 1] : 0) + nums[i];
            sm[n - i - 1] = Math.min((i > 0 ? sm[n - i] : Long.MAX_VALUE), nums[n - i - 1]);
        }

        long ans = Long.MIN_VALUE;
        for (int i = 0; i < n - 1; i++) {
            ans = Math.max(ans, ps[i] - sm[i + 1]);
        }
        return ans;
    }
}