package top.chenqwwq.leetcode.archive.lcof2._93;

/**
 * @author chenbingxin
 * @date 2021/12/23
 **/
public class Solution {
    public int lenLongestFibSubseq(int[] arr) {
        final int n = arr.length;
        if (n < 3) {
            return 0;
        }
        int ans = 0;
        int[][] dp = new int[n][n];
        for (int i = 2; i < n; i++) {
            int l = 0, r = i - 1;
            while (l < r) {
                final int sum = arr[l] + arr[r];
                if (sum == arr[i]) {
                    dp[r][i] = Math.max(dp[l][r] == 0 ? 3 : dp[l][r] + 1, dp[r][i]);
                    ans = Math.max(dp[r][i], ans);
                    l++;
                    r--;
                } else if (sum < arr[i]) {
                    l++;
                } else {
                    r--;
                }
            }
        }
        return ans;
    }
}