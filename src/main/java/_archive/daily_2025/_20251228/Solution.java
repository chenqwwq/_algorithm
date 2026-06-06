package top.chenqwwq.leetcode.daily._2025._20251228;

/**
 * @author chenqwwq
 * @date 2025/12/28
 **/
public class Solution {
    public int countNegatives(int[][] grid) {
        final int n = grid.length, m = grid[0].length;
        int ans = 0;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                if (grid[i][j] < 0) ans++;
                else break;
            }
        }
        return ans;
    }
}