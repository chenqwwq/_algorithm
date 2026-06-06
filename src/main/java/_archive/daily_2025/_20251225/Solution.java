package top.chenqwwq.leetcode.daily._2025._20251225;

import java.util.Arrays;

/**
 * @author chenqwwq
 * @date 2025/12/27
 **/
public class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        final int n = happiness.length;
        Arrays.sort(happiness);
        long ans = 0;
        for (int i = n - 1; i >= 0 && k > 0; i--, k--) {
            ans += Math.max(0L, happiness[i] - (n - i - 1));
        }

        return ans;
    }
}