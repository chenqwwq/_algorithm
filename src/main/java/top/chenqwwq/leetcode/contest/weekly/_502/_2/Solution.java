package top.chenqwwq.leetcode.contest.weekly._502._2;

/**
 * @author chenqwwq
 * @date 2026/5/17
 **/
public class Solution {
    public int countKthRoots(int l, int r, int k) {
        if (k == 1) return r - l + 1;
        int ans = 1;
        for (int i = 0; ; i++) {
            long t = 1;
            for (int j = 0; j < k; j++) t *= i;
            if (t > r) break;
            if (t >= l) ans++;
        }
        return ans;
    }

    public static void main(String[] args) {
        new Solution().countKthRoots(0, 26, 2);
    }
}