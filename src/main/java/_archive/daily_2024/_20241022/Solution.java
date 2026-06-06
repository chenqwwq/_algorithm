package top.chenqwwq.leetcode.daily._2024._20241022;


class Solution {
    public int countCompleteDayPairs(int[] hours) {
        final int[] hash = new int[24];
        for (int hour : hours) {
            hash[hour % 24]++;
        }
        int ans = 0;
        for (int i = 1; i < 12; i++) {
            ans += hash[i] * hash[24 - i];
        }
        return ans + (hash[0] * (hash[0] - 1) / 2) + (hash[12] * (hash[12] - 1) / 2);
    }
}