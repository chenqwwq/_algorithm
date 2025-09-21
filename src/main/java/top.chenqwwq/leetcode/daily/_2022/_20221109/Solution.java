package top.chenqwwq.leetcode.daily._2022._20221109;

/**
 * @author chenqwwq
 * @date 2022/11/9
 **/
public class Solution {
    int[] cx = new int[]{-1, 0, 1, 0};
    int[] cy = new int[]{0, -1, 0, 1};

    public int orderOfLargestPlusSign(int n, int[][] mines) {
        final int[][] grid = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = 1;
            }
        }
        for (int[] mine : mines) grid[mine[0]][mine[1]] = 0;
        int[][][] sums = new int[4][n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    for (int p = 0; p < 2; p++) {
                        sums[p][i][j] = grid[i][j];
                        int x = i + cx[p], y = j + cy[p];
                        if (x < 0 || x >= n || y < 0 || y >= n || sums[p][x][y] == 0) continue;
                        sums[p][i][j] += sums[p][x][y];
                    }
                }
                if (grid[n - i - 1][n - j - 1] == 1) {
                    for (int p = 2; p < 4; p++) {
                        sums[p][n - i - 1][n - j - 1] = grid[n - i - 1][n - j - 1];
                        int x = n - i - 1 + cx[p], y = n - j - 1 + cy[p];
                        if (x < 0 || x >= n || y < 0 || y >= n || sums[p][x][y] == 0) continue;
                        sums[p][n - i - 1][n - j - 1] += sums[p][x][y];
                    }
                }
            }
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) continue;
                int min = n;
                for (int p = 0; p < 4; p++) {
                    min = Math.min(min, sums[p][i][j]);
                }
                ans = Math.max(ans, min);
            }
        }
        return ans;
    }
}
