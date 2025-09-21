package top.chenqwwq.leetcode.contest.weekly._430._1;

/**
 * @author chenqwwq
 * @date 2024/12/29
 **/
public class Solution {
    public int minimumOperations(int[][] grid) {
        final int n = grid.length, m = grid[0].length;
        int ans = 0;
        for (int i = 0; i < m; i++) {
            int cur = grid[0][i];
            for (int j = 1; j < n; j++) {
                if (grid[j][i] <= cur) {
                    ans += ++cur - grid[j][i];
                } else {
                    cur = grid[j][i];
                }
            }
        }
        return ans;
    }
}