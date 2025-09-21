package top.chenqwwq.leetcode.contest.weekly._388._2;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Map;

/**
 * @author chenqwwq
 * @date 2024/3/10
 **/
public class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        final int n = happiness.length;
        Arrays.sort(happiness);
        long ans = 0l;
        for (int i = 0; i < k; i++) {
            ans += Math.max(0, happiness[n-i-1] - i);
        }
        return ans;
    }
}