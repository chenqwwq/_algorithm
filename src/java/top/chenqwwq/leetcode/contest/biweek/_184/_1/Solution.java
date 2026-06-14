package top.chenqwwq.leetcode.contest.biweek._184._1;

public class Solution {
    public boolean consecutiveSetBits(int n) {
        // int cnt = 0;
        // for (; n > 1; n >>= 1) {
        //     if ((n & 3) == 3) { // 最低两位是 11
        //         cnt++;
        //     }
        // }
        int m = n & (n >> 1); // 所有相邻比特位的 &
        return m > 0 && (m & (m - 1)) == 0; // m 是否恰好有一个 1
    }
}