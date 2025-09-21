package top.chenqwwq.leetcode.contest.weekly._300._4;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author chenqwwq
 * @date 2022/7/3
 **/
public class Solution {
    int mod = (int) 1e9 + 7;
    int cx[] = new int[]{0, 0, 1, -1}, cy[] = new int[]{1, -1, 0, 0};

    public int countPaths(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        long ans = 0;
        List<Integer[]> data = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                data.add(new Integer[]{i, j});
            }
        }
//        data.sort((o1, o2) -> Integer.compare(grid[o2[0]0][o2[1]],grid[o1[0]][o1[1]]));
        data.sort(Comparator.comparing(o -> grid[o[0]][o[1]]));
        long[][] dp = new long[n][m];
        for (Integer[] k : data) {
            int i = k[0], j = k[1];
            dp[i][j] = 1;
            for (int q = 0; q < 4; q++) {
                int x = i + cx[q];
                int y = j + cy[q];
                if (x < 0 || y < 0 || x >= n || y >= m || grid[i][j] <= grid[x][y]) {
                    continue;
                }
                dp[i][j] = (dp[x][y] + dp[i][j]) % mod;
            }
            ans = (ans + dp[i][j]) % mod;
        }
        return(int)ans;
    }

}