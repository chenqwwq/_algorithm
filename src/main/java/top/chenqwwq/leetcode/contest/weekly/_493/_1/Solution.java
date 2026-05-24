package top.chenqwwq.leetcode.contest.weekly._493._1;

/**
 * @author chenqwwq
 * @date 2026/3/21
 **/
public class Solution {
    public int countCommas(int n) {
        int cnt = 0;
        for (int i = 1000; i <= n; i++) {
            if (i <= 9999) cnt++;
            else if (i <= 999999) cnt += 2;
            else cnt += 3;
        }
        return cnt;
    }
}