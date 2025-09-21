package top.chenqwwq.leetcode.daily._2023._20230618;

/**
 * @author chenqwwq
 * @date 2023/6/18
 **/
public class Solution {
    int[] cx = {1, -1, 0, 0};
    int[] cy = {0, 0, 1, -1};

    int n, m;
    int[][] grid;

    public int closedIsland(int[][] grid) {
        this.grid = grid;
        this.n = grid.length;
        this.m = grid[0].length;

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) continue;
                if (dfs(i, j)) cnt++;
            }
        }
        return cnt;
    }

    public boolean dfs(int x, int y) {
        if (x < 0 || x >= n || y < 0 || y >= m) return false;
        if (grid[x][y] == 1) return true;
        boolean ans = true;
        if (grid[x][y] == 0) {
            grid[x][y] = 1;
            for (int i = 0; i < 4; i++) {
                ans &= dfs(cx[i] + x, cy[i] + y);
            }
        }
        return ans;
    }
}