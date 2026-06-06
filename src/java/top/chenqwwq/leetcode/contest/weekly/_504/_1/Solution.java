package top.chenqwwq.leetcode.contest.weekly._504._1;

/**
 * @author chenqwwq
 * @date 2026/5/31
 **/
public class Solution {
    public int digitFrequencyScore(int n) {
        int ans = 0;
        while (n != 0) {
            ans += (n % 10);
            n /= 10;
        }
        return ans;
    }
}