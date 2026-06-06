package top.chenqwwq.leetcode.contest.biweek._127._1;

/**
 * @author chenqwwq
 * @date 2024/3/30
 **/
public class Solution {
    final static int INF = 0x3f3f3f3f;

    public int minimumSubarrayLength(int[] nums, int k) {
        final int n = nums.length;
        int ans = INF;
        for (int i = 0; i < n; i++) {
            int t = 0;
            for (int j = i; j < n; j++) {
                if ((t |= nums[j]) >= k) {
                    ans = Math.min(ans, j - i + 1);
                    break;
                }
            }
        }
        return ans == INF ? -1 : ans;
    }
}