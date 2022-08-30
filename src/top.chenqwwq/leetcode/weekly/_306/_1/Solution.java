package top.chenqwwq.leetcode.weekly._306._1;

/**
 * @author chenqwwq
 * @date 2022/8/15
 **/
public class Solution {
    public int[][] largestLocal(int[][] grid) {
        final int n = grid.length;
        int[][] ret = new int[n - 2][n - 2];
        for (int i = 0; i < n - 2; i++) {
            for (int j = 0; j < n - 2; j++) {
                for (int q = 0; q < 3; q++) {
                    for (int p = 0; p < 3; p++) {
                        ret[i][j] = Math.max(ret[i][j], grid[i + q][j + p]);
                    }
                }
            }
        }
        return ret;
    }
}
