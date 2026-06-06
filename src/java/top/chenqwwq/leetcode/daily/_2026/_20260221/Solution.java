package top.chenqwwq.leetcode.daily._2026._20260221;

/**
 * @author chenqwwq
 * @date 2026/2/21
 **/
public class Solution {
    public int countPrimeSetBits(int left, int right) {
        int ans = 0;
        for (int i = left; i <= right; i++) {
            int c = Integer.bitCount(i);
            if (c == 2 || c == 3 || c == 5 || c == 7 || c == 11 || c == 13 || c == 17 || c == 19 || c == 23 || c == 29 || c == 31) {
                ans++;
            }
        }
        return ans;
    }
}