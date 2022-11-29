package top.chenqwwq.leetcode.contest.weekly._321._1;

/**
 * @author chenqwwq
 * @date 2022/11/27
 **/
public class Solution {
    public int pivotInteger(int n) {
        double sum = 1d * (n + 1) * ((double) n / 2);
        double cur = 0;
        for (int i = 1; i <= n; i++) {
            cur += i;
            if(cur == (sum + i) / 2) return i;
        }
        return -1;
    }
}