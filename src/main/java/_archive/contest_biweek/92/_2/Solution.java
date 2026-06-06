package top.chenqwwq.leetcode.contest.biweek._92._2;

/**
 * @author chenqwwq
 * @date 2022/11/27
 **/
public class Solution {
    public int[][] onesMinusZeros(int[][] grid) {
        final int n = grid.length, m = grid[0].length;
        int[][] diff = new int[n][m];
        int[] rows = new int[n], cols = new int[m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                rows[i] += grid[i][j];
                cols[j] += grid[i][j];
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                diff[i][j] =rows[i] +  cols[j] - (n - rows[i]) - (m - cols[j]);
            }
        }
        return diff;
    }
}