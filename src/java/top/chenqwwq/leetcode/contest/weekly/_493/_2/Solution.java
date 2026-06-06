package top.chenqwwq.leetcode.contest.weekly._493._2;

/**
 * @author chenqwwq
 * @date 2026/3/21
 **/
public class Solution {
    public long countCommas(long n) {
        if (n < 1000) return 0;
        long ans = 0;
        // 千分位上 1000 - 999999
        // 十万位上 1000000 - 999999999
        long base = 1000, top = 999999;
        int cnt = 1;
        while (n >= top) {
            ans += (top - base + 1) * cnt;
            top = top * 1000 + 999;
            base *= 1000;
            cnt++;
        }

        return ans + (n - base + 1) * cnt;
    }
}