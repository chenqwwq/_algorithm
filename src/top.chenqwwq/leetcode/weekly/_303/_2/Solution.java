package top.chenqwwq.leetcode.weekly._303._2;

/**
 * @author chenqwwq
 * @date 2022/7/24
 **/
public class Solution {
    public int equalPairs(int[][] grid) {
        final int n = grid.length;
        int cnt = 0;
        // 水平
        for (int i = 0; i < n; i++) {
            // 竖直
            inner:
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (grid[i][k] != grid[k][j]) {
                        continue inner;
                    }
                }
                cnt++;
            }
        }
        return cnt;
    }
}