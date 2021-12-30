package top.chenqwwq.leetcode.lcof2._94;

/**
 * @author chenbingxin
 * @date 2021/12/29
 **/
public class Solution1 {
    public int minCut(String s) {
        final int n = s.length();
        if (n < 2) {
            return 0;
        }
        final boolean[][] stat = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            stat[i][i] = true;
        }

        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                stat[i][j] = s.charAt(i) == s.charAt(j) && (j - i == 1 || stat[i+1][j-1]);
            }
        }

        final int[] dp = new int[n];
        for (int i = 1; i < n; i++) {
            if (stat[0][i]) {
                dp[i] = 0;
            } else {
                dp[i] = dp[i - 1] + 1;
                for (int j = 1; j < i; j++) {
                    if (s.charAt(j) == s.charAt(i) && stat[j][i]) {
                        dp[i] = Math.min(dp[i], dp[j-1] + 1);
                    }
                }
            }
        }
        return dp[n-1];
    }
}
