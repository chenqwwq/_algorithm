package top.chenqwwq.leetcode.daily._20221120;

/**
 * @author chenqwwq
 * @date 2022/11/20
 **/
public class Solution {
    public double champagneTower(int poured, int row, int idx) {
        double[][] dp = new double[row + 1][row + 1];
        dp[0][0] = poured;
        for (int i = 0; i <= row; i++) {
            for (int j = 0; j <= i; j++) {
                if (dp[i][j] == 0) continue;
                dp[i + 1][j] += ((dp[i][j] - 1) / 2);
                dp[i + 1][j + 1] += ((dp[i][j] - 1) / 2);
            }
        }
        return Math.min(dp[row][idx],1);
    }
}