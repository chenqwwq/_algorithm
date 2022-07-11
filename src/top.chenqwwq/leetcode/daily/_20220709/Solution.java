package top.chenqwwq.leetcode.daily._20220709;

import top.chenqwwq.leetcode.daily._20220711.MagicDictionary;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 沽酒
 * @since 2022/07/11
 */
public class Solution {
    public int lenLongestFibSubseq(int[] arr) {
        final int n = arr.length;
        // 递增序列，不包含重复元素
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(arr[i], i);
        }
        int ans = 0;
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = i - 1; j >= 0 && j < i && arr[i] - arr[j] < arr[j]; --j) {
                // 1 2 3 5 8 13
                final int t = arr[i] - arr[j];
                int p = map.getOrDefault(t, -1);
                if (p == -1) {
                    continue;
                }
                dp[j][i] = Math.max(3, dp[p][j] + 1);
                ans = Math.max(ans,dp[j][i]);
            }
        }
        return ans;
    }
}