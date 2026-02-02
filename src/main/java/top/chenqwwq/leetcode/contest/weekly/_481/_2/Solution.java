package top.chenqwwq.leetcode.contest.weekly._481._2;

/**
 * @author chenqwwq
 * @date 2025/12/22
 **/
public class Solution {
    public long minCost(String s, int[] cost) {
        final int n = s.length();
        long[] ts = new long[26];
        long total = 0;

        for (int i = 0; i < n; i++) {
            ts[s.charAt(i) - 'a'] += cost[i];
            total += cost[i];
        }

        long max = -1;
        for (int i = 0; i < 26; i++) {
            max = Math.max(max, ts[i]);
        }
        return total - max;
    }
}