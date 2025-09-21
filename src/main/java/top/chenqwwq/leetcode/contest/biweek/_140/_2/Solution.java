package top.chenqwwq.leetcode.contest.biweek._140._2;

import java.util.Arrays;

/**
 * @author chenqwwq
 * @date 2024/10/2
 **/
public class Solution {
    public long maximumTotalSum(int[] maximumHeight) {
        final int n = maximumHeight.length;
        Arrays.sort(maximumHeight);
        long ans = 0;
        int pre = maximumHeight[n - 1];
        for (int i = n - 1; i >= 0; i--) {
            if (pre <= 0) return -1;
            final int cur = Math.min(maximumHeight[i], pre);
            pre = cur - 1;
            ans += cur;
        }
        return ans;
    }
}