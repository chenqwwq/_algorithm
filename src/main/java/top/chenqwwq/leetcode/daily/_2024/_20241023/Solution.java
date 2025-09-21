package top.chenqwwq.leetcode.daily._2024._20241023;

/**
 * @author chenqwwq
 * @date 2024/10/23
 **/
public class Solution {
    public long countCompleteDayPairs(int[] hours) {
        final long[] hash = new long[24];
        for (int hour : hours) {
            hash[hour % 24]++;
        }
        long ans = 0;
        for (int i = 1; i < 12; i++) {
            ans += hash[i] * hash[24 - i];
        }
        return ans + (hash[0] * (hash[0]-1) / 2) + (hash[12] * (hash[12]-1) / 2);
    }
}