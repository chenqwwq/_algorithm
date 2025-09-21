package top.chenqwwq.leetcode.contest.biweek._82._2;

import java.util.Arrays;

/**
 * @author chenqwwq
 * @date 2022/7/10
 **/
public class Solution {
    public int latestTimeCatchTheBus(int[] b, int[] p, int c) {
        final int n = b.length, m = p.length;
        Arrays.sort(b);
        Arrays.sort(p);
        int j = 0, cc = 0;
        for (int k : b) {
            for (cc = c; cc > 0 && j < m && p[j] <= k; j++) {
                cc--;
            }
        }
        --j;
        int ans = cc > 0 ? b[n - 1] : p[j];
        while (j >= 0 && ans == p[j--]) {
            ans--;
        }
        return ans;
    }
}