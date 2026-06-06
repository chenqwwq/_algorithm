package top.chenqwwq.leetcode.daily._2026._20260321;

/**
 * @author chenqwwq
 * @date 2026/3/21
 **/
public class Solution {

    public int[][] reverseSubmatrix(int[][] grid, int x, int y, int k) {
        final int n = grid.length, m = grid[0].length;
        if (x < 0 || y < 0 || x >= n || y >= m) return grid;
        if (x + k > n || y + k > m) return grid;

        for (int i = 0; i < k >> 1; i++) {
            for (int j = 0; j < k; j++) {
                swap(grid, x + i, y + j, x + k - 1 - i, y + j);
            }
        }
        return grid;
    }

    private void swap(int[][] grid, int x, int y, int xx, int yy) {
        System.out.printf("%d %d %d %d\n", x, y, xx, yy);
        int t = grid[xx][yy];
        grid[xx][yy] = grid[x][y];
        grid[x][y] = t;
    }
}