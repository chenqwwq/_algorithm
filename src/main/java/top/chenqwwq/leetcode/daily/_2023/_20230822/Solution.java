package top.chenqwwq.leetcode.daily._2023._20230822;

/**
 * @author chenqwwq
 * @date 2023/8/22
 **/
public class Solution {
    public int maxDistToClosest(int[] seats) {
        final int n = seats.length;
        int p = -1, ans = 0;
        for (int i = 0; i < n; i++) {
            if (seats[i] != 1) continue;
            ans = Math.max(ans, p == -1 ? i : ((i - p - 2) >> 1) + 1);
            p = i;
        }
        return Math.max(ans, n - p - 1);
    }
}