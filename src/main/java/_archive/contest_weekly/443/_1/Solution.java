package top.chenqwwq.leetcode.contest.weekly._443._1;

/**
 * @author chenqwwq
 * @date 2025/3/30
 **/
public class Solution {
    public int[] minCosts(int[] cost) {
        final int n = cost.length;
        int[] ans = new int[n];
        int cur = cost[0];
        for (int i = 0; i < n; i++) {
            ans[i] = (cur = Math.min(cur, cost[i]));
        }
        return ans;
    }
}