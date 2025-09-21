package top.chenqwwq.leetcode.contest.weekly._387._2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chenqwwq
 * @date 2024/3/3
 **/
public class Solution {
    public int countSubmatrices(int[][] grid, int k) {
        final int n = grid.length, m = grid[0].length;
        // 二维前缀和
        int[][] ss = new int[n][m];
        ss[0][0] = grid[0][0];
        int ans = grid[0][0] <= k ? 1 : 0;
        for (int i = 1; i < m; i++) {
            if ((ss[0][i] = ss[0][i - 1] + grid[0][i]) <= k) {
                ans++;
            }
        }
        for (int i = 1; i < n; i++) {
            if ((ss[i][0] = ss[i - 1][0] + grid[i][0]) <= k) {
                ans++;
            }
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                ss[i][j] = grid[i][j] + ss[i - 1][j] + ss[i][j - 1] - ss[i - 1][j - 1];
                if (ss[i][j] <= k) ans++;
            }
        }
        return ans;
    }
}