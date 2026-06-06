package top.chenqwwq.leetcode.daily._2022._20221121;

/**
 * @author chenqwwq
 * @date 2022/11/21
 **/
public class Solution {
    double[][] memo;

    public double soupServings(int n) {
        n = (int) Math.ceil((double) n / 25);
        if (n >= 179) return 1.0;
        memo = new double[n + 1][n + 1];
        return dfs(n, n);
    }

    double dfs(int n, int m) {
        if (n <= 0 && m <= 0) return 0.5;
        else if (n <= 0) return 1;
        else if (m <= 0) return 0;
        if (memo[n][m] == 0) {
            memo[n][m] = 0.25d * (dfs(n - 4, m) + dfs(n - 3, m - 1) + dfs(n - 2, m - 2) + dfs(n - 1, m - 3));
        }
        return memo[n][m];
    }
}