package top.chenqwwq.leetcode.lcof._2020._47;

import java.util.Arrays;

/**
 * 剑指 Offer
 * 47. 礼物的最大价值
 * 在一个 m*n 的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于 0）。你可以从棋盘的左上角开始拿格子里的礼物，并每次向右或者向下移动一格、直到到达棋盘的右下角。给定一个棋盘及其上面的礼物的价值，请计算你最多能拿到多少价值的礼物？
 *
 * @author chen
 * @date 2020/6/24 上午11:41
 */
public class Solution {
    public int maxValue(int[][] grid) {
        if (grid.length == 1) {
            return Arrays.stream(grid[0]).sum();
        }
        int[][] dp = new int[grid.length + 1][grid[0].length + 1];

        for (int i = 1; i <= grid.length; i++) {
            for (int j = 1; j <= grid[0].length; j++) {
                dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]) + grid[i - 1][j - 1];
            }
        }

        return dp[grid.length][grid[0].length];

    }
}
