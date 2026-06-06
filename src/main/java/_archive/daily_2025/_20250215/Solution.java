package top.chenqwwq.leetcode.daily._2025._20250215;

/**
 * @author chenqwwq
 * @date 2025/2/15
 **/
public class Solution {
    public int[] findBall(int[][] grid) {
        final int m = grid.length, n = grid[0].length;

        int[] ans = new int[n];
        for(int i = 0;i < n;i++){
            ans[i] = h(grid,0,i);
        }
        return ans;
    }

    public int h(int[][] grid, int i, int j) {
        if (i >= grid.length) return j;
        // 检查能否通过当前通道
        if (grid[i][j] == 1 && j != grid[0].length - 1 && grid[i][j + 1] == 1) {
            return h(grid, i + 1, j + 1);
        }
        if (grid[i][j] == -1 && j != 0 && grid[i][j - 1] == -1) {
            return h(grid, i + 1, j - 1);
        }
        return -1;
    }
}